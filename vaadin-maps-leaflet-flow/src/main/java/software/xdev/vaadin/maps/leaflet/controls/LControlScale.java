package software.xdev.vaadin.maps.leaflet.controls;

import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#control-scale">Leaflet docs</a>
 */
public class LControlScale extends LControl<LControlScale>
{
	public LControlScale(
		final LComponentManagementRegistry compReg,
		final LControlScaleOptions options)
	{
		super(compReg, "L.control.scale(" + compReg.writeOptions(options) + ")");
	}
}
