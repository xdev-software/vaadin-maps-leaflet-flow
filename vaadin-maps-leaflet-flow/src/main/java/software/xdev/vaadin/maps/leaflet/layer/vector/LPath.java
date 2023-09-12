package software.xdev.vaadin.maps.leaflet.layer.vector;

import java.io.Serializable;

import software.xdev.vaadin.maps.leaflet.base.has.LHasBringTo;
import software.xdev.vaadin.maps.leaflet.base.has.LHasRedraw;
import software.xdev.vaadin.maps.leaflet.layer.LInteractiveLayer;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#path">Leaflet docs</a>
 */
public abstract class LPath<S extends LPath<S>> extends LInteractiveLayer<S>
	implements LHasBringTo<S>, LHasRedraw<S>
{
	protected LPath(
		final LComponentManagementRegistry compReg,
		final String jsConstructorCallExpression,
		final Serializable... parameters)
	{
		super(compReg, jsConstructorCallExpression, parameters);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#polyline-setstyle">Leaflet docs</a>
	 */
	@SuppressWarnings("resource")
	public S setStyle(final LPathOptions<?> options)
	{
		this.invokeSelf(".setStyle(" + this.componentRegistry().writeOptionsOrEmptyObject(options) + ")");
		return this.self();
	}
}
