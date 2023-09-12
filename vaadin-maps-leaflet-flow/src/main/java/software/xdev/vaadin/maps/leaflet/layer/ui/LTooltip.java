package software.xdev.vaadin.maps.leaflet.layer.ui;

import software.xdev.vaadin.maps.leaflet.basictypes.LLatLng;
import software.xdev.vaadin.maps.leaflet.layer.LLayer;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


public class LTooltip extends LDivOverlay<LTooltip>
{
	public LTooltip(
		final LComponentManagementRegistry compReg,
		final LTooltipOptions options,
		final LLayer<?> source)
	{
		super(compReg, "L.tooltip(" + compReg.writeOptions(options) + (source != null ? ", " + source.clientComponentJsAccessor() : "") + ")");
	}
	
	public LTooltip(
		final LComponentManagementRegistry compReg,
		final LTooltipOptions options)
	{
		this(compReg, options, null);
	}
	
	public LTooltip(final LComponentManagementRegistry compReg)
	{
		super(compReg, "L.tooltip()");
	}
	
	public LTooltip(
		final LComponentManagementRegistry compReg,
		final LLatLng latLng,
		final LTooltipOptions options)
	{
		super(compReg, "L.tooltip(" + latLng.clientComponentJsAccessor() + compReg.writeOptionsOptionalParameter(options) + ")");
	}
	
	public LTooltip(
		final LComponentManagementRegistry compReg,
		final LLatLng latLng)
	{
		this(compReg, latLng, null);
	}
}
