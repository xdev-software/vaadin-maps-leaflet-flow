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

import software.xdev.vaadin.maps.leaflet.base.LComponentOptions;


public abstract class LAbstractIconOptions<S extends LAbstractIconOptions<S>> implements LComponentOptions<S>
{
	private String iconUrl;
	private String iconRetinaUrl;
	private LPoint iconSize;
	private LPoint iconAnchor;
	private LPoint popupAnchor;
	private LPoint tooltipAnchor;
	private String shadowUrl;
	private String shadowRetinaUrl;
	private LPoint shadowSize;
	private LPoint shadowAnchor;
	private String className;
	// Boolean|String
	private Object crossOrigin;
	
	public String getIconUrl()
	{
		return this.iconUrl;
	}
	
	public void setIconUrl(final String iconUrl)
	{
		this.iconUrl = iconUrl;
	}
	
	public S withIconUrl(final String iconUrl)
	{
		this.setIconUrl(iconUrl);
		return this.self();
	}
	
	public String getIconRetinaUrl()
	{
		return this.iconRetinaUrl;
	}
	
	public void setIconRetinaUrl(final String iconRetinaUrl)
	{
		this.iconRetinaUrl = iconRetinaUrl;
	}
	
	public S withIconRetinaUrl(final String iconRetinaUrl)
	{
		this.setIconRetinaUrl(iconRetinaUrl);
		return this.self();
	}
	
	public LPoint getIconSize()
	{
		return this.iconSize;
	}
	
	public void setIconSize(final LPoint iconSize)
	{
		this.iconSize = iconSize;
	}
	
	public S withIconSize(final LPoint iconSize)
	{
		this.setIconSize(iconSize);
		return this.self();
	}
	
	public LPoint getIconAnchor()
	{
		return this.iconAnchor;
	}
	
	public void setIconAnchor(final LPoint iconAnchor)
	{
		this.iconAnchor = iconAnchor;
	}
	
	public S withIconAnchor(final LPoint iconAnchor)
	{
		this.setIconAnchor(iconAnchor);
		return this.self();
	}
	
	public LPoint getPopupAnchor()
	{
		return this.popupAnchor;
	}
	
	public void setPopupAnchor(final LPoint popupAnchor)
	{
		this.popupAnchor = popupAnchor;
	}
	
	public S withPopupAnchor(final LPoint popupAnchor)
	{
		this.setPopupAnchor(popupAnchor);
		return this.self();
	}
	
	public LPoint getTooltipAnchor()
	{
		return this.tooltipAnchor;
	}
	
	public void setTooltipAnchor(final LPoint tooltipAnchor)
	{
		this.tooltipAnchor = tooltipAnchor;
	}
	
	public S withCrossOrigin(final LPoint tooltipAnchor)
	{
		this.setTooltipAnchor(tooltipAnchor);
		return this.self();
	}
	
	public String getShadowUrl()
	{
		return this.shadowUrl;
	}
	
	public void setShadowUrl(final String shadowUrl)
	{
		this.shadowUrl = shadowUrl;
	}
	
	public S withShadowUrl(final String shadowUrl)
	{
		this.setShadowUrl(shadowUrl);
		return this.self();
	}
	
	public String getShadowRetinaUrl()
	{
		return this.shadowRetinaUrl;
	}
	
	public void setShadowRetinaUrl(final String shadowRetinaUrl)
	{
		this.shadowRetinaUrl = shadowRetinaUrl;
	}
	
	public S withShadowRetinaUrl(final String shadowRetinaUrl)
	{
		this.setShadowRetinaUrl(shadowRetinaUrl);
		return this.self();
	}
	
	public LPoint getShadowSize()
	{
		return this.shadowSize;
	}
	
	public void setShadowSize(final LPoint shadowSize)
	{
		this.shadowSize = shadowSize;
	}
	
	public S withShadowSize(final LPoint shadowSize)
	{
		this.setShadowSize(shadowSize);
		return this.self();
	}
	
	public LPoint getShadowAnchor()
	{
		return this.shadowAnchor;
	}
	
	public void setShadowAnchor(final LPoint shadowAnchor)
	{
		this.shadowAnchor = shadowAnchor;
	}
	
	public S withShadowAnchor(final LPoint shadowAnchor)
	{
		this.setShadowAnchor(shadowAnchor);
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
	
	public Object getCrossOrigin()
	{
		return this.crossOrigin;
	}
	
	public void setCrossOrigin(final Object crossOrigin)
	{
		this.crossOrigin = crossOrigin;
	}
	
	public S withCrossOrigin(final Object crossOrigin)
	{
		this.setCrossOrigin(crossOrigin);
		return this.self();
	}
}
