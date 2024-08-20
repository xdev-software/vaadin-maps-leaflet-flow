package software.xdev.vaadin.maps.leaflet.flow.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;

import software.xdev.vaadin.maps.leaflet.MapContainer;
import software.xdev.vaadin.maps.leaflet.basictypes.LLatLng;
import software.xdev.vaadin.maps.leaflet.layer.raster.LTileLayer;
import software.xdev.vaadin.maps.leaflet.layer.ui.LMarker;
import software.xdev.vaadin.maps.leaflet.map.LMap;
import software.xdev.vaadin.maps.leaflet.registry.LDefaultComponentManagementRegistry;


@Route(FreeingUpResourceBenchmarkDemo.NAV)
@SuppressWarnings("checkstyle:MagicNumber")
public class FreeingUpResourceBenchmarkDemo extends AbstractDemo
{
	public static final String NAV = "/freeing-up-resources-benchmark";
	
	private static final Logger LOG = LoggerFactory.getLogger(FreeingUpResourceBenchmarkDemo.class);
	
	private final LDefaultComponentManagementRegistry reg;
	private final LMap map;
	private final HorizontalLayout hlButtons = new HorizontalLayout();
	
	public FreeingUpResourceBenchmarkDemo()
	{
		this.reg = new LDefaultComponentManagementRegistry(this);
		
		final MapContainer mapContainer = new MapContainer(this.reg);
		mapContainer.setSizeFull();
		this.add(mapContainer);
		this.setSizeFull();
		
		this.map = mapContainer.getlMap();
		
		final LLatLng center = new LLatLng(this.reg, 49.675126, 12.160733);
		this.map.setView(center, 17);
		
		// Add default layers
		this.map.addLayer(LTileLayer.createDefaultForOpenStreetMapTileServer(this.reg));
		
		this.hlButtons.setWidthFull();
		this.add(this.hlButtons);
		
		this.addMemoryTestDemo();
	}
	
	/**
	 * Used for testing if memory on the client side is freed up correctly when handling a lot of components.
	 * <p/>
	 * What does this do?<p/> Creates huge amounts of components, adds them to the UI and removes them. This happens in
	 * iterative cycles. At the end of the test the browser should not use excessive amounts of memory as the
	 * components are removed again (-> no memory leak).
	 */
	// S5413 - Yes it's used correctly
	// S2245 - This is a reproducible demo
	// S1215 - This is a memory test and we don't rely on random GC collects
	@SuppressWarnings({"java:S5413", "java:S2245", "java:S1215", "java:S3776", "PMD"})
	private void addMemoryTestDemo()
	{
		final AtomicBoolean abort = new AtomicBoolean(false);
		
		this.hlButtons.add(this.createToggleButton(
			"Start browser memory test",
			"Stop browser memory test",
			() -> {
				this.map.setView(new LLatLng(this.reg, 0, 0), 12);
				
				abort.set(false);
				
				final int bulkSize = 100;
				final int sizeWhenStartRemoving = 1_000;
				final int endWhen = 100_000;
				
				final AtomicLong totallyAdded = new AtomicLong(0);
				final Random random = new Random(1);
				final UI ui = UI.getCurrent();
				
				CompletableFuture.runAsync(() -> {
					try
					{
						final List<LMarker> markers = new ArrayList<>();
						while(!abort.get() && totallyAdded.get() < endWhen)
						{
							LOG.info("Totally added markers: {}; Adding bulk", totallyAdded);
							
							for(int i = 0; i < bulkSize; i++)
							{
								if(markers.size() > sizeWhenStartRemoving)
								{
									final LMarker removed = markers.remove(0);
									
									ui.accessSynchronously(removed::remove);
								}
								final double lat = random.nextDouble() * 200 - 100;
								final double lng = random.nextDouble() * 200 - 100;
								final double v = random.nextDouble();
								
								ui.accessSynchronously(() ->
									markers.add(
										new LMarker(
											this.reg,
											new LLatLng(
												this.reg,
												lat,
												lng))
											.bindPopup("Random double: " + v)
											.addTo(this.map)));
							}
							
							totallyAdded.set(totallyAdded.get() + bulkSize);
							
							LOG.info("Added {}x markers; Performing GC", bulkSize);
							System.gc();
							LOG.info("Finished GC; Syncing with client");
							ui.accessSynchronously(this.reg::freeUpClient);
							
							if(!abort.get())
							{
								LOG.info("Waiting a moment");
								Thread.sleep(10);
							}
						}
						
						LOG.info("Ending; Clearing...");
						markers.forEach(m -> ui.accessSynchronously(m::remove));
						markers.clear();
						
						for(int i = 0; i < 2; i++)
						{
							System.gc();
							
							Thread.sleep(100);
							
							ui.accessSynchronously(this.reg::freeUpClient);
						}
						
						LOG.info("Done - Browser should no longer allocate a lot of RAM now");
						
						ui.accessSynchronously(() -> this.reg.execJs(
							"alert('Finished memory test!'"
								+ "+'\\nTracked components on client (less is better): ' "
								+ "+ document.getElementById('"
								+ this.reg.getId().orElseThrow()
								+ "').lComponents.size);"));
					}
					catch(final InterruptedException ex)
					{
						Thread.currentThread().interrupt();
						LOG.warn("Got interrupted", ex);
					}
					catch(final Exception ex)
					{
						LOG.error("Unexpected problem while testing", ex);
					}
				});
			},
			() -> abort.set(true)
		));
	}
}
