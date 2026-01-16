package MarketplaceInventorySystem;

import java.util.Scanner;

/**
 * Utility class for input validation in the Marketplace Inventory System. This
 * class provides methods to validate and retrieve user inputs such as strings,
 * integers, doubles, and Boolean.
 */
public class CheckUtil {

    /**
     * Validates and retrieves a non-empty string from the user input.
     *
     * @param scanner A Scanner object used to read user input.
     * @param message A string message to prompt the user for input.
     * @return A valid, non-empty string entered by the user.
     */
    public static String isValidString(Scanner scanner, String message) {
        String name = null; // Initialize the variable to hold the user's input
        boolean valid = true; // Flag to control the loop
        while (valid) { // Loop until a valid string is entered
            System.out.print(message); // Prompt the user with the message
            name = scanner.nextLine();
            if (name != null && name.trim().isEmpty()) { // Check if the input is empty or only whitespace
                System.out.println("Invalid name. Please enter a valid name.");
            } else {
                valid = false; // Exit the loop if input is valid
            }
        }
        return name; // Return the valid string
    }

    /**
     * Validates and retrieves an integer from the user input that matches one
     * of the values in the specified array.
     *
     * @param scanner A Scanner object used to read user input.
     * @param message A string message to prompt the user for input.
     * @param array An array of integers representing the valid range of values.
     * @return A valid integer entered by the user.
     */
    public static int isValidInt(Scanner scanner, String message, int[] array) {
        int num; // Variable to store the user's input

        while (true) { // Infinite loop to repeatedly prompt for input until valid
            System.out.print(message);
            try {
                num = scanner.nextInt();
                for (int i : array) { // Loop through the array of valid integers
                    if (i == num) { // Check if the entered number matches a valid option
                        scanner.nextLine(); // Clear the buffer.
                        return num;
                    }
                }
                System.out.println("Invalid number. Please enter a legal range number.");
            } catch (Exception e) { // Handle exceptions (e.g., invalid input format)
                System.out.println("Invalid number. Please enter a number.");
                scanner.nextLine();
            }
        }
    }

    /**
     * Validates and retrieves a valid double precision floating-point number
     * from user input.
     *
     * @param scanner A Scanner object used to read user input.
     * @param message A string message to prompt the user for input.
     * @param max The maximum limit for the input number, can be null to skip
     * this check.
     * @return A valid double precision floating-point number entered by the
     * user.
     */
    public static double isValidDouble(Scanner scanner, String message, Double max) {
        double num = 0;
        boolean valid = true;
        while (valid) { // Loop until a valid double is entered
            System.out.print(message); // Prompt the user with the message
            try {
                num = scanner.nextDouble();

                if (num <= 0) { // Check if the input is a positive number
                    System.out.println("Invalid number. Please enter a positive number.");
                } else if (max != null && num > max) { // Check if the input exceeds the maximum limit (if applicable)
                    System.out.println("Invalid number. Please enter a number less than " + max);
                } else {
                    valid = false; // Exit the loop if the input is valid
                }
            } catch (Exception e) { // Handle exceptions (e.g., invalid input format)
                System.out.println("Invalid number. Please enter a number.");
                scanner.nextLine();
            }
        }
        return num;
    }

    /**
     * Validates and retrieves a Boolean value from the user input.
     *
     * @param scanner A Scanner object used to read user input.
     * @param message A string message to prompt the user for input.
     * @return A Boolean value entered by the user.
     */
    public static boolean isValidBoolean(Scanner scanner, String message) {
        boolean flag = true; // Variable to store the boolean input
        boolean valid = true; // Flag to control the loop
        while (valid) { // Loop until a valid boolean is entere
            System.out.print(message); // Prompt the user with the message
            try {
                flag = scanner.nextBoolean();
                valid = false; // Exit the loop if input is valid

            } catch (Exception e) { // Handle exceptions (e.g., invalid input format)
                System.out.println("Invalid value. Please enter true or false.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
        return flag; // Return the valid boolean
    }
}
