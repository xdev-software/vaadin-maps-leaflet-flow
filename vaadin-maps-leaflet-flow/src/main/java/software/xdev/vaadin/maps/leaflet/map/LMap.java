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
package software.xdev.vaadin.maps.leaflet.map;

import java.util.UUID;

import com.vaadin.flow.component.html.Div;

import software.xdev.vaadin.maps.leaflet.base.LBaseComponent;
import software.xdev.vaadin.maps.leaflet.base.LEvented;
import software.xdev.vaadin.maps.leaflet.basictypes.LLatLng;
import software.xdev.vaadin.maps.leaflet.basictypes.LLatLngBounds;
import software.xdev.vaadin.maps.leaflet.basictypes.LPoint;
import software.xdev.vaadin.maps.leaflet.controls.LControl;
import software.xdev.vaadin.maps.leaflet.layer.LLayer;
import software.xdev.vaadin.maps.leaflet.layer.ui.LPopup;
import software.xdev.vaadin.maps.leaflet.layer.ui.LTooltip;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#map">Leaflet docs</a>
 */
public class LMap extends LBaseComponent<LMap> implements LEvented<LMap>
{
	// region Init
	public LMap(
		final LComponentManagementRegistry compReg,
		final String id)
	{
		this(compReg, id, null);
	}
	
	public LMap(
		final LComponentManagementRegistry compReg,
		final String id,
		final LMapOptions options)
	{
		super(compReg, "L.map($0" + compReg.writeOptionsOptionalNextParameter(options) + ")", id);
	}
	
	public LMap(
		final LComponentManagementRegistry compReg,
		final Div bindDiv)
	{
		this(compReg, bindDiv, null);
	}
	
	public LMap(
		final LComponentManagementRegistry compReg,
		final Div bindDiv,
		final LMapOptions options)
	{
		this(
			compReg,
			bindDiv.getId().orElseGet(() -> {
				final String dynamicId = "map-dynId-" + UUID.randomUUID();
				bindDiv.setId(dynamicId);
				return dynamicId;
			}),
			options);
	}
	
	/**
	 * This fixes situations where the leafletmap overlays components like Dialogs
	 */
	public static void fixZIndex(final Div div)
	{
		div.getStyle().set("z-index", "1");
	}
	
	public void fixInvalidSizeAfterCreation(final String callback)
	{
		// https://stackoverflow.com/q/53879753
		// This should no longer be required starting in Leaflet v2 https://github.com/Leaflet/Leaflet/pull/8612
		this.componentRegistry().execJs("let tempMap = " + this.clientComponentJsAccessor() + "; "
			+ "setTimeout(function () { "
			+ "  tempMap.invalidateSize(false); "
			+ (callback != null ? callback : "")
			+ " }, 100)");
	}
	
