package ahsta;
import java.util.HashSet;
import java.util.Set;

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;

public final class AHSTASpeechletRequestStreamHandler extends SpeechletRequestStreamHandler {

    private static final Set<String> supportedApplicationIds;
    
    static {
        supportedApplicationIds = new HashSet<String>();
     // supportedApplicationIds.add("amzn1.echo-sdk-ams.app.[unique-value-here]");
    }

    public AHSTASpeechletRequestStreamHandler() {
        super(new AHSTASpeechlet(), supportedApplicationIds);
    }
}
