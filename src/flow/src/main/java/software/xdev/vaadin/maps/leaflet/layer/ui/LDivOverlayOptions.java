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

import software.xdev.vaadin.maps.leaflet.basictypes.LPoint;
import software.xdev.vaadin.maps.leaflet.layer.LInteractiveLayerOptions;

/**
 * @see <a href="https://leafletjs.com/reference.html#divoverlay-option">Leaflet docs</a>
 */
public abstract class LDivOverlayOptions<S extends LDivOverlayOptions<S>> extends LInteractiveLayerOptions<S>
{
	private LPoint offset;
	private String className;
	private Object content;
	
	public LPoint getOffset()
	{
		return this.offset;
	}
	
	public void setOffset(final LPoint offset)
	{
		this.offset = offset;
	}
	
	public S withOffset(final LPoint offset)
	{
		this.setOffset(offset);
		return this.self();
	}
	
	public String getClassName()
	{
		return this.className;
	}
	
	public void setClassName(final String className)
	{
		this.className = className;
	}
	
	public S withClassName(final String className)
	{
		this.setClassName(className);
		return this.self();
	}
	
	public Object getContent()
	{
		return this.content;
	}
	
	public void setContent(final Object content)
	{
		this.content = content;
	}
	
	public S withContent(final Object content)
	{
		this.setContent(content);
		return this.self();
	}
}
