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
package software.xdev.vaadin.maps.leaflet.flow.data;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


public class LIcon
{
	private String iconUrl;
	
	@JsonInclude(value = Include.CUSTOM, valueFilter = IconSizeFilter.class)
	private List<Integer> iconSize = new ArrayList<>();
	private final List<Integer> iconAnchor = new ArrayList<>();
	private final List<Integer> popupAnchor = new ArrayList<>();
	private String shadowUrl;
	private final List<Integer> shadowSize = new ArrayList<>();
	private final List<Integer> shadowAnchor = new ArrayList<>();
	
	public LIcon()
	{
		this.setIconAnchor(12, 41);
		this.setPopupAnchor(1, -34);
		this.setShadowSize(41, 41);
		this.setShadowAnchor(12, 41);
		
		// Encoded as base64 so that we don't have to communicate with anything
		// Might impact browser rendering performance:
		// https://github.com/Leaflet/Leaflet/issues/4968#issuecomment-322422045
		this.iconUrl =
			"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABkAAAApCAYAAADAk4LOAAAFgUlEQVR4Aa1XA5BjWRTN2oW17d3YaZtr2962HUzbDNpjszW24mRt28p47v7zq/bXZtrp/lWnXr337j3nPCe85NcypgSFdugCpW5YoDAMRaIMqRi6aKq5E3YqDQO3qAwjVWrD8Ncq/RBpykd8oZUb/kaJutow8r1aP9II0WmLKLIsJyv1w/kqw9Ch2MYdB++12Onxee/QMwvf4/Dk/Lfp/i4nxTXtOoQ4pW5Aj7wpici1A9erdAN2OH64x8OSP9j3Ft3b7aWkTg/Fm91siTra0f9on5sQr9INejH6CUUUpavjFNq1B+Oadhxmnfa8RfEmN8VNAsQhPqF55xHkMzz3jSmChWU6f7/XZKNH+9+hBLOHYozuKQPxyMPUKkrX/K0uWnfFaJGS1QPRtZsOPtr3NsW0uyh6NNCOkU3Yz+bXbT3I8G3xE5EXLXtCXbbqwCO9zPQYPRTZ5vIDXD7U+w7rFDEoUUf7ibHIR4y6bLVPXrz8JVZEql13trxwue/uDivd3fkWRbS6/IA2bID4uk0UpF1N8qLlbBlXs4Ee7HLTfV1j54APvODnSfOWBqtKVvjgLKzF5YdEk5ewRkGlK0i33Eofffc7HT56jD7/6U+qH3Cx7SBLNntH5YIPvODnyfIXZYRVDPqgHtLs5ABHD3YzLuespb7t79FY34DjMwrVrcTuwlT55YMPvOBnRrJ4VXTdNnYug5ucHLBjEpt30701A3Ts+HEa73u6dT3FNWwflY86eMHPk+Yu+i6pzUpRrW7SNDg5JHR4KapmM5Wv2E8Tfcb1HoqqHMHU+uWDD7zg54mz5/2BSnizi9T1Dg4QQXLToGNCkb6tb1NU+QAlGr1++eADrzhn/u8Q2YZhQVlZ5+CAOtqfbhmaUCS1ezNFVm2imDbPmPng5wmz+gwh+oHDce0eUtQ6OGDIyR0uUhUsoO3vfDmmgOezH0mZN59x7MBi++WDL1g/eEiU3avlidO671bkLfwbw5XV2P8Pzo0ydy4t2/0eu33xYSOMOD8hTf4CrBtGMSoXfPLchX+J0ruSePw3LZeK0juPJbYzrhkH0io7B3k164hiGvawhOKMLkrQLyVpZg8rHFW7E2uHOL888IBPlNZ1FPzstSJM694fWr6RwpvcJK60+0HCILTBzZLFNdtAzJaohze60T8qBzyh5ZuOg5e7uwQppofEmf2++DYvmySqGBuKaicF1blQjhuHdvCIMvp8whTTfZzI7RldpwtSzL+F1+wkdZ2TBOW2gIF88PBTzD/gpeREAMEbxnJcaJHNHrpzji0gQCS6hdkEeYt9DF/2qPcEC8RM28Hwmr3sdNyht00byAut2k3gufWNtgtOEOFGUwcXWNDbdNbpgBGxEvKkOQsxivJx33iow0Vw5S6SVTrpVq11ysA2Rp7gTfPfktc6zhtXBBC+adRLshf6sG2RfHPZ5EAc4sVZ83yCN00Fk/4kggu40ZTvIEm5g24qtU4KjBrx/BTTH8ifVASAG7gKrnWxJDcU7x8X6Ecczhm3o6YicvsLXWfh3Ch1W0k8x0nXF+0fFxgt4phz8QvypiwCCFKMqXCnqXExjq10beH+UUA7+nG6mdG/Pu0f3LgFcGrl2s0kNNjpmoJ9o4B29CMO8dMT4Q5ox8uitF6fqsrJOr8qnwNbRzv6hSnG5wP+64C7h9lp30hKNtKdWjtdkbuPA19nJ7Tz3zR/ibgARbhb4AlhavcBebmTHcFl2fvYEnW0ox9xMxKBS8btJ+KiEbq9zA4RthQXDhPa0T9TEe69gWupwc6uBUphquXgf+/FrIjweHQS4/pduMe5ERUMHUd9xv8ZR98CxkS4F2n3EUrUZ10EYNw7BWm9x1GiPssi3GgiGRDKWRYZfXlON+dfNbM+GgIwYdwAAAAASUVORK5CYII=";
		this.shadowUrl =
			"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACkAAAApCAQAAAACach9AAACMUlEQVR4Ae3ShY7jQBAE0Aoz/f9/HTMzhg1zrdKUrJbdx+Kd2nD8VNudfsL/Th///dyQN2TH6f3y/BGpC379rV+S+qqetBOxImNQXL8JCAr2V4iMQXHGNJxeCfZXhSRBcQMfvkOWUdtfzlLgAENmZDcmo2TVmt8OSM2eXxBp3DjHSMFutqS7SbmemzBiR+xpKCNUIRkdkkYxhAkyGoBvyQFEJEefwSmmvBfJuJ6aKqKWnAkvGZOaZXTUgFqYULWNSHUckZuR1HIIimUExutRxwzOLROIG4vKmCKQt364mIlhSyzAf1m9lHZHJZrlAOMMztRRiKimp/rpdJDc9Awry5xTZCte7FHtuS8wJgeYGrex28xNTd086Dik7vUMscQOa8y4DoGtCCSkAKlNwpgNtphjrC6MIHUkR6YWxxs6Sc5xqn222mmCRFzIt8lEdKx+ikCtg91qS2WpwVfBelJCiQJwvzixfI9cxZQWgiSJelKnwBElKYtDOb2MFbhmUigbReQBV0Cg4+qMXSxXSyGUn4UbF8l+7qdSGnTC0XLCmahIgUHLhLOhpVCtw4CzYXvLQWQbJNmxoCsOKAxSgBJno75avolkRw8iIAFcsdc02e9iyCd8tHwmeSSoKTowIgvscSGZUOA7PuCN5b2BX9mQM7S0wYhMNU74zgsPBj3HU7wguAfnxxjFQGBE6pwN+GjME9zHY7zGp8wVxMShYX9NXvEWD3HbwJf4giO4CFIQxXScH1/TM+04kkBiAAAAAElFTkSuQmCC";
	}
	
