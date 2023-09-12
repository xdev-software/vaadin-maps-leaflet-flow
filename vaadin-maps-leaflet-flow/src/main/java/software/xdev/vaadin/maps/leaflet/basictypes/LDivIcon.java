package software.xdev.vaadin.maps.leaflet.basictypes;

import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * <a href="https://leafletjs.com/reference.html#divicon">Documentation</a>
 */
public class LDivIcon extends LIcon
{
	public LDivIcon(
		final LComponentManagementRegistry compReg,
		final LDivIconOptions options)
	{
		super(compReg, "L.divIcon", options);
	}
}
