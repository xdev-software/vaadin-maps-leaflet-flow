package software.xdev.vaadin.maps.leaflet.layer.vector;

import software.xdev.vaadin.maps.leaflet.basictypes.LLatLng;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#circle">Leaflet docs</a>
 */
public class LCircle extends LAbstractCircle<LCircle>
{
	public LCircle(
		final LComponentManagementRegistry compReg,
		final LLatLng latLng,
		final LCircleOptions options)
	{
		super(compReg, "L.circle("
			+ latLng.clientComponentJsAccessor()
			+ compReg.writeOptionsOptionalParameter(options)
			+ ")");
	}
	
	public LCircle(
		final LComponentManagementRegistry compReg,
		final LLatLng latLng,
		final double radius)
	{
		this(compReg, latLng, new LCircleOptions().withRadius(radius));
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#circle-setradius">Leaflet docs</a>
	 */
	public LCircle setRadius(final Double radius)
	{
		this.invokeSelf(".setRadius($0)", radius);
		return this.self();
	}
}