	public LIcon(final String url)
	{
		this.setIconAnchor(0, 0);
		this.setPopupAnchor(0, 0);
		this.setShadowSize(0, 0);
		this.setShadowAnchor(0, 0);
		this.iconUrl = url;
	}
	
	public String getIconUrl()
	{
		return this.iconUrl;
	}
	
	/**
	 * Sets a icon url.
	 */
	public void setIconUrl(final String iconUrl)
	{
		this.iconUrl = iconUrl;
	}
	
	public List<Integer> getIconSize()
	{
		return this.iconSize;
	}
	
	/**
	 * Icon size with x, y in px
	 */
	public void setIconSize(final int x, final int y)
	{
		this.setIconSize(new ArrayList<>(List.of(x, y)));
	}
	
	public void setIconSize(final List<Integer> iconSize)
	{
		this.iconSize = iconSize;
	}
	
	public List<Integer> getIconAnchor()
	{
		return this.iconAnchor;
	}
	
	/**
	 * Anchor point of the icon in x, y px.
	 */
	public void setIconAnchor(final int x, final int y)
	{
		this.iconAnchor.clear();
		this.iconAnchor.add(x);
		this.iconAnchor.add(y);
	}
	
	public List<Integer> getPopupAnchor()
	{
		return this.popupAnchor;
	}
	
	/**
	 * Anchor point of the Pop-up message in x,y px.
	 */
	public void setPopupAnchor(final int x, final int y)
	{
		
		this.popupAnchor.clear();
		this.popupAnchor.add(x);
		this.popupAnchor.add(y);
	}
	
	public String getShadowUrl()
	{
		return this.shadowUrl;
	}
	
	public void setShadowUrl(final String shadowUrl)
	{
		this.shadowUrl = shadowUrl;
	}
	
	public List<Integer> getShadowSize()
	{
		return this.shadowSize;
	}
	
	public void setShadowSize(final int x, final int y)
	{
		this.shadowSize.clear();
		this.shadowSize.add(x);
		this.shadowSize.add(y);
	}
	
	public List<Integer> getShadowAnchor()
	{
		return this.shadowAnchor;
	}
	
	public void setShadowAnchor(final int x, final int y)
	{
		this.shadowAnchor.clear();
		this.shadowAnchor.add(x);
		this.shadowAnchor.add(y);
	}
	
	public static class IconSizeFilter
	{
		@SuppressWarnings("java:S1206") // Filter only uses equals
		@Override
		public boolean equals(final Object obj)
		{
			// true = filter out; false = keep
			
			// Null is allowed
			if(obj == null)
			{
				return false;
			}
			
			// Filter out empty collection
			return Optional.of(obj)
				.filter(Collection.class::isInstance)
				.map(Collection.class::cast)
				.map(Collection::isEmpty)
				// Wrong type (not a collection)
				.orElse(true);
		}
	}
}
