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
package software.xdev.vaadin.maps.leaflet.map;

import software.xdev.vaadin.maps.leaflet.base.LComponentOptions;


/**
 * @see <a href="https://leafletjs.com/reference.html#locate-options-option">Leaflet docs</a>
 */
public class LMapLocateOptions implements LComponentOptions<LMapLocateOptions>
{
	private Boolean watch;
	private Boolean setView;
	private Integer maxZoom;
	private Integer timeout;
	private Integer maximumAge;
	private Boolean enableHighAccuracy;
	
	public Boolean getWatch()
	{
		return this.watch;
	}
	
	public void setWatch(final Boolean watch)
	{
		this.watch = watch;
	}
	
	public LMapLocateOptions withWatch(final Boolean watch)
	{
		this.setWatch(watch);
		return this.self();
	}
	
	public Boolean getSetView()
	{
		return this.setView;
	}
	
	public void setSetView(final Boolean setView)
	{
		this.setView = setView;
	}
	
	public LMapLocateOptions withSetView(final Boolean setView)
	{
		this.setSetView(setView);
		return this.self();
	}
	
	public Integer getMaxZoom()
	{
		return this.maxZoom;
	}
	
	public void setMaxZoom(final Integer maxZoom)
	{
		this.maxZoom = maxZoom;
	}
	
	public LMapLocateOptions withMaxZoom(final Integer maxZoom)
	{
		this.setMaxZoom(maxZoom);
		return this.self();
	}
	
	public Integer getTimeout()
	{
		return this.timeout;
	}
	
	public void setTimeout(final Integer timeout)
	{
		this.timeout = timeout;
	}
	
	public LMapLocateOptions withTimeout(final Integer timeout)
	{
		this.setTimeout(timeout);
		return this.self();
	}
	
	public Integer getMaximumAge()
	{
		return this.maximumAge;
	}
	
	public void setMaximumAge(final Integer maximumAge)
	{
		this.maximumAge = maximumAge;
	}
	
	public LMapLocateOptions withMaximumAge(final Integer maximumAge)
	{
		this.setMaximumAge(maximumAge);
		return this.self();
	}
	
	public Boolean getEnableHighAccuracy()
	{
		return this.enableHighAccuracy;
	}
	
	public void setEnableHighAccuracy(final Boolean enableHighAccuracy)
	{
		this.enableHighAccuracy = enableHighAccuracy;
	}
	
	public LMapLocateOptions withEnableHighAccuracy(final Boolean enableHighAccuracy)
	{
		this.setEnableHighAccuracy(enableHighAccuracy);
		return this.self();
	}
}
