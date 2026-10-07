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
package software.xdev.vaadin.maps.leaflet.layer;

import software.xdev.vaadin.maps.leaflet.basictypes.LLatLngBounds;


/**
 * @see <a href="https://leafletjs.com/reference.html#gridlayer-option">Leaflet docs</a>
 */
public abstract class LGridLayerOptions<S extends LGridLayerOptions<S>> extends LLayerOptions<S>
{
	// Number|Point
	private Object tileSize;
	private Number opacity;
	private Boolean updateWhenIdle;
	private Boolean updateWhenZooming;
	private Number updateInterval;
	private Number zIndex;
	private LLatLngBounds latLngBounds;
	private Number minZoom;
	private Number maxZoom;
	private Number minNativeZoom;
	private Number maxNativeZoom;
	private Boolean noWrap;
	private String className;
	private Number keepBuffer;
	
	public Object getTileSize()
	{
		return this.tileSize;
	}
	
	public void setTileSize(final Object tileSize)
	{
		this.tileSize = tileSize;
	}
	
	public S withTileSize(final Object tileSize)
	{
		this.setTileSize(tileSize);
		return this.self();
	}
	
	public Number getOpacity()
	{
		return this.opacity;
	}
	
	public void setOpacity(final Number opacity)
	{
		this.opacity = opacity;
	}
	
	public S withOpacity(final Number opacity)
	{
		this.setOpacity(opacity);
		return this.self();
	}
	
	public Boolean getUpdateWhenIdle()
	{
		return this.updateWhenIdle;
	}
	
	public void setUpdateWhenIdle(final Boolean updateWhenIdle)
	{
		this.updateWhenIdle = updateWhenIdle;
	}
	
	public S withUpdateWhenIdle(final Boolean updateWhenIdle)
	{
		this.setUpdateWhenIdle(updateWhenIdle);
		return this.self();
	}
	
	public Boolean getUpdateWhenZooming()
	{
		return this.updateWhenZooming;
	}
	
	public void setUpdateWhenZooming(final Boolean updateWhenZooming)
	{
		this.updateWhenZooming = updateWhenZooming;
	}
	
	public S withUpdateWhenZooming(final Boolean updateWhenZooming)
	{
		this.setUpdateWhenZooming(updateWhenZooming);
		return this.self();
	}
	
	public Number getUpdateInterval()
	{
		return this.updateInterval;
	}
	
	public void setUpdateInterval(final Number updateInterval)
	{
		this.updateInterval = updateInterval;
	}
	
	public S withUpdateInterval(final Number updateInterval)
	{
		this.setUpdateInterval(updateInterval);
		return this.self();
	}
	
	public Number getzIndex()
	{
		return this.zIndex;
	}
	
	public void setzIndex(final Number zIndex)
	{
		this.zIndex = zIndex;
	}
	
	public S withZIndex(final Number zIndex)
	{
		this.setzIndex(zIndex);
		return this.self();
	}
	
	public LLatLngBounds getLatLngBounds()
	{
		return this.latLngBounds;
	}
	
	public void setLatLngBounds(final LLatLngBounds latLngBounds)
	{
		this.latLngBounds = latLngBounds;
	}
	
	public S withLatLngBounds(final LLatLngBounds latLngBounds)
	{
		this.setLatLngBounds(latLngBounds);
		return this.self();
	}
	
	public Number getMinZoom()
	{
		return this.minZoom;
	}
	
	public void setMinZoom(final Number minZoom)
	{
		this.minZoom = minZoom;
	}
	
	public S withMinZoom(final Number minZoom)
	{
		this.setMinZoom(minZoom);
		return this.self();
	}
	
	public Number getMaxZoom()
	{
		return this.maxZoom;
	}
	
	public void setMaxZoom(final Number maxZoom)
	{
		this.maxZoom = maxZoom;
	}
	
	public S withMaxZoom(final Number maxZoom)
	{
		this.setMaxZoom(maxZoom);
		return this.self();
	}
	
	public Number getMinNativeZoom()
	{
		return this.minNativeZoom;
	}
	
	public void setMinNativeZoom(final Number minNativeZoom)
	{
		this.minNativeZoom = minNativeZoom;
	}
	
	public S withMinNativeZoom(final Number minNativeZoom)
	{
		this.setMinNativeZoom(minNativeZoom);
		return this.self();
	}
	
	public Number getMaxNativeZoom()
	{
		return this.maxNativeZoom;
	}
	
	public void setMaxNativeZoom(final Number maxNativeZoom)
	{
		this.maxNativeZoom = maxNativeZoom;
	}
	
	public S withMaxNativeZoom(final Number maxNativeZoom)
	{
		this.setMaxNativeZoom(maxNativeZoom);
		return this.self();
	}
	
	public Boolean getNoWrap()
	{
		return this.noWrap;
	}
	
	public void setNoWrap(final Boolean noWrap)
	{
		this.noWrap = noWrap;
	}
	
	public S withNoWrap(final Boolean noWrap)
	{
		this.setNoWrap(noWrap);
		return this.self();
	}
	
	public String getClassName()
	{
		return this.className;
	}
	
	public void setClassName(final String className)
	{
		this.className = className;
	}
	
	public S withClassName(final String className)
	{
		this.setClassName(className);
		return this.self();
	}
	
	public Number getKeepBuffer()
	{
		return this.keepBuffer;
	}
	
	public void setKeepBuffer(final Number keepBuffer)
	{
		this.keepBuffer = keepBuffer;
	}
	
	public S withKeepBuffer(final Number keepBuffer)
	{
		this.setKeepBuffer(keepBuffer);
		return this.self();
	}
}
