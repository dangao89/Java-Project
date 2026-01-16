package LoanEligibilitySystem;

/**
 * Date: 10/21/2024
 * Program Title: Loan Eligibility Evaluation System 
 */
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoanEligibilitySystemMain {

    public static void main(String[] args) {
        System.out.println("Program Title: Loan Eligibility Evaluation System");
        System.out.println("Author: Dan Gao");
        System.out.println("Course: CSC 230, Sec 01");
        System.out.println("-------------------------");

        //Create an instance of LoanEligibilitySystem to manage customers and loans
        LoanEligibilitySystem system = new LoanEligibilitySystem();

        //Reference the existing file containing customer and loan data
        File file = new File("customerData.txt");

        //Use Scanner to read data from the file
        try (Scanner scanner = new Scanner(file)) {

            int count = 0; //Initialize a counter to create unique customer IDs

            //Skip the header row if present
            if (scanner.hasNextLine()) {
                scanner.nextLine(); //Skip the header line
            }

            //Loop to read each line from the file
            while (scanner.hasNextLine()) {
                //Read the next line from the file
                String line = scanner.nextLine();

                //Split the line into data fields using commas as separators
                String[] userData = line.split(", ");

                //Assign values from the split line to individual variables
                String customerName = userData[0];
                double monthlyIncome = Double.parseDouble(userData[1]);
                double monthlyDebt = Double.parseDouble(userData[2]);
                int creditScore = Integer.parseInt(userData[3]);
                String loanType = userData[4];
                double loanAmount = Double.parseDouble(userData[5]);
                double interestRate = Double.parseDouble(userData[6]);
                int loanTerm = Integer.parseInt(userData[7]);

                count++; // Increment the counter for unique customer ID generation

                //Create a unique customer ID using the counter
                String customerID = String.valueOf(count);

                //Instantiate a Customer object with parsed data
                Customer customer = new Customer(customerName, customerID, monthlyIncome, monthlyDebt, creditScore);

                //Add the customer to the system
                system.addCustomer(customer);

                Loan loan = null; // Initialize a Loan reference

                //Determine the loan type and create the appropriate loan objects
                if (loanType.equalsIgnoreCase("PersonalLoan")) {
                    loan = new PersonalLoan(loanAmount, interestRate, loanTerm);
                } else if (loanType.equalsIgnoreCase("HomeLoan")) {
                    loan = new HomeLoan(loanAmount, interestRate, loanTerm);
                } else if (loanType.equalsIgnoreCase("CarLoan")) {
                    loan = new CarLoan(loanAmount, interestRate, loanTerm);
                } else {
                    //Print an error if the loan type is not recognized
                    System.out.println("Invalid loan type");
                }

                //If a valid loan object was created, add it to the system
                if (loan != null) {
                    system.addLoan(loan);

                    //Evaluate the customer's eligibility for the loan
                    system.evaluateLoan(customer, loan);
                }
            }
            //Display the stored eligibility results from the output file 
            system.readFromFile();

        } catch (FileNotFoundException e) {
            //Print an error message if the file is not found
            System.out.println("File not found: " + file.getName());

        } catch (IOException e) {
            //Handle any I/O errors during file operations
            System.out.println("Error processing files: " + e.getMessage());
        }
    }
}
