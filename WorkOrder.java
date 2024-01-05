/**
 * The WorkOrder class implements the Printable interface and contains the instance variables as well 
 * as methods used to construct a WorkOrder object.
 */
public class WorkOrder implements Printable{
	// Variable declaration
	private Employee employee;
	private Ticket ticket;
	private String createdAt;
	
	/**
	 * Public constructor used to create the object
	 * @param employee The Employee object.
	 * @param ticket The Ticket object.
	 * @param createdAt The String containing when the WorkOrder object was created.
	 */
	public WorkOrder(Employee employee, Ticket ticket, String createdAt) {
		
		this.employee = employee;
		this.ticket = ticket;
		this.createdAt = createdAt;
	}
	
	/**
	 * Gets the String with object data.
	 * @return The String containing the object data.
	 */
	@Override
	public String getFileData() {
		
		if(this.employee instanceof Tier2Employee) {
			
			return ticket.getFileData() + "," + getCreatedAt() + "," + ((Tier2Employee) employee).getFileData();
		}
		
		return ticket.getFileData() + "," + getCreatedAt() + "," + employee.getFileData();
	}
	
	/**
	 * Returns an Employee object.
	 * @return The Employee object.
	 */
	public Employee getEmployee() {
		
		return this.employee;
	}
	
	/**
	 * Sets the Employee object instance variable.
	 * @param employee The Employee object. 
	 */
	public void setEmployee(Employee employee) {
		
		this.employee = employee;
	}

	/**
	 * Returns a Ticket object.
	 * @return The Ticket object.
	 */
	public Ticket getTicket() {
		
		return this.ticket;
	}
	
	/**
	 * Sets the Ticket object instance variable.
	 * @param ticket The Ticket object. 
	 */
	public void setTicket(Ticket ticket) {
		
		this.ticket = ticket;
	}

	/**
	 * Returns the String containing when the WorkOrder object was created.
	 * @return The String containing when the WorkOrder object was created.
	 */
	public String getCreatedAt() {
		
		return this.createdAt;
	}

	/**
	 * Sets the createdAt instance variable.
	 * @param createdAt The String containing when the WorkOrder object was created.
	 */
	public void setCreatedAt(String createdAt) {
		
		this.createdAt = createdAt;
	}
}
