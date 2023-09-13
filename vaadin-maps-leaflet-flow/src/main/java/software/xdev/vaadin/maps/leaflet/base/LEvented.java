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
package software.xdev.vaadin.maps.leaflet.base;

/**
 * @see <a href="https://leafletjs.com/reference.html#evented">Leaflet docs</a>
 */
public interface LEvented<S extends LEvented<S>> extends LComponent<S>
{
	// region On/Off/Once
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#evented-on">Leaflet docs</a>
	 */
	default S on(final String type, final String function, final String context)
	{
		this.invokeSelf(".on("
			+ "$0,"
			+ function
			+ (context != null ? "," + context : "")
			+ ")",
			type);
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#evented-on">Leaflet docs</a>
	 */
	default S on(final String type, final String function)
	{
		return this.on(type, function, null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#evented-on">Leaflet docs</a>
	 */
	default S on(final String eventMap)
	{
		this.invokeSelf(".on($0)", eventMap);
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#evented-off">Leaflet docs</a>
	 */
	default S off(final String type, final String function, final String context)
	{
		this.invokeSelf(".off("
				+ "$0,"
				+ (function != null ? "," + function : "")
				+ (context != null ? "," + context : "")
				+ ")",
			type);
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#evented-off">Leaflet docs</a>
	 */
	default S off(final String type)
	{
		return this.on(type, null, null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#evented-off">Leaflet docs</a>
	 */
	default S off()
	{
		this.invokeSelf(".off()");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#evented-once">Leaflet docs</a>
	 */
	default S once(final String type, final String function, final String context)
	{
		this.invokeSelf(".once("
				+ "$0,"
				+ function
				+ (context != null ? "," + context : "")
				+ ")",
			type);
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#evented-once">Leaflet docs</a>
	 */
	default S once(final String type, final String function)
	{
		return this.on(type, function, null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#evented-once">Leaflet docs</a>
	 */
	default S once(final String eventMap)
	{
		this.invokeSelf(".once($0)", eventMap);
		return this.self();
	}
	
	// endregion
	// region Fire/Listens
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#evented-fire">Leaflet docs</a>
	 */
	default S fire(final String type, final String data, final Boolean propagate)
	{
		this.invokeSelf("fire($0"
			+ (data != null ? "," + data : "")
			+ (propagate != null ? "," + propagate : "")
			+ ")", type);
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#evented-fire">Leaflet docs</a>
	 */
	default S fire(final String type, final String data)
	{
		return this.fire(type, data, null);
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#evented-fire">Leaflet docs</a>
	 */
	default S fire(final String type)
	{
		return this.fire(type, null);
	}
	
	// endregion
	// region Event Parent
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#evented-addeventparent">Leaflet docs</a>
	 */
	default S addEventParent(final LEvented<?> obj)
	{
		this.invokeSelf("addEventParent(" + obj.clientComponentJsAccessor() + ")");
		return this.self();
	}
	
	/**
	 * @see <a href="https://leafletjs.com/reference.html#evented-removeeventparent">Leaflet docs</a>
	 */
	default S removeEventParent(final LEvented<?> obj)
	{
		this.invokeSelf("removeEventParent(" + obj.clientComponentJsAccessor() + ")");
		return this.self();
	}
	
	// endregion
}
