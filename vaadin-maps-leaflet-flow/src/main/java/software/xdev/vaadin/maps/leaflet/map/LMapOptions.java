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

import software.xdev.vaadin.maps.leaflet.base.LComponentOptions;
import software.xdev.vaadin.maps.leaflet.basictypes.LLatLng;
import software.xdev.vaadin.maps.leaflet.basictypes.LLatLngBounds;
import software.xdev.vaadin.maps.leaflet.layer.LLayer;

/**
 * <a href="https://leafletjs.com/reference.html#map-option">Leaflet docs</a>
 */
@SuppressWarnings("unused")
public class LMapOptions implements LComponentOptions<LMapOptions>
{
	private Boolean preferCanvas;
	
	private Boolean attributionControl;
	private Boolean zoomControl;
	
	private Boolean closePopupOnClick;
	private Boolean boxZoom;
	// Boolean|String
	private Object doubleClickZoom;
	private Boolean dragging;
	private Number zoomSnap;
	private Number zoomDelta;
	private Boolean trackResize;
	
	private Boolean inertia;
	private Number inertiaDeceleration;
	private Number inertiaMaxSpeed;
	private Number easeLinearity;
	private Boolean worldCopyJump;
	private Number maxBoundsViscosity;
	
	private Boolean keyboard;
	private Number keyboardPanDelta;
	
	// Boolean|String
	private Object scrollWheelZoom;
	private Number wheelDebounceTime;
	private Number wheelPxPerZoomLevel;
	
	private Boolean tapHold;
	private Number tapTolerance;
	// Boolean|String
	private Object touchZoom;
	private Boolean bounceAtZoomLimits;
	
	private Object crs;
	private LLatLng center;
	private Number zoom;
	private Number minZoom;
	private Number maxZoom;
	private LLayer<?>[] layers;
	private LLatLngBounds maxBounds;
	
	private Boolean zoomAnimation;
	private Number zoomAnimationThreshold;
	private Boolean fadeAnimation;
	private Boolean markerZoomAnimation;
	private Number transform3DLimit;
	
	public Boolean getPreferCanvas()
	{
		return this.preferCanvas;
	}
	
	public void setPreferCanvas(final Boolean preferCanvas)
	{
		this.preferCanvas = preferCanvas;
	}
	
	public LMapOptions withPreferCanvas(final Boolean preferCanvas)
	{
		this.setPreferCanvas(preferCanvas);
		return this.self();
	}
	
	public Boolean getAttributionControl()
	{
		return this.attributionControl;
	}
	
	public void setAttributionControl(final Boolean attributionControl)
	{
		this.attributionControl = attributionControl;
	}
	
	public LMapOptions withAttributionControl(final Boolean attributionControl)
	{
		this.setAttributionControl(attributionControl);
		return this.self();
	}
	
	public Boolean getZoomControl()
	{
		return this.zoomControl;
	}
	
	public void setZoomControl(final Boolean zoomControl)
	{
		this.zoomControl = zoomControl;
	}
	
	public LMapOptions withZoomControl(final Boolean zoomControl)
	{
		this.setZoomControl(zoomControl);
		return this.self();
	}
	
	public Boolean getClosePopupOnClick()
	{
		return this.closePopupOnClick;
	}
	
	public void setClosePopupOnClick(final Boolean closePopupOnClick)
	{
		this.closePopupOnClick = closePopupOnClick;
	}
	
	public LMapOptions withClosePopupOnClick(final Boolean closePopupOnClick)
	{
		this.setClosePopupOnClick(closePopupOnClick);
		return this.self();
	}
	
	public Boolean getBoxZoom()
	{
		return this.boxZoom;
	}
	
	public void setBoxZoom(final Boolean boxZoom)
	{
		this.boxZoom = boxZoom;
	}
	
	public LMapOptions withBoxZoom(final Boolean boxZoom)
	{
		this.setBoxZoom(boxZoom);
		return this.self();
	}
	
	public Object getNumberClickZoom()
	{
		return this.doubleClickZoom;
	}
	
