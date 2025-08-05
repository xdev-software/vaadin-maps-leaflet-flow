package software.xdev.vaadin.maps.leaflet.flow.demo.plugins;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import software.xdev.vaadin.maps.leaflet.MapContainer;
import software.xdev.vaadin.maps.leaflet.basictypes.LLatLng;
import software.xdev.vaadin.maps.leaflet.layer.other.LMarkerClusterGroup;
import software.xdev.vaadin.maps.leaflet.layer.raster.LTileLayer;
import software.xdev.vaadin.maps.leaflet.layer.ui.LMarker;
import software.xdev.vaadin.maps.leaflet.map.LMap;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;
import software.xdev.vaadin.maps.leaflet.registry.LDefaultComponentManagementRegistry;


@Route(LeafletMarkerClusterDemo.NAV)
@SuppressWarnings("checkstyle:MagicNumber")
public class LeafletMarkerClusterDemo extends VerticalLayout
{
	public static final String NAV = "/leaflet-markercluster";
	
	public LeafletMarkerClusterDemo()
	{
		// Let the view use 100% of the site
		this.setSizeFull();
		
		// Create the registry which is needed so that components can be reused and their methods invoked
		// Note: You normally don't need to invoke any methods of the registry and just hand it over to the components
		final LComponentManagementRegistry reg = new LDefaultComponentManagementRegistry(this);
		
		// Create and add the MapContainer (which contains the map) to the UI
		final MapContainer mapContainer = new MapContainer(reg);
		mapContainer.setSizeFull();
		this.add(mapContainer);
		
		final LMap map = mapContainer.getlMap();
		
		// Add a (default) TileLayer so that we can see something on the map
		map.addLayer(LTileLayer.createDefaultForOpenStreetMapTileServer(reg));
		
		// Set what part of the world should be shown
		map.setView(new LLatLng(reg, 49.1, 12), 8);
		
		final LMarkerClusterGroup markerClusterGroup = new LMarkerClusterGroup(reg);
		markerClusterGroup.addLayer(new LMarker(reg, new LLatLng(reg, 49.6756, 12.1610))
			.bindPopup("XDEV Software"));
		markerClusterGroup.addLayer(new LMarker(reg, new LLatLng(reg, 49.673800, 12.160113))
			.bindPopup("Schnitzel"));
		
		markerClusterGroup.addLayer(new LMarker(reg, new LLatLng(reg, 49.67, 12.16))
			.bindPopup("Weiden i.d.OPf."));
		markerClusterGroup.addLayer(new LMarker(reg, new LLatLng(reg, 49.44, 11.86))
			.bindPopup("Amberg"));
		markerClusterGroup.addLayer(new LMarker(reg, new LLatLng(reg, 49.33, 12.11))
			.bindPopup("Schwandorf"));
		markerClusterGroup.addLayer(new LMarker(reg, new LLatLng(reg, 49.45, 11.08))
			.bindPopup("Nürnberg"));
		markerClusterGroup.addLayer(new LMarker(reg, new LLatLng(reg, 49.02, 12.1))
			.bindPopup("Regensburg"));
		markerClusterGroup.addLayer(new LMarker(reg, new LLatLng(reg, 48.14, 11.57))
			.bindPopup("München"));
		
		map.addLayer(markerClusterGroup);
	}
}
