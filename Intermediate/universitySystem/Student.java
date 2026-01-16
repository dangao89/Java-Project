package UniversitySystem;

/**
 * Implements the Person interface and represents a student in the system.
 */
public class Student implements Person {

    //Private attributes
    private String name;
    private String studentID;

    //Parameterized constructor
    public Student(String name, String studentID) {
        this.name = name;
        this.studentID = studentID;
    }

    @Override  //Implements the getName() method defined in Person interface
    public String getName() {
        return name;
    }

    @Override  //Implements the getID() method defined in Person interface
    public String getID() {
        return studentID;
    }
}
