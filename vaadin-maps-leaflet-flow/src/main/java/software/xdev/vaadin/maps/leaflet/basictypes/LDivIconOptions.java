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
package software.xdev.vaadin.maps.leaflet.basictypes;

/**
 * @see <a href="https://leafletjs.com/reference.html#divicon">Leaflet docs</a>
 */
public class LDivIconOptions extends LAbstractIconOptions<LDivIconOptions>
{
	private String html;
	private LPoint bgPos;
	
	public String getHtml()
	{
		return this.html;
	}
	
	public void setHtml(final String html)
	{
		this.html = html;
	}
	
	public LDivIconOptions withHtml(final String html)
	{
		this.setHtml(html);
		return this.self();
	}
	
	public LPoint getBgPos()
	{
		return this.bgPos;
	}
	
	public void setBgPos(final LPoint bgPos)
	{
		this.bgPos = bgPos;
	}
	
	public LDivIconOptions withBgPos(final LPoint bgPos)
	{
		this.setBgPos(bgPos);
		return this.self();
	}
}
