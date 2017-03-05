package textadventure;

public class Connection {
	String name;
	String destination;
	String desc;
	
	Connection(String name, String destination){
		this.name = name;
		this.destination = destination;
	}
	
	Connection(String name, String destination, String desc){
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