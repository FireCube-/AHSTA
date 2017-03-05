package textadventure;

import java.util.Collection;
import java.util.HashSet;
import java.util.ArrayList;

public class Save {

	private Location location;
	private Inventory inventory;
	private ArrayList<Connection> connections;
	private ArrayList<Entity> entities;
	
	public static void main(String[] args){
		ArrayList<Connection> cons = new ArrayList<Connection>(3);
		cons.add(new Connection("door","A blue door with a metal doorknob.","LivingRoom"));
		cons.add(new Connection("window","A glass window with white borders, very classic.","Garden"));
		cons.add(new Connection("door","A white door with a metal doorknob.","DiningRoom"));
		ArrayList<Entity> ents = new ArrayList<Entity>(2);
		HashSet<String> hs1 = new HashSet<String>();
		hs1.add("hard");hs1.add("metal");
		ents.add(new Entity("key", "A small metal key. Looks quite new.", hs1));
		HashSet<String> hs2 = new HashSet<String>();
		hs2.add("black");hs2.add("wax");hs2.add("malleble");
		ents.add(new Entity("candle", "A black candle. Could probably be molded.", hs2));
		Location loc = new Location("Kitchen",cons,"A small kitchen, with black and white tiles.",ents);
		ArrayList<Entity> its = new ArrayList<Entity>(1);
		HashSet<String> hs3 = new HashSet<String>();
		hs3.add("sharp");hs3.add("metal");hs3.add("cold");
		its.add(new Entity("knife", "A shar metal knife. It's cold to the touch.", hs3));
		Inventory inv = new Inventory(its);
		Save save = new Save(loc, inv);
		save.Catalog();
	}

	public Save(Location location, Collection<Entity> inventory) {
		this.location = location;
		this.inventory = new Inventory(inventory);
		this.connections = location.getConnections();
		this.entities = location.getEntities();
	}
	public Save(Location location, Inventory inventory) {
		this.location = location;
		this.inventory = inventory;
		this.connections = location.getConnections();
		this.entities = location.getEntities();
	}

	public void Catalog(){
		print("<save>\n");
		print("	<location>\n");
		print("		<name>" + location.getName() + "</name>\n");
		print("		<desc>" + location.getDesc() + "</desc>\n");

		for (int a = 0 ; a < entities.size() ; a++){
			Entity entity = entities.get(a);
			print("		<entity>\n");
			print("			<name>" + entity.getName() + "</name>\n");
			print("			<desc>" + entity.getDesc() + "</desc>\n");

			ArrayList<String> props = new ArrayList<String>(entity.getProperties());
			for(int b = 0 ; b < props.size() ; b++){
				print("			<property>" + props.get(b) + "</property>\n");
			}

			print("		</entity>\n");

		}
		for (int a = 0 ; a < connections.size() ; a++){
			Connection connection = connections.get(a);
			print("		<connection>\n");
			print("			<name>" + connection.getName() + "</name>\n");
			print("			<desc>" + connection.getDesc() + "</desc>\n");
			print("			<destination>" + connection.getDestination() + "</destination>\n");
			print("		</connection>\n");
		}
		print("	</location>\n");
		print("	<inventory>\n");

		for (int a = 0 ; a < inventory.size() ; a++){
			Entity entity = inventory.get(a);
			print("		<entity>\n");
			print("			<name>" + entity.getName() + "</name>\n");
			print("			<desc>" + entity.getDesc() + "</desc>\n");

			ArrayList<String> props = new ArrayList<String>(entity.getProperties());
			for(int b = 0 ; b < props.size() ; b++){
				print("			<property>" + props.get(b) + "</property>\n");
			}

			print("		</entity>\n");

		}

		print("	</inventory>\n");
		print("</save>\n");
	}

	public Location getLocation() {
		return this.location;
	}

	public Inventory getInventory() {
		return this.inventory;
	}

	void print(String str){
		System.out.print(str);
	}

}