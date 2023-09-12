package software.xdev.vaadin.maps.leaflet.map;

/**
 * @see <a href="https://leafletjs.com/reference.html#zoom-options">Leaflet docs</a>
 */
public class LMapZoomOptions implements LMapZoomBaseOptions<LMapZoomOptions>
{
	private Boolean animate;
	
	@Override
	public Boolean getAnimate()
	{
		return this.animate;
	}
	
	@Override
	public void setAnimate(final Boolean animate)
	{
		this.animate = animate;
	}
}
