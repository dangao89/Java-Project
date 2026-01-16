package MarketplaceInventorySystem;

/**
 * This class represents a type of product: Vegetable. The Vegetable class
 * extends the Product class and adds additional attributes and functionality
 * specific to vegetables, such as whether the vegetable is organic or not. It
 * also overrides methods to calculate the price based on weight
 */
public class Vegetable extends Product {

    //Private attribute
    private boolean isOrganic;

    // Constructs a Vegetable object with specified name, weight, price per kilogram, and organic status.
    public Vegetable(String name, double weight, double pricePerKg, boolean isOrganic) {
        super(name, weight, pricePerKg); // Call the constructor of the superclass (Product)
        this.isOrganic = isOrganic; // Initialize the organic status
    }

    // Constructs a Vegetable object with the specified name.
    public Vegetable(String name) {
        super(name);
    }

    /**
     * Retrieves whether the vegetable is organic.
     *
     * @return True if the vegetable is organic, false otherwise.
     */
    public boolean getIsOrganic() {
        return isOrganic;
    }

    /**
     * Calculates the total price of the vegetable based on its weight and price
     * per kilogram. Overrides the abstract calculatePrice() method from the
     * Product class.
     *
     * @return The total price of the vegetable as a double.
     */
    @Override
    public double calculatePrice() {
        return getWeight() * getPricePerKg();
    }

    /**
     * Provides a string representation of the Vegetable object, including
     * whether it is organic and details from the Product class.
     *
     * @return A string describing the Vegetable object.
     */
    @Override
    public String toString() {
        return super.toString() + ", Organic: " + (isOrganic ? "Yes" : "No");
    }

}
