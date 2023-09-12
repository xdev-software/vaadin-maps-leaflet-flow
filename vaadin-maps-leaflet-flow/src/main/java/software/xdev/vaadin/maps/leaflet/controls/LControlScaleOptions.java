package software.xdev.vaadin.maps.leaflet.controls;

/**
 * @see <a href="https://leafletjs.com/reference.html#control-scale">Leaflet docs</a>
 */
public class LControlScaleOptions extends LControlOptions<LControlScaleOptions>
{
	private Integer maxWidth;
	private Boolean metric;
	private Boolean imperial;
	private Boolean updateWhenIdle;
	
	public Integer getMaxWidth()
	{
		return this.maxWidth;
	}
	
	public void setMaxWidth(final Integer maxWidth)
	{
		this.maxWidth = maxWidth;
	}
	
	public LControlScaleOptions withMaxWidth(final Integer maxWidth)
	{
		this.setMaxWidth(maxWidth);
		return this.self();
	}
	
	public Boolean getMetric()
	{
		return this.metric;
	}
	
	public void setMetric(final Boolean metric)
	{
		this.metric = metric;
	}
	
	public LControlScaleOptions withMetric(final Boolean metric)
	{
		this.setMetric(metric);
		return this.self();
	}
	
	public Boolean getImperial()
	{
		return this.imperial;
	}
	
	public void setImperial(final Boolean imperial)
	{
		this.imperial = imperial;
	}
	
	public LControlScaleOptions withImperial(final Boolean imperial)
	{
		this.setImperial(imperial);
		return this.self();
	}
	
	public Boolean getUpdateWhenIdle()
	{
		return this.updateWhenIdle;
	}
	
	public void setUpdateWhenIdle(final Boolean updateWhenIdle)
	{
		this.updateWhenIdle = updateWhenIdle;
	}
	
	public LControlScaleOptions withUpdateWhenIdle(final Boolean updateWhenIdle)
	{
		this.setUpdateWhenIdle(updateWhenIdle);
		return this.self();
	}
}
