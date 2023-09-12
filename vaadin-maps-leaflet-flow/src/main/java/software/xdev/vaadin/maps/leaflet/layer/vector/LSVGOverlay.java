package software.xdev.vaadin.maps.leaflet.layer.vector;

import software.xdev.vaadin.maps.leaflet.basictypes.LLatLngBounds;
import software.xdev.vaadin.maps.leaflet.layer.raster.LImageOverlay;
import software.xdev.vaadin.maps.leaflet.layer.raster.LVideoOverlayOptions;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#svgoverlay">Leaflet docs</a>
 */
public class LSVGOverlay extends LImageOverlay
{
	public LSVGOverlay(
		final LComponentManagementRegistry compReg,
		final String svg,
		final LLatLngBounds bounds,
		final LVideoOverlayOptions options)
	{
		super(compReg,
			"L.svgOverlay($0, "
				+ bounds.clientComponentJsAccessor()
				+ compReg.writeOptionsOptionalParameter(options)
				+ ")",
			svg);
	}
	
	public LSVGOverlay(
		final LComponentManagementRegistry compReg,
		final String video,
		final LLatLngBounds bounds)
	{
		this(compReg, video, bounds, null);
	}
}
