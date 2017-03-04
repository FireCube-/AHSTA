package ahsta;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import com.amazon.speech.speechlet.Session;

/**
 * Represents a score keeper game.
 */
public final class AHSTAGame {
    private Session session;
    private AHSTAGameData gameData;

    private AHSTAGame() {
    }

    
    public static AHSTAGame newInstance(Session session, AHSTAGameData gameData) {
    	AHSTAGame game = new AHSTAGame();
        game.setSession(session);
        game.setGameData(gameData);
        return game;
    }

    protected void setSession(Session session) {
        this.session = session;
    }

    protected Session getSession() {
        return session;
    }

    protected AHSTAGameData getGameData() {
        return gameData;
    }

    protected void setGameData(AHSTAGameData gameData) {
        this.gameData = gameData;
    }

}
