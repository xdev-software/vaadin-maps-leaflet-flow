
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

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.dom.ElementConstants;

import software.xdev.vaadin.maps.leaflet.flow.data.Center;
import software.xdev.vaadin.maps.leaflet.flow.data.Circle;
import software.xdev.vaadin.maps.leaflet.flow.data.DivIcon;
import software.xdev.vaadin.maps.leaflet.flow.data.MapIcon;
import software.xdev.vaadin.maps.leaflet.flow.data.Marker;
import software.xdev.vaadin.maps.leaflet.flow.data.Polygon;
import software.xdev.vaadin.maps.leaflet.flow.data.TileLayer;


@NpmPackage(value = "leaflet", version = "^1.6.0")
@Tag("leaflet-map")
@JsModule("./leaflet/leafletCon.js")
public class XdevGeoMap extends Component implements HasSize
{

	private static final String SET_VIEW_POINT_FUNCTION = "setViewPoint";
	private static final String ADD_CIRCLE_FUNCTION = "addCircle";
	private static final String ADD_POLYGON_FUNCTION = "addPolygon";
	private static final String ADD_MARKER_FUNCTION = "addMarker";
	private static final String DELETE_FUNCTION = "deleteItem";

	private Center center;
	private final List<Object> items = new ArrayList<>();

	private final String id;

	private String height = "100%";
	private String width = "100%";

	public XdevGeoMap(final double lat, final double lon, final int zoom)
	{
		super();
		this.id = IdGenerator.generateId();
		this.center = new Center(lat, lon, zoom);

		this.setId(this.id);
		this.setHeight(this.height);
		this.setWidth(this.width);
		this.setViewPoint(this.center);
	}

	public void setViewPoint(final Center viewpoint)
	{
		this.getElement().callJsFunction(SET_VIEW_POINT_FUNCTION, viewpoint.toJson());
	}

	public void setTileLayer(final TileLayer tl)
	{
		this.getElement().callJsFunction("setTileLayer", tl.toJson());
	}

	public void addMarker(final Marker obj, final DivIcon icon)
	{
		this.items.add(obj);
		this.getElement().callJsFunction(ADD_MARKER_FUNCTION, obj.toJson(), icon.toJson(), true);
	}

	public void addMarker(final Marker obj, final MapIcon icon)
	{
		this.items.add(obj);
		this.getElement().callJsFunction(ADD_MARKER_FUNCTION, obj.toJson(), icon.toJson(), false);
	}

	public void addMarker(final Marker obj)
	{
		this.items.add(obj);
		this.getElement().callJsFunction(ADD_MARKER_FUNCTION, obj.toJson());
	}

	public void addPolygon(final Polygon obj)
	{
		this.items.add(obj);
		this.getElement().callJsFunction(ADD_POLYGON_FUNCTION, obj.toJson());
	}

	public void addCircle(final Circle obj)
	{
		this.items.add(obj);
		this.getElement().callJsFunction(ADD_CIRCLE_FUNCTION, obj.toJson());
	}

	/**
	 * Sets the height of the Maps component in px, em or %<br>
	 * for example: "1000px", "10em", "75%"
	 */
	@Override
	public void setHeight(final String height)
	{
		this.height = height;
		this.getElement().getStyle().set(ElementConstants.STYLE_HEIGHT, height);
	}

	/**
	 * Sets the width of the Maps component in px, em or %<br>
	 * for example: "1000px", "10em", "75%"
	 */
	@Override
	public void setWidth(final String width)
	{
		this.width = width;
		this.getElement().getStyle().set(ElementConstants.STYLE_WIDTH, width);
	}

	/**
	 * Sets width and height both to 100%
	 */
	@Override
	public void setSizeFull()
	{
		this.setHeight("100%");
		this.setWidth("100%");
	}

	public String getIdMap()
	{
		return this.id;
	}

	public Center getCenter()
	{
		return this.center;
	}

	/**
	 * Starting Point of the map with latitude, longitude and zoom level
	 *
	 * @param start
	 */
	public void setCenter(final Center start)
	{
		this.center = start;
	}

	public List<Object> getItems()
	{
		return this.items;
	}

	/**
	 * Removes a map item
	 *
	 * @param item
	 */
	public void deleteItem(final Object item)
	{
		final int index = this.items.indexOf(item);

		if(index != -1 && this.items.remove(item))
		{
			this.getElement().callJsFunction(DELETE_FUNCTION, index);
		}
	}
}
