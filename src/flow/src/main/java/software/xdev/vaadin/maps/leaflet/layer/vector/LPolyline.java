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
package software.xdev.vaadin.maps.leaflet.layer.vector;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import software.xdev.vaadin.maps.leaflet.basictypes.LLatLng;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#polyline">Leaflet docs</a>
 */
public class LPolyline extends LPath<LPolyline>
{
	protected LPolyline(
		final LComponentManagementRegistry compReg,
		final String jsConstructorCallExpression,
		final Serializable... parameters)
	{
		super(compReg, jsConstructorCallExpression, parameters);
	}
	
	protected LPolyline(
		final LComponentManagementRegistry compReg,
		final String constructorMethod,
		final Collection<?> latLngs,
		final LPolylineOptions options)
	{
		super(compReg, constructorMethod + "("
			+ convertMultiLatLngs(latLngs)
			+ compReg.writeOptionsOptionalNextParameter(options)
			+ ")");
	}
	
	public LPolyline(
		final LComponentManagementRegistry compReg,
		final Collection<?> latLngs,
		final LPolylineOptions options)
	{
		this(compReg, "L.polyline", latLngs, options);
	}
	
	public LPolyline(
		final LComponentManagementRegistry compReg,
		final Collection<?> latLngs)
	{
		this(compReg, latLngs, null);
	}
	
	public LPolyline(
		final LComponentManagementRegistry compReg,
		final LLatLng... latLngs)
	{
		this(compReg, List.of(latLngs), null);
	}
	
	protected static String convertMultiLatLngs(final Collection<?> latLngsData)
	{
		final Object peekedElement = latLngsData.stream().findFirst().orElse(null);
		if(peekedElement instanceof LLatLng)
		{
			return convertLatLngs(latLngsData.stream()
				.filter(LLatLng.class::isInstance)
				.map(LLatLng.class::cast)
				.toList());
		}
		
		return "["
			+ latLngsData.stream()
			.filter(Collection.class::isInstance)
			.map(Collection.class::cast)
			.map(c -> {
				if(c.isEmpty())
				{
					return "[]";
				}
				return convertMultiLatLngs(c);
			})
			.collect(Collectors.joining(","))
			+ "]";
	}
	
	protected static String convertLatLngs(final Collection<LLatLng> latLngs)
	{
		return "[" + latLngs.stream().map(LLatLng::clientComponentJsAccessor).collect(Collectors.joining(",")) + "]";
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#polyline-setlatlngs">Leaflet docs</a>
	 */
	public LPolyline setLatLngs(final LLatLng... latLngs)
	{
		return this.setLatLngs(List.of(latLngs));
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#polyline-setlatlngs">Leaflet docs</a>
	 */
	public LPolyline setLatLngs(final Collection<LLatLng> latLngs)
	{
		this.invokeSelf(
			".setLatLngs([" + latLngs.stream().map(LLatLng::clientComponentJsAccessor).collect(Collectors.joining(","))
				+ "])");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#polyline-addlatlng">Leaflet docs</a>
	 */
	public LPolyline addLatLng(final LLatLng latLng, final Collection<LLatLng> latLngs)
	{
		this.invokeSelf(".addLatLng("
			+ latLng.clientComponentJsAccessor()
			+ (latLngs != null
			? "," + convertMultiLatLngs(latLngs)
			: "")
			+ ")");
		return this.self();
	}
}
