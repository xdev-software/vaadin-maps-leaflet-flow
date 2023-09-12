package software.xdev.vaadin.maps.leaflet.layer.vector;

import java.io.Serializable;

import software.xdev.vaadin.maps.leaflet.base.has.LHasSetLatLng;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


public abstract class LAbstractCircle<S extends LAbstractCircle<S>> extends LPath<S>
	implements LHasSetLatLng<S>
{
	protected LAbstractCircle(
		final LComponentManagementRegistry compReg,
		final String jsConstructorCallExpression,
		final Serializable... parameters)
	{
		super(compReg, jsConstructorCallExpression, parameters);
	}
}
