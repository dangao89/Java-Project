package FitnessTracker;

/**
 * Represent a user who logs physical activities.
 */
public class User {

    //Private attributes
    private String name;
    private Activity[] activities;
    private int activityCount;
    private int maxActivities;

    //Default constructor
    public User() {
        this.name = "Unknown";
        this.maxActivities = 10;
        this.activities = new Activity[maxActivities];
        this.activityCount = 0;
    }

    //Parameterized constructor
    public User(String name, int maxActivities) {
        this.name = name;
        this.maxActivities = maxActivities;
        this.activities = new Activity[maxActivities];
        this.activityCount = 0;
    }

    //Add an activity
    public void addActivity(String activityType, int duration) {

        //Check if the activity already exists
        for (int i = 0; i < activityCount; i++) {
            if (activities[i].getActivityType().equalsIgnoreCase(activityType)) {
                System.out.println("Activity already exists.");
                return;
            }
        }

        //Add the new activity if it does not already exist
        if (activityCount < maxActivities) {
            activities[activityCount] = new Activity(activityType, duration);
            activityCount++;
        } else {
            System.out.println("Maximum activity count reached.");
        }
    }

    //Print activities without calculating the total calories
    public String showActivities() {
        String activitiesDetail = "";
        for (int i = 0; i < activityCount; i++) {
            System.out.println((i + 1) + ". " + activities[i].getActivityDetails());
        }
        return activitiesDetail;
    }

    //Method to get total calories burned by the user
    public int getTotalCaloriesBurned() {
        int totalCaloriesBurned = 0;
        for (int i = 0; i < activityCount; i++) {
            totalCaloriesBurned += activities[i].getCaloriesBurned();
        }
        return totalCaloriesBurned;
    }

    //Get a summary of all activities and total calories performed by the user
    public String getActivitySummary() {
        String activitySummary = "";
        System.out.println("Summary for " + (name.isEmpty() ? "Unknown" : name));
        if (activityCount > 0) {
            activitySummary += showActivities();
            activitySummary += "Total Calories Burned: " + getTotalCaloriesBurned() + "\n";
        } else {
            activitySummary = "No activities logged.\n";
        }
        return activitySummary;
    }

    //Getter for name
    public String getName() {
        return name;
    }

    //Setter for name
    public void setName(String name) {
        this.name = name;
    }

    //Getter for activityCount
    public int getActivityCount() {
        return activityCount;
    }

    //Setter for activityCount
    public void setActivityCount(int activityCount) {
        this.activityCount = activityCount;
    }

    //Getter for maxActivities
    public int getMaxActivities() {
        return maxActivities;
    }

    //Setter for maxActivities
    public void setMaxActivities(int maxActivities) {
        this.maxActivities = maxActivities;
    }
}
