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

import java.io.Serializable;

import software.xdev.vaadin.maps.leaflet.base.LComponent;
import software.xdev.vaadin.maps.leaflet.base.has.LHasBringTo;
import software.xdev.vaadin.maps.leaflet.base.has.LHasSetLatLng;
import software.xdev.vaadin.maps.leaflet.layer.LInteractiveLayer;
import software.xdev.vaadin.maps.leaflet.layer.LLayer;
import software.xdev.vaadin.maps.leaflet.map.LMap;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#divoverlay">Leaflet docs</a>
 */
public abstract class LDivOverlay<S extends LDivOverlay<S>> extends LInteractiveLayer<S>
	implements LHasBringTo<S>, LHasSetLatLng<S>
{
	protected LDivOverlay(
		final LComponentManagementRegistry compReg,
		final String jsConstructorCallExpression,
		final Serializable... parameters)
	{
		super(compReg, jsConstructorCallExpression, parameters);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#divoverlay-openon">Leaflet docs</a>
	 */
	public S openOn(final LMap map)
	{
		this.invokeSelf(".openOn(" + map.clientComponentJsAccessor() + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#divoverlay-close">Leaflet docs</a>
	 */
	public S close()
	{
		this.invokeSelf(".close()");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#divoverlay-toggle">Leaflet docs</a>
	 */
	public S toggle(final LLayer<?> layer)
	{
		this.invokeSelf(".toggle(" + (layer != null ? layer.clientComponentJsAccessor() : "") + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#divoverlay-toggle">Leaflet docs</a>
	 */
	public S toggle()
	{
		return this.toggle(null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#divoverlay-setcontent">Leaflet docs</a>
	 */
	public S setContent(final String content)
	{
		this.invokeSelf(".setContent($0)", content);
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#divoverlay-setcontent">Leaflet docs</a>
	 */
	public S setContent(final LComponent<?> content)
	{
		this.invokeSelf(".setContent($0)", content.clientComponentJsAccessor());
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#divoverlay-update">Leaflet docs</a>
	 */
	public S update()
	{
		this.invokeSelf(".update()");
		return this.self();
	}
}
