
package garden.store;

/**
* Date: 05/16/2024
* Description: This program will help me compute the total price of special plants that I will buy today.
*/

import java.util.Scanner;

public class GardenPlantPurchase {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        final double TAX_RATE = 0.0675;
        double cost = 0;
        double totalCost = 0;               
        System.out.println("Welcome to UNCG's Garden Center!");
        System.out.println();
        System.out.println("option 1. (2) 4 inch 9.45 impatiens");
        System.out.println("option 2. (1) 12 pack 13.98 of okra");
        System.out.println("option 3. (1) 6 pack 11.98 spinach, kale or collards");
        System.out.println("option 4. (1) 8 pack 3.98 of petunias");
        System.out.println("option 5. (1) 2 quart pot 6.98 geraniums");
        System.out.println("option 6. (1) 4 pack 3.16 totatoes, peppers, cucumbers");
        System.out.println("Before you decide, check out today's plant specials: ");
        System.out.println("discount 15% off: ");
        System.out.println("option3 when you buy 4-6 packs or more");
        System.out.println("option5 when you buy 3-2 quart pots or more");
        System.out.println("option6 when you buy 8-4 packs or more");
        System.out.println("Which plants will you be getting today?");
        System.out.println("Enter the option number: ");
        int option = in.nextInt();
        System.out.println("Will you be taking advantage of our great specials today? true or false");
        boolean special = in.nextBoolean();
        System.out.println("Enter the quantity of option number: " + option);
        int qty = in.nextInt();
        switch(option)
        {
            case 1 ->  {cost = 9.45; }
            case 2 ->  {cost = 13.98; }
            case 3 ->  {cost = 11.98; }
            case 4 ->  {cost = 3.98; }
            case 5 ->  {cost = 6.98; }
            case 6 ->  {cost = 3.16; }
        }          
        if (special && ((option == 3 && qty >= 4) || (option == 5 && qty >=3) || (option == 6 && qty >=8)))
        {
            cost = cost * 85/100;
            totalCost = cost * qty;
            totalCost = totalCost * (1 + TAX_RATE);
        
        System.out.printf("Your total purchase is with taxes included = %5.2f", totalCost);
        }
        else
        { 
         System.out.println("Your purchase does not qualify for the special pricing");
        }   
        
    }
        
}
