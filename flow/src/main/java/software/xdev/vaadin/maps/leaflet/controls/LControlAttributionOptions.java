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
package software.xdev.vaadin.maps.leaflet.controls;

/**
 * @see <a href="https://leafletjs.com/reference.html#control-attribution">Leaflet docs</a>
 */
public class LControlAttributionOptions extends LControlOptions<LControlAttributionOptions>
{
	// String|false
	private Object prefix;
	
	public Object getPrefix()
	{
		return this.prefix;
	}
	
	public void setPrefix(final Object prefix)
	{
		this.prefix = prefix;
	}
	
	public LControlAttributionOptions withPrefix(final Object prefix)
	{
		this.setPrefix(prefix);
		return this.self();
	}
}
