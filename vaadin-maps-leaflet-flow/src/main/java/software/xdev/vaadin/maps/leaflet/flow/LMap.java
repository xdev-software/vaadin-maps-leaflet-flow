
package software.xdev.vaadin.maps.leaflet.flow;

/*-
 * #%L
 * vaadin-maps-leaflet-flow
 * %%
 * Copyright (C) 2019 XDEV Software
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import static org.apache.commons.text.StringEscapeUtils.escapeEcmaScript;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.shared.Registration;

import software.xdev.vaadin.maps.leaflet.flow.data.LCenter;
import software.xdev.vaadin.maps.leaflet.flow.data.LComponent;
import software.xdev.vaadin.maps.leaflet.flow.data.LLayerControl;
import software.xdev.vaadin.maps.leaflet.flow.data.LTileLayer;


@NpmPackage(value = "leaflet", version = "1.8.0")
@Tag("leaflet-map")
@JsModule("leaflet/dist/leaflet.js")
@CssImport("leaflet/dist/leaflet.css")
@CssImport("./leaflet/leaflet-custom.css")
public class LMap extends Component implements HasSize, HasStyle, HasComponents
{
	private static final String CLIENT_MAP = "this.map";
	private static final String CLIENT_COMPONENTS = "this.components";
	private static final String CLIENT_TILE_LAYER = "this.tilelayer";
	private final Div divMap = new Div();
	
	private LCenter center;
	private final List<LComponent> components = new ArrayList<>();
	
	public LMap()
	{
		// Default constructor
		this.setFixZIndexEnabled(true);
		
		this.divMap.setSizeFull();
		this.add(this.divMap);
		
		// bind map to div
		this.getElement().executeJs(CLIENT_MAP + "="
			+ "new L.map(this.getElementsByTagName('div')[0]);");
		this.getElement().executeJs(CLIENT_COMPONENTS + "="
			+ "new Array();");
	}
	
	public LMap(final double lat, final double lon, final int zoom)
	{
		this();
		
		this.setCenter(new LCenter(lat, lon, zoom));
		this.setViewPoint(this.center);
	}
	
	public void setZoom(final int zoom)
	{
		this.getElement().executeJs(CLIENT_MAP + ".setZoom(" + zoom + ");");
	}
	
	public void setViewPoint(final LCenter viewpoint)
	{
		this.getElement().executeJs(CLIENT_MAP + ".setView("
			+ "[" + viewpoint.getLat() + ", " + viewpoint.getLon() + "], "
			+ viewpoint.getZoom()
			+ ");");
	}
	
	public void setLayerControl(final LLayerControl layerControl)
	{
		try
		{
			final String addLayerControl = layerControl.buildClientJS() + "layerControl.addTo(" + CLIENT_MAP + ");";
			this.getElement().executeJs(addLayerControl);
		}
		catch(JsonProcessingException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	public void setTileLayer(final LTileLayer tl)
	{
		final String removeTileLayerIfPresent = "if (" + CLIENT_TILE_LAYER + ") {"
			+ CLIENT_MAP + ".removeLayer(" + CLIENT_TILE_LAYER + ");"
			+ "}";
		final String addTileLayer = CLIENT_TILE_LAYER + " = L.tileLayer("
			+ "'" + escapeEcmaScript(tl.getLink()) + "'"
			+ ",{"
			+ "attribution: '" + escapeEcmaScript(tl.getAttribution()) + "'"
			+ ", maxZoom: " + tl.getMaxZoom()
			+ (tl.getId() != null ? ", id: '" + escapeEcmaScript(tl.getId()) + "'" : "")
			+ "}"
			+ ").addTo(" + CLIENT_MAP + ");";
		this.getElement().executeJs(removeTileLayerIfPresent + "\n" + addTileLayer);
	}
	
	/**
	 * This fixes situations where the leafletmap overlays components like Dialogs
	 *
	 * @param enabled enable or disable the fix
	 */
	protected void setFixZIndexEnabled(final boolean enabled)
	{
		this.getStyle().set("z-index", enabled ? "1" : null);
	}
	
	/**
	 * add Leaflet component(s) to the map
	 */
	public void addLComponents(final LComponent... lComponents)
	{
		this.addLComponents(Arrays.asList(lComponents));
	}
	
	/**
	 * add Leaflet components to the map
	 */
	public void addLComponents(final Collection<LComponent> lComponents)
	{
		for(final LComponent lComponent : lComponents)
		{
			this.addLComponent(lComponent);
		}
	}
	
	protected void addLComponent(final LComponent lComponent)
	{
		this.getComponents().add(lComponent);
		try
		{
			this.getElement().executeJs(lComponent.buildClientJSItems() + "\n"
				+ "item.addTo(" + CLIENT_MAP + ");\n"
				+ (lComponent.getPopup() != null
				? "item.bindPopup('" + escapeEcmaScript(lComponent.getPopup()) + "');\n"
				: "")
				+ CLIENT_COMPONENTS + ".push(item);");
		}
		catch(final JsonProcessingException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * remove Leaflet component(s) to the map
	 */
	public void removeLComponents(final LComponent... lComponents)
	{
		this.removeLComponents(Arrays.asList(lComponents));
	}
	
	/**
	 * remove Leaflet components to the map
	 */
	public void removeLComponents(final Collection<LComponent> lComponents)
	{
		for(final LComponent lComponent : lComponents)
		{
			this.removeLComponent(lComponent);
		}
	}
	
	protected void removeLComponent(final LComponent lComponent)
	{
		final int index = this.components.indexOf(lComponent);
		
		if(index != -1 && this.components.remove(lComponent))
		{
			this.getElement().executeJs("let delItem = " + CLIENT_COMPONENTS + "[" + index + "];\n"
				+ "delItem.remove();\n"
				+ CLIENT_COMPONENTS + ".splice(" + index + ",1);");
		}
	}
	
	/**
	 * Returns a new component list
	 */
	public List<LComponent> getComponents()
	{
		return this.components;
	}
	
	public LCenter getCenter()
	{
		return this.center;
	}
	
	/**
	 * Starting Point of the map with latitude, longitude and zoom level
	 */
	public void setCenter(final LCenter start)
	{
		this.center = start;
		this.setViewPoint(start);
	}
	
	public Div getDivMap()
	{
		return this.divMap;
	}
	
	@ClientCallable
	protected void onMarkerClick(final String tag)
	{
		ComponentUtil.fireEvent(this, new MarkerClickEvent(this, true, tag));
	}
	
	public Registration addMarkerClickListener(final ComponentEventListener<MarkerClickEvent> listener)
	{
		return ComponentUtil.addListener(this, MarkerClickEvent.class, listener);
	}
	
	public class MarkerClickEvent extends ComponentEvent<LMap>
	{
		private final String tag;
		
		public MarkerClickEvent(final LMap source, final boolean fromClient, final String tag)
		{
			super(source, fromClient);
			this.tag = tag;
		}
		
		public String getTag()
		{
			return this.tag;
		}
	}
	
	@Override
	protected void onAttach(final AttachEvent attachEvent)
	{
		// https://stackoverflow.com/q/53879753
		this.getElement().executeJs("let tempMap = " + CLIENT_MAP + "\n"
			+ "setTimeout(function () { tempMap.invalidateSize(true); }, 100);");
	}
}
