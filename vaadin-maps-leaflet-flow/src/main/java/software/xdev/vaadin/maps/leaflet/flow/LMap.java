
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

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.shared.Registration;

import software.xdev.vaadin.maps.leaflet.flow.data.LCenter;
import software.xdev.vaadin.maps.leaflet.flow.data.LCircle;
import software.xdev.vaadin.maps.leaflet.flow.data.LComponent;
import software.xdev.vaadin.maps.leaflet.flow.data.LMarker;
import software.xdev.vaadin.maps.leaflet.flow.data.LPolygon;
import software.xdev.vaadin.maps.leaflet.flow.data.LTileLayer;


@NpmPackage(value = "leaflet", version = "^1.6.0")
@Tag("leaflet-map")
@JsModule("./leaflet/leafletCon.js")
@CssImport(value = "./styles/LeafletMap.css")
public class LMap extends Component implements HasSize, HasStyle
{

	private static final String SET_VIEW_POINT_FUNCTION = "setViewPoint";
	private static final String ADD_CIRCLE_FUNCTION = "addCircle";
	private static final String ADD_POLYGON_FUNCTION = "addPolygon";
	private static final String ADD_MARKER_FUNCTION = "addMarker";
	private static final String DELETE_FUNCTION = "deleteItem";
	private static final String TILE_LAYER_FUNCTION = "setTileLayer";
	private static final String SET_ZOOM_FUNCTION = "setZoomLevel";

	private LCenter center;
	private final List<LComponent> items = new ArrayList<>();

	public LMap(final double lat, final double lon, final int zoom)
	{
		super();
		this.center = new LCenter(lat, lon, zoom);
		this.setViewPoint(this.center);
	}

	public LMap()
	{
		this(50.921273, 10.359164, 6);
	}

	public void setZoom(final int zoom)
	{
		this.getElement().callJsFunction(SET_ZOOM_FUNCTION, zoom);
	}

	public void setViewPoint(final LCenter viewpoint)
	{
		this.getElement().callJsFunction(SET_VIEW_POINT_FUNCTION, viewpoint.toJson());
	}

	public void setTileLayer(final LTileLayer tl)
	{
		this.getElement().callJsFunction(TILE_LAYER_FUNCTION, tl.toJson());
	}

	/**
	 * add a Leaflet Component to the map.
	 *
	 * @param lObjects
	 */
	public void addLComponent(final LComponent... lObjects)
	{
		for(final LComponent lObj : lObjects)
		{
			if(lObj instanceof LMarker)
			{
				final LMarker obj = (LMarker)lObj;
				this.items.add(obj);
				this.getElement().callJsFunction(ADD_MARKER_FUNCTION, obj.toJson());
			}
			if(lObj instanceof LPolygon)
			{
				final LPolygon obj = (LPolygon)lObj;
				this.items.add(obj);
				this.getElement().callJsFunction(ADD_POLYGON_FUNCTION, obj.toJson());
			}
			if(lObj instanceof LCircle)
			{
				final LCircle obj = (LCircle)lObj;
				this.items.add(obj);
				this.getElement().callJsFunction(ADD_CIRCLE_FUNCTION, obj.toJson());
			}
		}
	}

	public LCenter getCenter()
	{
		return this.center;
	}

	/**
	 * Starting Point of the map with latitude, longitude and zoom level
	 *
	 * @param start
	 */
	public void setCenter(final LCenter start)
	{
		this.center = start;
		this.setViewPoint(start);
	}

	public List<LComponent> getItems()
	{
		return this.items;
	}

	/**
	 * Removes a map item
	 *
	 * @param items
	 */
	public void removeItem(final LComponent... items)
	{
		for(final LComponent item : items)
		{
			final int index = this.items.indexOf(item);

			if(index != -1 && this.items.remove(item))
			{
				this.getElement().callJsFunction(DELETE_FUNCTION, index);
			}
		}
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
}
