package flights.model;

public class AirportPath {

	private Airport airport;
	
	private Airport previousAirport;
	
	private Long totalCost;
	
	public AirportPath(Airport airport) {
		this.airport = airport;
	}

	public Long getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Long totalCost) {
		this.totalCost = totalCost;
	}

	public Airport getAirport() {
		return airport;
	}

	public void setAirport(Airport airport) {
		this.airport = airport;
	}

	public Airport getPreviousAirport() {
		return previousAirport;
	}

	public void setPreviousAirport(Airport previousAirport) {
		this.previousAirport = previousAirport;
	}
}
