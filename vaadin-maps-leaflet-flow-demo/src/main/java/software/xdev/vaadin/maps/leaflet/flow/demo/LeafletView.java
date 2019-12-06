package software.xdev.vaadin.maps.leaflet.flow.demo;

import java.util.Arrays;
import java.util.List;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import software.xdev.vaadin.maps.leaflet.flow.XdevGeoMap;
import software.xdev.vaadin.maps.leaflet.flow.data.Center;
import software.xdev.vaadin.maps.leaflet.flow.data.Circle;
import software.xdev.vaadin.maps.leaflet.flow.data.DivIcon;
import software.xdev.vaadin.maps.leaflet.flow.data.MapIcon;
import software.xdev.vaadin.maps.leaflet.flow.data.Marker;
import software.xdev.vaadin.maps.leaflet.flow.data.Point;
import software.xdev.vaadin.maps.leaflet.flow.data.Polygon;

@Route("")
public class LeafletView extends VerticalLayout
{

	private final Button button;
	private List<Point> points;
	private XdevGeoMap map;
	private boolean viewS;

	private Marker xDev;
	private Marker zob;
	private Marker rathaus;

	private Circle range;
	private Marker pizza;
	private Marker kebab;
	private Marker asia;
	private Marker greek;
	private Marker bakery;
	private Marker leberkaese;
	private Polygon nocPlace;



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

		if(this.viewS)
		{

			this.viewS= false;



			this.map.setViewPoint(new Center(49.675126, 12.160733, 16));
			this.map.deleteItem(this.rathaus);
			this.map.deleteItem(this.zob);


			this.map.addCircle(this.range);

			this.map.addMarker(this.pizza);
			this.map.addMarker(this.kebab);
			this.map.addMarker(this.asia);
			this.map.addMarker(this.greek);
			this.map.addMarker(this.bakery);
			this.map.addMarker(this.leberkaese);



		}
		else
		{
			this.viewS = true;
			this.map.setViewPoint(new Center(49.675126, 12.160733, 17));
			this.map.addMarker(this.rathaus);
			this.map.addMarker(this.zob);

			this.map.deleteItem(this.range);

			this.map.deleteItem(this.pizza);
			this.map.deleteItem(this.kebab);
			this.map.deleteItem(this.asia);
			this.map.deleteItem(this.greek);
			this.map.deleteItem(this.bakery);
			this.map.deleteItem(this.leberkaese);

		}
	}

	public void mapTest()
	{
		this.viewS = true;
		this.map = new XdevGeoMap(49.675126, 12.160733, 17);
		this.map.setHeight("700px");
		this.map.setWidth("1000px");

		this.add(this.map);



		this.xDev = new Marker(49.675126, 12.160733);
		final MapIcon xDevLogo = new MapIcon();
		xDevLogo.setIconUrl("https://www.xing.com/img/custom/communities/communities_files/f/f/6/32758/large/XDEV_600x600_red.png?1438789458");
		xDevLogo.setIconSize(70, 70);
		xDevLogo.setIconAnchor(33, 55);
		this.xDev.setPopup("<a href='https://www.xdev-software.de/'>Xdev-Software GmbH</a>");
		this.map.addMarker(this.xDev, xDevLogo);


		final Marker info = new Marker(49.674095, 12.162257);
		final DivIcon div = new DivIcon();
		div.setIconSize(265, 90);
		div.setHtml("<p><center><b>Welcome to Weiden in der Oberpfalz!</b></center></p><p>This Demo shows you different Markers, Popups, Polygon and other Stuff</p>");

		this.map.addMarker(info, div);

		this.zob = new Marker(49.673470, 12.160108);
		this.map.addMarker(this.zob);

		this.getPunkte();

		this.nocPlace = new Polygon(this.points);

		this.nocPlace.setFill(true);
		this.nocPlace.setFillColor("#3366ff");
		this.nocPlace.setFillOpacity(0.8);
		this.nocPlace.setStroke(false);
		this.nocPlace.setPopup("NOC-Nordoberpfalz Center");
		this.map.addPolygon(this.nocPlace);


		this.rathaus = new Marker(49.675519, 12.163868);
		this.rathaus.setPopup("Old Town Hall");
		this.map.addMarker(this.rathaus);



		this.range = new Circle(49.675126, 12.160733, 450);


		this.pizza = new Marker(49.674413, 12.160925);
		this.pizza.setPopup("Pizza!");
		this.kebab = new Marker(49.673026, 12.156278);
		this.kebab.setPopup("Kebab!");
		this.asia = new Marker(49.675039, 12.162127);
		this.asia.setPopup("Asian Food");
		this.greek = new Marker(49.675126, 12.161899);
		this.greek.setPopup("Greek Food");
		this.bakery = new Marker(49.674806, 12.160249);
		this.bakery.setPopup("Fresh baked stuff");
		this.leberkaese = new Marker(49.673800, 12.160113);
		this.leberkaese.setPopup("Fast food like Leberkäsesemmeln");

	}

	public void getPunkte()
	{
		this.points = Arrays.asList(
			new Point(49.674910, 12.159202),
			new Point(49.675719, 12.160248),
			new Point(49.675962, 12.160033),
			new Point(49.675691, 12.158011),
			new Point(49.675306, 12.158499));

	}

}