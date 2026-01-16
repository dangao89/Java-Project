package LeaderboardManagementSystem;

/**
 * Define a custom exception class InvalidScoreException which extends the
 * Exception class.Thrown if a contestant's total score is negative.
 */
public class InvalidScoreException extends Exception {

    //Constructor to initialize the exception with a custom error message
    public InvalidScoreException(String message) {
        //Call the superclass (Exception) and pass the message to the superclass
        super(message);
    }
}
