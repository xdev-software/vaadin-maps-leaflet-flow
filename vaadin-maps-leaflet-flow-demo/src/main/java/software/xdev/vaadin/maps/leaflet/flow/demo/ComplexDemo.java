package software.xdev.vaadin.maps.leaflet.flow.demo;

import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

import elemental.json.JsonObject;
import elemental.json.JsonValue;
import software.xdev.vaadin.maps.leaflet.MapContainer;
import software.xdev.vaadin.maps.leaflet.basictypes.LDivIcon;
import software.xdev.vaadin.maps.leaflet.basictypes.LDivIconOptions;
import software.xdev.vaadin.maps.leaflet.basictypes.LIcon;
import software.xdev.vaadin.maps.leaflet.basictypes.LIconOptions;
import software.xdev.vaadin.maps.leaflet.basictypes.LLatLng;
import software.xdev.vaadin.maps.leaflet.basictypes.LLatLngBounds;
import software.xdev.vaadin.maps.leaflet.basictypes.LPoint;
import software.xdev.vaadin.maps.leaflet.controls.LControlLayers;
import software.xdev.vaadin.maps.leaflet.controls.LControlLayersOptions;
import software.xdev.vaadin.maps.leaflet.controls.LControlScale;
import software.xdev.vaadin.maps.leaflet.controls.LControlScaleOptions;
import software.xdev.vaadin.maps.leaflet.layer.LLayer;
import software.xdev.vaadin.maps.leaflet.layer.LLayerGroup;
import software.xdev.vaadin.maps.leaflet.layer.raster.LImageOverlay;
import software.xdev.vaadin.maps.leaflet.layer.raster.LTileLayer;
import software.xdev.vaadin.maps.leaflet.layer.raster.LVideoOverlay;
import software.xdev.vaadin.maps.leaflet.layer.raster.LVideoOverlayOptions;
import software.xdev.vaadin.maps.leaflet.layer.ui.LMarker;
import software.xdev.vaadin.maps.leaflet.layer.ui.LMarkerOptions;
import software.xdev.vaadin.maps.leaflet.layer.vector.LCircle;
import software.xdev.vaadin.maps.leaflet.layer.vector.LCircleOptions;
import software.xdev.vaadin.maps.leaflet.layer.vector.LPolygon;
import software.xdev.vaadin.maps.leaflet.layer.vector.LPolyline;
import software.xdev.vaadin.maps.leaflet.map.LMap;
import software.xdev.vaadin.maps.leaflet.map.LMapLocateOptions;
import software.xdev.vaadin.maps.leaflet.registry.LDefaultComponentManagementRegistry;


@Route(ComplexDemo.NAV)
@SuppressWarnings("checkstyle:MagicNumber")
public class ComplexDemo extends AbstractDemo
{
	public static final String NAV = "/complex";
	
	private static final Logger LOG = LoggerFactory.getLogger(ComplexDemo.class);
	private static final String ID = "leaflet-demo-view";
	
	private final LDefaultComponentManagementRegistry reg;
	private final LMap map;
	private final HorizontalLayout hlButtons = new HorizontalLayout();
	
