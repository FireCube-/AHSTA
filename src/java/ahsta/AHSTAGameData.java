package ahsta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    	newInstance.setGame(new Game());
        return newInstance;
    }
    
    public void setGame(Game game) {
    	this.game = game;
    }
}
