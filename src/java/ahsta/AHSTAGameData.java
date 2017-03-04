package ahsta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Contains player and score data to represent a score keeper game.
 */
public class AHSTAGameData {
    
	

    public AHSTAGameData() {
        // public no-arg constructor required for DynamoDBMapper marshalling
    }

    /**
     * Creates a new instance of {@link ScoreKeeperGameData} with initialized but empty player and
     * score information.
     * 
     * @return
     */
    public static AHSTAGameData newInstance() {
    	AHSTAGameData newInstance = new AHSTAGameData();
        newInstance.setPlayers(new ArrayList<String>());
        newInstance.setScores(new HashMap<String, Long>());
        return newInstance;
    }


    @Override
    public String toString() {
        return "[ScoreKeeperGameData players: " + players + "] scores: " + scores + "]";
    }
}
