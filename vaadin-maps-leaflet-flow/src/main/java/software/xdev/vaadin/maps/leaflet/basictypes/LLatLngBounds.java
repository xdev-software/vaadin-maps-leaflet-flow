package software.xdev.vaadin.maps.leaflet.basictypes;

import software.xdev.vaadin.maps.leaflet.base.LBaseComponent;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#latlngbounds">Leaflet docs</a>
 */
public class LLatLngBounds extends LBaseComponent<LLatLngBounds>
{
	public LLatLngBounds(
		final LComponentManagementRegistry compReg,
		final LLatLng corner1,
		final LLatLng corner2)
	{
		super(compReg, "L.latLngBounds(" + corner1.clientComponentJsAccessor() + "," + corner2.clientComponentJsAccessor() + ")");
	}
}
