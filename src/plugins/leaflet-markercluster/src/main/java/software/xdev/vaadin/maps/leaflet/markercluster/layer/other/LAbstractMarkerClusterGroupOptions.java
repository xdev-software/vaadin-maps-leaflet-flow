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
package software.xdev.vaadin.maps.leaflet.markercluster.layer.other;

import software.xdev.vaadin.maps.leaflet.base.LComponentOptions;
import software.xdev.vaadin.maps.leaflet.base.RawString;


/**
 * @see <a href="https://github.com/Leaflet/Leaflet.markercluster/blob/v1.5.3/README.md#options">Docs</a>
 * @see <a href="https://github.com/Leaflet/Leaflet.markercluster/blob/v1.5.3/src/MarkerClusterGroup.js">Source</a>
 */
public abstract class LAbstractMarkerClusterGroupOptions<S extends LAbstractMarkerClusterGroupOptions<S>>
	implements LComponentOptions<S>
{
	private Number maxClusterRadius;
	private RawString iconCreateFunction;
	private RawString clusterPane;
	
	private Boolean spiderfyOnEveryZoom;
	private Boolean spiderfyOnMaxZoom;
	private Boolean showCoverageOnHover;
	private Boolean zoomToBoundsOnClick;
	private Boolean singleMarkerMode;
	
	private Number disableClusteringAtZoom;
	private Boolean removeOutsideVisibleBounds;
	private Boolean animate;
	private Boolean animateAddingMarkers;
	private RawString spiderfyShapePositions;
	private Number spiderfyDistanceMultiplier;
	// Should be of LPolylineOptions
	private Object spiderLegPolylineOptions;
	private Boolean chunkedLoading;
	private Number chunkInterval;
	private Number chunkDelay;
	private RawString chunkProgress;
	// Data to pass to L.Polygon
	private Object polygonOptions;
	
	public Number getMaxClusterRadius()
	{
		return this.maxClusterRadius;
	}
	
	public void setMaxClusterRadius(final Number maxClusterRadius)
	{
		this.maxClusterRadius = maxClusterRadius;
	}
	
	public S withMaxClusterRadius(final Number maxClusterRadius)
	{
		this.setMaxClusterRadius(maxClusterRadius);
		return this.self();
	}
	
	public RawString getIconCreateFunction()
	{
		return this.iconCreateFunction;
	}
	
	public void setIconCreateFunction(final RawString iconCreateFunction)
	{
		this.iconCreateFunction = iconCreateFunction;
	}
	
	public S withIconCreateFunction(final RawString iconCreateFunction)
	{
		this.setIconCreateFunction(iconCreateFunction);
		return this.self();
	}
	
	public RawString getClusterPane()
	{
		return this.clusterPane;
	}
	
	public void setClusterPane(final RawString clusterPane)
	{
		this.clusterPane = clusterPane;
	}
	
	public S withClusterPane(final RawString clusterPane)
	{
		this.setClusterPane(clusterPane);
		return this.self();
	}
	
	public Boolean getSpiderfyOnEveryZoom()
	{
		return this.spiderfyOnEveryZoom;
	}
	
	public void setSpiderfyOnEveryZoom(final Boolean spiderfyOnEveryZoom)
	{
		this.spiderfyOnEveryZoom = spiderfyOnEveryZoom;
	}
	
	public S withSpiderfyOnEveryZoom(final Boolean spiderfyOnEveryZoom)
	{
		this.setSpiderfyOnEveryZoom(spiderfyOnEveryZoom);
		return this.self();
	}
	
	public Boolean getSpiderfyOnMaxZoom()
	{
		return this.spiderfyOnMaxZoom;
	}
	
	public void setSpiderfyOnMaxZoom(final Boolean spiderfyOnMaxZoom)
	{
		this.spiderfyOnMaxZoom = spiderfyOnMaxZoom;
	}
	
	public S withSpiderfyOnMaxZoom(final Boolean spiderfyOnMaxZoom)
	{
		this.setSpiderfyOnMaxZoom(spiderfyOnMaxZoom);
		return this.self();
	}
	
	public Boolean getShowCoverageOnHover()
	{
		return this.showCoverageOnHover;
	}
	
	public void setShowCoverageOnHover(final Boolean showCoverageOnHover)
	{
		this.showCoverageOnHover = showCoverageOnHover;
	}
	
	public S withShowCoverageOnHover(final Boolean showCoverageOnHover)
	{
		this.setShowCoverageOnHover(showCoverageOnHover);
		return this.self();
	}
	
	public Boolean getZoomToBoundsOnClick()
	{
		return this.zoomToBoundsOnClick;
	}
	
	public void setZoomToBoundsOnClick(final Boolean zoomToBoundsOnClick)
	{
		this.zoomToBoundsOnClick = zoomToBoundsOnClick;
	}
	
	public S withZoomToBoundsOnClick(final Boolean zoomToBoundsOnClick)
	{
		this.setZoomToBoundsOnClick(zoomToBoundsOnClick);
		return this.self();
	}
	
	public Boolean getSingleMarkerMode()
	{
		return this.singleMarkerMode;
	}
	
	public void setSingleMarkerMode(final Boolean singleMarkerMode)
	{
		this.singleMarkerMode = singleMarkerMode;
	}
	
	public S withSingleMarkerMode(final Boolean singleMarkerMode)
	{
		this.setSingleMarkerMode(singleMarkerMode);
		return this.self();
	}
	
	public Number getDisableClusteringAtZoom()
	{
		return this.disableClusteringAtZoom;
	}
	
	public void setDisableClusteringAtZoom(final Number disableClusteringAtZoom)
	{
		this.disableClusteringAtZoom = disableClusteringAtZoom;
	}
	
	public S withDisableClusteringAtZoom(final Number disableClusteringAtZoom)
	{
		this.setDisableClusteringAtZoom(disableClusteringAtZoom);
		return this.self();
	}
	
	public Boolean getRemoveOutsideVisibleBounds()
	{
		return this.removeOutsideVisibleBounds;
	}
	
	public void setRemoveOutsideVisibleBounds(final Boolean removeOutsideVisibleBounds)
	{
		this.removeOutsideVisibleBounds = removeOutsideVisibleBounds;
	}
	
	public S withRemoveOutsideVisibleBounds(final Boolean removeOutsideVisibleBounds)
	{
		this.setRemoveOutsideVisibleBounds(removeOutsideVisibleBounds);
		return this.self();
	}
	
	public Boolean getAnimate()
	{
		return this.animate;
	}
	
	public void setAnimate(final Boolean animate)
	{
		this.animate = animate;
	}
	
	public S withAnimate(final Boolean animate)
	{
		this.setAnimate(animate);
		return this.self();
	}
	
	public Boolean getAnimateAddingMarkers()
	{
		return this.animateAddingMarkers;
	}
	
	public void setAnimateAddingMarkers(final Boolean animateAddingMarkers)
	{
		this.animateAddingMarkers = animateAddingMarkers;
	}
	
	public S withAnimateAddingMarkers(final Boolean animateAddingMarkers)
	{
		this.setAnimateAddingMarkers(animateAddingMarkers);
		return this.self();
	}
	
	public RawString getSpiderfyShapePositions()
	{
		return this.spiderfyShapePositions;
	}
	
	public void setSpiderfyShapePositions(final RawString spiderfyShapePositions)
	{
		this.spiderfyShapePositions = spiderfyShapePositions;
	}
	
	public S withSpiderfyShapePositions(final RawString spiderfyShapePositions)
	{
		this.setSpiderfyShapePositions(spiderfyShapePositions);
		return this.self();
	}
	
	public Number getSpiderfyDistanceMultiplier()
	{
		return this.spiderfyDistanceMultiplier;
	}
	
	public void setSpiderfyDistanceMultiplier(final Number spiderfyDistanceMultiplier)
	{
		this.spiderfyDistanceMultiplier = spiderfyDistanceMultiplier;
	}
	
	public S withSpiderfyDistanceMultiplier(final Number spiderfyDistanceMultiplier)
	{
		this.setSpiderfyDistanceMultiplier(spiderfyDistanceMultiplier);
		return this.self();
	}
	
	public Object getSpiderLegPolylineOptions()
	{
		return this.spiderLegPolylineOptions;
	}
	
	public void setSpiderLegPolylineOptions(final Object spiderLegPolylineOptions)
	{
		this.spiderLegPolylineOptions = spiderLegPolylineOptions;
	}
	
	public S withSpiderLegPolylineOptions(final Object spiderLegPolylineOptions)
	{
		this.setSpiderLegPolylineOptions(spiderLegPolylineOptions);
		return this.self();
	}
	
	public Boolean getChunkedLoading()
	{
		return this.chunkedLoading;
	}
	
	public void setChunkedLoading(final Boolean chunkedLoading)
	{
		this.chunkedLoading = chunkedLoading;
	}
	
	public S withChunkedLoading(final Boolean chunkedLoading)
	{
		this.setChunkedLoading(chunkedLoading);
		return this.self();
	}
	
	public Number getChunkInterval()
	{
		return this.chunkInterval;
	}
	
	public void setChunkInterval(final Number chunkInterval)
	{
		this.chunkInterval = chunkInterval;
	}
	
	public S withChunkInterval(final Number chunkInterval)
	{
		this.setChunkInterval(chunkInterval);
		return this.self();
	}
	
	public Number getChunkDelay()
	{
		return this.chunkDelay;
	}
	
	public void setChunkDelay(final Number chunkDelay)
	{
		this.chunkDelay = chunkDelay;
	}
	
	public S withChunkDelay(final Number chunkDelay)
	{
		this.setChunkDelay(chunkDelay);
		return this.self();
	}
	
	public RawString getChunkProgress()
	{
		return this.chunkProgress;
	}
	
	public void setChunkProgress(final RawString chunkProgress)
	{
		this.chunkProgress = chunkProgress;
	}
	
	public S withChunkProgress(final RawString chunkProgress)
	{
		this.setChunkProgress(chunkProgress);
		return this.self();
	}
	
	public Object getPolygonOptions()
	{
		return this.polygonOptions;
	}
	
	public void setPolygonOptions(final Object polygonOptions)
	{
		this.polygonOptions = polygonOptions;
	}
	
	public S withPolygonOptions(final Object polygonOptions)
	{
		this.setPolygonOptions(polygonOptions);
		return this.self();
	}
}
