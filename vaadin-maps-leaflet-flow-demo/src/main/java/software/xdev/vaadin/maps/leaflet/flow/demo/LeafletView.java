package software.xdev.vaadin.maps.leaflet.flow.demo;

import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import elemental.json.JsonObject;
import elemental.json.JsonValue;
import software.xdev.vaadin.maps.leaflet.basictypes.LDivIcon;
import software.xdev.vaadin.maps.leaflet.basictypes.LDivIconOptions;
import software.xdev.vaadin.maps.leaflet.basictypes.LIcon;
import software.xdev.vaadin.maps.leaflet.basictypes.LIconOptions;
import software.xdev.vaadin.maps.leaflet.basictypes.LLatLng;
import software.xdev.vaadin.maps.leaflet.basictypes.LLatLngBounds;
import software.xdev.vaadin.maps.leaflet.basictypes.LPoint;
import software.xdev.vaadin.maps.leaflet.controls.LControlLayers;
import software.xdev.vaadin.maps.leaflet.controls.LControlLayersOptions;
import software.xdev.vaadin.maps.leaflet.layer.LLayer;
import software.xdev.vaadin.maps.leaflet.layer.LLayerGroup;
import software.xdev.vaadin.maps.leaflet.layer.raster.LImageOverlay;
import software.xdev.vaadin.maps.leaflet.layer.raster.LTileLayer;
import software.xdev.vaadin.maps.leaflet.layer.raster.LVideoOverlay;
import software.xdev.vaadin.maps.leaflet.layer.raster.LVideoOverlayOptions;
import software.xdev.vaadin.maps.leaflet.layer.ui.LMarker;
import software.xdev.vaadin.maps.leaflet.layer.ui.LMarkerOptions;
import software.xdev.vaadin.maps.leaflet.layer.vector.LPolygon;
import software.xdev.vaadin.maps.leaflet.map.LMap;
import software.xdev.vaadin.maps.leaflet.map.LMapLocateOptions;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


@Route("")
public class LeafletView extends VerticalLayout
{
	private static final String ID = "leaflet-demo-view";
	
