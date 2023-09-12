package software.xdev.vaadin.maps.leaflet.layer.raster;

import software.xdev.vaadin.maps.leaflet.basictypes.LLatLngBounds;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#videooverlay">Leaflet docs</a>
 */
public class LVideoOverlay extends LImageOverlay
{
	public LVideoOverlay(
		final LComponentManagementRegistry compReg,
		final String video,
		final LLatLngBounds bounds,
		final LVideoOverlayOptions options)
	{
		super(compReg,
			"L.videoOverlay($0, "
				+ bounds.clientComponentJsAccessor()
				+ compReg.writeOptionsOptionalParameter(options)
				+ ")",
			video);
	}
	
	public LVideoOverlay(
		final LComponentManagementRegistry compReg,
		final String video,
		final LLatLngBounds bounds)
	{
		this(compReg, video, bounds, null);
	}
	
}
