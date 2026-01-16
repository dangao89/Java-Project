package graph;

/**
 * Represents an undirected, weighted graph using an adjacency List.
 */
import java.util.*;

public class Graph {

    private Map<String, List<Edge>> adjacencyList = new HashMap<>(); // Node -> List of edges
    private Set<String> nodes = new HashSet<>();  // All unique node
    private List<Edge> edges = new ArrayList<>(); // List of all edges

    /**
     * Add a bidirectional edge to the graph.
     *
     * @param src source node
     * @param dest destination node
     * @param weight edge weight
     */
    public void addEdge(String src, String dest, int weight) {
        // Initialize if not already present
        adjacencyList.putIfAbsent(src, new ArrayList<>());
        adjacencyList.putIfAbsent(dest, new ArrayList<>());

        Edge forwardEdge = new Edge(src, dest, weight); // Forward edge
        adjacencyList.get(src).add(forwardEdge); // Add to adjacency list

        Edge backwardEdge = new Edge(dest, src, weight); // Reverse edge
        adjacencyList.get(dest).add(backwardEdge); // Add to adjacency list

        edges.add(forwardEdge); // Store only one direction in edges list
        nodes.add(src); // Add source and destination node
        nodes.add(dest);
    }

    // Return all edges
    public List<Edge> getEdges() {
        return edges;
    }

    // Return all nodes
    public Set<String> getNodes() {
        return nodes;
    }

    // Return full adjacency list
    public Map<String, List<Edge>> getAdjacencyList() {
        return adjacencyList;
    }

    // Check if node exists in the graph
    boolean isValidNode(String node) {
        return nodes.contains(node);
    }
}
