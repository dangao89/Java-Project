package socialgraph;

/**
 * The Main class serves as the entry point for the SocialGraph application. It
 * allows users to interact with the social graph, find friends at a specific
 * distance, determine the shortest path between two users, and analyze graph
 * properties. 
 * Date: 04/15/2025 
 */
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Create a new SocialGraph object
        SocialGraph socialGraph = new SocialGraph();

        try { // Load the graph data from the file 
            socialGraph.loadFromFile("social network.txt");
            System.out.println("Total unique users " + socialGraph.getTotalUsers());
        } catch (IOException e) { // Catch the file error
            System.out.println("Error loading file: " + e.getMessage());
            return;
        }

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter user name: "); // Prompt for user name
        // Read the name, trim whitespace, and convert to lowercase
        String name = scanner.nextLine().trim().toLowerCase();
        if (name.isEmpty()) {
            System.out.println("Error: Name cannot be empty.");
            return;
        }

        System.out.print("Enter distance: "); // Prompt for distance
        int distance = scanner.nextInt();
        scanner.nextLine(); // Cosume leftover newline
        if (distance < 0) { // Print message if distance is negative
            System.out.println("Distance cannot be negative.");
            return;
        }
        // Get the friends at the specified distance
        List<String> friendsAtDistance = socialGraph.getFriendsAtDistance(name, distance);
        if (friendsAtDistance == null) { // If the user is not found, stop
            return;
        }
        // Print the friends at the specified distance
        System.out.println("\nFriends at distance " + distance + ":");

        // If there are no friends at the specified distance, print "None"
        if (friendsAtDistance.isEmpty()) {
            System.out.println(" None");
        } else {
            for (String friend : friendsAtDistance) { // Otherwise, iterate through the friends
                System.out.println(" - " + friend);
            }
        }

        // Ask if they want to find a short path
        System.out.print("\nWould you like to find the shortest path to another user? (yes/no): ");
        // Read the response, trim whitespace, and convert to lowercase
        String response = scanner.nextLine().trim().toLowerCase();

        // If the response is yes, ask for the target user's name
        if (response.equals("yes")) {
            System.out.print("Enter target user name: ");
            String target = scanner.nextLine().trim().toLowerCase();

            // Find the shortest path
            List<String> path = socialGraph.shortestPath(name, target);

            // If there is no path,print message
            if (path.isEmpty()) {
                System.out.println("No path exists between " + name + " and " + target + ".");
            } else {
                // Otherwise, print the path
                System.out.println("Shortest path from " + name + " to " + target + ": ");
                for (int i = 0; i < path.size(); i++) { // Iterate through the path        
                    System.out.print(path.get(i));
                    if (i != path.size() - 1) {  //If it's not the final, print an arrow
                        System.out.print(" -> ");
                    }
                }
                System.out.println();
            }
        }
        // Print graph analysis, graph connection, friends groups
        System.out.println("\nGraph analysis:");
        System.out.println("Is the graph connected? " + socialGraph.isGraphConnected());
        System.out.println("Number of friend groups: " + socialGraph.countFriendGroups());

        // Call the method to get a list of users with the most connections
        List<String> mostConnectedUsers = socialGraph.getMostConnectedUser();
        // Print the number of connections from the first user in the list
        System.out.println("User with the most connections (" + mostConnectedUsers.get(0).split("\\(")[1] + ":");
        // Loop through each user in the list and print their name 
        for (String user : mostConnectedUsers) {
            System.out.println("-" + user.split("\\(")[0].trim());
        }
    }
}
