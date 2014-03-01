package ch03.section_4;
/**
 * An address has the street, city, zip and country 
 * information.
 * @author CS140
 */
public class Address {
	private String street1;
	private String street2;
	private String city;
	private String zip;
	private String country;

	/**
	 * Constructs and address with all the information of a
	 * mailing address.
	 * @param street1 first line of street address
	 * @param street2 second line of street address
	 * @param city name of the city
	 * @param zip the zip-code
	 * @param country the country the city is in
	 */
	public Address(String street1, String street2, String city, String zip,
			String country) {
		super();
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.zip = zip;
		this.country = country;
	}
	
	/**
	 * Gets the first line of the address
	 * @return first line of street address
	 */
	public String getStreet1() {
		return street1;
	}

	/**
	 * Gets the second line of the address
	 * @return second line of street address
	 */
	public String getStreet2() {
		return street2;
	}
	
	/**
	 * Gets the city of the address
	 * @return the city name
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Gets the zip-code of the address
	 * @return the zip-code
	 */
	public String getZip() {
		return zip;
	}
	
	/**
	 * Gets the country where the city is
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	
}
