package LeaderboardManagementSystem;

/**
 * This class manages a leader board of contestants, providing functionalities
 * to add contestants, display their details, and sort them based on various
 * criteria such as total score, average score, or username.
 */
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LeaderboardManager {

    //Private attribute to store the list of contestants
    private List<Contestant> contestants;

    //Constructor to initialize the list of contestants
    public LeaderboardManager() {
        //Initialize the contestants list as an ArrayList
        this.contestants = new ArrayList<>();
    }

    //Adds a new contestant to the leaderboard
    public void addContestant(Contestant c) {
        //validate input: Check if the contestant object is null
        if (c == null) {
            //Print error message if contestant is null and terminate the method
            System.out.println("Error: Contestant cannot be null.");
            return;
        }

        //Flag to check if the username already exists
        boolean nameExists = false;
        //Iterate through the list of contestants
        for (Contestant contestant : contestants) {
            if (contestant.getUsername().equalsIgnoreCase(c.getUsername())) {
                nameExists = true; //Set flag if a match is found
                break; //Exit loop as match is found
            }
        }

        //If the username already exists, print an error message.
        if (nameExists) {
            System.out.println("Username already exists");
        } else {
            //Only add the contestant if the username is unique
            contestants.add(c);
            System.out.println("\"Contestant added successfully.\"");
        }
    }

    //Displays all contestants in the leaderboard
    public void displayContestants() {
        //Iterate through the list of contestants using forEach with a lambda expression
        //Call getDetail() method to print each contestant's details
        contestants.forEach(contestant -> System.out.println(contestant.getDetails()));
    }

    //Sorts the list of contestants using a given comparator
    public void sortByComparator(Comparator<Contestant> comp) {
        //Sort the contestants list using the provided comparator
        Collections.sort(contestants, comp);

        //Display the sorted list of contestants
        displayContestants();
    }

    //Sorts contestants by total score in descending order using QuickSort.
    public void sortByTotalScoreWithQuickSort() {

        //Creates an array of Contestant object
        //The size of the array matches the size of the contestants list
        Contestant[] array = new Contestant[contestants.size()];

        //Convert the contestants list to an array 
        contestants.toArray(array);

        //Use QuickSort to sort the array by total score
        SortByTotalScore.quickSort(array, 0, array.length - 1);

        //Convert the sorted array back to a list and update the contestants list
        contestants = new ArrayList<>(Arrays.asList(array));

        //Display the sorted list of contestants
        displayContestants();
    }

    //Sorts contestants by average score in descending order 
    //Breaks ties alphabetically by username using comparator chaining.
    public void sortByMultipleCriteria() {

        //Sort contestants using a lambda expression with comparator chaining
        Collections.sort(contestants, (c1, c2) -> {
            
            //First compare by average score using SortByAverageScore comparator
            int scoreComparison = new SortByAverageScore().compare(c1, c2);
            
            //If scores are different, return the comparision result
            if (scoreComparison != 0) {
                return scoreComparison;
            } else {
                //If scores are equal, compare by username alphabetically
                return new SortByUsername().compare(c1, c2);
            }
        });

        //Display the sorted list of contestants
        displayContestants();

    }
}
