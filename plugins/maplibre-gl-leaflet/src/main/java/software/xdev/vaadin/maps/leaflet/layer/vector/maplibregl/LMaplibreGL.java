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
package software.xdev.vaadin.maps.leaflet.layer.vector.maplibregl;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

import software.xdev.vaadin.maps.leaflet.layer.LLayer;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * Layer for MaplibreGL
 *
 * @see <a href="https://github.com/maplibre/maplibre-gl-leaflet/blob/main/API.md">MapLibre-GL-Leaflet API docs</a>
 */
@NpmPackage(value = "maplibre-gl", version = "5.6.1")
@NpmPackage(value = "@maplibre/maplibre-gl-leaflet", version = "0.1.3")
@JsModule("maplibre-gl/dist/maplibre-gl.js")
@CssImport("maplibre-gl/dist/maplibre-gl.css")
@JsModule("@maplibre/maplibre-gl-leaflet/leaflet-maplibre-gl.js")
public class LMaplibreGL extends LLayer<LMaplibreGL>
{
	public LMaplibreGL(
		final LComponentManagementRegistry compReg,
		final LAbstractMaplibreGLOptions<?> options)
	{
		super(compReg, "L.maplibreGL(" + compReg.writeOptionsOrEmptyObject(options) + ")");
	}
	
	public LMaplibreGL(
		final LComponentManagementRegistry compReg,
		final String style)
	{
		this(compReg, new LMaplibreGLOptions().withStyle(style));
	}
}
