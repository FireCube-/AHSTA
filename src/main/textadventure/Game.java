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
	
	public String doAction(String action, String object) throws InvalidActionException {
		//Does the action specified as the parameter
		switch(action) {
			case "move":
				return this.move(object);
			case "pickup":
				return this.pickUp(object);
			case "attack":
				return this.attack(object);
			case "look":
				return this.look(object);
			case "use":
				return this.use(object);
			default:
				throw new InvalidActionException();
		}
	}

	private String move(String destination) {
		try {
			Connection conn = this.location.getConnection(destination);
			this.location = Parser.parseLocation(destination);
			return this.describe();
		} catch (InvalidConnectionException e) {
			e.printStackTrace();
			return "There is no " + destination + " nearby.";
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "You are unable to go this way!";
		}
	}

	public String pickUp(String object) {
		try {
			Entity ent = this.location.getEntity(object);
			this.location.removeEntity(ent);
			this.inventory.add(ent);
			return "The " + object + " has been added to your inventory.";
		} catch (InvalidEntityException e) {
			e.printStackTrace();
			return "There is no such object around.";
		}	
	}
	
	public String attack(String object) {
		return "You injure yourself whilst trying to attack the " + object + ".";
	}
	
	public String look(String object) {
		Entity ent;
		try {
			ent = this.inventory.getEntity(object);
			return "Its a " + object + ". " + ent.getDesc();
		} catch (InvalidEntityException e) {
			e.printStackTrace();
			return "There is no such item in your inventory.";
		}

	}
	
	public String use(String object) {
		return "You can't use a " + object + ".";
	}
	
	public boolean newGame() {
		try {
			this.location = Parser.parseLocation("/adventurexml/start.xml");
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
	
	public boolean saveGame() {
		Save save = new Save(this.location, this.inventory);
		//save.saveToFile();
		return false;
	}

	public String describe() {
		return this.location.describe() + " " + this.inventory.describe();
	}

}
