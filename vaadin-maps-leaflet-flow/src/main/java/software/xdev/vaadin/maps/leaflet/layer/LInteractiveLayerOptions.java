package software.xdev.vaadin.maps.leaflet.layer;

/**
 * @see <a href="https://leafletjs.com/reference.html#interactive-layer-option">Leaflet Docs</a>
 */
public abstract class LInteractiveLayerOptions<S extends LInteractiveLayerOptions<S>> extends LLayerOptions<S>
{
	private Boolean interactive;
	private Boolean bubblingMouseEvents;
	
	public Boolean getInteractive()
	{
		return this.interactive;
	}
	
	public void setInteractive(final Boolean interactive)
	{
		this.interactive = interactive;
	}
	
	public S withInteractive(final Boolean interactive)
	{
		this.setInteractive(interactive);
		return this.self();
	}
	
	public Boolean getBubblingMouseEvents()
	{
		return this.bubblingMouseEvents;
	}
	
	public void setBubblingMouseEvents(final Boolean bubblingMouseEvents)
	{
		this.bubblingMouseEvents = bubblingMouseEvents;
	}
	
	public S withBubblingMouseEvents(final Boolean bubblingMouseEvents)
	{
		this.setBubblingMouseEvents(bubblingMouseEvents);
		return this.self();
	}
}
