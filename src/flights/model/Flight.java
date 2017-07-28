package flights.model;

/**
 * Flight information
 * 
 * @author softtek2
 *
 */
public class Flight {
	private String id;
	
	private String originAirportCode;

	private String destinationAirportCode;
	
	private Long cost;

	public Flight(String id, String originAirportCode, String destinationAirportCode, Long cost) {
		super();
		this.id = id;
		this.originAirportCode = originAirportCode;
		this.destinationAirportCode = destinationAirportCode;
		this.cost = cost;
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

	public String getOriginAirportCode() {
		return originAirportCode;
	}

	public void setOriginAirportCode(String originAirportCode) {
		this.originAirportCode = originAirportCode;
	}

	public String getDestinationAirportCode() {
		return destinationAirportCode;
	}

	public void setDestinationAirportCode(String destinationAirportCode) {
		this.destinationAirportCode = destinationAirportCode;
	}
}
