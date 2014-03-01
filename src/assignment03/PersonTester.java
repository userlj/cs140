package assignment03;

public class PersonTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Address[] peraddr = {
				new Address("100 Main St","","Binghamton","NY 13905","USA"),
				new Address("200 Main St","","Binghamton","NY 13905","USA"),
				new Address("123 Helen St","","Binghamton","NY 13850","USA"),
				new Address("300 Main St","","Binghamton","NY 13905","USA")
				};
		Person[] perarr = {
				new Person("Meng","Lingjie",peraddr[0],"012-345-6789","1990-04-03"),
				new Person("Ellen","Mary",peraddr[1],"012-345-6789","1949-10-01"),
				new Person("Morgan","Derek",peraddr[3],"012-345-6789","1996-01-28"),
				new Person("Obama","Barack",peraddr[2],"012-345-6789","1988-07-15")

				};
		System.out.println(Person.longestLastName(perarr));
	}
}
