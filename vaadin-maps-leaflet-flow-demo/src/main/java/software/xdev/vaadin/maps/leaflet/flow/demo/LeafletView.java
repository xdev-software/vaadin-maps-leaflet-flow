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
		this.mapTest();
		this.button = new Button();
		this.button.setText("Where do XDEV employees go for lunch break?");
		this.button.addClickListener(this::buttonOnClick);
		this.add(this.button);
	}

	private void buttonOnClick(final ClickEvent<Button> event)
	{

		if(this.viewSwitch)
		{
			this.viewSwitch = false;

			this.map.setViewPoint(new LCenter(49.675126, 12.160733, 16));
			this.map.removeItem(this.markerRathaus, this.markerZob);

			this.map.addLComponent(
				this.circleRange,
				this.markerPizza,
				this.markerKebab,
				this.markerAsia,
				this.markerGreek,
				this.markerBakery,
				this.markerLeberkaese);
		}
		else
		{
			this.viewSwitch = true;
			this.map.setViewPoint(new LCenter(49.675126, 12.160733, 17));
			this.map.addLComponent(this.markerRathaus, this.markerZob);

			this.map.removeItem(
				this.circleRange,
				this.markerPizza,
				this.markerKebab,
				this.markerAsia,
				this.markerGreek,
				this.markerBakery,
				this.markerLeberkaese);
		}
	}

	public void mapTest()
	{
		this.viewSwitch = true;
		this.map = new XdevGeoMap(49.675126, 12.160733, 17);
		this.map.setHeight("700px");
		this.map.setWidth("1000px");
		this.add(this.map);

		this.markerZob = new LMarker(49.673470, 12.160108);

		final LMarker markerXDev = new LMarker(49.675126, 12.160733);
		final LIcon xDevLogo = new LIcon();
		xDevLogo.setIconUrl(
			"https://www.xing.com/img/custom/communities/communities_files/f/f/6/32758/large/XDEV_600x600_red.png?1438789458");
		xDevLogo.setIconSize(70, 70);
		xDevLogo.setIconAnchor(33, 55);
		markerXDev.setPopup("<a href='https://www.xdev-software.de/'>Xdev-Software GmbH</a>");
		markerXDev.setIcon(xDevLogo);

		final LMarker markerInfo = new LMarker(49.674095, 12.162257);
		final LDivIcon div = new LDivIcon();
		div.setIconSize(265, 90);
		div.setHtml(
			"<p><center><b>Welcome to Weiden in der Oberpfalz!</b></center></p><p>This Demo shows you different Markers, Popups, Polygon and other Stuff</p>");
		markerInfo.setIcon(div);

		this.getPunkte();
		final LPolygon polygonNoc = new LPolygon(this.points);
		polygonNoc.setFill(true);
		polygonNoc.setFillColor("#3366ff");
		polygonNoc.setFillOpacity(0.8);
		polygonNoc.setStroke(false);
		polygonNoc.setPopup("NOC-Nordoberpfalz Center");

		this.markerRathaus = new LMarker(49.675519, 12.163868);
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

		this.map.addLComponent(
			markerXDev,
			markerInfo,
			this.markerZob,
			polygonNoc,
			this.markerRathaus);

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
