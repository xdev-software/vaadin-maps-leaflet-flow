package software.xdev.vaadin.maps.leaflet.flow.data;

import static org.apache.commons.text.StringEscapeUtils.escapeEcmaScript;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;


public class LLayerControl
{
	private final LLayerControlOptions layerControlOptions;
	private final Map<String, LComponent> overlays;
	
	public LLayerControl()
	{
		this(new LLayerControlOptions());
	}
	
	public LLayerControl(LLayerControlOptions options)
	{
		this.layerControlOptions = options;
		overlays = new HashMap<>();
	}
	
	public void addOverlayLayer(String name, LComponent layer)
	{
		overlays.put(name, layer);
	}
	
	public void addOverlayLayers(Map<String, LComponent> overlays)
	{
		this.overlays.putAll(overlays);
	}
	
	public String buildClientJS() throws JsonProcessingException
	{
		
		StringBuilder stringBuilder = new StringBuilder("let item = null;\n");
		stringBuilder.append("let layerControl = L.control.layers(null, null, {\ncollapsed: ")
			.append(layerControlOptions.isCollapsed())
			.append(",\n hideSingleBase: ")
			.append(layerControlOptions.isHideSingleBase())
			.append("\n});\n");
		for(String name : overlays.keySet())
		{
			stringBuilder.append(overlays.get(name).buildClientJSItems().replaceFirst("let", ""));
			stringBuilder.append((overlays.get(name).getPopup() != null
				? "item.bindPopup('" + escapeEcmaScript(overlays.get(name).getPopup()) + "');\n"
				: ""));
			stringBuilder.append("layerControl.addOverlay(item, \"").append(name).append("\");\n");
		}
		// layerControl.addOverlay(parks, "Parks");
		// TODO: add basemap support
		
		//let layerControl = L.control.layers()
		return stringBuilder.toString();
	}
}
