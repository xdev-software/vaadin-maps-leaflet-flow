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
package software.xdev.vaadin.maps.leaflet.layer.vector.maplibregl;

import software.xdev.vaadin.maps.leaflet.base.LComponentOptions;


/**
 * @see <a href="https://maplibre.org/maplibre-gl-js/docs/API/type-aliases/MapOptions/">MapLibre docs</a>
 */
public abstract class LAbstractMaplibreGLOptions<S extends LAbstractMaplibreGLOptions<S>>
	implements LComponentOptions<S>
{
	private String style;
	
	public String getStyle()
	{
		return this.style;
	}
	
	public void setStyle(final String style)
	{
		this.style = style;
	}
	
	public S withStyle(final String style)
	{
		this.setStyle(style);
		return this.self();
	}
}
