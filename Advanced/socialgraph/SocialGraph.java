package socialgraph;

/**
 * The class represents a social network graph where users are vertices and
 * friendships are edges. It perform graph traversals, and analyze network
 * properties such as connectivity and friend groups.
 */
import java.io.*;
import java.util.*;

public class SocialGraph {

    private Map<String, List<String>> adjacencyList; // Adjacency list to store the graph

    // Constructor
    public SocialGraph() {
        adjacencyList = new HashMap<>(); // Initializes the adjacency list.
    }

    /**
     * Adds a vertex (user) to the graph. If the vertex already exists, this
     * method does nothing.
     *
     * @param name The name of the user to add.
     */
    public void addVertex(String name) {
        adjacencyList.putIfAbsent(name.toLowerCase(), new ArrayList<>());
    }

    /**
     * Add an undirected edge (friendship) between two users in the graph. If
     * either user does not exist, it is added to the graph. Self-loops are
     * ignored.
     *
     * @param name1 The name of the first user. Case-insensitive.
     * @param name2 The name of the second user. Case-insensitive.
     */
    public void addEdge(String name1, String name2) {
        name1 = name1.toLowerCase();
        name2 = name2.toLowerCase();

        if (name1.equals(name2)) { // No self-loop
            return;
        }
        // Add name as a vertex
        addVertex(name1);
        addVertex(name2);

        if (!adjacencyList.get(name1).contains(name2)) {
            adjacencyList.get(name1).add(name2); // Add name2 to name1's adjacency list
        }
        if (!adjacencyList.get(name2).contains(name1)) {
            adjacencyList.get(name2).add(name1); // Add name1 to name2's adjacency list
        }
    }

