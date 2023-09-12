package software.xdev.vaadin.maps.leaflet.base;

import java.io.Serializable;

import com.vaadin.flow.component.page.PendingJavaScriptResult;

import software.xdev.vaadin.maps.leaflet.registry.LComponentManagementRegistry;


public interface LComponent<S extends LComponent<S>>
{
	LComponentManagementRegistry componentRegistry();
	
	@SuppressWarnings("resource")
	default String clientComponentJsAccessor()
	{
		return this.componentRegistry().clientComponentJsAccessor(this);
	}
	
	@SuppressWarnings("resource")
	default PendingJavaScriptResult invokeSelf(final String payload, final Serializable... params)
	{
		return this.componentRegistry().execJs(this.clientComponentJsAccessor() + payload, params);
	}
	
	// Getting data is not recommended as it can be manipulated on the client
	
	// default CompletableFuture<JsonValue> invokeSelfAsync(final String payload, final Serializable... params)
	// {
	// 	return this.invokeSelf(payload, params).toCompletableFuture();
	// }
	//
	// default JsonValue invokeSelfSync(final String payload, final Serializable... params)
	// {
	// 	try
	// 	{
	// 		return this.invokeSelfAsync(payload, params).get(15, TimeUnit.SECONDS);
	// 	}
	// 	catch(final ExecutionException e)
	// 	{
	// 		throw new JsCommunicationException("Failed to invoke function", e);
	// 	}
	// 	catch(final InterruptedException e)
	// 	{
	// 		Thread.currentThread().interrupt();
	// 		throw new JsCommunicationException("Got interrupted", e);
	// 	}
	// 	catch(final TimeoutException e)
	// 	{
	// 		throw new JsCommunicationException("Timed out while executing",e);
	// 	}
	// }
	
	@SuppressWarnings("unchecked")
	default S self()
	{
		return (S)this;
	}
}
