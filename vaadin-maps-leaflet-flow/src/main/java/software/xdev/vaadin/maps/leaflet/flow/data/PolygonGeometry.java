package software.xdev.vaadin.maps.leaflet.flow.data;

import java.util.List;


public class PolygonGeometry
{
	private List<List<Double>> coordinates;
	private String type;
	
	public PolygonGeometry(final String type, final List<List<Double>> coordinates)
	{
		this.type = type;
		this.coordinates = coordinates;
	}
	
	public String getType()
	{
		return this.type;
	}
	
	public void setType(final String type)
	{
		this.type = type;
	}
	
	public List<List<Double>> getCoordinates()
	{
		return this.coordinates;
	}
	
	public void setCoordinates(final List<List<Double>> poly)
	{
		this.coordinates = poly;
	}
	
}
