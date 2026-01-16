package graph;

/**
 * Implements Dijkstra's algorithm to compute the shortest paths from a source
 * node to all other nodes in a weighted graph.
 */
import java.util.*;

public class Dijkstra {

    public static Map<String, Integer> computeShortestPaths(Graph g, String src) {
        Map<String, Integer> shortestPaths = new HashMap<>(); // Stores shortest distances from source
        Map<String, String> previousNodes = new HashMap<>(); // Stores previous node for path reconstruction
        Set<String> visitedNodes = new HashSet<>(); // Keeps track of visited nodes

        // Inotialize distances: source gets 0, all other nodes get max value.
        for (String node : g.getNodes()) {
            shortestPaths.put(node, Integer.MAX_VALUE);
        }
        shortestPaths.put(src, 0);

        // Create a comparator that compares two nodes based on their shortest path distances
        Comparator<String> nodeComparator = new Comparator<String>() {
            @Override
            public int compare(String node1, String node2) {
                Integer distance1 = shortestPaths.get(node1);
                Integer distance2 = shortestPaths.get(node2);
                return Integer.compare(distance1, distance2);
            }
        };

        // Create a PriorityQueue of Strings (nodes) using the custom comparator
        PriorityQueue<String> pq = new PriorityQueue<>(nodeComparator);

        pq.add(src); // Start from the source

        // Process nodes until the queue is empty
        while (!pq.isEmpty()) {
            String currentNode = pq.poll(); // Get node with smallest distance
            if (visitedNodes.contains(currentNode)) {
                continue; // Skip if already visited
            }
            visitedNodes.add(currentNode); // Mark as visited

            // Explore neighbors
            for (Edge edge : g.getAdjacencyList().get(currentNode)) {
                String neighborNode = edge.getDest(); // Neighbor node
                int weight = edge.getWeight();  // Edge weight
                int newPaths = shortestPaths.get(currentNode) + weight; // New possible shorter path
                if (newPaths < shortestPaths.get(neighborNode)) {
                    shortestPaths.put(neighborNode, newPaths); // Update with new shorter distance
                    previousNodes.put(neighborNode, currentNode); // Store path
                    pq.add(neighborNode); // Add to queue for further processing
                }
            }
        }
        return shortestPaths; // Return the map of shortest paths
    }
}
