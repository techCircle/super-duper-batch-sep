package maria.HomePage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.ConfigurationProperties;
import Utilities.Driver;

public class HomePagePage {

	public HomePagePage() {
		PageFactory.initElements(Driver.getDriver(), this);

///changes to pushzzz
	}

	@FindBy(xpath="//img[@title='Selenium Ruby']")
	public WebElement seleniumRubyimg;

	@FindBy(xpath="//img[@title='Thinking in HTML']")
	public WebElement thinkingInHTMLimg;

	@FindBy(xpath="//img[@title='Mastering JavaScript']")
	public WebElement MasteringJavaScriptimg;

	@FindBy(id = "menu-item-40")
	public WebElement shopButton;

	@FindBy(xpath = "//*[@id=\"n2-ss-6\"]/div[1]/div/div/div")
	public List<WebElement> sliders;
	@FindBy(xpath = "//*[@id=\"themify_builder_content-22\"]/div[2]/div/div/div/div/div[2]/div")
	public List<WebElement> arrivals;

	@FindBy(xpath="//*[@id=\"tab-description\"]")
	public WebElement arrivalImg2Description;

	@FindBy(xpath="//*[@id=\"product-163\"]/div[3]/ul/li[2]")
	public WebElement arrivalImg2Review;

	@FindBy(xpath="//*[@id=\"comments\"]")
	public WebElement arrivalImg2ReviewDisplay;



	@FindBy(xpath=" //*[@id=\"product-163\"]/div[5]/ul/li[2]/a[1]")
	public WebElement arrivalImg2AddToBasketBtn;

	@FindBy(xpath="//button[contains(text(), 'Add to basket')]")
	public WebElement arrivalsubImg2AddToBasketBtn;

	@FindBy(xpath="//*[@id=\"wpmenucartli\"]/a/span[2]")
	public WebElement arrivalsubImg2CartPrice;



	@FindBy(xpath="//*[@class='quantity']/input ")
	public WebElement arrivalsubImg2CartPriceMax;

	@FindBy(xpath="//form/div/input")
	public WebElement arrivalsubImg2quntityBox;

	@FindBy(xpath="//button[contains(text(), 'Add to basket')]")
	public WebElement arrivalsubImg2quntityBoxcliik;

	@SuppressWarnings("unused")
	private int moreThanMax;



	//Methods

	public void checkSlidersCount() throws InterruptedException {
		int count=3;
		Assert.assertEquals(count, sliders.size());
		Thread.sleep(3000);
	}

	public void checkArrivalsCount() {
		int count=3;
		Assert.assertEquals(count, arrivals.size());
	}

	public void verifyImagesInArrivalsShouldNavigate() {
		String[] expectedTexts = new String[]{"Selenium Ruby", "Thinking in HTML", "Mastering JavaScript"};

		for(int i = 0; i<arrivals.size(); i++) {

			String pathText = String.format("//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div[%d]", i+1);

			Driver.getDriver().findElement(By.xpath(pathText)).click();
			String text = Driver.getDriver().findElement(By.xpath("//*[@class='product_title entry-title']")).getText();

			Assert.assertTrue(expectedTexts[i].equals(text)) ;                    
			Driver.getDriver().navigate().back();            
		}


	}
	public void arrivalImage2click() {
		thinkingInHTMLimg.click();


	}
	public void arrivalImage2description() {
		Assert.assertTrue(arrivalImg2Description.isDisplayed());



	}

	public void arrivalImage2Review() {

		arrivalImg2Review.click();
		Assert.assertTrue(arrivalImg2ReviewDisplay.isDisplayed());
	}




	public void arrivalImg2AddToBasket() {
		arrivalImg2AddToBasketBtn.click();		
		arrivalsubImg2AddToBasketBtn.click();
	}

	public void arrivalsubImg2CartPrice() {
		Assert.assertTrue(arrivalsubImg2CartPrice.isDisplayed());
	}

	public void arrivalSubImgProceedToCheckout() {
		arrivalsubImg2CartPrice.click();

	}

	public void arrivalsubImg2CartPriceMax() {
		String getMax=arrivalsubImg2CartPriceMax.getAttribute("Max");
		moreThanMax = Integer.valueOf(getMax)+1;
		arrivalsubImg2quntityBox.clear();
		arrivalsubImg2quntityBox.sendKeys(ConfigurationProperties.getProperty("moreThanMax"));
		arrivalsubImg2quntityBoxcliik.click();

		WebElement ele = arrivalsubImg2quntityBox;
		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
		Boolean isValidInput = (Boolean)js.executeScript("return arguments[0].checkValidity();", ele);
		System.out.println(isValidInput);
		String validationMessage = (String)js.executeScript("return arguments[0].validationMessage;", ele);
		System.out.println(validationMessage);

		Assert.assertFalse(isValidInput);

		String alert = String.format("Value must be less than or equal to %d.", Integer.valueOf(getMax));

		Assert.assertTrue(validationMessage.equals(alert));


	}







}
