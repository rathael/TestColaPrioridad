package flights.model;

/**
 * Flight information
 * 
 * @author softtek2
 *
 */
public class Flight {
	private String id;
	
	private Airport origin;

	private Airport destination;
	
	private Long cost;

	public Flight(String id, Airport origin, Airport destination, Long cost) {
		super();
		this.id = id;
		this.origin = origin;
		this.destination = destination;
		this.cost = cost;
	}

	public Airport getOrigin() {
		return origin;
	}

	public void setOrigin(Airport origin) {
		this.origin = origin;
	}

	public Airport getDestination() {
		return destination;
	}

	public void setDestination(Airport destination) {
		this.destination = destination;
	}

	public Long getCost() {
		return cost;
	}

	public void setCost(Long cost) {
		this.cost = cost;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
