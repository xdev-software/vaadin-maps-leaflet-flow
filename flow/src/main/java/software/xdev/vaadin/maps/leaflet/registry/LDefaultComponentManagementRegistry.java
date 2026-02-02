/*
 * Copyright © 2019 XDEV Software (https://xdev.software)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package software.xdev.vaadin.maps.leaflet.registry;

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
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.page.PendingJavaScriptResult;

import software.xdev.vaadin.maps.leaflet.base.LComponent;
import software.xdev.vaadin.maps.leaflet.base.LComponentOptions;
import software.xdev.vaadin.maps.leaflet.base.RawString;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.ObjectWriter;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.module.SimpleModule;
import tools.jackson.databind.ser.std.StdSerializer;


@SuppressWarnings("java:S1948") // DO NOT SERIALIZE UI CLASSES!
public class LDefaultComponentManagementRegistry extends Composite<Div> implements LComponentManagementRegistry
{
	protected static final AtomicLong NEXT_ID = new AtomicLong(1);
	
	protected Map<LComponent<?>, Integer> componentIndices = new WeakHashMap<>();
	protected AtomicInteger nextComponentId = new AtomicInteger(1);
	protected AtomicInteger clientMapSize = new AtomicInteger(0);
	
	protected final ObjectWriter optionsWriter;
	
	public LDefaultComponentManagementRegistry(final HasComponents parent)
	{
		this(parent, getDefaultWriterForOptions());
	}
	
	public LDefaultComponentManagementRegistry(final HasComponents parent, final ObjectWriter optionsWriter)
	{
		this.optionsWriter = Objects.requireNonNull(optionsWriter);
		
		this.setId("lComponentRegistry" + NEXT_ID.getAndIncrement());
		this.getElement().executeJs(this.clientComponents() + " = new Map();");
		
		// Make invisible but still be inside dom
		this.getContent().getElement().setAttribute("hidden", true);
		// Attach to parent
		parent.add(this);
	}
	
	@Override
	public String writeOptionsOptionalNextParameter(final LComponentOptions<?> options)
	{
		return options == null ? "" : (", " + this.writeOptionsOrEmptyObject(options));
	}
	
	@Override
	public String writeOptions(final LComponentOptions<?> options)
	{
		return this.writeOptions(options, "");
	}
	
	@Override
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
		catch(final JacksonException e)
		{
			throw new IllegalStateException("Failed to write options", e);
		}
	}
	
	protected String clientComponents()
	{
		return "document.getElementById('" + this.getId().orElseThrow() + "').lComponents";
	}
	
	@Override
	public <C extends LComponent<C>> C add(
		final C component,
		final String jsConstructorCallExpression,
		final Object... parameters)
	{
		final int currentId = this.nextComponentId.getAndIncrement();
		this.getElement().executeJs(
			this.clientComponents() + ".set(" + currentId + ", " + jsConstructorCallExpression + ");",
			parameters);
		this.clientMapSize.incrementAndGet();
		this.componentIndices.put(component, currentId);
		
		return component;
	}
	
	@Override
	public String clientComponentJsAccessor(final LComponent<?> component)
	{
		return Optional.ofNullable(this.componentIndices.get(component))
			.map(id -> this.clientComponents() + ".get(" + id + ")")
			.orElse(null);
	}
	
	@Override
	public PendingJavaScriptResult execJs(final String js, final Object... params)
	{
		return this.getElement().executeJs(js, params);
	}
	
	@Override
	public <C extends LComponent<C>> void remove(final C component, final boolean freeUpClientWhenNoMatch)
	{
		final Integer removedId = this.componentIndices.remove(component);
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
	
	@Override
	public void freeUpClient()
	{
		if(this.clientMapSize.get() != this.componentIndices.size())
		{
			final Collection<Integer> ids = this.componentIndices.values();
			this.getElement().executeJs("""
				let activeIds = [%s];
				let components = %s;
				Array.from(components.keys()).filter(i => !activeIds.includes(i)).forEach(i => components.delete(i));
				""".formatted(
				ids.stream().map(String::valueOf).collect(Collectors.joining(",")),
				this.clientComponents()));
			this.clientMapSize.set(ids.size());
		}
	}
	
	@Override
	public void clearAll()
	{
		this.getElement().executeJs(this.clientComponents() + ".clear();");
		this.clientMapSize.set(0);
	}
	
	protected static ObjectWriter getDefaultWriterForOptions()
	{
		return JsonMapper.builder()
			.changeDefaultPropertyInclusion(v -> v
				.withValueInclusion(JsonInclude.Include.NON_EMPTY))
			.changeDefaultVisibility(vc -> vc
				.withFieldVisibility(JsonAutoDetect.Visibility.ANY)
				.withGetterVisibility(JsonAutoDetect.Visibility.NONE)
				.withIsGetterVisibility(JsonAutoDetect.Visibility.NONE)
				.withSetterVisibility(JsonAutoDetect.Visibility.NONE)
				.withCreatorVisibility(JsonAutoDetect.Visibility.NONE))
			.addModule(new SimpleModule()
				.addSerializer(RawString.class, new RawSerializer<>(RawString::getValue))
				.addSerializer(LComponent.class, new RawSerializer<>(LComponent::clientComponentJsAccessor)))
			.build()
			.writer();
	}
	
	protected static class RawSerializer<V> extends StdSerializer<V>
	{
		private final Function<V, String> rawValueExtractor;
		
		public RawSerializer(final Function<V, String> rawValueExtractor)
		{
			super((Class<V>)null);
			this.rawValueExtractor = Objects.requireNonNull(rawValueExtractor);
		}
		
		@Override
		public void serialize(final V value, final JsonGenerator gen, final SerializationContext ctx)
		{
			gen.writeRawValue(this.rawValueExtractor.apply(value));
		}
	}
}
