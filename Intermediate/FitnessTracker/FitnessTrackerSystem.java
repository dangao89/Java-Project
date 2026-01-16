package FitnessTracker;

/**
 * Date: 09/15/2024
 * Program Title: Fitness Tracker System 
 */
import java.util.Scanner;

public class FitnessTrackerSystem {

    public static void main(String[] args) {
        System.out.println("Program Title: Fitness Tracker System");
        System.out.println("Author: <Dan Gao>");
        System.out.println("Course: CSC230, Sec 01");
        System.out.println("---------------------------------");

        Scanner in = new Scanner(System.in);
        int maxUsers = 20; //Max number of users 

        //Create the array of User objects and initialize user count
        User[] users = new User[maxUsers];
        int userCount = 0;

        //Step1, add users to the array
        for (int i = 0; i < maxUsers; i++) {
            System.out.print("Type a name (or type 'done' to finish): ");
            String name = in.nextLine();

            //check if the user wants to stop adding the users
            if (name.equalsIgnoreCase("done")) {
                break;
            }

            //Add the user with the name and max activities
            boolean userExists = false;
            for (int j = 0; j < userCount; j++) {
                if (users[j].getName().equalsIgnoreCase(name)) {
                    System.out.println("User already exists.");
                    userExists = true;
                    break;
                }
            }

            if (!userExists && userCount < maxUsers) {
                users[userCount] = new User(name, 5); //Max 5 activities for each user
                userCount++;
            }
        }

        //Step2, show users
        System.out.println("\nThe users are: ");
        if (userCount == 0) {
            System.out.println("No users available.");
        } else {
            for (int i = 0; i < userCount; i++) {
                System.out.println(users[i].getName());
            }
            System.out.println();
        }

        //Step3, log activities for each user
        for (int i = 0; i < userCount; i++) {
            String userName = users[i].getName();

            //Allow up to 5 activities per user or until 'done' is typed
            for (int j = 0; j < 5; j++) {
                System.out.println("Log an activity for " + userName + ".");
                System.out.print("Type activity name (or type 'done' to stop adding activities): ");
                String activityName = in.nextLine();

                //Check if the user wants to stop adding activities
                if (activityName.equalsIgnoreCase("done")) {
                    break;
                }

                //Validate the activityType
                if (!Activity.isValidActivity(activityName)) {
                    System.out.println("Invalid activity. Please try again.");
                    continue;
                }

                //Ask for activity duration
                System.out.print("Type activity duration (in minutes): ");
                int durationTime = in.nextInt();
                in.nextLine();

                //Validate duration
                while (durationTime <= 0) {
                    System.out.println("Invalid duration. Please enter a positive number.");
                    System.out.print("Type activity duration (in minutes): ");
                    durationTime = in.nextInt();
                    in.nextLine();
                }

                //Add activity to the user
                users[i].addActivity(activityName, durationTime);
                System.out.println();
            }

            //Display activities for the user           
            if (users[i].getActivityCount() == 1) {
                System.out.println("\nThe activity for " + users[i].getName() + " is: ");
            } else {
                System.out.println("\nThe activities for " + users[i].getName() + " are: ");
            }
            users[i].showActivities();
            System.out.println();
        }

        //Step4, display activity summary for all users
        for (int i = 0; i < userCount; i++) {
            System.out.println(users[i].getActivitySummary());
        }
    }
}
