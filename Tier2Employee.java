/**
 * The Tier2Employee class extends Employee and implements the Printable interface and contains the
 * instance variables as well as methods used to construct a Tier2Employee object.
 */
public class Tier2Employee extends Employee implements Printable{
	// Variable declaration
	private String certification;
	
	/**
	 * Public constructor used to create the object
	 * @param firstName The String containing the first name.
	 * @param lastName The String containing the last name.
	 * @param address The String containing the address.
	 * @param phoneNumber The String containing the phone number.
	 * @param email The String containing the email.
	 * @param employeeId The String containing the employee id.
	 * @param clockedIn The String containing the clocked in information.
	 * @param hiredDate The String containing the hire date.
	 * @param certification The String containing the certification of the employee.
	 */
	public Tier2Employee(String firstName, String lastName, String address, String phoneNumber, String email, String employeeId, String clockedIn, String hiredDate, String certification){
		
		super(firstName, lastName, address, phoneNumber, email, employeeId, clockedIn, hiredDate);
		this.certification = certification;
	}
	
	/**
	 * Gets the String with object data.
	 * @return The String containing the object data.
	 */
	@Override
	public String getFileData() {
		
		return super.getFileData() + "," + getCertification();
	}

	/**
	 * Returns the String containing the certification that the employee has.
	 * @return The String containing the certification that the employee has.
	 */
	public String getCertification() {
		
		return this.certification;
	}
	
	/**
	 * Sets the certification instance variable.
	 * @param certification The String containing the certification that the employee has.
	 */
	public void setCertification(String certification) {
		
		this.certification = certification;
	}
}
