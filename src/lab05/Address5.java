package lab05;
/**
 * An address has the street, city, zip and country infromation.
 * @author CS140
 */
public class Address5 {
	private int streetNum;
	private String street1;
	private String street2;
	private String city;
	private String zip;
	private String country;
	/**
	 * Constructs and address with all the information of a
	 * mailing address.
	 * @param streetNum number on first line of street address
	 * @param street1 name of first line of street address
	 * @param street2 second line of street address
	 * @param city name of the city
	 * @param zip the zip-code
	 * @param country the country the city is in
	 */
	public Address5(int streetNum, String street1, String street2, 
			String city, String zip, String country) {
		this.streetNum = streetNum;
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.zip = zip;
		this.country = country;
	}

	/**
	 * Gets the number on the first line of the address
	 * @return number on the first line of street address
	 */
	public int getStreetNum() {
		return streetNum;
	}

	/**
	 * Gets the name of the first line of the address
	 * @return name of first line of street address
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

	public String toString() {
		StringBuilder text = new StringBuilder();
		text.append(streetNum + " " + street1 + "\n");
		if(street2 != null && street2.length() > 0) {
			text.append(street2 + "\n");
		}
		text.append(city + ", " + zip + "\n");
		text.append(country);
		return text.toString();
	}
	
	// ZIP CODES DO NOT MATCH TOWNS!
	public Address5[] getRandomUSaddresses(int number) {
		Address5[] retVal = new Address5[number]; 
		for(int i = 0; i < retVal.length; i++) {
			retVal[i] = new Address5((int)Math.round(1+1000*Math.random()),
					NamesResource.getRandomUSstreet(),
						"", 
						NamesResource.getRandomUStown(),
						"" + (int)Math.round(1+99998*Math.random()),
						"USA");
		}
		return retVal;

	}
}
