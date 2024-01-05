import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * The FileHandler class has most of the methods that are responsible for reading in employee data
 * and ticket data from the input files as well as writing to the output file in addition to the
 * logger file after processing has been done.
 */
public class FileHandler {
	
	/**
	 * Writes the data from the work order ArrayList to the output file as well as appending it to the
	 * logger file.
	 * @param workOrderFileName The String containing the name of the output file.
	 */
	public static void writeData(String workOrderFileName) {
		// Variable declaration
		PrintWriter output = null;
		
		logger("Writing Work Order Data to File"); // Calls method to write to the logger
		
		// Try block to catch any exceptions that may occur
		try {
			output = new PrintWriter(workOrderFileName);
		// All exceptions that are handled
		} catch (FileNotFoundException e) {
			System.out.println("*File does not exist or path was entered incorrectly.*");
		}
		
		// Writes the header to the output file
		output.println("customer_id,customer_first_name,customer_last_name,ticket_id,ticket_createdAt,workorder_createdAt,employee_id,employee_first_name,employee_last_name,clocked_in,certification");
		
		// For-Each loop to go through each value in the workOrder ArrayList
		for(WorkOrder workOrder : Project3.workOrderList) {
			
			// Writes all of the data to the output file and also calls the logger method
			output.println(workOrder.getFileData());
			logger(workOrder.getFileData());
		}
		
		logger("Work Orders Created. Program Exiting"); // Lets logger method know that work is done
		
		output.close(); // Closes the output file so that there are no issues
	}
	
	/**
	 * Gets data from the file that was passed to the method and stores the created Employee or
	 * Tier2Employee objects in the employeeList ArrayList. 
	 * @param employeeFileName The String containing the name of the file.
	 */
	public static void readEmployeeData(String employeeFileName) {
		// Variable declaration
		Scanner fileScanner = null;
		
		// Try block to catch any exceptions that may occur
		try {
			fileScanner = new Scanner(new FileReader(employeeFileName));
			String line = "";
			
			fileScanner.nextLine(); // Gets rid of the header line from the user file
			
			logger("Loading Employee Data");
			
			// While loop to keep reading and creating objects with data until file reaches the end
			while (fileScanner.hasNext()) {
				line = fileScanner.nextLine();
				String[] words = line.split(",");
				
				// Checks which type of employee object to create and add to the ArrayList
				if(words[8].equals("tier1")) {
					
					Project3.employeeList.add(new Employee(words[1], words[2], words[4], words[5], words[3], words[0], words[6], words[7]));
				}
				else {
					
					Project3.employeeList.add(new Tier2Employee(words[1], words[2], words[4], words[5], words[3], words[0], words[6], words[7], words[9])); 
				}
			}
		
		// All exceptions that are handled
		} catch (FileNotFoundException e) {
			System.out.println("*File does not exist or path was entered incorrectly.*");
		}
		
		fileScanner.close(); // Closes the scanner so that there are no issues
	}
	
	/**
	 * Gets data from the file that was passed to the method and stores the created ticket objects in
	 * an ArrayList.
	 * @param ticketFileName The String containing the name of the file.
	 * @return The Ticket LinkedList containing the ticket objects that were created.
	 */
	public static LinkedList<Ticket> readTicketData(String ticketFileName){
		// Variable declaration
		Scanner fileScanner = null;
		LinkedList<Ticket> ticketsList = new LinkedList<Ticket>();
		
		// Try block to catch any exceptions that may occur
		try {
			fileScanner = new Scanner(new FileReader(ticketFileName));
			String line = "";
			
			fileScanner.nextLine(); // Gets rid of the header line from the user file
			
			logger("Loading Ticket Data"); // Calls method to write to the logger file
			
			// While loop to keep reading and creating objects with data until file reaches the end
			while (fileScanner.hasNext()) {
				line = fileScanner.nextLine();
				String[] words = line.split(",");
				
				if(ticketFileName.equals("tier1_ticket_data.csv")) {
					
					ticketsList.add(new Ticket(new Customer(words[1], words[2], words[4], words[5], words[3], words[0], words[6]), words[8], words[7]));
				}
				else {
					
					ticketsList.add(new Ticket(new Customer(words[1], words[2], words[4], words[5], words[3], words[0], words[6]), words[8], words[7]));
				}		
			}
		
		// All exceptions that are handled
		} catch (FileNotFoundException e) {
			System.out.println("*File does not exist or path was entered incorrectly.*");
		}
		
		return ticketsList;
	}
	
	/**
	 * Writes any thing passed to the method to the log file along with the current date and time in
	 * a certain format, the file will be appended to rather than overwritten.
	 * @param log The String containing the name of the log file.
	 */
	private static void logger(String log) {
		// Variable declaration
		String logFile = "log.txt";
		PrintWriter output = null;
		
		// Creates new Date object and formats the date into the required form
		Date current = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		String currentFormatted = sdf.format(current);
		
		// Try block to catch any exceptions that may occur
		try {
			output = new PrintWriter(new FileWriter(logFile, true));
			output.println("log: " + currentFormatted + " : " + log);
			
		// All exceptions that are handled
		} catch (IOException e) {
			System.out.println("File could not be written or appended to");
		}
		
		output.close(); // Closes the output so that there are no issues
	}
}
