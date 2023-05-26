package software.xdev.vaadin.maps.leaflet.flow.demo;

import java.util.Arrays;
import java.util.List;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.AnchorTarget;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import com.vaadin.flow.router.RouteAlias;
import software.xdev.vaadin.maps.leaflet.flow.LMap;
import software.xdev.vaadin.maps.leaflet.flow.data.LCenter;
import software.xdev.vaadin.maps.leaflet.flow.data.LCircle;
import software.xdev.vaadin.maps.leaflet.flow.data.LComponent;
import software.xdev.vaadin.maps.leaflet.flow.data.LDivIcon;
import software.xdev.vaadin.maps.leaflet.flow.data.LIcon;
import software.xdev.vaadin.maps.leaflet.flow.data.LMarker;
import software.xdev.vaadin.maps.leaflet.flow.data.LPoint;
import software.xdev.vaadin.maps.leaflet.flow.data.LPolygon;
import software.xdev.vaadin.maps.leaflet.flow.data.LTileLayer;


@Route("")
@CssImport("./styles/cluster-state.css")
public class LeafletView extends VerticalLayout
{
	private boolean viewLunch = false;
	
	/**
	 * UI-Components
	 */
	private final Button btnLunch = new Button("Where do XDEV employees go for lunch?");
	private final Button btnCenter = new Button("Center on Caribbean");
	private LMap map;
	
	private LMarker markerZob;
	private LMarker markerRathaus;
	
	private LCircle circleRange;
	private LMarker markerPizza;
	private LMarker markerKebab;
	private LMarker markerAsia;
	private LMarker markerGreek;
	private LMarker markerBakery;
	private LMarker markerLeberkaese;
	
	public LeafletView()
	{
		this.initMapComponents();
		
		this.btnLunch.addClickListener(this::btnLunchClick);
		final HorizontalLayout hlButtonContainer = new HorizontalLayout();
		hlButtonContainer.setWidthFull();
		hlButtonContainer.setJustifyContentMode(JustifyContentMode.BETWEEN);
		hlButtonContainer.setPadding(false);
		hlButtonContainer.setSpacing(false);
		hlButtonContainer.add(
			this.btnLunch,
			this.btnCenter,
			new Button("Open dialog over map", ev ->
			{
				final Icon icoClose = VaadinIcon.CLOSE.create();
				
				final Dialog dialog = new Dialog(icoClose);
				dialog.setWidth("50vw");
				dialog.setHeight("50vh");
				dialog.open();
				
				icoClose.addClickListener(iev -> dialog.close());
			}));
		this.btnCenter.addClickListener(e-> map.centerAndZoom(new LPoint(14.467727, -61.69703), new LPoint(16.33426,-60.921676)));
		this.add(this.map, hlButtonContainer);
		this.setSizeFull();
	}
	
	private void btnLunchClick(final ClickEvent<Button> event)
	{
		this.viewLunch = !this.viewLunch;
		
		final List<LComponent> normalComponents = Arrays.asList(this.markerRathaus, this.markerZob);
		final List<LComponent> lunchComponents = Arrays.asList(
			this.circleRange,
			this.markerPizza,
			this.markerKebab,
			this.markerAsia,
			this.markerGreek,
			this.markerBakery,
			this.markerLeberkaese);
		
		this.map.setViewPoint(new LCenter(49.675126, 12.160733, this.viewLunch ? 16 : 17));
		this.map.removeLComponents(this.viewLunch ? normalComponents : lunchComponents);
		this.map.addLComponents(this.viewLunch ? lunchComponents : normalComponents);
		
		this.btnLunch.setText(this.viewLunch ? "Go back to the normal view" : "Where do XDEV employees go for lunch?");
	}
	
