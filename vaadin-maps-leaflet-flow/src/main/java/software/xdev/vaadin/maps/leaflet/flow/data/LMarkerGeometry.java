/*
 * Copyright © 2019 XDEV Software (https://xdev.software/en)
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
package software.xdev.vaadin.maps.leaflet.flow.data;



import java.util.ArrayList;
import java.util.List;


public class LMarkerGeometry
{
	private String type;
	private List<Double> coordinates = new ArrayList<>();
	
	public LMarkerGeometry(final String type, final double lat, final double lon)
	{
		this.type = type;
		this.coordinates.add(lat);
		this.coordinates.add(lon);
	}
	
	public String getType()
	{
		return this.type;
	}
	
	public void setType(final String type)
	{
		this.type = type;
	}
	
	public List<Double> getCoordinates()
	{
		return this.coordinates;
	}
	
	public void setCoordinates(final List<Double> coordinates)
	{
		this.coordinates = coordinates;
	}
	
}
