package software.xdev.vaadin.maps.leaflet.base;

import java.io.Serializable;

import com.vaadin.flow.component.page.PendingJavaScriptResult;

import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


public interface LComponent<S extends LComponent<S>>
{
	LComponentManagementRegistry componentRegistry();
	
	default String clientComponentJsAccessor()
	{
		return this.componentRegistry().clientComponentJsAccessor(this);
	}
	
	default PendingJavaScriptResult invokeSelf(final String payload, final Serializable... params)
	{
		return this.componentRegistry().execJs(this.clientComponentJsAccessor() + payload, params);
	}
	
	@SuppressWarnings("unchecked")
	default S self()
	{
		return (S)this;
	}
}
