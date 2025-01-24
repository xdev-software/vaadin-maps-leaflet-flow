package software.xdev.vaadin.maps.leaflet.layer.raster;


/**
 * @see <a href="https://leafletjs.com/reference.html#tilelayer-wms-option">Leaflet docs</a>
 */
public class LTileLayerWMSOptions extends LAbstractTileLayerOptions<LTileLayerWMSOptions>
{
	private String layers;
	private String styles;
	private String format;
	private Boolean transparent;
	private String version;
	private Object crs;
	private Boolean uppercase;
	
	public String getLayers()
	{
		return this.layers;
	}
	
	public void setLayers(final String layers)
	{
		this.layers = layers;
	}
	
	public LTileLayerWMSOptions withLayers(final String layers)
	{
		this.setLayers(layers);
		return this.self();
	}
	
	public String getStyles()
	{
		return this.styles;
	}
	
	public void setStyles(final String styles)
	{
		this.styles = styles;
	}
	
	public LTileLayerWMSOptions withStyles(final String styles)
	{
		this.setStyles(styles);
		return this.self();
	}
	
	public String getFormat()
	{
		return this.format;
	}
	
	public void setFormat(final String format)
	{
		this.format = format;
	}
	
	public LTileLayerWMSOptions withFormat(final String format)
	{
		this.setFormat(format);
		return this.self();
	}
	
	public Boolean getTransparent()
	{
		return this.transparent;
	}
	
	public void setTransparent(final Boolean transparent)
	{
		this.transparent = transparent;
	}
	
	public LTileLayerWMSOptions withTransparent(final Boolean transparent)
	{
		this.setTransparent(transparent);
		return this.self();
	}
	
	public String getVersion()
	{
		return this.version;
	}
	
	public void setVersion(final String version)
	{
		this.version = version;
	}
	
	public LTileLayerWMSOptions withVersion(final String version)
	{
		this.setVersion(version);
		return this.self();
	}
	
	public Object getCrs()
	{
		return this.crs;
	}
	
	public void setCrs(final Object crs)
	{
		this.crs = crs;
	}
	
	public LTileLayerWMSOptions withCrs(final Object crs)
	{
		this.setCrs(crs);
		return this.self();
	}
	
	public Boolean getUppercase()
	{
		return this.uppercase;
	}
	
	public void setUppercase(final Boolean uppercase)
	{
		this.uppercase = uppercase;
	}
	
	public LTileLayerWMSOptions withUppercase(final Boolean uppercase)
	{
		this.setUppercase(uppercase);
		return this.self();
	}
}
