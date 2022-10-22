package software.xdev.vaadin.maps.leaflet.flow.data;

import static org.apache.commons.text.StringEscapeUtils.escapeEcmaScript;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;


/**
 * @author Evan Penner
 * Layer group to bundle together multiple components
 * @see LLayerControl
 */
public class LLayerGroup implements LComponent
{
	final List<LComponent> lComponents;
	
	/**
	 * Create a new layer group.
	 *
	 * @param lComponents the components to include in the layer group
	 */
	public LLayerGroup(final LComponent... lComponents)
	{
		this.lComponents = List.of(lComponents);
	}
	
	@Override public String buildClientJSItems()
	{
		StringBuilder stringBuilder = new StringBuilder("let item = null;\nvar layers = [];\n");
		
		lComponents.forEach(lComponent -> {
			try
			{
				// Work around for LComponent#buildClientJSItems() having "let"
				stringBuilder.append(lComponent.buildClientJSItems().replaceFirst("let", ""))
					.append((lComponent.getPopup() != null
						? "item.bindPopup('" + escapeEcmaScript(lComponent.getPopup()) + "');\n"
						: ""))
					.append("\nlayers.push(item);\n");
			}
			catch(JsonProcessingException e)
			{
				throw new RuntimeException(e);
			}
		});
		
		stringBuilder.append("item = L.layerGroup(layers);\n");
		return stringBuilder.toString();
	}
	
	/**
	 * Does nothing
	 *
	 * @return empty string
	 */
	@Override public String getPopup()
	{
		return null;
	}
}
