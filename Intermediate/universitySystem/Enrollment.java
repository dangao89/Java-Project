package UniversitySystem;

/**
 * Represents the enrollment of a student in a specific course and stores the
 * grade assigned to the student.
 */
public class Enrollment {

    //Private attributes
    private Student student;
    private Course course;
    private String grade;

    //Parameterized constructor
    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.grade = "No grade assigned"; //Initialize the grade as "No grade assigned"
    }

    //Getter for student
    public Student getStudent() {
        return student;
    }

    //Method to get grade
    public String getGrade() {
        return grade;
    }

    //Method to assign a grade
    public void assignGrade(String grade) {
        this.grade = grade; //Sets the grade to the student
    }
}
