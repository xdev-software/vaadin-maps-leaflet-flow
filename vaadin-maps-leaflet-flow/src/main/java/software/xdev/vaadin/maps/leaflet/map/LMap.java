package software.xdev.vaadin.maps.leaflet.map;

import java.util.UUID;

import com.vaadin.flow.component.html.Div;

import software.xdev.vaadin.maps.leaflet.base.LBaseComponent;
import software.xdev.vaadin.maps.leaflet.base.LEvented;
import software.xdev.vaadin.maps.leaflet.basictypes.LLatLng;
import software.xdev.vaadin.maps.leaflet.controls.LControl;
import software.xdev.vaadin.maps.leaflet.layer.LLayer;
import software.xdev.vaadin.maps.leaflet.layer.ui.LPopup;
import software.xdev.vaadin.maps.leaflet.layer.ui.LTooltip;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#map">Leaflet Docs</a>
 */
public class LMap extends LBaseComponent<LMap> implements LEvented<LMap>
{
	// region Init
	public LMap(
		final LComponentManagementRegistry compReg,
		final String id)
	{
		this(compReg, id, null);
	}
	
	public LMap(
		final LComponentManagementRegistry compReg,
		final String id,
		final LMapOptions options)
	{
		super(compReg, "L.map($0" + compReg.writeOptionsOptionalParameter(options) + ")", id);
		// https://stackoverflow.com/q/53879753
		this.fixInvalidSizeAfterCreation();
	}
	
	public LMap(
		final LComponentManagementRegistry compReg,
		final Div bindDiv)
	{
		this(compReg, bindDiv, null);
	}
	
	public LMap(
		final LComponentManagementRegistry compReg,
		final Div bindDiv,
		final LMapOptions options)
	{
		this(compReg, bindDiv, options, true);
	}
	
	public LMap(
		final LComponentManagementRegistry compReg,
		final Div bindDiv,
		final boolean fixDivZIndex)
	{
		this(compReg, bindDiv, null, fixDivZIndex);
	}
	
	public LMap(
		final LComponentManagementRegistry compReg,
		final Div bindDiv,
		final LMapOptions options,
		final boolean fixDivZIndex)
	{
		this(
			compReg,
			bindDiv.getId().orElseGet(() -> {
				final String dynamicId = "map-dynId-" + UUID.randomUUID();
				bindDiv.setId(dynamicId);
				return dynamicId;
			}),
			options);
		if(fixDivZIndex)
		{
			fixZIndex(bindDiv);
		}
	}
	
	/**
	 * This fixes situations where the leafletmap overlays components like Dialogs
	 */
	public static void fixZIndex(final Div div)
	{
		div.getStyle().set("z-index", "1");
	}
	
	@SuppressWarnings("resource")
	protected void fixInvalidSizeAfterCreation()
	{
		this.componentRegistry().execJs("let tempMap = " + this.clientComponentJsAccessor() + "; "
			+ "setTimeout(function () { tempMap.invalidateSize(false); }, 100)");
	}
	
	// endregion
	// region Layer/Controls
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-addcontrol">Leaflet Docs</a>
	 */
	public LMap addControl(final LControl<?> control)
	{
		this.invokeSelf(".addControl(" + control.clientComponentJsAccessor() + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-removecontrol">Leaflet Docs</a>
	 */
	public LMap removeControl(final LControl<?> control)
	{
		this.invokeSelf(".removeControl(" + control.clientComponentJsAccessor() + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-addlayer">Leaflet Docs</a>
	 */
	public LMap addLayer(final LLayer<?> layer)
	{
		this.invokeSelf(".addLayer(" + layer.clientComponentJsAccessor() + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-removelayer">Leaflet Docs</a>
	 */
	public LMap removeLayer(final LLayer<?> layer)
	{
		this.invokeSelf(".removeLayer(" + layer.clientComponentJsAccessor() + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-openpopup">Leaflet Docs</a>
	 */
	public LMap openPopup(final LPopup popup)
	{
		this.invokeSelf(".openPopup(" + popup.clientComponentJsAccessor() + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-closepopup">Leaflet Docs</a>
	 */
	public LMap closePopup(final LPopup popup)
	{
		this.invokeSelf(".closePopup(" + popup.clientComponentJsAccessor() + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-closepopup">Leaflet Docs</a>
	 */
	public LMap closePopup()
	{
		this.invokeSelf(".closePopup()");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-opentooltip">Leaflet Docs</a>
	 */
	public LMap openTooltip(final LTooltip tooltip)
	{
		this.invokeSelf(".openTooltip(" + tooltip.clientComponentJsAccessor() + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-closetooltip">Leaflet Docs</a>
	 */
	public LMap closeTooltip(final LTooltip tooltip)
	{
		this.invokeSelf(".closeTooltip(" + tooltip.clientComponentJsAccessor() + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-closetooltip">Leaflet Docs</a>
	 */
	public LMap closeTooltip()
	{
		this.invokeSelf(".closeTooltip()");
		return this.self();
	}
	
	// endregion
	// region Map state
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-setview">Leaflet docs</a>
	 */
	public LMap setView(final LLatLng center, final int zoom)
	{
		this.invokeSelf(".setView(" + center.clientComponentJsAccessor() + ", " + zoom + ")");
		return this.self();
	}
	
	// endregion
	// region Geolocation
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-locate">Leaflet docs</a>
	 */
	@SuppressWarnings("resource")
	public LMap locate(final LMapLocateOptions options)
	{
		this.invokeSelf(".locate(" + this.componentRegistry().writeOptions(options) + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-locate">Leaflet docs</a>
	 */
	public LMap locate()
	{
		return this.locate(null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-stoplocate">Leaflet docs</a>
	 */
	public LMap stopLocate()
	{
		this.invokeSelf(".stopLocate()");
		return this.self();
	}
	
	// endregion
}
