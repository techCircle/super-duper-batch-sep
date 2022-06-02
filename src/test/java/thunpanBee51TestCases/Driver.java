package thunpanBee51TestCases;


import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	public static WebDriver driver;


	public static WebDriver getDriver() {
		if (driver == null) {
			switch (ConfigurationProperties.getProperty("browser")) {
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(ThunpanBeeConstant.implicitWait, TimeUnit.SECONDS);
				break;
			case "Chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(ThunpanBeeConstant.implicitWait, TimeUnit.SECONDS);
				break;
			case "safari":
				// WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(ThunpanBeeConstant.implicitWait, TimeUnit.SECONDS);
				break;
			}
			driver.get(ConfigurationProperties.getProperty("url"));
		}
		return driver;
	}

	/********************************
	 ********** utilities ***********
	 ********************************/
	
	public static double getPriceAsInt(WebElement element) {
		return Double.parseDouble(element.getText().substring(1));
	}

	public static void clickOnProduct(List<WebElement> list, String key) {
		for (WebElement Option : list) {
			String Select = Option.getText();
			if (Select.contains(key)) {
				Option.click();
				break;
			}
		}
	}
	
	public static void clickAutualObj(List<WebElement> list, String key) {
		for (WebElement Option : list) {
			String Select = Option.getText();
			if (Select.equals(key)) {
				Option.click();
				break;
			}
		}
	}
	
	

	public void productDisplayed(List<WebElement> list, String key) {
		for (WebElement Option : list) {
			String select = Option.getText();
			System.out.println("Displayed : " + select);
		}
	}

	public static void navBack() {
		Driver.getDriver().navigate().back();
	}

	public static void getURL() {
		System.out.println(Driver.getDriver().getCurrentUrl());
	}

	public static void destroy() {
		if (driver != null) {
			driver.close();
		}
	}
	
	//// ConvertCurrency ////
	public static BigDecimal parse(final String amount, final Locale locale) throws ParseException {
		final NumberFormat format = NumberFormat.getNumberInstance(locale);
		if (format instanceof DecimalFormat) {
			((DecimalFormat) format).setParseBigDecimal(true);
		}
		return (BigDecimal) format.parse(amount.replaceAll("[^\\d.,]", ""));
	}
	
}


