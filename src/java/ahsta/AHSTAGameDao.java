package ahsta;

import com.amazon.speech.speechlet.Session;

/**
 * Contains the methods to interact with the persistence layer for ScoreKeeper in DynamoDB.
 */
public class AHSTAGameDao {
    private final AHSTADynamoDbClient dynamoDbClient;

    public AHSTAGameDao(AHSTADynamoDbClient dynamoDbClient) {
        this.dynamoDbClient = dynamoDbClient;
    }

    /**
     * Reads and returns the {@link ScoreKeeperGame} using user information from the session.
     * <p>
     * Returns null if the item could not be found in the database.
     * 
     * @param session
     * @return
     */
    public AHSTAGame getAHSTAGame(Session session) {
        AHSTAGameDataItem item = new AHSTAGameDataItem();
        item.setCustomerId(session.getUser().getUserId());

        item = dynamoDbClient.loadItem(item);

        if (item == null) {
            return null;
        }

        return AHSTAGame.newInstance(session, item.getGameData());
    }

    /**
     * Saves the {@link ScoreKeeperGame} into the database.
     * 
     * @param game
     */
    public void saveAHSTAGame(AHSTAGame game) {
    	AHSTAGameDataItem item = new AHSTAGameDataItem();
        item.setCustomerId(game.getSession().getUser().getUserId());
        item.setGameData(game.getGameData());

        dynamoDbClient.saveItem(item);
    }
}

