package software.xdev.vaadin.maps.leaflet.flow.demo;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import software.xdev.vaadin.maps.leaflet.MapContainer;
import software.xdev.vaadin.maps.leaflet.basictypes.LLatLng;
import software.xdev.vaadin.maps.leaflet.controls.LControl;
import software.xdev.vaadin.maps.leaflet.controls.LControlOptions;
import software.xdev.vaadin.maps.leaflet.layer.raster.LTileLayer;
import software.xdev.vaadin.maps.leaflet.map.LMap;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;
import software.xdev.vaadin.maps.leaflet.registry.LDefaultComponentManagementRegistry;


@Route(WatermarkControlDemo.NAV)
@SuppressWarnings("checkstyle:MagicNumber")
public class WatermarkControlDemo extends VerticalLayout
{
	public static final String NAV = "/watermark-control";
	
	@SuppressWarnings("checkstyle:LineLength")
	public WatermarkControlDemo()
	{
		LWatermark.register();
		
		// Let the view use 100% of the site
		this.setSizeFull();
		
		this.add(new Anchor(
			"https://leafletjs.com/examples/extending/extending-3-controls.html#controls",
			"Based on this example"));
		
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
		
		new LWatermark(reg,
			new LWatermarkOptions()
				.withPosition(LControl.Positions.BOTTOM_LEFT)
				.withWidth("20em")
				.withSrc(
				"data:image/svg+xml;utf8,<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"1000\" height=\"200\" viewBox=\"0 0 18300 4500\">\n" +
				  "<defs>\n" +
				    "<style>\n" +
				      ".fil0{fill:%23d71e23}\n" +
				    "</style>\n" +
				  "</defs>\n" +
				  "<g>\n" +
				    "<path class=\"fil0\" d=\"M9763 10965h-920l-17-6-1503-588-1506 588-11 4-13 2-1562 148-1102 105 1064-369 2311-801-1638-633-683-263h1609l16 6 1515 588 1521-588 10-4 9-1 1388-211 1177-178-1131 441-2177 849 1675 647 682 264zM25514 9520l-1909 1442-22 17h-693l-23-19-1765-1440-285-233h907l22 17 1490 1178 1395-1177 23-19h1171zM20426 10961h-4015V9260h4126l-1 127-1 99v126h-112l-3041-3 2 322 3038 3h110l2 124 1 83 2 128h-3146v352l3035-6h112v346z\" transform=\"translate(-5400 -7700)\"/>\n" +
				    "<path class=\"fil0\" d=\"M10994 9275h2026a12150 12150 0 0 1 1368 73c292 35 559 83 798 143h1c290 73 510 158 659 254 165 106 248 229 248 368 0 134-85 254-254 359-151 94-375 180-672 256-292 76-618 132-977 170-359 37-751 56-1174 56h-2102V9275h79zm917 1354h1106c300 0 574-14 822-41 247-27 469-67 665-121h1a2470 2470 0 0 0 277-96c176-79 264-164 264-256 0-60-39-118-117-173-92-66-234-125-425-178-197-55-418-96-665-123-248-27-522-41-822-41h-1106v1029z\" transform=\"translate(-5400 -7700)\"/>\n" +
				  "</g>\n" +
				"</svg>"))
			.addTo(map);
		
		// Set what part of the world should be shown
		map.setView(new LLatLng(reg, 49.6751, 12.1607), 5);
	}
	
	public static class LWatermark extends LControl<LWatermark>
	{
		public LWatermark(
			final LComponentManagementRegistry compReg,
			final LWatermarkOptions options)
		{
			super(compReg, "L.control.watermark(" + compReg.writeOptions(options) + ")");
		}
		
		public static void register()
		{
			UI.getCurrent().getPage().executeJs(
				"L.Control.Watermark = L.Control.extend({\n" +
				    "onAdd: function(map) {\n" +
				        "var img = L.DomUtil.create('img');\n" +
				        "img.src = this.options.src;\n" +
				        "img.style.width = this.options.width;\n" +
				        "return img;\n" +
				    "},\n" +
				    
				    "onRemove: function(map) {\n" +
				        "// Nothing to do here\n" +
				    "}\n" +
				"});\n" +
				
				"L.control.watermark = function(opts) {\n" +
				    "return new L.Control.Watermark(opts);\n" +
				"}");
		}
	}
	
	public static class LWatermarkOptions extends LControlOptions<LWatermarkOptions>
	{
		private String src;
		private String width;
		
		public String getSrc()
		{
			return this.src;
		}
		
		public void setSrc(final String src)
		{
			this.src = src;
		}
		
		public LWatermarkOptions withSrc(final String src)
		{
			this.setSrc(src);
			return this.self();
		}
		
		public String getWidth()
		{
			return this.width;
		}
		
		public void setWidth(final String width)
		{
			this.width = width;
		}
		
		public LWatermarkOptions withWidth(final String width)
		{
			this.setWidth(width);
			return this.self();
		}
	}
}
