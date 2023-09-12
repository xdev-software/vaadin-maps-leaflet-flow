package software.xdev.vaadin.maps.leaflet.controls;

import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#control-attribution">Leaflet docs</a>
 */
public class LControlAttribution extends LControl<LControlAttribution>
{
	public LControlAttribution(
		final LComponentManagementRegistry compReg,
		final LControlAttributionOptions options)
	{
		super(compReg, "L.control.attribution(" + compReg.writeOptions(options) + ")");
	}
}
