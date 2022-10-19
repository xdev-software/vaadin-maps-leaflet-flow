package software.xdev.vaadin.maps.leaflet.flow.data;

public class LLayerControlOptions
{
	private boolean collapsed = true;
	private boolean hideSingleBase = false;
	
	public boolean isCollapsed()
	{
		return collapsed;
	}
	
	public void setCollapsed(final boolean collapsed)
	{
		this.collapsed = collapsed;
	}
	
	public boolean isHideSingleBase()
	{
		return hideSingleBase;
	}
	
	public void setHideSingleBase(final boolean hideSingleBase)
	{
		this.hideSingleBase = hideSingleBase;
	}
}
