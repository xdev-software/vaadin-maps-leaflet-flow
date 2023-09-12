package software.xdev.vaadin.maps.leaflet.layer;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import software.xdev.vaadin.maps.leaflet.base.has.LHasSetZIndex;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#layergroup">Leaflet docs</a>
 */
public class LLayerGroup extends LLayer<LLayerGroup> implements LHasSetZIndex<LLayerGroup>
{
	public LLayerGroup(
		final LComponentManagementRegistry compReg,
		final LLayer<?>[] layers,
		final LLayerOptions<?>[] options)
	{
		super(
			compReg,
			"L.layerGroup("
				+ (layers != null
				? "[" + Stream.of(layers).map(LLayer::clientComponentJsAccessor).collect(Collectors.joining(",")) + "]"
				: "")
				+ (options != null
				? ", ["+ Stream.of(options).map(compReg::writeOptionsOrEmptyObject).collect(Collectors.joining(","))+ "]"
				: "")
				+ ")");
	}
	
	public LLayerGroup(
		final LComponentManagementRegistry compReg,
		final LLayer<?>... layers)
	{
		this(compReg, layers, null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layergroup-addlayer">Leaflet Docs</a>
	 */
	public LLayerGroup addLayer(final LLayer<?> layer)
	{
		this.invokeSelf(".addLayer(" + layer.clientComponentJsAccessor() + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layergroup-removelayer">Leaflet Docs</a>
	 */
	public LLayerGroup removeLayer(final LLayer<?> layer)
	{
		this.invokeSelf(".removeLayer(" + layer.clientComponentJsAccessor() + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#layergroup-clearlayers">Leaflet Docs</a>
	 */
	public LLayerGroup clearLayers()
	{
		this.invokeSelf(".clearLayers()");
		return this.self();
	}
}
