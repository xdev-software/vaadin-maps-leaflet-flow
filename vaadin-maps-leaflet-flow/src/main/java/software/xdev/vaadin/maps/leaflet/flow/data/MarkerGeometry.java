package software.xdev.vaadin.maps.leaflet.flow.data;

import java.util.ArrayList;
import java.util.List;


public class MarkerGeometry
{
	private String type;
	private List<Double> coordinates = new ArrayList<>();
	
	public MarkerGeometry(final String type, final double lon, final double lat)
	{
		this.type = type;
		this.coordinates.add(lat);
		this.coordinates.add(lon);
		
	}
	
	public String getType()
	{
		return this.type;
	}
	
	public void setType(final String type)
	{
		this.type = type;
	}
	
	public List<Double> getCoordinates()
	{
		return this.coordinates;
	}
	
	public void setCoordinates(final List<Double> coordinates)
	{
		this.coordinates = coordinates;
	}
	
}