	public void setNumberClickZoom(final Object doubleClickZoom)
	{
		this.doubleClickZoom = doubleClickZoom;
	}
	
	public LMapOptions withNumberClickZoom(final Object doubleClickZoom)
	{
		this.setNumberClickZoom(doubleClickZoom);
		return this.self();
	}
	
	public Boolean getDragging()
	{
		return this.dragging;
	}
	
	public void setDragging(final Boolean dragging)
	{
		this.dragging = dragging;
	}
	
	public LMapOptions withDragging(final Boolean dragging)
	{
		this.setDragging(dragging);
		return this.self();
	}
	
	public Number getZoomSnap()
	{
		return this.zoomSnap;
	}
	
	public void setZoomSnap(final Number zoomSnap)
	{
		this.zoomSnap = zoomSnap;
	}
	
	public LMapOptions withZoomSnap(final Number zoomSnap)
	{
		this.setZoomSnap(zoomSnap);
		return this.self();
	}
	
	public Number getZoomDelta()
	{
		return this.zoomDelta;
	}
	
	public void setZoomDelta(final Number zoomDelta)
	{
		this.zoomDelta = zoomDelta;
	}
	
	public LMapOptions withZoomDelta(final Number zoomDelta)
	{
		this.setZoomDelta(zoomDelta);
		return this.self();
	}
	
	public Boolean getTrackResize()
	{
		return this.trackResize;
	}
	
	public void setTrackResize(final Boolean trackResize)
	{
		this.trackResize = trackResize;
	}
	
	public LMapOptions withTrackResize(final Boolean trackResize)
	{
		this.setTrackResize(trackResize);
		return this.self();
	}
	
	public Boolean getInertia()
	{
		return this.inertia;
	}
	
	public void setInertia(final Boolean inertia)
	{
		this.inertia = inertia;
	}
	
	public LMapOptions withInertia(final Boolean inertia)
	{
		this.setInertia(inertia);
		return this.self();
	}
	
	public Number getInertiaDeceleration()
	{
		return this.inertiaDeceleration;
	}
	
	public void setInertiaDeceleration(final Number inertiaDeceleration)
	{
		this.inertiaDeceleration = inertiaDeceleration;
	}
	
	public LMapOptions withInertiaDeceleration(final Number inertiaDeceleration)
	{
		this.setInertiaDeceleration(inertiaDeceleration);
		return this.self();
	}
	
	public Number getInertiaMaxSpeed()
	{
		return this.inertiaMaxSpeed;
	}
	
	public void setInertiaMaxSpeed(final Number inertiaMaxSpeed)
	{
		this.inertiaMaxSpeed = inertiaMaxSpeed;
	}
	
	public LMapOptions withInertiaMaxSpeed(final Number inertiaMaxSpeed)
	{
		this.setInertiaMaxSpeed(inertiaMaxSpeed);
		return this.self();
	}
	
	public Number getEaseLinearity()
	{
		return this.easeLinearity;
	}
	
	public void setEaseLinearity(final Number easeLinearity)
	{
		this.easeLinearity = easeLinearity;
	}
	
	public LMapOptions withEaseLinearity(final Number easeLinearity)
	{
		this.setEaseLinearity(easeLinearity);
		return this.self();
	}
	
	public Boolean getWorldCopyJump()
	{
		return this.worldCopyJump;
	}
	
	public void setWorldCopyJump(final Boolean worldCopyJump)
	{
		this.worldCopyJump = worldCopyJump;
	}
	
	public LMapOptions withWorldCopyJump(final Boolean worldCopyJump)
	{
		this.setWorldCopyJump(worldCopyJump);
		return this.self();
	}
	
	public Number getMaxBoundsViscosity()
	{
		return this.maxBoundsViscosity;
	}
	
	public void setMaxBoundsViscosity(final Number maxBoundsViscosity)
	{
		this.maxBoundsViscosity = maxBoundsViscosity;
	}
	
	public LMapOptions withMaxBoundsViscosity(final Number maxBoundsViscosity)
	{
		this.setMaxBoundsViscosity(maxBoundsViscosity);
		return this.self();
	}
	
