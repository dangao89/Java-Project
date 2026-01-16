package UniversitySystem;

/**
 * The Person interface defines common behavior for both Student and Professor.
 */
public interface Person {

    //Abstract method which will be implemented by the child class
    public abstract String getName();

    //Abstract method which will be implemented by the child class
    public abstract String getID();
}
