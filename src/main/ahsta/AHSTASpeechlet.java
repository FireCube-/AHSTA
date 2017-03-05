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



public class AHSTASpeechlet implements Speechlet {

	private static final Logger log = LoggerFactory.getLogger(ahsta.AHSTASpeechlet.class);
	

	private AHSTAGameManager ahstaGameManager = new AHSTAGameManager();

	@Override
	public void onSessionStarted(SessionStartedRequest request, Session session) throws SpeechletException {
		log.info("onSessionStarted requestId={}, sessionId={}", request.getRequestId(), session.getSessionId());
		//ahstaGameManager = new AHSTAGameManager();
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
		if ("MoveIntent".equals(intent.getName())) {
			return ahstaGameManager.getMoveIntentResponse(intent, session);

		} else if ("PickUpIntent".equals(intent.getName())) {
			return ahstaGameManager.getPickUpIntentResponse(intent, session);

		} else if ("AttackIntent".equals(intent.getName())) {
			return ahstaGameManager.getAttackIntentResponse(intent, session);

		} else if ("UseIntent".equals(intent.getName())) {
			return ahstaGameManager.getUseIntentResponse(intent, session);

		} else if ("LookIntent".equals(intent.getName())) {
			return ahstaGameManager.getLookIntentResponse(intent, session);

		} else if ("NewGameIntent".equals(intent.getName())) {
			return ahstaGameManager.getNewGameIntentResponse(intent, session);

		} else if ("AMAZON.StopIntent".equals(intent.getName())) {
			return ahstaGameManager.getExitIntentResponse(intent, session);

		} else {
			throw new IllegalArgumentException("I am sorry, you cannot perform that action.");
		}
	}

	@Override
	public void onSessionEnded(SessionEndedRequest request, Session session) throws SpeechletException {
		log.info("onSessionEnded requestId={}, sessionId={}", request.getRequestId(), session.getSessionId());

	}

}
