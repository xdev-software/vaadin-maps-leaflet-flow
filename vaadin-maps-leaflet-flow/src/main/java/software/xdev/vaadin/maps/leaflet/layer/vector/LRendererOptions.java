package software.xdev.vaadin.maps.leaflet.layer.vector;

import software.xdev.vaadin.maps.leaflet.layer.LLayerOptions;


/**
 * @see <a href="https://leafletjs.com/reference.html#renderer">Leaflet docs</a>
 */
public abstract class LRendererOptions<S extends LRendererOptions<S>> extends LLayerOptions<S>
{
	private Double padding;
	
	public Double getPadding()
	{
		return this.padding;
	}
	
	public void setPadding(final Double padding)
	{
		this.padding = padding;
	}
	
	public S withPadding(final Double padding)
	{
		this.setPadding(padding);
		return this.self();
	}
}
