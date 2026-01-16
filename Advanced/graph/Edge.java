package graph;

/**
 * Represents a weighted edge in a graph.
 */
public class Edge implements Comparable<Edge> {

    private String src; // Source node
    private String dest; // Destination node
    private int weight;  // Weight of the edge

    // Constructs an edge between two nodes with a given weight
    public Edge(String src, String dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    // Return source node
    public String getSrc() {
        return src;
    }

    // Return destination node
    public String getDest() {
        return dest;
    }

    // Return edge weight
    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge other) { // Compare edge by weight
        return Integer.compare(this.weight, other.weight);
    }

    @Override
    public String toString() { // String representation of edge
        return src + " - " + dest + " (" + weight + ")";
    }
}
