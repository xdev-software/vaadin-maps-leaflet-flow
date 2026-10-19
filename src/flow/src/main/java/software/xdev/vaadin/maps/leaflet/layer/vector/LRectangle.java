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
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#rectangle">Leaflet docs</a>
 */
@SuppressWarnings("java:S110")
public class LRectangle extends LPolyline
{
	public LRectangle(
		final LComponentManagementRegistry compReg,
		final LLatLngBounds bounds,
		final LPolylineOptions options)
	{
		super(compReg, "L.rectangle("
			+ bounds.clientComponentJsAccessor()
			+ compReg.writeOptionsOptionalNextParameter(options)
			+ ")");
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#rectangle-setbounds">Leaflet docs</a>
	 */
	public LRectangle setBounds(final LLatLngBounds bounds)
	{
		this.invokeSelf(".setBounds(" + bounds.clientComponentJsAccessor() + ")");
		return this;
	}
}
