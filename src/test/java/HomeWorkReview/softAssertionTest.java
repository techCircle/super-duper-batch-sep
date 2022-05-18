package HomeWorkReview;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class softAssertionTest {

	// Object of Class SoftAssert is created to use its methods
	SoftAssertions softassert = new SoftAssertions();
	// SoftAssert softassert2 = new SoftAssert();

	@Test
	public void softAssertionTest() {
		// TODO Auto-generated method stub

		// Object of Class SoftAssert is created to use its methods
		//SoftAssertions softassert = new SoftAssertions();
		// SoftAssert softassert2 = new SoftAssert();

		WebDriver driver;

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://www.amazon.com");
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Welcome to Amazon"; // incorrect title expectation
		// String ExpectedTitle = "Amazon.com. Spend less. Smile more."; //correct title
		// expectation

		// Soft assert applied to verify title
		// softassert.assertEquals(ActualTitle, ExpectedTitle);
		// softassert.equals(ExpectedTitle);
		softassert.assertThat(ExpectedTitle).isEqualTo(ActualTitle);
		// If failed, this line gets printed and execution is not halted
		System.out.println("Assertion 1 is executed");

		softassert.assertAll();

	}

}
