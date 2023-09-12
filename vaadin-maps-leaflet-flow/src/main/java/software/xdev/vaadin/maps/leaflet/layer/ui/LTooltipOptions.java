package software.xdev.vaadin.maps.leaflet.layer.ui;

public class LTooltipOptions extends LDivOverlayOptions<LTooltipOptions>
{
	private String direction;
	private Boolean permanent;
	private Boolean sticky;
	private Double opacity;
	
	public String getDirection()
	{
		return this.direction;
	}
	
	public void setDirection(final String direction)
	{
		this.direction = direction;
	}
	
	public LTooltipOptions withDirection(final String direction)
	{
		this.setDirection(direction);
		return this.self();
	}
	
	public Boolean getPermanent()
	{
		return this.permanent;
	}
	
	public void setPermanent(final Boolean permanent)
	{
		this.permanent = permanent;
	}
	
	public LTooltipOptions withPermanent(final Boolean permanent)
	{
		this.setPermanent(permanent);
		return this.self();
	}
	
	public Boolean getSticky()
	{
		return this.sticky;
	}
	
	public void setSticky(final Boolean sticky)
	{
		this.sticky = sticky;
	}
	
	public LTooltipOptions withSticky(final Boolean sticky)
	{
		this.setSticky(sticky);
		return this.self();
	}
	
	public Double getOpacity()
	{
		return this.opacity;
	}
	
	public void setOpacity(final Double opacity)
	{
		this.opacity = opacity;
	}
	
	public LTooltipOptions withOpacity(final Double opacity)
	{
		this.setOpacity(opacity);
		return this.self();
	}
}
