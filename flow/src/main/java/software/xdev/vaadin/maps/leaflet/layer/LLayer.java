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

import java.io.Serializable;

import software.xdev.vaadin.maps.leaflet.base.LBaseComponent;
import software.xdev.vaadin.maps.leaflet.base.LComponent;
import software.xdev.vaadin.maps.leaflet.base.LEvented;
import software.xdev.vaadin.maps.leaflet.basictypes.LLatLng;
import software.xdev.vaadin.maps.leaflet.layer.ui.LPopup;
import software.xdev.vaadin.maps.leaflet.layer.ui.LPopupOptions;
import software.xdev.vaadin.maps.leaflet.layer.ui.LTooltip;
import software.xdev.vaadin.maps.leaflet.layer.ui.LTooltipOptions;
import software.xdev.vaadin.maps.leaflet.map.LMap;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#layer">Leaflet docs</a>
 */
public abstract class LLayer<S extends LLayer<S>> extends LBaseComponent<S> implements LEvented<S>
{
	protected LLayer(
		final LComponentManagementRegistry compReg,
		final String jsConstructorCallExpression,
		final Serializable... parameters)
	{
		super(compReg, jsConstructorCallExpression, parameters);
	}
	
	// region Add/Remove
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-addto">Leaflet docs</a>
	 */
	protected S addTo(final LComponent<?> lComponent)
	{
		this.invokeSelf(".addTo(" + lComponent.clientComponentJsAccessor() + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-addto">Leaflet docs</a>
	 */
	public S addTo(final LMap map)
	{
		return this.addTo((LComponent<?>)map);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-addto">Leaflet docs</a>
	 */
	public S addTo(final LLayerGroup layerGroup)
	{
		return this.addTo((LComponent<?>)layerGroup);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-remove">Leaflet docs</a>
	 */
	public S remove()
	{
		this.invokeSelf(".remove()");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-removefrom">Leaflet docs</a>
	 */
	protected S removeFrom(final LComponent<?> lComponent)
	{
		this.invokeSelf(".removeFrom(" + lComponent.clientComponentJsAccessor() + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-removefrom">Leaflet docs</a>
	 */
	public S removeFrom(final LMap map)
	{
		return this.removeFrom((LComponent<?>)map);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-removefrom">Leaflet docs</a>
	 */
	public S removeFrom(final LLayerGroup layerGroup)
	{
		return this.removeFrom((LComponent<?>)layerGroup);
	}
	
	// endregion
	// region Popup
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-bindpopup">Leaflet docs</a>
	 */
	public S bindPopup(final String content, final LPopupOptions options)
	{
		this.invokeSelf(
			".bindPopup($0" + this.componentRegistry().writeOptionsOptionalNextParameter(options) + ")",
			content);
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-bindpopup">Leaflet docs</a>
	 */
	public S bindPopup(final String content)
	{
		return this.bindPopup(content, null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-bindpopup">Leaflet docs</a>
	 */
	public S bindPopup(final LPopup popup)
	{
		this.invokeSelf(".bindPopup(" + popup.clientComponentJsAccessor() + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-unbindpopup">Leaflet docs</a>
	 */
	public S unbindPopup()
	{
		this.invokeSelf(".unbindPopup()");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-togglepopup">Leaflet docs</a>
	 */
	public S togglePopup()
	{
		this.invokeSelf(".togglePopup()");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-openpopup">Leaflet docs</a>
	 */
	public S openPopup(final LLatLng latLng)
	{
		this.invokeSelf(".openPopup(" + (latLng != null ? latLng.clientComponentJsAccessor() : "") + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-openpopup">Leaflet docs</a>
	 */
	public S openPopup()
	{
		return this.openPopup(null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-closepopup">Leaflet docs</a>
	 */
	public S closePopup()
	{
		this.invokeSelf(".closePopup()");
		return this.self();
	}
	
	// endregion
	// region Tooltip
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-bindtooltip">Leaflet docs</a>
	 */
	public S bindTooltip(final String content, final LTooltipOptions options)
	{
		this.invokeSelf(
			".bindTooltip($0" + this.componentRegistry().writeOptionsOptionalNextParameter(options) + ")",
			content);
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-bindtooltip">Leaflet docs</a>
	 */
	public S bindTooltip(final String content)
	{
		return this.bindTooltip(content, null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-bindtooltip">Leaflet docs</a>
	 */
	public S bindTooltip(final LTooltip tooltip)
	{
		this.invokeSelf(".bindTooltip(" + tooltip.clientComponentJsAccessor() + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-unbindtooltip">Leaflet docs</a>
	 */
	public S unbindTooltip()
	{
		this.invokeSelf(".unbindTooltip()");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-toggletooltip">Leaflet docs</a>
	 */
	public S toggleTooltip()
	{
		this.invokeSelf(".toggleTooltip()");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-opentooltip">Leaflet docs</a>
	 */
	public S openTooltip(final LLatLng latLng)
	{
		this.invokeSelf(".openTooltip(" + (latLng != null ? latLng.clientComponentJsAccessor() : "") + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-opentooltip">Leaflet docs</a>
	 */
	public S openTooltip()
	{
		return this.openPopup(null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layer-closetooltip">Leaflet docs</a>
	 */
	public S closeTooltip()
	{
		this.invokeSelf(".closeTooltip()");
		return this.self();
	}
	
	// endregion
}
