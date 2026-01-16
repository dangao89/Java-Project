package LoanEligibilitySystem;

/**
 * The Person interface defines common behaviors for both the Customer and
 * LoanOfficer.
 */
public interface Person {

    //Abstract method which will be implemented by the child class
    public abstract String getName();

    public abstract String getID();
}
