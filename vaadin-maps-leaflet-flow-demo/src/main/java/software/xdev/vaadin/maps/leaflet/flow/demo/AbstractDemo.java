package software.xdev.vaadin.maps.leaflet.flow.demo;

import java.util.concurrent.atomic.AtomicBoolean;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;


public abstract class AbstractDemo extends VerticalLayout
{
	protected Button createToggleButton(
		final String showText,
		final String hideText,
		final Runnable onShow,
		final Runnable onHide)
	{
		final AtomicBoolean shown = new AtomicBoolean(false);
		final Button btn = new Button(
			showText,
			ev -> {
				final boolean isShow = !shown.get();
				(isShow ? onShow : onHide).run();
				ev.getSource().setText(isShow ? hideText : showText);
				
				shown.set(isShow);
				
				ev.getSource().setEnabled(true);
			}
		);
		btn.setDisableOnClick(true);
		return btn;
	}
}
