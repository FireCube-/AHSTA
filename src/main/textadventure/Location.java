package textadventure;
import java.util.ArrayList;

public class Location {
	
	public static void main(String[] args){
		ArrayList<Connection> cons = new ArrayList<Connection>();
		cons.add(new Connection("door","north"));
		cons.add(new Connection("gate","south"));
		ArrayList<Entity> ents = new ArrayList<Entity>();
		ents.add(new Entity("grandfather clock"));
		ents.add(new Entity("chest full of gold"));
		Location temp = new Location("room",cons,"This is a bleeeeak room ful of air, nothing and loneliness.",ents);
		System.out.println(temp.View());
	}

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
	
	Location(String name, ArrayList<Connection> connections, String desc, ArrayList<Entity> entities){
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
	public String View(){
		String connectionsDesc = "There is:";
		for(int x = 0 ; x < connections.size() ; x++){
			connectionsDesc = connectionsDesc + ", a " + connections.get(x).name;
					}
		connectionsDesc = connectionsDesc.substring(0,8) + connectionsDesc.substring(10,connectionsDesc.length()) + " in the " + this.name + ".\n";

		String entitiesDesc = "There is:";
		for(int x = 0 ; x < connections.size() ; x++){
			entitiesDesc = entitiesDesc + ", a " + connections.get(x).name;
					}
		entitiesDesc = entitiesDesc.substring(0,8) + entitiesDesc.substring(10,entitiesDesc.length()) + " in the " + this.name + ".\n";

		
		return this.desc + "\n" + connectionsDesc + entitiesDesc;
		
	}
	
	
}