	private void initMapComponents()
	{
		this.markerZob = new LMarker(49.673470, 12.160108, "ZoB");
		this.markerZob.setPopup("Central bus station");
		this.markerZob.setToolip("Alert state=true");
		this.markerZob.setAlertState(true); //Cluster will be red once it includes this Marker upon zoom-out
		
		
		final LMarker markerXDev = new LMarker(49.675806677512824, 12.160990185846394);
		final LIcon xDevLogo = new LIcon(
			// Important replace # with %23!
			"data:image/svg+xml;utf8,<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"1000\" height=\"200\" viewBox=\"0 0 18300 4500\" style=\"background-color:rgba(180,180,180,0.7)\">\n"
				+ "  <defs>\n"
				+ "    <style>\n"
				+ "      .fil0{fill:%23d71e23}\n"
				+ "    </style>\n"
				+ "  </defs>\n"
				+ "  <g>\n"
				+ "    <path class=\"fil0\" d=\"M9763 10965h-920l-17-6-1503-588-1506 588-11 4-13 2-1562 148-1102 105 1064-369 2311-801-1638-633-683-263h1609l16 6 1515 588 1521-588 10-4 9-1 1388-211 1177-178-1131 441-2177 849 1675 647 682 264zM25514 9520l-1909 1442-22 17h-693l-23-19-1765-1440-285-233h907l22 17 1490 1178 1395-1177 23-19h1171zM20426 10961h-4015V9260h4126l-1 127-1 99v126h-112l-3041-3 2 322 3038 3h110l2 124 1 83 2 128h-3146v352l3035-6h112v346z\" transform=\"translate(-5400 -7700)\"/>\n"
				+ "    <path class=\"fil0\" d=\"M10994 9275h2026a12150 12150 0 0 1 1368 73c292 35 559 83 798 143h1c290 73 510 158 659 254 165 106 248 229 248 368 0 134-85 254-254 359-151 94-375 180-672 256-292 76-618 132-977 170-359 37-751 56-1174 56h-2102V9275h79zm917 1354h1106c300 0 574-14 822-41 247-27 469-67 665-121h1a2470 2470 0 0 0 277-96c176-79 264-164 264-256 0-60-39-118-117-173-92-66-234-125-425-178-197-55-418-96-665-123-248-27-522-41-822-41h-1106v1029z\" transform=\"translate(-5400 -7700)\"/>\n"
				+ "  </g>\n"
				+ "</svg>");
		
		xDevLogo.setIconSize(100, 20);
		xDevLogo.setIconAnchor(50, 0);
		markerXDev.setPopup("<a href='https://xdev.software/en' target='" + AnchorTarget.BLANK.getValue() + "'>XDEV Software GmbH</a>");
		markerXDev.setIcon(xDevLogo);
		
		final LMarker markerInfo = new LMarker(49.674095, 12.162257);
		final LDivIcon div = new LDivIcon(
			"<p><center><b>Welcome to Weiden in der Oberpfalz!</b></center></p><p>This demo shows you different markers,<br> popups, polygons and other stuff</p>");
		
		markerInfo.setDivIcon(div);
		
		final LPolygon polygonNoc = new LPolygon(
			Arrays.asList(
				new LPoint(49.674883, 12.159098),
				new LPoint(49.675719, 12.160248),
				new LPoint(49.676080, 12.159985),
				new LPoint(49.675750, 12.158008),
				new LPoint(49.675306, 12.158499)));
		polygonNoc.setFill(true);
		polygonNoc.setFillColor("#3366ff");
		polygonNoc.setFillOpacity(0.8);
		polygonNoc.setStroke(false);
		polygonNoc.setPopup("NOC-Nordoberpfalz Center");
		
		this.markerRathaus = new LMarker(49.675519, 12.163868, "L-22556");
		this.markerRathaus.setPopup("Old Town Hall");
		
		this.circleRange = new LCircle(49.675126, 12.160733, 450);
		
		this.markerPizza = new LMarker(49.674413, 12.160925);
		this.markerPizza.setPopup("Pizza!");
		
		this.markerKebab = new LMarker(49.673026, 12.156278);
		this.markerKebab.setPopup("Kebab!");
		
		this.markerAsia = new LMarker(49.675039, 12.162127);
		this.markerAsia.setPopup("Asian Food");
		
		this.markerGreek = new LMarker(49.675126, 12.161899);
		this.markerGreek.setPopup("Greek Food");
		
		this.markerBakery = new LMarker(49.674806, 12.160249);
		this.markerBakery.setPopup("Fresh baked stuff");
		
		this.markerLeberkaese = new LMarker(49.673800, 12.160113);
		this.markerLeberkaese.setPopup("Fast food like Leberkäsesemmeln");
		
		this.map = new LMap(49.675126, 12.160733, 17);
		this.map.setTileLayer(LTileLayer.DEFAULT_OPENSTREETMAP_TILE);
		this.map.enableMarkerCluster(true);
		
		this.map.setSizeFull();
		// add some logic here for called Markers (token)
		this.map.addMarkerClickListener(ev -> System.out.println(ev.getTag()));
		
		this.map.addLComponents(
			markerXDev,
			markerInfo,
			this.markerZob,
			polygonNoc,
			this.markerRathaus);
		this.map.addMarkerCluster();
	}
}
