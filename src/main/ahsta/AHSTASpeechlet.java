package ahsta;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.SpeechletException;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazonaws.services.dynamodbv2.*;

public class AHSTASpeechlet implements Speechlet {

	private static final Logger log = LoggerFactory.getLogger(AHSTASpeechlet.class);
	

	public static void main(String[] args) {
		
	}
	
    private AHSTAGameManager ahstaGameManager;
	
	@Override
	public void onSessionStarted(SessionStartedRequest request, Session session) throws SpeechletException {
		log.info("onSessionStarted requestId={}, sessionId={}", request.getRequestId(), session.getSessionId());
		ahstaGameManager = new AHSTAGameManager();
	}

	@Override
	//onlaunch is run when the skill is opened without an intent
	//not sure whether to use this or an intent to launch the program - keeping it here for now
	public SpeechletResponse onLaunch(LaunchRequest request, Session session) throws SpeechletException {
		log.info("onLaunch requestId={}, sessionId={}", request.getRequestId(), session.getSessionId());
		return ahstaGameManager.getLaunchResponse(request, session);
}

	@Override
	public SpeechletResponse onIntent(IntentRequest request, Session session) throws SpeechletException {
		log.info("onIntent requestId={}, sessionId={}", request.getRequestId(), session.getSessionId());

		Intent intent = request.getIntent();
		if ("OptionOneIntent".equals(intent.getName())) {
			return ahstaGameManager.getOption1IntentResponse(intent, session);

		} else if ("OptionTwoIntent".equals(intent.getName())) {
			return ahstaGameManager.getOption2IntentResponse(intent, session);

		} else if ("OptionThreeIntent".equals(intent.getName())) {
			return ahstaGameManager.getOption3IntentResponse(intent, session);

		} else if ("OptionFourIntent".equals(intent.getName())) {
			return ahstaGameManager.getOption4IntentResponse(intent, session);

		} else if ("NewGameIntent".equals(intent.getName())) {
			return ahstaGameManager.getNewGameIntentResponse(intent, session);

		} else if ("AMAZON.StopIntent".equals(intent.getName())) {
			return ahstaGameManager.getExitIntentResponse(intent, session);

		} else {
			throw new IllegalArgumentException("Unrecognized intent: " + intent.getName());
		}
	}

	@Override
	public void onSessionEnded(SessionEndedRequest request, Session session) throws SpeechletException {
		log.info("onSessionEnded requestId={}, sessionId={}", request.getRequestId(), session.getSessionId());

	}

}
