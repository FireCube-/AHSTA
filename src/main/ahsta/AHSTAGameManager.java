package ahsta;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;
import com.amazonaws.services.dynamodbv2.*;

public class AHSTAGameManager {

	private final AHSTAGameDao ahstaGameDao;
	
    public AHSTAGameManager(final AmazonDynamoDBClient amazonDynamoDbClient) {
        AHSTADynamoDbClient dynamoDbClient = new AHSTADynamoDbClient(amazonDynamoDbClient);
        ahstaGameDao = new AHSTAGameDao(dynamoDbClient);
    }
    //placeholder
    public SpeechletResponse getLaunchResponse(LaunchRequest request, Session session) {
        String speechText;
        //AHSTAGame game = ahstaGameDao.getAHSTAGame(session);

        
        
        speechText = "It is almost harvesting season!";

        return getTellSpeechletResponse(speechText);
    }
  
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
        AHSTAGame game = ahstaGameDao.getAHSTAGame(session);

        if (game == null) {
            return getTellSpeechletResponse("Hello! New game started! TEST TEST TEST");
        }

        ahstaGameDao.saveAHSTAGame(game);

        String speechText = "New game started with!";

       
        return getTellSpeechletResponse(speechText);
    }
    public SpeechletResponse getExitIntentResponse (Intent intent, Session session){
        return null;
    }

    
    private SpeechletResponse getTellSpeechletResponse(String speechText) {
        // Create the Simple card content.
        SimpleCard card = new SimpleCard();
        card.setTitle("Session");
        card.setContent(speechText);

        // Create the plain text output.
        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        return SpeechletResponse.newTellResponse(speech, card);
    }
    
    private SpeechletResponse getAskSpeechletResponse(String speechText, String repromptText) {
        // Create the Simple card content.
        SimpleCard card = new SimpleCard();
        card.setTitle("Session");
        card.setContent(speechText);

        // Create the plain text output.
        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        // Create reprompt
        PlainTextOutputSpeech repromptSpeech = new PlainTextOutputSpeech();
        repromptSpeech.setText(repromptText);
        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(repromptSpeech);

        return SpeechletResponse.newAskResponse(speech, reprompt, card);
    }


	
}
