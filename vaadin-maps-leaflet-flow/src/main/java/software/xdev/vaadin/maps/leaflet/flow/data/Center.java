
package software.xdev.vaadin.maps.leaflet.flow.data;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import elemental.json.Json;
import elemental.json.JsonObject;


public class Center
{

	private List<Double> coordinates = new ArrayList<>();
	private int zoom;

	public Center(final double lat, final double lon, final int zoom)
	{
		this.coordinates.add(lat);
		this.coordinates.add(lon);
		this.zoom = zoom;
	}

	public int getZoom()
	{
		return this.zoom;
	}

	/**
	 * Sets the zoom level at the start
	 * @param zoom
	 */
	public void setZoom(final int zoom)
	{
		this.zoom = zoom;
	}

	public List<Double> getCoordinates()
	{
		return this.coordinates;
	}

	public void setCoordinates(final List<Double> coordinates)
	{
		this.coordinates = coordinates;
	}

	public JsonObject toJson()
	{
		final JsonObject jsonObject = Json.createObject();
		final ObjectMapper mapper = new ObjectMapper();
		try
		{
			jsonObject.put("point", Json.parse(mapper.writeValueAsString(this)));
		}
		catch(final JsonProcessingException e)
		{
			throw new RuntimeException(e);
		}

		return jsonObject;
	}
}
