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



public class LMarkerOptions
{
	private String popup;
	private String tooltip;
	private LIcon icon;
	private boolean alertState = false;
	
	public LMarkerOptions()
	{
		this.icon = new LIcon();
	}
	
	public LIcon getIcon()
	{
		return this.icon;
	}
	
	public void setIcon(final LIcon icon)
	{
		this.icon = icon;
	}
	
	public String getPopup()
	{
		return this.popup;
	}
	
	public void setPopup(final String popup)
	{
		this.popup = popup;
	}
	
	public String getTooltip()
	{
		return this.tooltip;
	}
	
	public void setTooltip(final String tooltip)
	{
		this.tooltip = tooltip;
	}
	
	public void setAlertState(boolean state) {
		this.alertState = state;
	}
	
	public boolean getAlertState() {
		return this.alertState;
	}
}
