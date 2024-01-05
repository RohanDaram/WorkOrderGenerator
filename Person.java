/**
 * The Person class implements the Printable interface and contains the instance variables as well as 
 * methods used to construct a Person object.
 */
public class Person implements Printable{
	// Variable declaration
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private String email;
	
	/**
	 * Public constructor used to create the object
	 * @param firstName The String containing the first name.
	 * @param lastName The String containing the last name.
	 * @param address The String containing the address.
	 * @param phoneNumber The String containing the phone number.
	 * @param email The String containing the email.
	 */
	public Person(String firstName, String lastName, String address, String phoneNumber, String email){
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	/**
	 * Gets the String with object data.
	 * @return The String containing the object data.
	 */
	@Override
	public String getFileData() {

		return getFirstName() + "," + getLastName();
	}
	
	/**
	 * Returns the String containing the first name.
	 * @return The String containing the first name.
	 */
	public String getFirstName() {
		
		return this.firstName;
	}
	
	/**
	 * Sets the firstName instance variable.
	 * @param firstName The String containing the first name.
	 */
	public void setFirstName(String firstName) {
		
		this.firstName = firstName;
	}
	
	/**
	 * Returns the String containing the last name.
	 * @return The String containing the last name.
	 */
	public String getLastName() {
		
		return this.lastName;
	}
	
	/**
	 * Sets the lastName instance variable.
	 * @param lastName The String containing the last name.
	 */
	public void setLastName(String lastName) {
		
		this.lastName = lastName;
	}
	
	/**
	 * Returns the String containing the address.
	 * @return The String containing the address.
	 */
	public String getAddress() {
		
		return this.address;
	}
	
	/**
	 * Sets the address instance variable.
	 * @param address The String containing the address.
	 */
	public void setAddress(String address) {
		
		this.address = address;
	}
	
	/**
	 * Returns the String containing the phone number.
	 * @return The String containing the phone number.
	 */
	public String getPhoneNumber() {
		
		return this.phoneNumber;
	}
	
	/**
	 * Sets the phoneNumber instance variable.
	 * @param phoneNumber The String containing the phone number.
	 */
	public void setPhoneNumber(String phoneNumber) {
		
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * Returns the String containing the email.
	 * @return The String containing the email.
	 */
	public String getEmail() {
		
		return this.email;
	}
	
	/**
	 * Sets the email instance variable.
	 * @param email The String containing the email.
	 */
	public void setEmail(String email) {
		
		this.email = email;
	}
}
