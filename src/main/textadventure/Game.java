package textadventure;

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


	boolean doAction(String action) {
		//Does the action specified as the parameter
		return true;
	}

}
