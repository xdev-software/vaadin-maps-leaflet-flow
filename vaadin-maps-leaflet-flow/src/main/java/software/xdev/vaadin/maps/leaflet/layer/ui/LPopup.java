package software.xdev.vaadin.maps.leaflet.layer.ui;

import software.xdev.vaadin.maps.leaflet.basictypes.LLatLng;
import software.xdev.vaadin.maps.leaflet.layer.LLayer;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


public class LPopup extends LDivOverlay<LPopup>
{
	public LPopup(
		final LComponentManagementRegistry compReg,
		final LPopupOptions options,
		final LLayer<?> source)
	{
		super(compReg, "L.popup(" + compReg.writeOptions(options) + (source != null ? ", " + source.clientComponentJsAccessor() : "") + ")");
	}
	
	public LPopup(
		final LComponentManagementRegistry compReg,
		final LPopupOptions options)
	{
		this(compReg, options, null);
	}
	
	public LPopup(final LComponentManagementRegistry compReg)
	{
		super(compReg, "L.popup()");
	}
	
	public LPopup(
		final LComponentManagementRegistry compReg,
		final LLatLng latLng,
		final LPopupOptions options)
	{
		super(compReg, "L.popup(" + latLng.clientComponentJsAccessor() + compReg.writeOptionsOptionalParameter(options) + ")");
	}
	
	public LPopup(
		final LComponentManagementRegistry compReg,
		final LLatLng latLng)
	{
		this(compReg, latLng, null);
	}
}
