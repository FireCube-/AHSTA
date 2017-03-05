package textadventure;

import java.io.FileNotFoundException;

public class Game {
	
	private Location location;
	private Inventory inventory;

	public IntentType option1Type;
	public IntentType option2Type;
	public IntentType option3Type;
	public IntentType option4Type;

	public Game() {
		this.inventory = new Inventory();
		option1Type = new IntentType();
		option2Type = new IntentType();
		option3Type = new IntentType();
		option4Type = new IntentType();
	}
	
	public String doAction(IntentType.Action action, String object) {
		//Does the action specified as the parameter
		return "MASSIVE YACHT!";
	}

	public boolean newGame() {
		try {
			this.location = Parser.parseLocation("start.xml");
			this.inventory = new Inventory();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("start.xml not found");
			return false;
		}
	}
	
	public boolean loadGame(String name) {
		try {
			Save save = Parser.parseSave(System.getProperty("user.dir") + "/../../saves/" + name + ".xml");
			this.inventory = save.getInventory();
			this.location = save.getLocation();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(name + ".xml not found");
			return false;
		}
	}
	
	public boolean saveGame(String name) {
		Save save = new Save(this.location, this.inventory);
		save.saveToFile(name);
	}

}
