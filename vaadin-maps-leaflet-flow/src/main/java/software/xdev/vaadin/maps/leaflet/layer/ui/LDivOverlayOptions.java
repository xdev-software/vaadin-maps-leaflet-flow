package software.xdev.vaadin.maps.leaflet.layer.ui;

import software.xdev.vaadin.maps.leaflet.basictypes.LPoint;
import software.xdev.vaadin.maps.leaflet.layer.LInteractiveLayerOptions;

/**
 * @see <a href="https://leafletjs.com/reference.html#divoverlay-option">Leaflet Docs</a>
 */
public abstract class LDivOverlayOptions<S extends LDivOverlayOptions<S>> extends LInteractiveLayerOptions<S>
{
	private LPoint offset;
	private String className;
	private Object content;
	
	public LPoint getOffset()
	{
		return this.offset;
	}
	
	public void setOffset(final LPoint offset)
	{
		this.offset = offset;
	}
	
	public S withOffset(final LPoint offset)
	{
		this.setOffset(offset);
		return this.self();
	}
	
	public String getClassName()
	{
		return this.className;
	}
	
	public void setClassName(final String className)
	{
		this.className = className;
	}
	
	public S withClassName(final String className)
	{
		this.setClassName(className);
		return this.self();
	}
	
	public Object getContent()
	{
		return this.content;
	}
	
	public void setContent(final Object content)
	{
		this.content = content;
	}
	
	public S withContent(final Object content)
	{
		this.setContent(content);
		return this.self();
	}
}
