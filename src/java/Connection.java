
public class Connection {
	String name;
	Location destination;
	
	String desc;
	
	Connection(String name, Location destination){
		this.name = name;
		this.destination = destination;
	}
	
	Connection(String name, Location destination, String desc){
		this.name = name;
		this.destination = destination;
		this.desc = desc;
	}
	
}
