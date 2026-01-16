package MarketplaceInventorySystem;

import java.util.Objects;

/**
 * Represents a product in the marketplace. This abstract class serves as a base
 * for specific product types, such as Meat or Vegetable. It contains shared
 * properties like name, weight, and price per kilogram, and requires subclasses
 * to implement the calculatePrice` method for price calculation.
 */
public abstract class Product {

    //Private attributes
    private String name;
    private double weight;
    private double pricePerKg;

    // Constructs a Product with the specified name, weight, and price per kilogram.
    public Product(String name, double weight, double pricePerKg) {
        this.name = name;
        this.weight = weight;
        this.pricePerKg = pricePerKg;
    }

    // Constructs a Product with the specified name.
    public Product(String name) {
        this.name = name;
    }

    /**
     * Retrieves the name of the product.
     *
     * @return The name of the product as a string.
     */
    public String getName() {
        return name;
    }

    /**
     * Provides a string representation of the product, including its name,
     * weight, and price per kilogram.
     *
     * @return A string describing the product.
     */
    @Override
    public String toString() {
        return name + ", Weight:" + weight + "kg, Price:$" + pricePerKg + "/kg";
    }

    /**
     * Sets the weight of the product.
     *
     * @param weight The weight of the product in kilograms.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Retrieves the weight of the product.
     *
     * @return The weight of the product in kilograms.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Retrieves the price per kilogram of the product.
     *
     * @return The price per kilogram of the product as a double.
     */
    public double getPricePerKg() {
        return pricePerKg;
    }

    /**
     * Abstract method to calculate the total price based on weight. Subclasses
     * must provide their own implementation of this method.
     *
     * @return total price as double
     */
    public abstract double calculatePrice();

    /**
     * Compares this product with another object for equality. Products are
     * considered equal if their names are the same.
     *
     * @param o The object to compare to.
     * @return True if the products have the same name, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        // Checks if the passed object is null or if it is not of the same class as this object.
        if (o == null || getClass() != o.getClass()) {
            // Returns false if the object is null or of a different class.
            return false;
        }
        // Casts the object to a Product type since it has passed the class check.
        Product product = (Product) o;
        // Compares the 'name' field of the current object with the 'name' field of the other Product object.
        return Objects.equals(name, product.name);
    }

    /**
     * Overrides the hashCode method to provide a consistent hash code for
     * Product objects.
     *
     * @return The hash code of the product as an integer, based on its name.
     */
    @Override
    public int hashCode() {
        // Generates a hash code based on the 'name' field, ensuring consistency with the equals method.
        return Objects.hashCode(name);
    }
}