	public Boolean getKeyboard()
	{
		return this.keyboard;
	}
	
	public void setKeyboard(final Boolean keyboard)
	{
		this.keyboard = keyboard;
	}
	
	public LMapOptions withKeyboard(final Boolean keyboard)
	{
		this.setKeyboard(keyboard);
		return this.self();
	}
	
	public Number getKeyboardPanDelta()
	{
		return this.keyboardPanDelta;
	}
	
	public void setKeyboardPanDelta(final Number keyboardPanDelta)
	{
		this.keyboardPanDelta = keyboardPanDelta;
	}
	
	public LMapOptions withKeyboardPanDelta(final Number keyboardPanDelta)
	{
		this.setKeyboardPanDelta(keyboardPanDelta);
		return this.self();
	}
	
	public Object getScrollWheelZoom()
	{
		return this.scrollWheelZoom;
	}
	
	public void setScrollWheelZoom(final Object scrollWheelZoom)
	{
		this.scrollWheelZoom = scrollWheelZoom;
	}
	
	public LMapOptions withScrollWheelZoom(final Object scrollWheelZoom)
	{
		this.setScrollWheelZoom(scrollWheelZoom);
		return this.self();
	}
	
	public Number getWheelDebounceTime()
	{
		return this.wheelDebounceTime;
	}
	
	public void setWheelDebounceTime(final Number wheelDebounceTime)
	{
		this.wheelDebounceTime = wheelDebounceTime;
	}
	
	public LMapOptions withWheelDebounceTime(final Number wheelDebounceTime)
	{
		this.setWheelDebounceTime(wheelDebounceTime);
		return this.self();
	}
	
	public Number getWheelPxPerZoomLevel()
	{
		return this.wheelPxPerZoomLevel;
	}
	
	public void setWheelPxPerZoomLevel(final Number wheelPxPerZoomLevel)
	{
		this.wheelPxPerZoomLevel = wheelPxPerZoomLevel;
	}
	
	public LMapOptions withWheelPxPerZoomLevel(final Number wheelPxPerZoomLevel)
	{
		this.setWheelPxPerZoomLevel(wheelPxPerZoomLevel);
		return this.self();
	}
	
	public Boolean getTapHold()
	{
		return this.tapHold;
	}
	
	public void setTapHold(final Boolean tapHold)
	{
		this.tapHold = tapHold;
	}
	
	public LMapOptions withTapHold(final Boolean tapHold)
	{
		this.setTapHold(tapHold);
		return this.self();
	}
	
	public Number getTapTolerance()
	{
		return this.tapTolerance;
	}
	
	public void setTapTolerance(final Number tapTolerance)
	{
		this.tapTolerance = tapTolerance;
	}
	
	public LMapOptions withTapTolerance(final Number tapTolerance)
	{
		this.setTapTolerance(tapTolerance);
		return this.self();
	}
	
	public Object getTouchZoom()
	{
		return this.touchZoom;
	}
	
	public void setTouchZoom(final Object touchZoom)
	{
		this.touchZoom = touchZoom;
	}
	
	public LMapOptions withTouchZoom(final Object touchZoom)
	{
		this.setTouchZoom(touchZoom);
		return this.self();
	}
	
	public Boolean getBounceAtZoomLimits()
	{
		return this.bounceAtZoomLimits;
	}
	
	public void setBounceAtZoomLimits(final Boolean bounceAtZoomLimits)
	{
		this.bounceAtZoomLimits = bounceAtZoomLimits;
	}
	
	public LMapOptions withBounceAtZoomLimits(final Boolean bounceAtZoomLimits)
	{
		this.setBounceAtZoomLimits(bounceAtZoomLimits);
		return this.self();
	}
	
	public Object getCrs()
	{
		return this.crs;
	}
	
	public void setCrs(final Object crs)
	{
		this.crs = crs;
	}
	
	public LMapOptions withCrs(final Object crs)
	{
		this.setCrs(crs);
		return this.self();
	}
	
	public LLatLng getCenter()
	{
		return this.center;
	}
	
