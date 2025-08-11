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
package software.xdev.vaadin.maps.leaflet.geoman.map;

import software.xdev.vaadin.maps.leaflet.base.LAbstractComponent;
import software.xdev.vaadin.maps.leaflet.geoman.LAbstractDrawOptions;
import software.xdev.vaadin.maps.leaflet.geoman.LAbstractDrawOrEditOptions;
import software.xdev.vaadin.maps.leaflet.geoman.LAbstractEditOptions;
import software.xdev.vaadin.maps.leaflet.geoman.LDrawOptions;
import software.xdev.vaadin.maps.leaflet.geoman.LTextOptions;
import software.xdev.vaadin.maps.leaflet.map.LMap;


/**
 * @see <a href="https://geoman.io/docs/leaflet/">Docs</a>
 */
public class LMapPM extends LAbstractComponent<LMapPM>
{
	private final LMap map;
	
	public LMapPM(final LMap map)
	{
		super(map.componentRegistry());
		this.map = map;
	}
	
	public LMapPM addControls()
	{
		return this.addControls(null);
	}
	
	public LMapPM addControls(final LAbstractMapPMControlOptions<?> options)
	{
		this.invokeSelf(".addControls(" + this.componentRegistry().writeOptions(options) + ")");
		return this;
	}
	
	public LMapPM removeControls()
	{
		this.invokeSelf(".removeControls()");
		return this;
	}
	
	public LMapPM toggleControls()
	{
		this.invokeSelf(".toggleControls()");
		return this;
	}
	
	public LMapPM enableDraw(final String shape)
	{
		return this.enableDraw(shape, null);
	}
	
	public LMapPM enableDraw(final String shape, final LAbstractDrawOptions<?> options)
	{
		this.invokeSelf(".enableDraw('" + shape + "'"
			+ this.componentRegistry().writeOptionsOptionalNextParameter(options)
			+ ")");
		return this;
	}
	
	public LMapPM enableDrawText(final LTextOptions textOptions)
	{
		return this.enableDraw("Text", new LDrawOptions().withTextOptions(textOptions));
	}
	
	public LMapPM disableDraw()
	{
		this.invokeSelf(".disableDraw()");
		return this;
	}
	
	public LMapPM setGlobalOptions(final LAbstractDrawOrEditOptions<?> options)
	{
		this.invokeSelf(".setGlobalOptions(" + this.componentRegistry().writeOptionsOrEmptyObject(options) + ")");
		return this;
	}
	
	public LMapPM applyGlobalOptions()
	{
		this.invokeSelf(".applyGlobalOptions()");
		return this;
	}
	
	public LMapPM enableGlobalEditMode(final LAbstractEditOptions<?> options)
	{
		this.invokeSelf(".enableGlobalEditMode(" + this.componentRegistry().writeOptionsOrEmptyObject(options) + ")");
		return this;
	}
	
	public LMapPM disableGlobalEditMode()
	{
		this.invokeSelf(".disableGlobalEditMode()");
		return this;
	}
	
	public LMapPM toggleGlobalEditMode(final LAbstractEditOptions<?> options)
	{
		this.invokeSelf(".toggleGlobalEditMode(" + this.componentRegistry().writeOptionsOrEmptyObject(options) + ")");
		return this;
	}
	
	public LMapPM enableGlobalDragMode()
	{
		this.invokeSelf(".enableGlobalDragMode()");
		return this;
	}
	
	public LMapPM disableGlobalDragMode()
	{
		this.invokeSelf(".disableGlobalDragMode()");
		return this;
	}
	
	public LMapPM toggleGlobalDragMode()
	{
		this.invokeSelf(".toggleGlobalDragMode()");
		return this;
	}
	
	public LMapPM enableGlobalRemovalMode()
	{
		this.invokeSelf(".enableGlobalRemovalMode()");
		return this;
	}
	
	public LMapPM disableGlobalRemovalMode()
	{
		this.invokeSelf(".disableGlobalRemovalMode()");
		return this;
	}
	
	public LMapPM toggleGlobalRemovalMode()
	{
		this.invokeSelf(".toggleGlobalRemovalMode()");
		return this;
	}
	
	public LMapPM enableGlobalCutMode(final LAbstractEditOptions<?> options)
	{
		this.invokeSelf(".enableGlobalCutMode(" + this.componentRegistry().writeOptionsOrEmptyObject(options) + ")");
		return this;
	}
	
	public LMapPM disableGlobalCutMode()
	{
		this.invokeSelf(".disableGlobalCutMode()");
		return this;
	}
	
	public LMapPM toggleGlobalCutMode(final LAbstractEditOptions<?> options)
	{
		this.invokeSelf(".toggleGlobalCutMode(" + this.componentRegistry().writeOptionsOrEmptyObject(options) + ")");
		return this;
	}
	
	public LMapPM enableGlobalRotateMode()
	{
		this.invokeSelf(".enableGlobalRotateMode()");
		return this;
	}
	
	public LMapPM disableGlobalRotateMode()
	{
		this.invokeSelf(".disableGlobalRotateMode()");
		return this;
	}
	
	public LMapPM toggleGlobalRotateMode()
	{
		this.invokeSelf(".toggleGlobalRotateMode()");
		return this;
	}
	
	@Override
	public String clientComponentJsAccessor()
	{
		return this.map.clientComponentJsAccessor() + ".pm";
	}
}
