package software.xdev.vaadin.maps.leaflet.layer;

import java.io.Serializable;

import software.xdev.vaadin.maps.leaflet.base.LBaseComponent;
import software.xdev.vaadin.maps.leaflet.base.LComponent;
import software.xdev.vaadin.maps.leaflet.base.LEvented;
import software.xdev.vaadin.maps.leaflet.basictypes.LLatLng;
import software.xdev.vaadin.maps.leaflet.layer.ui.LPopup;
import software.xdev.vaadin.maps.leaflet.layer.ui.LPopupOptions;
import software.xdev.vaadin.maps.leaflet.layer.ui.LTooltip;
import software.xdev.vaadin.maps.leaflet.layer.ui.LTooltipOptions;
import software.xdev.vaadin.maps.leaflet.map.LMap;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#layer">Leaflet Docs</a>
 */
public abstract class LLayer<S extends LLayer<S>> extends LBaseComponent<S> implements LEvented<S>
{
	protected LLayer(
		final LComponentManagementRegistry compReg,
		final String jsConstructorCallExpression,
		final Serializable... parameters)
	{
		super(compReg, jsConstructorCallExpression, parameters);
	}
	
	// region Add/Remove
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-addto">Leaflet Docs</a>
	 */
	protected S addTo(final LComponent<?> lComponent)
	{
		this.invokeSelf(".addTo(" + lComponent.clientComponentJsAccessor() + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-addto">Leaflet Docs</a>
	 */
	public S addTo(final LMap map)
	{
		return this.addTo((LComponent<?>)map);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-addto">Leaflet Docs</a>
	 */
	public S addTo(final LLayerGroup layerGroup)
	{
		return this.addTo((LComponent<?>)layerGroup);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-remove">Leaflet Docs</a>
	 */
	public S remove()
	{
		this.invokeSelf(".remove()");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-removefrom">Leaflet Docs</a>
	 */
	protected S removeFrom(final LComponent<?> lComponent)
	{
		this.invokeSelf(".removeFrom(" + lComponent.clientComponentJsAccessor() + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-removefrom">Leaflet Docs</a>
	 */
	public S removeFrom(final LMap map)
	{
		return this.removeFrom((LComponent<?>)map);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-removefrom">Leaflet Docs</a>
	 */
	public S removeFrom(final LLayerGroup layerGroup)
	{
		return this.removeFrom((LComponent<?>)layerGroup);
	}
	
	// endregion
	// region Popup
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-bindpopup">Leaflet Docs</a>
	 */
	public S bindPopup(final String content, final LPopupOptions options)
	{
		this.invokeSelf(".bindPopup($0, " + this.componentRegistry().writeOptionsOptionalParameter(options) + ")", content);
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-bindpopup">Leaflet Docs</a>
	 */
	public S bindPopup(final String content)
	{
		return this.bindPopup(content, null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-bindpopup">Leaflet Docs</a>
	 */
	public S bindPopup(final LPopup popup)
	{
		this.invokeSelf(".bindPopup(" + popup.clientComponentJsAccessor() + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-unbindpopup">Leaflet Docs</a>
	 */
	public S unbindPopup()
	{
		this.invokeSelf(".unbindPopup()");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-togglepopup">Leaflet Docs</a>
	 */
	public S togglePopup()
	{
		this.invokeSelf(".togglePopup()");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-openpopup">Leaflet Docs</a>
	 */
	public S openPopup(final LLatLng latLng)
	{
		this.invokeSelf(".openPopup(" + (latLng != null ? latLng.clientComponentJsAccessor() : "") + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-openpopup">Leaflet Docs</a>
	 */
	public S openPopup()
	{
		return this.openPopup(null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-closepopup">Leaflet Docs</a>
	 */
	public S closePopup()
	{
		this.invokeSelf(".closePopup()");
		return this.self();
	}
	
	// endregion
	// region Tooltip
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-bindtooltip">Leaflet Docs</a>
	 */
	public S bindTooltip(final String content, final LTooltipOptions options)
	{
		this.invokeSelf(".bindTooltip($0, " + this.componentRegistry().writeOptionsOptionalParameter(options) + ")", content);
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-bindtooltip">Leaflet Docs</a>
	 */
	public S bindTooltip(final String content)
	{
		return this.bindTooltip(content, null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-bindtooltip">Leaflet Docs</a>
	 */
	public S bindTooltip(final LTooltip tooltip)
	{
		this.invokeSelf(".bindTooltip(" + tooltip.clientComponentJsAccessor() + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-unbindtooltip">Leaflet Docs</a>
	 */
	public S unbindTooltip()
	{
		this.invokeSelf(".unbindTooltip()");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-toggletooltip">Leaflet Docs</a>
	 */
	public S toggleTooltip()
	{
		this.invokeSelf(".toggleTooltip()");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-opentooltip">Leaflet Docs</a>
	 */
	public S openTooltip(final LLatLng latLng)
	{
		this.invokeSelf(".openTooltip(" + (latLng != null ? latLng.clientComponentJsAccessor() : "") + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-opentooltip">Leaflet Docs</a>
	 */
	public S openTooltip()
	{
		return this.openPopup(null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-closetooltip">Leaflet Docs</a>
	 */
	public S closeTooltip()
	{
		this.invokeSelf(".closeTooltip()");
		return this.self();
	}
	
	// endregion
}