	public ComplexDemo()
	{
		this.setId(ID);
		
		this.reg = new LDefaultComponentManagementRegistry(this);
		
		final MapContainer mapContainer = new MapContainer(this.reg);
		mapContainer.setSizeFull();
		this.add(mapContainer);
		this.setSizeFull();
		
		this.map = mapContainer.getlMap();
		
		final LLatLng center = new LLatLng(this.reg, 49.675126, 12.160733);
		this.map.setView(center, 17);
		
		final LTileLayer tlOSM = LTileLayer.createDefaultForOpenStreetMapTileServer(this.reg);
		final LTileLayer tlOSMHOT = new LTileLayer(
			this.reg,
			"https://{s}.tile.openstreetmap.fr/hot/{z}/{x}/{y}.png'",
			19,
			"&copy; <a href=\"https://www.openstreetmap.org/copyright\">OpenStreetMap</a> contributors, Tiles style by"
				+ " <a href=\"https://www.hotosm.org/\" target=\"_blank\">Humanitarian OpenStreetMap Team</a> hosted "
				+ "by <a href=\"https://openstreetmap.fr/\" target=\"_blank\">OpenStreetMap France</a>"
		);
		final LTileLayer tlTopo = new LTileLayer(
			this.reg,
			"https://{s}.tile.opentopomap.org/{z}/{x}/{y}.png",
			16,
			"Map data: &copy; <a href=\"https://www.openstreetmap.org/copyright\">OpenStreetMap</a> contributors, <a "
				+ "href=\"http://viewfinderpanoramas.org\">SRTM</a> | Map style: &copy; <a href=\"https://opentopomap"
				+ ".org\">OpenTopoMap</a> (<a href=\"https://creativecommons.org/licenses/by-sa/3.0/\">CC-BY-SA</a>"
		);
		
		final LDivIcon divIconInfo = new LDivIcon(this.reg, new LDivIconOptions()
			.withHtml("""
				<div style="white-space:nowrap; padding: 0.5em">
				<center><b>Welcome to Weiden in der Oberpfalz!</b></center>
				This demo shows you different markers,<br> popups, polygons and other stuff
				</div>
				""")
			// Set the icon size to unlimited otherwise the div collapses
			.withIconSize(new LPoint(this.reg, -1, -1)));
		final LMarker markerInfo = new LMarker(
			this.reg,
			new LLatLng(this.reg, 49.674662, 12.162869),
			new LMarkerOptions().withIcon(divIconInfo));
		
		@SuppressWarnings("checkstyle:LineLength")
		final LIcon iconXDEV = new LIcon(this.reg, new LIconOptions()
			.withIconUrl("""
				data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" width="1000" height="200" viewBox="0 0 18300 4500" style="background-color:rgba(180,180,180,0.7)">
				  <defs>
				    <style>
				      .fil0{fill:%23d71e23}
				    </style>
				  </defs>
				  <g>
				    <path class="fil0" d="M9763 10965h-920l-17-6-1503-588-1506 588-11 4-13 2-1562 148-1102 105 1064-369 2311-801-1638-633-683-263h1609l16 6 1515 588 1521-588 10-4 9-1 1388-211 1177-178-1131 441-2177 849 1675 647 682 264zM25514 9520l-1909 1442-22 17h-693l-23-19-1765-1440-285-233h907l22 17 1490 1178 1395-1177 23-19h1171zM20426 10961h-4015V9260h4126l-1 127-1 99v126h-112l-3041-3 2 322 3038 3h110l2 124 1 83 2 128h-3146v352l3035-6h112v346z" transform="translate(-5400 -7700)"/>
				    <path class="fil0" d="M10994 9275h2026a12150 12150 0 0 1 1368 73c292 35 559 83 798 143h1c290 73 510 158 659 254 165 106 248 229 248 368 0 134-85 254-254 359-151 94-375 180-672 256-292 76-618 132-977 170-359 37-751 56-1174 56h-2102V9275h79zm917 1354h1106c300 0 574-14 822-41 247-27 469-67 665-121h1a2470 2470 0 0 0 277-96c176-79 264-164 264-256 0-60-39-118-117-173-92-66-234-125-425-178-197-55-418-96-665-123-248-27-522-41-822-41h-1106v1029z" transform="translate(-5400 -7700)"/>
				  </g>
				</svg>
				""")
			.withIconSize(new LPoint(this.reg, 125, 25)));
		
		final LLatLng locationXDEV = new LLatLng(this.reg, 49.6756, 12.1610);
		final LMarker markerXDEV =
			new LMarker(this.reg, locationXDEV, new LMarkerOptions().withIcon(iconXDEV))
				.bindPopup("<a href='https://xdev.software' target='_blank'>XDEV Software GmbH</a>");
		
		final LPolygon polygonNOC = new LPolygon(
			this.reg,
			new LLatLng(this.reg, 49.674883, 12.159098),
			new LLatLng(this.reg, 49.675719, 12.160248),
			new LLatLng(this.reg, 49.676080, 12.159985),
			new LLatLng(this.reg, 49.675750, 12.158008),
			new LLatLng(this.reg, 49.675306, 12.158499));
		polygonNOC.bindPopup("NOC - NordOberpfalz Center")
			.bindTooltip("This is a tooltip<br/>You can click to open the popup");
		
		final LCircle circleFood = new LCircle(
			this.reg,
			locationXDEV,
			new LCircleOptions()
				.withRadius(400d)
				.withStroke(true)
				.withColor("#000")
				.withFill(false));
		
		final LMarker markerPizza = new LMarker(this.reg, new LLatLng(this.reg, 49.674413, 12.160925))
			.bindPopup("Pizza");
		
		final LLatLng locationSchnitzel = new LLatLng(this.reg, 49.673800, 12.160113);
		final LMarker markerSchnitzel = new LMarker(this.reg, locationSchnitzel)
			.bindPopup("Schnitzel");
		
		final LPolyline polylineToSchnitzel = new LPolyline(
			this.reg,
			locationXDEV,
			new LLatLng(this.reg, 49.675631, 12.160430),
			new LLatLng(this.reg, 49.673919, 12.160769),
			locationSchnitzel)
			.bindPopup("Route to Schnitzel");
		
		final LLayerGroup lLayerGroupPlaces = new LLayerGroup(this.reg)
			.addLayer(markerXDEV)
			.addLayer(polygonNOC)
			.addLayer(markerInfo);
		final LLayerGroup lLayerGroupFood =
			new LLayerGroup(this.reg, markerPizza, markerSchnitzel, circleFood, polylineToSchnitzel);
		
		// Add default layers
		this.map
			.addLayer(tlOSM)
			.addLayer(lLayerGroupPlaces);
		
		this.addControls(tlOSM, tlOSMHOT, tlTopo, lLayerGroupPlaces, lLayerGroupFood);
		
		this.hlButtons.setWidthFull();
		this.add(this.hlButtons);
		
		this.addEventDemo();
		
		this.addLocateDemo();
		this.addMapMethodsDemo(center);
		this.addImageOverlayDemo();
		this.addVideoOverlayDemo();
		this.addComplexPolygonDemo();
		this.addRetrieveClientSideDataDemo();
		
		this.addOpenDialogOverMapDemo();
	}
	
