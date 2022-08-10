
package software.xdev.vaadin.maps.leaflet.flow.data;

/*-
 * #%L
 * vaadin-maps-leaflet-flow
 * %%
 * Copyright (C) 2019 XDEV Software
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

public class LDivIcon extends LIcon
{
	
	private String className = "div-icon";
	private String html;
	
	public LDivIcon()
	{
		this("");
	}
	
	/**
	 * <b>Ensure that you escape the html properly so that you don't accidentally introduce Serverside XSS</b>
	 *
	 * @param html
	 */
	public LDivIcon(final String html)
	{
		this.setHtml(html);
		this.setIconAnchor(0, 0);
	}
	
	public String getClassName()
	{
		return this.className;
	}
	
	/**
	 * Sets a className for CSS formating.
	 *
	 * @param className
	 */
	public void setClassName(final String className)
	{
		this.className = className;
	}
	
	public String getHtml()
	{
		return this.html;
	}
	
	/**
	 * Custom HTML code to put inside the div element, empty by default. Alternatively, an instance of HTMLElement.
	 * <br/>
	 * <b>Ensure that you escape the html properly so that you don't accidentally introduce Serverside XSS</b>
	 *
	 * @param html
	 */
	public void setHtml(final String html)
	{
		this.html = html;
	}
}
