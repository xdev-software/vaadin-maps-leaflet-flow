
package software.xdev.vaadin.maps.leaflet.flow;

public class IdGenerator
{
	private IdGenerator()
	{
		// private constructor for utility class
	}
	
	public static String generateId()
	{
		final String possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		final StringBuilder idStr = new StringBuilder();
		
		for(int i = 0; i < 10; i++)
		{
			idStr.append(possible.charAt((int)Math.floor(Math.random() * possible.length())));
		}
		return idStr.toString();
	}
	
}
