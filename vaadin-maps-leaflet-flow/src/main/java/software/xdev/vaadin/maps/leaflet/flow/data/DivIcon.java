
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import elemental.json.Json;
import elemental.json.JsonObject;


public class DivIcon
{
	private String className = "leaflet-div-icon";
	private final List<Integer> iconSize = new ArrayList<>();
	private final List<Integer> iconAnchor = new ArrayList<>();
	private String html;
	
	public DivIcon()
	{
		this.setIconSize(25, 41);
		this.setIconAnchor(0, 0);
	}
	
	public List<Integer> getIconSize()
	{
		return this.iconSize;
	}
	
	/**
	 * Sets icon size in px.
	 *
	 * @param iconSize
	 */
	public void setIconSize(final int x, final int y)
	{
		this.iconSize.clear();
		this.iconSize.add(x);
		this.iconSize.add(y);
	}
	
	public List<Integer> getIconAnchor()
	{
		return this.iconAnchor;
	}
	
	/**
	 * Anchor point vor the Icon image for fixing offsets
	 *
	 * @param iconAnchor
	 */
	public void setIconAnchor(final int x, final int y)
	{
		this.iconAnchor.clear();
		this.iconAnchor.add(x);
		this.iconAnchor.add(y);
	}
	
	public String getClassName()
	{
		return this.className;
	}
	
	/**
	 * Sets a className for CSS formating.
	 *
	 * @param className
	 */
	public void setClassName(final String className)
	{
		this.className = className;
	}
	
	public String getHtml()
	{
		return this.html;
	}
	
	/**
	 * Custom HTML code to put inside the div element, empty by default. Alternatively, an instance of HTMLElement.
	 *
	 * @param html
	 */
	public void setHtml(final String html)
	{
		this.html = html;
	}
	
	@JsonIgnore
	public JsonObject toJson()
	{
		final JsonObject jsonObject = Json.createObject();
		final ObjectMapper mapper = new ObjectMapper();
		try
		{
			jsonObject.put("icon", Json.parse(mapper.writeValueAsString(this)));
		}
		catch(final JsonProcessingException e)
		{
			throw new RuntimeException(e);
		}
		
		return jsonObject;
	}
}
