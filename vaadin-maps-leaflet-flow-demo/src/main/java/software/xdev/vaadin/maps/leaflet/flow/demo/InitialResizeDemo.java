package software.xdev.vaadin.maps.leaflet.flow.demo;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import software.xdev.vaadin.maps.leaflet.MapContainer;
import software.xdev.vaadin.maps.leaflet.basictypes.LLatLng;
import software.xdev.vaadin.maps.leaflet.basictypes.LLatLngBounds;
import software.xdev.vaadin.maps.leaflet.layer.raster.LTileLayer;
import software.xdev.vaadin.maps.leaflet.layer.vector.LPolylineOptions;
import software.xdev.vaadin.maps.leaflet.layer.vector.LRectangle;
import software.xdev.vaadin.maps.leaflet.map.LMap;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;
import software.xdev.vaadin.maps.leaflet.registry.LDefaultComponentManagementRegistry;


@Route(InitialResizeDemo.NAV)
public class InitialResizeDemo extends VerticalLayout
{
	public static final String NAV = "/initial-resize";
	
	public InitialResizeDemo()
	{
		this.setSizeFull();
		
		final LComponentManagementRegistry reg = new LDefaultComponentManagementRegistry(this);
		
		// We want to show this area initially
		final LLatLngBounds bounds = new LLatLngBounds(
			reg,
			new LLatLng(reg, 49, 12),
			new LLatLng(reg, 50, 11)
		);
		
		final MapContainer mapContainer = new MapContainer(reg, map -> {
			// This needs to be done after the map was initially resized
			// otherwise the view is calculated incorrectly
			map.fitBounds(bounds);
		});
		mapContainer.setSizeFull();
		this.add(mapContainer);
		
		final LMap map = mapContainer.getlMap();
		map.addLayer(LTileLayer.createDefaultForOpenStreetMapTileServer(reg));
		
		// Still required as the map refuses to work otherwise
		map.setView(new LLatLng(reg, 0, 0), 1);
		
		// Create rectangle for reference
		new LRectangle(reg, bounds, new LPolylineOptions())
			.addTo(map);
	}
}
