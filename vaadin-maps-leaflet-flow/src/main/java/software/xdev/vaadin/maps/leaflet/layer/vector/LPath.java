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
package software.xdev.vaadin.maps.leaflet.layer.vector;

import java.io.Serializable;

import software.xdev.vaadin.maps.leaflet.base.has.LHasBringTo;
import software.xdev.vaadin.maps.leaflet.base.has.LHasRedraw;
import software.xdev.vaadin.maps.leaflet.base.has.LHasSetStylePath;
import software.xdev.vaadin.maps.leaflet.layer.LInteractiveLayer;
import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


/**
 * @see <a href="https://leafletjs.com/reference.html#path">Leaflet docs</a>
 */
public abstract class LPath<S extends LPath<S>> extends LInteractiveLayer<S>
	implements LHasBringTo<S>, LHasRedraw<S>, LHasSetStylePath<S>
{
	protected LPath(
		final LComponentManagementRegistry compReg,
		final String jsConstructorCallExpression,
		final Serializable... parameters)
	{
		super(compReg, jsConstructorCallExpression, parameters);
	}
}
