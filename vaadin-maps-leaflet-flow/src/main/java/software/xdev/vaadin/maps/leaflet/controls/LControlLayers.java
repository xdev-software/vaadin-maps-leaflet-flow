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

import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.text.StringEscapeUtils;

import software.xdev.vaadin.maps.leaflet.layer.LLayer;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#control-layers">Leaflet docs</a>
 */
public class LControlLayers extends LControl<LControlLayers>
{
	public LControlLayers(
		final LComponentManagementRegistry compReg,
		final Map<String, LLayer<?>> baselayers,
		final Map<String, LLayer<?>> overlays,
		final LControlLayersOptions options)
	{
		super(compReg, "L.control.layers("
			+ (baselayers != null ? convertLayerMapToString(baselayers) : "")
			+ "," + (overlays != null ? convertLayerMapToString(overlays) : "{}")
			+ compReg.writeOptionsOptionalParameter(options)
			+ ")");
	}
	
	public LControlLayers(
		final LComponentManagementRegistry compReg,
		final Map<String, LLayer<?>> baselayers,
		final Map<String, LLayer<?>> overlays)
	{
		this(compReg, baselayers, overlays, null);
	}
	
	public LControlLayers(
		final LComponentManagementRegistry compReg,
		final Map<String, LLayer<?>> baselayers,
		final LControlLayersOptions options)
	{
		this(compReg, baselayers, null, options);
	}
	
	public LControlLayers(
		final LComponentManagementRegistry compReg,
		final Map<String, LLayer<?>> baselayers)
	{
		this(compReg, baselayers, (LControlLayersOptions)null);
	}
	
	public LControlLayers(final LComponentManagementRegistry compReg)
	{
		this(compReg, null);
	}
	
	protected static String convertLayerMapToString(final Map<String, LLayer<?>> map)
	{
		return "{"
			+ map.entrySet()
			.stream()
			.map(e -> "\"" + StringEscapeUtils.escapeEcmaScript(e.getKey()) + "\":"
				+ e.getValue().clientComponentJsAccessor())
			.collect(Collectors.joining(","))
			+ "}";
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#control-layers-addbaselayer">Leaflet docs</a>
	 */
	public LControlLayers addBaseLayer(final LLayer<?> layer, final String name)
	{
		this.invokeSelf(".addBaseLayer(" + layer.clientComponentJsAccessor() + ",$0)", name);
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#control-layers-addoverlay">Leaflet docs</a>
	 */
	public LControlLayers addOverlay(final LLayer<?> layer, final String name)
	{
		this.invokeSelf(".addOverlay(" + layer.clientComponentJsAccessor() + ",$0)", name);
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#control-layers-removelayer">Leaflet docs</a>
	 */
	public LControlLayers removeLayer(final LLayer<?> layer)
	{
		this.invokeSelf(".removeLayer(" + layer.clientComponentJsAccessor() + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#control-layers-expand">Leaflet docs</a>
	 */
	public LControlLayers expand()
	{
		this.invokeSelf(".expand()");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#control-layers-collapse">Leaflet docs</a>
	 */
	public LControlLayers collapse()
	{
		this.invokeSelf(".collapse()");
		return this.self();
	}
}
