package UniversitySystem;

/**
 * Implements the Person interface and represents a professor in the system.
 */
import java.util.ArrayList;

public class Professor implements Person {

    //Private attributes
    private String name;
    private String professorID;
    private ArrayList<Course> coursesTaught; // A list of courses the professor teaches

    private static final int MAX_COURSES = 3; //Maxium number of courses a professor can teach

    //Parameterized constructor
    public Professor(String name, String professorID) {
        this.name = name;
        this.professorID = professorID;
        this.coursesTaught = new ArrayList<>(); //Initialize an empty list of coursesTaught
    }

    @Override //Implements the getName() method defined in Person interface
    public String getName() {
        return name;
    }

    @Override //Implements the getID() method defined in Person interface
    public String getID() {
        return professorID;
    }

    //Add a course to the professor's list of courses
    public void addCourse(Course course) throws IllegalArgumentException {
        //Check if the professor has reached the maximum course limit
        if (coursesTaught.size() < MAX_COURSES) {
            coursesTaught.add(course); //Adds the course to the list of the courses taught
            course.assignProfessor(this); //Assigns the professor to the course
        } else {
            //If the maximum number of courses has been reached, throw an exception with a descriptive message
            throw new IllegalArgumentException("Professor cannot be assigned to more than " + MAX_COURSES + " courses.\n");
        }
    }

    //Assign a grade to a student for a specific course
    public void assignGrade(Course course, Student student, String grade) {
        course.assignGrade(student, grade);
        System.out.println("Assigning Grade '" + grade + "' to Student '" + student.getName() + "' in '" + course.getCourseName() + "'...");
        System.out.println("Grade '" + grade + "' successfully assigned.\n");
    }

    //Print the list of courses taught by the professor
    public void printCourses() {
        for (Course course : coursesTaught) { //Iterate through each course in the coursesTaught list
            System.out.println(course.getCourseName()); //Print the name of current course
        }
    }
}
