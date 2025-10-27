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
package software.xdev.vaadin.maps.leaflet.geoman;

import software.xdev.vaadin.maps.leaflet.base.LComponentOptions;


/**
 * Common properties shared by {@link LAbstractDrawOptions} and {@link LAbstractEditOptions}
 */
public abstract class LAbstractDrawOrEditOptions<S extends LAbstractDrawOrEditOptions<S>>
	implements LComponentOptions<S>
{
	private Boolean snappable;
	private Number snapDistance;
	private Boolean snapMiddle;
	private Boolean snapSegment;
	private Boolean snapVertex;
	private Boolean requireSnapToFinish;
	private Boolean tooltips;
	private Boolean allowSelfIntersection;
	
	public Boolean getSnappable()
	{
		return this.snappable;
	}
	
	public void setSnappable(final Boolean snappable)
	{
		this.snappable = snappable;
	}
	
	public S withSnappable(final Boolean snappable)
	{
		this.setSnappable(snappable);
		return this.self();
	}
	
	public Number getSnapDistance()
	{
		return this.snapDistance;
	}
	
	public void setSnapDistance(final Number snapDistance)
	{
		this.snapDistance = snapDistance;
	}
	
	public S withSnapDistance(final Number snapDistance)
	{
		this.setSnapDistance(snapDistance);
		return this.self();
	}
	
	public Boolean getSnapMiddle()
	{
		return this.snapMiddle;
	}
	
	public void setSnapMiddle(final Boolean snapMiddle)
	{
		this.snapMiddle = snapMiddle;
	}
	
	public S withSnapMiddle(final Boolean snapMiddle)
	{
		this.setSnapMiddle(snapMiddle);
		return this.self();
	}
	
	public Boolean getSnapSegment()
	{
		return this.snapSegment;
	}
	
	public void setSnapSegment(final Boolean snapSegment)
	{
		this.snapSegment = snapSegment;
	}
	
	public S withSnapSegment(final Boolean snapSegment)
	{
		this.setSnapSegment(snapSegment);
		return this.self();
	}
	
	public Boolean getSnapVertex()
	{
		return this.snapVertex;
	}
	
	public void setSnapVertex(final Boolean snapVertex)
	{
		this.snapVertex = snapVertex;
	}
	
	public S withSnapVertex(final Boolean snapVertex)
	{
		this.setSnapVertex(snapVertex);
		return this.self();
	}
	
	public Boolean getRequireSnapToFinish()
	{
		return this.requireSnapToFinish;
	}
	
	public void setRequireSnapToFinish(final Boolean requireSnapToFinish)
	{
		this.requireSnapToFinish = requireSnapToFinish;
	}
	
	public S withRequireSnapToFinish(final Boolean requireSnapToFinish)
	{
		this.setRequireSnapToFinish(requireSnapToFinish);
		return this.self();
	}
	
	public Boolean getTooltips()
	{
		return this.tooltips;
	}
	
	public void setTooltips(final Boolean tooltips)
	{
		this.tooltips = tooltips;
	}
	
	public S withTooltips(final Boolean tooltips)
	{
		this.setTooltips(tooltips);
		return this.self();
	}
	
	public Boolean getAllowSelfIntersection()
	{
		return this.allowSelfIntersection;
	}
	
	public void setAllowSelfIntersection(final Boolean allowSelfIntersection)
	{
		this.allowSelfIntersection = allowSelfIntersection;
	}
	
	public S withAllowSelfIntersection(final Boolean allowSelfIntersection)
	{
		this.setAllowSelfIntersection(allowSelfIntersection);
		return this.self();
	}
}
