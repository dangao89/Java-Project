package binarysearchtree;

/**
 * This class represents a contact entry in the address book. It implements the
 * Comparable interface for name-based sorting.
 */
public class Person implements Comparable<Person> {

    private String name; // Unique, case-insensitive
    private String address;
    private String phone;

    // Constructor to initialize a Person object.
    public Person(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    // Getter method for the name field.
    public String getName() {
        return name;
    }

    // Compares two Person objects based on name (case-insensitive).
    @Override
    public int compareTo(Person other) {
        return this.name.compareToIgnoreCase(other.name);
    }

    // Returns a formatted string representation of the person’s details.
    @Override
    public String toString() {
        return String.format("Name: %s, Address: %s, Phone: %s", name, address, phone);

    }
}
