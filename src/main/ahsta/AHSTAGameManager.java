package ahsta;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;
import textadventure.Game;


public class AHSTAGameManager {

    private Game game;

    //placeholder
    public SpeechletResponse getLaunchResponse(LaunchRequest request, Session session) {
        String speechText;

        speechText = "It is almost harvesting season!";

        return getTellSpeechletResponse(speechText);
    }
  
    public SpeechletResponse getOption1IntentResponse (Intent intent, Session session){

        String speechText = murrayFunction(game.option1Type.action, game.option1Type.object);

        return getTellSpeechletResponse(speechText);
    }
    public SpeechletResponse getOption2IntentResponse (Intent intent, Session session){
        String speechText = murrayFunction(game.option2Type.action, game.option2Type.object);

        return getTellSpeechletResponse(speechText);
    }
    public SpeechletResponse getOption3IntentResponse (Intent intent, Session session){
        String speechText = murrayFunction(game.option3Type.action, game.option3Type.object);

        return getTellSpeechletResponse(speechText);
    }
    public SpeechletResponse getOption4IntentResponse (Intent intent, Session session){
        String speechText = murrayFunction(game.option4Type.action, game.option4Type.object);

        return getTellSpeechletResponse(speechText);
    }
    public SpeechletResponse getNewGameIntentResponse (Intent intent, Session session){

       game = new Game();

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
