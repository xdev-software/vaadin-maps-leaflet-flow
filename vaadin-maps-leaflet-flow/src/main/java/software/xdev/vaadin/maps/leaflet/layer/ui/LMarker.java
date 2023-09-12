package software.xdev.vaadin.maps.leaflet.layer.ui;

import software.xdev.vaadin.maps.leaflet.base.has.LHasOpacity;
import software.xdev.vaadin.maps.leaflet.base.has.LHasSetLatLng;
import software.xdev.vaadin.maps.leaflet.basictypes.LIcon;
import software.xdev.vaadin.maps.leaflet.basictypes.LLatLng;
import software.xdev.vaadin.maps.leaflet.layer.LInteractiveLayer;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#marker">Leaflet Docs</a>
 */
public class LMarker extends LInteractiveLayer<LMarker>
	implements LHasSetLatLng<LMarker>, LHasOpacity<LMarker>
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
	 * @see <a href="https://leafletjs.com/reference.html#marker-setzindexoffset">Leaflet Docs</a>
	 */
	public LMarker setZIndexOffset(final Integer offset)
	{
		this.invokeSelf(".setZIndexOffset($0)", offset);
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#marker-seticon">Leaflet Docs</a>
	 */
	public LMarker setIcon(final LIcon icon)
	{
		this.invokeSelf(".setIcon(" + icon.clientComponentJsAccessor() + ")");
		return this.self();
	}
}
