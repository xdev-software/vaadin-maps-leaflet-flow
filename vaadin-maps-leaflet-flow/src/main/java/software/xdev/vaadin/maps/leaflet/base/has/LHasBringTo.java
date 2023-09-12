package software.xdev.vaadin.maps.leaflet.base.has;

import software.xdev.vaadin.maps.leaflet.base.LComponent;


public interface LHasBringTo<S extends LHasBringTo<S>> extends LComponent<S>
{
	default S bringToFront()
	{
		this.invokeSelf(".bringToFront()");
		return this.self();
	}
	
	default S bringToBack()
	{
		this.invokeSelf(".bringToBack()");
		return this.self();
	}
}
