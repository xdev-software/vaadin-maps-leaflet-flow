
package software.xdev.vaadin.maps.leaflet.flow.data;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import elemental.json.Json;
import elemental.json.JsonObject;


public class DivIcon
{
	private String className = "leaflet-div-icon";
	private final List<Integer> iconSize = new ArrayList<>();
	private final List<Integer> iconAnchor = new ArrayList<>();
	private String html;
	
	public DivIcon()
	{
		this.setIconSize(25, 41);
		this.setIconAnchor(0, 0);
	}
	
	public List<Integer> getIconSize()
	{
		return this.iconSize;
	}
	
	/**
	 * Sets icon size in px.
	 *
	 * @param iconSize
	 */
	public void setIconSize(final int x, final int y)
	{
		this.iconSize.clear();
		this.iconSize.add(x);
		this.iconSize.add(y);
	}
	
	public List<Integer> getIconAnchor()
	{
		return this.iconAnchor;
	}
	
	/**
	 * Anchor point vor the Icon image for fixing offsets
	 *
	 * @param iconAnchor
	 */
	public void setIconAnchor(final int x, final int y)
	{
		this.iconAnchor.clear();
		this.iconAnchor.add(x);
		this.iconAnchor.add(y);
	}
	
	public String getClassName()
	{
		return this.className;
	}
	
	/**
	 * Sets a className for CSS formating.
	 *
	 * @param className
	 */
	public void setClassName(final String className)
	{
		this.className = className;
	}
	
	public String getHtml()
	{
		return this.html;
	}
	
	/**
	 * Custom HTML code to put inside the div element, empty by default. Alternatively, an instance of HTMLElement.
	 *
	 * @param html
	 */
	public void setHtml(final String html)
	{
		this.html = html;
	}
	
	@JsonIgnore
	public JsonObject toJson()
	{
		final JsonObject jsonObject = Json.createObject();
		final ObjectMapper mapper = new ObjectMapper();
		try
		{
			jsonObject.put("icon", Json.parse(mapper.writeValueAsString(this)));
		}
		catch(final JsonProcessingException e)
		{
			throw new RuntimeException(e);
		}
		
		return jsonObject;
	}
}
