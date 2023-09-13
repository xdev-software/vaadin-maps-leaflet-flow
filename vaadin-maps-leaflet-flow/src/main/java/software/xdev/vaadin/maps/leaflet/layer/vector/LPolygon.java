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

import java.util.Collection;
import java.util.List;

import software.xdev.vaadin.maps.leaflet.basictypes.LLatLng;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#polygon">Leaflet docs</a>
 */
public class LPolygon extends LPolyline
{
	public LPolygon(
		final LComponentManagementRegistry compReg,
		final Collection<?> latLngs,
		final LPolylineOptions options)
	{
		super(compReg, "L.polygon", latLngs, options);
	}
	
	public LPolygon(
		final LComponentManagementRegistry compReg,
		final Collection<?> latLngs)
	{
		this(compReg, latLngs, null);
	}
	
	public LPolygon(
		final LComponentManagementRegistry compReg,
		final LLatLng... latLngs)
	{
		this(compReg, List.of(latLngs), null);
	}
}
