package banking.core;

/**
 *Date: 06/11/2024 
 *Purpose of program: Implementing public class.
 */
public class SavingsAccount {

    private double balance;
    
    //constructs account with 0 balance
    public SavingsAccount()
    {
        balance = 0;
    }
    public void deposit(double amount)
    {
        balance = balance + amount;
    }
    public void withdraw(double amount)
    {
        balance = balance - amount;
    }
    public double getBalance()
    {
        return balance;
    }
}
