package textadventure;

public class Connection {

	private String name;
	private String destination;
	private String desc;
	
	public Connection(String name, String destination){
		this.name = name;
		this.destination = destination;
	}
	
	public Connection(String name, String destination, String desc){
		this(name, destination);
		this.desc = desc;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDesc() {
		return this.desc;
	}
	
	public String getDestination() {
		return this.destination;
	}
}