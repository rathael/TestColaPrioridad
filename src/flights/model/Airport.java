package flights.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Airports of the world
 * 
 * @author alex
 *
 */
public class Airport {

	private String id;
	
	private String name;
	
	private List<Airport> flightsTo = new ArrayList<Airport>();
	
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

	public List<Airport> getFlightsTo() {
		return flightsTo;
	}

	public void setFlightsTo(List<Airport> flightsTo) {
		this.flightsTo = flightsTo;
	}
}
