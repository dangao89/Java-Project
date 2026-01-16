package LeaderboardManagementSystem;

/**
 * Define a custom exception class InvalidScoreException which extends the
 * Exception class.Thrown if the number of contests participated is zero or
 * negative.
 */
public class InvalidContestParticipationException extends Exception {

    //Constructor to initialize the exception with a custom error message
    public InvalidContestParticipationException(String message) {
        //Call the superclass (Exception) and pass the message to the superclass
        super(message);
    }

}
