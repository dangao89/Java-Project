
package security.password;

/** 
 * Date: 05/23/2024
 * Description: Write a program to create a random password. 
 */

import java.util.*;

public class PasswordGenerator {

    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       System.out.println("Enter first name: ");
       String fName = in.next();
       System.out.println("Enter middle name: ");
       String mName = in.next();
       System.out.println("Enter last name: ");
       String lName = in.next();
       
       int fLength = (int)(Math.random() * fName.length()) + 1;    
       char fCh = fName.charAt(fLength - 1);
       
       int mLength = (int)(Math.random() * mName.length()) + 1;
       char mCh = mName.charAt(mLength - 1);
       
       int lLength = (int)(Math.random() * lName.length()) + 1;
       char lCh = lName.charAt(lLength - 1);
       
       String fLetter = Character.toString(fCh);
       String mLetter = Character.toString(mCh);
       String lLetter = Character.toString(lCh);
       
       String passWord = fLetter + mLetter + lLetter;
       int num = (int)(Math.random()*100)+1;
       
       passWord = passWord+num;

       System.out.println(passWord);
       
       
       

    }
}
