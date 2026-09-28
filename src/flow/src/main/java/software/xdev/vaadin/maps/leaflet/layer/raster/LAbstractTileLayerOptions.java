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
public abstract class LAbstractTileLayerOptions<S extends LAbstractTileLayerOptions<S>> extends LGridLayerOptions<S>
{
	// String|String[]
	private Object subdomains;
	private String errorTileUrl;
	private Number zoomOffset;
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
	
	public S withSubdomains(final Object subdomains)
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
	
	public S withErrorTileUrl(final String errorTileUrl)
	{
		this.setErrorTileUrl(errorTileUrl);
		return this.self();
	}
	
	public Number getZoomOffset()
	{
		return this.zoomOffset;
	}
	
	public void setZoomOffset(final Number zoomOffset)
	{
		this.zoomOffset = zoomOffset;
	}
	
	public S withZoomOffset(final Number zoomOffset)
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
	
	public S withTms(final Boolean tms)
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
	
	public S withZoomReverse(final Boolean zoomReverse)
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
	public S withDetectRetina(final Boolean detectRetina)
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
	
	public S withCrossOrigin(final Object crossOrigin)
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
	
	public S withReferrerPolicy(final Object referrerPolicy)
	{
		this.setReferrerPolicy(referrerPolicy);
		return this.self();
	}
}
