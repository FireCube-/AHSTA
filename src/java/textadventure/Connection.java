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
		this.name = name;
		this.destination = destination;
		this.desc = desc;
	}
	
	String ToString(){
		return name;
	}
	String Destination(){
		return desc;
	}
}
