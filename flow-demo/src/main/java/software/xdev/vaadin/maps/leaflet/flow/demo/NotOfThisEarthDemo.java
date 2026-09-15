package software.xdev.vaadin.maps.leaflet.flow.demo;

import java.util.Map;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.router.Route;

import software.xdev.vaadin.maps.leaflet.MapContainer;
import software.xdev.vaadin.maps.leaflet.basictypes.LLatLng;
import software.xdev.vaadin.maps.leaflet.basictypes.LLatLngBounds;
import software.xdev.vaadin.maps.leaflet.crs.LCRS;
import software.xdev.vaadin.maps.leaflet.layer.raster.LImageOverlay;
import software.xdev.vaadin.maps.leaflet.layer.ui.LMarker;
import software.xdev.vaadin.maps.leaflet.layer.vector.LPolyline;
import software.xdev.vaadin.maps.leaflet.map.LMap;
import software.xdev.vaadin.maps.leaflet.map.LMapOptions;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;
import software.xdev.vaadin.maps.leaflet.registry.LDefaultComponentManagementRegistry;


@Route(NotOfThisEarthDemo.NAV)
@SuppressWarnings("checkstyle:MagicNumber")
public class NotOfThisEarthDemo extends AbstractDemo
{
	public static final String NAV = "not-of-this-earth";
	
	private final LComponentManagementRegistry reg;
	
	public NotOfThisEarthDemo()
	{
		// Let the view use 100% of the site
		this.setSizeFull();
		
		this.add(new Anchor("https://leafletjs.com/examples/crs-simple/crs-simple.html", "Based on this example"));
		
		// Create the registry which is needed so that components can be reused and their methods invoked
		// Note: You normally don't need to invoke any methods of the registry and just hand it over to the components
		this.reg = new LDefaultComponentManagementRegistry(this);
		
		this.buildMap();
	}
	
	private void buildMap()
	{
		// Create and add the MapContainer (which contains the map) to the UI
		final MapContainer mapContainer = new MapContainer(
			this.reg,
			new LMapOptions()
				.withCrs(LCRS.Defined.SIMPLE)
				.withMinZoom(-3));
		mapContainer.setSizeFull();
		this.add(mapContainer);
		
		final LMap map = mapContainer.getlMap();
		
		new LImageOverlay(
			this.reg,
			"uqm_map_full.png",
			new LLatLngBounds(
				this.reg,
				this.xy(-25, -26.5),
				this.xy(1023, 1021.5))
		).addTo(map);
		
		final LLatLng cordSol = this.xy(175.2, 145);
		final LLatLng cordDeneb = this.xy(218.7, 8.3);
		Map.ofEntries(
			Map.entry(cordSol, "Sol"),
			Map.entry(this.xy(41.6, 130.1), "Mizar"),
			Map.entry(this.xy(13.4, 56.5), "Krueger-Z"),
			Map.entry(cordDeneb, "Deneb")
		).forEach((cords, text) -> new LMarker(this.reg, cords)
			.bindPopup(text)
			.addTo(map));
		
		new LPolyline(this.reg, cordSol, cordDeneb)
			.addTo(map);
		
		map.setView(this.xy(300, 140), 1);
	}
	
	private LLatLng xy(final double x, final double y)
	{
		return new LLatLng(this.reg, y, x);
	}
}
