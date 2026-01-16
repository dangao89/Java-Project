package LeaderboardManagementSystem;

/** 
 * Date: 11/17/2024
 * Program Title: Leader board Management System 
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Program Title: Leaderboard Management System");
        System.out.println("Author: Dan Gao");
        System.out.println("Course: CSC 230, Sec 01");
        System.out.println("-------------------------");

        //Create a Scanner object to read user input from the console
        Scanner input = new Scanner(System.in);

        //Instantiate the LeaderboardManager
        LeaderboardManager manager = new LeaderboardManager();

        //Infinite loop for the main menu
        while (true) {
            System.out.println("Main Menu");
            System.out.println("1. Add Contestant");
            System.out.println("2. Display All Contestants");
            System.out.println("3. Sort by Username");
            System.out.println("4. Sort by Average Score");
            System.out.println("5. Sort by Number of Contests Participated");
            System.out.println("6. Sort by Total Score (QuickSort)");
            System.out.println("7. Sort by Multiple Criteria");
            System.out.println("8. Exit");
            System.out.print("Select an option: ");

            int option = input.nextInt(); //Read the user's menu option selection
            input.nextLine(); //Clear the input buffer after reading an int

            //Process the user's choice with a switch statement
            switch (option) {
                case 1: //Add a contestant
                    try {
                        //Prompt the user to enter the contestant's username
                        System.out.print("Enter Username: ");
                        String username = input.nextLine();

                        //Prompt the user to enter the contestant's total score
                        System.out.print("Enter Total Score: ");
                        int totalScore = input.nextInt();
                        input.nextLine();

                        //Prompt the user to enter the number of contests participated
                        System.out.print("Enter Number of Contests Participated: ");
                        int contestsParticipated = input.nextInt();
                        input.nextLine();

                        //Create a new Contestant object with the provided details
                        Contestant contestant = new Contestant(username, totalScore, contestsParticipated);

                        //Add the contestant to the leaderboard
                        manager.addContestant(contestant);

                        //Handle exceptions if the score or contests participated are invalid
                    } catch (InvalidScoreException | InvalidContestParticipationException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println();
                    break;

                case 2: //Display all contestants
                    //Call the method to display the list of all contestants
                    manager.displayContestants();
                    System.out.println();
                    break;

                case 3: //Sorted by Username
                    System.out.println("\"Sorted by Username.\"\n");

                    //Call the method sortByComparator()
                    //An instance of the SortByUsername comparator is passed to specify the sorting criterion
                    manager.sortByComparator(new SortByUsername());
                    System.out.println();
                    break;

                case 4: //Sorted by Average Score
                    System.out.println("\"Sorted by Average Score.\"\n");

                    //Call the method sortByComparator()
                    //An instance of the SortByAverageScore comparator is passed to specify the sorting criterion
                    manager.sortByComparator(new SortByAverageScore());
                    System.out.println();
                    break;

                case 5: //Sorted by Number of Contests Participated
                    System.out.println("\"Sorted by Number of Contests Participated.\"\n");

                    //Call the method sortByComparator()
                    //An instance of the SortByContestsParticipated comparator is passed to specify the sorting criterion
                    manager.sortByComparator(new SortByContestsParticipated());
                    System.out.println();
                    break;

                case 6: //Sorted by Total Score (QuickSort)  
                    System.out.println("\"Sorted by Total Score.\"\n");

                    //Call the method to sort the contestants by total score using the QuickSort algorithm
                    manager.sortByTotalScoreWithQuickSort();
                    System.out.println();
                    break;

                case 7: //Sorted by Multiple Criteria (Average Score and Username)
                    System.out.println("\"Sorted by Average Score and Username as a tie-breaker.\"\n");

                    //Call the method to sort the contestants by average score, breaking ties using their username
                    manager.sortByMultipleCriteria();
                    System.out.println();
                    break;

                case 8: //Exit the program
                    System.out.println("\"Exiting the program.\"");
                    System.exit(0); //Terminate the program
                    break;

                default: //Handle invalid option input
                    System.out.println("Invalid option, please try again.\n");
            }
        }
    }
}
