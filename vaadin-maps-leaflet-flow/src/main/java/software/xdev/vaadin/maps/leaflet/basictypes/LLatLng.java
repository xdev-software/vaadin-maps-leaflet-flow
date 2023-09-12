package software.xdev.vaadin.maps.leaflet.basictypes;

import software.xdev.vaadin.maps.leaflet.base.LBaseComponent;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#latlng">Leaflet Docs</a>
 */
public class LLatLng extends LBaseComponent<LLatLng>
{
	public LLatLng(final LComponentManagementRegistry componentRegistry, final double lat, final double lng)
	{
		super(componentRegistry, "L.latLng($0, $1)", lat, lng);
	}
	
	public LLatLng(final LComponentManagementRegistry componentRegistry, final double lat, final double lng, final double altitude)
	{
		super(componentRegistry, "L.latLng($0, $1, $2)", lat, lng, altitude);
	}
}
