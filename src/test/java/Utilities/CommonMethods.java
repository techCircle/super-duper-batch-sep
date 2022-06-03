package Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {

	/*
	 * Method that clear and sends key
	 * 
	 * by: Shafkat Ali 02/22/2019 modified by: Alip 12/22/2021
	 * 
	 */
	public static void sendText(WebElement element, String text) {

		element.clear();
		element.sendKeys(text);

	}

	/*
	 * method checks if radio/checkbox is enabled and clicks it
	 * 
	 * by: Shafkat Ali 02/22/2019 modified by: Alip 12/22/2021
	 * 
	 */
	public static void clickRadioOrCheckbox(List<WebElement> radioOrCheckbox, String value) {

		String actualValue;

		for (WebElement el : radioOrCheckbox) {
			actualValue = el.getAttribute("value").trim();
			if (el.isEnabled() && actualValue.equals(value)) {
				el.click();
				break;
			}
		}
	}

	// selects dropDown value
	public static void selectDropDownValue(WebElement element, String textToSelect) {

		try {
			Select select = new Select(element);

			List<WebElement> options = select.getOptions();

			for (WebElement el : options) {
				if (el.getText().equals(textToSelect)) {
					select.selectByVisibleText(textToSelect);
					break;
				}
			}

		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}

	}

	// select dropdown by index
	public static void selectDropDownIndex(WebElement element, int indexValue) {

		try {
			Select select = new Select(element);

			int size = select.getOptions().size();

			if (size > indexValue) {
				select.selectByIndex(indexValue);
			}

		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}

	}

	// methods that dismisses alerts and catchs exception if alert is not present
	public static void dismissAlert() {

		try {

			Alert alert = BaseClass.getDriver().switchTo().alert();
			alert.dismiss();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

	}

	//
	// methods that gets text of alert and catches exception if laert is not present
	// return type has to be String
	public static String getAlertText() {

		String alertText = null;

		try {

			Alert alert = BaseClass.getDriver().switchTo().alert();
			alertText = alert.getText();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

		return alertText;
	}

	///// accept Alert
	public static void acceptAlert() {

		try {

			Alert alert = BaseClass.getDriver().switchTo().alert();
			alert.accept();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

	}

	// sends text to alertbox
	public static void sendAlertText(String str) {

		try {

			Alert alert = BaseClass.getDriver().switchTo().alert();
			alert.sendKeys(str);
			alert.accept();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

	}

	// iframe
	public static void switchToFrame(String nameOrId) {

		try {
			BaseClass.getDriver().switchTo().frame(nameOrId);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}

	}

	// iframe
	public static void switchToFrame(WebElement element) {

		try {
			BaseClass.getDriver().switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}

	}

	// iframe index
	public static void switchToFrame(int index) {

		try {
			BaseClass.getDriver().switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}

	}

	// handle windows by switching to child Window
	public static void switchToChildWindow() {

		String mainWindow = BaseClass.getDriver().getWindowHandle();
		Set<String> windows = BaseClass.getDriver().getWindowHandles();

		for (String eachWindow : windows) {

			if (!eachWindow.equals(mainWindow)) {
				BaseClass.getDriver().switchTo().window(eachWindow);
				break;
			}

		}

	}

	public static WebDriverWait getWaitObject() {

		WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Constants.explicit_wait_time);

		return wait;
	}

	public static WebElement waitForClickability(WebElement element) {

		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	public static WebElement waitForVisibility(WebElement element) {

		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}

	public static void click(WebElement element) {
		waitForVisibility(element).click();
	}

	// js executer
	public static JavascriptExecutor getJSObject() {
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.getDriver();
		return js;
	}

	public static void jsClick(WebElement element) {
		getJSObject().executeScript("arguments[0].click();", element);
	}

	public static void scrollToElement(WebElement element) {
		getJSObject().executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void ScrolByPixel(int pixel) {
		// scroll down positive
		// scroll up negative

		getJSObject().executeScript("window.scrollBy(0," + pixel + ")");

	}

	public static String getTimeStemp() {

		Date date = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");

		return sdf.format(date.getTime());
	}

	public static byte[] takeScreenshot(String filename) {
		TakesScreenshot ts = (TakesScreenshot) BaseClass.getDriver();
		byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);

		File file = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = Constants.SCREENSHOT_FILEPATH + filename + getTimeStemp() + ".png";

			
		try {
			FileUtils.copyFile(file, new File(destinationFile));
		} catch (Exception ex) {
			System.out.println("Cannot take screenshot!");
		}

		return picBytes;
	}

	public static void wait(int second) {

		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void selectCalendarDate(List<WebElement> element, String text) {
		for (WebElement pickDate : element) {
			if (pickDate.isEnabled()) {
				if (pickDate.getText().equals(text)) {
					pickDate.click();
					break;
				}
			}
		}
	}
	
	
	public static void hover(WebElement element) {
		Actions actions = new Actions(Driver.getDriver());
		actions.moveToElement(element).perform();
	}

	public static void dragAndDrop(WebElement source, WebElement target) {
		Actions actions = new Actions(Driver.getDriver());
		actions.dragAndDrop(source, target).perform();
	}

	public static void doubleClick(WebElement source) {
		Actions actions = new Actions(Driver.getDriver());
		actions.doubleClick(source).perform();
	}
	
	
	/**
	 * return a list of string from a list of elements ignores any element with no
	 * text
	 * 
	 * @param list
	 * @return
	 */
	public static List<String> getElementsText(List<WebElement> list) {
		List<String> elemTexts = new ArrayList<String>();
		for (WebElement el : list) {
			if (!el.getText().isEmpty()) {
				elemTexts.add(el.getText());
			}
		}
		return elemTexts;
	}
	
	

	
	
	
	

}
