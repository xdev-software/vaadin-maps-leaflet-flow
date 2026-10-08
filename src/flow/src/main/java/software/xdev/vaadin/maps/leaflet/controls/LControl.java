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
package software.xdev.vaadin.maps.leaflet.controls;

import java.io.Serializable;

import software.xdev.vaadin.maps.leaflet.base.LBaseComponent;
import software.xdev.vaadin.maps.leaflet.map.LMap;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#control">Leaflet docs</a>
 */
public abstract class LControl<S extends LControl<S>> extends LBaseComponent<S>
{
	protected LControl(
		final LComponentManagementRegistry compReg,
		final String jsConstructorCallExpression,
		final Serializable... parameters)
	{
		super(compReg, jsConstructorCallExpression, parameters);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#control-setposition">Leaflet docs</a>
	 */
	public S setPosition(final String position)
	{
		this.invokeSelf(".setPosition($0)", position);
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#control-addto">Leaflet docs</a>
	 */
	public S addTo(final LMap map)
	{
		this.invokeSelf(".addTo(" + map.clientComponentJsAccessor() + ")");
		return this.self();
	}
	
	/**
	 * The possible values of position
	 *
	 * @see <a href="https://leafletjs.com/reference.html#control-position">Leaflet docs</a>
	 */
	public static final class Positions
	{
		public static final String TOP_LEFT = "topleft";
		public static final String TOP_RIGHT = "topright";
		public static final String BOTTOM_LEFT = "bottomleft";
		public static final String BOTTOM_RIGHT = "bottomright";
		
		private Positions()
		{
		}
	}
}
