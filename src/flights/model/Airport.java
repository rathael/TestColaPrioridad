package flights.model;

/**
 * Airports of the world
 * 
 * @author alex
 *
 */
public class Airport {

	private String id;
	
	private String name;
	
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
}