	public LeafletView()
	{
		this.setId(ID);
		
		final Div mapContainer = new Div();
		mapContainer.setSizeFull();
		this.add(mapContainer);
		
		this.setSizeFull();
		
		final LComponentManagementRegistry reg = new LComponentManagementRegistry(this);
		
		final LMap map = new LMap(reg, mapContainer);
		
		final LLatLng center = new LLatLng(reg, 49.675126, 12.160733);
		map.setView(center, 17);
		
		final LTileLayer tlOSM = LTileLayer.createDefaultForOpenStreetMapTileServer(reg);
		final LTileLayer tlOSMHOT = new LTileLayer(
			reg,
			"https://{s}.tile.openstreetmap.fr/hot/{z}/{x}/{y}.png'",
			19,
			"&copy; <a href=\"https://www.openstreetmap.org/copyright\">OpenStreetMap</a> contributors, Tiles style by"
				+ " <a href=\"https://www.hotosm.org/\" target=\"_blank\">Humanitarian OpenStreetMap Team</a> hosted "
				+ "by <a href=\"https://openstreetmap.fr/\" target=\"_blank\">OpenStreetMap France</a>"
		);
		final LTileLayer tlTopo = new LTileLayer(
			reg,
			"https://{s}.tile.opentopomap.org/{z}/{x}/{y}.png",
			16,
			"Map data: &copy; <a href=\"https://www.openstreetmap.org/copyright\">OpenStreetMap</a> contributors, <a "
				+ "href=\"http://viewfinderpanoramas.org\">SRTM</a> | Map style: &copy; <a href=\"https://opentopomap"
				+ ".org\">OpenTopoMap</a> (<a href=\"https://creativecommons.org/licenses/by-sa/3.0/\">CC-BY-SA</a>"
		);
		
		final LDivIcon divIconInfo = new LDivIcon(reg, new LDivIconOptions()
			.withHtml("""
				<div style="white-space:nowrap; padding: 0.5em">
				<center><b>Welcome to Weiden in der Oberpfalz!</b></center>
				This demo shows you different markers,<br> popups, polygons and other stuff
				</div>
				""")
			.withIconSize(new LPoint(reg, -1, -1)));
		new LMarker(
			reg,
			new LLatLng(reg, 49.674662, 12.162869),
			new LMarkerOptions().withIcon(divIconInfo)).addTo(map);
		
		final LIcon iconXDEV = new LIcon(reg, new LIconOptions()
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
			.withIconSize(new LPoint(reg, 125, 25)));
		
		final LMarker markerXDEV =
			new LMarker(reg, new LLatLng(reg, 49.675806, 12.1609901), new LMarkerOptions().withIcon(iconXDEV));
		markerXDEV.bindPopup("<a href='https://xdev.software' target='_blank'>XDEV Software GmbH</a>");
		markerXDEV.on("click", "e => document.getElementById('" + ID + "').$server.markerClicked(e.latlng)");
		
		final LPolygon polygonNOC = new LPolygon(
			reg,
			new LLatLng(reg, 49.674883, 12.159098),
			new LLatLng(reg, 49.675719, 12.160248),
			new LLatLng(reg, 49.676080, 12.159985),
			new LLatLng(reg, 49.675750, 12.158008),
			new LLatLng(reg, 49.675306, 12.158499));
		
		final LMarker markerPizza = new LMarker(reg, new LLatLng(reg, 49.674413, 12.160925))
			.bindPopup("Pizza");
		
		final LMarker markerSchnitzel = new LMarker(reg, new LLatLng(reg, 49.673800, 12.160113))
			.bindPopup("Schnitzel");
		
		final LLayerGroup lLayerGroupPlaces = new LLayerGroup(reg)
			.addLayer(markerXDEV)
			.addLayer(polygonNOC);
		final LLayerGroup lLayerGroupFood = new LLayerGroup(reg, markerPizza, markerSchnitzel);
		
		final LinkedHashMap<String, LLayer<?>> baseLayers = new LinkedHashMap<>();
		baseLayers.put("OSM", tlOSM);
		baseLayers.put("OSM HOT", tlOSMHOT);
		baseLayers.put("TOPO", tlTopo);
		new LControlLayers(
			reg,
			baseLayers,
			new LControlLayersOptions().withCollapsed(false))
			.addOverlay(lLayerGroupPlaces, "Places")
			.addOverlay(lLayerGroupFood, "Food")
			.addTo(map);
		
		// Add default layers
		map.addLayer(tlOSM)
			.addLayer(lLayerGroupPlaces);
		
		final HorizontalLayout hlButtons = new HorizontalLayout();
		hlButtons.setWidthFull();
		this.add(hlButtons);
		
		map.on(
			"locationerror",
			"e => alert('Failed to locate: ' "
				+ "+ '\\nCode: ' + e.code "
				+ "+ '\\nMessage: ' + e.message"
				+ ")");
		map.on(
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
		hlButtons.add(new Button("Locate", ev -> map.locate(new LMapLocateOptions().withSetView(true))));
		
		final LImageOverlay imageOverlay = new LImageOverlay(
			reg,
			"https://maps.lib.utexas.edu/maps/historical/newark_nj_1922.jpg",
			new LLatLngBounds(
				reg,
				new LLatLng(reg, 40.712216, -74.22655),
				new LLatLng(reg, 40.773941, -74.12544)
			)
		);
		hlButtons.add(this.createToggleButton(
			"Show image",
			"Hide image",
			() -> {
				imageOverlay.addTo(map);
				map.setView(new LLatLng(reg, 40.74, -74.17), 12);
			},
			imageOverlay::remove
		));
		
		final LVideoOverlay videoOverlay = new LVideoOverlay(
			reg,
			"https://www.mapbox.com/bites/00188/patricia_nasa.webm",
			new LLatLngBounds(
				reg,
				new LLatLng(reg, 32, -130),
				new LLatLng(reg, 13, -100)
			),
			new LVideoOverlayOptions().withAttribution(
				"<a href='https://www.youtube.com/watch?v=ZcxBOQTOb2Q'>NASA</a>"));
		hlButtons.add(this.createToggleButton(
			"Show video",
			"Hide video",
			() -> {
				videoOverlay.addTo(map);
				// Start video 30s in (otherwise no hurricane - boring)
				videoOverlay.invokeSelf(".getElement().currentTime=30");
				
				map.setView(new LLatLng(reg, 20, -115), 5);
				
				// Play otherwise stops after hiding
				videoOverlay.invokeSelf(".getElement()?.play()");
			},
			videoOverlay::remove
		));
	}
	
	private Button createToggleButton(
		final String showText,
		final String hideText,
		final Runnable onShow,
		final Runnable onHide)
	{
		final AtomicBoolean shown = new AtomicBoolean(false);
		final Button btn = new Button(
			showText,
			ev -> {
				final boolean isShow = !shown.get();
				(isShow ? onShow : onHide).run();
				ev.getSource().setText(isShow ? hideText : showText);
				
				shown.set(isShow);
				
				ev.getSource().setEnabled(true);
			}
		);
		btn.setDisableOnClick(true);
		return btn;
	}
	
	@ClientCallable
	public void markerClicked(final JsonValue input)
	{
		if(!(input instanceof final JsonObject obj))
		{
			return;
		}
		
		System.out.println("Marker clicked: lat: " + obj.getNumber("lat") + ", lng: " + obj.getNumber("lng"));
	}
}
