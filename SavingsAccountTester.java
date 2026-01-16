package banking.core;
/**
 *Date: 06/11/2024 
 *Purpose of program: Implementing public class.
 */
public class SavingsAccountTester {
    public static void main(String[] args) {
        SavingsAccount mySavings = new SavingsAccount();
        mySavings.deposit(2000);
        mySavings.withdraw(200);
        System.out.print("Savings balace = ");
        System.out.println(mySavings.getBalance());
        System.out.println("");
        System.out.println("Expected = 1800");
    }
}
