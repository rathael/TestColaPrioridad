package flights.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Graph of Flights
 * 
 * @author alex
 *
 */
public class FlightManager {

	private Map<String, Airport> airports;
	
	public FlightManager(Flight[] flights) {
		airports = new HashMap<>(flights.length);
	}
}
