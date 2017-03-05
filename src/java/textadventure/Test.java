package textadventure;

import java.io.FileNotFoundException;

public class Test {
	
	public static void main(String[] args) throws FileNotFoundException {
		Game game = new Game();
		game.loadLocation("test-location.xml");
	}
	
}
