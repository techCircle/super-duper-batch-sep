package SeleniumDay_10;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class NewTest {

	@Test(dataProvider = "dp")
	public void f(Integer n, String s) {

		System.out.println("Printing these items:  -- " + n + "=" + s);
	}

	@DataProvider(name = "dp")
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "a" }, new Object[] { 22, "asdfb" }, new Object[] { 2, "basf" },
				new Object[] { 33, "asdfb" }, new Object[] { 2, "bd" }, new Object[] { 2, "basf" },
				new Object[] { 2, "b" }, new Object[] { 2, "asdfb" }, new Object[] { 95, "b" },
				new Object[] { 2, "b" }, };

	}

	@DataProvider(name = "dp2")
	public Object[][] anotherDataProviderMethod() {
		return new Object[][] { new Object[] { 1, "a" }, new Object[] { 22, "asdfb" }, new Object[] { 2, "basf" },
				new Object[] { 33, "asdfb" }, new Object[] { 2, "bd" }, new Object[] { 2, "basf" },
				new Object[] { 2, "b" }, new Object[] { 2, "asdfb" }, new Object[] { 95, "b" },
				new Object[] { 2, "b" }, };

	}

	
	
	///
	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() {
		return new Object[][] { { "ValidUsername","ValidPassword" }, { "ValidUsername","inValidPassword" }, { "ValidUsername","InvalidPassword" } };
	}

	@Test(dataProvider = "data-provider")
	public void myTest(String val, String val2) {
		System.out.println("Passed Parameter Is : " + val + "------ " +val2);
	}

}
