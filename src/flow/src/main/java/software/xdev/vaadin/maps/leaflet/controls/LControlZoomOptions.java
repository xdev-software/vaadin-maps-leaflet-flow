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
 * @see <a href="https://leafletjs.com/reference.html#control-zoom">Leaflet docs</a>
 */
public class LControlZoomOptions extends LControlOptions<LControlZoomOptions>
{
	private String zoomInText;
	private String zoomInTitle;
	private String zoomOutText;
	private String zoomOutTitle;
	
	public String getZoomInText()
	{
		return this.zoomInText;
	}
	
	public void setZoomInText(final String zoomInText)
	{
		this.zoomInText = zoomInText;
	}
	
	public LControlZoomOptions withZoomInText(final String zoomInText)
	{
		this.setZoomInText(zoomInText);
		return this.self();
	}
	
	public String getZoomInTitle()
	{
		return this.zoomInTitle;
	}
	
	public void setZoomInTitle(final String zoomInTitle)
	{
		this.zoomInTitle = zoomInTitle;
	}
	
	public LControlZoomOptions withZoomInTitle(final String zoomInTitle)
	{
		this.setZoomInTitle(zoomInTitle);
		return this.self();
	}
	
	public String getZoomOutText()
	{
		return this.zoomOutText;
	}
	
	public void setZoomOutText(final String zoomOutText)
	{
		this.zoomOutText = zoomOutText;
	}
	
	public LControlZoomOptions withZoomOutText(final String zoomOutText)
	{
		this.setZoomOutText(zoomOutText);
		return this.self();
	}
	
	public String getZoomOutTitle()
	{
		return this.zoomOutTitle;
	}
	
	public void setZoomOutTitle(final String zoomOutTitle)
	{
		this.zoomOutTitle = zoomOutTitle;
	}
	
	public LControlZoomOptions withZoomOutTitle(final String zoomOutTitle)
	{
		this.setZoomOutTitle(zoomOutTitle);
		return this.self();
	}
}
