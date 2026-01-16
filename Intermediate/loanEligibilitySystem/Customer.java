package LoanEligibilitySystem;

/**
 * Represents a customer in the system.
 */
public class Customer implements Person {

    //Private attributes
    private String name;
    private String customerID;
    private double income;
    private double monthlyDebt;
    private int creditScore;

    //Initialize the customer's name, ID, income, monthly debt, and credit score
    public Customer(String name, String customerID, double income, double monthlyDebt, int creditScore) {
        this.name = name;
        this.customerID = customerID;
        this.income = income;
        this.monthlyDebt = monthlyDebt;
        this.creditScore = creditScore;
    }

    @Override //Implements the getName() method defined in Person interface
    public String getName() {
        return name;
    }

    @Override //Implements the getID() method defined in Person interface
    public String getID() {
        return customerID;
    }

    //Getter for income
    public double getIncome() {
        return income;
    }

    //Getter for monthlyDebt
    public double getMonthlyDebt() {
        return monthlyDebt;
    }

    //Getter for creditScore
    public int getCreditScore() {
        return creditScore;
    }
}
