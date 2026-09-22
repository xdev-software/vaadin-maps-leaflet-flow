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

public abstract class LAbstractDrawOptions<S extends LAbstractDrawOptions<S>>
	extends LAbstractDrawOrEditOptions<S>
{
	private Object templineStyle;
	private Object hintlineStyle;
	private Object pathOptions;
	private Object markerStyle;
	private Boolean cursorMarker;
	private Object finishOn;
	private Boolean hideMiddleMarkers;
	private Number minRadiusCircle;
	private Number maxRadiusCircle;
	private Number minRadiusCircleMarker;
	private Number maxRadiusCircleMarker;
	private Boolean resizeableCircle;
	private Boolean resizeableCircleMarker;
	private Boolean markerEditable;
	private Boolean continueDrawing;
	private Number rectangleAngle;
	private Object layersToCut;
	private Object textOptions;
	
	public Object getTemplineStyle()
	{
		return this.templineStyle;
	}
	
	public void setTemplineStyle(final Object templineStyle)
	{
		this.templineStyle = templineStyle;
	}
	
	public S withTemplineStyle(final Object templineStyle)
	{
		this.setTemplineStyle(templineStyle);
		return this.self();
	}
	
	public Object getHintlineStyle()
	{
		return this.hintlineStyle;
	}
	
	public void setHintlineStyle(final Object hintlineStyle)
	{
		this.hintlineStyle = hintlineStyle;
	}
	
	public S withHintlineStyle(final Object hintlineStyle)
	{
		this.setHintlineStyle(hintlineStyle);
		return this.self();
	}
	
	public Object getPathOptions()
	{
		return this.pathOptions;
	}
	
	public void setPathOptions(final Object pathOptions)
	{
		this.pathOptions = pathOptions;
	}
	
	public S withPathOptions(final Object pathOptions)
	{
		this.setPathOptions(pathOptions);
		return this.self();
	}
	
	public Object getMarkerStyle()
	{
		return this.markerStyle;
	}
	
	public void setMarkerStyle(final Object markerStyle)
	{
		this.markerStyle = markerStyle;
	}
	
	public S withMarkerStyle(final Object markerStyle)
	{
		this.setMarkerStyle(markerStyle);
		return this.self();
	}
	
	public Boolean getCursorMarker()
	{
		return this.cursorMarker;
	}
	
	public void setCursorMarker(final Boolean cursorMarker)
	{
		this.cursorMarker = cursorMarker;
	}
	
	public S withCursorMarker(final Boolean cursorMarker)
	{
		this.setCursorMarker(cursorMarker);
		return this.self();
	}
	
	public Object getFinishOn()
	{
		return this.finishOn;
	}
	
	public void setFinishOn(final Object finishOn)
	{
		this.finishOn = finishOn;
	}
	
	public S withFinishOn(final Object finishOn)
	{
		this.setFinishOn(finishOn);
		return this.self();
	}
	
	public Boolean getHideMiddleMarkers()
	{
		return this.hideMiddleMarkers;
	}
	
	public void setHideMiddleMarkers(final Boolean hideMiddleMarkers)
	{
		this.hideMiddleMarkers = hideMiddleMarkers;
	}
	
	public S withHideMiddleMarkers(final Boolean hideMiddleMarkers)
	{
		this.setHideMiddleMarkers(hideMiddleMarkers);
		return this.self();
	}
	
	public Number getMinRadiusCircle()
	{
		return this.minRadiusCircle;
	}
	
	public void setMinRadiusCircle(final Number minRadiusCircle)
	{
		this.minRadiusCircle = minRadiusCircle;
	}
	
	public S withMinRadiusCircle(final Number minRadiusCircle)
	{
		this.setMinRadiusCircle(minRadiusCircle);
		return this.self();
	}
	
	public Number getMaxRadiusCircle()
	{
		return this.maxRadiusCircle;
	}
	
	public void setMaxRadiusCircle(final Number maxRadiusCircle)
	{
		this.maxRadiusCircle = maxRadiusCircle;
	}
	
	public S withMaxRadiusCircle(final Number maxRadiusCircle)
	{
		this.setMaxRadiusCircle(maxRadiusCircle);
		return this.self();
	}
	
	public Number getMinRadiusCircleMarker()
	{
		return this.minRadiusCircleMarker;
	}
	
	public void setMinRadiusCircleMarker(final Number minRadiusCircleMarker)
	{
		this.minRadiusCircleMarker = minRadiusCircleMarker;
	}
	
	public S withMinRadiusCircleMarker(final Number minRadiusCircleMarker)
	{
		this.setMinRadiusCircleMarker(minRadiusCircleMarker);
		return this.self();
	}
	
	public Number getMaxRadiusCircleMarker()
	{
		return this.maxRadiusCircleMarker;
	}
	
	public void setMaxRadiusCircleMarker(final Number maxRadiusCircleMarker)
	{
		this.maxRadiusCircleMarker = maxRadiusCircleMarker;
	}
	
	public S withMaxRadiusCircleMarker(final Number maxRadiusCircleMarker)
	{
		this.setMaxRadiusCircleMarker(maxRadiusCircleMarker);
		return this.self();
	}
	
	public Boolean getResizeableCircle()
	{
		return this.resizeableCircle;
	}
	
	public void setResizeableCircle(final Boolean resizeableCircle)
	{
		this.resizeableCircle = resizeableCircle;
	}
	
	public S withResizeableCircle(final Boolean resizeableCircle)
	{
		this.setResizeableCircle(resizeableCircle);
		return this.self();
	}
	
	public Boolean getResizeableCircleMarker()
	{
		return this.resizeableCircleMarker;
	}
	
	public void setResizeableCircleMarker(final Boolean resizeableCircleMarker)
	{
		this.resizeableCircleMarker = resizeableCircleMarker;
	}
	
	public S withResizeableCircleMarker(final Boolean resizeableCircleMarker)
	{
		this.setResizeableCircleMarker(resizeableCircleMarker);
		return this.self();
	}
	
	public Boolean getMarkerEditable()
	{
		return this.markerEditable;
	}
	
	public void setMarkerEditable(final Boolean markerEditable)
	{
		this.markerEditable = markerEditable;
	}
	
	public S withMarkerEditable(final Boolean markerEditable)
	{
		this.setMarkerEditable(markerEditable);
		return this.self();
	}
	
	public Boolean getContinueDrawing()
	{
		return this.continueDrawing;
	}
	
	public void setContinueDrawing(final Boolean continueDrawing)
	{
		this.continueDrawing = continueDrawing;
	}
	
	public S withContinueDrawing(final Boolean continueDrawing)
	{
		this.setContinueDrawing(continueDrawing);
		return this.self();
	}
	
	public Number getRectangleAngle()
	{
		return this.rectangleAngle;
	}
	
	public void setRectangleAngle(final Number rectangleAngle)
	{
		this.rectangleAngle = rectangleAngle;
	}
	
	public S withRectangleAngle(final Number rectangleAngle)
	{
		this.setRectangleAngle(rectangleAngle);
		return this.self();
	}
	
	public Object getLayersToCut()
	{
		return this.layersToCut;
	}
	
	public void setLayersToCut(final Object layersToCut)
	{
		this.layersToCut = layersToCut;
	}
	
	public S withLayersToCut(final Object layersToCut)
	{
		this.setLayersToCut(layersToCut);
		return this.self();
	}
	
	public Object getTextOptions()
	{
		return this.textOptions;
	}
	
	public void setTextOptions(final Object textOptions)
	{
		this.textOptions = textOptions;
	}
	
	public S withTextOptions(final Object textOptions)
	{
		this.setTextOptions(textOptions);
		return this.self();
	}
}
