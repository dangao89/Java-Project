package MarketplaceInventorySystem;

import java.util.Objects;

/**
 * Represents an item in the shopping cart. A CartItem consists of a product,
 * the quantity purchased, and the total price.
 */
public class CartItem {

    // Private attributes
    private Product product;
    private double quantity;
    private double price;

    // Constructs a CartItem with the specified product, quantity, and price.
    public CartItem(Product product, double quantity, double price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    // Constructs a CartItem with the specified product.
    public CartItem(Product product) {
        this.product = product;
    }

    /**
     * Retrieve the product associated with this cart item.
     *
     * @return The product associated with this cart item.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the product for this cart item.
     *
     * @param product
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Retrieve the quantity of the product in kilograms.
     *
     * @return
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product in kilograms.
     *
     * @param quantity
     */
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    /**
     * Retrieve the total price for the product in the cart item.
     *
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the total price for the product in the cart item.
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Calculate the total price of the cart item based on its quantity and the
     * product's price per kilogram.
     *
     * @return The total calculated price for this cart item.
     */
    public double calculatePrice() {
        return quantity * product.getPricePerKg();
    }

    /**
     * Provide a string representation of the cart item, including product name,
     * quantity, price per kilogram, and total price.
     *
     * @return A string representation of the cart item.
     */
    @Override
    public String toString() {
        return product.getName() + " - " + quantity + " kg @ $" + product.getPricePerKg() + "/kg, Total: $" + calculatePrice();
    }

    /**
     * Checks if this item is equal to another objects. Two cart items are
     * considered equal if they have the same product name.
     *
     * @param o The object to compare with this cart item.
     * @return True if the cart items are equal, otherwise false.
     */
    @Override
    public boolean equals(Object o) {
        // Checks if the passed object is null or if it is not of the same class as this object.
        if (o == null || getClass() != o.getClass()) {
            return false; // Returns false if the object is null or of a different class.
        }
        // Casts the passed object to a CartItem type.
        CartItem cartItem = (CartItem) o;
        // Compares the 'name' of the 'product' in the current CartItem with the 'name' of the 'product' in the other CartItem.
        // Return ture if the name are equal; otherwise, return false.
        return Objects.equals(product.getName(), cartItem.product.getName());
    }

    /**
     * Generates a hash code for this cart item based on the product name.
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(product.getName());
    }
}
