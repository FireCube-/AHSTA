package textadventure;
import java.util.ArrayList;
import java.util.Collection;

public class Location {

	private String name;
	private String desc;
	private ArrayList<Connection> connections;
	private ArrayList<Entity> entities;
	
	public Location(String name){
		this.name = name;
	}
	
	public Location(String name, Collection<Connection> connections){
		this(name);
		this.connections = new ArrayList<>(connections);
	}
	
	public Location(String name, Collection<Connection> connections, String desc){
		this(name, connections);
		this.desc =  desc;
	}
	
	public Location(String name, Collection<Connection> connections, String desc, ArrayList<Entity> entities){
		this(name, connections, desc);
		this.entities = new ArrayList<>(entities);
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

	public Connection getConnection(String name) throws InvalidConnectionException {
		for (Connection c : this.connections) {
			if (c.getName() == name)
				return c;
		}
		throw new InvalidConnectionException("Invalid connection search");
	}
	public ArrayList<Connection> getConnections() {
		return connections;
	}

	public Entity getEntity(String name) throws InvalidEntityException {
		for (Entity e : this.entities) {
			if (e.getName() == name)
				return e;
		}
		throw new InvalidEntityException("Invalid entity search");
	}
	
	public ArrayList<Entity> getEntities() {
		return entities;
	}
	
	//Someone else can clean this up
	public String View(){
		String connectionsDesc = "There is:";
		for(int x = 0 ; x < connections.size() ; x++){
			connectionsDesc = connectionsDesc + ", a " + connections.get(x).getName();
					}
		connectionsDesc = connectionsDesc.substring(0,8) + connectionsDesc.substring(10,connectionsDesc.length()) + " in the " + this.name + ".\n";

		String entitiesDesc = "There is:";
		for(int x = 0 ; x < connections.size() ; x++){
			entitiesDesc = entitiesDesc + ", a " + connections.get(x).getName();
					}
		entitiesDesc = entitiesDesc.substring(0,8) + entitiesDesc.substring(10,entitiesDesc.length()) + " in the " + this.name + ".\n";

		
		return this.desc + "\n" + connectionsDesc + entitiesDesc;
	}
	
	
}
