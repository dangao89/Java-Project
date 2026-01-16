package LoanEligibilitySystem;

/**
 * Define a custom exception class LoanAmountTooHighException which extends the Exception class.
 */
public class LoanAmountTooHighException extends Exception {

    // Default constructor with a predefined message
    public LoanAmountTooHighException() {
        super("The requested loan amount exceeds the customer's calculated loan eligibility.");
    }

    //Parameterized constructor to allow custom message
    public LoanAmountTooHighException(String message) {
        super(message);
    }
}
