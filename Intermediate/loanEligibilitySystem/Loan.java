package LoanEligibilitySystem;

/**
 * Represents the loan details requested by a customer.
 */
public abstract class Loan {

    //Private attributes
    private double loanAmount;
    private double interestRate;
    private int loanTerm; //In months

    //Initialize the loan amount, interest rate, and loan term
    protected Loan(double loanAmount, double interestRate, int loanTerm) {
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.loanTerm = loanTerm;
    }

    //Calculate monthly payments
    public double calculateMonthlyPayment() {
        double monthlyInterestRate = interestRate / 1200;
        double monthlyPayment = loanAmount * monthlyInterestRate / (1
                - (1 / Math.pow(1 + monthlyInterestRate, loanTerm)));
        return monthlyPayment;
    }

    //Getter for loanAmount
    public double getLoanAmount() {
        return loanAmount;
    }

    //Getter for interestRate
    public double getInterestRate() {
        return interestRate;
    }

    //Abstract method to calculate eligibility
    public abstract void calculateEligibility(Customer customer)
            throws InvalidCreditScoreException, LowIncomeException, LoanAmountTooHighException;

}
