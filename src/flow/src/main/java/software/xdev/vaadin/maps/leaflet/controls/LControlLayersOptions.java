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
package software.xdev.vaadin.maps.leaflet.controls;

import software.xdev.vaadin.maps.leaflet.base.RawString;


/**
 * @see <a href="https://leafletjs.com/reference.html#control-layers">Leaflet docs</a>
 */
public class LControlLayersOptions extends LControlOptions<LControlLayersOptions>
{
	private Boolean collapsed;
	private Boolean autoZIndex;
	private Boolean hideSingleBase;
	private Boolean sortLayers;
	private RawString sortFunction;
	
	public Boolean getCollapsed()
	{
		return this.collapsed;
	}
	
	public void setCollapsed(final Boolean collapsed)
	{
		this.collapsed = collapsed;
	}
	
	public LControlLayersOptions withCollapsed(final Boolean collapsed)
	{
		this.setCollapsed(collapsed);
		return this.self();
	}
	
	public Boolean getAutoZIndex()
	{
		return this.autoZIndex;
	}
	
	public void setAutoZIndex(final Boolean autoZIndex)
	{
		this.autoZIndex = autoZIndex;
	}
	
	public LControlLayersOptions withAutoZIndex(final Boolean autoZIndex)
	{
		this.setAutoZIndex(autoZIndex);
		return this.self();
	}
	
	public Boolean getHideSingleBase()
	{
		return this.hideSingleBase;
	}
	
	public void setHideSingleBase(final Boolean hideSingleBase)
	{
		this.hideSingleBase = hideSingleBase;
	}
	
	public LControlLayersOptions withHideSingleBase(final Boolean hideSingleBase)
	{
		this.setHideSingleBase(hideSingleBase);
		return this.self();
	}
	
	public Boolean getSortLayers()
	{
		return this.sortLayers;
	}
	
	public void setSortLayers(final Boolean sortLayers)
	{
		this.sortLayers = sortLayers;
	}
	
	public LControlLayersOptions withSortLayers(final Boolean sortLayers)
	{
		this.setSortLayers(sortLayers);
		return this.self();
	}
	
	public RawString getSortFunction()
	{
		return this.sortFunction;
	}
	
	public void setSortFunction(final RawString sortFunction)
	{
		this.sortFunction = sortFunction;
	}
	
	public LControlLayersOptions withSortFunction(final RawString sortFunction)
	{
		this.setSortFunction(sortFunction);
		return this.self();
	}
}
