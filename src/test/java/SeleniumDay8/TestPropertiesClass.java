package SeleniumDay8;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Utilities.ConfigurationProperties;
import Utilities.Driver;

public class TestPropertiesClass {

	@Before
	public void setUp() {

		Driver.getDriver();

	}

	@Test
	public void test1() {
		System.out.println(ConfigurationProperties.getProperty("text"));
	}

	@After
	public void tearDown() {
		Driver.tearDown();
	}

}
