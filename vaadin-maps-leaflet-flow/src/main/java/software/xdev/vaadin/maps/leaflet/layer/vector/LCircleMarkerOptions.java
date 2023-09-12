package software.xdev.vaadin.maps.leaflet.layer.vector;


/**
 * @see <a href="https://leafletjs.com/reference.html#circlemarker">Leaflet docs</a>
 */
public class LCircleMarkerOptions extends LPathOptions<LCircleMarkerOptions>
{
	private Integer radius;
	
	public Integer getRadius()
	{
		return this.radius;
	}
	
	public void setRadius(final Integer radius)
	{
		this.radius = radius;
	}
	
	public LCircleMarkerOptions withRadius(final Integer radius)
	{
		this.setRadius(radius);
		return this.self();
	}
}
