package MarketplaceInventorySystem;

/**
 * Represents a type of product categorized as a fruit in the Marketplace Inventory System.
 * Inherits common product attributes and behavior from the Product class, while
 * adding specific attributes such as the season in which the fruit is available.
 */
public class Fruit extends Product {

    //Private attribute
    private String season;

    //Constructor to initialize all properties of the fruit, including name, weight, 
    //price per kilogram, and season.
    public Fruit(String name, double weight, double pricePerKg, String season) {
        super(name, weight, pricePerKg);
        this.season = season;
    }

    //Constructor to initialize only the name of the fruit. This can be used when
    //other attributes are not immediately available or needed.
    public Fruit(String name) {
        super(name);
    }

    /**
     * Retrieves the season of the fruit.
     * @return The season during which the fruit is available.
     */
    public String getSeason() {
        return season;
    }

    /**
     * Calculates the total price of the fruit based on its weight and price per kilogram.
     * Override the abstract method in the Product class.
     * @return The calculated price of the fruit.
     */
    @Override
    public double calculatePrice() {
        return getWeight() * getPricePerKg();
    }

    /**
     * Provide a string representation of the fruit, including details such as name,
     * weight, price per kilogram, and season. This method overrides the method from the Product class.
     * @return A string representation of the fruit.
     */
    @Override
    public String toString() {
        return super.toString() + ", Season: " + season;
    }
}
