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
package software.xdev.vaadin.maps.leaflet.geoman.map;

import software.xdev.vaadin.maps.leaflet.base.LComponentOptions;


public abstract class LAbstractMapPMControlOptions<S extends LAbstractMapPMControlOptions<S>>
	implements LComponentOptions<S>
{
	private String position;
	private Object positions;
	private Boolean drawMarker;
	private Boolean drawCircleMarker;
	private Boolean drawPolyline;
	private Boolean drawRectangle;
	private Boolean drawPolygon;
	private Boolean drawCircle;
	private Boolean drawText;
	private Boolean editMode;
	private Boolean dragMode;
	private Boolean cutPolygon;
	private Boolean removalMode;
	private Boolean rotateMode;
	private Boolean oneBlock;
	private Boolean drawControls;
	private Boolean editControls;
	private Boolean customControls;
	
	public String getPosition()
	{
		return this.position;
	}
	
	public void setPosition(final String position)
	{
		this.position = position;
	}
	
	public S withPosition(final String position)
	{
		this.setPosition(position);
		return this.self();
	}
	
	public Object getPositions()
	{
		return this.positions;
	}
	
	public void setPositions(final Object positions)
	{
		this.positions = positions;
	}
	
	public S withPositions(final Object positions)
	{
		this.setPositions(positions);
		return this.self();
	}
	
	public Boolean getDrawMarker()
	{
		return this.drawMarker;
	}
	
	public void setDrawMarker(final Boolean drawMarker)
	{
		this.drawMarker = drawMarker;
	}
	
	public S withDrawMarker(final Boolean drawMarker)
	{
		this.setDrawMarker(drawMarker);
		return this.self();
	}
	
	public Boolean getDrawCircleMarker()
	{
		return this.drawCircleMarker;
	}
	
	public void setDrawCircleMarker(final Boolean drawCircleMarker)
	{
		this.drawCircleMarker = drawCircleMarker;
	}
	
	public S withDrawCircleMarker(final Boolean drawCircleMarker)
	{
		this.setDrawCircleMarker(drawCircleMarker);
		return this.self();
	}
	
	public Boolean getDrawPolyline()
	{
		return this.drawPolyline;
	}
	
	public void setDrawPolyline(final Boolean drawPolyline)
	{
		this.drawPolyline = drawPolyline;
	}
	
	public S withDrawPolyline(final Boolean drawPolyline)
	{
		this.setDrawPolyline(drawPolyline);
		return this.self();
	}
	
	public Boolean getDrawRectangle()
	{
		return this.drawRectangle;
	}
	
	public void setDrawRectangle(final Boolean drawRectangle)
	{
		this.drawRectangle = drawRectangle;
	}
	
	public S withDrawRectangle(final Boolean drawRectangle)
	{
		this.setDrawRectangle(drawRectangle);
		return this.self();
	}
	
	public Boolean getDrawPolygon()
	{
		return this.drawPolygon;
	}
	
	public void setDrawPolygon(final Boolean drawPolygon)
	{
		this.drawPolygon = drawPolygon;
	}
	
	public S withDrawPolygon(final Boolean drawPolygon)
	{
		this.setDrawPolygon(drawPolygon);
		return this.self();
	}
	
	public Boolean getDrawCircle()
	{
		return this.drawCircle;
	}
	
	public void setDrawCircle(final Boolean drawCircle)
	{
		this.drawCircle = drawCircle;
	}
	
	public S withDrawCircle(final Boolean drawCircle)
	{
		this.setDrawCircle(drawCircle);
		return this.self();
	}
	
	public Boolean getDrawText()
	{
		return this.drawText;
	}
	
	public void setDrawText(final Boolean drawText)
	{
		this.drawText = drawText;
	}
	
	public S withDrawText(final Boolean drawText)
	{
		this.setDrawText(drawText);
		return this.self();
	}
	
	public Boolean getEditMode()
	{
		return this.editMode;
	}
	
	public void setEditMode(final Boolean editMode)
	{
		this.editMode = editMode;
	}
	
	public S withEditMode(final Boolean editMode)
	{
		this.setEditMode(editMode);
		return this.self();
	}
	
	public Boolean getDragMode()
	{
		return this.dragMode;
	}
	
	public void setDragMode(final Boolean dragMode)
	{
		this.dragMode = dragMode;
	}
	
	public S withDragMode(final Boolean dragMode)
	{
		this.setDragMode(dragMode);
		return this.self();
	}
	
	public Boolean getCutPolygon()
	{
		return this.cutPolygon;
	}
	
	public void setCutPolygon(final Boolean cutPolygon)
	{
		this.cutPolygon = cutPolygon;
	}
	
	public S withCutPolygon(final Boolean cutPolygon)
	{
		this.setCutPolygon(cutPolygon);
		return this.self();
	}
	
	public Boolean getRemovalMode()
	{
		return this.removalMode;
	}
	
	public void setRemovalMode(final Boolean removalMode)
	{
		this.removalMode = removalMode;
	}
	
	public S withRemovalMode(final Boolean removalMode)
	{
		this.setRemovalMode(removalMode);
		return this.self();
	}
	
	public Boolean getRotateMode()
	{
		return this.rotateMode;
	}
	
	public void setRotateMode(final Boolean rotateMode)
	{
		this.rotateMode = rotateMode;
	}
	
	public S withRotateMode(final Boolean rotateMode)
	{
		this.setRotateMode(rotateMode);
		return this.self();
	}
	
	public Boolean getOneBlock()
	{
		return this.oneBlock;
	}
	
	public void setOneBlock(final Boolean oneBlock)
	{
		this.oneBlock = oneBlock;
	}
	
	public S withOneBlock(final Boolean oneBlock)
	{
		this.setOneBlock(oneBlock);
		return this.self();
	}
	
	public Boolean getDrawControls()
	{
		return this.drawControls;
	}
	
	public void setDrawControls(final Boolean drawControls)
	{
		this.drawControls = drawControls;
	}
	
	public S withDrawControls(final Boolean drawControls)
	{
		this.setDrawControls(drawControls);
		return this.self();
	}
	
	public Boolean getEditControls()
	{
		return this.editControls;
	}
	
	public void setEditControls(final Boolean editControls)
	{
		this.editControls = editControls;
	}
	
	public S withEditControls(final Boolean editControls)
	{
		this.setEditControls(editControls);
		return this.self();
	}
	
	public Boolean getCustomControls()
	{
		return this.customControls;
	}
	
	public void setCustomControls(final Boolean customControls)
	{
		this.customControls = customControls;
	}
	
	public S withCustomControls(final Boolean customControls)
	{
		this.setCustomControls(customControls);
		return this.self();
	}
}
