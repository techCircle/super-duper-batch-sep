package SeleniumDay8;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import Utilities.ConfigurationProperties;
import Utilities.Driver;

public class TestPropertiesClass {

	@BeforeMethod
	public void setUp() {

		Driver.getDriver();

	}

	@Test
	public void test1() {
		System.out.println(ConfigurationProperties.getProperty("text"));
	}

	@AfterMethod
	public void tearDown() {
		Driver.tearDown();
	}

}
