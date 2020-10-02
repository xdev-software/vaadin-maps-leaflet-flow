
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


public class LPolygon implements LComponent
{
	private final LPolygonGeometry geometry;
	private final LPolygonOptions properties;
	
	public LPolygon(final LPoint... points)
	{
		final List<List<Double>> posis = new ArrayList<>();
		this.properties = new LPolygonOptions();
		for(final LPoint p : points)
		{
			posis.add(p.getCoords());
		}
		this.geometry = new LPolygonGeometry("Polygon", posis);
	}
	
	/**
	 * Create a new Polygon for marking a area on the map
	 *
	 * @param points
	 *            List of points to draw the Polygon
	 */
	public LPolygon(final List<LPoint> points)
	{
		final List<List<Double>> posis = new ArrayList<>();
		for(final LPoint p : points)
		{
			posis.add(p.getCoords());
		}
		
		this.properties = new LPolygonOptions();
		this.geometry = new LPolygonGeometry("Polygon", posis);
	}
	
	public boolean isStroke()
	{
		return this.properties.isStroke();
	}
	
	/**
	 * Draws a border, default is true.
	 *
	 * @param stroke
	 */
	public void setStroke(final boolean stroke)
	{
		this.properties.setStroke(stroke);
	}
	
	public String getStrokeColor()
	{
		return this.properties.getColor();
	}
	
	/**
	 * Set a Color to the border.
	 *
	 * @param strokeColor
	 */
	public void setStrokeColor(final String strokeColor)
	{
		this.properties.setColor(strokeColor);
	}
	
	public double getStrokeOpacity()
	{
		return this.properties.getOpacity();
	}
	
	/**
	 * Sets the opacity of the border.
	 *
	 * @param strokeOpacity
	 */
	public void setStrokeOpacity(final double strokeOpacity)
	{
		this.properties.setOpacity(strokeOpacity);
	}
	
	public int getStrokeWeight()
	{
		return this.properties.getWeight();
	}
	
	/**
	 * Sets the width of the border.
	 *
	 * @param strokeWeight
	 */
	public void setStrokeWeight(final int strokeWeight)
	{
		this.properties.setWeight(strokeWeight);
	}
	
	public String getLineJoin()
	{
		return this.properties.getLineJoin();
	}
	
	/**
	 * A string that defines shape to be used at the corners of the stroke.<br>
	 * <li>miter</li>
	 * <li>round</li>
	 * <li>bevel</li>
	 * <li>miter-clip</li>
	 * <li>arcs</li>
	 *
	 * @param lineJoin
	 */
	public void setLineJoin(final String lineJoin)
	{
		this.properties.setLineJoin(lineJoin);
	}
	
	public String getDashArray()
	{
		return this.properties.getDashArray();
	}
	
	/**
	 * A string that defines the stroke dash pattern.<br>
	 * For example: "2 1 3 1 2"
	 *
	 * @param dashArray
	 */
	public void setDashArray(final String dashArray)
	{
		this.properties.setDashArray(dashArray);
	}
	
	public String getDashOffset()
	{
		return this.properties.getDashOffset();
	}
	
	/**
	 * A string that defines the distance into the dash pattern to start the dash.<br>
	 * For example: "2" - The start of the dash array computation is pulled by 3 user units
	 *
	 * @param dashOffset
	 */
	public void setDashOffset(final String dashOffset)
	{
		this.properties.setDashOffset(dashOffset);
	}
	
	public boolean isFill()
	{
		return this.properties.isFill();
	}
	
	/**
	 * Whether to fill the path with color. Set it to false to disable filling.
	 *
	 * @param fill
	 */
	public void setFill(final boolean fill)
	{
		this.properties.setFill(fill);
	}
	
	public String getFillColor()
	{
		return this.properties.getFillColor();
	}
	
	/**
	 * Fill color.
	 *
	 * @param fillColor
	 */
	public void setFillColor(final String fillColor)
	{
		this.properties.setFillColor(fillColor);
	}
	
	public double getFillOpacity()
	{
		return this.properties.getFillOpacity();
	}
	
	/**
	 * Fill opacity.
	 *
	 * @param fillOpacity
	 */
	public void setFillOpacity(final double fillOpacity)
	{
		this.properties.setFillOpacity(fillOpacity);
	}
	
	public String getPopup()
	{
		return this.properties.getPopup();
	}
	
	/**
	 * Set Pop-up message.
	 *
	 * @param popup
	 */
	public void setPopup(final String popup)
	{
		this.properties.setPopup(popup);
	}
	
	public String getFillRule()
	{
		return this.properties.getFillRule();
	}
	
	/**
	 * A string that defines how the inside of a shape is determined.<br>
	 * <li>evenodd</li>
	 * <li>nonzero</li>
	 *
	 * @param fillRule
	 */
	public void setFillRule(final String fillRule)
	{
		this.properties.setFillRule(fillRule);
	}
	
	public boolean isNoClip()
	{
		return this.properties.isNoClip();
	}
	
	/**
	 * Disable polyline clipping.
	 *
	 * @param noClip
	 */
	public void setNoClip(final boolean noClip)
	{
		this.properties.setNoClip(noClip);
	}
	
	public double getSmoothFactor()
	{
		return this.properties.getSmoothFactor();
	}
	
	/**
	 * How much to simplify the polyline on each zoom level.<br>
	 * More means better performance and smoother look, and less means more accurate representation.
	 *
	 * @param smoothFactor
	 */
	public void setSmoothFactor(final double smoothFactor)
	{
		this.properties.setSmoothFactor(smoothFactor);
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
		}
		catch(final JsonProcessingException e)
		{
			throw new RuntimeException(e);
		}
		
		return jsonObject;
	}
	
}
