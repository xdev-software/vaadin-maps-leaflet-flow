package software.xdev.vaadin.maps.leaflet.basictypes;

/**
 * <a href="https://leafletjs.com/reference.html#divicon">Documentation</a>
 */
public class LDivIconOptions extends LAbstractIconOptions<LDivIconOptions>
{
	private String html;
	private LPoint bgPos;
	
	public String getHtml()
	{
		return this.html;
	}
	
	public void setHtml(final String html)
	{
		this.html = html;
	}
	
	public LDivIconOptions withHtml(final String html)
	{
		this.setHtml(html);
		return this.self();
	}
	
	public LPoint getBgPos()
	{
		return this.bgPos;
	}
	
	public void setBgPos(final LPoint bgPos)
	{
		this.bgPos = bgPos;
	}
	
	public LDivIconOptions withBgPos(final LPoint bgPos)
	{
		this.setBgPos(bgPos);
		return this.self();
	}
}
