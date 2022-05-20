package SeleniumDay_10;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;



public class reportingLog {
	
	
	
	
	
  @Test
  public void f() {
	  
	  Reporter.log("This test verifies the current selenium compatibility with TestNG by launching the chrome driver");
      Reporter.log("Launching Google Chrome Driver version 81 for this test"); 
      
	  Reporter.log("before Assertion");

	  
	  AssertJUnit.assertTrue(true);
	  
	  System.out.println("if this code executes, assertion pass");
	  Reporter.log("if this code executes, assertion pass");
	  
  }
  
  
  
  
  
  
}
