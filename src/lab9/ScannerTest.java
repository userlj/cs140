package lab9;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new FileReader("test1.txt"));
//            int i = input.nextInt();
            int i = 0;
            if (input.hasNextInt()) {
                input.nextInt();
            }
            String str = input.next();
            System.out.println(str);
            input.close();
            String str1 = input.next();
        } 
        catch(FileNotFoundException ex) {
        	System.out.println(ex);
        	System.out.println(ex.getMessage());
        }
        catch(InputMismatchException ex) {
        	System.out.println(ex);
        	System.out.println(ex.getMessage());
        	System.out.println(ex + "is coming from parsing something that is not an int");
        }
        catch(NoSuchElementException ex) {
        	System.out.println(ex);
        	System.out.println(ex.getMessage());
        	System.out.println(ex + "nothing (more) in the file");
        }
        catch(IllegalStateException ex) {
        	System.out.println(ex + "--after scanner is closed");
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }        
    }
}
