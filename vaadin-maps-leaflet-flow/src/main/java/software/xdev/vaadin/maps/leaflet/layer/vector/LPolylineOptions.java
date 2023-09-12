package software.xdev.vaadin.maps.leaflet.layer.vector;

public class LPolylineOptions extends LPathOptions<LPolylineOptions>
{
	private Double smoothFactor;
	private Boolean noClip;
	
	public Double getSmoothFactor()
	{
		return this.smoothFactor;
	}
	
	public void setSmoothFactor(final Double smoothFactor)
	{
		this.smoothFactor = smoothFactor;
	}
	
	public LPolylineOptions withSmoothFactor(final Double smoothFactor)
	{
		this.setSmoothFactor(smoothFactor);
		return this.self();
	}
	
	public Boolean getNoClip()
	{
		return this.noClip;
	}
	
	public void setNoClip(final Boolean noClip)
	{
		this.noClip = noClip;
	}
	
	public LPolylineOptions withNoClip(final Boolean noClip)
	{
		this.setNoClip(noClip);
		return this.self();
	}
}
