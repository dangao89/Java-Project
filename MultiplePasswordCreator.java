
package security.password;

/**
 * Date: 05/28/2024
 * Description: Write a program to create 5 passwords that are stored in an array. 
 */

import java.util.*;
public class MultiplePasswordCreator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the password Creator!");
        System.out.println("You can create up to 5 passwords.");    
        System.out.println("Would you like to get started now? yes/no");
        String response = in.next();
        response = response.toLowerCase();
        
        String [] pWArray = new String [5]; 
        char fChar = ' ';
        char mChar = ' ';
        char lChar = ' ';
        int count = 0;
        while(count < 5 && response.equals("yes")){
            System.out.println("Enter First Name");
            String fName = in.next();
            int fLength = (int)(Math.random() * fName.length()) + 1;  
            fChar = fName.charAt(fLength - 1);
            
            System.out.println("Enter Middle Name");
            String mName = in.next();
            int mLength = (int)(Math.random() * mName.length()) + 1;
            mChar = mName.charAt(mLength - 1);      
            
            System.out.println("Enter Last Name");
            String lName = in.next();
            int lLength = (int)(Math.random() * lName.length()) + 1;
            lChar = lName.charAt(lLength - 1);
     
            String fLetter = Character.toString(fChar);
            String mLetter = Character.toString(mChar);
            String lLetter = Character.toString(lChar);        
            String passWord = fLetter + mLetter + lLetter;
        
            int nums = 0;
            for(int i = 0; i < 8; i++){              
                int random = (int)(Math.random()*100) + 1;
                nums = nums + random;
            }          
            passWord = passWord + nums;              
            pWArray[count] = passWord;
            count++;
              
            System.out.println("Would you like to create another password? yes/no");
            response = in.next();
            response = response.toLowerCase();      
        }
        
        System.out.println("You created: " + count + " password(s).");
        
        for(int i = 0; i < count; i++){
            System.out.println(i + 1 + ". " + pWArray[i]);
        }
        
        
    }
}
