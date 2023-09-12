package software.xdev.vaadin.maps.leaflet.base.has;

import software.xdev.vaadin.maps.leaflet.base.LComponent;


public interface LHasOpacity<S extends LHasOpacity<S>> extends LComponent<S>
{
	default S setOpacity(final Double opacity)
	{
		this.invokeSelf(".setOpacity($0)", opacity);
		return this.self();
	}
}
