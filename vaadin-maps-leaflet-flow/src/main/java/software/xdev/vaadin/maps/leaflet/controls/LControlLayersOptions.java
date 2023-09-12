package software.xdev.vaadin.maps.leaflet.controls;

import software.xdev.vaadin.maps.leaflet.base.RawString;


/**
 * @see <a href="https://leafletjs.com/reference.html#control-layers">Leaflet docs</a>
 */
public class LControlLayersOptions extends LControlOptions<LControlLayersOptions>
{
	private Boolean collapsed;
	private Boolean autoZIndex;
	private Boolean hideSingleBase;
	private Boolean sortLayers;
	private RawString sortFunction;
	
	public Boolean getCollapsed()
	{
		return this.collapsed;
	}
	
	public void setCollapsed(final Boolean collapsed)
	{
		this.collapsed = collapsed;
	}
	
	public LControlLayersOptions withCollapsed(final Boolean collapsed)
	{
		this.setCollapsed(collapsed);
		return this.self();
	}
	
	public Boolean getAutoZIndex()
	{
		return this.autoZIndex;
	}
	
	public void setAutoZIndex(final Boolean autoZIndex)
	{
		this.autoZIndex = autoZIndex;
	}
	
	public LControlLayersOptions withAutoZIndex(final Boolean autoZIndex)
	{
		this.setAutoZIndex(autoZIndex);
		return this.self();
	}
	
	public Boolean getHideSingleBase()
	{
		return this.hideSingleBase;
	}
	
	public void setHideSingleBase(final Boolean hideSingleBase)
	{
		this.hideSingleBase = hideSingleBase;
	}
	
	public LControlLayersOptions withHideSingleBase(final Boolean hideSingleBase)
	{
		this.setHideSingleBase(hideSingleBase);
		return this.self();
	}
	
	public Boolean getSortLayers()
	{
		return this.sortLayers;
	}
	
	public void setSortLayers(final Boolean sortLayers)
	{
		this.sortLayers = sortLayers;
	}
	
	public LControlLayersOptions withSortLayers(final Boolean sortLayers)
	{
		this.setSortLayers(sortLayers);
		return this.self();
	}
	
	public RawString getSortFunction()
	{
		return this.sortFunction;
	}
	
	public void setSortFunction(final RawString sortFunction)
	{
		this.sortFunction = sortFunction;
	}
	
	public LControlLayersOptions withSortFunction(final RawString sortFunction)
	{
		this.setSortFunction(sortFunction);
		return this.self();
	}
}
