
package software.xdev.vaadin.maps.leaflet.flow.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import elemental.json.Json;
import elemental.json.JsonObject;


public class Marker
{
	
	private static final String MARKER_TYPE = "Point";
	private final MarkerGeometry geometry;
	private final MarkerOptions properties;
	
	/**
	 * Creates a new Marker at the latitude, longitude
	 *
	 * @param name
	 * @param lat
	 * @param lon
	 */
	public Marker(final double lat, final double lon)
	{
		this.geometry = new MarkerGeometry(MARKER_TYPE, lat, lon);
		this.properties = new MarkerOptions();
	}
	
	public double getLat()
	{
		return this.geometry.getCoordinates().get(0);
	}
	
	public void setLat(final double lat)
	{
		this.geometry.getCoordinates().remove(0);
		this.geometry.getCoordinates().set(0, lat);
	}
	
	public double getLon()
	{
		return this.geometry.getCoordinates().get(1);
	}
	
	public void setLon(final double lon)
	{
		this.geometry.getCoordinates().remove(1);
		this.geometry.getCoordinates().set(1, lon);
	}
	
	public String getPopup()
	{
		return this.properties.getPopup();
	}
	
	/**
	 * Sets a Pop-up to the Marker
	 *
	 * @param popup
	 */
	public void setPopup(final String popup)
	{
		this.properties.setPopup(popup);
	}
	
	public JsonObject toJson()
	{
		final JsonObject jsonObject = Json.createObject();
		final ObjectMapper mapper = new ObjectMapper();
		try
		{
			jsonObject.put("type", Json.create("Feature"));
			jsonObject.put("geometry", Json.parse(mapper.writeValueAsString(this.geometry)));
			jsonObject.put("properties", Json.parse(mapper.writeValueAsString(this.properties)));
		}
		catch(final JsonProcessingException e)
		{
			throw new RuntimeException(e);
		}
		
		return jsonObject;
	}
}
