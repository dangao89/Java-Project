package LeaderboardManagementSystem;

/**
 * Class to define a custom comparator for sorting contestants by the number of
 * contests they participated in descending order.
 */
import java.util.Comparator;

public class SortByContestsParticipated implements Comparator<Contestant> {

    //Overriding the compare method to define sorting logic
    @Override
    public int compare(Contestant c1, Contestant c2) {

        //Retrieve the number of contests participated and store result in variables of int double
        int contestsParticipated1 = c1.getContestsParticipated();
        int contestsParticipated2 = c2.getContestsParticipated();

        //Compare the number of contests participated by two contestants to sort in descending order
        if (contestsParticipated1 > contestsParticipated2) {
            return -1; //Return -1 if the first contestant has participated in more contests (to place c1 before c2)
        } else if (contestsParticipated1 == contestsParticipated2) {
            return 0; //Return 0 if the number of contests is equal (no change in order)
        } else {
            return 1; //Return 1 if the second contestant has paticipated in more contests (to place c2 before c1)
        }
    }
}
