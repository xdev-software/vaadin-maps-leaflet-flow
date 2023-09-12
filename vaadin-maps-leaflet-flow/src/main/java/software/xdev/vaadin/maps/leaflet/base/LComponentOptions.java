package software.xdev.vaadin.maps.leaflet.base;

public interface LComponentOptions<S extends LComponentOptions<S>>
{
	@SuppressWarnings("unchecked")
	default S self()
	{
		return (S)this;
	}
}
