package software.xdev.vaadin.maps.leaflet.base;

import java.io.Serializable;
import java.util.Objects;

import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


public abstract class LBaseComponent<S extends LComponent<S>> implements LComponent<S>
{
	private final LComponentManagementRegistry componentRegistry;
	
	protected LBaseComponent(
		final LComponentManagementRegistry compReg,
		final String jsConstructorCallExpression,
		final Serializable... parameters)
	{
		this.componentRegistry = Objects.requireNonNull(compReg);
		this.componentRegistry.add(this.self(), jsConstructorCallExpression, parameters);
	}
	
	@Override
	public LComponentManagementRegistry componentRegistry()
	{
		return this.componentRegistry;
	}
	
	@Override
	public String clientComponentJsAccessor()
	{
		return this.componentRegistry.clientComponentJsAccessor(this);
	}
}
