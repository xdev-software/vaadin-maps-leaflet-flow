/*
 * Copyright © 2019 XDEV Software (https://xdev.software)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package software.xdev.vaadin.maps.leaflet.markercluster.layer.other;

import java.util.Collection;
import java.util.stream.Collectors;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

import software.xdev.vaadin.maps.leaflet.base.LBaseComponent;
import software.xdev.vaadin.maps.leaflet.layer.LAbstractLayerGroup;
import software.xdev.vaadin.maps.leaflet.layer.LLayer;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://github.com/Leaflet/Leaflet.markercluster">Docs</a>
 */
@NpmPackage(value = "leaflet.markercluster", version = "1.5.3")
@JsModule("leaflet.markercluster/dist/leaflet.markercluster.js")
@CssImport("leaflet.markercluster/dist/MarkerCluster.css")
@CssImport("leaflet.markercluster/dist/MarkerCluster.Default.css")
public class LMarkerClusterGroup extends LAbstractLayerGroup<LMarkerClusterGroup>
{
	public LMarkerClusterGroup(
		final LComponentManagementRegistry compReg,
		final LAbstractMarkerClusterGroupOptions<?> options)
	{
		super(
			compReg,
			"L.markerClusterGroup("
				+ compReg.writeOptions(options)
				+ ")");
	}
	
	public LMarkerClusterGroup(final LComponentManagementRegistry compReg)
	{
		this(compReg, null);
	}
	
	public LMarkerClusterGroup refreshClusters()
	{
		this.invokeSelf(".refreshClusters()");
		return this.self();
	}
	
	public LMarkerClusterGroup refreshClusters(final LLayer<?> layer)
	{
		this.invokeSelf(".refreshClusters(" + layer.clientComponentJsAccessor() + ")");
		return this.self();
	}
	
	public LMarkerClusterGroup refreshClusters(final Collection<LLayer<?>> layers)
	{
		this.invokeSelf(".refreshClusters(["
			+ layers.stream().map(LBaseComponent::clientComponentJsAccessor).collect(Collectors.joining(", "))
			+ "])");
		return this.self();
	}
	
	public LMarkerClusterGroup zoomToShowLayer(final LLayer<?> layer)
	{
		return this.zoomToShowLayer(layer, null);
	}
	
	public LMarkerClusterGroup zoomToShowLayer(final LLayer<?> layer, final String callback)
	{
		this.invokeSelf(".zoomToShowLayer("
				+ layer.clientComponentJsAccessor()
				+ (callback != null ? ", " + callback : "")
				+ ")");
		return this.self();
	}
}