	// endregion
	// region Layer/Controls
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-addcontrol">Leaflet docs</a>
	 */
	public LMap addControl(final LControl<?> control)
	{
		this.invokeSelf(".addControl(" + control.clientComponentJsAccessor() + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-removecontrol">Leaflet docs</a>
	 */
	public LMap removeControl(final LControl<?> control)
	{
		this.invokeSelf(".removeControl(" + control.clientComponentJsAccessor() + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-addlayer">Leaflet docs</a>
	 */
	public LMap addLayer(final LLayer<?> layer)
	{
		this.invokeSelf(".addLayer(" + layer.clientComponentJsAccessor() + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-removelayer">Leaflet docs</a>
	 */
	public LMap removeLayer(final LLayer<?> layer)
	{
		this.invokeSelf(".removeLayer(" + layer.clientComponentJsAccessor() + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-openpopup">Leaflet docs</a>
	 */
	public LMap openPopup(final LPopup popup)
	{
		this.invokeSelf(".openPopup(" + popup.clientComponentJsAccessor() + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-closepopup">Leaflet docs</a>
	 */
	public LMap closePopup(final LPopup popup)
	{
		this.invokeSelf(".closePopup(" + popup.clientComponentJsAccessor() + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-closepopup">Leaflet docs</a>
	 */
	public LMap closePopup()
	{
		this.invokeSelf(".closePopup()");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-opentooltip">Leaflet docs</a>
	 */
	public LMap openTooltip(final LTooltip tooltip)
	{
		this.invokeSelf(".openTooltip(" + tooltip.clientComponentJsAccessor() + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-closetooltip">Leaflet docs</a>
	 */
	public LMap closeTooltip(final LTooltip tooltip)
	{
		this.invokeSelf(".closeTooltip(" + tooltip.clientComponentJsAccessor() + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-closetooltip">Leaflet docs</a>
	 */
	public LMap closeTooltip()
	{
		this.invokeSelf(".closeTooltip()");
		return this.self();
	}
	
	// endregion
	// region Map state
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-setview">Leaflet docs</a>
	 */
	public LMap setView(final LLatLng center, final int zoom, final LMapZoomPanOptions options)
	{
		this.invokeSelf(".setView("
			+ center.clientComponentJsAccessor()
			+ "," + zoom
			+ this.componentRegistry().writeOptionsOptionalNextParameter(options)
			+ ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-setview">Leaflet docs</a>
	 */
	public LMap setView(final LLatLng center, final int zoom)
	{
		return this.setView(center, zoom, null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-zoomin">Leaflet docs</a>
	 */
	public LMap zoomIn(final Integer delta, final LMapZoomOptions options)
	{
		this.invokeSelf(".zoomIn("
			+ (delta != null ? delta : "")
			+ this.componentRegistry().writeOptionsOptionalNextParameter(options)
			+ ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-zoomin">Leaflet docs</a>
	 */
	public LMap zoomIn(final Integer delta)
	{
		return this.zoomIn(delta, null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-zoomin">Leaflet docs</a>
	 */
	public LMap zoomIn()
	{
		return this.zoomIn(null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-zoomout">Leaflet docs</a>
	 */
	public LMap zoomOut(final Integer delta, final LMapZoomOptions options)
	{
		this.invokeSelf(".zoomOut("
			+ (delta != null ? delta : "")
			+ this.componentRegistry().writeOptionsOptionalNextParameter(options)
			+ ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-zoomout">Leaflet docs</a>
	 */
	public LMap zoomOut(final Integer delta)
	{
		return this.zoomOut(delta, null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-zoomout">Leaflet docs</a>
	 */
	public LMap zoomOut()
	{
		return this.zoomOut(null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-setzoomaround">Leaflet docs</a>
	 */
	public LMap setZoomAround(final LLatLng latLng, final int zoom, final LMapZoomOptions options)
	{
		this.invokeSelf(
			".setZoomAround("
				+ latLng.clientComponentJsAccessor()
				+ ",$0"
				+ this.componentRegistry().writeOptionsOptionalNextParameter(options)
				+ ")",
			zoom);
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-setzoomaround">Leaflet docs</a>
	 */
	public LMap setZoomAround(final LLatLng latLng, final int zoom)
	{
		return this.setZoomAround(latLng, zoom, null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-setzoomaround">Leaflet docs</a>
	 */
	public LMap setZoomAround(final LPoint point, final int zoom, final LMapZoomOptions options)
	{
		this.invokeSelf(
			".setZoomAround("
				+ point.clientComponentJsAccessor()
				+ ",$0"
				+ this.componentRegistry().writeOptionsOptionalNextParameter(options)
				+ ")",
			zoom);
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-setzoomaround">Leaflet docs</a>
	 */
	public LMap setZoomAround(final LPoint point, final int zoom)
	{
		return this.setZoomAround(point, zoom, null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-fitbounds">Leaflet docs</a>
	 */
	public LMap fitBounds(final LLatLngBounds bounds, final LMapFitBoundOptions options)
	{
		this.invokeSelf(
			".fitBounds("
				+ bounds.clientComponentJsAccessor()
				+ this.componentRegistry().writeOptionsOptionalNextParameter(options)
				+ ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-fitbounds">Leaflet docs</a>
	 */
	public LMap fitBounds(final LLatLngBounds bounds)
	{
		return this.fitBounds(bounds, null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-fitworld">Leaflet docs</a>
	 */
	public LMap fitWorld(final LMapFitBoundOptions options)
	{
		this.invokeSelf(
			".fitWorld("
				+ this.componentRegistry().writeOptions(options)
				+ ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-fitworld">Leaflet docs</a>
	 */
	public LMap fitWorld()
	{
		return this.fitWorld(null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-panto">Leaflet docs</a>
	 */
	public LMap panTo(final LLatLng latLng, final LMapPanOptions options)
	{
		this.invokeSelf(
			".panTo("
				+ latLng.clientComponentJsAccessor()
				+ this.componentRegistry().writeOptions(options)
				+ ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-panto">Leaflet docs</a>
	 */
	public LMap panTo(final LLatLng latLng)
	{
		return this.panTo(latLng, null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-panby">Leaflet docs</a>
	 */
	public LMap panBy(final LPoint offset, final LMapPanOptions options)
	{
		this.invokeSelf(
			".panBy("
				+ offset.clientComponentJsAccessor()
				+ this.componentRegistry().writeOptions(options)
				+ ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-panby">Leaflet docs</a>
	 */
	public LMap panBy(final LPoint offset)
	{
		return this.panBy(offset, null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-flyto">Leaflet docs</a>
	 */
	public LMap flyTo(final LLatLng latLng, final Integer zoom, final LMapZoomPanOptions options)
	{
		this.invokeSelf(
			".flyTo("
				+ latLng.clientComponentJsAccessor()
				+ (zoom != null ? "," + zoom : "")
				+ this.componentRegistry().writeOptionsOptionalNextParameter(options)
				+ ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-flyto">Leaflet docs</a>
	 */
	public LMap flyTo(final LLatLng latLng, final Integer zoom)
	{
		return this.flyTo(latLng, zoom, null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-flyto">Leaflet docs</a>
	 */
	public LMap flyTo(final LLatLng latLng)
	{
		return this.flyTo(latLng, null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-flytobounds">Leaflet docs</a>
	 */
	public LMap flyToBounds(final LLatLngBounds bounds, final LMapZoomPanOptions options)
	{
		this.invokeSelf(
			".flyToBounds("
				+ bounds.clientComponentJsAccessor()
				+ this.componentRegistry().writeOptionsOptionalNextParameter(options)
				+ ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-flytobounds">Leaflet docs</a>
	 */
	public LMap flyToBounds(final LLatLngBounds bounds)
	{
		return this.flyToBounds(bounds, null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-setmaxbounds">Leaflet docs</a>
	 */
	public LMap setMaxBounds(final LLatLngBounds bounds)
	{
		this.invokeSelf(
			".setMaxBounds("
				+ bounds.clientComponentJsAccessor()
				+ ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-setminzoom">Leaflet docs</a>
	 */
	public LMap setMinZoom(final int zoom)
	{
		this.invokeSelf(".setMinZoom($0)", zoom);
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-setmaxzoom">Leaflet docs</a>
	 */
	public LMap setMaxZoom(final int zoom)
	{
		this.invokeSelf(".setMaxZoom($0)", zoom);
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-paninsidebounds">Leaflet docs</a>
	 */
	public LMap panInsideBounds(final LLatLngBounds bounds, final LMapPanOptions options)
	{
		this.invokeSelf(
			".panInsideBounds("
				+ bounds.clientComponentJsAccessor()
				+ this.componentRegistry().writeOptionsOptionalNextParameter(options)
				+ ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-paninsidebounds">Leaflet docs</a>
	 */
	public LMap panInsideBounds(final LLatLngBounds bounds)
	{
		return this.panInsideBounds(bounds, null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-paninside">Leaflet docs</a>
	 */
	public LMap panInside(final LLatLng latLng, final LMapPanOptions options)
	{
		this.invokeSelf(
			".panInside("
				+ latLng.clientComponentJsAccessor()
				+ this.componentRegistry().writeOptionsOptionalNextParameter(options)
				+ ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-paninside">Leaflet docs</a>
	 */
	public LMap panInside(final LLatLng latLng)
	{
		return this.panInside(latLng, null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-invalidatesize">Leaflet docs</a>
	 */
	public LMap invalidateSize(final LMapZoomPanOptions options)
	{
		this.invokeSelf(".invalidateSize("
			+ this.componentRegistry().writeOptions(options)
			+ ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-invalidatesize">Leaflet docs</a>
	 */
	public LMap invalidateSize(final boolean animate)
	{
		this.invokeSelf(".invalidateSize($0)", animate);
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-stop">Leaflet docs</a>
	 */
	public LMap stop()
	{
		this.invokeSelf(".stop()");
		return this.self();
	}
	
	// endregion
	// region Geolocation
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-locate">Leaflet docs</a>
	 */
	public LMap locate(final LMapLocateOptions options)
	{
		this.invokeSelf(".locate(" + this.componentRegistry().writeOptions(options) + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-locate">Leaflet docs</a>
	 */
	public LMap locate()
	{
		return this.locate(null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-stoplocate">Leaflet docs</a>
	 */
	public LMap stopLocate()
	{
		this.invokeSelf(".stopLocate()");
		return this.self();
	}
	
	// endregion
	// region Other
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#map-remove">Leaflet docs</a>
	 */
	public LMap remove()
	{
		this.invokeSelf(".remove()");
		return this.self();
	}
	
	// endregion
}
