
package math.tables;

/**
* Date: 05/21/2024
* Description: Write a program that uses nested for loops to display a multiplication table.
*/
public class MultiplicationTableGenerator {

    public static void main(String[] args) {
        
        int maxDigit = 10;
        
        for(int i = 1; i <= maxDigit; i++){
            for (int j =1; j <= maxDigit; j++){
                System.out.printf(" %4d", i * j);    
            }
            System.out.println();
        }   
    }
}
