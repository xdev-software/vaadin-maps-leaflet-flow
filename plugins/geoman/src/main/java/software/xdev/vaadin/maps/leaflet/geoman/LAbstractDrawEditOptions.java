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

/**
 * Combination of {@link LAbstractDrawOptions} and {@link LAbstractEditOptions}
 */
public abstract class LAbstractDrawEditOptions<S extends LAbstractDrawEditOptions<S>>
	extends LAbstractDrawOptions<S>
{
	private Boolean allowSelfIntersectionEdit;
	private Boolean preventMarkerRemoval;
	private Boolean removeLayerBelowMinVertexCount;
	private Boolean syncLayersOnDrag;
	private Boolean allowEditing;
	private Boolean allowRemoval;
	private Boolean allowCutting;
	private Boolean allowRotation;
	private Boolean draggable;
	private Boolean addVertexOn;
	private Object addVertexValidation;
	private Object removeVertexOn;
	private Object removeVertexValidation;
	private Object moveVertexValidation;
	private Number limitMarkersToCount;
	
	public Boolean getAllowSelfIntersectionEdit()
	{
		return this.allowSelfIntersectionEdit;
	}
	
	public void setAllowSelfIntersectionEdit(final Boolean allowSelfIntersectionEdit)
	{
		this.allowSelfIntersectionEdit = allowSelfIntersectionEdit;
	}
	
	public S withAllowSelfIntersectionEdit(final Boolean allowSelfIntersectionEdit)
	{
		this.setAllowSelfIntersection(allowSelfIntersectionEdit);
		return this.self();
	}
	
	public Boolean getPreventMarkerRemoval()
	{
		return this.preventMarkerRemoval;
	}
	
	public void setPreventMarkerRemoval(final Boolean preventMarkerRemoval)
	{
		this.preventMarkerRemoval = preventMarkerRemoval;
	}
	
	public S withPreventMarkerRemoval(final Boolean preventMarkerRemoval)
	{
		this.setPreventMarkerRemoval(preventMarkerRemoval);
		return this.self();
	}
	
	public Boolean getRemoveLayerBelowMinVertexCount()
	{
		return this.removeLayerBelowMinVertexCount;
	}
	
	public void setRemoveLayerBelowMinVertexCount(final Boolean removeLayerBelowMinVertexCount)
	{
		this.removeLayerBelowMinVertexCount = removeLayerBelowMinVertexCount;
	}
	
	public S withRemoveLayerBelowMinVertexCount(final Boolean removeLayerBelowMinVertexCount)
	{
		this.setRemoveLayerBelowMinVertexCount(removeLayerBelowMinVertexCount);
		return this.self();
	}
	
	public Boolean getSyncLayersOnDrag()
	{
		return this.syncLayersOnDrag;
	}
	
	public void setSyncLayersOnDrag(final Boolean syncLayersOnDrag)
	{
		this.syncLayersOnDrag = syncLayersOnDrag;
	}
	
	public S withSyncLayersOnDrag(final Boolean syncLayersOnDrag)
	{
		this.setSyncLayersOnDrag(syncLayersOnDrag);
		return this.self();
	}
	
	public Boolean getAllowEditing()
	{
		return this.allowEditing;
	}
	
	public void setAllowEditing(final Boolean allowEditing)
	{
		this.allowEditing = allowEditing;
	}
	
	public S withAllowEditing(final Boolean allowEditing)
	{
		this.setAllowEditing(allowEditing);
		return this.self();
	}
	
	public Boolean getAllowRemoval()
	{
		return this.allowRemoval;
	}
	
	public void setAllowRemoval(final Boolean allowRemoval)
	{
		this.allowRemoval = allowRemoval;
	}
	
	public S withAllowRemoval(final Boolean allowRemoval)
	{
		this.setAllowRemoval(allowRemoval);
		return this.self();
	}
	
	public Boolean getAllowCutting()
	{
		return this.allowCutting;
	}
	
	public void setAllowCutting(final Boolean allowCutting)
	{
		this.allowCutting = allowCutting;
	}
	
	public S withAllowCutting(final Boolean allowCutting)
	{
		this.setAllowCutting(allowCutting);
		return this.self();
	}
	
	public Boolean getAllowRotation()
	{
		return this.allowRotation;
	}
	
	public void setAllowRotation(final Boolean allowRotation)
	{
		this.allowRotation = allowRotation;
	}
	
	public S withAllowRotation(final Boolean allowRotation)
	{
		this.setAllowRotation(allowRotation);
		return this.self();
	}
	
	public Boolean getDraggable()
	{
		return this.draggable;
	}
	
	public void setDraggable(final Boolean draggable)
	{
		this.draggable = draggable;
	}
	
	public S withDraggable(final Boolean draggable)
	{
		this.setDraggable(draggable);
		return this.self();
	}
	
	public Boolean getAddVertexOn()
	{
		return this.addVertexOn;
	}
	
	public void setAddVertexOn(final Boolean addVertexOn)
	{
		this.addVertexOn = addVertexOn;
	}
	
	public S withAddVertexOn(final Boolean addVertexOn)
	{
		this.setAddVertexOn(addVertexOn);
		return this.self();
	}
	
	public Object getAddVertexValidation()
	{
		return this.addVertexValidation;
	}
	
	public void setAddVertexValidation(final Object addVertexValidation)
	{
		this.addVertexValidation = addVertexValidation;
	}
	
	public S withAddVertexValidation(final Object addVertexValidation)
	{
		this.setAddVertexValidation(addVertexValidation);
		return this.self();
	}
	
	public Object getRemoveVertexOn()
	{
		return this.removeVertexOn;
	}
	
	public void setRemoveVertexOn(final Object removeVertexOn)
	{
		this.removeVertexOn = removeVertexOn;
	}
	
	public S withRemoveVertexOn(final Object removeVertexOn)
	{
		this.setRemoveVertexOn(removeVertexOn);
		return this.self();
	}
	
	public Object getRemoveVertexValidation()
	{
		return this.removeVertexValidation;
	}
	
	public void setRemoveVertexValidation(final Object removeVertexValidation)
	{
		this.removeVertexValidation = removeVertexValidation;
	}
	
	public S withRemoveVertexValidation(final Object removeVertexValidation)
	{
		this.setRemoveVertexValidation(removeVertexValidation);
		return this.self();
	}
	
	public Object getMoveVertexValidation()
	{
		return this.moveVertexValidation;
	}
	
	public void setMoveVertexValidation(final Object moveVertexValidation)
	{
		this.moveVertexValidation = moveVertexValidation;
	}
	
	public S withMoveVertexValidation(final Object moveVertexValidation)
	{
		this.setMoveVertexValidation(moveVertexValidation);
		return this.self();
	}
	
	public Number getLimitMarkersToCount()
	{
		return this.limitMarkersToCount;
	}
	
	public void setLimitMarkersToCount(final Number limitMarkersToCount)
	{
		this.limitMarkersToCount = limitMarkersToCount;
	}
	
	public S withLimitMarkersToCount(final Number limitMarkersToCount)
	{
		this.setLimitMarkersToCount(limitMarkersToCount);
		return this.self();
	}
}
