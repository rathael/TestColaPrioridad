package flights.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Airports of the world
 * 
 * @author alex
 *
 */
public class Airport {

	private String id;
	
	private String name;
	
	private Map<Airport, Flight> flightsTo = new HashMap<>();
	
	public Airport(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Airport, Flight> getFlightsTo() {
		return flightsTo;
	}

	public void setFlightsTo(Map<Airport, Flight> flightsTo) {
		this.flightsTo = flightsTo;
	}


}
