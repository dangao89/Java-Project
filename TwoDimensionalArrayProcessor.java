package arrays.demo;

/**
 * Date: 06/06/2024 
 * Purpose of program: Write a program to create a two dimensional array and then
 * pass to a second method. The second method will prompt user to enter integer. 
 * The program will printout the array contents finally.
 */
import java.util.Scanner;
public class TwoDimensionalArrayProcessor {
    public static void main(String[] args) {
        // Create a (3 X 4) 2 dimensional array
        int[][] arr = new int[3][4];

        // Passing array to populateArray method
        arr = populateArray(arr);
        
        // Display the array contents 
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }

            // Display a empty line
            System.out.println();
        }
    }

    //Creat populateArray method
        
    public static int[][] populateArray(int[][] array) {
    // No params passed. It looks like book instand of professor Crellin's.
    // She said it was OK.
    
        //Creat a Scanner
        Scanner in = new Scanner(System.in);

        // Prompt the user to enter an integer between 1 and 10
        System.out.println("Enter a number between 1 and 10: ");

        //Define a variable x to hold the input value.
        int x = in.nextInt();

        // Use nested for loops to enter array values
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = x + 2 * (i + 1);
            }
        }
        return array;
    }
}
