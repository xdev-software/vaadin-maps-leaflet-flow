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
package software.xdev.vaadin.maps.leaflet.layer.other;

import software.xdev.vaadin.maps.leaflet.base.RawString;
import software.xdev.vaadin.maps.leaflet.layer.LInteractiveLayerOptions;


/**
 * @see <a href="https://leafletjs.com/reference.html#geojson">Leaflet docs</a>
 */
public class LGeoJSONLayerOptions extends LInteractiveLayerOptions<LGeoJSONLayerOptions>
{
	private RawString pointToLayer;
	private RawString style;
	private RawString onEachFeature;
	private RawString coordsToLatLng;
	private Boolean markersInheritOptions;
	
	public RawString getPointToLayer()
	{
		return this.pointToLayer;
	}
	
	public void setPointToLayer(final RawString pointToLayer)
	{
		this.pointToLayer = pointToLayer;
	}
	
	public LGeoJSONLayerOptions withPointToLayer(final RawString pointToLayer)
	{
		this.setPointToLayer(pointToLayer);
		return this.self();
	}
	
	public RawString getStyle()
	{
		return this.style;
	}
	
	public void setStyle(final RawString style)
	{
		this.style = style;
	}
	
	public LGeoJSONLayerOptions withStyle(final RawString style)
	{
		this.setStyle(style);
		return this.self();
	}
	
	public RawString getOnEachFeature()
	{
		return this.onEachFeature;
	}
	
	public void setOnEachFeature(final RawString onEachFeature)
	{
		this.onEachFeature = onEachFeature;
	}
	
	public LGeoJSONLayerOptions withOnEachFeature(final RawString onEachFeature)
	{
		this.setOnEachFeature(onEachFeature);
		return this.self();
	}
	
	public RawString getCoordsToLatLng()
	{
		return this.coordsToLatLng;
	}
	
	public void setCoordsToLatLng(final RawString coordsToLatLng)
	{
		this.coordsToLatLng = coordsToLatLng;
	}
	
	public LGeoJSONLayerOptions withCoordsToLatLng(final RawString coordsToLatLng)
	{
		this.setCoordsToLatLng(coordsToLatLng);
		return this.self();
	}
	
	public Boolean getMarkersInheritOptions()
	{
		return this.markersInheritOptions;
	}
	
	public void setMarkersInheritOptions(final Boolean markersInheritOptions)
	{
		this.markersInheritOptions = markersInheritOptions;
	}
	
	public LGeoJSONLayerOptions withMarkersInheritOptions(final Boolean markersInheritOptions)
	{
		this.setMarkersInheritOptions(markersInheritOptions);
		return this.self();
	}
}
