package garden.layout;

/**
* Date: 05/14/2024
* Description: This program will help me to compute the garden's area,
* the total number of plants and the cost of the flats.
 */
public class GardenLayoutCalculator {

    public static void main(String[] args) {
       
        // Convert the garden dimensions to square feet
        
        int gardenLength = 45;
        int gardenWidth = 9;
        int gardenDim = gardenLength * gardenWidth;
        
        System.out.println("The total square feet space in garden = " + gardenDim);
        
        //Declare cost per flat and number of plants per flat 
        
        int costPerFlat = 22;
        int numPlantsPerFlat = 36;
        
        //Compute sqFt area of each plant 
        
        double plantLength = 1.5;
        double plantWidth = 1.5;
        double plantSqFt = plantLength * plantWidth;
        
        System.out.println("The square feet per plant = " + plantSqFt);
        
        //Compute the total area required to plant each flat and the side length of a square flat
        
        double flatSqFt = numPlantsPerFlat * plantSqFt;
        double flatSideLength = Math.sqrt(flatSqFt);
        
        System.out.println("The square feet per flat = " + flatSqFt);
        System.out.println("The side length of a square flat = " + flatSideLength);
        
        //Compute and print the number of total plants
        
        double totalPlants =  gardenDim / plantSqFt;
        
        System.out.println("The total number of plants that you will need to buy = " + totalPlants);
        
        //Compute and print total number of flats
        
        double flatsNum = totalPlants / numPlantsPerFlat;
        
        System.out.println("You will need to buy " + flatsNum + " flats");
        
        //Compute and print the cost of flats
        
        final double TAX_RATE = 6.5;
        double costBeforeTax = flatsNum * costPerFlat;
        double costAfterTax = costBeforeTax * (1 + TAX_RATE/100);
        
        System.out.println("Your total cost before tax = " + costBeforeTax);
        System.out.printf("Your total cost after tax = %-10.2f\n", costAfterTax);
        
   
    }
    
}
