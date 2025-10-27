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
package software.xdev.vaadin.maps.leaflet.map;

import software.xdev.vaadin.maps.leaflet.base.LComponentOptions;
import software.xdev.vaadin.maps.leaflet.basictypes.LPoint;


/**
 * @see <a href="https://leafletjs.com/reference.html#padding-options">Leaflet docs</a>
 */

public interface LMapPaddingBaseOptions<S extends LMapPaddingBaseOptions<S>> extends LComponentOptions<S>
{
	LPoint getPaddingTopLeft();
	
	void setPaddingTopLeft(final LPoint paddingTopLeft);
	
	default S withPaddingTopLeft(final LPoint paddingTopLeft)
	{
		this.setPaddingTopLeft(paddingTopLeft);
		return this.self();
	}
	
	LPoint getPaddingBottomRight();
	
	void setPaddingBottomRight(final LPoint paddingBottomRight);
	
	default S withPaddingBottomRight(final LPoint paddingBottomRight)
	{
		this.setPaddingBottomRight(paddingBottomRight);
		return this.self();
	}
	
	LPoint getPadding();
	
	void setPadding(final LPoint padding);
	
	default S withPadding(final LPoint padding)
	{
		this.setPadding(padding);
		return this.self();
	}
}
