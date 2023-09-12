package software.xdev.vaadin.maps.leaflet.map;

import software.xdev.vaadin.maps.leaflet.base.LComponentOptions;


/**
 * @see <a href="https://leafletjs.com/reference.html#pan-options">Leaflet docs</a>
 */
public interface LMapPanBaseOptions<S extends LMapPanBaseOptions<S>> extends LComponentOptions<S>
{
	Boolean getAnimate();
	
	void setAnimate(final Boolean animate);
	
	default S withAnimate(final Boolean animate)
	{
		this.setAnimate(animate);
		return this.self();
	}
	
	Double getDuration();
	
	void setDuration(final Double duration);
	
	default S withDuration(final Double duration)
	{
		this.setDuration(duration);
		return this.self();
	}
	
	Double getEaseLinearity();
	
	void setEaseLinearity(final Double easeLinearity);
	
	default S withEaseLinearity(final Double easeLinearity)
	{
		this.setEaseLinearity(easeLinearity);
		return this.self();
	}
	
	Boolean getNoMoveStart();
	
	void setNoMoveStart(final Boolean noMoveStart);
	
	default S withNoMoveStart(final Boolean noMoveStart)
	{
		this.setNoMoveStart(noMoveStart);
		return this.self();
	}
}
