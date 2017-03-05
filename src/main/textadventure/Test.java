package textadventure;

import java.io.FileNotFoundException;

public class Test {
	public static void main(String[] args) throws FileNotFoundException {
		Game game = new Game();
		if (game.loadLocation("test-location"))
			game.printLocation();
		else
			System.out.println("Returned false!");
			
	}

}
