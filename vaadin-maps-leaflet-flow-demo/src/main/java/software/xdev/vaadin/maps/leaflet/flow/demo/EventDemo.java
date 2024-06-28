package software.xdev.vaadin.maps.leaflet.flow.demo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import software.xdev.vaadin.maps.leaflet.MapContainer;
import software.xdev.vaadin.maps.leaflet.basictypes.LLatLng;
import software.xdev.vaadin.maps.leaflet.layer.raster.LTileLayer;
import software.xdev.vaadin.maps.leaflet.layer.ui.LMarker;
import software.xdev.vaadin.maps.leaflet.map.LMap;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;
import software.xdev.vaadin.maps.leaflet.registry.LDefaultComponentManagementRegistry;


@Route(EventDemo.NAV)
@SuppressWarnings("checkstyle:MagicNumber")
public class EventDemo extends VerticalLayout
{
	public static final String NAV = "/event";
	
	public EventDemo()
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
		map.setView(new LLatLng(reg, 49.6751, 12.1607), 17);
		
		// Create a new marker
		new LMarker(reg, new LLatLng(reg, 49.6756, 12.1610))
			// Bind a popup which is displayed when clicking the marker
			.bindPopup("XDEV Software")
			// Add it to the map
			.addTo(map);
		
		final HorizontalLayout hlButtons = new HorizontalLayout();
		
		// Bind clickFunc to map so that it gets disposed when the map is disposed
		final String clickFuncReference = map.clientComponentJsAccessor() + ".myCoolClickFunc";
		reg.execJs(clickFuncReference + "=e => alert('You clicked: ' + e.latlng)");
		
		final String type = "click";
		hlButtons.add(new Button("Register click", ev -> map.on(type, clickFuncReference)));
		hlButtons.add(new Button("Register click once", ev -> map.once(type, clickFuncReference)));
		hlButtons.add(new Button("Unregister click", ev -> map.off(type, clickFuncReference)));
		
		hlButtons.setWidthFull();
		this.add(hlButtons);
	}
}
