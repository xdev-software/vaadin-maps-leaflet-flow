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

import software.xdev.vaadin.maps.leaflet.base.LComponentOptions;


/**
 * @see <a href="https://leafletjs.com/reference.html#layer-option">Leaflet docs</a>
 */
public abstract class LLayerOptions<S extends LLayerOptions<S>> implements LComponentOptions<S>
{
	private String pane;
	private String attribution;
	
	public String getPane()
	{
		return this.pane;
	}
	
	public void setPane(final String pane)
	{
		this.pane = pane;
	}
	
	public S withPane(final String pane)
	{
		this.setPane(pane);
		return this.self();
	}
	
	public String getAttribution()
	{
		return this.attribution;
	}
	
	public void setAttribution(final String attribution)
	{
		this.attribution = attribution;
	}
	
	public S withAttribution(final String attribution)
	{
		this.setAttribution(attribution);
		return this.self();
	}
}
