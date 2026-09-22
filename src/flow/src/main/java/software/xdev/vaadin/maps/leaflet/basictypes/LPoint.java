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
 * @see <a href="https://leafletjs.com/reference.html#point">Leaflet docs</a>
 */
public class LPoint extends LBaseComponent<LPoint>
{
	public LPoint(
		final LComponentManagementRegistry compReg,
		final int x,
		final int y)
	{
		super(compReg, "L.point($0, $1)", x, y);
	}
	
	public LPoint(
		final LComponentManagementRegistry compReg,
		final int[] arr)
	{
		super(compReg, "L.point($0, $1)", arr[0], arr[1]);
	}
}
