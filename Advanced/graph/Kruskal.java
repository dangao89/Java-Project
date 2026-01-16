package graph;

/**
 * This class provides a method to compute the minimum spanning tree using
 * Kruskal's algorithm.
 */
import java.util.*;

public class Kruskal {

    /**
     * Finds the minimum spanning tree (MST) of a graph.
     *
     * @param g the graph
     * @return a list of edges that form the MST
     */
    public static List<Edge> findMST(Graph g) {
        List<Edge> mstEdges = new ArrayList<>(); // Store MST edges
        int totalWeight = 0; // Initialize the total weight
        List<Edge> edges = new ArrayList<>(g.getEdges()); // All edges
        Collections.sort(edges); // Sort edges by weight 
        UnionFind uf = new UnionFind(g.getNodes()); // Union-Find structure for cycle detection

        // Iterate over all edges, sorted by weight
        for (Edge edge : edges) {
            // Connect two nodes of the edge using Union-Find
            if (uf.union(edge.getSrc(), edge.getDest())) {
                // Add the edge to the MST since it doesn't form a cycle
                mstEdges.add(edge);
                // Add the edge's weight to the total MST weight
                totalWeight += edge.getWeight();
                if (mstEdges.size() == g.getNodes().size() - 1) {
                    break; // Early exit if MST complete
                }
            }
        }
        return mstEdges; // Return list of MST edges
    }
}
