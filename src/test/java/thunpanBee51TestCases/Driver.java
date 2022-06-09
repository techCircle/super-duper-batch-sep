package thunpanBee51TestCases;


import java.io.File;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
				break;
			case "Chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();			
				break;
			case "safari":
				// WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				break;
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(ThunpanBeeConstant.implicitWait, TimeUnit.SECONDS);
			driver.get(ConfigurationProperties.getProperty("url"));
			PageInitialized.init();
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
	 
	
	public static String generateRandomString(int size) {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < size ; i++) {
            char c = 'a';
            c += rand.nextInt(26);
            sb.append(c);
        }
        return sb.toString();
    }
	
	//// ConvertCurrency ////
	public static BigDecimal parse(final String amount, final Locale locale) throws ParseException {
		final NumberFormat format = NumberFormat.getNumberInstance(locale);
		if (format instanceof DecimalFormat) {
			((DecimalFormat) format).setParseBigDecimal(true);
		}
		return (BigDecimal) format.parse(amount.replaceAll("[^\\d.,]", ""));
	}
	
	public static String getTimeStamp() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(" yyyy_MM_dd_HH:mm:ss");
        return sdf.format(date.getTime());
    }
	
	public static byte[] takeScreenshot(String filename, WebElement element) {
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        byte[] picBytes = element.getScreenshotAs(OutputType.BYTES);

        File file = element.getScreenshotAs(OutputType.FILE);
        String destinationFile = Constant.SCREENSHOT_FILEPATH + filename + getTimeStamp() + ".png";

        try {
            FileUtils.copyFile(file, new File(destinationFile));
        } catch (Exception ex) {
            System.out.println("Cannot take screenshot!");
        }
        return picBytes;
    }

}


