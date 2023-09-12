package software.xdev.vaadin.maps.leaflet.layer.raster;

import software.xdev.vaadin.maps.leaflet.layer.LGridLayer;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * Represents a <a href="https://leafletjs.com/reference.html#tilelayer">tile layer</a>.
 * <p/>
 * <b>Important</b>
 * <ul>
 *     <li>Before using tile servers check their usage policies</li>
 *     <li>If the server is funded by donations consider donating</li>
 * </ul>
 *
 * @see <a href="https://wiki.openstreetmap.org/wiki/Raster_tile_providers">List of raster tile providers</a>
 */
public class LTileLayer extends LGridLayer<LTileLayer>
{
	public LTileLayer(
		final LComponentManagementRegistry compReg,
		final String urlTemplate)
	{
		this(compReg, urlTemplate, null);
	}
	
	public LTileLayer(
		final LComponentManagementRegistry compReg,
		final String urlTemplate,
		final LTileLayerOptions options)
	{
		super(compReg, "L.tileLayer($0" + compReg.writeOptionsOptionalParameter(options) + ")", urlTemplate);
	}
	
	public LTileLayer(
		final LComponentManagementRegistry compReg,
		final String urlTemplate,
		final int maxZoom,
		final String attribution)
	{
		this(compReg, urlTemplate, new LTileLayerOptions().withMaxZoom(maxZoom).withAttribution(attribution));
	}
	
	/**
	 * Use OpenStreetMap's tile server <br/>
	 * <b>Important: By using this you accept the <a href="https://operations.osmfoundation.org/policies/tiles/">Usage Policy</a></b>
	 */
	public static LTileLayer createDefaultForOpenStreetMapTileServer(final LComponentManagementRegistry compReg)
	{
		return new LTileLayer(
			compReg,
			"https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png",
			19,
			"© <a href=\"https://www.openstreetmap.org/copyright\">OpenStreetMap</a>"
		);
	}
}
