package software.xdev.vaadin.maps.leaflet.layer.vector;

import java.io.Serializable;

import software.xdev.vaadin.maps.leaflet.layer.LLayer;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#renderer">Leaflet docs</a>
 */
public abstract class LRenderer<S extends LRenderer<S>> extends LLayer<S>
{
	protected LRenderer(
		final LComponentManagementRegistry compReg,
		final String jsConstructorCallExpression,
		final Serializable... parameters)
	{
		super(compReg, jsConstructorCallExpression, parameters);
	}
}
