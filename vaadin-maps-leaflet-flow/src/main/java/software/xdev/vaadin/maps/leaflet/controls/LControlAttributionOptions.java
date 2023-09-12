package software.xdev.vaadin.maps.leaflet.controls;

/**
 * @see <a href="https://leafletjs.com/reference.html#control-attribution">Leaflet docs</a>
 */
public class LControlAttributionOptions extends LControlOptions<LControlAttributionOptions>
{
	// String|false
	private Object prefix;
	
	public Object getPrefix()
	{
		return this.prefix;
	}
	
	public void setPrefix(final Object prefix)
	{
		this.prefix = prefix;
	}
	
	public LControlAttributionOptions withPrefix(final Object prefix)
	{
		this.setPrefix(prefix);
		return this.self();
	}
}
