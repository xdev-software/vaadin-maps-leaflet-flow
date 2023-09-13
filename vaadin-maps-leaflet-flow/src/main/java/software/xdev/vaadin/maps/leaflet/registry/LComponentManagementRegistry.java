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
package software.xdev.vaadin.maps.leaflet.registry;

import java.io.Serializable;

import com.vaadin.flow.component.page.PendingJavaScriptResult;

import software.xdev.vaadin.maps.leaflet.base.LComponent;
import software.xdev.vaadin.maps.leaflet.base.LComponentOptions;


public interface LComponentManagementRegistry
{
	// region Write Options
	String writeOptionsOptionalParameter(final LComponentOptions<?> options);
	
	String writeOptions(final LComponentOptions<?> options);
	
	String writeOptionsOrEmptyObject(final LComponentOptions<?> options);
	
	// endregion
	// region Tracking
	
	/**
	 * Creates the component on the client side and tracks it.
	 *
	 * @implNote The component is tracked on the server side inside a {@link java.util.WeakHashMap} which means that
	 * it's can vanish (get garbage collected) to free up memory - when it's not used otherwise (e.g. in a Variable or
	 * Lambda). This is a memory-optimization for cases where lots of components are added and removed.
	 */
	<C extends LComponent<C>> C add(
		final C component,
		final String jsConstructorCallExpression,
		final Serializable... parameters);
	
	/**
	 * Returns an expression to access the component on the client with JavaScript
	 */
	String clientComponentJsAccessor(final LComponent<?> component);
	
	/**
	 * Wrapper for {@link com.vaadin.flow.dom.Element#executeJs(String, Serializable...)}.
	 * <p/>
	 * Usage is normally not recommended however there are some corner cases where it's required.
	 */
	PendingJavaScriptResult execJs(final String js, final Serializable... params);
	
	/**
	 * Calls {@link #remove(LComponent, boolean)} with <code>freeUpClientWhenNoMatch = true</code>
	 *
	 * @see #remove(LComponent, boolean)
	 */
	default <C extends LComponent<C>> void remove(final C component)
	{
		this.remove(component, true);
	}
	
	/**
	 * Removes the tracked component from the client.
	 * <p/>
	 * If the component can't be found {@link #freeUpClient()} is called when specified.
	 */
	<C extends LComponent<C>> void remove(final C component, final boolean freeUpClientWhenNoMatch);
	
	/**
	 * Tries to free up unused components on the client.
	 * @implNote Freeing up is only executed when the server detects that a component on server side vanished (got
	 * garbage collected). If this is true a full resync of all tracked elements with the client is triggered.
	 */
	void freeUpClient();
	
	/**
	 * Clears all tracked elements.
	 */
	void clearAll();
	
	// endregion
}
