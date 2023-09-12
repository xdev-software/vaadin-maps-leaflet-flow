package software.xdev.vaadin.maps.leaflet.map;

import software.xdev.vaadin.maps.leaflet.base.LComponentOptions;


public interface LMapZoomBaseOptions<S extends LMapZoomBaseOptions<S>> extends LComponentOptions<S>
{
	Boolean getAnimate();
	
	void setAnimate(final Boolean animate);
	
	default S withAnimate(final Boolean animate)
	{
		this.setAnimate(animate);
		return this.self();
	}
}
