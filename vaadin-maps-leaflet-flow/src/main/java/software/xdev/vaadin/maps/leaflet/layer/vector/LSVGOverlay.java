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
