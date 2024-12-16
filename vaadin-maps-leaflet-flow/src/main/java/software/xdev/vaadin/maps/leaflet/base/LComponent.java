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

import java.io.Serializable;

import com.vaadin.flow.component.page.PendingJavaScriptResult;

import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


public interface LComponent<S extends LComponent<S>>
{
	LComponentManagementRegistry componentRegistry();
	
	default String clientComponentJsAccessor()
	{
		return this.componentRegistry().clientComponentJsAccessor(this);
	}
	
	default PendingJavaScriptResult invokeSelf(final String payload, final Serializable... params)
	{
		return this.componentRegistry().execJs(this.clientComponentJsAccessor() + payload, params);
	}
	
	/**
	 * @apiNote Usage is not recommended as clientside data can be manipulated
	 */
	default PendingJavaScriptResult invokeSelfReturn(final String payload, final Serializable... params)
	{
		return this.componentRegistry().execJs("return " + this.clientComponentJsAccessor() + payload, params);
	}
	
	@SuppressWarnings("unchecked")
	default S self()
	{
		return (S)this;
	}
}
