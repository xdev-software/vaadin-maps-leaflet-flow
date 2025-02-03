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
public class LTileLayer extends LAbstractTileLayer<LTileLayer>
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
		super(compReg, "L.tileLayer($0" + compReg.writeOptionsOptionalNextParameter(options) + ")", urlTemplate);
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
	@SuppressWarnings("checkstyle:MagicNumber") // Default max Zoom
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
