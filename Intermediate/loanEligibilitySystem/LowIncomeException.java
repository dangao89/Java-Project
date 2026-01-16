package LoanEligibilitySystem;

/**
 * Define a custom exception class LowIncomeException which extends the Exception class.
 */
public class LowIncomeException extends Exception {

    // Default constructor with a predefined message
    public LowIncomeException() {
        super("Customer's income is too low to qualify for the requested loan.");
    }

    //Parameterized constructor to allow custom message
    public LowIncomeException(String message) {
        super(message);
    }
}
