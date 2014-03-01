package ch03.section_4;
/**
   A bank account has a balance that can be changed by 
   deposits and withdrawals. It also has an account number
   and the name and address of the account owner.
 */
public class BankAccount {  
	private double balance;
	private String name;
	private Address address;
	private int accNumber;

	/**
      Constructs a bank account with an account number, an account owner and
      a zero balance 
 	  @param name account owner
	  @param address address of account owner
	  @param accNumber number of the account
	 */
	public BankAccount(String name, Address address, int accNumber) {
		this.name = name;
		this.address = address;
		this.accNumber = accNumber;
	}

	/**
    Constructs a bank account with an account number, an account owner and
    a given balance 
      @param initialBalance the initial balance
	  @param name account owner
	  @param address address of account owner
	  @param accNumber number of the account
	 */
	public BankAccount(double initialBalance, String name, 
			Address address, int accNumber) {
		balance = initialBalance;
		this.name = name;
		this.address = address;
		this.accNumber = accNumber;
	}

	/**
      Deposits money into the bank account.
      @param amount the amount to deposit
	 */
	public void deposit(double amount) {  
		balance = balance + amount;
	}

	/**
      Withdraws money from the bank account.
      @param amount the amount to withdraw
	 */
	public void withdraw(double amount) {   
		balance = balance - amount;
	}

	/**
      Gets the current balance of the bank account.
      @return the current balance
	 */
	public double getBalance() {   
		return balance;
	}

	/**
     Gets the name of the account owner.
     @return the owner's name
	 */
	public String getName() {
		return name;
	}

	/**
     Gets the address of the account owner.
     @return the owner's address
	 */
	public Address getAddress() {
		return address;
	}

	/**
     Gets the account number.
     @return the account number
	 */
	public int getAccNumber() {
		return accNumber;
	}

	/**
	  Sets a new name on the account.
	  @param name new name for the account
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	  Changes the address of the account owner
	 * @param address new address for the account owner
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

}
