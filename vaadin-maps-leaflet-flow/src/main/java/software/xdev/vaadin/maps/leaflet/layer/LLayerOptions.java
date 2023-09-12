package software.xdev.vaadin.maps.leaflet.layer;

import software.xdev.vaadin.maps.leaflet.base.LComponentOptions;


/**
 * @see <a href="https://leafletjs.com/reference.html#layer-option">Leaflet Docs</a>
 */
public abstract class LLayerOptions<S extends LLayerOptions<S>> implements LComponentOptions<S>
{
	String pane;
	String attribution;
	
	public String getPane()
	{
		return this.pane;
	}
	
	public void setPane(final String pane)
	{
		this.pane = pane;
	}
	
	public S withPane(final String pane)
	{
		this.setPane(pane);
		return this.self();
	}
	
	public String getAttribution()
	{
		return this.attribution;
	}
	
	public void setAttribution(final String attribution)
	{
		this.attribution = attribution;
	}
	
	public S withAttribution(final String attribution)
	{
		this.setAttribution(attribution);
		return this.self();
	}
}
