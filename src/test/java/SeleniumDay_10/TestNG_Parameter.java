package SeleniumDay_10;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_Parameter {

	
	
	@Test
	@Parameters({"Value1","Value2"})
	public void Sum(int num1, int num2) {

		int finalSum = num1 + num2;

		System.out.println("Sum of these two numbers " + finalSum);

	}
	
	
	
	
	
	
	

}
