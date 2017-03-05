package textadventure;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class Game {

	private Location location;
	private Inventory inventory;

	public Game() {
		this.inventory = new Inventory();
	}

	boolean doAction(String action) {
		//Does the action specified as the parameter
		return true;
	}

	boolean loadLocation(String name) throws FileNotFoundException {
		//Loads the location from xml and stores it in the location member variable.
		FileReader fr = new FileReader("../../" + name + ".xml");
		BufferedReader br = new BufferedReader(fr);
		String check = Parser.getTag(br);
		if (!check.equals("location"))
			return false;
		String tag = Parser.getTag(br);
		String locName = "";
		String locDesc = "";
		ArrayList<Entity> locEntities = new ArrayList<>();
		ArrayList<Connection> locConnections = new ArrayList<>();
		while (!tag.equals("/location")) {
			switch(tag) {
				case "name":
					locName = Parser.getContent(br);
					if (!Parser.getTag(br).equals("/name"))
						return false;
					break;
				case "desc":
					locName = Parser.getContent(br);
					if (!Parser.getTag(br).equals("/desc"))
						return false;
					break;
				case "entity":
					locEntities.add(this.loadEntity(br));
					break;
				case "connection":
					locConnections.add(this.loadConnection(br));
					break;
				default:
					return false;
			}
			tag = Parser.getTag(br);
		}
		this.location = new Location(locName, locConnections, locDesc, locEntities);
		return true;
	}

	private Entity loadEntity(BufferedReader br) {
		String tag = Parser.getTag(br);
		String eName = "";
		String eDesc = "";
		HashSet<String> eProps = new HashSet<>();
		while (!tag.equals("/entity")) {
			switch(tag) {
				case "name":
					eName = Parser.getContent(br);
					if (!Parser.getTag(br).equals("/name"))
						return new Entity("ERROR", "INVALID ENTITY NAME");
					break;
				case "desc":
					eDesc = Parser.getContent(br);
					if (!Parser.getTag(br).equals("/desc"))
						return new Entity("ERROR", "INVALID ENTITY DESCRIPTION");
					break;
				case "property":
					eProps.add(Parser.getContent(br));
					if (!Parser.getTag(br).equals("/property"))
						return new Entity("ERROR", "INVALID ENTITY PROPERTY");
					break;
				default:
					return new Entity("ERROR", "INVALID ENTITY XML");
		
			}
			tag = Parser.getTag(br);
		}
		return new Entity(eName, eDesc);
	}
	
	private Connection loadConnection(BufferedReader br) {
		String tag = Parser.getTag(br);
		String cName = "";
		String cDesc = "";
		String cDestination = "";
		while (!tag.equals("/connection")) {
			switch(tag) {
				case "name":
					cName = Parser.getContent(br);
					if (!Parser.getTag(br).equals("/name"))
						return new Connection("ERROR", "INVALID CONNECTION NAME");
					break;
				case "desc":
					cName = Parser.getContent(br);
					if (!Parser.getTag(br).equals("/desc"))
						return new Connection("ERROR", "INVALID CONNECTION DESCRIPTION");
					break;
				case "destination":
					cDestination = Parser.getContent(br);
					if (!Parser.getTag(br).equals("/destination"))
						return new Connection("ERROR", "INVALID CONNECTION DESTINATION");
					break;
				default:
					return new Connection("ERROR", "INVALID CONNECTION XML");
		
			}
			tag = Parser.getTag(br);
		}
		return new Connection(cName, cDestination, cDesc);
	}


}
