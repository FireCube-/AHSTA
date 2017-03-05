package ahsta;

import textadventure.Game;

/**
 * Contains player and score data to represent a score keeper game.
 */
public class AHSTAGameData {
    
	private Game game;

    public AHSTAGameData() {
        // public no-arg constructor required for DynamoDBMapper marshalling
    }

    public static AHSTAGameData newInstance() {
    	AHSTAGameData newInstance = new AHSTAGameData();
    	newInstance.setGame(null);
        return newInstance;
    }
    
    public void setGame(Game game) {
    	this.game = game;
    }
}
