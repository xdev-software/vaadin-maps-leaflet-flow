package software.xdev.vaadin.maps.leaflet.base.has;

import software.xdev.vaadin.maps.leaflet.base.LComponent;


public interface LHasRedraw<S extends LHasRedraw<S>> extends LComponent<S>
{
	default S redraw()
	{
		this.invokeSelf(".redraw()");
		return this.self();
	}
}