    /**
     * Loads graph data from a file where each line represents a friendship
     * (edge) between two users.
     *
     * @param filename
     * @throws IOException If an error occurs while reading the file.
     */
    public void loadFromFile(String filename) throws IOException {
        // Use BufferedReader to read the file line by line
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String currentLine; // Variable to store each line
            while ((currentLine = reader.readLine()) != null) {  // Read a line from the file until end
                currentLine = currentLine.trim(); // Remove whitespace
                if (currentLine.isEmpty()) {
                    continue; // Skip empty lines
                }
                String[] names = currentLine.split(","); // Split the line by comma 
                if (names.length != 2) { // If the line doesn't contain exactly two names, skip it
                    continue;
                }
                // Trim whitespace from name
                String firstName = names[0].trim().toLowerCase();
                String secondName = names[1].trim().toLowerCase();

                addEdge(firstName, secondName); // Add an edge between firstName and secondName
            }
        }
    }

    /**
     * Returns the total number of users in the social graph.
     *
     * @return the number of users, based on the size of the adjacency list
     */
    public int getTotalUsers() {
        return adjacencyList.size();
    }

    /**
     * Performs a Breadth-First Search (BFS) from the source user to determine
     * the levels of other users in the graph, where level is the distance from
     * the source.
     *
     * @param source The name of the starting user for BFS. Case-insensitive.
     * @return A map where keys are the levels (distances) from the source user,
     * and values are lists of users at that level.
     */
    public Map<Integer, List<String>> bfsLevels(String source) {
        Map<Integer, List<String>> userAtLevels = new HashMap<>(); // Create a map to store users at each level
        Map<String, Integer> userDistancesFromSource = new HashMap<>(); //Use a map to track users and their distances
        Queue<String> queue = new LinkedList<>(); // Create a queue for BFS

        queue.offer(source); // Add the source to the queue
        userDistancesFromSource.put(source, 0); // Distance of source from itself is 0

        while (!queue.isEmpty()) {
            String currentUser = queue.poll(); // Get the next user from the queue
            int currentDistance = userDistancesFromSource.get(currentUser); //Get the distance to the user

            // If the level doesn't exist, add it to the levels map
            userAtLevels.putIfAbsent(currentDistance, new ArrayList<>());
            // Add the user to the list of users at that level
            userAtLevels.get(currentDistance).add(currentUser);

            for (String friend : adjacencyList.get(currentUser)) {  // Iterate through the friends of the current user
                if (!userDistancesFromSource.containsKey(friend)) { // If the friend has not been visited
                    userDistancesFromSource.put(friend, currentDistance + 1); //Put the friend and distance to the map
                    queue.offer(friend); // Add the friend to the queue
                }
            }
        }
        return userAtLevels; // Return the levels map
    }

    /**
     * Gets a list of friends at a specified distance from a given user.
     *
     * @param source The name of the starting user. Case-insensitive.
     * @param k The distance from the source user. Must be non-negative.
     * @return A list of users who are exactly 'distance' hops away from the
     * source user. Returns null if the source user does not exist. Returns an
     * empty list if the distance is negative.
     */
    public List<String> getFriendsAtDistance(String source, int k) {
        // If the source does not exist, return null
        if (!adjacencyList.containsKey(source)) {
            System.out.println("User not found: " + source);
            return null;
        }

        //If the distance k is negative, return empty list
        if (k < 0) {
            System.out.println("Distance cannot be negative.");
            return new ArrayList<>();
        }

        // Get the levels from BFS
        Map<Integer, List<String>> levels = bfsLevels(source);
        //Get user at specific level
        List<String> friendsAtDistanceK = levels.get(k);
        if (friendsAtDistanceK == null) { // If there are no friends, return empty list
            return new ArrayList<>();
        } else {
            return friendsAtDistanceK;
        }
    }

    /**
     * Finds the shortest path between two users in the graph using BFS.
     *
     * @param source The name of the starting user.
     * @param target The name of the destination user.
     * @return A list of user names representing the shortest path from the
     * source to the target user. Returns an empty list if no path exists or if
     * the user does not exist.
     */
    public List<String> shortestPath(String source, String target) {
        // If the lowercase target doesn't exist, Return a new list
        if (!adjacencyList.containsKey(source) || !adjacencyList.containsKey(target)) {
            System.out.println("User not found: " + (!adjacencyList.containsKey(source) ? source : target));
            return new ArrayList<>();
        }

        //Keep track of each node's parent
        Map<String, String> parentMap = new HashMap<>(); //Keep track of each node's parent
        Queue<String> queue = new LinkedList<>(); // Create a queue for BFS
        Set<String> visitedUsers = new HashSet<>(); // Create a visited set

        queue.offer(source); // Add the source to the queue
        visitedUsers.add(source); //Mark source to visited

        while (!queue.isEmpty()) { // Loop until the queue is empty
            String currentUser = queue.poll(); // Get the next user from the queue

            // Loop through all friend from adjacencyList
            for (String friend : adjacencyList.get(currentUser)) {
                if (!visitedUsers.contains(friend)) { //if friend hasn't been visited
                    visitedUsers.add(friend); //Add friend to visited
                    queue.offer(friend); //Add friend to queue
                    parentMap.put(friend, currentUser); //Put friend and user to the map
                }
            }
        }

        //If the parent doesn't contain the target, return a new list
        if (!parentMap.containsKey(target)) {
            return new ArrayList<>();
        }

        //Create a linkedList to store shortest path
        List<String> shortestPath = new LinkedList<>();
        //Create a string variable to point to target node
        String current = target;
        while (current != null) { // loop until current is not null (has no parent)
            shortestPath.addFirst(current); // Add current node at the begining of the path list
            current = parentMap.get(current); // Move to the parent of the current node for the next iteration
        }
        return shortestPath;
    }

    /**
     * Checks if the graph is connected, meaning there is a path from any vertex
     * to any other vertex. This method performs a BFS starting from an
     * arbitrary vertex and checks if all vertices are visited.
     *
     * @return true if graph is connected, otherwise, return false.
     */
    public boolean isGraphConnected() {
        if (adjacencyList.isEmpty()) {
            System.out.println("The graph is empty.");
            return true; // If the graph is empty, return true
        }

        Set<String> allNodes = adjacencyList.keySet(); // Get all nodes in the graph as a set
        Iterator<String> nodeIterator = allNodes.iterator(); // Get iterator for the set
        String startNode = nodeIterator.next(); // Get first node to use as BFS starting point

        Set<String> visitedNodes = new HashSet<>(); // Tracks visited nodes
        Queue<String> queue = new LinkedList<>(); // Queue for BFS

        queue.add(startNode); // Add the starting node to the queue
        visitedNodes.add(startNode); // Mark the starting node as visited

        while (!queue.isEmpty()) { // While there are nodes to visit
            String currentNode = queue.poll(); // Get the next node from the queue

            // Iterate through the friends of the current node
            for (String friend : adjacencyList.get(currentNode)) {
                if (!visitedNodes.contains(friend)) { // If the friend hasn't been visited
                    visitedNodes.add(friend); // Mark the friend as visited
                    queue.add(friend); // Add the friend to the queue
                }
            }
        }
        // Grapgh is connected if we visited all nodes
        return visitedNodes.size() == adjacencyList.size();
    }

    /**
     * Perform Depth-First Search(DFS) starting from a given vertex.
     *
     * @param start
     * @param visited
     */
    private void dfs(String currentUser, Set<String> visitedUsers) {
        visitedUsers.add(currentUser); // Mark the current nodes as visited
        // Iterate through the friends of the current nodes
        for (String friend : adjacencyList.get(currentUser)) {
            if (!visitedUsers.contains(friend)) { // If the friend hasn't been visited
                dfs(friend, visitedUsers); // Recursively call DFS on the friend
            }
        }
    }

    /**
     * Counts the number of connected components (friend groups) in the graph.
     * This method uses Depth-First Search (DFS) to traverse the graph and
     * identify disconnected components.
     *
     * @return The number of friend groups in the graph.
     */
    public int countFriendGroups() {
        // If the graph is empty, there are no friend groups
        if (adjacencyList.isEmpty()) {
            return 0;
        }

        // Keep track of visited nodes
        Set<String> visitedUsers = new HashSet<>();
        int groupCount = 0; // Initialize the group count to 0

        // Iterate through all the nodes in the graph
        for (String currentUser : adjacencyList.keySet()) {
            if (!visitedUsers.contains(currentUser)) { // If the node hasn't been visited
                groupCount++; // Increment the group count
                dfs(currentUser, visitedUsers); // Perform DFS starting from this node
            }
        }
        return groupCount; // Return the number of friend groups
    }

    /**
     * Finds the user with the most connections (friends) in the graph.
     *
     * @return The name of the user with the most connections, along with the
     * number of connections.
     */
    public List<String> getMostConnectedUser() {
        // List to store the users with the most connection
        List<String> mostConnectedUsers = new ArrayList<>();
        //Variable to store the maximum connection
        int maxConnections = 0;
        // Get all userNames(keys) from the adjacency list
        Set<String> userNames = adjacencyList.keySet();
        // Loop through each username
        for (String userName : userNames) {
            // Get the current user's friend list from the adjacency list
            List<String> friends = adjacencyList.get(userName);
            // Calculate the number of connections(friends)
            int connections = friends.size();
            //If connection is greater than maxConnection
            if (connections > maxConnections) { 
                maxConnections = connections; //Assign connection to maxConnection
                mostConnectedUsers.clear(); // Clear the previous list as we found a new max
                mostConnectedUsers.add(userName.toLowerCase()); // Add the current user as the new most connected
            } else if (connections == maxConnections) { // If this user has the same number of connections as the max
                // Add the user to the list of most connected users
                mostConnectedUsers.add(userName.toLowerCase());
            }
        }
        // Create a formatted result list to include connection count
        List<String> result = new ArrayList<>();
        // Loop through the list of most connected users
        for (String user : mostConnectedUsers) {
            // Add a formatted string to the result list showing the user's name and number of connections
            result.add(user + " (" + maxConnections + " connections)");
        }
        return result;
    }
}
