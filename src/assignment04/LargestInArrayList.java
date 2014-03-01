package assignment04;
import java.util.ArrayList;
import java.util.Scanner;

/**
   This program reads a sequence of values and prints them, marking the largest value.
*/
public class LargestInArrayList
{
   public static void main(String[] args)
   {  
      ArrayList<Double> values = new ArrayList<Double>();

      // Read inputs

      System.out.println("Please enter values, Q to quit:");
      Scanner in = new Scanner(System.in);
//      while (in.hasNextDouble() && currentSize < values.length)
//      {  
//         values[currentSize] = in.nextDouble();
//         currentSize++;
//      }
//      in.close();
      
      while (in.hasNext()) {
    	  if (in.hasNextDouble()) {
    		  values.add(in.nextDouble());
    	  }
    	  else if (in.hasNext("Q") || in.hasNext("q")) {
    		  break;
    	  }
    	  else {
    		  ////////////////////////////////////////////////what's wrong here?!?!?!?!?!?
    		  System.out.println("Please enter a double number, 'Q' or 'q' to quit.");
    		  in.next();
    	  }
      }

      // Find the largest value

      double largest = values.get(0);
      for (int i = 1; i < values.size(); i++)
      {
         if (values.get(i) > largest)
         {
            largest = values.get(i);
         }
      }

      // Print all values, marking the largest

      for (int i = 0; i < values.size(); i++)
      {  
         System.out.print(values.get(i));
         if (values.get(i) == largest) 
         {
            System.out.print(" <== largest value");
         }
         System.out.println();
      }
      in.close();
   }
}
