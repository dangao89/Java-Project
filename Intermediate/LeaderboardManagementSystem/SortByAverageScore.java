package LeaderboardManagementSystem;

/**
 * Class to define a custom comparator for sorting contestants by their average
 * score in descending order.
 */
import java.util.Comparator;

public class SortByAverageScore implements Comparator<Contestant> {

    //Overriding the compare method to define sorting logic
    @Override
    public int compare(Contestant c1, Contestant c2) {

        //Retrieve the average score of the contestants and store result in variables of type double
        double averageScore1 = c1.getAverageScore();
        double averageScore2 = c2.getAverageScore();

        //Compare the two average scores to sort in descending order
        if (averageScore1 > averageScore2) {
            return -1; //Return -1 if the first contestant has a higher score (to place c1 before c2)
        } else if (averageScore1 == averageScore2) {
            return 0; //Return 0 if the scores are equal (no change in order)
        } else {
            return 1; //Return 1 if the second contestant has a higher score (to place c2 before c1)
        }
    }
}
