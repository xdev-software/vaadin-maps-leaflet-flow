/*
 * Copyright © 2019 XDEV Software (https://xdev.software/en)
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
package software.xdev.vaadin.maps.leaflet.flow.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import elemental.json.Json;
import elemental.json.JsonObject;


/**
 * <b>Important: When using a TileServer you have to check the usage policy!</b>
 *
 * @see <a href="https://wiki.openstreetmap.org/wiki/Tile_servers">Tile servers</a>
 */
public class LTileLayer
{
	/**
	 * OpenStreetMap's Standard tile layer
	 *
	 * @see <a href="https://operations.osmfoundation.org/policies/tiles/">Usage Policy</a>
	 */
	public static final LTileLayer DEFAULT_OPENSTREETMAP_TILE = new LTileLayer(
		"https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png",
		"© <a href=\"https://www.openstreetmap.org/copyright\">OpenStreetMap</a>",
		18
	);
	
	private String link;
	private String attribution;
	private int maxZoom;
	private String id;
	
	public LTileLayer(final String link, final String attribution, final int maxZoom)
	{
		this(link, attribution, maxZoom, null);
	}
	
	public LTileLayer(final String link, final String attribution, final int maxZoom, final String id)
	{
		this.link = link;
		this.attribution = attribution;
		this.maxZoom = maxZoom;
		this.id = id;
	}
	
	public String getLink()
	{
		return this.link;
	}
	
	public void setLink(final String link)
	{
		this.link = link;
	}
	
	public String getAttribution()
	{
		return this.attribution;
	}
	
	public void setAttribution(final String attribution)
	{
		this.attribution = attribution;
	}
	
	public int getMaxZoom()
	{
		return this.maxZoom;
	}
	
	public void setMaxZoom(final int maxZoom)
	{
		this.maxZoom = maxZoom;
	}
	
	public String getId()
	{
		return this.id;
	}
	
	public void setId(final String id)
	{
		this.id = id;
	}
	
	public JsonObject toJson()
	{
		final JsonObject jsonObject = Json.createObject();
		final ObjectMapper mapper = new ObjectMapper();
		try
		{
			jsonObject.put("tile", Json.parse(mapper.writeValueAsString(this)));
		}
		catch(final JsonProcessingException e)
		{
			throw new RuntimeException(e);
		}
		
		return jsonObject;
	}
}
