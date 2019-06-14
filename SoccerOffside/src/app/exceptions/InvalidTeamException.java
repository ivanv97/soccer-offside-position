package app.exceptions;

/*Creating a custom checked exception - for when the array of teams is not accurately defined*/
public class InvalidTeamException extends Exception {
	public InvalidTeamException(String message) {
		super(message);
	}
}
