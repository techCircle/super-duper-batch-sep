package SeleniumDay_11;

import org.testng.Assert;
import org.testng.annotations.Test;

public class retryFailedTest1 {
	
	
	
	@Test(retryAnalyzer = Utilities.RetryAnalyzer.class)
	public void Test1() {
		
		Assert.assertEquals(false, true);
	}
	
	
	
	@Test
	public void Test2() {
		
		Assert.assertEquals(true, false);
	}
	
	
	
	
	
	
	
	
	
	

}
