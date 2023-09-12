package software.xdev.vaadin.maps.leaflet.layer.vector;

import software.xdev.vaadin.maps.leaflet.basictypes.LLatLng;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#circlemarker">Leaflet docs</a>
 */
public class LCircleMarker extends LAbstractCircle<LCircleMarker>
{
	public LCircleMarker(
		final LComponentManagementRegistry compReg,
		final LLatLng latLng,
		final LCircleMarkerOptions options)
	{
		super(compReg, "L.circleMarker("
			+ latLng.clientComponentJsAccessor()
			+ compReg.writeOptionsOptionalParameter(options)
			+ ")");
	}
	
	public LCircleMarker(
		final LComponentManagementRegistry compReg,
		final LLatLng latLng)
	{
		this(compReg, latLng, null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#circlemarker-setradius">Leaflet docs</a>
	 */
	public LCircleMarker setRadius(final Integer radius)
	{
		this.invokeSelf(".setRadius($0)", radius);
		return this.self();
	}
}
