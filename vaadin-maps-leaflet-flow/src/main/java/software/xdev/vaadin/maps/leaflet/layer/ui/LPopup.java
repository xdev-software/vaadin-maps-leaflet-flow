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
package software.xdev.vaadin.maps.leaflet.layer.ui;

import software.xdev.vaadin.maps.leaflet.basictypes.LLatLng;
import software.xdev.vaadin.maps.leaflet.layer.LLayer;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


public class LPopup extends LDivOverlay<LPopup>
{
	public LPopup(
		final LComponentManagementRegistry compReg,
		final LPopupOptions options,
		final LLayer<?> source)
	{
		super(compReg, "L.popup("
			+ compReg.writeOptions(options)
			+ (source != null ? ", " + source.clientComponentJsAccessor() : "")
			+ ")");
	}
	
	public LPopup(
		final LComponentManagementRegistry compReg,
		final LPopupOptions options)
	{
		this(compReg, options, null);
	}
	
	public LPopup(final LComponentManagementRegistry compReg)
	{
		super(compReg, "L.popup()");
	}
	
	public LPopup(
		final LComponentManagementRegistry compReg,
		final LLatLng latLng,
		final LPopupOptions options)
	{
		super(compReg, "L.popup("
			+ latLng.clientComponentJsAccessor()
			+ compReg.writeOptionsOptionalParameter(options)
			+ ")");
	}
	
	public LPopup(
		final LComponentManagementRegistry compReg,
		final LLatLng latLng)
	{
		this(compReg, latLng, null);
	}
}
