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
package software.xdev.vaadin.maps.leaflet.geoman.layer;

import software.xdev.vaadin.maps.leaflet.base.LAbstractComponent;
import software.xdev.vaadin.maps.leaflet.basictypes.LLatLng;
import software.xdev.vaadin.maps.leaflet.geoman.LAbstractEditOptions;
import software.xdev.vaadin.maps.leaflet.layer.LLayer;


/**
 * @see <a href="https://geoman.io/docs/leaflet/">Docs</a>
 */
public class LLayerPM extends LAbstractComponent<LLayerPM>
{
	private final LLayer<?> layer;
	
	public LLayerPM(final LLayer<?> layer)
	{
		super(layer.componentRegistry());
		this.layer = layer;
	}
	
	public LLayerPM enable(final LAbstractEditOptions<?> options)
	{
		this.invokeSelf(".enable(" + this.componentRegistry().writeOptionsOrEmptyObject(options) + ")");
		return this;
	}
	
	public LLayerPM disable()
	{
		this.invokeSelf(".disable()");
		return this;
	}
	
	public LLayerPM toggleEdit(final LAbstractEditOptions<?> options)
	{
		this.invokeSelf(".toggleEdit(" + this.componentRegistry().writeOptionsOrEmptyObject(options) + ")");
		return this;
	}
	
	public LLayerPM remove()
	{
		this.invokeSelf(".remove()");
		return this;
	}
	
	public LLayerPM setOptions(final LAbstractEditOptions<?> options)
	{
		this.invokeSelf(".setOptions(" + this.componentRegistry().writeOptionsOrEmptyObject(options) + ")");
		return this;
	}
	
	public LLayerPM enableLayerDrag()
	{
		this.invokeSelf(".enableLayerDrag()");
		return this;
	}
	
	public LLayerPM disableLayerDrag()
	{
		this.invokeSelf(".disableLayerDrag()");
		return this;
	}
	
	public LLayerPM enableRotate()
	{
		this.invokeSelf(".enableRotate()");
		return this;
	}
	
	public LLayerPM disableRotate()
	{
		this.invokeSelf(".disableRotate()");
		return this;
	}
	
	public LLayerPM rotateLayer(final Number degrees)
	{
		this.invokeSelf(".rotateLayer($0)", degrees);
		return this;
	}
	
	public LLayerPM rotateLayerToAngle(final Number degrees)
	{
		this.invokeSelf(".rotateLayerToAngle($0)", degrees);
		return this;
	}
	
	public LLayerPM setInitAngle(final Number degrees)
	{
		this.invokeSelf(".setInitAngle($0)", degrees);
		return this;
	}
	
	public LLayerPM setRotationCenter(final LLatLng center)
	{
		this.invokeSelf(".setRotationCenter(" + center.clientComponentJsAccessor() + ")");
		return this;
	}
	
	@Override
	public String clientComponentJsAccessor()
	{
		return this.layer.clientComponentJsAccessor() + ".pm";
	}
}
