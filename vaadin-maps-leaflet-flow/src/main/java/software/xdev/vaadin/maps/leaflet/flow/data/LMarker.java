
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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import elemental.json.Json;
import elemental.json.JsonObject;


public class LMarker implements LComponent
{

	private static final String MARKER_TYPE = "Point";
	private LMarkerGeometry geometry;
	private LMarkerOptions properties;
	private String token;


	/**
	 * Creates a new Marker at the latitude, longitude
	 *
	 * @param name
	 * @param lat
	 * @param lon
	 */
	public LMarker(final double lat, final double lon)
	{
		this(lat, lon, "empty");
	}

	public LMarker(final double lat, final double lon, final String token)
	{
		this.geometry = new LMarkerGeometry(MARKER_TYPE, lat, lon);
		this.properties = new LMarkerOptions();
		this.token = token;
	}


	public LIcon getIcon()
	{
		return this.properties.getIcon();
	}

	public void setDivIcon(final LDivIcon icon)
	{
		this.properties.setIcon(icon);
	}

	public LIcon getDivIcon()
	{
		return this.properties.getIcon();
	}

	public void setIcon(final LIcon icon)
	{
		this.properties.setIcon(icon);
	}

	public LMarkerGeometry getGeometry()
	{
		return this.geometry;
	}

	public void setGeometry(final LMarkerGeometry geometry)
	{
		this.geometry = geometry;
	}

	public LMarkerOptions getProperties()
	{
		return this.properties;
	}

	public void setProperties(final LMarkerOptions properties)
	{
		this.properties = properties;
	}

	public double getLat()
	{
		return this.geometry.getCoordinates().get(0);
	}

	public void setLat(final double lat)
	{
		this.geometry.getCoordinates().remove(0);
		this.geometry.getCoordinates().set(0, lat);
	}

	public double getLon()
	{
		return this.geometry.getCoordinates().get(1);
	}

	public void setLon(final double lon)
	{
		this.geometry.getCoordinates().remove(1);
		this.geometry.getCoordinates().set(1, lon);
	}

	public String getPopup()
	{
		return this.properties.getPopup();
	}

	/**
	 * Sets a Pop-up to the Marker
	 *
	 * @param popup
	 */
	public void setPopup(final String popup)
	{
		this.properties.setPopup(popup);
	}

	public String getToken()
	{
		return this.token;
	}

	public void setToken(final String token)
	{
		this.token = token;
	}

	public JsonObject toJson()
	{
		final JsonObject jsonObject = Json.createObject();
		final ObjectMapper mapper = new ObjectMapper();
		try
		{
			jsonObject.put("type", Json.create("Feature"));
			jsonObject.put("geometry", Json.parse(mapper.writeValueAsString(this.geometry)));
			jsonObject.put("properties", Json.parse(mapper.writeValueAsString(this.properties)));
			jsonObject.put("token", Json.create(this.token));

		}
		catch(final JsonProcessingException e)
		{
			throw new RuntimeException(e);
		}

		return jsonObject;
	}
}
