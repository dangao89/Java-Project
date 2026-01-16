package MarketplaceInventorySystem;

/**
 * The Manager class implements the MarketPlaceAccess interface and provides
 * functionalities for managing the marketplace inventory system.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Manager implements MarketPlaceAccess {

    // The inventory list stores all products managed by the system.
    public static final ArrayList<Product> inventory = new ArrayList<>();

    /**
     * Displays the Manager's menu and provides options for managing the inventory.
     * This method loops continuously until the user logs out. It handles various
     * operations such as adding, removing, searching, and viewing products, as well
     * as adjusting product weight.
     */
    @Override
    public void showMenu() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            
            // Display the menu options for the manager
            System.out.println("----------Manager Menu----------");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Search Product");
            System.out.println("4. View Inventory");
            System.out.println("5. Adjust Weight");
            System.out.println("0. Logout");
            
            // Prompt the user to enter their choice and validate the input
            int choice = CheckUtil.isValidInt(scanner, "Enter Choice: ", new int[]{1, 2, 3, 4, 5, 0});
            
            // Executes different functionality based on the user's choice.
            switch (choice) {
                
                // Gather product details and add the product to inventory
                case 1 -> {
                    // Prompt the user to enter product details
                    String name = CheckUtil.isValidString(scanner, "Enter product name: ");
                    double weight = CheckUtil.isValidDouble(scanner, "Enter weight(kg): ", null);
                    double pricePerKg = CheckUtil.isValidDouble(scanner, "Enter price per kg: ", null);
                    int type = CheckUtil.isValidInt(scanner, "Enter product type (1: Vegetable, 2: Fruit, 3: Meat): ", new int[]{1, 2, 3});
                   
                    Product product = null; // Initialize product variable
                    // Determine the type of product and create the corresponding object
                    switch (type) {
                        case 1 -> { // Get organic status and create a Vegetable object.
                            boolean isOrganic = CheckUtil.isValidBoolean(scanner, "Enter isOrganic: ");
                            product = new Vegetable(name, weight, pricePerKg, isOrganic);
                        }
                        case 2 -> { // Get fruit season and create a fruit object.
                            String season = CheckUtil.isValidString(scanner, "Enter season: ");
                            product = new Fruit(name, weight, pricePerKg, season);
                        }
                        case 3 -> { // Get meat cut type and create a meat object.
                            String cutType = CheckUtil.isValidString(scanner, "Enter cutType: ");
                            product = new Meat(name, weight, pricePerKg, cutType);
                        }
                    }
                    addProduct(product); // Adds the product to the inventory if it's successfully created.
                }
                // Handles removing a product by name.
                case 2 -> {
                    // Prompt the user to enter the name of the product to remove
                    String name = CheckUtil.isValidString(scanner, "Enter product name to remove: ");
                    boolean exist = false;
                    // Iterate through the inventory to find the product
                    for (Product product : inventory) {
                        if (product.getName().equals(name)) { // Check if the product name matches
                            exist = true;
                            removeProduct(product); // Remove the product from the inventory
                            break;
                        }
                    }
                    // If the product is not found, display an appropriate message
                    if (!exist) {
                        System.out.println(name + " not found in inventory.");
                    }
                }
                // Handles searching for a product by name.
                case 3 -> {
                    // Prompt the user to enter the name of the product to search
                    String name = CheckUtil.isValidString(scanner, "Enter product name to search: ");
                    Product product = searchProduct(name);
                    if (product != null) { // If the product is found, display its details
                        if (product instanceof Vegetable vegetable) { // Check if it is a Vegetable
                            System.out.println(vegetable); 
                        } else if (product instanceof Fruit fruit) { // Check if it is a Fruit
                            System.out.println(fruit);
                        } else if (product instanceof Meat meat) { // Check if it is a Meat
                            System.out.println(meat);
                        }
                    } else { // Display a message if the product is not found
                        System.out.println("Product not found.");
                    }
                }
                // Handles viewing all products in the inventory.
                case 4 -> {
                    viewInventory(); // Call the method to display all products in the inventory
                }
                // Handles adjusting the weight of a product.
                case 5 -> {
                    // Prompt the user to enter the name  and weight of the product to adjust
                    String name = CheckUtil.isValidString(scanner, "Enter product name to Adjust: ");
                    double weight = CheckUtil.isValidDouble(scanner, "Enter product weight to Adjust: ", null);

                    boolean exist = false;
                    for (Product product : inventory) { // Iterate through inventory to find the product.
                        if (product.getName().equals(name)) { // Product found.
                            exist = true;
                            adjustWeight(product, weight); // Adjust the weight.
                            break;
                        }
                    }
                    if (!exist) { // If the product doesn't exist in the inventory.
                        System.out.println(name + " not found in inventory.");
                    }
                }
                // Handles logging out and returning to the login screen.
                case 0 -> {
                    LoginSystem.login(); // Call the login system.
                    return; // Exit the method to stop the menu loop.
                }
            }
        }
    }

    /**
     * Adds a product to the inventory.
     * @param product The product to be added.
     */
    public void addProduct(Product product) {
        inventory.add(product);
        System.out.println(product.getName() + " added to inventory.");
    }

    /**
     * Removes a product from the inventory.
     * @param product The product to be removed.
     */
    public void removeProduct(Product product) {
        inventory.remove(product);
        System.out.println(product.getName() + " removed from inventory.");
    }

    /**
     * Searches for a product in the inventory by name.
     * @param name The name of the product to search for.
     * @return The product if found; otherwise, return null.
     */
    public Product searchProduct(String name) {
        for (Product product : inventory) { // Iterate through the inventory.
            if (product.getName().equals(name)) { // If a product with the given name is found.
                return product;
            }
        }
        return null;
    }

    // Displays all products in the inventory.
    public static void viewInventory() {
        if (inventory.isEmpty()) { // Check if the inventory is empty.
            System.out.println("Inventory is empty.");
        }
        for (Product product : inventory) { // Iterate through the inventory.
            System.out.println(product);
        }
    }

    /**
     * Adjusts the weight of a product in the inventory.
     * @param product The product whose weight needs adjustment.
     * @param weight The amount to adjust the weight by.
     */
    public void adjustWeight(Product product, double weight) {
        product.setWeight(product.getWeight() + weight);
        System.out.println("Updated weight of " + product.getName() + " to " + product.getWeight() + " kg.");
    }
}
