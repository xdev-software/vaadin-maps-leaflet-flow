/*
 * Copyright © 2019 XDEV Software (https://xdev.software)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
