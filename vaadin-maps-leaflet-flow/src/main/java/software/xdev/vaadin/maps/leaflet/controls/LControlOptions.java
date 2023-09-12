package software.xdev.vaadin.maps.leaflet.controls;

import software.xdev.vaadin.maps.leaflet.base.LComponentOptions;


/**
 * @see <a href="https://leafletjs.com/reference.html#control">Leaflet Docs</a>
 */
public abstract class LControlOptions<S extends LControlOptions<S>> implements LComponentOptions<S>
{
	private String position;
	
	public String getPosition()
	{
		return this.position;
	}
	
	public void setPosition(final String position)
	{
		this.position = position;
	}
	
	public S withPosition(final String position)
	{
		this.setPosition(position);
		return this.self();
	}
}
