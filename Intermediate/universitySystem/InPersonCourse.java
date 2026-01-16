package UniversitySystem;

/**
 * This class represents an in-person course. It extends the abstract Course
 * class and provides a specific implementation for printing course details.
 */
public class InPersonCourse extends Course {

    //Parameterized constructor
    public InPersonCourse(String courseName) {
        super(courseName); //Call the superclass (Course) constructor        
    }

    @Override //Implementation of the abstract method from Course class to print details specific for in-person course
    public void printCourseDetails() {
        System.out.println("In-Person Course: " + courseName); //Print the name of in-person course
        System.out.println("Professor: " + (professor != null ? professor.getName() : "No professor assigned")); //Print the name of the professor
        System.out.println("Enrolled Students: "); //Print the list of enrolled students and their grades
        for (Enrollment enrollment : enrollments) {
            System.out.println("- Student: " + enrollment.getStudent().getName() + ", Grade: " + enrollment.getGrade());
        }
        System.out.println();
    }
}
