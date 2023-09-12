package software.xdev.vaadin.maps.leaflet.layer.vector;

import java.util.Collection;
import java.util.List;

import software.xdev.vaadin.maps.leaflet.basictypes.LLatLng;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


public class LPolygon extends LPolyline
{
	public LPolygon(
		final LComponentManagementRegistry compReg,
		final Collection<LLatLng> latLngs,
		final LPolygonOptions options)
	{
		super(compReg, "L.polygon", latLngs, options);
	}
	
	public LPolygon(
		final LComponentManagementRegistry compReg,
		final Collection<LLatLng> latLngs)
	{
		this(compReg, latLngs, null);
	}
	
	public LPolygon(
		final LComponentManagementRegistry compReg,
		final LLatLng... latLngs)
	{
		this(compReg, List.of(latLngs), null);
	}
}
