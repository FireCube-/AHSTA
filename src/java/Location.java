import java.util.ArrayList;

public class Location {

	String name;
	ArrayList<Connection> connections = new ArrayList<Connection>();
	
	String desc;
	
	
	Location(String name){
		this.name = name;
	}
	
	Location(String name, ArrayList<Connection> connections){
		this.name = name;
		this.connections = connections;
	}
	
	Location(String name, ArrayList<Connection> connections, String desc){
		this.name = name;
		this.connections = connections;
		this.desc = desc;
	}
	
}
