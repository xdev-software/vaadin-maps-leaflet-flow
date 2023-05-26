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
package software.xdev.vaadin.maps.leaflet.flow;



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
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.shared.Registration;

import software.xdev.vaadin.maps.leaflet.flow.data.LCenter;
import software.xdev.vaadin.maps.leaflet.flow.data.LComponent;
import software.xdev.vaadin.maps.leaflet.flow.data.LMarker;
import software.xdev.vaadin.maps.leaflet.flow.data.LPoint;
import software.xdev.vaadin.maps.leaflet.flow.data.LTileLayer;


@NpmPackage(value = "leaflet", version = "1.8.0")
@NpmPackage(value = "leaflet.markercluster", version = "1.4.1")
@Tag("leaflet-map")
@JsModule("leaflet/dist/leaflet.js")
@JavaScript(value = "leaflet.markercluster/dist/leaflet.markercluster.js")
@CssImport("leaflet/dist/leaflet.css")
@CssImport("./leaflet/leaflet-custom.css")
@CssImport("leaflet.markercluster/dist/MarkerCluster.Default.css")
@CssImport("leaflet.markercluster/dist/MarkerCluster.css")
public class LMap extends Component implements HasSize, HasStyle, HasComponents
{
	private static final String CLIENT_MAP = "this.map";
	private static final String CLIENT_COMPONENTS = "this.components";
	private static final String CLIENT_TILE_LAYER = "this.tilelayer";
	private static final String CLIENT_CLUSTER_LAYER = "this.cluserlayer";

	private final Div divMap = new Div();
	private LCenter center;
	private final List<LComponent> components = new ArrayList<>();
	private boolean clusterEnabled = false;
	private boolean clusterLayerAdded = false;
	
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
	
	public LMap(final double lat, final double lon, final int zoom, final LTileLayer tileLayer)
	{
		this(lat, lon, zoom);
		this.setTileLayer(tileLayer);
	}
	
	public LMap(final LTileLayer tileLayer)
	{
		this();
		this.setTileLayer(tileLayer);
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
	
	/**
	 * Creates the MarkerClusterGroup layer to enable clustering LMarkers clustering
	 * @param showAlerts : if true, Cluster color will depend on the alert state of its LMarkers (defined by custom CSS) if false, default MarkerCluster css is used
	 */
	public void enableMarkerCluster(boolean showAlerts)
	{
		if(!this.clusterEnabled)
		{
			if(showAlerts)
			{
				this.getElement().executeJs(CLIENT_CLUSTER_LAYER + "="
					+ "L.markerClusterGroup({iconCreateFunction: function(cluster) {\n"
					+ "let markers = cluster.getAllChildMarkers();\n"
					+ "let cname = 'cluster-ok';\n"
					+ "for (var i = 0; i< markers.length; i++) {\n"
					+ "if (markers[i].options.alert_state) {\n"
					+ "cname = 'cluster-nok';\nbreak;\n}\n"
					+ "}\n"
					+ "return new L.DivIcon({ html: '<div><span>' + cluster.getChildCount() + '</span></div>', "
					+ "className: 'marker-cluster ' + cname, iconSize: new L.Point(40, 40) });"
					+ "}});");
			} else {
				this.getElement().executeJs(CLIENT_CLUSTER_LAYER +  " = L.markerClusterGroup();");
			}
			this.clusterEnabled = true;
		}
	}
	
	/**
	 * Once all LMarkers have been added to the map, adds the MarkerCluster and enable clustering
	 * @return true if clustering has been enabled, false if enableMarkerCluster has not been called prior to this call
	 */
	public boolean addMarkerCluster() {
		boolean added = false;
		if (this.clusterEnabled && !this.clusterLayerAdded)
		{
			this.getElement().executeJs(CLIENT_MAP + ".addLayer(" + CLIENT_CLUSTER_LAYER + ");");
			this.clusterLayerAdded = true;
			added = true;
		}
		return added;
	}
	
	/**
	 * Uses fitBounds https://leafletjs.com/reference.html#map-fitbounds
	 * to compute zoom level and center coordinates to zoom the map on the given rectangle
	 * @param noPoint : Top let point on the map
	 * @param sePoint : Bottom right point on the map
	 */
	public void centerAndZoom(final LPoint noPoint, final LPoint sePoint)
	{
		this.getElement().executeJs(CLIENT_MAP + ".fitBounds(["
			+ "[" + noPoint.getLat() + ", " + noPoint.getLon() + "],"
			+ "[" + sePoint.getLat() + ", " + sePoint.getLon() + "]"
			+ "]);");
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
	 * @param enabled
	 *            enable or disable the fix
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
			final StringBuilder sb = new StringBuilder(lComponent.buildClientJSItems());
			sb.append("\n");
			if (this.clusterEnabled && (lComponent instanceof LMarker))
			{
				sb.append(CLIENT_CLUSTER_LAYER);
				sb.append(".addLayer(item);\n");
			} else {
				sb.append("item.addTo(");
				sb.append(CLIENT_MAP);
				sb.append(");\n");
			}
			if (lComponent.getPopup() != null) {
				sb.append("item.bindPopup('");
				sb.append(escapeEcmaScript(lComponent.getPopup()));
				sb.append("');\n");
			}
			if (lComponent.getTooltip() != null) {
				sb.append("item.bindTooltip('");
				sb.append(escapeEcmaScript(lComponent.getTooltip()));
				sb.append("');\n");
			}
			sb.append(CLIENT_COMPONENTS);
			sb.append(".push(item);");
			this.getElement().executeJs(sb.toString());
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
				+ (this.clusterEnabled ? (CLIENT_CLUSTER_LAYER+".removeLayer(delItem);\n"):"delItem.remove();\n")
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
