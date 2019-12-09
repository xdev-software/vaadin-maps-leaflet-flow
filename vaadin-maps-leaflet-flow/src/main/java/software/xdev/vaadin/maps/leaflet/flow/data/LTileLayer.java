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


public class LTileLayer
{
	private String link;
	private String attribution;
	private int zoom;
	private String id;
	
	public LTileLayer(final String link, final String attribution, final int zoom, final String id)
	{
		super();
		this.link = link;
		this.attribution = attribution;
		this.zoom = zoom;
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
	
	public int getZoom()
	{
		return this.zoom;
	}
	
	public void setZoom(final int zoom)
	{
		this.zoom = zoom;
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
