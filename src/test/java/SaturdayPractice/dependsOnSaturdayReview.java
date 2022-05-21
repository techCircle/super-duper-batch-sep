package SaturdayPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class dependsOnSaturdayReview {

	@Test(dependsOnGroups="smokeTest1")
	public void test() {
		Assert.assertTrue(true);
	}

	@Test
	public void test0() {
		Assert.assertTrue(true);
	}

	@Test(dependsOnMethods = { "test0", "test" })
	public void test1() {
		Assert.assertTrue(true);

	}

	@Test(dependsOnMethods = "test1")
	public void test2() {
		Assert.assertTrue(true);

	}

	@Test(dependsOnMethods = "test2")
	public void test3() {
		Assert.assertTrue(true);

	}

	@Test(dependsOnMethods = "test3")
	public void test4() {
		Assert.assertTrue(true);

	}
	
	@Test(groups="smokeTest1")
	public void test5() {
		Assert.assertTrue(true);
	}
	
	@Test(groups="smokeTest1")
	public void test6() {
		Assert.assertTrue(false);
	}
	
	@Test(groups="smokeTest1")
	public void test7() {
		Assert.assertTrue(true);
	}

}
