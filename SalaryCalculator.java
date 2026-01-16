package finance.calculator;

/**
 * Date: 05/30/24 
 * Description: This program will calculate the new salary before and after taxes.
 */
import java.util.Scanner;
public class SalaryCalculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the salary estimator!");
        System.out.println("Please enter your current salary:");
        double salary = in.nextDouble();
        System.out.println("Enter the percentage increase(ie 5.49):");
        double increase = in.nextDouble();
        double newAmt = calcIncrease(salary, increase);
        System.out.printf("Your new salary before taxes = $%,.2f", newAmt);
        System.out.println();
        System.out.println();
        System.out.println("The current Tax Brackets are:");
        System.out.println("35% if (> 243,725)");
        System.out.println("32% if (<= 243,725 && > 191,950)");
        System.out.println("24% if (<= 191,950 && > 100,525)");
        System.out.println("22% if (<= 100,525 && > 47,150)");
        System.out.println("12% if (<= 47,150 && > 11,001)");
        System.out.println("10% if (<= 11,001)");
        System.out.println();
        System.out.println("Enter the Tax Rate after increase:");
        double taxPercent = in.nextDouble();
        double newValAfterTax = taxes(newAmt, taxPercent);
        System.out.printf("Your new salary after taxes = $%,.2f", newValAfterTax);
        System.out.println();
    }
    public static double calcIncrease(double salary, double increase) {
        double newAmt = salary * (1 + increase / 100);
        return newAmt;
    }
    public static double taxes(double newAmt, double taxPercent) {
        double taxedAmt = newAmt * (1 - taxPercent / 100);
        return taxedAmt ;
    }
}
