package binarysearchtree;

/**
 * This class implements the Binary Search Tree (BST) for storing and managing
 * Person objects.
 */
import java.util.Stack;

public class BinarySearchTree {

    private Node root; // Reference to the root of the BST

    // Inserts a new Person into the BST
    public void insert(Person person) {
        root = recursiveInsert(root, person); // Start insertion from the root
    }

    // Helper method for inserting a Person recursively
    private Node recursiveInsert(Node root, Person person) {
        if (root == null) { // If the current node is null, insert the new person here
            return new Node(person);
        } else if (person.compareTo(root.getPerson()) < 0) { // If person is smaller, go left
            root.setLeft(recursiveInsert(root.getLeft(), person));
        } else if (person.compareTo(root.getPerson()) > 0) { // If person is larger, go right
            root.setRight(recursiveInsert(root.getRight(), person));
        }
        return root;

    }

    // Search for a contact by name
    public Person search(String name) {
        return recursiveSearch(root, name); // Start searching from the root
    }

    // Helper method for searching a Person recursively
    private Person recursiveSearch(Node root, String name) {
        if (root == null || root.getPerson().getName().equalsIgnoreCase(name)) {
            return (root != null) ? root.getPerson() : null; // Return the found person or null
        } else if (name.compareToIgnoreCase(root.getPerson().getName()) < 0) { // Search left subtree
            return recursiveSearch(root.getLeft(), name);
        } else { // Search right subtree
            return recursiveSearch(root.getRight(), name);
        }
    }

    // Displays contacts in sorted order using inorder traversal
    public void inorderTraversal() {
        Stack<Node> stack = new Stack<>();  // Stack for iterative traversal
        Node current = root;  // Start from the root

        while (current != null || !stack.isEmpty()) { // Loop until all nodes are processed
            while (current != null) { // Traverse to the leftmost node
                stack.push(current);
                current = current.getLeft();
            }
            current = stack.pop(); // Visit the node
            System.out.println(current.getPerson()); // Print person details
            current = current.getRight(); // Move to the right subtree
        }
    }

    // Returns the total number of contacts in the BST
    public int countNodes() {
        return recursiveCountNodes(root); // Start counting from the root
    }

    // Helper method for counting nodes recursively
    private int recursiveCountNodes(Node root) {
        if (root == null) { // Base case: no node
            return 0;
        } else { // Count current + left + right
            return 1 + recursiveCountNodes(root.getLeft()) + recursiveCountNodes(root.getRight());
        }
    }

    // Computes the height of the BST
    public int height() {
        return recursiveHeight(root); // Start from the root
    }

    // Helper method for computing the height recursively
    private int recursiveHeight(Node root) {
        if (root == null) {
            return -1; // Height of an empty tree is -1
        } else {  // Height = 1 + max(left, right)
            return 1 + Math.max(recursiveHeight(root.getLeft()), recursiveHeight(root.getRight()));
        }
    }

    // Returns the contact with the smallest name
    public Person findMin() {
        if (root == null) {
            return null;
        }
        Node current = root;
        while (current.getLeft() != null) { // Move to the leftmost node
            current = current.getLeft();
        }
        return current.getPerson();  // Return the person with the smallest name
    }

    // Returns the contact with the largest name
    public Person findMax() {
        if (root == null) {
            return null;
        }
        Node current = root;
        while (current.getRight() != null) {  // Move to the rightmost node
            current = current.getRight();
        }
        return current.getPerson();  // Return the person with the largest name
    }
}
