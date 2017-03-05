package textadventure;

public class InvalidConnectionException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InvalidConnectionException() {
		super();
	}
	
	public InvalidConnectionException(String message) {
		super(message);
	}

}
