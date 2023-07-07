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
package software.xdev.vaadin.maps.leaflet.flow.data;

public class LPolygonOptions
{
	private boolean stroke = true;
	private String color = "#000000";
	private double opacity = 1.0;
	private int weight = 3;
	private String lineJoin = "round";
	
	private boolean fill = false;
	private String fillColor = "#ffffff";
	private double fillOpacity = 0.2;
	private String fillRule = "nonzero";
	private String dashArray;
	private String dashOffset;
	
	private boolean noClip = true;
	private double smoothFactor = 0.5;
	
	/**
	 * Radius for Circle Objects
	 */
	private double radius;
	
	private String popup;
	
	public double getRadius()
	{
		return this.radius;
	}
	
	/**
	 * Only for Circle
	 */
	public void setRadius(final double radius)
	{
		this.radius = radius;
	}
	
	public boolean isStroke()
	{
		return this.stroke;
	}
	
	public void setStroke(final boolean stroke)
	{
		this.stroke = stroke;
	}
	
	public String getColor()
	{
		return this.color;
	}
	
	public void setColor(final String strokeColor)
	{
		this.color = strokeColor;
	}
	
	public double getOpacity()
	{
		return this.opacity;
	}
	
	public void setOpacity(final double strokeOpacity)
	{
		this.opacity = strokeOpacity;
	}
	
	public int getWeight()
	{
		return this.weight;
	}
	
	public void setWeight(final int strokeWeight)
	{
		this.weight = strokeWeight;
	}
	
	public String getLineJoin()
	{
		return this.lineJoin;
	}
	
	public void setLineJoin(final String lineJoin)
	{
		this.lineJoin = lineJoin;
	}
	
	public boolean isFill()
	{
		return this.fill;
	}
	
	public void setFill(final boolean fill)
	{
		this.fill = fill;
	}
	
	public String getFillColor()
	{
		return this.fillColor;
	}
	
	public void setFillColor(final String fillColor)
	{
		this.fillColor = fillColor;
	}
	
	public double getFillOpacity()
	{
		return this.fillOpacity;
	}
	
	public void setFillOpacity(final double fillOpacity)
	{
		this.fillOpacity = fillOpacity;
	}
	
	public String getFillRule()
	{
		return this.fillRule;
	}
	
	public void setFillRule(final String fillRule)
	{
		this.fillRule = fillRule;
	}
	
	public String getDashArray()
	{
		return this.dashArray;
	}
	
	public void setDashArray(final String dashArray)
	{
		this.dashArray = dashArray;
	}
	
	public String getDashOffset()
	{
		return this.dashOffset;
	}
	
	public void setDashOffset(final String dashOffset)
	{
		this.dashOffset = dashOffset;
	}
	
	public boolean isNoClip()
	{
		return this.noClip;
	}
	
	public void setNoClip(final boolean noClip)
	{
		this.noClip = noClip;
	}
	
	public double getSmoothFactor()
	{
		return this.smoothFactor;
	}
	
	public void setSmoothFactor(final double smoothFactor)
	{
		this.smoothFactor = smoothFactor;
	}
	
	public String getPopup()
	{
		return this.popup;
	}
	
	public void setPopup(final String popup)
	{
		this.popup = popup;
	}
	
}
