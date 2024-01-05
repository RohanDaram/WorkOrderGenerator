/*
 * Author:	  Sai Rohan Daram
 * Title:	  Work Order Generator
 * 
 * Takes in three input files from the user, which includes employee data as well as tier 1 and
 * tier 2 ticket data. Program will then attempt to read in data from the three files and make
 * work order objects which will then be written to a work order output file. Everything that happens
 * in the program will also be written to a separate log file containing the current date and time.
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Takes in the three input files as well as the name of the output file, program will then process
 * the information by calling upon multiple methods and store the data in multiple ArrayLists and
 * Queues. Then the this class will attempt to create work order objects with the information and add
 * them to an ArrayList containing work orders which will finally be written to the output file.
 */
public class Project3 {
	
	public static String employeeFileName;
	public static String tier1TicketFileName;
	public static String tier2TicketFileName;
	public static String workOrderFileName;
	public static ArrayList<Employee> employeeList = new ArrayList<Employee>();
	public static Queue<Ticket> tier1TicketFile = new LinkedList<Ticket>();
	public static Queue<Ticket> tier2TicketFile = new LinkedList<Ticket>();
	public static ArrayList<WorkOrder> workOrderList = new ArrayList<WorkOrder>();

	public static void main(String[] args) {
		
		// Stores the names of all the input and output files in their respective variable
		employeeFileName = "employee_data.csv";
		tier1TicketFileName = "tier1_ticket_data.csv";
		tier2TicketFileName = "tier2_ticket_data.csv";
		workOrderFileName = "workorder_data.csv";
		
		System.out.println("Project 3 Work Order Generator\n");
		
		System.out.println("Loading Employee Data");
		// Calls method to read employee data by passing in the corresponding file name
		FileHandler.readEmployeeData(employeeFileName);
		
		System.out.println("Loading Ticket Data");
		// Calls method to process the ticket data and store it inside the respective ArrayList
		tier1TicketFile = FileHandler.readTicketData(tier1TicketFileName);
		tier2TicketFile = FileHandler.readTicketData(tier2TicketFileName);
		
		System.out.println("Creating Work Orders");
		// Calls method to create work orders and store them in the respective ArrayList
		createWorkOrders();
		
		System.out.println("Writing Work Order Data to File");
		
		FileHandler.writeData(workOrderFileName); // Calls method to write data to the output file
	
		System.out.println("Work Orders Created. Program Exiting");
	}
	
	/**
	 * Differentiates between the two tiers of employees and makes corresponding work order objects
	 * by assigning each employee the correct ticket as well as the time the ticket was created. The
	 * objects are then stored in the work order ArrayList.
	 */
	public static void createWorkOrders() {
		// Creates new Date object and formats the date into the required form
		Date current = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		String currentFormatted = sdf.format(current);
		
		// Variable declaration
		ArrayList<Tier2Employee> tier2Employees = new ArrayList<Tier2Employee>();
		ArrayList<Employee> tier1Employees = new ArrayList<Employee>();
		
		// For-Each loop to go through each value in the employeeList ArrayList
		for(Employee emp : employeeList) {
			
			if(emp instanceof Tier2Employee) {
				
				// Adds employee object to Tier2Employee ArrayList if it is a Tier2Employee object 
				tier2Employees.add((Tier2Employee) emp);
			}
			else {
				
				// Adds employee object to Tier1Employee ArrayList if it is a normal Employee object
				tier1Employees.add(emp);
			}
		}
		
		int t2 = 0; // Sets tier 2 employee index to 0
		// For-Each loop to go through each value in the tier2TicketFile ArrayList
		for (Ticket tier2 : tier2TicketFile) {
			
			Tier2Employee tier2Employee = null;
			
			if(t2 < tier2Employees.size()) {
				
				tier2Employee = tier2Employees.get(t2); // Gets the employee object at index  
				t2++;
			}
			else {
				
				// If the index is higher than the size of the ArrayList goes back to first employee
				t2 = 0;
				tier2Employee = tier2Employees.get(t2); // Gets the employee object at index 
				t2++;
			}
			
			// Adds the new WorkOrder object that is created to the corresponding ArrayList 
			workOrderList.add(new WorkOrder(tier2Employee, tier2, currentFormatted));
		}
		
		int t1 = 0; // Sets tier 1 employee index to 0
		// For-Each loop to go through each value in the tier1TicketFile ArrayList
		for (Ticket tier1 : tier1TicketFile) {
			
			Employee employee = null;
			if(t1 < tier1Employees.size()) {
				
				employee = tier1Employees.get(t1); // Gets the employee object at index  
				t1++;
			}
			else {
				
				// If the index is higher than the size of the ArrayList goes back to first employee
				t1 = 0;
				employee = tier1Employees.get(t1); // Gets the employee object at index
				t1++;
			}
			
			// Adds the new WorkOrder object that is created to the corresponding ArrayList
			workOrderList.add(new WorkOrder(employee, tier1, currentFormatted));
		}
	}
	
}
