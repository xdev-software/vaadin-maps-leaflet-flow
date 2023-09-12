package software.xdev.vaadin.maps.leaflet.base.has;

import software.xdev.vaadin.maps.leaflet.base.LComponent;


public interface LHasSetZIndex<S extends LHasSetZIndex<S>> extends LComponent<S>
{
	default S setZIndex(final Integer zIndex)
	{
		this.invokeSelf(".setZIndex($0)", zIndex);
		return this.self();
	}
}
