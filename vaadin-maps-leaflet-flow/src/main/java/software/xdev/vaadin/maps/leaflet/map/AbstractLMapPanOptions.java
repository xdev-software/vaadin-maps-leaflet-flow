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

public class AbstractLMapPanOptions<T extends AbstractLMapPanOptions<T>>
	implements LMapPanBaseOptions<T>
{
	private Boolean animate;
	private Number duration;
	private Number easeLinearity;
	private Boolean noMoveStart;
	
	@Override
	public Boolean getAnimate()
	{
		return this.animate;
	}
	
	@Override
	public void setAnimate(final Boolean animate)
	{
		this.animate = animate;
	}
	
	@Override
	public T withAnimate(final Boolean animate)
	{
		return LMapPanBaseOptions.super.withAnimate(animate);
	}
	
	@Override
	public Number getDuration()
	{
		return this.duration;
	}
	
	@Override
	public void setDuration(final Number duration)
	{
		this.duration = duration;
	}
	
	@Override
	public Number getEaseLinearity()
	{
		return this.easeLinearity;
	}
	
	@Override
	public void setEaseLinearity(final Number easeLinearity)
	{
		this.easeLinearity = easeLinearity;
	}
	
	@Override
	public Boolean getNoMoveStart()
	{
		return this.noMoveStart;
	}
	
	@Override
	public void setNoMoveStart(final Boolean noMoveStart)
	{
		this.noMoveStart = noMoveStart;
	}
}
