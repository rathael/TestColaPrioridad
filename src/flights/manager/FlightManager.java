package flights.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

import flights.model.Airport;
import flights.model.Flight;

/**
 * Graph of Flights
 * 
 * @author alex
 *
 */
public class FlightManager {

	private Map<String, Airport> airports;
	
	public static void main(String[] args) {
		
		// https://stackoverflow.com/questions/17480022/java-find-shortest-path-between-2-points-in-a-distance-weighted-map
		
		Flight[] GRAPH = { 
				new Flight("1", "a", "b", 7L), 
				new Flight("2", "a", "c", 9L),
				new Flight("3","a", "f", 14L), 
				new Flight("4","b", "c", 10L), 
				new Flight("5","b", "d", 15L),
				new Flight("6","c", "d", 11L), 
				new Flight("7","c", "f", 2L), 
				new Flight("8","d", "e", 6L),
				new Flight("9","e", "f", 9L),
				new Flight("10","a", "h", 18L),
				new Flight("11","h", "e", 2L)};		
		
		FlightManager g = new FlightManager(GRAPH);
		g.findFlight("a", null);
		g.printPath("e");
		// g.printAllPaths();
	}
	
	public FlightManager(Flight[] flights) {
		airports = new HashMap<>(flights.length);
		
		// Create Airport List
		for (Flight flight : flights) {
			if (!airports.containsKey(flight.getOriginAirportCode())) {
				airports.put(flight.getOriginAirportCode(), new Airport(flight.getOriginAirportCode(), flight.getOriginAirportCode()));
			}
			
			if (!airports.containsKey(flight.getDestinationAirportCode())) {
				airports.put(flight.getDestinationAirportCode(), new Airport(flight.getDestinationAirportCode(), flight.getDestinationAirportCode()));
			}
		}
		
		// Create direct connections
		for (Flight flight : flights) {
			Airport originAirport = airports.get(flight.getOriginAirportCode());
			Airport destinationAirport = airports.get(flight.getDestinationAirportCode());
			
			// go
			originAirport.getFlightsTo().put(destinationAirport, flight);
			
			// return
			destinationAirport.getFlightsTo().put(originAirport, flight);
		}
	}
	
	public void findFlight(String originAirportCode, String destinationAirportCode) {

		Airport originAirport = airports.get(originAirportCode);
		
		//NavigableSet<AirportPath> queue = new TreeSet<>();
		NavigableSet<Airport> queue = new TreeSet<>();
		
		for (Airport airport : airports.values()) {
			/*AirportPath airportPath = new AirportPath(airport);
			
			if (originAirportCode.equalsIgnoreCase(airport.getId())) {
				airportPath.setTotalCost(0L);
				airportPath.setPreviousAirport(airport);
			} else {
				airportPath.setTotalCost(Long.MAX_VALUE);
				airportPath.setPreviousAirport(null);
			}
			
			queue.add(airportPath);*/
			
			if (originAirportCode.equalsIgnoreCase(airport.getId())) {
				airport.setTotalCost(0L);
				airport.setPreviousAirport(airport);
			} else {
				airport.setTotalCost(Long.MAX_VALUE);
				airport.setPreviousAirport(null);
			}
			
			queue.add(airport);			
		}
		
		findConnections(queue);
	}
	
	private void findConnections(NavigableSet<Airport> queue) {
		Airport u;
		
		while (!queue.isEmpty()) {
			
			u = queue.pollFirst();

			if (u.getTotalCost() == Long.MAX_VALUE) {
				break;
			}
			
			for (Map.Entry<Airport, Flight> connection : u.getFlightsTo().entrySet() ){
				Airport v = connection.getKey();
				
				long alternateCost = u.getTotalCost() + connection.getValue().getCost();
				
				// http://www.vogella.com/tutorials/JavaAlgorithmsDijkstra/article.html
				
				if (alternateCost < v.getTotalCost()) {
					queue.remove(v);
					v.setTotalCost(alternateCost);
					v.setPreviousAirport(u);
					queue.add(v);
				}
			}
		}
	}
	
	/** Prints a path from the source to the specified vertex */
	public void printPath(String endName) {
		if (!airports.containsKey(endName)) {
			System.err.printf("Graph doesn't contain end vertex \"%s\"\n", endName);
			return;
		}

		airports.get(endName).printPath();
		System.out.println();
	}
}
