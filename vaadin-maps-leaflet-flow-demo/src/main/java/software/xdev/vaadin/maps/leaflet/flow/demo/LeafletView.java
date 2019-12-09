package software.xdev.vaadin.maps.leaflet.flow.demo;

import java.util.Arrays;
import java.util.List;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import software.xdev.vaadin.maps.leaflet.flow.XdevGeoMap;
import software.xdev.vaadin.maps.leaflet.flow.data.LCenter;
import software.xdev.vaadin.maps.leaflet.flow.data.LCircle;
import software.xdev.vaadin.maps.leaflet.flow.data.LDivIcon;
import software.xdev.vaadin.maps.leaflet.flow.data.LIcon;
import software.xdev.vaadin.maps.leaflet.flow.data.LMarker;
import software.xdev.vaadin.maps.leaflet.flow.data.LPoint;
import software.xdev.vaadin.maps.leaflet.flow.data.LPolygon;

@Route("")
public class LeafletView extends VerticalLayout
{

	private final Button button;
	private List<LPoint> points;
	private XdevGeoMap map;
	private boolean viewSwitch;

	private LMarker xDev_Marker;
	private LMarker zob_Marker;
	private LMarker rathaus_Marker;

	private LCircle range_Circle;
	private LMarker pizza_Marker;
	private LMarker kebab_Marker;
	private LMarker asia_Marker;
	private LMarker greek_Marker;
	private LMarker bakery_Marker;
	private LMarker leberkaese_Marker;
	private LPolygon nocPlace_Polygon;



	public LeafletView()
	{
		this.mapTest();
		this.button = new Button();
		this.button.setText("Where do XDEV employees go for lunch break?");
		this.button.addClickListener(this::button_onClick);
		this.add(this.button);
	}

	private void button_onClick(final ClickEvent<Button> event)
	{

		if(this.viewSwitch)
		{
			this.viewSwitch= false;

			this.map.setViewPoint(new LCenter(49.675126, 12.160733, 16));
			this.map.removeItem(this.rathaus_Marker,this.zob_Marker);

			this.map.addLComponent(this.range_Circle,this.pizza_Marker,this.kebab_Marker,this.asia_Marker,this.greek_Marker,this.bakery_Marker,this.leberkaese_Marker);
		}
		else
		{
			this.viewSwitch = true;
			this.map.setViewPoint(new LCenter(49.675126, 12.160733, 17));
			this.map.addLComponent(this.rathaus_Marker, this.zob_Marker);

			this.map.removeItem(this.range_Circle,this.pizza_Marker,this.kebab_Marker,this.asia_Marker,this.greek_Marker,this.bakery_Marker,this.leberkaese_Marker);
		}
	}

	public void mapTest()
	{
		this.viewSwitch = true;
		this.map = new XdevGeoMap(49.675126, 12.160733, 17);
		this.map.setHeight("700px");
		this.map.setWidth("1000px");
		this.add(this.map);

		this.zob_Marker = new LMarker(49.673470, 12.160108);

		this.xDev_Marker = new LMarker(49.675126, 12.160733);
		final LIcon xDevLogo = new LIcon();
		xDevLogo.setIconUrl("https://www.xing.com/img/custom/communities/communities_files/f/f/6/32758/large/XDEV_600x600_red.png?1438789458");
		xDevLogo.setIconSize(70, 70);
		xDevLogo.setIconAnchor(33, 55);
		this.xDev_Marker.setPopup("<a href='https://www.xdev-software.de/'>Xdev-Software GmbH</a>");
		this.xDev_Marker.setIcon(xDevLogo);

		final LMarker info_Marker = new LMarker(49.674095, 12.162257);
		final LDivIcon div = new LDivIcon();
		div.setIconSize(265, 90);
		div.setHtml("<p><center><b>Welcome to Weiden in der Oberpfalz!</b></center></p><p>This Demo shows you different Markers, Popups, Polygon and other Stuff</p>");
		info_Marker.setIcon(div);

		this.getPunkte();
		this.nocPlace_Polygon = new LPolygon(this.points);
		this.nocPlace_Polygon.setFill(true);
		this.nocPlace_Polygon.setFillColor("#3366ff");
		this.nocPlace_Polygon.setFillOpacity(0.8);
		this.nocPlace_Polygon.setStroke(false);
		this.nocPlace_Polygon.setPopup("NOC-Nordoberpfalz Center");

		this.rathaus_Marker = new LMarker(49.675519, 12.163868);
		this.rathaus_Marker.setPopup("Old Town Hall");

		this.range_Circle = new LCircle(49.675126, 12.160733, 450);

		this.pizza_Marker = new LMarker(49.674413, 12.160925);
		this.pizza_Marker.setPopup("Pizza!");

		this.kebab_Marker = new LMarker(49.673026, 12.156278);
		this.kebab_Marker.setPopup("Kebab!");

		this.asia_Marker = new LMarker(49.675039, 12.162127);
		this.asia_Marker.setPopup("Asian Food");

		this.greek_Marker = new LMarker(49.675126, 12.161899);
		this.greek_Marker.setPopup("Greek Food");

		this.bakery_Marker = new LMarker(49.674806, 12.160249);
		this.bakery_Marker.setPopup("Fresh baked stuff");

		this.leberkaese_Marker = new LMarker(49.673800, 12.160113);
		this.leberkaese_Marker.setPopup("Fast food like Leberkäsesemmeln");

		this.map.addLComponent(this.xDev_Marker, info_Marker,this.zob_Marker,this.nocPlace_Polygon, this.rathaus_Marker);

	}

	public void getPunkte()
	{
		this.points = Arrays.asList(
			new LPoint(49.674910, 12.159202),
			new LPoint(49.675719, 12.160248),
			new LPoint(49.675962, 12.160033),
			new LPoint(49.675691, 12.158011),
			new LPoint(49.675306, 12.158499));

	}

}