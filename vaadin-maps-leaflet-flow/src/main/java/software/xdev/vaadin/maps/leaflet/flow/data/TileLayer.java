package software.xdev.vaadin.maps.leaflet.flow.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import elemental.json.Json;
import elemental.json.JsonObject;


public class TileLayer
{
	private String link;
	private String attribution;
	private int zoom;
	private String id;

	public TileLayer(final String link, final String attribution, final int zoom, final String id)
	{
		super();
		this.link = link;
		this.attribution = attribution;
		this.zoom = zoom;
		this.id = id;
	}

	public String getLink()
	{
		return this.link;
	}

	public void setLink(final String link)
	{
		this.link = link;
	}

	public String getAttribution()
	{
		return this.attribution;
	}

	public void setAttribution(final String attribution)
	{
		this.attribution = attribution;
	}

	public int getZoom()
	{
		return this.zoom;
	}

	public void setZoom(final int zoom)
	{
		this.zoom = zoom;
	}

	public String getId()
	{
		return this.id;
	}

	public void setId(final String id)
	{
		this.id = id;
	}

	public JsonObject toJson()
	{
		final JsonObject jsonObject = Json.createObject();
		final ObjectMapper mapper = new ObjectMapper();
		try
		{
			jsonObject.put("tile", Json.parse(mapper.writeValueAsString(this)));
		}
		catch(final JsonProcessingException e)
		{
			e.printStackTrace();
		}

		return jsonObject;
	}
}
