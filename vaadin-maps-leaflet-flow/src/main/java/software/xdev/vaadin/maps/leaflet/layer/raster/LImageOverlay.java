package software.xdev.vaadin.maps.leaflet.layer.raster;

import java.io.Serializable;

import software.xdev.vaadin.maps.leaflet.base.has.LHasBringTo;
import software.xdev.vaadin.maps.leaflet.base.has.LHasOpacity;
import software.xdev.vaadin.maps.leaflet.basictypes.LLatLngBounds;
import software.xdev.vaadin.maps.leaflet.layer.LInteractiveLayer;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#imageoverlay">Leaflet docs</a>
 */
public class LImageOverlay extends LInteractiveLayer<LImageOverlay>
	implements LHasBringTo<LImageOverlay>, LHasOpacity<LImageOverlay>
{
	protected LImageOverlay(
		final LComponentManagementRegistry compReg,
		final String jsConstructorCallExpression,
		final Serializable... parameters)
	{
		super(compReg, jsConstructorCallExpression, parameters);
	}
	
	public LImageOverlay(
		final LComponentManagementRegistry compReg,
		final String imageUrl,
		final LLatLngBounds bounds,
		final LImageOverlayOptions options)
	{
		super(compReg,
			"L.imageOverlay($0, "
			+ bounds.clientComponentJsAccessor()
			+ compReg.writeOptionsOptionalParameter(options) + ")",
			imageUrl);
	}
	
	public LImageOverlay(
		final LComponentManagementRegistry compReg,
		final String imageUrl,
		final LLatLngBounds bounds)
	{
		this(compReg, imageUrl, bounds, null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#imageoverlay-setbounds">Leaflet docs</a>
	 */
	public LImageOverlay setBounds(final LLatLngBounds bounds)
	{
		this.invokeSelf(".setBounds(" + bounds.clientComponentJsAccessor() + ")");
		return this.self();
	}
}
