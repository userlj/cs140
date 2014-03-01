package assignment01;


/**
 * A person has a lastname, firstname, address, 
 * ssn and date of birth information.
 * @author Lingjie Meng
 */
public class Person {
	private String lastNames;
	private String firstNames;
	private Address address;
	private String ssn;	// has the format "012-345-6789"
	private String dob;	// has the format "yyyy-mm-dd" which is a typical default for databases

	/**
	 * Constructs with all the information of a person.
	 * @param lastNames lastname of account owner
	 * @param fristNames firstname of account owner
	 * @param address address if account owner
	 * @param ssn social security number of account owner
	 * @param dob date of bank account
	 */
	public Person(String lastNames, String fristNames, Address address,
			String ssn, String dob) {
		super();
		this.lastNames = lastNames;
		this.firstNames = fristNames;
		this.address = address;
		
        if(badSSN(ssn)) {
            System.out.println("Social Security Number \"" + ssn + "\" is the " +
                    "wrong format, will use 012-345-6789" );
            ssn = "012-345-6789";
        } else {
            this.ssn = ssn;
        }
		
        if(badDOB(dob)) {
            System.out.println("Date of birth \"" + dob + "\" is the " +
                    "wrong format, will use 2000-01-01" );
            dob = "2000-01-01";
        } else {
            this.dob = dob;
        }
/*        if(badDOB1(dob)) {
            System.out.println("Date of birth \"" + dob + "\" is the " +
                    "wrong format, will use 2000-01-01" );
            dob = "2000-01-01";
        } else {
            this.dob = dob;
        }
*/	}

    private static boolean badSSN(String ssn) {
        boolean retVal = true;

        if(ssn.length() == 12
                && Character.isDigit(ssn.charAt(0)) 
                && Character.isDigit(ssn.charAt(1))
                && Character.isDigit(ssn.charAt(2))
                && ssn.charAt(3) == '-'
                && Character.isDigit(ssn.charAt(4))
                && Character.isDigit(ssn.charAt(5))
                && Character.isDigit(ssn.charAt(6))
                && ssn.charAt(7) == '-'
                && Character.isDigit(ssn.charAt(8))
                && Character.isDigit(ssn.charAt(9))
                && Character.isDigit(ssn.charAt(10))
                && Character.isDigit(ssn.charAt(11))
                ) {
            retVal = false;
        }
        return retVal;
    }
    // This is uses the class documented at
    // http://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
/*    private static boolean badDOB1(String dob) {
        Pattern p = Pattern.compile("\\d{4}\\-\\d{2}\\-\\d{2}");
        Matcher m = p.matcher(dob);
        return !m.matches();
    }*/
    private static boolean badDOB(String dob) {
        boolean retVal = true;

        if(dob.length() == 10
                && Character.isDigit(dob.charAt(0)) 
                && Character.isDigit(dob.charAt(1))
                && Character.isDigit(dob.charAt(2))
                && Character.isDigit(dob.charAt(3))
                && dob.charAt(4) == '-'
                // finish this to check chars 5 through 9
                && Character.isDigit(dob.charAt(5))
                && Character.isDigit(dob.charAt(6))
                && dob.charAt(7) == '-'
                && Character.isDigit(dob.charAt(8))
                && Character.isDigit(dob.charAt(9))
                ) {
            retVal = false;
        }
        return retVal;
    }

	/**
	 * Gets account owner's lastname
	 * @return the lastNames
	 */
	public String getLastNames() {
		return lastNames;
	}

	/**
	 * Changes account owner's lastname
	 * @param lastNames the lastNames to set
	 */
	public void changeLastNames(String lastNames) {
		this.lastNames = lastNames;
	}

	/**
	 * Gets account owner's firstname
	 * @return the fristNames
	 */
	public String getFirstNames() {
		return firstNames;
	}

	/**
	 * Changes account owner's firstname
	 * @param fristNames the fristNames to set
	 */
	public void changeFirstNames(String firstNames) {
		this.firstNames = firstNames;
	}

	/**
	 * Gets the address
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Changes the address
	 * @param address the address to set
	 */
	public void changeAddress(Address address) {
		this.address = address;
	}

	/**
	 * Gets the ssn
	 * @return the ssn
	 */
	public String getSsn() {
		return ssn;
	}


	/**
	 * Gets the date of birth
	 * @return the date of birth
	 */
	public String getDob() {
		return dob;
	}
	
	
	//******************************************************
	public String getStreet1()
	{
		return this.address.getStreet1();
	}

	public String getStreet2()
	{
		return this.address.getStreet2();
	}

	public String getCity()
	{
		return this.address.getCity();
	}

	public String getZip()
	{
		return this.address.getZip();
	}

	public String getCountry()
	{
		return this.address.getCountry();
	}
//***********************************************************


	public String toString() {
        StringBuilder text = new StringBuilder();
        text.append("Lastname: " + lastNames + "\n");
        text.append("Firstname: " + firstNames + "\n");
        text.append("Address:\n" + address + "\n");
        text.append("Ssn: " + ssn + "\n");
        text.append("Date of birth: " + dob);
        return text.toString();
	}

}
