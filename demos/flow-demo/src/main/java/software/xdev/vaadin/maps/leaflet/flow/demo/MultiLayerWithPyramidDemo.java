package software.xdev.vaadin.maps.leaflet.flow.demo;

import java.util.List;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.treegrid.TreeGrid;
import com.vaadin.flow.router.Route;

import software.xdev.vaadin.maps.leaflet.MapContainer;
import software.xdev.vaadin.maps.leaflet.basictypes.LLatLng;
import software.xdev.vaadin.maps.leaflet.layer.LLayerGroup;
import software.xdev.vaadin.maps.leaflet.layer.raster.LTileLayer;
import software.xdev.vaadin.maps.leaflet.layer.vector.LPolygon;
import software.xdev.vaadin.maps.leaflet.map.LMap;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;
import software.xdev.vaadin.maps.leaflet.registry.LDefaultComponentManagementRegistry;


@Route(MultiLayerWithPyramidDemo.NAV)
@SuppressWarnings("checkstyle:MagicNumber")
public class MultiLayerWithPyramidDemo extends HorizontalLayout
{
	public static final String NAV = "/multilayer";
	private static final String WIKIPEDIA_THUMB = "https://upload.wikimedia.org/wikipedia/commons/thumb/";
	
	private static final List<BuildingData> DATA = List.of(
		new BuildingComplex(
			"Pyramids ▲",
			List.of(
				new Building(
					"Great Pyramid of Giza",
					"https://en.wikipedia.org/wiki/Great_Pyramid_of_Giza",
					WIKIPEDIA_THUMB + "e/e3/Kheops-Pyramid.jpg/320px-Kheops-Pyramid.jpg",
					createRectangleDataPoints(29.980138, 31.133104, 29.978121, 31.135367)),
				new Building(
					"Pyramid of Khafre",
					"https://en.wikipedia.org/wiki/Pyramid_of_Khafre",
					WIKIPEDIA_THUMB + "e/e4/Khephren_009.jpg/320px-Khephren_009.jpg",
					createRectangleDataPoints(29.976912, 31.129671, 29.974964, 31.1318537)),
				new Building(
					"Pyramid of Menkaure",
					"https://en.wikipedia.org/wiki/Pyramid_of_Menkaure",
					WIKIPEDIA_THUMB
						+ "3/38/Cairo%2C_Gizeh%2C_Pyramid_of_Menkaure%2C_Egypt%2C_Oct_2005"
						+ ".jpg/320px-Cairo%2C_Gizeh%2C_Pyramid_of_Menkaure%2C_Egypt%2C_Oct_2005.jpg",
					createRectangleDataPoints(29.972898, 31.127787, 29.972039, 31.1287585)))
		),
		new BuildingComplex(
			"Other",
			List.of(
				new Building(
					"Sphinx 🐈",
					"https://en.wikipedia.org/wiki/Great_Sphinx_of_Giza",
					WIKIPEDIA_THUMB
						+ "f/f6/Great_Sphinx_of_Giza_-_20080716a.jpg/320px-Great_Sphinx_of_Giza_-_20080716a.jpg",
					List.of(
						new DataPoint(29.975283598029613, 31.137253754493454),
						new DataPoint(29.97535970910997, 31.137377101561537),
						new DataPoint(29.975335184460793, 31.13753679603173),
						new DataPoint(29.975318920391995, 31.13770108133231),
						new DataPoint(29.975354933683573, 31.137749361094116),
						new DataPoint(29.975336346179866, 31.13798405438065),
						new DataPoint(29.975286973106307, 31.137998135977842),
						new DataPoint(29.975285230526783, 31.137849943931197),
						new DataPoint(29.97525560667033, 31.137858661110414),
						new DataPoint(29.975253864090273, 31.137986066037392),
						new DataPoint(29.97520565269632, 31.137990759903126),
						new DataPoint(29.97518358000214, 31.137748690541862),
						new DataPoint(29.975196939791317, 31.1377151629295),
						new DataPoint(29.975199844093044, 31.137524055539036),
						new DataPoint(29.97517719053711, 31.13737251073115)
					)),
				new Building(
					"Tomb of Queen Khentkaus I",
					"https://en.wikipedia.org/wiki/Pyramid_of_Khentkaus_I",
					"https://upload.wikimedia.org/wikipedia/commons/b/b6/Tomb_of_Khentkaus_I.jpg",
					createRectangleDataPoints(29.973586, 31.135233, 29.973164, 31.135737)
				)
			)
		)
	);
	
