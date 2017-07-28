package flights.model;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

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
		
		// Create Airport List
		for (Flight flight : flights) {
			if (!airports.containsKey(flight.getOrigin().getId())) {
				airports.put(flight.getOrigin().getId(), flight.getOrigin());
			}
			
			if (!airports.containsKey(flight.getDestination().getId())) {
				airports.put(flight.getDestination().getId(), flight.getDestination());
			}
		}
		
		// Create direct connections
		for (Flight flight : flights) {
			// go
			airports.get(flight.getOrigin().getId()).getFlightsTo().put(flight.getDestination(), flight);
			
			// return
			airports.get(flight.getDestination().getId()).getFlightsTo().put(flight.getOrigin(), flight);
		}
	}
	
	public void findFlight(String originAirportCode, String destinationAirportCode) {

		Airport originAirport = airports.get(originAirportCode);
		
		NavigableSet<Airport> q = new TreeSet<>();
	}
	
	private void findConnections(NavigableSet<Airport> q) {
		Airport u;
		Airport v;
		
		while (!q.isEmpty()) {
			
			u = q.pollFirst();
			
			//if (u.dist)
			for (Map.Entry<Airport, Flight> connection : u.getFlightsTo().entrySet() ){
				v = connection.getKey();
				
				long alternateCost = connection.getValue().getCost();
				
				
				
			}
		}
	}
}
