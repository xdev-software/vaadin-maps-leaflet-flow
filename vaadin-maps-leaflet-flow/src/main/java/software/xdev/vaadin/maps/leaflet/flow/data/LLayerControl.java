package software.xdev.vaadin.maps.leaflet.flow.data;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;


public class LLayerControl
{
	private final LLayerControlOptions layerControlOptions;
	private final Map<String, LComponent> overlays;
	
	public LLayerControl()
	{
		layerControlOptions = new LLayerControlOptions();
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
		
		StringBuilder stringBuilder = new StringBuilder("let item = null;\nlet layerMap = {};\n");
		
		for(String name : overlays.keySet())
		{
			stringBuilder.append(overlays.get(name).buildClientJSItems().replaceFirst("let", ""));
			stringBuilder.append("layerMap.push(\"").append(name).append("\": item);\n");
		}
		// TODO: add basemap support
		stringBuilder.append("let layerControl = L.control.layers(null, layerMap, {\ncollapsed: ")
			.append(layerControlOptions.isCollapsed())
			.append(",\n hideSingleBase: ")
			.append(layerControlOptions.isHideSingleBase())
			.append("\n});\n");
		//let layerControl = L.control.layers()
		return stringBuilder.toString();
	}
}
