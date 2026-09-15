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
package software.xdev.vaadin.maps.leaflet.crs;

import software.xdev.vaadin.maps.leaflet.base.RawString;


/**
 * @apiNote CRS can't be constructed
 * @see <a href="https://leafletjs.com/reference.html#crs">Leaflet docs</a>
 */
public final class LCRS
{
	public static final class Defined
	{
		public static final RawString EARTH = new RawString("L.CRS.Earth");
		
		public static final RawString EPSG3395 = new RawString("L.CRS.EPSG3395");
		public static final RawString EPSG3857 = new RawString("L.CRS.EPSG3857");
		public static final RawString EPSG4326 = new RawString("L.CRS.EPSG4326");
		public static final RawString BASE = new RawString("L.CRS.Base");
		public static final RawString SIMPLE = new RawString("L.CRS.Simple");
		
		private Defined()
		{
		}
	}
	
	private LCRS()
	{
	}
}
