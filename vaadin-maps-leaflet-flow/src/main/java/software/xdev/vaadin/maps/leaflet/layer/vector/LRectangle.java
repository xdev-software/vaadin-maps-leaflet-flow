package software.xdev.vaadin.maps.leaflet.layer.vector;

import software.xdev.vaadin.maps.leaflet.basictypes.LLatLngBounds;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#rectangle">Leaflet docs</a>
 */
public class LRectangle extends LPolyline
{
	public LRectangle(
		final LComponentManagementRegistry compReg,
		final LLatLngBounds bounds,
		final LPolylineOptions options)
	{
		super(compReg, "L.rectangle("
			+ bounds.clientComponentJsAccessor()
			+ compReg.writeOptionsOptionalParameter(options)
			+ ")");
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#rectangle-setbounds">Leaflet docs</a>
	 */
	public LRectangle setBounds(final LLatLngBounds bounds)
	{
		this.invokeSelf(".setBounds(" + bounds.clientComponentJsAccessor() + ")");
		return this;
	}
}
