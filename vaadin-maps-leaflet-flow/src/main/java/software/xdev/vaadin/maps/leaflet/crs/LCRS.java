package software.xdev.vaadin.maps.leaflet.crs;

import software.xdev.vaadin.maps.leaflet.base.RawString;


/**
 * @apiNote CRS can't be constructed
 * @see <a href="https://leafletjs.com/reference.html#crs">Leaflet docs</a>
 */
public final class LCRS
{
	public static final class Defined
	{
		public static final RawString EARTH = new RawString("L.CRS.Earth");
		
		public static final RawString EPSG3395 = new RawString("L.CRS.EPSG3395");
		public static final RawString EPSG3857 = new RawString("L.CRS.EPSG3857");
		public static final RawString EPSG4326 = new RawString("L.CRS.EPSG4326");
		public static final RawString BASE = new RawString("L.CRS.Base");
		public static final RawString SIMPLE = new RawString("L.CRS.Simple");
		
		private Defined()
		{
		}
	}
	
	private LCRS()
	{
	}
}