	public void setCenter(final LLatLng center)
	{
		this.center = center;
	}
	
	public LMapOptions withCenter(final LLatLng center)
	{
		this.setCenter(center);
		return this.self();
	}
	
	public Number getZoom()
	{
		return this.zoom;
	}
	
	public void setZoom(final Number zoom)
	{
		this.zoom = zoom;
	}
	
	public LMapOptions withZoom(final Number zoom)
	{
		this.setZoom(zoom);
		return this.self();
	}
	
	public Number getMinZoom()
	{
		return this.minZoom;
	}
	
	public void setMinZoom(final Number minZoom)
	{
		this.minZoom = minZoom;
	}
	
	public LMapOptions withMinZoom(final Number minZoom)
	{
		this.setMinZoom(minZoom);
		return this.self();
	}
	
	public Number getMaxZoom()
	{
		return this.maxZoom;
	}
	
	public void setMaxZoom(final Number maxZoom)
	{
		this.maxZoom = maxZoom;
	}
	
	public LMapOptions withMaxZoom(final Number maxZoom)
	{
		this.setMaxZoom(maxZoom);
		return this.self();
	}
	
	@SuppressWarnings("java:S1452") // No alternative
	public LLayer<?>[] getLayers()
	{
		return this.layers;
	}
	
	public void setLayers(final LLayer<?>[] layers)
	{
		this.layers = layers;
	}
	
	public LMapOptions withLayers(final LLayer<?>[] layers)
	{
		this.setLayers(layers);
		return this.self();
	}
	
	public LLatLngBounds getMaxBounds()
	{
		return this.maxBounds;
	}
	
	public void setMaxBounds(final LLatLngBounds maxBounds)
	{
		this.maxBounds = maxBounds;
	}
	
	public LMapOptions withMaxBounds(final LLatLngBounds maxBounds)
	{
		this.setMaxBounds(maxBounds);
		return this.self();
	}
	
	public Boolean getZoomAnimation()
	{
		return this.zoomAnimation;
	}
	
	public void setZoomAnimation(final Boolean zoomAnimation)
	{
		this.zoomAnimation = zoomAnimation;
	}
	
	public LMapOptions withZoomAnimation(final Boolean zoomAnimation)
	{
		this.setZoomAnimation(zoomAnimation);
		return this.self();
	}
	
	public Number getZoomAnimationThreshold()
	{
		return this.zoomAnimationThreshold;
	}
	
	public void setZoomAnimationThreshold(final Number zoomAnimationThreshold)
	{
		this.zoomAnimationThreshold = zoomAnimationThreshold;
	}
	
	public LMapOptions withZoomAnimationThreshold(final Number zoomAnimationThreshold)
	{
		this.setZoomAnimationThreshold(zoomAnimationThreshold);
		return this.self();
	}
	
	public Boolean getFadeAnimation()
	{
		return this.fadeAnimation;
	}
	
	public void setFadeAnimation(final Boolean fadeAnimation)
	{
		this.fadeAnimation = fadeAnimation;
	}
	
	public LMapOptions withFadeAnimation(final Boolean fadeAnimation)
	{
		this.setFadeAnimation(fadeAnimation);
		return this.self();
	}
	
	public Boolean getMarkerZoomAnimation()
	{
		return this.markerZoomAnimation;
	}
	
	public void setMarkerZoomAnimation(final Boolean markerZoomAnimation)
	{
		this.markerZoomAnimation = markerZoomAnimation;
	}
	
	public LMapOptions withMarkerZoomAnimation(final Boolean markerZoomAnimation)
	{
		this.setMarkerZoomAnimation(markerZoomAnimation);
		return this.self();
	}
	
	public Number getTransform3DLimit()
	{
		return this.transform3DLimit;
	}
	
	public void setTransform3DLimit(final Number transform3DLimit)
	{
		this.transform3DLimit = transform3DLimit;
	}
	
	public LMapOptions withTransform3DLimit(final Number transform3DLimit)
	{
		this.setTransform3DLimit(transform3DLimit);
		return this.self();
	}
}
