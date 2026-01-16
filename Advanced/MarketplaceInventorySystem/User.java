package MarketplaceInventorySystem;

/**
 * User class represents the functionality of a user interacting with the
 * marketplace system. It implements the MarketPlaceAccess interface, allowing
 * users to view and manage their cart. Users can add/remove items to/from the
 * cart, view cart contents, and proceed with checkout. It interacts with the
 * Manager class to view available products and update the inventory.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class User implements MarketPlaceAccess {

    // Holds the items added to the cart by the user
    private ArrayList<CartItem> cart;

    // Constructor initializes an empty cart for the user.
    public User() {
        this.cart = new ArrayList<>();
    }

    /**
     * Displays the user menu with options to interact with the marketplace. The
     * user can choose to add/remove products from the cart, view the cart, or
     * checkout.
     *
     * Expected inputs: - An integer representing the user's menu choice (1, 2,
     * 3, 4, or 0).
     *
     * Outputs: - Executes the selected operation, such as adding/removing items
     * or proceeding with checkout.
     */
    @Override
    public void showMenu() {
        // Infinite loop to continuously show the menu until the user chooses to logout.
        while (true) {
            Scanner scanner = new Scanner(System.in);
            // Display the menu options for the user
            System.out.println("----------User Menu----------");
            System.out.println("1. Add to Cart");
            System.out.println("2. Remove from Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Check out");
            System.out.println("0. Logout");
            // Prompt the user to enter their choice and validate the input
            int choice = CheckUtil.isValidInt(scanner, "Enter Choice: ", new int[]{1, 2, 3, 4, 0});

            // Switch case to handle different menu options based on user input
            switch (choice) {
                // Add product to cart
                case 1 -> {
                    Manager.viewInventory(); // Display the inventory of products available
                    // Get product name input from the user and validate it
                    String name = CheckUtil.isValidString(scanner, "Enter product name: ");

                    // Check if the product exists in the inventory
                    boolean exist = false;
                    Product product = null;
                    for (Product productTemp : Manager.inventory) {
                        if (productTemp.getName().equals(name)) {
                            exist = true;
                            product = productTemp;
                            break;
                        }
                    }

                    // If the product doesn't exist in inventory, inform the user
                    if (!exist) {
                        System.out.println(name + " not found in inventory.");
                    } else {
                        // Get product quantity input and validate it
                        double quantity = CheckUtil.isValidDouble(scanner, "Enter product quantity(kg): ", product.getWeight());
                        // Add the product to the cart
                        addToCart(product, quantity);
                    }
                }
                case 2 -> { // Remove product from cart
                    // Get product name input to remove from the cart
                    String name = CheckUtil.isValidString(scanner, "Enter product name to remove: ");

                    // Check if the product exists in the cart
                    boolean exist = false;
                    for (CartItem cartItem : cart) {
                        if (cartItem.getProduct().getName().equals(name)) {
                            exist = true;
                            // Remove the product from the cart
                            removeFromCart(cartItem.getProduct());
                            break;
                        }
                    }
                    if (!exist) { // If the product doesn't exist in cart, inform the user
                        System.out.println(name + " not found in cart.");
                    }
                }
                case 3 -> { // View the items in the cart
                    viewCart();
                }
                case 4 -> { // Proceed to checkout
                    checkout();
                }
                case 0 -> { // Logout and return to the login system
                    LoginSystem.login();
                    return;
                }
            }
        }
    }

    /**
     * Adds a product to the user's cart with the specified quantity.
     *
     * @param product The product to be added to the cart.
     * @param quantity The quantity of the product to be added to the cart (in
     * kg).
     */
    public void addToCart(Product product, double quantity) {
        // Create a new CartItem and add it to the cart
        CartItem item = new CartItem(product, quantity, product.getPricePerKg());
        cart.add(item);
        System.out.println(quantity + " kg of " + product.getName() + " added to cart.");
    }

    /**
     * Removes a product from the user's cart.
     *
     * @param product The product to be removed from the cart.
     */
    public void removeFromCart(Product product) {
        // Create a CartItem for the product and remove it from the cart
        CartItem item = new CartItem(product);
        cart.remove(item);
        System.out.println(product.getName() + " removed from cart.");
    }

    /**
     * Displays the contents of the user's cart. If the cart is empty, a message
     * will be shown indicating so.
     */
    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        }
        // Otherwise, display the details of each item in the cart
        for (CartItem item : cart) {
            System.out.println(item.toString());
        }
    }

    /**
     * Processes the checkout by calculating the total payment for the items in
     * the cart, updating the inventory with the reduced quantities of products,
     * and clearing the cart.
     *
     */
    public void checkout() {
        double total = 0;
        // Iterate through the cart and process each item
        for (CartItem item : cart) {
            Product product = item.getProduct();
            // Update the product's weight based on the quantity purchased
            product.setWeight(product.getWeight() - item.getQuantity());

            // Update the inventory with the modified product
            int index = Manager.inventory.indexOf(product);
            if (index != -1) {
                Manager.inventory.set(index, product);
            }

            // Calculate the total price for the item and add it to the total payment
            total += item.calculatePrice();
        }
        // Display the total payment for the items in the cart
        System.out.println("Total Payment: $" + total);
        // Clear the cart after checkout is complete
        cart.clear();
    }
}
