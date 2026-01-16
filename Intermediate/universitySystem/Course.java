package UniversitySystem;

/**
 * The abstract Course class is the super class for all types of courses.
 */
import java.util.ArrayList;

public abstract class Course {

    //Private attributes
    protected String courseName;
    protected Professor professor;
    protected ArrayList<Enrollment> enrollments; //A list of students enrolled in the course and their grades

    private static final int MAX_STUDENTS = 50; //Maximum number of students allowed per course

    //Parameterized constructor
    protected Course(String courseName) {
        this.courseName = courseName;
        this.professor = null; //Initialize professor as unassigned
        this.enrollments = new ArrayList<>(); //Initialize an empty list of enrollments
    }

    //Getter for courseName
    public String getCourseName() {
        return courseName;
    }

    //Assign a professor to the course
    public void assignProfessor(Professor professor) {
        this.professor = professor; //Set the professor for this course

    }

    //Enroll a student in the course
    public void enrollStudent(Student student) throws IllegalArgumentException {
        //Check if the enrollments has reached the maximum student limit
        if (enrollments.size() < MAX_STUDENTS) {
            Enrollment enrollment = new Enrollment(student, this); //Create a new enrollment for the student
            enrollments.add(enrollment); //Add the enrollment to the list
        } else {
            //If the maximum number of students has been reached, throw an exception with a descriptive message
            throw new IllegalArgumentException("Enrollment limit reached. " + courseName + " can have at most " + MAX_STUDENTS + " students.\n");
        }
    }

    //Assign a grade to a student enrolled in the course
    public void assignGrade(Student student, String grade) {
        for (Enrollment enrollment : enrollments) { //Loop through each enrollment matches the student
            if (enrollment.getStudent().equals(student)) { //Check if the current enrollemnt matches the student
                enrollment.assignGrade(grade); //Assign the grade to the student
                break;
            }
        }
    }

    //Abstract method to print course-specific details
    public abstract void printCourseDetails(); //To be implemented by subclasses to provide specific details about the course

}
