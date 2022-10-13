import org.junit.Test;
import org.json.JSONException;
import org.junit.Assert;

import java.io.*;
import java.nio.charset.Charset;


public class HPMS_Portal_Test { 
   /*
    * Purpose: test the HPMS_portal.getAPI() method using JUnit testing
    * 
    * public void test_getAPI_is_success() creates an input stream using the getAPI method, 
    * turns it into a string, and then creates a boolean value that is looking to see if the string
    * contains a certain string.  
    */
	@Test
   public void test_getAPI_is_success() throws IOException {
	   //API URl that will be used 
	   String portalURL = "http://happy-pets-web-1522142859.us-east-1.elb.amazonaws.com/patient-portal";
	   //input stream of the API
	   InputStream is = HPMS_Portal.getAPI(portalURL);
	   //Strings initialized of what we want vs what we have
	   String whatWeHave = is.toString();
	   String whatWeWant = "sun.net.www.protocol.http.HttpURLConnection$HttpInputStream";
	   //Either true or false based on if what we have contains what we want
	   boolean actual = whatWeHave.contains(whatWeWant); 
	   boolean expected = true;
	   //JUnit test that declares if what we have is what we want
	   Assert.assertEquals(expected, actual);
   }
   /* Purpose: test the HPMS_portal.readAPI() method using JUnit testing
    * 
    * public void rest_readAPI_is_success() the readAPI method is used by the creation of an input stream
    * this input stream is used in the method. The method output is printed out into a string and then
    * compared the the expected string
    */
   @Test
   public void test_readAPI_is_success() throws IOException{
	   //Expected string output
	   String expected = "This is the expected output";
	   //Creating an input stream to use in HPMS_Portal.readAPI()
	   InputStream inputStream = new ByteArrayInputStream(expected.getBytes(Charset.forName("UTF-8")));
	   //BufferedReader that is set to the return of HPMS_Portal.readAPI()
	   BufferedReader actualBuffer = HPMS_Portal.readAPI(inputStream);
	   //Strings that are manipulated to provide the actual value.
	   String actualBufferLine = null;
	   String actualResult = "";
	   //iterate through each line of the retrieved data and print
	   while((actualBufferLine = actualBuffer.readLine()) != null)
		{
			actualResult = actualResult+actualBufferLine;
		}
	   //JUnit test that declares if what we have is what we want
	   Assert.assertEquals(expected, actualResult);

   } 
   /* Purpose: test the HPMS_portal.printAPI() method using JUnit testing.  
    * 
    * public void test_printAPI_is_success() tests the printAPI method that it correctly prints the contents
    * of the given BufferedReader. This is done by checking to see if the contained values are within the 
    * output of printAPI. 
    */
   @Test
   public void test_printAPI_is_success() throws IOException, JSONException{
	   //API URl that will be used 
	   String portalURL = "http://happy-pets-web-1522142859.us-east-1.elb.amazonaws.com/patient-portal";
	   //input stream of the API
	   InputStream is = HPMS_Portal.getAPI(portalURL);
	   BufferedReader br = HPMS_Portal.readAPI(is);
	   /* Prints out the HPMS_PortalID() method in the output stream then converts 
	    * the output stream into a string for manipulation. 
	    */
	   ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
	   PrintStream ps = new PrintStream(baos);
	   PrintStream old = System.out;
	   System.setOut(ps);
	   HPMS_Portal.printAPI(br);	 
	   System.out.flush();
	   System.setOut(old);
	   String actualString = baos.toString();
	   System.out.println(actualString);
	   //Boolean values whether or not the actual String contains information that is needed
	   Boolean containsPatientPortal = actualString.contains("patientPortal");
	   Boolean containsDate = actualString.contains("2018-10-31");
	   Boolean containsCustomerID = actualString.contains("customer_id");
	   Boolean containsService = actualString.contains("service");
	   Boolean containsPatientID = actualString.contains("patient_id");
	   //Boolean value that shows whether the actual String contains all of the information that is needed

	   Boolean actualContainsAll = true;
	   //If all of the boolean values are false, therefore they contain all of the values that are needed
	   if (containsPatientPortal == false || containsDate == false 
		   || containsCustomerID == false || containsService == false 
		   || containsPatientID == false) 
	   {
		actualContainsAll = false;
	   }
	   //Expected boolean value
	   Boolean expected = true;
	   //JUnit test that declares if what we have is what we want
	   Assert.assertEquals(expected, actualContainsAll);
	   
   }
   /*
    * Purpose: test the HPMS_portal.parseAPI() method using JUnit testing
    * 
    * public void test_parseAPI_is_success() Takes the output of the parseAPI method, converts it to a string,
    * then find boolean values of whether or not keywords are contained within the string 
    */
   @Test
   public void test_parseAPI_is_success() throws IOException, JSONException{
	   //URL of the API that will be used 
	   String portalURL = "http://happy-pets-web-1522142859.us-east-1.elb.amazonaws.com/patient-portal";
	   //Creation of an inputStream for readAPI()
	   InputStream is = HPMS_Portal.getAPI(portalURL);
	   //Creation of a BufferedReader for printAPI()
	   BufferedReader br = HPMS_Portal.readAPI(is);
	   //Creation of a String that is returned from the method printAPI()
	   String actual = HPMS_Portal.parseAPI(br);
	   //Boolean values whether or not the actual String contains information that is needed
	   Boolean actualContainsDate = actual.contains("date");
	   Boolean actualContainsCustomer_id = actual.contains("customer_id");
	   Boolean actualContainsTransaction_type = actual.contains("transaction_type");
	   Boolean actualContainsService = actual.contains("service");
	   Boolean actualContainsPatient_ID = actual.contains("patient_id");
	   //Boolean value that shows whether the actual String contains all of the information that is needed
	   Boolean actualContainsAll = false;
	   //If all of the boolean values are true, therefore they do not contain all of the values that are needed
	   if (actualContainsDate == true || actualContainsCustomer_id == true 
		   || actualContainsTransaction_type == true || actualContainsService == true 
		   || actualContainsPatient_ID == true) 
	   {
		actualContainsAll = true;
	   }
	   //Expected boolean value
	   Boolean expected = false;
	   //JUnit test that declares if what we have is what we want
	   Assert.assertEquals(expected, actualContainsAll);
   }
   /* Purpose: test the HPMS_portal.portalID() method using JUnit testing
    * 
    * public void test_portalID_is_success() takes the output of the portalID method, turns it into a string,
    * then creates a boolean value of whether or not the string contains a certain keyword
    */
   @Test
   public void test_portalID_is_success() throws IOException, JSONException {
	   
	   /* Prints out the HPMS_PortalID() method in the output stream then converts 
	    * the output stream into a string for manipulation. 
	    */
	   ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
	   PrintStream ps = new PrintStream(baos);
	   PrintStream old = System.out;
	   System.setOut(ps);
	   HPMS_Portal.portalID("100025");	 
	   System.out.flush();
	   System.setOut(old);
	   String actualString = baos.toString();
	   //Boolean vales that will be used in the JUnit test
	   Boolean actual = false;
	   Boolean expected = true;
	   //If the actual string contains customer id 100,003, then the test is a failure. Otherwise it is true0
	   if (actualString.contains("100003") != true) {
		   actual = true;
	   }
	   //JUnit test that declares if what we have is what we want
	   Assert.assertEquals(expected, actual);
   }
   /* Purpose: test the HPMS_portal.portal() method using JUnit testing
    * 
    * public void test_portal_is_success() takes the output of the portal method, 
    * initializes it into a string, and then, checks to see if keywords are contained within that string. 
    */
   @Test
   public void test_portal_is_success() throws IOException, JSONException {
	   //String that will contain the actual output of the method
	   String actual = HPMS_Portal.portal();
	   //Boolean value that will provide the information on whether or not the actual string contains all of the information
	   Boolean actualContainsAll = false;
	   //If statement that updates the boolean value if the actual string contains all of the dates
	   if (actual.contains("2018-10-31") && actual.contains("2019-09-04") && actual.contains("2017-05-22")) {
		   actualContainsAll = true;
	   }
	   //Expected boolean value
	   Boolean expected = true;
	   //JUnit test that declares if what we have is what we want
	   Assert.assertEquals(expected, actualContainsAll);
   }
   /*
    * Purpose: test the HPMS_portal.main argument with zero arguments using JUnit testing
    * 
    * public void test_main_with_0_argument() creates an empty string array that will be used in the call
    * of the main method. The main method is printed out into a output stream, which is converted
    * to a string. A boolean value contains whether or not the expected string is within the actual string. 
    * This boolean value should be true to pass the test.
    */
   @Test
   public void test_main_with_0_argument() throws IOException, JSONException {
	   //String array used in the HPMS_Portal.main() call.
	   String[] argument = new String[] {}; 
	   /* Prints out the HPMS_Portal.main method in the output stream then converts 
	    * the output stream into a string for manipulation. 
	    */
	   ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
	   PrintStream ps = new PrintStream(baos);
	   PrintStream old = System.out;
	   System.setOut(ps);
	   HPMS_Portal.main(argument);
	   System.out.flush();
	   System.setOut(old);
	   String actualString = baos.toString();
	   //Expected string value from the expected method call
	   String expectedString = HPMS_Portal.portal();
	   //Expected and actual boolean values
	   Boolean actual = false;
	   Boolean expected = true;
	   //If statement that declares whether the actual and expected statements are the same
	   if (actualString.contains(expectedString) == true){
		   actual = true;
	   }
	   //JUnit test that declares if what we have is what we want
	   Assert.assertEquals(expected, actual);
   }
   /*
    * Purpose: test the HPMS_portal.main() argument with one argument using JUnit testing
    * 
    * public void test_main_with_1_argument() creates an empty string array that will be used in the call
    * of the main method. The main method is printed out into a output stream, which is converted
    * to a string. This process is repeated for the expected string of the method that is supposed to be 
    * called from the main method. The expectedString and actualString are then compared to each other to 
    * determine whether or not it passes the test
    */
   @Test
   public void test_main_with_1_argument() throws IOException, JSONException {
	   //String array used in the HPMS_Portal.main() call.
	   String[] argument = new String[] {"100003"}; 
	   /* Prints out the HPMS_Portal.main method in the output stream then converts 
	    * the output stream into a string for manipulation. 
	    */
	   ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
	   PrintStream ps = new PrintStream(baos);
	   PrintStream old = System.out;
	   System.setOut(ps);
	   HPMS_Portal.main(argument);
	   System.out.flush();
	   System.setOut(old);
	   String actualString = baos.toString();
	   /* Prints out the HPMS_PortalID() method in the output stream then converts 
	    * the output stream into a string for manipulation. 
	    */
	   ByteArrayOutputStream soab = new ByteArrayOutputStream(); 
	   PrintStream sp = new PrintStream(soab);
	   PrintStream dlo = System.out;
	   System.setOut(sp);
	   HPMS_Portal.portalID("100003");	   
	   System.out.flush();
	   System.setOut(dlo);
	   String expectedString = soab.toString();
	   //JUNIT test that declares if what we have is what we want
	   Assert.assertEquals(expectedString, actualString);
   }
   }

