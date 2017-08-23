package flights.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Airports of the world
 * 
 * @author alex
 *
 */
public class Airport implements Comparable<Airport>{

	private String id;
	
	private String name;
	
	private Map<Airport, Flight> flightsTo = new HashMap<>();

	/**
	 * used in searchs
	 * TODO Create another class to manage this
	 */
	private Airport previousAirport;
	
	private Long totalCost = Long.MAX_VALUE;
	
	public Airport(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public void printPath() {
		if (this == this.previousAirport) {
			System.out.printf("%s", this.name);
		} else if (this.previousAirport == null) {
			System.out.printf("%s(unreached)", this.name);
		} else {
			this.previousAirport.printPath();
			System.out.printf(" -> %s(%d)", this.name, this.totalCost);
		}
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

	public Airport getPreviousAirport() {
		return previousAirport;
	}

	public void setPreviousAirport(Airport previousAirport) {
		this.previousAirport = previousAirport;
	}

	public Long getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Long totalCost) {
		this.totalCost = totalCost;
	}

	@Override
	public int compareTo(Airport other) {
		if (this.totalCost == other.totalCost) {
			return this.getName().compareTo(other.getName());
		}
		
		return Long.compare(this.totalCost, other.totalCost);
	}
}
