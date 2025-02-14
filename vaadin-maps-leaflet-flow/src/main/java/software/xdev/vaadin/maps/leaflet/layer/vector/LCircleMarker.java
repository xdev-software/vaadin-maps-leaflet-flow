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

import software.xdev.vaadin.maps.leaflet.basictypes.LLatLng;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#circlemarker">Leaflet docs</a>
 */
public class LCircleMarker extends LAbstractCircle<LCircleMarker>
{
	public LCircleMarker(
		final LComponentManagementRegistry compReg,
		final LLatLng latLng,
		final LCircleMarkerOptions options)
	{
		super(compReg, "L.circleMarker("
			+ latLng.clientComponentJsAccessor()
			+ compReg.writeOptionsOptionalNextParameter(options)
			+ ")");
	}
	
	public LCircleMarker(
		final LComponentManagementRegistry compReg,
		final LLatLng latLng)
	{
		this(compReg, latLng, null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#circlemarker-setradius">Leaflet docs</a>
	 */
	public LCircleMarker setRadius(final Number radius)
	{
		this.invokeSelf(".setRadius($0)", radius);
		return this.self();
	}
}
