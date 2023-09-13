package software.xdev.vaadin.maps.leaflet.basictypes;

import software.xdev.vaadin.maps.leaflet.base.LBaseComponent;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#point">Leaflet docs</a>
 */
public class LPoint extends LBaseComponent<LPoint>
{
	public LPoint(
		final LComponentManagementRegistry compReg,
		final int x,
		final int y)
	{
		super(compReg, "L.point($0, $1)", x, y);
	}
	
	public LPoint(
		final LComponentManagementRegistry compReg,
		final int[] arr)
	{
		super(compReg, "L.point($0, $1)", arr[0], arr[1]);
	}
}
