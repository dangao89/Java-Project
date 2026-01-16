package UniversitySystem;

/**
 * This class represents a lab course, with a limit on how many students can be
 * enrolled due to lab capacity. This class extends he abstract Course class and
 * provides a specific implementation for printing course details.
 */
public class LabCourse extends Course {

    //private sttributes
    private int labCapacity; //Maximum number of students allowed in the lab

    //Parameterized constructor
    public LabCourse(String courseName, int labCapacity) {
        super(courseName); //Call the superclass (Course) constructor
        this.labCapacity = labCapacity; //Set the labCapacity
    }

    @Override //Override enrollStudent method to check for lab and enroll the student
    public void enrollStudent(Student student) {
        if (enrollments.size() < labCapacity) { //Check if the current number of enrollments is less than the lab capacity
            super.enrollStudent(student); //Call the superclass to add the student to the enrollment list
        } else {
            System.out.println("The lab is full.");
        }
    }

    @Override //Implementation of the abstract method from Course class to print details specific for lab course
    public void printCourseDetails() {
      
        System.out.println("Lab Course: " + courseName); //Print the lab course name
        System.out.println("Lab Capacity: " + labCapacity); //Print the lab capacity
        System.out.println("Professor: " + (professor != null ? professor.getName() : "No professor assigned")); //Print the name of the professor
        System.out.println("Enrolled Students: "); //Print the list of enrolled students and their grades
        for (Enrollment enrollment : enrollments) {
            System.out.println("- Student: " + enrollment.getStudent().getName() + ", Grade: " + enrollment.getGrade());
        }
        System.out.println();

    }
}
