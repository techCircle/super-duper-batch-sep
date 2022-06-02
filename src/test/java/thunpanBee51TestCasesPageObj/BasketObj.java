package thunpanBee51TestCasesPageObj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import thunpanBee51TestCases.Driver;

public class BasketObj {

	
	@FindBy(xpath = "//div[@class='quantity']/input")
	private WebElement QTYBox;
	
	@FindBy(xpath = "//input[@value='Update Basket']")
	private  WebElement updateBtn;
	
	@FindBy(xpath = "//div[@class='page-content entry-content']")
	private WebElement info;
	
	@FindBy(xpath = "//div[@class='woocommerce-message']")
	private WebElement updateLabel;
	
	public BasketObj() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	public void inoputQTYBox() {
		QTYBox.clear();
		QTYBox.sendKeys("3");
		updateBtn.click();	
		
	}
	
	public void verifyUpadteInfo() {
		String actual = updateLabel.getText(); 
		String expected = "updated";
		
		System.out.println("Actual : "+actual);
		System.out.println("Expected : "+expected);		
		Assert.assertTrue(actual.contains(expected));			
	}
}
