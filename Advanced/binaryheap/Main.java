package binaryheap;

/**
 * Date: 03/24/2025
 * Program Title: Binary Heap Implementation 
 * Main class for testing the functionality of a binary heap with different data
 * types. This class demonstrates how the Heap class works with various data
 * types and provides a user interface for selecting data types, inserting
 * elements into the heap, and performing operations such as heap sort and
 * finding the K largest elements.
 */
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    /**
     * Main method that serve as the entry point for the program. It prompts the
     * user for the number of elements, the value of K, and the data type choice
     * before performing heap operation.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the number of elements (N)
        System.out.print("Enter bumber of elements (N): ");
        int N = scanner.nextInt();

        // Validate input for N
        if (N <= 0) {
            System.out.println("Invalid value of N. N must be positive.");
            return;
        }
        scanner.nextLine(); // Consume the newline character

        // Prompt user for value of K
        System.out.print("Enter value of K: ");
        int K = scanner.nextInt();

        // Validate input for K
        if (K > N || K <= 0) {
            System.out.println("Invalid value of K. K must be between 1 and N.");
            return;
        }
        scanner.nextLine();

        // Display data type options
        System.out.println("\nChoose data type:");
        System.out.println("1. Integer");
        System.out.println("2. String");
        System.out.println("3. Student (Custom Class)");
        System.out.print("Enter your choice (1 - 3): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        // Call dataSet method based on user's choice
        switch (choice) {
            case 1 ->
                dataSet(N, K, 1); // Pass 1 for Integer
            case 2 ->
                dataSet(N, K, 2); // Pass 2 for String
            case 3 ->
                dataSet(N, K, 3); // Pass 3 for Student
            default ->
                System.out.println("Invalid choice. Exiting.");
        }
        scanner.close();
    }

    /**
     * Generic method to test heap functionality with different data types. It
     * generates a random array, builds a Max-heap, sorts the array, and finds
     * the K largest elements.
     *
     * @param <E> Generic type that extends Comparable
     * @param N Number of elements
     * @param K Number of largest elements to find
     * @param typeChoice Type of data (1 = Integer, 2 = String, 3 = Student)
     */
    public static <E extends Comparable<E>> void dataSet(int N, int K, int typeChoice) {
        E[] randomArray = generateRandomArray(N, typeChoice);  // Generate random array
        System.out.println("\nGenerated Random Array:\n" + Arrays.toString(randomArray) + "\n");
        Heap<E> heap = new Heap<>(N);  // Create a heap with capacity N
        heap.buildHeap(randomArray);   // Build heap from random array
        System.out.println("Heap Array after heapify: ");
        heap.printHeap();  // Print heap array
        System.out.println();

        // Perform heap sort
        E[] sortedArray = (E[]) new Comparable[randomArray.length]; // Create array for sorted values
        // Copy all elements from randomArray to sortedArray starting from index 0 in both arrays
        System.arraycopy(randomArray, 0, sortedArray, 0, randomArray.length);
        heap.heapSort(sortedArray);  // Sort array using heap sort
        System.out.println("HeapSort Result:\n" + Arrays.toString(sortedArray) + "\n");

        // Find the top K largest elements
        Comparable<E>[] kMaxElements = heap.findKMaxElements(randomArray, K);
        System.out.println("Top " + K + " Largest Elements:\n" + Arrays.toString(kMaxElements) + "\n");
    }

    /**
     * Generates an array of random elements based on the selected data type.
     *
     * @param <E> Generic type that extends Comparable
     * @param N Number of elements
     * @param typeChoice Data type choice (1 = Integer, 2 = String, 3 = Student)
     * @return Array of randomly generated elements
     */
    private static <E extends Comparable<E>> E[] generateRandomArray(int N, int typeChoice) {
        Random random = new Random();  // Create a Random object
        E[] array = (E[]) new Comparable[N]; // Create a generic array

        switch (typeChoice) {
            case 1:  // Integer
                Integer[] intArray = new Integer[N];  // Create an Integer array of size N
                for (int i = 0; i < N; i++) {
                    intArray[i] = random.nextInt(100);  // Random integers between 0 and 99
                }
                System.arraycopy(intArray, 0, array, 0, N);  // Copy elements from intArray to the generic array
                break;
            case 2: // String
                String[] stringArray = new String[N];   // Create a String array of size N
                for (int i = 0; i < N; i++) {
                    stringArray[i] = generateRandomString(random.nextInt(3) + 3); // Random strings of length 3-6
                }
                System.arraycopy(stringArray, 0, array, 0, N);  // Copy elements from stringArray to the generic array
                break;
            case 3: // Student
                Student[] studentArray = new Student[N];   // Create an array of Student objects of size N
                for (int i = 0; i < N; i++) {
                    studentArray[i] = new Student("Student" + i, random.nextInt(100)); // Random students with scores 0-99
                }
                System.arraycopy(studentArray, 0, array, 0, N);  // Copy elements from studentArray to the generic array
                break;
            default:
                throw new IllegalArgumentException("Invalid type choice");  // Throw exception if typeChoice is invalid
        }
        return array;  // Return generated array
    }

    /**
     * Generates a random string of a given length.
     *
     * @param length Length of the random string
     * @return A randomly generated string consisting of lowercase letters
     */
    private static String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);  // Create a StringBuilder with specified length
        for (int i = 0; i < length; i++) {
            char c = (char) ('a' + random.nextInt(26));  // Generate a random lowercase letter
            sb.append(c);
        }
        return sb.toString();   // Convert StringBuilder to String and return
    }
}
