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
package software.xdev.vaadin.maps.leaflet.layer.other;

import java.io.Serializable;

import software.xdev.vaadin.maps.leaflet.layer.LLayer;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#geojson">Leaflet docs</a>
 */
public class LGeoJSONLayer extends LAbstractFeatureGroup<LGeoJSONLayer>
{
	protected LGeoJSONLayer(
		final LComponentManagementRegistry compReg,
		final String jsConstructorCallExpression,
		final Serializable... parameters)
	{
		super(compReg, jsConstructorCallExpression, parameters);
	}
	
	public LGeoJSONLayer(
		final LComponentManagementRegistry compReg,
		final String serializedGeoJSON,
		final LGeoJSONLayerOptions options)
	{
		super(
			compReg,
			"L.geoJSON("
				+ serializedGeoJSON
				+ compReg.writeOptionsOptionalNextParameter(options) + ")");
	}
	
	public LGeoJSONLayer(
		final LComponentManagementRegistry compReg,
		final String serializedGeoJSON)
	{
		this(compReg, serializedGeoJSON, (LGeoJSONLayerOptions)null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#geojson-adddata">Leaflet docs</a>
	 */
	public LGeoJSONLayer addData(final String serializedGeoJSON)
	{
		this.invokeSelf(".addLayer(" + serializedGeoJSON + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#geojson-resetstyle">Leaflet docs</a>
	 */
	public LGeoJSONLayer resetStyle(final LLayer<?> layer)
	{
		this.invokeSelf(".resetStyle(" + (layer != null ? layer.clientComponentJsAccessor() : "") + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#geojson-resetstyle">Leaflet docs</a>
	 */
	public LGeoJSONLayer resetStyle()
	{
		return this.resetStyle(null);
	}
	
}
