package LeaderboardManagementSystem;

/**
 * Class to sort an array of contestants by their total score in descending order 
 * using the QuickSort algorithm.
 */
public class SortByTotalScore {

    private Contestant[] contestants; //Array of Contestant objects to be sorted
    private int start; //Start index for sorting
    private int end; //End index for sorting

    //Sorts the contestants array using the QuickSort algorithm.
    public static void quickSort(Contestant[] contestants, int start, int end) {
        //The sorting process continues only if the start index is less than the end index 
        if (start < end) {
            //Partition the array and get the pivot index
            int pivotIndex = partition(contestants, start, end);

            //Recursively sort the sub-array before the pivot
            quickSort(contestants, start, pivotIndex - 1);

            //Recursively sort the sub-array after the pivot
            quickSort(contestants, pivotIndex + 1, end);
        }
    }

    //Partitions the array into two halves and returns the pivot index
    public static int partition(Contestant[] contestants, int start, int end) {
        //Choose the total score of the first contestant as the pivot
        int pivot = contestants[start].getTotalScore();

        int i = start; //Index for forward search
        int j = end; //Index for backward search

        //Loop to rearrange elements based on the pivot
        while (i < j) {
            //Move the left pointer i forward until a smaller score than the pivot is found
            while (i <= j && contestants[i].getTotalScore() >= pivot) {
                i++; //Increment the pointer i
            }
            //Move the right pointer j backward until a larger score than pivot is found
            while (i <= j && contestants[j].getTotalScore() < pivot) {
                j--; //Decrement the pointer j
            }
            //If the pointers haven't crossed, swap the contestants at i and j
            if (i < j) {
                swap(contestants, i, j);
            }
        }

        //Swap the pivot contestant with the contestant at the j index
        swap(contestants, start, j);
        return j;
    }

    //Swap two elements in the contestants array
    public static void swap(Contestant[] contestants, int i, int j) {
        //Temporarily store the contestant at index j
        Contestant temp = contestants[j];

        //Assign the contestant at index i to index j
        contestants[j] = contestants[i];

        //Assign the stored contestant to index i
        contestants[i] = temp;
    }
}
