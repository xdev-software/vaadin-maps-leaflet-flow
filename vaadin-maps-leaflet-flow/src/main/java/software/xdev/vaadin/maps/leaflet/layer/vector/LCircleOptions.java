package software.xdev.vaadin.maps.leaflet.layer.vector;


/**
 * @see <a href="https://leafletjs.com/reference.html#circle">Leaflet docs</a>
 */
public class LCircleOptions extends LPathOptions<LCircleOptions>
{
	private Double radius;
	
	public Double getRadius()
	{
		return this.radius;
	}
	
	public void setRadius(final Double radius)
	{
		this.radius = radius;
	}
	
	public LCircleOptions withRadius(final Double radius)
	{
		this.setRadius(radius);
		return this.self();
	}
}
