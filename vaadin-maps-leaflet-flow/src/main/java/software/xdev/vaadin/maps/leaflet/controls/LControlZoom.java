package software.xdev.vaadin.maps.leaflet.controls;

import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#control-zoom">Leaflet docs</a>
 */
public class LControlZoom extends LControl<LControlZoom>
{
	public LControlZoom(
		final LComponentManagementRegistry compReg,
		final LControlZoomOptions options)
	{
		super(compReg, "L.control.zoom(" + compReg.writeOptions(options) + ")");
	}
}
