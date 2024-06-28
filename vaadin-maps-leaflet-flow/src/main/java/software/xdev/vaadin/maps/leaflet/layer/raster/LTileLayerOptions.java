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
package software.xdev.vaadin.maps.leaflet.layer.raster;

import software.xdev.vaadin.maps.leaflet.layer.LGridLayerOptions;


/**
 * @see <a href="https://leafletjs.com/reference.html#tilelayer-option">Leaflet docs</a>
 */
public class LTileLayerOptions extends LGridLayerOptions<LTileLayerOptions>
{
	// String|String[]
	private Object subdomains;
	private String errorTileUrl;
	private Integer zoomOffset;
	private Boolean tms;
	private Boolean zoomReverse;
	private Boolean detectRetina;
	// Boolean|String
	private Object crossOrigin;
	// Boolean|String
	private Object referrerPolicy;
	
	public Object getSubdomains()
	{
		return this.subdomains;
	}
	
	public void setSubdomains(final Object subdomains)
	{
		this.subdomains = subdomains;
	}
	
	public LTileLayerOptions withSubdomains(final Object subdomains)
	{
		this.setSubdomains(subdomains);
		return this.self();
	}
	
	public String getErrorTileUrl()
	{
		return this.errorTileUrl;
	}
	
	public void setErrorTileUrl(final String errorTileUrl)
	{
		this.errorTileUrl = errorTileUrl;
	}
	
	public LTileLayerOptions withErrorTileUrl(final String errorTileUrl)
	{
		this.setErrorTileUrl(errorTileUrl);
		return this.self();
	}
	
	public Integer getZoomOffset()
	{
		return this.zoomOffset;
	}
	
	public void setZoomOffset(final Integer zoomOffset)
	{
		this.zoomOffset = zoomOffset;
	}
	
	public LTileLayerOptions withZoomOffset(final Integer zoomOffset)
	{
		this.setZoomOffset(zoomOffset);
		return this.self();
	}
	
	public Boolean getTms()
	{
		return this.tms;
	}
	
	public void setTms(final Boolean tms)
	{
		this.tms = tms;
	}
	
	public LTileLayerOptions withTms(final Boolean tms)
	{
		this.setTms(tms);
		return this.self();
	}
	
	public Boolean getZoomReverse()
	{
		return this.zoomReverse;
	}
	
	public void setZoomReverse(final Boolean zoomReverse)
	{
		this.zoomReverse = zoomReverse;
	}
	
	public LTileLayerOptions withZoomReverse(final Boolean zoomReverse)
	{
		this.setZoomReverse(zoomReverse);
		return this.self();
	}
	
	public Boolean getDetectRetina()
	{
		return this.detectRetina;
	}
	
	public void setDetectRetina(final Boolean detectRetina)
	{
		this.detectRetina = detectRetina;
	}
	public LTileLayerOptions withDetectRetina(final Boolean detectRetina)
	{
		this.setDetectRetina(detectRetina);
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
	
	public LTileLayerOptions withCrossOrigin(final Object crossOrigin)
	{
		this.setCrossOrigin(crossOrigin);
		return this.self();
	}
	
	public Object getReferrerPolicy()
	{
		return this.referrerPolicy;
	}
	
	public void setReferrerPolicy(final Object referrerPolicy)
	{
		this.referrerPolicy = referrerPolicy;
	}
	
	public LTileLayerOptions withReferrerPolicy(final Object referrerPolicy)
	{
		this.setReferrerPolicy(referrerPolicy);
		return this.self();
	}
}
