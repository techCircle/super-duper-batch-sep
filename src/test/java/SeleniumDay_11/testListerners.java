package SeleniumDay_11;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utilities.ListernersTestNG;

@Listeners(ListernersTestNG.class)
public class testListerners {

	@Test // success Test
	public void test1() {

		AssertJUnit.assertTrue(true);
	}

	@Test // failed
	public void test2() {
		AssertJUnit.assertTrue(false);
	}

	@Test // failed
	public void test3() {
		AssertJUnit.assertTrue(false);
	}

	@Test // success Test
	public void test4() {
		AssertJUnit.assertTrue(true);
	}

	@Test
	public void firstMethod() {
		Assert.assertTrue(true);
	}

	@Test
	public void secondMethod() {
		Assert.assertTrue(false);
	}

	@Test(dependsOnMethods = { "firstMethod" })
	public void thirdMethod() {
		Assert.assertTrue(true);
	}

}
