package LeaderboardManagementSystem;

/**
 * Class to sort Contestant object by username alphabetically in case-insensitive manner
 */
import java.util.Comparator;

public class SortByUsername implements Comparator<Contestant> {

    //Overriding the compare method to define sorting logic
    @Override
    public int compare(Contestant c1, Contestant c2) {
        //Comparing username of two Contestant objects ignoring case sensitivity
        return c1.getUsername().compareToIgnoreCase(c2.getUsername());
    }
}
