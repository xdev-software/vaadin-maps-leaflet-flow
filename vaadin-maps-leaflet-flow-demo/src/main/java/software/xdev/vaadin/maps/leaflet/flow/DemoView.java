package software.xdev.vaadin.maps.leaflet.flow;

import java.util.List;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import software.xdev.vaadin.maps.leaflet.flow.demo.ComplexDemo;
import software.xdev.vaadin.maps.leaflet.flow.demo.FreeingUpResourceBenchmarkDemo;
import software.xdev.vaadin.maps.leaflet.flow.demo.InitialResizeDemo;
import software.xdev.vaadin.maps.leaflet.flow.demo.MinimalisticDemo;
import software.xdev.vaadin.maps.leaflet.flow.demo.MultiLayerWithPyramidDemo;
import software.xdev.vaadin.maps.leaflet.flow.demo.MultipleMapsDemo;
import software.xdev.vaadin.maps.leaflet.flow.demo.NotOfThisEarthDemo;
import software.xdev.vaadin.maps.leaflet.flow.demo.WatermarkControlDemo;


@PageTitle("Leaflet + Vaadin demos")
@Route("")
public class DemoView extends Composite<VerticalLayout>
{
	private final Grid<Example> grExamples = new Grid<>();
	
	public DemoView()
	{
		this.grExamples
			.addColumn(new ComponentRenderer<>(example -> {
				final Anchor anchor = new Anchor(example.route(), example.name());
				
				final Span spDesc = new Span(example.desc());
				spDesc.getStyle().set("font-size", "90%");
				spDesc.getStyle().set("white-space", "pre");
				
				final VerticalLayout vl = new VerticalLayout(anchor, spDesc);
				vl.setSpacing(false);
				return vl;
			}))
			.setHeader("Available demos");
		
		this.grExamples.setSizeFull();
		this.grExamples.addThemeVariants(GridVariant.LUMO_COMPACT, GridVariant.LUMO_NO_BORDER);
		
		this.getContent().add(this.grExamples);
		this.getContent().setHeightFull();
	}
	
	@Override
	protected void onAttach(final AttachEvent attachEvent)
	{
		this.grExamples.setItems(List.of(
			new Example(
				MinimalisticDemo.NAV,
				"Minimalistic",
				"Showcasing the simplest form of using the API"
			),
			new Example(
				MultipleMapsDemo.NAV,
				"Multiple maps",
				"Showcasing multiple concurrent maps in the same UI"
			),
			new Example(
				InitialResizeDemo.NAV,
				"Initial resize",
				"Some map methods - when called instantly after the map is created - will not work correctly."
					+ " This example shows how to workaround this restriction."
			),
			new Example(
				ComplexDemo.NAV,
				"Complex",
				"A complex example with various leaflet components and methods"
			),
			new Example(
				NotOfThisEarthDemo.NAV,
				"Not of this earth",
				"Displays a map that is not from this earth"
			),
			new Example(
				WatermarkControlDemo.NAV,
				"Watermark-Control",
				"Creates a custom control interface"
			),
			new Example(
				MultiLayerWithPyramidDemo.NAV,
				"Multi-Layer",
				"using Pyramids ▲ and more...\n"
					+ "Showcases a selection of different layers and how they can be displayed on a map"
			),
			new Example(
				FreeingUpResourceBenchmarkDemo.NAV,
				"Freeing up resources Benchmark",
				"Benchmark for showcasing how resources a freed up when handling huge amounts of components"
			)
		));
	}
	
	record Example(String route, String name, String desc)
	{
	}
}
