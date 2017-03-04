import java.io.FileReader;
import java.io.BufferedReader;

public class Game {

	//save game state:
	//	Location name
	//	Inventory items


	private Location location;
	private Inventory inventory;

	public Game(String story) {
		//Creates a new save of the story name.
	}

	public Game(String save) {
		//Finds the save game and loads it.
	}
	
	boolean loadGame(String save) {
		//Loads the XML save of the game
		FileReader fr = new FileReader("../../saves/" + save + ".xml");
		BufferedReader br = new BufferedReader(fr);
		String check = Parser.getTag(br);
		if (check != "save")
			return false;
		String tag = Parser.getTag(br);
		while (!tag.equals("/save")) {
			switch(tag) {
				case "location":
					if (!loadLocation(Parser.getContent()) || Parser.getTag() != "/location")
						return false;
					break;
				case "item":
					if (!inventory.addItem(Parser.getContent) || Parser.getTag() != "/item")
						return false;
					break;
			}
		}
		return true;
	}

	boolean saveGame(String save) {
		//Makes an XML save of the game
	}

	boolean doAction(String action) {
		//Does the action specified as the parameter
	}

	boolean loadLocation(String name) {
		//Loads the location from xml and stores it in the location member variable.
		FileReader fr = new FileReader("../../" + name + ".xml");
		BufferedReader br = new BufferedReader(fr);
		String check = Parser.getTag();
		if (!check.equals("location"))
			return false;
	}

}
