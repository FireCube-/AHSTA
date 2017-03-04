package ahsta;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

public class AHSTAGameManager {

	private final AHSTAGameDao ahstaGameDao;
	

    public AHSTAGameManager(final AmazonDynamoDBClient amazonDynamoDbClient) {
        ScoreKeeperDynamoDbClient dynamoDbClient =
                new ScoreKeeperDynamoDbClient(amazonDynamoDbClient);
        ahstaGameDao = new AHSTAGameDao(dynamoDbClient);
    }
    //placeholder
    public SpeechletResponse getOption1IntentResponse (Intent intent, Session session){
        return null;
    }
    public SpeechletResponse getOption2IntentResponse (Intent intent, Session session){
        return null;
    }
    public SpeechletResponse getOption3IntentResponse (Intent intent, Session session){
        return null;
    }
    public SpeechletResponse getOption4IntentResponse (Intent intent, Session session){
        return null;
    }
    public SpeechletResponse getNewGameIntentResponse (Intent intent, Session session){
        return null;
    }
    public SpeechletResponse getExitIntentResponse (Intent intent, Session session){
        return null;
    }



	
}
