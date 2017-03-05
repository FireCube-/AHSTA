package textadventure;

public class InvalidEntityException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidEntityException() {
		super();
	}
	
	public InvalidEntityException(String message) {
		super(message);
	}
	
}
