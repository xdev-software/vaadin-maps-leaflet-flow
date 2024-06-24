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


import software.xdev.vaadin.maps.leaflet.basictypes.LIcon;
import software.xdev.vaadin.maps.leaflet.layer.LInteractiveLayerOptions;


/**
 * <a href="https://leafletjs.com/reference.html#marker">Leaflet docs</a>
 */
public class LMarkerOptions extends LInteractiveLayerOptions<LMarkerOptions>
{
	private LIcon icon;
	private Boolean keyboard;
	private String title;
	private String alt;
	private Integer zIndexOffset;
	private Double opacity;
	private Boolean riseOnHover;
	private Double riseOffset;
	private String shadowPane;
	private Boolean autoPanFocus;
	
	public LIcon getIcon()
	{
		return this.icon;
	}
	
	public void setIcon(final LIcon icon)
	{
		this.icon = icon;
	}
	
	public LMarkerOptions withIcon(final LIcon icon)
	{
		this.setIcon(icon);
		return this.self();
	}
	
	public Boolean getKeyboard()
	{
		return this.keyboard;
	}
	
	public void setKeyboard(final Boolean keyboard)
	{
		this.keyboard = keyboard;
	}
	
	public LMarkerOptions withKeyboard(final Boolean keyboard)
	{
		this.setKeyboard(keyboard);
		return this.self();
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public void setTitle(final String title)
	{
		this.title = title;
	}
	
	public LMarkerOptions withTitle(final String title)
	{
		this.setTitle(title);
		return this.self();
	}
	
	public String getAlt()
	{
		return this.alt;
	}
	
	public void setAlt(final String alt)
	{
		this.alt = alt;
	}
	
	public LMarkerOptions withAlt(final String alt)
	{
		this.setAlt(alt);
		return this.self();
	}
	
	public Integer getzIndexOffset()
	{
		return this.zIndexOffset;
	}
	
	public void setzIndexOffset(final Integer zIndexOffset)
	{
		this.zIndexOffset = zIndexOffset;
	}
	
	public LMarkerOptions withzIndexOffset(final Integer zIndexOffset)
	{
		this.setzIndexOffset(zIndexOffset);
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
	
	public LMarkerOptions withOpacity(final Double opacity)
	{
		this.setOpacity(opacity);
		return this.self();
	}
	
	public Boolean getRiseOnHover()
	{
		return this.riseOnHover;
	}
	
	public void setRiseOnHover(final Boolean riseOnHover)
	{
		this.riseOnHover = riseOnHover;
	}
	
	public LMarkerOptions withRiseOnHover(final Boolean riseOnHover)
	{
		this.setRiseOnHover(riseOnHover);
		return this.self();
	}
	
	public Double getRiseOffset()
	{
		return this.riseOffset;
	}
	
	public void setRiseOffset(final Double riseOffset)
	{
		this.riseOffset = riseOffset;
	}
	
	public LMarkerOptions withRiseOffset(final Double riseOffset)
	{
		this.setRiseOffset(riseOffset);
		return this.self();
	}
	
	public String getShadowPane()
	{
		return this.shadowPane;
	}
	
	public void setShadowPane(final String shadowPane)
	{
		this.shadowPane = shadowPane;
	}
	
	public LMarkerOptions withShadowPane(final String shadowPane)
	{
		this.setShadowPane(shadowPane);
		return this.self();
	}
	
	public Boolean getAutoPanFocus()
	{
		return this.autoPanFocus;
	}
	
	public void setAutoPanFocus(final Boolean autoPanFocus)
	{
		this.autoPanFocus = autoPanFocus;
	}
	
	public LMarkerOptions withAutoPanFocus(final Boolean autoPanFocus)
	{
		this.setAutoPanFocus(autoPanFocus);
		return this.self();
	}
}