	private void addControls(
		final LTileLayer tlOSM,
		final LTileLayer tlOSMHOT,
		final LTileLayer tlTopo,
		final LLayerGroup lLayerGroupPlaces,
		final LLayerGroup lLayerGroupFood)
	{
		// Use LinkedHashMap for order
		final LinkedHashMap<String, LLayer<?>> baseLayers = new LinkedHashMap<>();
		baseLayers.put("OSM", tlOSM);
		baseLayers.put("OSM HOT", tlOSMHOT);
		baseLayers.put("TOPO", tlTopo);
		final LControlLayers lControlLayers = new LControlLayers(
			this.reg,
			baseLayers,
			new LControlLayersOptions().withCollapsed(false))
			.addOverlay(lLayerGroupPlaces, "Places")
			.addOverlay(lLayerGroupFood, "Food")
			.addTo(this.map);
		// Apply manual patch for https://github.com/Leaflet/Leaflet/issues/9009 as this was not released yet
		this.map.on(
			"resize",
			lControlLayers.clientComponentJsAccessor() + "._expandIfNotCollapsed",
			lControlLayers.clientComponentJsAccessor());
		
		new LControlScale(this.reg, new LControlScaleOptions()).addTo(this.map);
	}
	
	private void addEventDemo()
	{
		// See also https://vaadin.com/docs/latest/create-ui/element-api/client-server-rpc
		this.map.on("click", "e => document.getElementById('" + ID + "').$server.mapClicked(e.latlng)");
	}
	
	// This server side method will be called when the map is clicked
	@ClientCallable
	public void mapClicked(final JsonValue input)
	{
		if(!(input instanceof final JsonObject obj))
		{
			return;
		}
		
		LOG.info("Map clicked - lat: {}, lng: {}", obj.getNumber("lat"), obj.getNumber("lng"));
	}
	
	private void addLocateDemo()
	{
		this.map.on(
			"locationerror",
			"e => alert('Failed to locate: ' "
				+ "+ '\\nCode: ' + e.code "
				+ "+ '\\nMessage: ' + e.message"
				+ ")");
		this.map.on(
			"locationfound",
			"e => alert('Location successful: '"
				+ "+ '\\nLocation: ' + e.latlng "
				+ "+ '\\nBounds: ' + e.bounds?.getNorthWest() + ' ' + e.bounds?.getSouthEast() "
				+ "+ '\\nAccuracy(m): ' + e.accuracy "
				+ "+ '\\nAltitude(m): ' + e.altitude "
				+ "+ '\\nAltitudeAccuracy(m): ' + e.altitudeAccuracy "
				+ "+ '\\nHeading: ' + e.heading"
				+ "+ '\\nSpeed: ' + e.speed "
				+ ")");
		this.hlButtons.add(new Button("Locate", ev -> this.map.locate(new LMapLocateOptions().withSetView(true))));
	}
	
	private void addMapMethodsDemo(final LLatLng center)
	{
		this.hlButtons.add(new Button("Center on Weiden", ev -> this.map.setView(center, 17)));
		this.hlButtons.add(new Button("FlyTo to Weiden", ev -> this.map.flyTo(center, 17)));
	}
	
