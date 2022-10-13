import java.io.*;
import java.net.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*
*HPMS Billing class obtains data from Happy Pets API's billing information
*/
public class HPMS_Billing
{
	
	//code reuse -> can change URL if needed
	static String billingUrl = "http://happy-pets-web-1522142859.us-east-1.elb.amazonaws.com/billing";
	
	/*
	*Connects to API and obtains billing information
	*/
	public static InputStream getAPI(String website) throws IOException
	{
		
		URL url = new URL(website); //set up URL, main method catches exception
		
		//connect to URL
		URLConnection con = url.openConnection();
		//send data through input stream
		InputStream is = con.getInputStream();
	
		return is;
		
	}
	
	/*
	*Sets up buffered reader allowing for the API to be read
	*/
	public static BufferedReader readAPI(InputStream is)
	{
		//read input
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		return br;
		
	}
	
	/*
	*Prints API information for each line
	*/
	public static void printAPI(BufferedReader br) throws IOException
	{
		
		String line = null;
		
		//iterate through each line of the retrieved data and print
		while((line = br.readLine()) != null)
		{
			System.out.println(line);
		}
		
	}
	
	/*
	*Parses the API data
	*/
	public static String parseAPI(BufferedReader br) throws IOException, JSONException
	{
		
		String s = "";
		String line = null;
		String result = "";
		
		//create string using fetched API data
		while((line = br.readLine()) != null)
		{
			s=s+line;
		}
	    
		System.out.println();
		
		//create JSON object using string built above, then find patientPortal JSON array
        JSONObject obj = new JSONObject(s);
        JSONArray arr = obj.getJSONArray("patientBilling");
        
        //iterate through JSON array and collect/print each piece
	    for (int i = 0; i < arr.length(); i++) 
	    {
	          String date = arr.getJSONObject(i).getString("date");
	          result = result + " " + date + "\n";
	          float amount = arr.getJSONObject(i).getInt("amount");
	          result = result + " " + amount + "\n";
	          int customer_id = arr.getJSONObject(i).getInt("customer_id");
	          result = result + " " + customer_id + "\n";
	          String service = arr.getJSONObject(i).getString("service");           
	          result = result + " " + service + "\n";
	          int patient_id = arr.getJSONObject(i).getInt("patient_id");
	          result = result + " " + patient_id + "\n" + "\n";
	    }    
	    
	    return result;

	}
	
	/*
	*Iterate through billing information for specific customer ID numbers
	*/
	public static void billingId(String custID) throws IOException, JSONException
	{
		
		BufferedReader br = readAPI(getAPI(billingUrl));
		String result = "";
		String line = null;
		String apiCall = "";
		int targetID = Integer.parseInt(custID);
		
		//iterate through each line of the retrieved data and print
		while((line = br.readLine()) != null)
		{
			apiCall = apiCall + line;
		}
		
		JSONObject obj = new JSONObject(apiCall);
        JSONArray arr = obj.getJSONArray("patientBilling");
        
        //iterate through JSON array and collect/print each piece
	    for (int i = 0; i < arr.length(); i++) 
	    {
	    	int customer_id = arr.getJSONObject(i).getInt("customer_id");
	    	if(customer_id == targetID)
	    	{
	    		String date = arr.getJSONObject(i).getString("date");
		        float amount = arr.getJSONObject(i).getInt("amount");
		        String service = arr.getJSONObject(i).getString("service");
		        int patient_id = arr.getJSONObject(i).getInt("patient_id");
		        result = date + "\n" + amount + "\n" + customer_id + "\n" + service + "\n" + patient_id + "\n";
	    		System.out.println(result);

	    	}
	    }
	    
		
	}
	
	/*
	*Combines previous methods
	*/
	public static String billing() throws IOException, JSONException
	{
		
		String result = " ";
		
		try
		{
			result = parseAPI(readAPI(getAPI(billingUrl)));
		}
		catch(IOException e)
		{
			System.out.println("ERROR: IOException caught.");
			System.exit(1); //if exception occurs, exit with error code
		}
		
		return result;
		
	}

	/*
	*MAIN METHOD
	*/
	public static void main(String[] args) throws IOException, JSONException
	{
		
		//printAPI(readAPI(getAPI(billingUrl)));  <--used to show raw API results
		
		if(args.length == 0)
		{
			try
			{
				System.out.println(billing());
			}
			//must catch exception:
			catch(IOException e)
			{
				System.out.println("ERROR: IOException caught.");
				System.exit(1); //if exception occurs, exit with error code
			}
		}
		else if(args.length == 1)
		{
			try
			{
				billingId(args[0]);
			}
			catch(Exception e)
			{
				System.out.println("ERROR: Exception caught.");
				System.exit(1); //if exception occurs, exit with error code
			}
			
		}
		else
		{
			System.out.println("ERROR: Improper arguments.");
			System.exit(1); //if exception occurs, exit with error code
		}

		
	}

}
