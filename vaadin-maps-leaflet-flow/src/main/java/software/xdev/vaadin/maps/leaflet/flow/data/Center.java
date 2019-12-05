
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

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import elemental.json.Json;
import elemental.json.JsonObject;


public class Center
{

	private List<Double> coordinates = new ArrayList<>();
	private int zoom;

	public Center(final double lat, final double lon, final int zoom)
	{
		this.coordinates.add(lat);
		this.coordinates.add(lon);
		this.zoom = zoom;
	}

	public int getZoom()
	{
		return this.zoom;
	}

	/**
	 * Sets the zoom level at the start
	 * @param zoom
	 */
	public void setZoom(final int zoom)
	{
		this.zoom = zoom;
	}

	public List<Double> getCoordinates()
	{
		return this.coordinates;
	}

	public void setCoordinates(final List<Double> coordinates)
	{
		this.coordinates = coordinates;
	}

	public JsonObject toJson()
	{
		final JsonObject jsonObject = Json.createObject();
		final ObjectMapper mapper = new ObjectMapper();
		try
		{
			jsonObject.put("point", Json.parse(mapper.writeValueAsString(this)));
		}
		catch(final JsonProcessingException e)
		{
			throw new RuntimeException(e);
		}

		return jsonObject;
	}
}
