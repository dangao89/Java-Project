package binarysearchtree;

/**
 * Date: 02/11/2025
 * Program Title: BST-based contact management system 
 * This class contains the main method and handles user interaction
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BSTApp {

    public static void main(String[] args) {
        System.out.println("Program Title: BST-based contact management system");
        System.out.println("Author: Dan Gao");
        System.out.println("Course: CSC 330, Sec 02");
        System.out.println("-------------------------");

        BinarySearchTree tree = new BinarySearchTree();  // Create BST instance
        readFile("Person.txt", tree);  // Load data from file into BST
        processMenu(tree, new Scanner(System.in));  //Handle user input
    }

    // Reads persons.txt, creates Person objects, and inserts them into the BST
    private static void readFile(String filename, BinarySearchTree tree) {
        try (Scanner sc = new Scanner(new File(filename))) {  //Open file

            while (sc.hasNextLine()) {  //Read file line by line
                String[] personData = sc.nextLine().split(",");  // Split by comma
                if (personData.length == 3) {  // Check for valid data
                    tree.insert(new Person(personData[0], personData[1], personData[2])); // Insert person
                }
            }
            System.out.println("Data loadednfrom " + filename);
        } catch (FileNotFoundException e) {  // Handle missing file
            System.out.println("File not found: " + filename);
        }
    }

    // Allows the user to manually add a contact to the BST
    private static void addNewEntry(BinarySearchTree tree, Scanner sc) {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter address: ");
        String address = sc.nextLine();
        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        tree.insert(new Person(name, address, phone)); // Add new contact
        System.out.println("Contact added successfully.");
    }

    // Displays the interactive menu for user operations
    private static void displayMenu() {
        System.out.println("\nMENU:");
        System.out.println("1. Display Contacts (Sorted)");
        System.out.println("2. Search Contact");
        System.out.println("3. Count Total Contacts");
        System.out.println("4. Find BST Height");
        System.out.println("5. Find Min & Max Name");
        System.out.println("6. Add New Contact");
        System.out.println("7. Exit");
        System.out.print("Choose an option: ");
    }

    // Handles user input and executes corresponding BST operations
    private static void processMenu(BinarySearchTree tree, Scanner sc) {
        int choice;
        do {
            displayMenu();  // Show menu options
            choice = sc.nextInt();  // Read user's choice
            sc.nextLine();  // Clear buffer

            switch (choice) {
                case 1:
                    tree.inorderTraversal();  // Display sorted contacts
                    break;
                case 2:
                    System.out.print("Enter name to search: ");
                    String searchName = sc.nextLine();
                    Person person = tree.search(searchName);  // Search for a contact
                    System.out.println(person != null ? "Contact found: "
                            + person.toString() : "Sorry, the contact was not found.");
                    break;
                case 3:
                    System.out.println("Total contacts: " + tree.countNodes()); // Display total count
                    break;
                case 4:
                    System.out.println("BST height: " + tree.height()); // Display BST height
                    break;
                case 5:
                    System.out.println("Min name is: " + tree.findMin());  // Find min name
                    System.out.println("Max name is: " + tree.findMax());   // Find max name
                    break;
                case 6:
                    addNewEntry(tree, sc);  //Add new contact
                    break;
                case 7:
                    System.out.println("Exiting program.");  // Exit
                    break;
                default:
                    System.out.println("Invalid option. Please try again."); // Handle invalid input
            }
        } while (choice != 7);  // Loop until user choose to exit
    }
}
