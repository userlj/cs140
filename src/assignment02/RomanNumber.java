package assignment02;

import java.util.Scanner;

public class RomanNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in); //why warning???
        boolean inputOK = false; 
        while(!inputOK) {
        	System.out.print("Please enter an integer less than 4000: "); 
            if (keyboard.hasNextInt()) { 
                int inputNum = keyboard.nextInt(); 
                ToString tostring = new ToString(inputNum);
                System.out.println(tostring);
                inputOK = true;
            } else {
            String str = keyboard.nextLine(); 
            System.out.print("You typed \"" + str + ",\" which is " +
                    "not a number\n");
            }
        }
	}
}