	private final LComponentManagementRegistry reg;
	
	private LLayerGroup activeLayerGroup;
	
	@SuppressWarnings("PMD.UnusedAssignment") // FP activeLayerGroup is used
	public MultiLayerWithPyramidDemo()
	{
		// Let the view use 100% of the site
		this.setSizeFull();
		
		final TreeGrid<BuildingData> treeGrid = new TreeGrid<>();
		treeGrid.addHierarchyColumn(BuildingData::name)
			.setHeader("Building");
		treeGrid.setItems(DATA, BuildingData::nested);
		treeGrid.setHeightFull();
		treeGrid.setMinWidth("18em");
		treeGrid.setWidth("20%");
		
		this.add(treeGrid);
		
		// Create the registry which is needed so that components can be reused and their methods invoked
		// Note: You normally don't need to invoke any methods of the registry and just hand it over to the components
		this.reg = new LDefaultComponentManagementRegistry(this);
		
		// Create and add the MapContainer (which contains the map) to the UI
		final MapContainer mapContainer = new MapContainer(this.reg);
		mapContainer.setSizeFull();
		this.add(mapContainer);
		
		final LMap map = mapContainer.getlMap();
		
		// Add a (default) TileLayer so that we can see something on the map
		map.addLayer(LTileLayer.createDefaultForOpenStreetMapTileServer(this.reg));
		
		// Set what part of the world should be shown
		map.setView(new LLatLng(this.reg, 29.9759, 31.1350), 17);
		
		treeGrid.addSelectionListener(ev ->
		{
			if(this.activeLayerGroup != null)
			{
				this.activeLayerGroup.removeFrom(map);
				this.activeLayerGroup = null;
				
				// Free up memory if needed
				this.reg.freeUpClient();
			}
			
			ev.getFirstSelectedItem().ifPresent(buildingData -> {
				this.activeLayerGroup = new LLayerGroup(this.reg);
				
				if(buildingData instanceof final BuildingComplex complex)
				{
					complex.buildings().forEach(this::createPolygonAndAddToActiveLayerGroup);
				}
				else if(buildingData instanceof final Building building)
				{
					this.createPolygonAndAddToActiveLayerGroup(building);
				}
				
				map.addLayer(this.activeLayerGroup);
			});
		});
		
		DATA.forEach(treeGrid::expand);
		treeGrid.select(DATA.get(0));
	}
	
	private void createPolygonAndAddToActiveLayerGroup(final Building building)
	{
		new LPolygon(this.reg, building.dataPoints().stream()
			.map(dp -> new LLatLng(this.reg, dp.lat(), dp.lng()))
			.toList())
			.bindPopup(
				"<a href='" + building.url() + "' target='_blank'>"
					+ "<center><b>" + building.name() + "</b></center><br>"
					+ "<img style='width:12em' src='" + building.imageUrl() + "'>"
					+ "</a>")
			.addTo(this.activeLayerGroup);
	}
	
	record BuildingComplex(
		String name,
		List<Building> buildings
	) implements BuildingData
	{
		@Override
		public List<BuildingData> nested()
		{
			return this.buildings()
				.stream()
				.map(BuildingData.class::cast)
				.toList();
		}
	}
	
	
	record Building(
		String name,
		String url,
		String imageUrl,
		List<DataPoint> dataPoints
	) implements BuildingData
	{
		@Override
		public List<BuildingData> nested()
		{
			return List.of();
		}
	}
	
	interface BuildingData
	{
		String name();
		
		List<BuildingData> nested();
	}
	
	static List<DataPoint> createRectangleDataPoints(
		final double lat1, final double lng1,
		final double lat2, final double lng2)
	{
		return List.of(
			new DataPoint(lat1, lng1),
			new DataPoint(lat1, lng2),
			new DataPoint(lat2, lng2),
			new DataPoint(lat2, lng1)
		);
	}
	
	record DataPoint(double lat, double lng)
	{
	}
}
