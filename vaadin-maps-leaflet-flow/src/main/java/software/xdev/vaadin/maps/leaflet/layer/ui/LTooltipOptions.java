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
package software.xdev.vaadin.maps.leaflet.layer.ui;

public class LTooltipOptions extends LDivOverlayOptions<LTooltipOptions>
{
	private String direction;
	private Boolean permanent;
	private Boolean sticky;
	private Double opacity;
	
	public String getDirection()
	{
		return this.direction;
	}
	
	public void setDirection(final String direction)
	{
		this.direction = direction;
	}
	
	public LTooltipOptions withDirection(final String direction)
	{
		this.setDirection(direction);
		return this.self();
	}
	
	public Boolean getPermanent()
	{
		return this.permanent;
	}
	
	public void setPermanent(final Boolean permanent)
	{
		this.permanent = permanent;
	}
	
	public LTooltipOptions withPermanent(final Boolean permanent)
	{
		this.setPermanent(permanent);
		return this.self();
	}
	
	public Boolean getSticky()
	{
		return this.sticky;
	}
	
	public void setSticky(final Boolean sticky)
	{
		this.sticky = sticky;
	}
	
	public LTooltipOptions withSticky(final Boolean sticky)
	{
		this.setSticky(sticky);
		return this.self();
	}
	
	public Double getOpacity()
	{
		return this.opacity;
	}
	
	public void setOpacity(final Double opacity)
	{
		this.opacity = opacity;
	}
	
	public LTooltipOptions withOpacity(final Double opacity)
	{
		this.setOpacity(opacity);
		return this.self();
	}
}
