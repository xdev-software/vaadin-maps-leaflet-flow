package software.xdev.vaadin.maps.leaflet.layer.ui;

import java.io.Serializable;

import software.xdev.vaadin.maps.leaflet.base.LComponent;
import software.xdev.vaadin.maps.leaflet.base.has.LHasBringTo;
import software.xdev.vaadin.maps.leaflet.basictypes.LLatLng;
import software.xdev.vaadin.maps.leaflet.layer.LInteractiveLayer;
import software.xdev.vaadin.maps.leaflet.layer.LLayer;
import software.xdev.vaadin.maps.leaflet.map.LMap;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#divoverlay">Leaflet Docs</a>
 */
public abstract class LDivOverlay<S extends LDivOverlay<S>> extends LInteractiveLayer<S> implements LHasBringTo<S>
{
	protected LDivOverlay(
		final LComponentManagementRegistry compReg,
		final String jsConstructorCallExpression,
		final Serializable... parameters)
	{
		super(compReg, jsConstructorCallExpression, parameters);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#divoverlay-openon">Leaflet Docs</a>
	 */
	public void openOn(final LMap map)
	{
		this.invokeSelf(".openOn(" + map.clientComponentJsAccessor() + ")");
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#divoverlay-close">Leaflet Docs</a>
	 */
	public void close()
	{
		this.invokeSelf(".close()");
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#divoverlay-toggle">Leaflet Docs</a>
	 */
	public void toggle(final LLayer<?> layer)
	{
		this.invokeSelf(".toggle(" + (layer != null ? layer.clientComponentJsAccessor() : "") + ")");
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#divoverlay-toggle">Leaflet Docs</a>
	 */
	public void toggle()
	{
		this.toggle(null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#divoverlay-setlatlng">Leaflet Docs</a>
	 */
	public void setLatLng(final LLatLng latLng)
	{
		this.invokeSelf(".setLatLng(" + latLng.clientComponentJsAccessor() + ")");
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#divoverlay-setcontent">Leaflet Docs</a>
	 */
	public void setContent(final String content)
	{
		this.invokeSelf(".setContent($0)", content);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#divoverlay-setcontent">Leaflet Docs</a>
	 */
	public void setContent(final LComponent<?> content)
	{
		this.invokeSelf(".setContent($0)", content.clientComponentJsAccessor());
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#divoverlay-update">Leaflet Docs</a>
	 */
	public void update()
	{
		this.invokeSelf(".update()");
	}
}
