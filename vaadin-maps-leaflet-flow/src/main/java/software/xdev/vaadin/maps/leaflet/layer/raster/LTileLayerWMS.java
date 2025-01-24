package software.xdev.vaadin.maps.leaflet.layer.raster;

import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * Represents a <a href="https://leafletjs.com/reference.html#tilelayer-wms">WMS tile layer</a>.
 */
public class LTileLayerWMS extends LAbstractTileLayer<LTileLayerWMS>
{
	public LTileLayerWMS(
		final LComponentManagementRegistry compReg,
		final String baseUrl,
		final LTileLayerWMSOptions options)
	{
		super(compReg, "L.tileLayer.wms($0" + compReg.writeOptionsOptionalNextParameter(options) + ")", baseUrl);
	}
	
	public LTileLayerWMS(
		final LComponentManagementRegistry compReg,
		final String baseUrl,
		final String layers)
	{
		this(compReg, baseUrl, new LTileLayerWMSOptions().withLayers(layers));
	}
	
	public LTileLayerWMS(
		final LComponentManagementRegistry compReg,
		final String baseUrl,
		final String layers,
		final int maxZoom,
		final String attribution)
	{
		this(compReg, baseUrl, new LTileLayerWMSOptions()
			.withLayers(layers)
			.withMaxZoom(maxZoom)
			.withAttribution(attribution));
	}
}
