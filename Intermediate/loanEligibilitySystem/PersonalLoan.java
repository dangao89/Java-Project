package LoanEligibilitySystem;

/**
 * This class represents a personal loan.
 */
public class PersonalLoan extends Loan {

    //Initialize the loan amount, interest rate, and loan term
    public PersonalLoan(double loanAmount, double interestRate, int loanTerm) {
        super(loanAmount, interestRate, loanTerm);
    }

    @Override //Implements the abstract method from Loan class
    public void calculateEligibility(Customer customer)
            throws InvalidCreditScoreException, LowIncomeException, LoanAmountTooHighException {

        //Calculate the customer's debt-to-income ratio  
        double debtToIncomeRatio = customer.getMonthlyDebt() / customer.getIncome();
       
        //Calculate the eligible loan amount as 10 times the customer's income
        double eligibleLoanAmount = customer.getIncome() * 10;

        //Check if the credit score is outside the valid range of 300 to 900
        if (customer.getCreditScore() < 300 || customer.getCreditScore() > 900) {
            throw new InvalidCreditScoreException("Credit score must be between 300 and 900");
        }

        //Check if the debt-to-income ratio is too high (> 0.4)
        if (debtToIncomeRatio > 0.4) {
            throw new LowIncomeException("Debt-to-Income ratio is too high");
        }

        //Check if the requested loan amount exceeds the eligible loan amount
        if (eligibleLoanAmount < getLoanAmount()) {
            throw new LoanAmountTooHighException("Requested loan amount exceeds the eligibility");
        } 
    }
}
