package software.xdev.vaadin.maps.leaflet.flow.demo;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import software.xdev.vaadin.maps.leaflet.MapContainer;
import software.xdev.vaadin.maps.leaflet.base.RawString;
import software.xdev.vaadin.maps.leaflet.basictypes.LLatLng;
import software.xdev.vaadin.maps.leaflet.layer.other.LGeoJSONLayer;
import software.xdev.vaadin.maps.leaflet.layer.other.LGeoJSONLayerOptions;
import software.xdev.vaadin.maps.leaflet.layer.raster.LTileLayer;
import software.xdev.vaadin.maps.leaflet.map.LMap;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;
import software.xdev.vaadin.maps.leaflet.registry.LDefaultComponentManagementRegistry;


@Route(GeoJSONDemo.NAV)
@SuppressWarnings("checkstyle:MagicNumber")
public class GeoJSONDemo extends VerticalLayout
{
	public static final String NAV = "/geojson";
	
	public GeoJSONDemo()
	{
		// Let the view use 100% of the site
		this.setSizeFull();
		
		this.add(new Anchor("https://leafletjs.com/examples/geojson", "Based on this example"));
		
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
		map.setView(new LLatLng(reg, 39.75621, -104.99404), 17);
		
		// Handle GeoJSON
		final String serializedGeoJSON = """
			{
			    "type": "Feature",
			    "properties": {
			        "name": "Coors Field",
			        "amenity": "Baseball Stadium",
			        "popupContent": "This is where the Rockies play!"
			    },
			    "geometry": {
			        "type": "Point",
			        "coordinates": [-104.99404, 39.75621]
			    }
			}
			""";
		new LGeoJSONLayer(
			reg,
			serializedGeoJSON,
			new LGeoJSONLayerOptions()
				.withOnEachFeature(new RawString("(feature, layer) => { "
					+ "    if (feature.properties && feature.properties.popupContent) { "
					+ "        layer.bindPopup(feature.properties.popupContent); "
					+ "    }"
					+ " }"))
		)
			.addTo(map);
	}
}
