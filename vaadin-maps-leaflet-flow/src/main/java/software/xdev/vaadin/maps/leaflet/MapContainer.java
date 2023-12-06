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
package software.xdev.vaadin.maps.leaflet;

import java.util.function.Consumer;

import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.HasText;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.html.Div;

import software.xdev.vaadin.maps.leaflet.basictypes.LLatLngBounds;
import software.xdev.vaadin.maps.leaflet.map.LMap;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * Component that contains a {@link LMap} and all required client side dependencies for Vaadin.
 */
@NpmPackage(value = "leaflet", version = "1.9.4")
@Tag("leaflet-map")
@JsModule("leaflet/dist/leaflet.js")
@CssImport("leaflet/dist/leaflet.css")
public class MapContainer extends Composite<Div> implements HasSize, HasStyle, HasComponents, HasText
{
	private final LMap lMap;
	
	private Consumer<LMap> afterInitialResize;
	
	public MapContainer(final LComponentManagementRegistry reg)
	{
		this(reg, null);
	}
	
	/**
	 * @param afterInitialResize This is called after the map was initially resized/is ready.
	 *                           <p/>
	 *                           This is ONLY required when calling certain methods like e.g.
	 *                           {@link LMap#fitBounds(LLatLngBounds)} instantly after the map is created.
	 *                           <p/>
	 *                           For performance reasons it's highly recommended to only use this when required.
	 */
	public MapContainer(
		final LComponentManagementRegistry reg,
		final Consumer<LMap> afterInitialResize)
	{
		this.afterInitialResize = afterInitialResize;
		this.getContent().setSizeFull();
		this.fixZIndex();
		
		this.lMap = new LMap(reg, this.getContent());
		this.fixInitialSizeAfterCreation();
	}
	
	protected String ensureId()
	{
		// Id is auto assigned by LMap so this will never throw
		return this.getContent().getId().orElseThrow();
	}
	
	protected void fixZIndex()
	{
		LMap.fixZIndex(this.getContent());
	}
	
	protected void fixInitialSizeAfterCreation()
	{
		this.lMap.fixInvalidSizeAfterCreation(this.afterInitialResize != null
			? "document.getElementById('" + this.ensureId() + "').$server.onInitialResize();"
			: null);
	}
	
	@ClientCallable
	public void onInitialResize()
	{
		if(this.afterInitialResize == null)
		{
			return;
		}
		
		this.afterInitialResize.accept(this.getlMap());
		// Free up
		this.afterInitialResize = null;
	}
	
	public LMap getlMap()
	{
		return this.lMap;
	}
}
