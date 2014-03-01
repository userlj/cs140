package lab05;

import java.text.DateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

/**
 * Class Person has a simple representation of a Person. The class
 * stores the first and last name, and the date and place of the 
 * Person's birth. 
 * @author CS 140
 *
 */
public abstract class Person5 {
	private String firstName;
	private String lastName;
	private String id;
	private Date dateOfBirth;
	private String cityOfBirth;
	private String countryOfBirth;
	private static DateFormat dateFormatter = 
		DateFormat.getDateInstance(
				DateFormat.DEFAULT, new Locale("en","US"));
	
	@Override
	public int hashCode() {
		int h = 0;
		int h1 = id.hashCode();
		int h2 = cityOfBirth.hashCode();
		int h3 = countryOfBirth.hashCode();
		int h4 = dateOfBirth.hashCode();
		int MULTIPLIER = 31;
		h = MULTIPLIER * h1 + h2;
		h = MULTIPLIER * h + h3;
		h = MULTIPLIER * h + h4;
		return h;
	}

	/**
	 * The null-argument package-private constructor is for the use 
	 * of classes in this package only, for example JUnit tests.  
	 */
	Person5() {		
	}
	
	/**
	 * Constructor for a Person object. The values of the parameters
	 * are copied to the fields of the new object created by the 
	 * constructor. 
	 * @param firstName the first name of the person
	 * @param lastName the last name of the person
	 * @param dateOfBirth the date of birth of the person
	 * @param cityOfBirth the city where the person was born
	 * @param countryOfBirth the country where the person was born
	 */
	public Person5(String firstName, String lastName, Date dateOfBirth,
			String cityOfBirth, String countryOfBirth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.cityOfBirth = cityOfBirth;
		this.countryOfBirth = countryOfBirth;
	}

	/**
	 * Constructor for a Person object. The values of the parameters
	 * are copied to the fields of the new object created by the 
	 * constructor. 
	 * @param firstName the first name of the person
	 * @param lastName the last name of the person
	 * @param id the ID of the person
	 * @param dateOfBirth the date of birth of the person
	 * @param cityOfBirth the city where the person was born
	 * @param countryOfBirth the country where the person was born
	 */
	public Person5(String firstName, String lastName, 
			String id, Date dateOfBirth,
			String cityOfBirth, String countryOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.dateOfBirth = dateOfBirth;
		this.cityOfBirth = cityOfBirth;
		this.countryOfBirth = countryOfBirth;
	}

	/**
	 * Getter method for the first name
	 * @return the firstName instance variable
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Setter method for the id instance variable
	 * @param id value of the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Getter method for the last name
	 * @return the lastName instance variable
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Getter method for the id 
	 * @return the person's id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Returns the gender of this person.
	 */
	public abstract Gender getGender();

	/**
	 * Getter method for the person's name, formed by combining the
	 * first and last name
	 * @return the person's name
	 */
	public String getName() {
		return firstName + " " + lastName;
	}
	
	/**
	 * Getter method for the person's date of birth
	 * @return the date of birth of the person
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	/**
	 * Getter method for the city where the person was born
	 * @return the city where the person was born
	 */
	public String getCityOfBirth() {
		return cityOfBirth;
	}
	
	/**
	 * Getter method for the country where the person was born
	 * @return the county where the person was born
	 */
	public String getCountryOfBirth() {
		return countryOfBirth;
	}    
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " [firstName=" + firstName 
				+ ", lastName=" + lastName + ", id=" + id + ", dateOfBirth=" 
				+ dateFormatter.format(dateOfBirth)
				+ ", cityOfBirth=" + cityOfBirth + ", countryOfBirth="
				+ countryOfBirth + ", hashcode=" + hashCode()+ "]";
	}

	public static Person5[] getRandomUSborn(int number) {
		Person5[] retVal = new Person5[number]; 
		for(int i = 0; i < retVal.length; i++) {
			if(Math.random() > 0.5) {
				retVal[i] = new Woman5(NamesResource.getRandomFirstName(),
						NamesResource.getRandomLastName(), 
						NamesResource.getRandomID(),
						NamesResource.getRandomBirthDate(),
						NamesResource.getRandomUStown(),
						"USA");
			} else {
				retVal[i] = new Man5(NamesResource.getRandomFirstName(),
						NamesResource.getRandomLastName(), 
						NamesResource.getRandomID(),
						NamesResource.getRandomBirthDate(),
						NamesResource.getRandomUStown(),
						"USA");
			}
		}
		return retVal;
	}

	public static class FirstNameComp implements Comparator<Person5> {
		@Override
		public int compare(Person5 arg0, Person5 arg1) {
			return arg0.firstName.compareToIgnoreCase(arg1.firstName);
		}
	}

	public static class DOBComp implements Comparator<Person5> {
		@Override
		public int compare(Person5 arg0, Person5 arg1) {
			return arg0.dateOfBirth.compareTo(arg1.dateOfBirth);
		}
	}
	
	public static class IdComp implements Comparator<Person5> {
		@Override
		public int compare(Person5 arg0, Person5 arg1) {
			return arg0.id.compareToIgnoreCase(arg1.id);
		}
	}
	
	public static class LastNameComp implements Comparator<Person5> {
		@Override
		public int compare(Person5 arg0, Person5 arg1) {
			return arg0.lastName.compareToIgnoreCase(arg1.lastName);
		}
	}
	
	public static class CityOfBirthComp implements Comparator<Person5> {
		@Override
		public int compare(Person5 arg0, Person5 arg1) {
			return arg0.cityOfBirth.compareToIgnoreCase(arg1.cityOfBirth);
		}
	}
	
	public static class CountryOfBirthComp implements Comparator<Person5> {
		@Override
		public int compare(Person5 arg0, Person5 arg1) {
			return arg0.countryOfBirth.compareToIgnoreCase(arg1.countryOfBirth);
		}
	}
}