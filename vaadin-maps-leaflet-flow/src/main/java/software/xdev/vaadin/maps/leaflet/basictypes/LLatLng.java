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
package software.xdev.vaadin.maps.leaflet.basictypes;

import software.xdev.vaadin.maps.leaflet.base.LBaseComponent;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#latlng">Leaflet docs</a>
 */
public class LLatLng extends LBaseComponent<LLatLng>
{
	public LLatLng(final LComponentManagementRegistry componentRegistry, final double lat, final double lng)
	{
		super(componentRegistry, "L.latLng($0, $1)", lat, lng);
	}
	
	public LLatLng(
		final LComponentManagementRegistry componentRegistry,
		final double lat,
		final double lng,
		final double altitude)
	{
		super(componentRegistry, "L.latLng($0, $1, $2)", lat, lng, altitude);
	}
}
