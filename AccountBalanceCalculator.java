package finance.calculator;

/******************************************************************
* Date: 05/09/24
* Description:Calculate the account balance for the first 3 years.
* ****************************************************************/

public class AccountBalanceCalculator {

    public static void main(String[] args) {
        // TODO code application logic here
        double amt=500;
        double intRate=3.2;
        System.out.print("The amout= "); 
        System.out.printf("%5.2f", amt);
        System.out.println();
        System.out.print("The intRate= "); 
        System.out.printf("%5.2f", intRate);
        System.out.println();
        amt=amt+amt*intRate/100;
        System.out.print("after 1 year the account will have accrued:"); 
        System.out.printf("%5.2f", amt);
        System.out.println();
        amt=amt+amt*intRate/100;
        System.out.print("after 2 year the account will have accrued:"); 
        System.out.printf("%5.2f", amt);
        System.out.println();
        amt=amt+amt*intRate/100;
        System.out.print("after 3 year the account will have accrued:"); 
        System.out.printf("%5.2f", amt);
        System.out.println();
        
                
                
                
        
    }
    
}
