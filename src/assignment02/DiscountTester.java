package assignment02;

import java.util.Scanner;

public class DiscountTester {
	
	public static void main(String[] args) {
		
        Scanner keyboard = new Scanner(System.in); 	//why warning???
        double inputDouble; 
        boolean inputOK = false; 
        while(!inputOK) {
            System.out.print("Please enter the cost of your groceries: "); 
            if (keyboard.hasNextDouble()) { 
                inputDouble = keyboard.nextDouble(); 
                inputOK = true;
                // compute the following values
                // preferably using a static method to compute the discount
                // percent
                int discPercent;
                double discount;
                
                if (inputDouble > 210) {	//more than $210
                	discPercent = 14; discount = inputDouble* discPercent/100.0;
                }
                else if (inputDouble > 150) {	//more than $150 to $210
                	discPercent = 12; discount = inputDouble* discPercent/100.0;
                }
                else if (inputDouble > 60) {	//more than $60 to $150
                	discPercent = 10; discount = inputDouble* discPercent/100.0;
                }
                else if (inputDouble >= 10) {	//from $10 to $60
                	discPercent = 8; discount = inputDouble* discPercent/100.0;
                }
                else {	//less than $10
                	discPercent = 0; discount = 0.0;
                }
                

                System.out.printf("You win a discount coupon of $%1.2f " +
                        "(%d%% of your purchase)\n", discount, discPercent);
            } else {
                String str = keyboard.nextLine(); 
                System.out.print("You typed \"" + str + ",\" which is " +
                        "not a number\n");
            }

        }
    }
}