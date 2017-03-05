package textadventure;

/**
 * Created by Gwion on 05/03/2017.
 */
public class IntentType {

    public enum Action{
        PICK_UP,
        MOVE,
        LOOK,
        USE,
        ATTACK
    };

    public String object;

public Action action;


}
