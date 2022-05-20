package SeleniumDay_10;

import org.testng.annotations.Test;

public class ClassB extends ClassA {
	
	
	
	
	@Test(dependsOnMethods = {"f"})
	public void anotherMethod() {
		
		System.out.println("another Method executed over in this World, called ClassB");
	
		
	}
	
	
	
	
}
