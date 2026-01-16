package graph;

/**
 * Main class to demonstrate Dijkstra and kruskal algorithms on a sample graph.
 * Date: 05/03/2025 
 */
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Graph g = new Graph(); // Create a graph
        // Add all edges to the graph
        g.addEdge("A", "B", 3);
        g.addEdge("A", "C", 5);
        g.addEdge("A", "D", 9);
        g.addEdge("B", "C", 3);
        g.addEdge("B", "D", 4);
        g.addEdge("B", "E", 7);
        g.addEdge("C", "D", 2);
        g.addEdge("C", "E", 6);
        g.addEdge("D", "E", 2);
        g.addEdge("D", "F", 2);
        g.addEdge("E", "F", 5);
        g.addEdge("C", "F", 8);

        System.out.println("Shortest distances from A:");
        // Call Dijkstra's algorithm on graph 'g' starting from node "A".
        Map<String, Integer> shortestPaths = Dijkstra.computeShortestPaths(g, "A");
        // Iterate over all nodes in the graph
        for (String node : g.getNodes()) {
            // Print the shortest distance from node A to the current node
            System.out.println("A -> " + node + " = " + shortestPaths.get(node));
        }
        System.out.println();

        System.out.println("Minimum Spanning Tree:");
        // Call Kruskal's algorithm on the graph g to find the MST
        List<Edge> mst = Kruskal.findMST(g);
        // Initialize the total weight to 0
        int totalWeight = 0;
        // Loop through each edge in the MST
        for (Edge edge : mst) {
            System.out.println("Edge: " + edge.toString());
            totalWeight += edge.getWeight(); // Add the edge's weight to total
        }
        System.out.println("Total weight: " + totalWeight);
    }
}
