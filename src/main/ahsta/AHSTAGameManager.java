package ahsta;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;
import textadventure.Game;
import textadventure.IntentType;


public class AHSTAGameManager {

    private Game game;

    //placeholder
    public SpeechletResponse getLaunchResponse(LaunchRequest request, Session session) {
        String speechText;

        speechText = "It is almost harvesting season!";

        return getTellSpeechletResponse(speechText);
    }

    public SpeechletResponse getMoveIntentResponse (Intent intent, Session session){
        String speechText = new String();
        speechText = game.doAction("move", intent.getSlot("Object").getValue().toString());
        return getTellSpeechletResponse(speechText);
    }
    public SpeechletResponse getPickUpIntentResponse (Intent intent, Session session){
        String speechText = new String();
        speechText = game.doAction("pickup", intent.getSlot("Object").getValue().toString());
        return getTellSpeechletResponse(speechText);
    }
    public SpeechletResponse getAttackIntentResponse (Intent intent, Session session){
        String speechText = new String();
        speechText = game.doAction("attack", intent.getSlot("Object").getValue().toString());
        return getTellSpeechletResponse(speechText);
    }
    public SpeechletResponse getUseIntentResponse (Intent intent, Session session){
        String speechText = new String();
        speechText = game.doAction("use", intent.getSlot("Object").getValue().toString());
        return getTellSpeechletResponse(speechText);
    }
    public SpeechletResponse getLookIntentResponse (Intent intent, Session session){
        String speechText = new String();
        speechText = game.doAction("look", intent.getSlot("Object").getValue().toString());
        return getTellSpeechletResponse(speechText);
    }
    public SpeechletResponse getNewGameIntentResponse (Intent intent, Session session){
        String speechText = "New game started!";

        game = new Game();

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
