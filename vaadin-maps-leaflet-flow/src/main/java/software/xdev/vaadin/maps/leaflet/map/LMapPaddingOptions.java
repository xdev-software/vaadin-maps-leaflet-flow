package software.xdev.vaadin.maps.leaflet.map;

import software.xdev.vaadin.maps.leaflet.basictypes.LPoint;


/**
 * @see <a href="https://leafletjs.com/reference.html#padding-options">Leaflet docs</a>
 */
public class LMapPaddingOptions implements LMapPaddingBaseOptions<LMapPaddingOptions>
{
	private LPoint paddingTopLeft;
	private LPoint paddingBottomRight;
	private LPoint padding;
	
	@Override
	public LPoint getPaddingTopLeft()
	{
		return this.paddingTopLeft;
	}
	
	@Override
	public void setPaddingTopLeft(final LPoint paddingTopLeft)
	{
		this.paddingTopLeft = paddingTopLeft;
	}
	
	@Override
	public LPoint getPaddingBottomRight()
	{
		return this.paddingBottomRight;
	}
	
	@Override
	public void setPaddingBottomRight(final LPoint paddingBottomRight)
	{
		this.paddingBottomRight = paddingBottomRight;
	}
	
	@Override
	public LPoint getPadding()
	{
		return this.padding;
	}
	
	@Override
	public void setPadding(final LPoint padding)
	{
		this.padding = padding;
	}
}
