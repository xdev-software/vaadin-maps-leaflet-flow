package software.xdev.vaadin.maps.leaflet.base.has;

import software.xdev.vaadin.maps.leaflet.base.LComponent;
import software.xdev.vaadin.maps.leaflet.basictypes.LLatLng;


public interface LHasSetLatLng<S extends LHasSetLatLng<S>> extends LComponent<S>
{
	default S setLatLng(final LLatLng latLng)
	{
		this.invokeSelf(".setLatLng(" + latLng.clientComponentJsAccessor() + ")");
		return this.self();
	}
}
