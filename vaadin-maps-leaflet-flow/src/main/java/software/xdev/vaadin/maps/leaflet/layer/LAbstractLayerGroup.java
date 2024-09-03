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

import software.xdev.vaadin.maps.leaflet.base.has.LHasSetZIndex;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#layergroup">Leaflet docs</a>
 */
public class LAbstractLayerGroup<S extends LAbstractLayerGroup<S>> extends LLayer<S>
	implements LHasSetZIndex<S>
{
	protected LAbstractLayerGroup(
		final LComponentManagementRegistry compReg,
		final String jsConstructorCallExpression,
		final Serializable... parameters)
	{
		super(compReg, jsConstructorCallExpression, parameters);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layergroup-addlayer">Leaflet docs</a>
	 */
	public S addLayer(final LLayer<?> layer)
	{
		this.invokeSelf(".addLayer(" + layer.clientComponentJsAccessor() + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layergroup-removelayer">Leaflet docs</a>
	 */
	public S removeLayer(final LLayer<?> layer)
	{
		this.invokeSelf(".removeLayer(" + layer.clientComponentJsAccessor() + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layergroup-clearlayers">Leaflet docs</a>
	 */
	public S clearLayers()
	{
		this.invokeSelf(".clearLayers()");
		return this.self();
	}
}