	private void addImageOverlayDemo()
	{
		final LImageOverlay imageOverlay = new LImageOverlay(
			this.reg,
			"https://maps.lib.utexas.edu/maps/historical/newark_nj_1922.jpg",
			new LLatLngBounds(
				this.reg,
				new LLatLng(this.reg, 40.712216, -74.22655),
				new LLatLng(this.reg, 40.773941, -74.12544)
			)
		);
		this.hlButtons.add(this.createToggleButton(
			"Show image",
			"Hide image",
			() -> {
				imageOverlay.addTo(this.map);
				this.map.setView(new LLatLng(this.reg, 40.74, -74.17), 12);
			},
			imageOverlay::remove
		));
	}
	
	private void addVideoOverlayDemo()
	{
		final LVideoOverlay videoOverlay = new LVideoOverlay(
			this.reg,
			"https://www.mapbox.com/bites/00188/patricia_nasa.webm",
			new LLatLngBounds(
				this.reg,
				new LLatLng(this.reg, 32, -130),
				new LLatLng(this.reg, 13, -100)
			),
			new LVideoOverlayOptions().withAttribution(
				"<a href='https://www.youtube.com/watch?v=ZcxBOQTOb2Q'>NASA</a>"));
		this.hlButtons.add(this.createToggleButton(
			"Show video",
			"Hide video",
			() -> {
				videoOverlay.addTo(this.map);
				// Start video 30s in (otherwise no hurricane - boring)
				videoOverlay.invokeSelf(".getElement().currentTime=30");
				
				this.map.setView(new LLatLng(this.reg, 20, -115), 5);
				
				// Play otherwise stops after hiding
				videoOverlay.invokeSelf(".getElement()?.play()");
			},
			videoOverlay::remove
		));
	}
	
	private void addComplexPolygonDemo()
	{
		// See also 38.871008516069516, -77.0559701487416
		final LPolygon pentagon = new LPolygon(
			this.reg,
			List.of(
				List.of(
					List.of(
						new LLatLng(this.reg, 38.872923, -77.054687),
						new LLatLng(this.reg, 38.870639, -77.053252),
						new LLatLng(this.reg, 38.868895, -77.055569),
						new LLatLng(this.reg, 38.870071, -77.058473),
						new LLatLng(this.reg, 38.872570, -77.057877)
					),
					List.of(
						new LLatLng(this.reg, 38.871749, -77.055494),
						new LLatLng(this.reg, 38.870866, -77.054932),
						new LLatLng(this.reg, 38.870225, -77.055829),
						new LLatLng(this.reg, 38.870650, -77.056901),
						new LLatLng(this.reg, 38.871607, -77.056723)
					)
				),
				List.of(
					new LLatLng(this.reg, 38.871107, -77.055903),
					new LLatLng(this.reg, 38.870990, -77.055831),
					new LLatLng(this.reg, 38.870899, -77.055950),
					new LLatLng(this.reg, 38.870961, -77.056104),
					new LLatLng(this.reg, 38.871089, -77.056072)
				)
			));
		final String imageLink =
			"https://upload.wikimedia.org/wikipedia/commons/thumb/f/f9/Building_and_ship_comparison_to_the_Pentagon2"
				+ ".svg/260px-Building_and_ship_comparison_to_the_Pentagon2.svg.png";
		pentagon.bindPopup("<a href='https://en.wikipedia.org/wiki/The_Pentagon' target='_blank'>"
			+ "<center><b>The Pentagon</b></center><br>"
			+ "<img style='width:12em' src='" + imageLink + "'>"
			+ "</a>");
		this.hlButtons.add(this.createToggleButton(
			"Show complex polygon",
			"Hide complex polygon",
			() -> {
				pentagon.addTo(this.map);
				pentagon.openPopup();
				
				this.map.setView(new LLatLng(this.reg, 38.871008, -77.055970), 17);
			},
			pentagon::remove
		));
	}
	
	private void addRetrieveClientSideDataDemo()
	{
		// Note: Usage is not recommended as clientside data can be manipulated
		this.hlButtons.add(
			new Button(
				"Get bounds",
				ev -> this.map.invokeSelfReturn(".getBounds()")
					.then(v -> Notification.show(v.toJson())))
		);
	}
	
	private void addOpenDialogOverMapDemo()
	{
		this.hlButtons.add(
			new Button("Open dialog", ev ->
			{
				final Icon icoClose = VaadinIcon.CLOSE.create();
				
				final Dialog dialog = new Dialog(icoClose);
				dialog.setDraggable(true);
				dialog.setResizable(true);
				dialog.setWidth("70vw");
				dialog.setHeight("70vh");
				dialog.open();
				
				icoClose.addClickListener(iev -> dialog.close());
			}));
	}
}
