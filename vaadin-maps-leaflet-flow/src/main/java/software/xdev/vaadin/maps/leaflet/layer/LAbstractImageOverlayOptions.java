package software.xdev.vaadin.maps.leaflet.layer;

public abstract class LAbstractImageOverlayOptions<S extends LAbstractImageOverlayOptions<S>> extends LInteractiveLayerOptions<S>
{
	private Double opacity;
	private String alt;
	// Boolean|String
	private Object crossOrigin;
	private String errorOverlayUrl;
	private Integer zIndex;
	private String className;
	
	public Double getOpacity()
	{
		return this.opacity;
	}
	
	public void setOpacity(final Double opacity)
	{
		this.opacity = opacity;
	}
	
	public S withOpacity(final Double opacity)
	{
		this.setOpacity(opacity);
		return this.self();
	}
	
	public String getAlt()
	{
		return this.alt;
	}
	
	public void setAlt(final String alt)
	{
		this.alt = alt;
	}
	
	public S withAlt(final String alt)
	{
		this.setAlt(alt);
		return this.self();
	}
	
	public Object getCrossOrigin()
	{
		return this.crossOrigin;
	}
	
	public void setCrossOrigin(final Object crossOrigin)
	{
		this.crossOrigin = crossOrigin;
	}
	
	public S withCrossOrigin(final Object crossOrigin)
	{
		this.setCrossOrigin(crossOrigin);
		return this.self();
	}
	
	public String getErrorOverlayUrl()
	{
		return this.errorOverlayUrl;
	}
	
	public void setErrorOverlayUrl(final String errorOverlayUrl)
	{
		this.errorOverlayUrl = errorOverlayUrl;
	}
	
	public S withErrorOverlayUrl(final String errorOverlayUrl)
	{
		this.setErrorOverlayUrl(errorOverlayUrl);
		return this.self();
	}
	
	public Integer getzIndex()
	{
		return this.zIndex;
	}
	
	public void setzIndex(final Integer zIndex)
	{
		this.zIndex = zIndex;
	}
	
	public S withZIndex(final Integer zIndex)
	{
		this.setzIndex(zIndex);
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
}
