/**
 * The Employee class extends Person and implements the Printable interface and contains the
 * instance variables as well as methods used to construct an Employee object.
 */
public class Employee extends Person implements Printable{
	// Variable declaration
	private String employeeId;
	private String clockedIn;
	private String hiredDate;
	
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
	 */
	public Employee(String firstName, String lastName, String address, String phoneNumber, String email, String employeeId, String clockedIn, String hiredDate){
		
		super(firstName, lastName, address, phoneNumber, email);
		this.employeeId = employeeId;
		this.clockedIn = clockedIn;
		this.hiredDate = hiredDate;	
	}
	
	/**
	 * Gets the String with object data.
	 * @return The String containing the object data.
	 */
	@Override
	public String getFileData() {
		
		return getEmployeeId() + "," + super.getFileData() + "," + getClockedIn();
	}
	
	/**
	 * Returns the String containing the employee id.
	 * @return The String containing the employee id.
	 */
	public String getEmployeeId() {
		
		return this.employeeId;
	}
	
	/**
	 * Sets the employeeId instance variable.
	 * @param employeeId The String containing the employee id.
	 */
	public void setEmployeeId(String employeeId) {
		
		this.employeeId = employeeId;
	}
	
	/**
	 * Returns the String containing the clocked in information.
	 * @return The String containing the clocked in information.
	 */
	public String getClockedIn() {
		
		return this.clockedIn;
	}

	/**
	 * Sets the clockedIn instance variable.
	 * @param clockedIn The String containing the clocked in information.
	 */
	public void setClockedIn(String clockedIn) {
		
		this.clockedIn = clockedIn;
	}
	
	/**
	 * Returns the String containing the hire date.
	 * @return The String containing the hire date.
	 */
	public String getHiredDate() {
		
		return this.hiredDate;
	}
	
	/**
	 * Sets the hiredDate instance variable.
	 * @param hiredDate The String containing the hire date.
	 */
	public void setHiredDate(String hiredDate) {
		
		this.hiredDate = hiredDate;
	}
}
