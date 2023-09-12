package software.xdev.vaadin.maps.leaflet.map;

/**
 * @see <a href="https://leafletjs.com/reference.html#pan-options">Leaflet docs</a>
 */
public class LMapPanOptions implements LMapPanBaseOptions<LMapPanOptions>
{
	private Boolean animate;
	private Double duration;
	private Double easeLinearity;
	private Boolean noMoveStart;
	
	@Override
	public Boolean getAnimate()
	{
		return this.animate;
	}
	
	@Override
	public void setAnimate(final Boolean animate)
	{
		this.animate = animate;
	}
	
	@Override
	public Double getDuration()
	{
		return this.duration;
	}
	
	@Override
	public void setDuration(final Double duration)
	{
		this.duration = duration;
	}
	
	@Override
	public Double getEaseLinearity()
	{
		return this.easeLinearity;
	}
	
	@Override
	public void setEaseLinearity(final Double easeLinearity)
	{
		this.easeLinearity = easeLinearity;
	}
	
	@Override
	public Boolean getNoMoveStart()
	{
		return this.noMoveStart;
	}
	
	@Override
	public void setNoMoveStart(final Boolean noMoveStart)
	{
		this.noMoveStart = noMoveStart;
	}
}
