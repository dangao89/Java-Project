package graph;

/**
 * Union-Find (Disjoint Set) data structure for efficient cycle detection.
 */
import java.util.*;

public class UnionFind {

    // Stores the parent of each node
    private Map<String, String> parent = new HashMap<>();

    /**
     * Initialize the Union-Find structure with each node as its own parent
     *
     * @param nodes the set of graph nodes
     */
    public UnionFind(Set<String> nodes) {
        for (String node : nodes) {
            parent.put(node, node); // Each node starts in its own set
        }
    }

    /**
     * Find the root of a set that a node belongs to
     *
     * @param node the node to find
     * @return the root parent
     */
    public String find(String node) {
        // If the node is not its own parent, recursively find and update its parent
        if (!parent.get(node).equals(node)) {
            parent.put(node, find(parent.get(node)));
        }
        return parent.get(node); // Return root
    }

    /**
     * Unions two sets by connecting their roots
     *
     * @param node1 first node
     * @param node2 second node
     * @return true if union successful (no cycle)
     */
    public boolean union(String node1, String node2) {
        String root1 = find(node1); // Find root of first node
        String root2 = find(node2); // Find root of second node
        // If thwy have the same root, they're already connected
        if (root1.equals(root2)) {
            return false;
        }
        // Otherwise, merge the two sets by setting  root1's parent to root2
        parent.put(root1, root2);
        return true;
    }
}
