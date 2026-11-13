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
package software.xdev.vaadin.maps.leaflet.layer.raster;

import java.io.Serializable;

import software.xdev.vaadin.maps.leaflet.base.has.LHasBringTo;
import software.xdev.vaadin.maps.leaflet.base.has.LHasOpacity;
import software.xdev.vaadin.maps.leaflet.basictypes.LLatLngBounds;
import software.xdev.vaadin.maps.leaflet.layer.LInteractiveLayer;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#imageoverlay">Leaflet docs</a>
 */
public class LImageOverlay extends LInteractiveLayer<LImageOverlay>
	implements LHasBringTo<LImageOverlay>, LHasOpacity<LImageOverlay>
{
	protected LImageOverlay(
		final LComponentManagementRegistry compReg,
		final String jsConstructorCallExpression,
		final Serializable... parameters)
	{
		super(compReg, jsConstructorCallExpression, parameters);
	}
	
	public LImageOverlay(
		final LComponentManagementRegistry compReg,
		final String imageUrl,
		final LLatLngBounds bounds,
		final LImageOverlayOptions options)
	{
		super(
			compReg,
			"L.imageOverlay($0, "
				+ bounds.clientComponentJsAccessor()
				+ compReg.writeOptionsOptionalNextParameter(options) + ")",
			imageUrl);
	}
	
	public LImageOverlay(
		final LComponentManagementRegistry compReg,
		final String imageUrl,
		final LLatLngBounds bounds)
	{
		this(compReg, imageUrl, bounds, null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#imageoverlay-setbounds">Leaflet docs</a>
	 */
	public LImageOverlay setBounds(final LLatLngBounds bounds)
	{
		this.invokeSelf(".setBounds(" + bounds.clientComponentJsAccessor() + ")");
		return this.self();
	}
}
