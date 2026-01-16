package binaryheap;

/**
 * A generic implementation of a binary max-heap. The heap stores elements of
 * type E which must implement Comparable for comparison. This class provides
 * operations like insertion, deletion, heapify, and heap sorting.
 */
import java.util.Arrays;

public class Heap<E extends Comparable<E>> {

    private Comparable<E>[] heapArray; // Array to store heap elements
    private int size; // Current size of heap
    private int capacity; // Maximum capacity of the heap;

    /**
     * Constructs a heap with the specified initial capacity. Initializes the
     * heap array and sets the size to 0.
     *
     * @param capacity the initial capacity of the heap
     */
    public Heap(int capacity) {
        this.heapArray = new Comparable[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    /**
     * Returns the index of the parent of the given index.
     *
     * @param index the index of the child
     * @return the index of the parent
     */
    private int parent(int index) {
        return (index - 1) / 2; 
    }

    /**
     * Returns the index of the left child of the given index.
     *
     * @param index the index of the parent
     * @return the index of the left child
     */
    private int leftChild(int index) {
        return 2 * index + 1; 
    }

    /**
     * Returns the index of the right child of the given index.
     *
     * @param index the index of the parent
     * @return the index of the right child
     */
    private int rightChild(int index) {
        return 2 * index + 2; 
    }

    /**
     * Checks if the given index is a leaf node.
     *
     * @param index the index to check
     * @return true if the index is a leaf node, false otherwise
     */
    private boolean isLeaf(int index) {
        return index >= size / 2; // Leaf nodes are in the second half of the heap
    }

    /**
     * Inserts an element into the heap and maintains the heap property. The new
     * element is placed at the end of the heap and then percolated up.
     *
     * @param elem the element to be inserted
     */
    public void insert(E elem) {
        if (elem == null) {
            throw new IllegalArgumentException("Cannot insert null elements into the heap.");
        }
        if (size >= capacity) {
            resize(); // Resize the heap if it's full
        }
        heapArray[size] = elem;  // Place the element at the end of the heap
        int current = size;
        size++; // Increase the size of the heap

        // Percolate up to maintain the max-heap property
        while (current > 0 && heapArray[current].compareTo((E) heapArray[parent(current)]) > 0) {
            swap(heapArray, current, parent(current)); // Swap with parent if current is larger
            current = parent(current); // Move up to the parent's position
        }
    }

    /**
     * Deletes and returns the maximum element of the heap. The root (maximum
     * element) is removed, the last element is moved to the root, and then the
     * heap property is restored by percolating down.
     *
     * @return the maximum element
     */
    public E deleteMax() {
        if (size == 0) {
            throw new IllegalArgumentException("Heap is empty"); // Throw exception if heap is empty
        }
        E max = (E) heapArray[0]; // The root element is the maximum
        size--; // Decrease the size of the heap
        heapArray[0] = heapArray[size]; // Replace the root with the last element       
        percolateDown(heapArray, 0, size); // Restore the heap property by percolating down
        return max;
    }

    /**
     * Builds a heap from an array of elements. The array is copied into the
     * heap array, and the heap property is restored.
     *
     * @param arr the array to build the heap
     */
    public void buildHeap(E[] arr) {
        
        size = arr.length; // Set the size of the heap
        heapArray = new Comparable[size];
        for (int i = 0; i < size; i++) {
            heapArray[i] = arr[i];  // Copy elements into heapArray starting at index 0
        }
        heapify(); // Restore the heap property by percolating down
    }

    /**
     * Restores the heap property for the entire heap by percolating down
     */
    private void heapify() {
        for (int i = size / 2 - 1; i >= 0; i--) { // Start from first non-leaf node
            percolateDown(heapArray, i, size);
        }
    }

    /**
     * Restores the heap property by moving an element down the heap.
     *
     * @param array the heap array
     * @param position the index of the element to percolate down
     * @param heapSize the size of the heap
     */
    private void percolateDown(Comparable<E>[] array, int position, int heapSize) {
        // Declare variables for left child, right child, and largest element
        int left, right, largest;
        while (position < heapSize / 2) { // Continue while the current position is a non-leaf node
            left = leftChild(position); 
            right = left + 1; 
            largest = position; // Assume the current position has the largest element

            // Check if the left child is larger than the current largest
            if (left < heapSize && array[left] != null && array[left].compareTo((E) array[largest]) > 0) {
                largest = left;
            }
            // Check if the right child is larger than the current largest
            if (right < heapSize && array[right] != null && array[right].compareTo((E) array[largest]) > 0) {
                largest = right;
            }
            // If the largest element is not at the current position
            if (largest != position) {
                // Swap the elements at the current position and the largest position
                swap(array, position, largest);
                position = largest; // Update the current position to the largest position
            } else {
                break; // If the heap property is satisfied, exit the loop
            }
        }
    }

    /**
     * Swaps two elements in the heap array.
     *
     * @param array the heap array
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private void swap(Comparable<E>[] array, int i, int j) {
        Comparable<E> temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Resizes the heap array when it runs out of space. The array size is
     * doubled, and the existing elements are copied to the new array.
     */
    private void resize() {
        Comparable<E>[] newHeapArray = new Comparable[heapArray.length * 2]; // Double the capacity
        System.arraycopy(heapArray, 0, newHeapArray, 0, size); // copy elements to new array
        heapArray = newHeapArray; // Replace the old array with the new one
        capacity = heapArray.length; // Update the heap's capacity
    }

    /**
     * Prints the current heap as an array.
     */
    public void printHeap() {
        E[] tempArray = (E[]) new Comparable[size];  // Allocate the correct size
        System.arraycopy(heapArray, 0, tempArray, 0, size); // Copy elements to tempArray
        System.out.println(Arrays.toString(tempArray));  // Print the heap as an array
    }

    /**
     * Sorts an array using in-place heap sort (0-based indexing).
     *
     * @param array the array to be sorted
     */
    public void heapSort(Comparable<E>[] array) {
        int n = array.length; // Get the length of the array
        // Iterate through the non-leaf nodes of the heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            percolateDown(array, i, n);  // Call percolateDown to maintain the heap property
        }
        // Iterate from the last element to the second element
        for (int i = n - 1; i > 0; i--) {
            swap(array, 0, i); // Swap the root element with the current element
            percolateDown(array, 0, i); // Call percolateDown to maintain the heap property

        }
    }

    /**
     * Finds the K largest elements in an array. Builds a heap from the array
     * and then extracts the K largest elements.
     *
     * @param array the input array
     * @param k the number of largest elements to find
     * @return an array containing the K largest elements
     */
    public Comparable<E>[] findKMaxElements(Comparable<E>[] array, int k) {
        // Create a new Heap object to avoid modifying the original heap
        Heap<E> tempHeap = new Heap<>(array.length);
        tempHeap.buildHeap((E[])array); // Build a heap from the input array
        E[] result = (E[]) new Comparable[k]; // Create a result array for the K largest elements
        for (int i = 0; i < k; i++) {
            // Extract the maximum element and store it in the result
            result[i] = tempHeap.deleteMax();
        }
        return result;
    }
}
