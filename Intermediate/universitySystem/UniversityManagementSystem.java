package UniversitySystem;

/**
 * Date: 10/8/2024
 * Program Title: University Management System 
 */
import java.util.Scanner;

public class UniversityManagementSystem {

    public static void main(String[] args) {
        System.out.println("Program Title: University Management System");
        System.out.println("Author: Dan Gao");
        System.out.println("Course: CSC 230, Sec 01");
        System.out.println("-------------------------");

        Scanner input = new Scanner(System.in); //Create Scanner object for input
        University university = new University(); //Create an instance of the University class

        while (true) { //Loop for menu system
            System.out.println("--- University Management System Menu ---");
            System.out.println("1. Add a Student");
            System.out.println("2. Add a Professor");
            System.out.println("3. Add a Course");
            System.out.println("4. Enroll a Student in a Course");
            System.out.println("5. Assign a Professor to a Course");
            System.out.println("6. Assign Grades");
            System.out.println("7. View All Courses");
            System.out.println("8. View All Students");
            System.out.println("9. Exit");
            System.out.print("Choose an option: "); //Prompt the user to choose an option

            int choice = input.nextInt(); //Read user's choice as an integer
            input.nextLine(); //Clear the input buffer
            System.out.println();

            switch (choice) { //Switch to handle the different menu options
                case 1: //Add a Student
                    System.out.print("Enter Student Name: ");
                    String studentName = input.nextLine();

                    System.out.print("Enter Student ID: ");
                    String studentID = input.nextLine();

                    Student student = new Student(studentName, studentID); //Create a new Student object
                    university.addStudent(student); //Add the student to the univesity
                    break;

                case 2: //Add a Professor
                    System.out.print("Enter Professor Name: ");
                    String professorName = input.nextLine();

                    System.out.print("Enter Professor ID: ");
                    String professorID = input.nextLine();

                    Professor professor = new Professor(professorName, professorID); //Create a new Professor object
                    university.addProfessor(professor); //Add the professor to the university
                    break;

                case 3: //Add a course
                    System.out.print("Select Course Type (1: General, 2: In-Person, 3: Lab): ");
                    int courseType = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Course Name: ");
                    String courseName = input.nextLine();

                    Course course = null; //Initialize a Course object to null
                    if (courseType == 1) {
                        course = new GeneralCourse(courseName); //Create a GeneralCourse object if course type is 1
                    } else if (courseType == 2) {
                        course = new InPersonCourse(courseName); //Create a InPersonCourse object if course type is 2
                    } else if (courseType == 3) { //Create a LabCourse object if course type is 3
                        course = new LabCourse(courseName, 30); //Set the lab capacity of 30
                    } else {
                        System.out.println("Invalid courseType");
                    }

                    if (course != null) {
                        university.addCourse(course); //Add the course to the university if valid
                    }
                    break;

                case 4: //Enroll a Student in a Course
                    System.out.print("Enter Student ID: ");
                    studentID = input.nextLine();
                    System.out.print("Enter Course Name: ");
                    courseName = input.nextLine();

                    student = university.findStudentByID(studentID); //Find the student by ID
                    course = university.findCourseByName(courseName); //Find the course by name

                    //Check if both the stuednt and course are found
                    if (student != null && course != null) {
                        try {
                            university.enrollStudentInCourse(student, course); //Enroll the student in the course
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage()); //Handle the exception and print the message
                        }
                    } else {
                        System.out.println("Student or Course not found.\n");
                    }
                    break;

                case 5: //Assign a professor to a course
                    System.out.print("Enter Professor ID: ");
                    professorID = input.nextLine();
                    System.out.print("Enter Course Name: ");
                    courseName = input.nextLine();

                    professor = university.findProfessorByID(professorID); //Find the professor by ID
                    course = university.findCourseByName(courseName); //Find the course by name

                    if (professor != null && course != null) {
                        try {
                            professor.addCourse(course); //Add the course to the professor's list of courseTaught and associate the course with the professor
                            university.assignProfessorToCourse(professor, course); //Aassign the professor to the course and record the association
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage()); //Handle the exception and print the message
                        }
                    } else {
                        System.out.println("Professor or Course not found.\n");
                    }

                    break;

                case 6: //Assign grades
                    System.out.print("Enter Professor ID: ");
                    professorID = input.nextLine();
                    System.out.print("Enter Course Name: ");
                    courseName = input.nextLine();
                    System.out.print("Enter Student ID: ");
                    studentID = input.nextLine();

                    student = university.findStudentByID(studentID); //Find the student by ID

                    if (student != null) {
                        System.out.print("Enter Grade for Student '" + student.getName() + "': "); //Prompt for grade
                        String grade = input.nextLine();

                        professor = university.findProfessorByID(professorID); //Find the professor by ID
                        course = university.findCourseByName(courseName); //Find the course by name

                        if (professor != null && course != null) {
                            professor.assignGrade(course, student, grade); //Assign the grade if professor and course are valid
                        }
                    } else {
                        System.out.println("Student not found. Please check the student ID.\n"); //Error if student not found
                    }
                    break;

                case 7: //View all courses
                    university.printAllCourses(); //Print details of all courses in the university
                    break;

                case 8: //View all students
                    System.out.println("--- All Students ---"); //Header for student list
                    for (Student s : university.getStudents()) { //Loop through each student
                        System.out.println("Student Name: " + s.getName() + ", ID: " + s.getID());
                    }
                    System.out.println();
                    break;

                case 9: //Exit the system
                    System.out.println("Exiting University Management System...");
                    System.out.println("Goodbye!");
                    System.exit(0); //Exit the program
                    break;

                default: //Handle invalid choices
                    System.out.println("Invalid choice, please try again.\n"); //Print error for invalid menu option                   

            }
        }
    }
}
