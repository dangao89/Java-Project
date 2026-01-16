package LeaderboardManagementSystem;

/**
 * The Contestant class represents contestant in a leader-board system,
 * containing details such as username, total score, number of contests
 * participated, and average score.
 */
public class Contestant {

    //Private instance variables to store contestant details
    private String username;
    private int totalScore;
    private int contestsParticipated;
    private double averageScore;

    //Constructor to initialize a Contestand object
    public Contestant(String username, int totalScore, int contestsParticipated)
            throws InvalidScoreException, InvalidContestParticipationException {
        //Check if a contestant's total score is valid
        if (totalScore < 0) {
            //Thrown an exception if the total score is negative
            throw new InvalidScoreException("Contestant's total score cannot be negative.");
        }
        //Check if the number of contests participated is valid
        if (contestsParticipated <= 0) {
            //Thrown an exception if the number of contests participated is zero or negative
            throw new InvalidContestParticipationException("The number of contests participated must be positive.");
        }
        
        //Initialize instance variables
        this.username = username;
        this.totalScore = totalScore;
        this.contestsParticipated = contestsParticipated;
        
        //Calculate the average score
        this.averageScore = (double) totalScore / contestsParticipated;
    }

    //Getter method to retrieve the username of the contestant
    public String getUsername() {
        return username;
    }

    //Getter method to retrieve the total score of the contestant
    public int getTotalScore() {
        return totalScore;
    }

    //Getter method to retrieve the number of the contests participated
    public int getContestsParticipated() {
        return contestsParticipated;
    }

    //Getter method to retrieve the average score of the contestant
    public double getAverageScore() {
        return averageScore;
    }

    //Display contestant details in a formatted string
    public String getDetails() {
        return String.format("Username: %s, Total Score: %d, Contests: %d, Avg Score: %.2f",
                username, totalScore, contestsParticipated, averageScore);
    }
}
