package ahsta;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

public class AHSTAGameManager {

	private final AHSTAGameDao ahstaGameDao;
	

    public AHSTAGameManager(final AmazonDynamoDBClient amazonDynamoDbClient) {
        AHSTADynamoDbClient dynamoDbClient = new AHSTADynamoDbClient(amazonDynamoDbClient);
        ahstaGameDao = new AHSTAGameDao(dynamoDbClient);
    }
    //placeholder
    public static SpeechletResponse getLaunchResponse(LaunchRequest requst, Session session) {
    	return null;
    }    
    public static SpeechletResponse getOption1IntentResponse (Intent intent, Session session){
        return null;
    }
    public static SpeechletResponse getOption2IntentResponse (Intent intent, Session session){
        return null;
    }
    public static SpeechletResponse getOption3IntentResponse (Intent intent, Session session){
        return null;
    }
    public static SpeechletResponse getOption4IntentResponse (Intent intent, Session session){
        return null;
    }
    public static SpeechletResponse getNewGameIntentResponse (Intent intent, Session session){
        return null;
    }
    public static SpeechletResponse getExitIntentResponse (Intent intent, Session session){
        return null;
    }



	
}
