package textadventure;
import java.util.ArrayList;

public class Location {

	private String name;
	ArrayList<Connection> connections = new ArrayList<Connection>();
	
	private String desc;
	ArrayList<Entity> entities = new ArrayList<Entity>();
	
	
	Location(String name){
		this.setName(name);
	}
	
	Location(String name, ArrayList<Connection> connections){
		this.setName(name);
		this.connections = connections;
	}
	
	Location(String name, ArrayList<Connection> connections, String desc){
		this.setName(name);
		this.connections = connections;
		this.setDesc(desc);
	}
	
	Location(String name, ArrayList<Connection> connections, String desc, ArrayList<Entity> entities) {
		this.setName(name);
		this.connections = connections;
		this.setDesc(desc);
		this.entities = entities;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
