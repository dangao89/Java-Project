package LoanEligibilitySystem;

/**
 * Define a custom exception class InvalidCreditScoreException which extends the Exception class.
 */
public class InvalidCreditScoreException extends Exception {
    // Default constructor with a predefined message
    public InvalidCreditScoreException() {
        super("Invalid credit score.");
    }

    //Parameterized constructor to allow custom message
    public InvalidCreditScoreException(String message) {
        super(message);
    }
}
