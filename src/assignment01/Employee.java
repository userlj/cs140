package assignment01;
/**
 * An employee has a person, company name, company address, 
 * salary and job title information.
 * @author Lingjie Meng
 */
public class Employee {
	private Person person;
	private String companyName;
	private Address companyAddress;
	private double salary;
	private String jobTitle;
	/**
	 * Constructs with all the information of an employee.
	 * @param person person has a lastname, firstname, address, ssn and date of birth
	 * @param companyName the company name in which the person work
	 * @param companyAddress the company address of which the person work
	 * @param salary the salary of the person
	 * @param jobTitle the jobtitle of the person
	 */
	public Employee(Person person, String companyName, Address companyAddress,
			double salary, String jobTitle) {
		super();
		this.person = person;
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.salary = salary;
		this.jobTitle = jobTitle;
	}
	/**
	 * Gets the person's lastname, firstname, address, ssn and date of birth
	 * @return the person
	 */
	public Person getPerson() {
		return this.person;
	}
	/**
	 * Sets the person's lastname, firstname, address, ssn and date of birth
	 * @param person the person to set
	 */
//	public void setPerson(Person person) {
//		this.person = person;
//	}
	/**
	 * Gets the company name 
	 * @return the companyName
	 */
	public String getCompanyName() {
		return this.companyName;
	}
	/**
	 * Sets the company name
	 * @param companyName the companyName to set
	 */
//	public void setCompanyName(String companyName) {
//		this.companyName = companyName;
//	}
	/**
	 * Gets the address of the company
	 * @return the companyAddress
	 */
	public Address getCompanyAddress() {
		return this.companyAddress;
	}
	/**
	 * Sets the address of the company
	 * @param companyAddress the companyAddress to set
	 */
//	public void setCompanyAddress(Address companyAddress) {
//		this.companyAddress = companyAddress;
//	}
	/**
	 * Gets the salary of the employee
	 * @return the salary
	 */
	public double getSalary() {
		return this.salary;
	}
	/**
	 * Set the salary of the employee
	 * @param salary the salary to set
	 */
//	public void setSalary(double salary) {
//		this.salary = salary;
//	}
	/**
	 * Gets the job title of the employee
	 * @return the jobTitle
	 */
	public String getJobTitle() {
		return this.jobTitle;
	}
	/**
	 * Sets the job title of the employee
	 * @param jobTitle the jobTitle to set
	 */
//	public void setJobTitle(String jobTitle) {
//		this.jobTitle = jobTitle;
//	}
	/**
	 * Gets the salary raised by rate
	 * @param jobTitle the jobTitle to set
	 */
	public double getRaise(double rate) {
		salary = salary * (1 + rate/100.0);
		return salary;
	}
	
/*	public void getRaise(double percentage)
	{
		this.salary += salary * (percentage / 100.0);
	}
*/
}
