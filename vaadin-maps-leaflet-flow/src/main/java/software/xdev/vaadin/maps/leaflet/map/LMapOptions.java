package software.xdev.vaadin.maps.leaflet.map;

import software.xdev.vaadin.maps.leaflet.base.LComponentOptions;
import software.xdev.vaadin.maps.leaflet.basictypes.LLatLng;

// TODO with and abstraction?
/**
 * <a href="https://leafletjs.com/reference.html#map-example">Documentation</a>
 */
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
	private Integer zoomSnap;
	private Integer zoomDelta;
	private Boolean trackResize;
	
	private Boolean inertia;
	private Integer inertiaDeceleration;
	private Integer inertiaMaxSpeed;
	private Double easeLinearity;
	private Boolean worldCopyJump;
	private Double maxBoundsViscosity;
	
	private Boolean keyboard;
	private Integer keyboardPanDelta;
	
	// Boolean|String
	private Object scrollWheelZoom;
	private Integer wheelDebounceTime;
	private Integer wheelPxPerZoomLevel;
	
	private Boolean tapHold;
	private Integer tapTolerance;
	// Boolean|String
	private Object touchZoom;
	private Boolean bounceAtZoomLimits;
	
	// TODO CRS
	private LLatLng center;
	private Integer zoom;
	private Integer minZoom;
	private Integer maxZoom;
	// TODO LAYERS
	// TODO maxBounds
	// TODO Renderer
	
	private Boolean zoomAnimation;
	private Integer zoomAnimationThreshold;
	private Boolean fadeAnimation;
	private Boolean markerZoomAnimation;
	private Integer transform3DLimit;
	
	public Boolean getPreferCanvas()
	{
		return this.preferCanvas;
	}
	
	public void setPreferCanvas(final Boolean preferCanvas)
	{
		this.preferCanvas = preferCanvas;
	}
	
	public Boolean getAttributionControl()
	{
		return this.attributionControl;
	}
	
	public void setAttributionControl(final Boolean attributionControl)
	{
		this.attributionControl = attributionControl;
	}
	
	public Boolean getZoomControl()
	{
		return this.zoomControl;
	}
	
	public void setZoomControl(final Boolean zoomControl)
	{
		this.zoomControl = zoomControl;
	}
	
	public Boolean getClosePopupOnClick()
	{
		return this.closePopupOnClick;
	}
	
	public void setClosePopupOnClick(final Boolean closePopupOnClick)
	{
		this.closePopupOnClick = closePopupOnClick;
	}
	
	public Boolean getBoxZoom()
	{
		return this.boxZoom;
	}
	
	public void setBoxZoom(final Boolean boxZoom)
	{
		this.boxZoom = boxZoom;
	}
	
	public Object getDoubleClickZoom()
	{
		return this.doubleClickZoom;
	}
	
	public void setDoubleClickZoom(final Object doubleClickZoom)
	{
		this.doubleClickZoom = doubleClickZoom;
	}
	
	public Boolean getDragging()
	{
		return this.dragging;
	}
	
	public void setDragging(final Boolean dragging)
	{
		this.dragging = dragging;
	}
	
	public Integer getZoomSnap()
	{
		return this.zoomSnap;
	}
	
	public void setZoomSnap(final Integer zoomSnap)
	{
		this.zoomSnap = zoomSnap;
	}
	
	public Integer getZoomDelta()
	{
		return this.zoomDelta;
	}
	
	public void setZoomDelta(final Integer zoomDelta)
	{
		this.zoomDelta = zoomDelta;
	}
	
	public Boolean getTrackResize()
	{
		return this.trackResize;
	}
	
	public void setTrackResize(final Boolean trackResize)
	{
		this.trackResize = trackResize;
	}
	
	public Boolean getInertia()
	{
		return this.inertia;
	}
	
	public void setInertia(final Boolean inertia)
	{
		this.inertia = inertia;
	}
	
	public Integer getInertiaDeceleration()
	{
		return this.inertiaDeceleration;
	}
	
	public void setInertiaDeceleration(final Integer inertiaDeceleration)
	{
		this.inertiaDeceleration = inertiaDeceleration;
	}
	
	public Integer getInertiaMaxSpeed()
	{
		return this.inertiaMaxSpeed;
	}
	
	public void setInertiaMaxSpeed(final Integer inertiaMaxSpeed)
	{
		this.inertiaMaxSpeed = inertiaMaxSpeed;
	}
	
	public Double getEaseLinearity()
	{
		return this.easeLinearity;
	}
	
	public void setEaseLinearity(final Double easeLinearity)
	{
		this.easeLinearity = easeLinearity;
	}
	
	public Boolean getWorldCopyJump()
	{
		return this.worldCopyJump;
	}
	
	public void setWorldCopyJump(final Boolean worldCopyJump)
	{
		this.worldCopyJump = worldCopyJump;
	}
	
	public Double getMaxBoundsViscosity()
	{
		return this.maxBoundsViscosity;
	}
	
	public void setMaxBoundsViscosity(final Double maxBoundsViscosity)
	{
		this.maxBoundsViscosity = maxBoundsViscosity;
	}
	
	public Boolean getKeyboard()
	{
		return this.keyboard;
	}
	
	public void setKeyboard(final Boolean keyboard)
	{
		this.keyboard = keyboard;
	}
	
	public Integer getKeyboardPanDelta()
	{
		return this.keyboardPanDelta;
	}
	
	public void setKeyboardPanDelta(final Integer keyboardPanDelta)
	{
		this.keyboardPanDelta = keyboardPanDelta;
	}
	
	public Object getScrollWheelZoom()
	{
		return this.scrollWheelZoom;
	}
	
	public void setScrollWheelZoom(final Object scrollWheelZoom)
	{
		this.scrollWheelZoom = scrollWheelZoom;
	}
	
	public Integer getWheelDebounceTime()
	{
		return this.wheelDebounceTime;
	}
	
	public void setWheelDebounceTime(final Integer wheelDebounceTime)
	{
		this.wheelDebounceTime = wheelDebounceTime;
	}
	
	public Integer getWheelPxPerZoomLevel()
	{
		return this.wheelPxPerZoomLevel;
	}
	
	public void setWheelPxPerZoomLevel(final Integer wheelPxPerZoomLevel)
	{
		this.wheelPxPerZoomLevel = wheelPxPerZoomLevel;
	}
	
	public Boolean getTapHold()
	{
		return this.tapHold;
	}
	
	public void setTapHold(final Boolean tapHold)
	{
		this.tapHold = tapHold;
	}
	
	public Integer getTapTolerance()
	{
		return this.tapTolerance;
	}
	
	public void setTapTolerance(final Integer tapTolerance)
	{
		this.tapTolerance = tapTolerance;
	}
	
	public Object getTouchZoom()
	{
		return this.touchZoom;
	}
	
	public void setTouchZoom(final Object touchZoom)
	{
		this.touchZoom = touchZoom;
	}
	
	public Boolean getBounceAtZoomLimits()
	{
		return this.bounceAtZoomLimits;
	}
	
	public void setBounceAtZoomLimits(final Boolean bounceAtZoomLimits)
	{
		this.bounceAtZoomLimits = bounceAtZoomLimits;
	}
	
	public LLatLng getCenter()
	{
		return this.center;
	}
	
	public void setCenter(final LLatLng center)
	{
		this.center = center;
	}
	
	public Integer getZoom()
	{
		return this.zoom;
	}
	
	public void setZoom(final Integer zoom)
	{
		this.zoom = zoom;
	}
	
	public Integer getMinZoom()
	{
		return this.minZoom;
	}
	
	public void setMinZoom(final Integer minZoom)
	{
		this.minZoom = minZoom;
	}
	
	public Integer getMaxZoom()
	{
		return this.maxZoom;
	}
	
	public void setMaxZoom(final Integer maxZoom)
	{
		this.maxZoom = maxZoom;
	}
	
	public Boolean getZoomAnimation()
	{
		return this.zoomAnimation;
	}
	
	public void setZoomAnimation(final Boolean zoomAnimation)
	{
		this.zoomAnimation = zoomAnimation;
	}
	
	public Integer getZoomAnimationThreshold()
	{
		return this.zoomAnimationThreshold;
	}
	
	public void setZoomAnimationThreshold(final Integer zoomAnimationThreshold)
	{
		this.zoomAnimationThreshold = zoomAnimationThreshold;
	}
	
	public Boolean getFadeAnimation()
	{
		return this.fadeAnimation;
	}
	
	public void setFadeAnimation(final Boolean fadeAnimation)
	{
		this.fadeAnimation = fadeAnimation;
	}
	
	public Boolean getMarkerZoomAnimation()
	{
		return this.markerZoomAnimation;
	}
	
	public void setMarkerZoomAnimation(final Boolean markerZoomAnimation)
	{
		this.markerZoomAnimation = markerZoomAnimation;
	}
	
	public Integer getTransform3DLimit()
	{
		return this.transform3DLimit;
	}
	
	public void setTransform3DLimit(final Integer transform3DLimit)
	{
		this.transform3DLimit = transform3DLimit;
	}
}
