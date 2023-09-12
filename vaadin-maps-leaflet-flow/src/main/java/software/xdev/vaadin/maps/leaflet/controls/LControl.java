package software.xdev.vaadin.maps.leaflet.controls;

import java.io.Serializable;

import software.xdev.vaadin.maps.leaflet.base.LBaseComponent;
import software.xdev.vaadin.maps.leaflet.map.LMap;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#control">Leaflet Docs</a>
 */
public abstract class LControl<S extends LControl<S>> extends LBaseComponent<S>
{
	protected LControl(
		final LComponentManagementRegistry compReg,
		final String jsConstructorCallExpression,
		final Serializable... parameters)
	{
		super(compReg, jsConstructorCallExpression, parameters);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#control-setposition">Leaflet Docs</a>
	 */
	public S setPosition(final String position)
	{
		this.invokeSelf(".setPosition($0)", position);
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#control-addto">Leaflet Docs</a>
	 */
	public S addTo(final LMap map)
	{
		this.invokeSelf(".addTo(" + map.clientComponentJsAccessor() + ")");
		return this.self();
	}
}
