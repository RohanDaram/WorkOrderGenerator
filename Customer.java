/**
 * The Customer class extends Person and implements the Printable interface and contains the
 * instance variables as well as methods used to construct a Customer object.
 */
public class Customer extends Person implements Printable{
	// Variable declaration
	private String customerId;
	private String accountNumber;

	/**
	 * Public constructor used to create the object
	 * @param firstName The String containing the first name.
	 * @param lastName The String containing the last name.
	 * @param address The String containing the address.
	 * @param phoneNumber The String containing the phone number.
	 * @param email The String containing the email.
	 * @param customerId The String containing the customer id.
	 * @param accountNumber The String containing the account number.
	 */
	public Customer(String firstName, String lastName, String address, String phoneNumber, String email, String customerId, String accountNumber){
		
		super(firstName, lastName, address, phoneNumber, email);
		this.customerId = customerId;
		this.accountNumber = accountNumber;		
	}
	
	/**
	 * Gets the String with object data.
	 * @return The String containing the object data.
	 */
	@Override
	public String getFileData() {
		
		return getCustomerId() + "," + super.getFileData();
	}
	
	/**
	 * Returns the String containing the customer id.
	 * @return The String containing the customer id.
	 */
	public String getCustomerId() {
		
		return this.customerId;
	}
	
	/**
	 * Sets the customerId instance variable.
	 * @param customerId The String containing the customer id.
	 */
	public void setCustomerId(String customerId) {
		
		this.customerId = customerId;
	}
	
	/**
	 * Returns the String containing the account number.
	 * @return The String containing the account number.
	 */
	public String getAccountNumber() {
		
		return this.accountNumber;
	}
	
	/**
	 * Sets the accountNumber instance variable.
	 * @param accountNumber The String containing the account number.
	 */
	public void setAccountNumber(String accountNumber) {
		
		this.accountNumber = accountNumber;
	}
}
