package software.xdev.vaadin.maps.leaflet.registry;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.page.PendingJavaScriptResult;

import software.xdev.vaadin.maps.leaflet.base.LComponent;
import software.xdev.vaadin.maps.leaflet.base.LComponentOptions;
import software.xdev.vaadin.maps.leaflet.base.RawString;


// TODO Interface
public class LComponentManagementRegistry extends Composite<Div> implements AutoCloseable
{
	protected static final AtomicLong NEXT_ID = new AtomicLong(1);
	
	protected Map<LComponent, Integer> componentIndexMap = new WeakHashMap<>();
	protected AtomicInteger nextComponentId = new AtomicInteger(1);
	protected AtomicInteger clientMapSize = new AtomicInteger(0);
	
	protected final ObjectWriter optionsWriter;
	
	public static ObjectWriter getDefaultWriterForOptions()
	{
		return new ObjectMapper()
			.setDefaultPropertyInclusion(JsonInclude.Include.NON_EMPTY)
			.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
			.setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE)
			.setVisibility(PropertyAccessor.IS_GETTER, JsonAutoDetect.Visibility.NONE)
			.setVisibility(PropertyAccessor.SETTER, JsonAutoDetect.Visibility.NONE)
			.setVisibility(PropertyAccessor.CREATOR, JsonAutoDetect.Visibility.NONE)
			.registerModule(new SimpleModule()
				.addSerializer(RawString.class, new RawSerializer<>(RawString::getValue))
				.addSerializer(LComponent.class, new RawSerializer<>(LComponent::clientComponentJsAccessor)))
			.writer();
	}
	
	public static class RawSerializer<V> extends StdSerializer<V>
	{
		private final Function<V, String> rawValueExtractor;
		
		public RawSerializer(final Function<V, String> rawValueExtractor)
		{
			super((Class<V>)null);
			this.rawValueExtractor = Objects.requireNonNull(rawValueExtractor);
		}
		
		@Override
		public void serialize(final V value, final JsonGenerator gen, final SerializerProvider provider)
			throws IOException
		{
			gen.writeRawValue(this.rawValueExtractor.apply(value));
		}
	}
	
	public LComponentManagementRegistry(final HasComponents parent)
	{
		this(parent, getDefaultWriterForOptions());
	}
	
	public LComponentManagementRegistry(final HasComponents parent, final ObjectWriter optionsWriter)
	{
		this.optionsWriter = Objects.requireNonNull(optionsWriter);
		
		this.setId("lComponentRegistry" + NEXT_ID.getAndIncrement());
		this.getElement().executeJs(this.clientComponents() + " = new Map();");
		
		// Make invisible but still be inside dom
		this.getContent().getElement().setAttribute("hidden", true);
		// Attach to parent
		parent.add(this);
	}
	
	public String writeOptionsOptionalParameter(final LComponentOptions<?> options)
	{
		return options == null ? "" : (", " + this.writeOptionsOrEmptyObject(options));
	}
	
	public String writeOptions(final LComponentOptions<?> options)
	{
		return this.writeOptions(options, "");
	}
	
	public String writeOptionsOrEmptyObject(final LComponentOptions<?> options)
	{
		return this.writeOptions(options, "{}");
	}
	
	protected String writeOptions(final Object options, final String nullDefault)
	{
		if(options == null)
		{
			return nullDefault;
		}
		try
		{
			return this.optionsWriter.writeValueAsString(options);
		}
		catch(final JsonProcessingException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	protected String clientComponents()
	{
		return "document.getElementById('" + this.getId().orElseThrow() + "').lComponents";
	}
	
	public <C extends LComponent<C>> C add(
		final C component,
		final String jsConstructorCallExpression,
		final Serializable... parameters)
	{
		final int currentId = this.nextComponentId.getAndIncrement();
		this.getElement()
			.executeJs(this.clientComponents() + ".set(" + currentId + ", " + jsConstructorCallExpression + ");", parameters);
		this.clientMapSize.incrementAndGet();
		this.componentIndexMap.put(component, currentId);
		
		return component;
	}
	
	public String clientComponentJsAccessor(final LComponent<?> component)
	{
		return Optional.ofNullable(this.componentIndexMap.get(component))
			.map(id -> this.clientComponents() + ".get(" + id + ")")
			.orElse(null);
	}
	
	public PendingJavaScriptResult execJs(final String js, final Serializable... params)
	{
		return this.getElement().executeJs(js, params);
	}
	
	public <C extends LComponent<C>> void remove(final C component)
	{
		this.remove(component, true);
	}
	
	public <C extends LComponent<C>> void remove(final C component, final boolean freeUpClientWhenNoMatch)
	{
		final Integer removedId = this.componentIndexMap.remove(component);
		if(removedId != null)
		{
			this.getElement().executeJs(this.clientComponents() + ".delete(" + removedId + ");");
			this.clientMapSize.decrementAndGet();
			return;
		}
		
		if(freeUpClientWhenNoMatch)
		{
			// Object was maybe already disposed by GC but client may still have it
			this.freeUpClient();
		}
	}
	
	public void freeUpClient()
	{
		if(this.clientMapSize.get() != this.componentIndexMap.size())
		{
			final Collection<Integer> ids = this.componentIndexMap.values();
			this.getElement().executeJs("""
				let activeIds = [%s];
				Array.from(%s.keys()).filter(i => !activeIds.includes(i)).forEach(i => components.delete(i));
				""".formatted(
				ids.stream().map(String::valueOf).collect(Collectors.joining(",")),
				this.clientComponents()));
			this.clientMapSize.set(ids.size());
		}
	}
	
	public void clear()
	{
		this.getElement().executeJs(this.clientComponents() + ".clear();");
		this.clientMapSize.set(0);
	}
	
	@Override
	public void close()
	{
		this.clear();
	}
}
