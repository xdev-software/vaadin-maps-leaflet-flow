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
package software.xdev.vaadin.maps.leaflet.geoman;

public class LTextOptions
{
	private String text;
	private Boolean focusAfterDraw;
	private Boolean removeIfEmpty;
	private String className;
	private Boolean textMarkerCentered;
	
	public String getText()
	{
		return this.text;
	}
	
	public void setText(final String text)
	{
		this.text = text;
	}
	
	public LTextOptions withText(final String text)
	{
		this.setText(text);
		return this;
	}
	
	public Boolean getFocusAfterDraw()
	{
		return this.focusAfterDraw;
	}
	
	public void setFocusAfterDraw(final Boolean focusAfterDraw)
	{
		this.focusAfterDraw = focusAfterDraw;
	}
	
	public LTextOptions withFocusAfterDraw(final Boolean focusAfterDraw)
	{
		this.setFocusAfterDraw(focusAfterDraw);
		return this;
	}
	
	public Boolean getRemoveIfEmpty()
	{
		return this.removeIfEmpty;
	}
	
	public void setRemoveIfEmpty(final Boolean removeIfEmpty)
	{
		this.removeIfEmpty = removeIfEmpty;
	}
	
	public LTextOptions withRemoveIfEmpty(final Boolean removeIfEmpty)
	{
		this.setRemoveIfEmpty(removeIfEmpty);
		return this;
	}
	
	public String getClassName()
	{
		return this.className;
	}
	
	public void setClassName(final String className)
	{
		this.className = className;
	}
	
	public LTextOptions withClassName(final String className)
	{
		this.setClassName(className);
		return this;
	}
	
	public Boolean getTextMarkerCentered()
	{
		return this.textMarkerCentered;
	}
	
	public void setTextMarkerCentered(final Boolean textMarkerCentered)
	{
		this.textMarkerCentered = textMarkerCentered;
	}
	
	public LTextOptions withTextMarkerCentered(final Boolean textMarkerCentered)
	{
		this.setTextMarkerCentered(textMarkerCentered);
		return this;
	}
}
