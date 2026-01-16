package arrays.operations;

/**
 * Date: 06/04/2024 
 * PurposeOfProgram: Write a program that initializes an array with 10 random
 * integers and then prints every elements, every element at an odd index, every
 * even element, all elements in reverse order, and only the second and fifth
 * element.
 */
public class ArrayOperations {

    public static void main(String[] args) {
        //Create a single dimensiond array of 10 elements of int type.        
        int[] arr = new int[10];
        
        //Initializes the array with random integers (between 1 and 100) and print every element.
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((Math.random() * 100) + 1);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
        //Print every element at an odd  index.
        for (int i = 1; i < arr.length; i += 2) {
                System.out.print(arr[i] + " ");
            }
        System.out.println();
        
        //Print every even element.
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
        
        //Print all elements in reverse order
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
        //Print only the second and fifth element
        System.out.println(arr[1] + " " + arr[4]);
    }
}
