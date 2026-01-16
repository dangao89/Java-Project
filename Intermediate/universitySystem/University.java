package UniversitySystem;

/**
 * The University class is responsible for managing students, professor, and
 * courses.
 */
import java.util.ArrayList;

public class University {

    //Private sttributes
    private ArrayList<Student> students;
    private ArrayList<Professor> professors;
    private ArrayList<Course> courses;

    //Default constructor
    public University() {
        this.students = new ArrayList<>();
        this.professors = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    //Add a student to the university
    public void addStudent(Student student) {
        //Add a student to the students list       
        students.add(student);
        System.out.println("Student '" + student.getName() + "' added successfully!\n");
    }

    //Add a professor to the university
    public void addProfessor(Professor professor) {
        //Add a professor to the professors list
        professors.add(professor);
        System.out.println("Professor '" + professor.getName() + "' added successfully!\n");
    }

    //Add a course to the university
    public void addCourse(Course course) {
        //Add a course to the courses list
        courses.add(course);
        System.out.println("Course '" + course.getCourseName() + "' added successfully!\n");
    }

    //Enroll a student in a course
    public void enrollStudentInCourse(Student student, Course course) {
        //Check if the student and course exist in the university before enrolling
        if (students.contains(student) && courses.contains(course)) {
            course.enrollStudent(student); //Enroll the student in the specified course
            System.out.println("Enrolling Student '" + student.getName() + "' in " + "'" + course.getCourseName() + "'...");
            System.out.println("Student '" + student.getName() + "' successfully enrolled in " + "'" + course.getCourseName() + "'.\n");
        } else {
            System.out.println("Student or Course not found.\n");
        }
    }

    //Assign a professor to a course
    public void assignProfessorToCourse(Professor professor, Course course) {
        //Check if the professor and course exist in the university before assigning
        if (professors.contains(professor) && courses.contains(course)) {
            course.assignProfessor(professor); //Assign the professor to the specified course
            System.out.println("Assigning Professor '" + professor.getName() + "' to " + "'" + course.getCourseName() + "'...");
            System.out.println("Professor '" + professor.getName() + "' is now assigned to " + "'" + course.getCourseName() + "'.\n");
        } else {
            System.out.println("Professor or Course not found.\n");
        }
    }

    //Print details of all courses
    public void printAllCourses() {
        System.out.println("--- All Courses ---"); //Header for course details
        for (Course course : courses) {
            course.printCourseDetails(); //Print course details
        }
    }

    //Getter for students
    public ArrayList<Student> getStudents() {
        return students;
    }

    //Find a student by ID
    public Student findStudentByID(String studentID) {
        for (Student student : students) {  //Iterate over each student in the stuents list
            if (student.getID().equals(studentID)) { //Check if current ID matches the given ID
                return student;
            }
        }
        return null; //Return null if no student with the given ID is found
    }

    //Find a professor by their ID
    public Professor findProfessorByID(String professorID) {
        for (Professor professor : professors) { //Iterate over each professor in the professors list
            if (professor.getID().equals(professorID)) { //Check if current ID matches the given ID
                return professor;
            }
        }
        return null; //Return null if no professor with the given ID is found
    }

    //Find a course by its name
    public Course findCourseByName(String courseName) {
        for (Course course : courses) { //Iterate over each course in the courses list
            if (course.getCourseName().equals(courseName)) { //Check if current course's name matches the given name
                return course;
            }
        }
        return null; //Return null if no course with the given name is found
    }
}
