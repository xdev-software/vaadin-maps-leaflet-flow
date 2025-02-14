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


/**
 * @see <a href="https://leafletjs.com/reference.html#pan-options">Leaflet docs</a>
 */
@SuppressWarnings("unused")
public interface LMapPanBaseOptions<S extends LMapPanBaseOptions<S>> extends LComponentOptions<S>
{
	Boolean getAnimate();
	
	void setAnimate(final Boolean animate);
	
	default S withAnimate(final Boolean animate)
	{
		this.setAnimate(animate);
		return this.self();
	}
	
	Number getDuration();
	
	void setDuration(final Number duration);
	
	default S withDuration(final Number duration)
	{
		this.setDuration(duration);
		return this.self();
	}
	
	Number getEaseLinearity();
	
	void setEaseLinearity(final Number easeLinearity);
	
	default S withEaseLinearity(final Number easeLinearity)
	{
		this.setEaseLinearity(easeLinearity);
		return this.self();
	}
	
	Boolean getNoMoveStart();
	
	void setNoMoveStart(final Boolean noMoveStart);
	
	default S withNoMoveStart(final Boolean noMoveStart)
	{
		this.setNoMoveStart(noMoveStart);
		return this.self();
	}
}
