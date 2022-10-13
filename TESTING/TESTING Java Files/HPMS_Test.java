import org.junit.Test;
import org.json.JSONException;
import org.junit.Assert;	
import java.io.*;
import java.nio.charset.Charset;

public class HPMS_Test {
	/*
	 * Purpose: test the HPMS.argCheck() method using JUnit Testing
	 * 
	 * public void test_argCheck_billing() takes a string array, enters it as a parameter for the
	 * argCheck() method, and then pulls the boolean values from HPMS which is used to determine if 
	 * argCheck found the parameter we want it to find. 
	 */
	@Test
	public void test_argCheck_billing() {
		//Initialized string array that will be provided for the argsCheck method
		String [] argument = new String[] {"--billing"};
		//Method that is being tested
		HPMS.argsCheck(argument);
		//Values that will be checked to see what is set to true
		Boolean billing = HPMS.billGo;
		Boolean portal = HPMS.portGo;
		int customer_id = HPMS.cust_id;
		//Boolean value of what actually happens in the method
		Boolean actual = false; 
		//If statement that sees what arguments are declared to be present by argCheck
		if (billing == true && portal == false && customer_id == 0) {
			actual = true;
		}
		//Expected boolean value
		Boolean expected = true;
		//Resets the HPMS values
		HPMS.billGo = false;
		HPMS.portGo = false;
		HPMS.cust_id = 0;
		//Junit test that declares what is found in argCheck is what we want
		Assert.assertEquals(expected, actual);
	}
	/*
	 * Purpose: test the HPMS.argCheck() method using JUnit Testing
	 * 
	 * public void test_argCheck_portal() takes a string array, enters it as a parameter for the
	 * argCheck() method, and then pulls the boolean values from HPMS which is used to determine if 
	 * argCheck found the parameter we want it to find. 
	 */
	@Test
	public void test_argCheck_portal() {
		//Initialized string array that will be provided for the argsCheck method
		String [] argument = new String[] {"--patient-portal"};
		//Method that is being tested
		HPMS.argsCheck(argument);
		//Values that will be checked to see what is set to true
		Boolean billing = HPMS.billGo;
		Boolean portal = HPMS.portGo;
		int customer_id = HPMS.cust_id;
		//Boolean value of what actually happens in the method
		Boolean actual = false; 
		//If statement that sees what arguments are declared to be present by argCheck
		if (billing == false && portal == true && customer_id == 0) {
			actual = true;
		}
		//Expected boolean value
		Boolean expected = true;
		//Resets the HPMS values
		HPMS.billGo = false;
		HPMS.portGo = false;
		HPMS.cust_id = 0;
		//Junit test that declares what is found in argCheck is what we want
		Assert.assertEquals(expected, actual);
		
	}
	/*
	 * Purpose: test the HPMS.argCheck() method using JUnit Testing
	 * 
	 * public void test_argCheck_billing_portal() takes a string array, enters it as a parameter for the
	 * argCheck() method, and then pulls the boolean values from HPMS which is used to determine if 
	 * argCheck found the parameter we want it to find. 
	 */
	@Test
	public void test_argCheck_billing_portal() {
		//Initialized string array that will be provided for the argsCheck method
		String [] argument = new String[] {"--billing" , "--patient-portal"};
		//Method that is being tested
		HPMS.argsCheck(argument);
		//Values that will be checked to see what is set to true
		Boolean billing = HPMS.billGo;
		Boolean portal = HPMS.portGo;
		int customer_id = HPMS.cust_id;		
		//Boolean value of what actually happens in the method
		Boolean actual = false; 
		//If statement that sees what arguments are declared to be present by argCheck
		if (billing == true && portal == true && customer_id == 0) {
			actual = true;
		}
		//Expected boolean value
		Boolean expected = true;
		//Resets the HPMS values
		HPMS.billGo = false;
		HPMS.portGo = false;
		HPMS.cust_id = 0;
		//Junit test that declares what is found in argCheck is what we want
		Assert.assertEquals(expected, actual);
	}
	/*
	 * Purpose: test the HPMS.argCheck() method using JUnit Testing
	 * 
	 * public void test_argCheck__portal_billing() takes a string array, enters it as a parameter for the
	 * argCheck() method, and then pulls the boolean values from HPMS which is used to determine if 
	 * argCheck found the parameter we want it to find. 
	 */
	@Test
	public void test_argCheck_portal_billing() {
		//Initialized string array that will be provided for the argsCheck method
		String [] argument = new String[] {"--patient-portal" , "--billing"};
		//Method that is being tested
		HPMS.argsCheck(argument);
		//Values that will be checked to see what is set to true
		Boolean billing = HPMS.billGo;
		Boolean portal = HPMS.portGo;
		int customer_id = HPMS.cust_id;
		//Boolean value of what actually happens in the method
		Boolean actual = false; 
		//If statement that sees what arguments are declared to be present by argCheck
		if (billing == true && portal == true && customer_id == 0) {
			actual = true;
		}
		//Expected boolean value
		Boolean expected = true;
		//Resets the HPMS values
		HPMS.billGo = false;
		HPMS.portGo = false;
		HPMS.cust_id = 0;
		//Junit test that declares what is found in argCheck is what we want
		Assert.assertEquals(expected, actual);
	}
	/*
	 * Purpose: test the HPMS.argCheck() method using JUnit Testing
	 * 
	 * public void test_argCheck_billing_portal_customerid_number() takes a string array, enters it as a parameter for the
	 * argCheck() method, and then pulls the boolean values from HPMS which is used to determine if 
	 * argCheck found the parameter we want it to find. 
	 */
	@Test
	public void test_argCheck_billing_portal_customerid_number() {
		//Initialized string array that will be provided for the argsCheck method
		String [] argument = new String[] {"--billing" , "--patient-portal" , "--customer-id" , "100025"};
		//Method that is being tested
		HPMS.argsCheck(argument);
		//Values that will be checked to see what is set to true
		Boolean billing = HPMS.billGo;
		Boolean portal = HPMS.portGo;
		int customer_id = HPMS.cust_id;
		//Boolean value of what actually happens in the method
		Boolean actual = false; 
		//If statement that sees what arguments are declared to be present by argCheck
		if (billing == true && portal == true && customer_id >= 0) {
			actual = true;
		}
		//Expected boolean value
		Boolean expected = true;
		//Resets the HPMS values
		HPMS.billGo = false;
		HPMS.portGo = false;
		HPMS.cust_id = 0;
		//Junit test that declares what is found in argCheck is what we want
		Assert.assertEquals(expected, actual);
	}
	/*
	 * Purpose: test the HPMS.portalCommand() method using JUnit testing
	 * 
	 * public void test_portalCommand_is_success() takes the expected string with the actual string, that
	 * is created using the HPMS.portalCommand() method, and these values are compared to see if they
	 * are equal.
	 */
	@Test
	public void test_portalCommand_is_success() {
		//Expected String of the method
		String expected = "java -jar HPMS_Portal.jar ";
		//actual string created from HPMS.portalCommand() method`
		String actual = HPMS.portalCommand();
		//JUnit testing that string expected is equal to string actual
		Assert.assertEquals(expected, actual);
	}
	/*
	 * Purpose: test the HPMS.portalCommand() method using JUnit testing
	 * 
	 * public void test_portalCommand_with_string_is_success() sets the custoemr id
	 * number. and then takes the expected string with and the actual string,
	 * that is created using the HPMS.portalCommand() method, and these values are compared to see if they
	 * are equal.
	 */
	@Test
	public void test_portalCommamnd_with_String_is_success() {
		//Sets a customer id value for HPMS.portal
		HPMS.cust_id = 100025;
		//Expected String
		String expected = "java -jar HPMS_Portal.jar 100025";
		//actual string created from HPMS.portalCommand() method
		String actual = HPMS.portalCommand();
		//Resets customer id value
		HPMS.cust_id = 0;
		//JUnit test that string expected is equal to string actual
		Assert.assertEquals(expected, actual);
	}
	/*
	 * Purpose: test the HPMS.portalCommand() method using JUnit testing
	 * 
	 * public void test_billingCommand_is_success() takes the expected string with and the actual string,
	 * that is created using the HPMS.billingCommand() method, and these values are compared to see if they
	 * are equal.
	 */
	@Test 
	public void test_billingCommand_is_success() {
		//Expected String of the method
		String expected = "java -jar HPMS_Billing.jar ";
		//actual string created from HPMS.billingCommand() method`
		String actual = HPMS.billingCommand();
		//JUnit testing that string expected is equal to string actual
		Assert.assertEquals(expected, actual);
	}
	/*
	 * Purpose: test the HPMS.portalCommand() method using JUnit testing
	 * 
	 * public void test_billingCommand_with_string_is_success() sets the customer id
	 * number. and then takes the expected string with and the actual string,
	 * that is created using the HPMS.billingCommand() method, and these values are compared to see if they
	 * are equal.
	 */
	@Test
	public void test_billingCommand_with_String_is_success() {
		//Sets a customer id value for HPMS.Billing
		HPMS.cust_id = 100025;
		//Expected String of the method
		String expected = "java -jar HPMS_Billing.jar 100025";
		//actual string created from HPMS.billingCommand() method
		String actual = HPMS.billingCommand();
		//Resets customer id value
		HPMS.cust_id = 0;
		//JUnit test that string expected is equal to string actual
		Assert.assertEquals(expected, actual);
	}
	/*
	 * Purpose: test the HPMS.run() method using JUnit Testing
	 * 
	 * public void test_run_success() takes a string, this string is then entered into the run command
	 * the run command, if ran, will change a boolean value which is accessed throught the test method.
	 * The boolean value should be true and this will be compared to see if they are equal.
	 */
	@Test
	public void test_run_success() throws IOException {
		//String that is going to be used in the run command
        String command = "java -jar HPMS_Portal-jar";
        //HPMS run method that will be tested
        HPMS.run(command);
        //Boolean values for the JUnit test
        boolean expected = true;
        boolean actual = HPMS.lineRead;
        //JUnit test that compares the expected and actual string values. 
        Assert.assertEquals(expected, actual);
}
	/*
	 * Purpose: test the HPMS.main() method using JUnit testing
	 * 
	 * public void test_hpmsMain_portGo_true initializes a string array that is used as an 
	 * argument in the HPMS.main method. This method is then output to an output stream which is turned 
	 * into a string for manipulation. if this string contains the expected string, then  it will return
	 * a true boolean value which is compared to the expected boolean value for testing. 
	 */
	@Test
	public void test_hpmsMain_portGo_true() throws IOException {
		//String array to use as args for the HPMS.main() method   
		String [] argument = new String[] {"--patient-portal"};
		   /* Prints out the HPMS.main(argument) method in the output stream then converts 
		    * the output stream into a string for manipulation. 
		    */
		   ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
		   PrintStream ps = new PrintStream(baos);
		   PrintStream old = System.out;
		   System.setOut(ps);
		   HPMS.main(argument);	 
		   System.out.flush();
		   System.setOut(old);
		   //String that is generated from the outputStream
		   String actualString = baos.toString();
		   //Expected string that is contained within actual string
		   String expectedString = "HPMS_Portal:";
		   //Expected and actual boolean values of actual vs expected
		   Boolean actual = actualString.contains(expectedString);
		   Boolean expected = true;
		   //reset HPMS values
		   HPMS.billGo = false;
		   HPMS.portGo = false;
		   HPMS.cust_id = 0;
		   //JUnit test that contains boolean values that let us know if actual contains expected. 
		   Assert.assertEquals(expected, actual);
	}
	/*
	 * Purpose: test the HPMS.main() method using JUnit testing
	 * 
	 * public void test_hpmsMain_billGo_true initializes a string array that is used as an 
	 * argument in the HPMS.main method. This method is then output to an output stream which is turned 
	 * into a string for manipulation. if this string contains the expected string, then  it will return
	 * a true boolean value which is compared to the expected boolean value for testing. 
	 */
	@Test
	public void test_hpmsMain_billGo_true() throws IOException {
		   //String array to use as args for the HPMS.main() method   
		   String [] argument = new String[] {"--billing"};
		   /* Prints out the HPMS.main(argument) method in the output stream then converts 
		    * the output stream into a string for manipulation. 
		    */
		   ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
		   PrintStream ps = new PrintStream(baos);
		   PrintStream old = System.out;
		   System.setOut(ps);
		   HPMS.main(argument);	 
		   System.out.flush();
		   System.setOut(old);
		   //String that is generated from the outputStream
		   String actualString = baos.toString();
		   System.out.println(actualString);
		   //Expected string that is contained within actual string
		   String expectedString = "HPMS_Billing";
		   //Expected and actual boolean values of actual vs expected
		   Boolean actual = actualString.contains(expectedString);
		   Boolean expected = true;
		   //reset HPMS values
		   HPMS.billGo = false;
		   HPMS.portGo = false;
		   HPMS.cust_id = 0;
		   //JUnit test that contains boolean values that let us know if actual contains expected. 
		   Assert.assertEquals(expected, actual);
		
	}
	/*
	 * Purpose: test the HPMS.main() method using JUnit testing
	 * 
	 * public void test_hpmsMain_portGo__billGo_bothTrue initializes a string array that is used as an 
	 * argument in the HPMS.main method. This method is then output to an output stream which is turned 
	 * into a string for manipulation. if this string contains the expected string, then  it will return
	 * a true boolean value which is compared to the expected boolean value for testing. 
	 */
	@Test
	public void test_hpmsMain_portGo_billGo_bothTrue() throws IOException {
		//String array to use as args for the HPMS.main() method   
		   String [] argument = new String[] {"--billing" , "--patient-portal"};
		   /* Prints out the HPMS.main(argument) method in the output stream then converts 
		    * the output stream into a string for manipulation. 
		    */
		   ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
		   PrintStream ps = new PrintStream(baos);
		   PrintStream old = System.out;
		   System.setOut(ps);
		   HPMS.main(argument);	 
		   System.out.flush();
		   System.setOut(old);
		   //String that is generated from the outputStream
		   String actualString = baos.toString();
		   System.out.println(actualString);
		   //Expected string that is contained within actual string
		   String expectedStringBilling = "HPMS_Billing";
		   String expectedStringPortal = "HPMS_Portal";
		   //Expected and actual boolean values of actual vs expected
		   Boolean actual = false;
		   Boolean expected = true;
		   //if statement that checks to see if the actualString contains both billing and portal information
		   if (actualString.contains(expectedStringBilling) == true 
				   && actualString.contains(expectedStringPortal)) {
			   actual = true;
		   }
		   //reset HPMS values
		   HPMS.billGo = false;
		   HPMS.portGo = false;
		   HPMS.cust_id = 0;
		   //JUnit test that contains boolean values that let us know if actual contains expected. 
		   Assert.assertEquals(expected, actual);
	}
}
