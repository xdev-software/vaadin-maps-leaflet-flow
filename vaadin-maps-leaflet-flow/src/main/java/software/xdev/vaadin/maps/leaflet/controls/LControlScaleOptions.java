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

/**
 * @see <a href="https://leafletjs.com/reference.html#control-scale">Leaflet docs</a>
 */
public class LControlScaleOptions extends LControlOptions<LControlScaleOptions>
{
	private Integer maxWidth;
	private Boolean metric;
	private Boolean imperial;
	private Boolean updateWhenIdle;
	
	public Integer getMaxWidth()
	{
		return this.maxWidth;
	}
	
	public void setMaxWidth(final Integer maxWidth)
	{
		this.maxWidth = maxWidth;
	}
	
	public LControlScaleOptions withMaxWidth(final Integer maxWidth)
	{
		this.setMaxWidth(maxWidth);
		return this.self();
	}
	
	public Boolean getMetric()
	{
		return this.metric;
	}
	
	public void setMetric(final Boolean metric)
	{
		this.metric = metric;
	}
	
	public LControlScaleOptions withMetric(final Boolean metric)
	{
		this.setMetric(metric);
		return this.self();
	}
	
	public Boolean getImperial()
	{
		return this.imperial;
	}
	
	public void setImperial(final Boolean imperial)
	{
		this.imperial = imperial;
	}
	
	public LControlScaleOptions withImperial(final Boolean imperial)
	{
		this.setImperial(imperial);
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
	
	public LControlScaleOptions withUpdateWhenIdle(final Boolean updateWhenIdle)
	{
		this.setUpdateWhenIdle(updateWhenIdle);
		return this.self();
	}
}
