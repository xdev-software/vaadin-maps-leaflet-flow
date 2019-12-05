
package software.xdev.vaadin.maps.leaflet.flow.data;

import java.util.ArrayList;
import java.util.List;


public class Point
{
	private List<Double> coords = new ArrayList<>();
	
	public Point(final double lat, final double lon)
	{
		this.coords.add(lat);
		this.coords.add(lon);
	}
	
	public List<Double> getCoords()
	{
		return this.coords;
	}
	
	public void setCoords(final List<Double> point)
	{
		this.coords = point;
	}
	
}
