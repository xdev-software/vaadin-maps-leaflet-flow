
package software.xdev.vaadin.maps.leaflet.flow.data;

/*-
 * #%L
 * vaadin-maps-leaflet-flow
 * %%
 * Copyright (C) 2019 XDEV Software
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import elemental.json.Json;
import elemental.json.JsonObject;

import java.util.ArrayList;
import java.util.List;


public class LPoint
{
	private Double lat;
	private Double lon;
	private List<Double> coords = new ArrayList<>();
	
	public LPoint(final double lat, final double lon)
	{
		this.lat = lat;
		this.lon = lon;
		coords.add(lat);
		coords.add(lon);
	}
	
	public List<Double> getCoords()
	{
		return coords;
	}
	
	public void setCoords(final List<Double> point)
	{
		this.coords = point;
		this.lat = point.get(0);
		this.lon = point.get(1);
	}

	public JsonObject toJson()
	{
		final JsonObject jsonObject = Json.createObject();
		jsonObject.put("lat", Json.create(this.lat));
		jsonObject.put("lon",  Json.create(this.lon));
		return jsonObject;
	}
	
}
