package FitnessTracker;

/**
 * Represent a physical activity with its details. Calculates calories burned
 * based on activity type and duration.
 */
public class Activity {

    //Private attributes
    private String activityType;
    private int duration;
    private int caloriesBurned;

    //Array of valid activities
    private static String[] validActivities = {"Running", "Cycling", "Swimming", "Weight Lifting",
        "Yoga", "Stair Step Machine", "Rowing", "Calisthenics", "Walking", "Pilates"};

    //Default constructor
    public Activity() {
        this.activityType = "";
        this.duration = 0;
        this.caloriesBurned = 0;
    }

    //Parameterized constructor
    public Activity(String activityType, int duration) {
        this.activityType = activityType;
        this.duration = duration;
        this.caloriesBurned = calculateCalories();
    }

    //Getter for activityType
    public String getActivityType() {
        return activityType;
    }

    //Setter for activityType
    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    //Getter for duration
    public int getDuration() {
        return duration;
    }

    //Setter for duration
    public void setDuration(int duration) {
        this.duration = duration;
    }

    //Getter for caloriesBurned
    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    //Calculate calories based on activity type and duration
    private int calculateCalories() {
        switch (activityType.toLowerCase()) {
            case "running":
                caloriesBurned = duration * 10;
                break;
            case "cycling":
                caloriesBurned = duration * 9;
                break;
            case "swimming":
                caloriesBurned = duration * 8;
                break;
            case "weight lifting":
                caloriesBurned = duration * 6;
                break;
            case "yoga":
                caloriesBurned = duration * 4;
                break;
            case "stair step machine":
                caloriesBurned = duration * 7;
                break;
            case "rowing":
                caloriesBurned = duration * 8;
                break;
            case "calisthenics":
                caloriesBurned = duration * 8;
                break;
            case "walking":
                caloriesBurned = duration * 4;
                break;
            case "pilates":
                caloriesBurned = duration * 6;
                break;
            default:
                caloriesBurned = 0;
                break;
        }
        return caloriesBurned;
    }

    //Check if an activity is valid
    public static boolean isValidActivity(String activityName) {
        for (int i = 0; i < validActivities.length; i++) {
            if (validActivities[i].equalsIgnoreCase(activityName)) {
                return true;
            }
        }
        return false;
    }

    //Get a string representation of the activity details
    public String getActivityDetails() {
        return "Activity: " + activityType + ", Duration: "
                + duration + " minutes, Calories Burned: " + caloriesBurned;
    }
}
