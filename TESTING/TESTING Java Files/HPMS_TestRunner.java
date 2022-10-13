import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class HPMS_TestRunner {
   public static void main(String[] args) {
      //Result from the JUnit test run
      Result result = JUnitCore.runClasses(HPMS_Test.class);
      //if statement that declares if there are failures in the Junit testing
      if (result.getFailures().size() > 0){
          System.err.println("A unit test failed:");
          //for loop that prints out the failed unit cases
          for (Failure failure : result.getFailures()) {
             System.err.println("\t" + failure.toString());
          }

          System.exit(1);
      }
      //if all tests work print out this message!
      System.out.println("All tests passed");
      System.exit(0);
   }
}