package assignment08;
import java.util.Scanner;
import invoice.Address;
import invoice.Invoice;
import invoice.Product;


public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// address
		Scanner input = new Scanner(System.in);
		String aName;
		String aStreet;
        String aCity;
        String aState;
        String aZip;
        System.out.print("Enter address \nEnter name: ");
        aName = input.next();
        System.out.print("Enter street: ");
        aStreet = input.next();
        System.out.print("Enter city: ");
        aCity = input.next();
        System.out.print("Enter state: ");
        aState = input.next();
        System.out.print("Enter zip: ");
        aZip = input.next();
        Address address = new Address(aName, aStreet,
                aCity, aState, aZip);
        
        // product1
        String aDescription1;
        double aPrice1;
        System.out.print("Enter product1 \nEnter description1: ");
        aDescription1 = input.next();
        System.out.print("Enter price1: ");
        aPrice1 = input.nextDouble();
        Product product1 = new Product(aDescription1, aPrice1);
        
        System.out.print("Enter quantity1: ");
        int aQuantity1 = input.nextInt();
        
        // product2
        String aDescription2;
        double aPrice2;
        System.out.print("Enter product2 \nEnter description2: ");
        aDescription2 = input.next();
        System.out.print("Enter price2: ");
        aPrice2 = input.nextDouble();
        Product product2 = new Product(aDescription2, aPrice2);
        
        System.out.print("Enter quantity2: ");
        int aQuantity2 = input.nextInt();
        
        // product3
        String aDescription3;
        double aPrice3;
        System.out.print("Enter product3 \nEnter description3: ");
        aDescription3 = input.next();
        System.out.print("Enter price3: ");
        aPrice3 = input.nextDouble();
        Product product3 = new Product(aDescription3, aPrice3);
        
        System.out.print("Enter quantity3: ");
        int aQuantity3 = input.nextInt();
        
		Invoice invoice = new Invoice(address);
		invoice.add(product1, aQuantity1);
		invoice.add(product2, aQuantity2);
		invoice.add(product3, aQuantity3);
		
		input.close();
	}

}
