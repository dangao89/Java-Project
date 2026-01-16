package binarysearchtree;

/**
 * This class represents a single node in the BST, containing a Person object.
 */
public class Node {

    private Person person; // Stores the person's details
    private Node left; // Reference to the left child
    private Node right; // Reference to the right child

    // Constructor to initialize the node with a Person object.
    public Node(Person person) {
        this.person = person;
        this.left = null;
        this.right = null;
    }

    // Getter method for the person field
    public Person getPerson() {
        return person;
    }

    // Getter method for the left child
    public Node getLeft() {
        return left;
    }

    // Setter method for the left child
    public void setLeft(Node left) {
        this.left = left;
    }

    // Getter method for the right child
    public Node getRight() {
        return right;
    }

    // Setter method for the right child
    public void setRight(Node right) {
        this.right = right;
    }
}
