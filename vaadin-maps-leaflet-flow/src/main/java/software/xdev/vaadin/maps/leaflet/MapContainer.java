package software.xdev.vaadin.maps.leaflet;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.HasText;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.html.Div;

import software.xdev.vaadin.maps.leaflet.map.LMap;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * Component that contains a {@link LMap} and all required client side dependencies for Vaadin.
 */
@NpmPackage(value = "leaflet", version = "1.9.4")
@Tag("leaflet-map")
@JsModule("leaflet/dist/leaflet.js")
@CssImport("leaflet/dist/leaflet.css")
public class MapContainer extends Composite<Div> implements HasSize, HasStyle, HasComponents, HasText
{
	private final LMap lMap;
	
	public MapContainer(final LComponentManagementRegistry reg)
	{
		this.getContent().setSizeFull();
		
		this.lMap = new LMap(reg, this.getContent());
	}
	
	public LMap getlMap()
	{
		return this.lMap;
	}
}
