package ahsta;
import java.util.HashSet;
import java.util.Set;

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;

public final class AHSTASpeechletRequestStreamHandler extends SpeechletRequestStreamHandler {

    private static final Set<String> supportedApplicationIds = new HashSet<String>();
    
    static {
        supportedApplicationIds.add("amzn1.ask.skill.2b3f9ac4-2dd1-430f-aa93-46960e947a2d");
    }

    public AHSTASpeechletRequestStreamHandler() {
        super(new AHSTASpeechlet(), supportedApplicationIds);
    }
}
