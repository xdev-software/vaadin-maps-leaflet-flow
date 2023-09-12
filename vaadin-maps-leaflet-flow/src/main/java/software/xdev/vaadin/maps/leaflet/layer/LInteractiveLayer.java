package software.xdev.vaadin.maps.leaflet.layer;

import java.io.Serializable;

import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


public abstract class LInteractiveLayer<S extends LInteractiveLayer<S>> extends LLayer<S>
{
	protected LInteractiveLayer(
		final LComponentManagementRegistry compReg,
		final String jsConstructorCallExpression,
		final Serializable... parameters)
	{
		super(compReg, jsConstructorCallExpression, parameters);
	}
}
