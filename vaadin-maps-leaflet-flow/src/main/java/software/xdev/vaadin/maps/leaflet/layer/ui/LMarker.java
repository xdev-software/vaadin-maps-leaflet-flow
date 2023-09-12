package software.xdev.vaadin.maps.leaflet.layer.ui;

import software.xdev.vaadin.maps.leaflet.basictypes.LIcon;
import software.xdev.vaadin.maps.leaflet.basictypes.LLatLng;
import software.xdev.vaadin.maps.leaflet.layer.LInteractiveLayer;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#marker">Leaflet Docs</a>
 */
public class LMarker extends LInteractiveLayer<LMarker>
{
	public LMarker(
		final LComponentManagementRegistry componentRegistry,
		final LLatLng latLng)
	{
		this(componentRegistry, latLng, null);
	}
	
	public LMarker(
		final LComponentManagementRegistry compReg,
		final LLatLng latLng,
		final LMarkerOptions options)
	{
		super(
			compReg,
			"L.marker(" + compReg.clientComponentJsAccessor(latLng) + compReg.writeOptionsOptionalParameter(options) + ")");
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#marker-setlatlng">Leaflet Docs</a>
	 */
	@SuppressWarnings("resource")
	public void setLatLng(final LLatLng latLng)
	{
		this.invokeSelf(".setLatLng(" + this.componentRegistry().clientComponentJsAccessor(latLng) + ")");
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#marker-setzindexoffset">Leaflet Docs</a>
	 */
	public void setZIndexOffset(final Integer offset)
	{
		this.invokeSelf(".setZIndexOffset($0)", offset);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#marker-seticon">Leaflet Docs</a>
	 */
	@SuppressWarnings("resource")
	public void setIcon(final LIcon icon)
	{
		this.invokeSelf(".setIcon(" + this.componentRegistry().clientComponentJsAccessor(icon) + ")");
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#marker-setopacity">Leaflet Docs</a>
	 */
	public void setOpacity(final Double offset)
	{
		this.invokeSelf(".setOpacity($0)", offset);
	}
}
