package MarketplaceInventorySystem;

/**
 * Date: 01/27/2025
 * Program Title: Marketplace Inventory System 
 */
import java.util.Scanner;

/**
 * Handles the login process for the Marketplace Inventory System. Provides
 * access to specific menus based on user roles (Manager or User) upon
 * successful authentication.
 *
 * Inputs: - Username and password entered by the user.
 *
 * Outputs: - Success message and access to the appropriate menu for Managers or
 * Users. - Error message for invalid credentials.
 *
 * Expected Roles: - Manager: Username: "admin", Password: "password123" - User:
 * Username: "customer", Password: "guest"
 *
 * @author dangao
 */
public class LoginSystem {

    private static final String MANAGER_USERNAME = "admin"; // The username for the Manager role
    private static final String MANAGER_PASSWORD = "password123"; // The password for the Manager role
    private static final String USER_USERNAME = "customer"; // The username for the User role
    private static final String USER_PASSWORD = "guest"; // The password for the User role

    /**
     * Manages the login process. Prompts the user to enter their username and
     * password, validates their credentials, and grants access to the
     * appropriate menu based on their role.
     */
    public static void login() {
        while (true) { //Infinite loop to allow retries
            Scanner scanner = new Scanner(System.in);
            System.out.println("------Welcome to Market Inventory System------");
            System.out.print("Enter username: "); // Prompt user for username
            String username = scanner.nextLine();
            System.out.print("Enter password: "); // Prompt user for password
            String password = scanner.nextLine();

            MarketPlaceAccess access; // Declare a variable for accessing Manager or User menu

            // Check if the entered credentials match the Manager or user credentials
            if (MANAGER_USERNAME.equals(username) && MANAGER_PASSWORD.equals(password)) {
                System.out.println("Manager login successful.");
                access = new Manager(); // Create a Manager instance
                access.showMenu(); // Show the Manager menu
                return;
            } else if (USER_USERNAME.equals(username) && USER_PASSWORD.equals(password)) {
                System.out.println("User login successful.");
                access = new User(); //Create a User instance
                access.showMenu(); // Show the User menu
                return;
            } else {
                System.out.println("Invalid credentials! Exiting the system.");
            }
        }
    }

    // The entry point of the application. 
    public static void main(String[] args) {
        System.out.println("Program Title: Marketplace Inventory System");
        System.out.println("Author: <Dan Gao>");
        System.out.println("Course: CSC330, Sec 02");
        System.out.println("---------------------------------");
        login(); //Start the login process
    }
}
