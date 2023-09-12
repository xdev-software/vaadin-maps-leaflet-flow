package software.xdev.vaadin.maps.leaflet.map;

import software.xdev.vaadin.maps.leaflet.base.LComponentOptions;
import software.xdev.vaadin.maps.leaflet.basictypes.LPoint;


/**
 * @see <a href="https://leafletjs.com/reference.html#padding-options">Leaflet docs</a>
 */

public interface LMapPaddingBaseOptions<S extends LMapPaddingBaseOptions<S>> extends LComponentOptions<S>
{
	LPoint getPaddingTopLeft();
	
	void setPaddingTopLeft(final LPoint paddingTopLeft);
	
	default S withPaddingTopLeft(final LPoint paddingTopLeft)
	{
		this.setPaddingTopLeft(paddingTopLeft);
		return this.self();
	}
	
	LPoint getPaddingBottomRight();
	
	void setPaddingBottomRight(final LPoint paddingBottomRight);
	
	default S withPaddingBottomRight(final LPoint paddingBottomRight)
	{
		this.setPaddingBottomRight(paddingBottomRight);
		return this.self();
	}
	
	LPoint getPadding();
	
	void setPadding(final LPoint padding);
	
	default S withPadding(final LPoint padding)
	{
		this.setPadding(padding);
		return this.self();
	}
}
