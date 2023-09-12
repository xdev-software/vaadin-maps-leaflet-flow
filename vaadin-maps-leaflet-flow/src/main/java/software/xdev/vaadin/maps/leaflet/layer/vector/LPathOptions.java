package software.xdev.vaadin.maps.leaflet.layer.vector;

import software.xdev.vaadin.maps.leaflet.layer.LInteractiveLayerOptions;


/**
 * @see <a href="https://leafletjs.com/reference.html#path">Leaflet docs</a>
 */
public abstract class LPathOptions<S extends LPathOptions<S>> extends LInteractiveLayerOptions<S>
{
	private Boolean stroke;
	private String color;
	private Integer weight;
	private Double opacity;
	private String lineCap;
	private String lineJoin;
	private String dashArray;
	private String dashOffset;
	private Boolean fill;
	private String fillColor;
	private Double fillOpacity;
	private String fillRule;
	private LRenderer<?> renderer;
	private String className;
	
	public Boolean getStroke()
	{
		return this.stroke;
	}
	
	public void setStroke(final Boolean stroke)
	{
		this.stroke = stroke;
	}
	
	public S withStroke(final Boolean stroke)
	{
		this.setStroke(stroke);
		return this.self();
	}
	
	public String getColor()
	{
		return this.color;
	}
	
	public void setColor(final String color)
	{
		this.color = color;
	}
	
	public S withColor(final String color)
	{
		this.withColor(color);
		return this.self();
	}
	
	public Integer getWeight()
	{
		return this.weight;
	}
	
	public void setWeight(final Integer weight)
	{
		this.weight = weight;
	}
	
	public S withWeight(final Integer weight)
	{
		this.setWeight(weight);
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
	
	public S withOpacity(final Double opacity)
	{
		this.setOpacity(opacity);
		return this.self();
	}
	
	public String getLineCap()
	{
		return this.lineCap;
	}
	
	public void setLineCap(final String lineCap)
	{
		this.lineCap = lineCap;
	}
	
	public S withLineCap(final String lineCap)
	{
		this.setLineCap(lineCap);
		return this.self();
	}
	
	public String getLineJoin()
	{
		return this.lineJoin;
	}
	
	public void setLineJoin(final String lineJoin)
	{
		this.lineJoin = lineJoin;
	}
	
	public S withLineJoin(final String lineJoin)
	{
		this.setLineJoin(lineJoin);
		return this.self();
	}
	
	public String getDashArray()
	{
		return this.dashArray;
	}
	
	public void setDashArray(final String dashArray)
	{
		this.dashArray = dashArray;
	}
	
	public S withDashArray(final String dashArray)
	{
		this.setDashArray(dashArray);
		return this.self();
	}
	
	public String getDashOffset()
	{
		return this.dashOffset;
	}
	
	public void setDashOffset(final String dashOffset)
	{
		this.dashOffset = dashOffset;
	}
	
	public S withDashOffset(final String dashOffset)
	{
		this.setDashOffset(dashOffset);
		return this.self();
	}
	
	public Boolean getFill()
	{
		return this.fill;
	}
	
	public void setFill(final Boolean fill)
	{
		this.fill = fill;
	}
	
	public S withFill(final Boolean fill)
	{
		this.setFill(fill);
		return this.self();
	}
	
	public String getFillColor()
	{
		return this.fillColor;
	}
	
	public void setFillColor(final String fillColor)
	{
		this.fillColor = fillColor;
	}
	
	public S withFillColor(final String fillColor)
	{
		this.setFillColor(fillColor);
		return this.self();
	}
	
	public Double getFillOpacity()
	{
		return this.fillOpacity;
	}
	
	public void setFillOpacity(final Double fillOpacity)
	{
		this.fillOpacity = fillOpacity;
	}
	
	public S withFillOpacity(final Double fillOpacity)
	{
		this.setFillOpacity(fillOpacity);
		return this.self();
	}
	
	public String getFillRule()
	{
		return this.fillRule;
	}
	
	public void setFillRule(final String fillRule)
	{
		this.fillRule = fillRule;
	}
	
	public S withFillRule(final String fillRule)
	{
		this.setFillRule(fillRule);
		return this.self();
	}
	
	public LRenderer<?> getRenderer()
	{
		return this.renderer;
	}
	
	public void setRenderer(final LRenderer<?> renderer)
	{
		this.renderer = renderer;
	}
	
	public S withRenderer(final LRenderer<?> renderer)
	{
		this.setRenderer(renderer);
		return this.self();
	}
	
	public String getClassName()
	{
		return this.className;
	}
	
	public void setClassName(final String className)
	{
		this.className = className;
	}
	
	public S withClassName(final String className)
	{
		this.setClassName(className);
		return this.self();
	}
}
