package MarketplaceInventorySystem;

/**
 * This class represents a type of product: Meat. The Meat class extends the
 * Product class and adds additional attributes and functionality specific to
 * meat products, such as the type of meat cut. It also overrides methods to
 * calculate the price based on weight and price per kilogram.
 */
public class Meat extends Product {

    //Private attribute
    private String cutType;

    // Constructs a Meat object with specified name, weight, price per kilogram, and cut type. 
    public Meat(String name, double weight, double pricePerKg, String cutType) {
        super(name, weight, pricePerKg); // Call the constructor of the superclass (Product)
        this.cutType = cutType;
    }

    // Constructs a Meat object with the specified name.
    public Meat(String name) {
        super(name); // Call the constructor of the superclass (Product) with the name
    }

    /**
     * Retrieve the type of meat cut.
     *
     * @return The type of meat cut as a string.
     */
    public String getcutType() {
        return cutType;
    }

    /**
     * Calculates the total price of the meat based on its weight and price per
     * kilogram. Overrides the abstract calculatePrice() method from the Product
     * class.
     *
     * @return The total price of the meat as a double.
     */
    //Override the abstract method from Product class
    @Override
    public double calculatePrice() {
        return getWeight() * getPricePerKg();
    }

    /**
     * Provides a string representation of the Meat object, including the cut
     * type and details from the Product class.
     *
     * @return A string describing the Meat object.
     */
    @Override
    public String toString() {
        return super.toString() + ", Cut Type: " + cutType;
    }
}
