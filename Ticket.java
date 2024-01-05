/**
 * The Ticket class implements the Printable interface and contains the instance variables as well as 
 * methods used to construct a Ticket object.
 */
public class Ticket implements Printable{
	// Variable declaration
	private Customer customer;
	private String createdAt;
	private String ticketId;
	
	/**
	 * Public constructor used to create the object
	 * @param customer The Customer object.
	 * @param createdAt The String containing when the Ticket object was created.
	 * @param ticketId The String containing the ticket id.
	 */
	public Ticket(Customer customer, String createdAt, String ticketId) {
		
		this.customer = customer;
		this.createdAt = createdAt;
		this.ticketId = ticketId;
	}
	
	/**
	 * Gets the String with object data.
	 * @return The String containing the object data.
	 */
	@Override
	public String getFileData() {
		
		return customer.getFileData() + "," + getTicketId() + "," + getCreatedAt();
	}
	
	/**
	 * Returns a Customer object.
	 * @return The Customer object.
	 */
	public Customer getCustomer() {
		
		return this.customer;
	}
	
	/**
	 * Sets the Customer object instance variable.
	 * @param customer The Customer object. 
	 */
	public void setCustomer(Customer customer) {
		
		this.customer = customer;
	}
	
	/**
	 * Returns the String containing when the Ticket object was created.
	 * @return The String containing when the Ticket object was created.
	 */
	public String getCreatedAt() {
		
		return this.createdAt;
	}

	/**
	 * Sets the createdAt instance variable.
	 * @param createdAt The String containing when the Ticket object was created.
	 */
	public void setCreatedAt(String createdAt) {
		
		this.createdAt = createdAt;
	}

	/**
	 * Returns the String containing the ticket id.
	 * @return The String containing the ticket id.
	 */
	public String getTicketId() {
		
		return this.ticketId;
	}

	/**
	 * Sets the ticketId instance variable.
	 * @param ticketId The String containing the ticket id.
	 */
	public void setTicketId(String ticketId) {
		
		this.ticketId = ticketId;
	}
}
