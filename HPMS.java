import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
*<h1>Happy pets management system<h1>
*this is a terminal application which allows the user to parse and print json data from
*the happy pets veterinary hospital web database
*@authors Greyson Blanchard, Steven Herd, Collin Moran, Malcolm Watts, Mason White (in alphabetical order) 
*@version 1.0
*@since 2020-05-13
*/

public class HPMS {

	//ARGUMENT AND VARIABLE DECLARATION
	//Aceepted user arguments
    final static String BILLING = "--billing";
    final static String PORTAL = "--patient-portal";
    final static String CUSTOMER = "--customer-id";
    
    /*
     * examples of acceptable user inputs:
     * HPMS --Billing 
     * HPMS --patient portal
     * HPMS --customer-id ######## --Billing
     * HPMS --Patient-portal --customer-id ##########
     * 
     * customer-id may appear before or after Billing and patient-portal, but must always be immediately followed by an integer
     */
	
	//Error statement
	final static String ERROR = "Error: Incorrect format of arguments.";
	
    //Booleans for checking    
    public static boolean billGo = false;
    public static boolean portGo = false;
	public static boolean idPresent = false;
	public static boolean lineRead = false;
	
    //Integer for holding ID number
    public static int cust_id = 0;
    
    //ARGUMENT CHECK
    //check if there are too few or too many arguments
    //check static variables portgo, billgo, and custgo if the user used said arguments
    public static void argsCheck(String[] args)
    {
    	/**
		 * this method is used to statically "check" the portgo, billgo, and custgo boolean variables
		 * as well as find an integer to use to find the customer id number entered as user input
		 * @param args 
		 * accepts an array(in computer terms, not a wide variety, in fact this program doesn't accept that many arguments)
		 * of arguments, the same ones the user entered, i.e. the user arguments are plugged directly into this method 
		 */
    	//If argument has too few or too many inputs: ERROR
    	if(args.length == 0 || args.length > 4)
    	{
    		System.out.println(ERROR + " Too few or too many arguments.");
    		System.exit(1);
    	}
    	//Determine which arguments are passed
    	for(int i = 0; i<args.length; i++)
    	{
    		if(args[i].equals(BILLING))// check billing boolean if billing user argument is used
    		{
    			billGo = true;
    		}
    		else if(args[i].equals(PORTAL))//check billing boolean if portal user argument is used
    		{
    			portGo = true;
			}
			//If the argument passed is --customer-id: check for ID number
    		else if(args[i].equals(CUSTOMER))
    		{
				//Check for ID number
    			if(args[i+1] == null)//customer argument is used and no id is given, therefore exit program
    			{
    				System.out.println(ERROR + " No customer ID entered.");
    	    		System.exit(1);
    			}
    			else//customer id argument is given and id is also given, proceed and assign integer argument to customer id variable
    			{
    				idPresent = true;
    				cust_id = Integer.parseInt(args[i+1]);
    			}
    			
    		}
    		
    	}
    	
    	
    	
    }
    
    
	public static String portalCommand()
    {
		/**
		 * it does what the "Returns:" section says
		 * @return a string with a complete user input which calls the portal program and includes the customer id if that was included in the user's input
		 */
    	//Creating baseline portal command
    	String command = "java -jar HPMS_Portal.jar ";
    		
		//If there is a customer id we can add it to the end to send in that argument to the portal program
		if(cust_id != 0)
		{
			command += cust_id;
		}
    		
    	return command;
    	
    }
    
    public static String billingCommand()
    {
		/**
		 * it does what the "Returns:" section says
		 * @return a string with a complete user input which calls the billing program and includes the customer id if that was included in the user's input
		 */
    	//Creating baseline billing command
    	String command = "java -jar HPMS_Billing.jar ";
    	
    	//If there is a customer id we can add it to the end to send in that argument to the billing program
		if(cust_id != 0)
		{
			command += cust_id;
		}
    	
    	return command;
    }
    
    
    public static void run(String command) throws IOException
    {
		/**
		 * this method calls the billing and portal jar programs
		 * @param command accepts the command line prompt created by the billingCommand and portalcommand methods
		 * @return Nothing
		 */
    	//Run terminal command
    	Process proc = Runtime.getRuntime().exec(command);
        
    	//Print terminal command & output to stdOut
        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        String line = "";
        lineRead = true;
        
        while((line = reader.readLine()) != null)
        {
            System.out.print(line + "\n");
        }

        //Check for process error
        try 
        {
            proc.waitFor();
        } 
        catch(InterruptedException e)
        {
             System.out.println("Error: interrupted exception.");
        }

    }

    
	//MAIN METHOD
    public static void main(String [] args) throws IOException
    {
		/**
		 * This is the main method, it makes use of the argsCheck, run, portaCommand, and billingCommand methods
		 * @param args user input determine what databases the program retrieves json data from and which of it is returned
		 * @return Nothing, see: void
		 * @exception IOError on incorrect input or a lack therof, or too much
		 */

		//RUN ARGUMENT CHECK
    	//First check the arguments for errors -- typos, incorrect argument format, etc.
    	argsCheck(args);
    	
    	//If portal is selected, run it (but also catch exceptions)
    	if(portGo == true)
    	{
    		try
    		{
    			System.out.println("\nHPMS_Portal:\n");
        		run(portalCommand());
    		}
    		catch(IOException e)
    		{
    			System.out.println("Error: IOException");
    			System.exit(1);
    		}
    		
    	}
    	
    	//If billing is selected, run it (but also catch exceptions)
    	if(billGo == true)
    	{
    		try
    		{
    			System.out.println("\nHPMS_Billing:\n");
        		run(billingCommand());
    		}
    		catch(IOException e)
    		{
    			System.out.println("Error: IOException");
    			System.exit(1);
    		}
		}
		//Else output error for an incorrect argument
		else if(portGo == false && billGo == false){
			System.out.println(ERROR + " Invalid argument passed.");
			System.exit(1);
		}
    	
	}
	
}

