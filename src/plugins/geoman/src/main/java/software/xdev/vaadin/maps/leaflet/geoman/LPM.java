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
package software.xdev.vaadin.maps.leaflet.geoman;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

import software.xdev.vaadin.maps.leaflet.base.LAbstractComponent;
import software.xdev.vaadin.maps.leaflet.layer.LLayer;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://geoman.io/docs/leaflet/">Docs</a>
 */
@NpmPackage(value = "@geoman-io/leaflet-geoman-free", version = "2.18.3")
@JsModule("@geoman-io/leaflet-geoman-free/dist/leaflet-geoman.js")
@CssImport("@geoman-io/leaflet-geoman-free/dist/leaflet-geoman.css")
public class LPM extends LAbstractComponent<LPM>
{
	public LPM(final LComponentManagementRegistry compReg)
	{
		super(compReg);
	}
	
	public LPM setOptIn(final boolean optIn)
	{
		this.invokeSelf(".setOptIn(" + optIn + ")");
		return this;
	}
	
	public LPM reInitLayer(final LLayer<?> layer)
	{
		this.invokeSelf(".reInitLayer(" + layer.clientComponentJsAccessor() + ")");
		return this;
	}
	
	@Override
	public String clientComponentJsAccessor()
	{
		return "L.PM";
	}
}
