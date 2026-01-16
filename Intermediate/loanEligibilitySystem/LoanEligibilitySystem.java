package LoanEligibilitySystem;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoanEligibilitySystem {

    //Private attributes
    private ArrayList<Customer> customers;
    private ArrayList<Loan> loans;
    private String exceptionMessage;

    //Default Constructor
    public LoanEligibilitySystem() {
        this.customers = new ArrayList<>();
        this.loans = new ArrayList<>();
        this.exceptionMessage = "";
    }

    //Add a customer to the system
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    //Add a loan to the system
    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    //Evaluate whether a customer is eligible for a particular loan
    public void evaluateLoan(Customer customer, Loan loan) throws IOException {
        exceptionMessage = ""; //Reset exception message before evaluation
        boolean eligible = false;
        try {
            // Calculate eligibility for the loan
            loan.calculateEligibility(customer);
            eligible = true; // If no exception is thrown, the customer is eligible for the loan

        } catch (InvalidCreditScoreException | LowIncomeException | LoanAmountTooHighException e) {
            //If an exception is caught, store the message in exceptionMessage for later use
            exceptionMessage = e.getMessage();
        }
        //Call the method to save the evaluation result to a file
        saveToFile(customer, loan, eligible);

    }

    //Save the customer's loan eligibility results to file
    public void saveToFile(Customer customer, Loan loan, boolean eligible) throws IOException {
        
        // Use PrintWriter with FileWriter to write data to the customeroutput.txt file                         
        try (PrintWriter output = new PrintWriter(new FileWriter("customerOutput.txt", true))) {

            output.write("Customer: " + customer.getName() + "\n"); //Write customer name

            //Determine and write the loan type
            String loanType = "Unknown loan";
            if (loan instanceof PersonalLoan) {
                loanType = "Personal Loan";
            } else if (loan instanceof HomeLoan) {
                loanType = "Home Loan";
            } else if (loan instanceof CarLoan) {
                loanType = "Car Loan";
            }
            output.write("Loan Type: " + loanType + "\n");
            output.write("Loan Amount: " + loan.getLoanAmount() + "\n"); //Write loan amount

            //If the customer is eligible, write the eligibility status and monthly payment
            if (eligible == true) {
                output.write("Eligibility: Eligible" + "\n");
                output.write("Monthly Payment: " + String.format("%.2f", loan.calculateMonthlyPayment()) + "\n\n");

            } else {
                //If the customer is not eligible, write the exception message
                output.write("Eligibiliity: Not eligible (" + exceptionMessage + ")\n\n");
            }
        }

    }

    //Read the stored customer and loan data from a file and display them
    public void readFromFile() throws IOException {

        //Creates a File object representing the file named "customerOutput.txt".
        java.io.File file = new java.io.File("customerOutput.txt");

        //Try-with-resources block to ensure the Scanner is closed automatically
        try (Scanner scanner = new Scanner(file)) {
            //Loop through each line in the file
            while (scanner.hasNextLine()) {
                //Print each line from the file to the console
                System.out.println(scanner.nextLine());
            }
        }
    }
}
