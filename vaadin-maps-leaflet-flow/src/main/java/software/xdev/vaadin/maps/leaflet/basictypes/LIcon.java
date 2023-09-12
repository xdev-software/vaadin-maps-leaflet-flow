package software.xdev.vaadin.maps.leaflet.basictypes;

import software.xdev.vaadin.maps.leaflet.base.LBaseComponent;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


public class LIcon extends LBaseComponent<LIcon>
{
	protected LIcon(
		final LComponentManagementRegistry compReg,
		final String jsCreate,
		final LAbstractIconOptions<?> options)
	{
		super(compReg, jsCreate + "(" + compReg.writeOptions(options) + ")");
	}
	
	public LIcon(
		final LComponentManagementRegistry compReg,
		final LIconOptions options)
	{
		this(compReg, "L.icon", options);
	}
}
