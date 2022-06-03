package thunpanBeePageObj;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import thunpanBee51TestCases.Driver;



public class ProductPage {
	public ProductPage() {
		PageFactory.initElements(Driver.getDriver(),this);
	}
	
	
	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	public WebElement cartBtn;
	
	@FindBy(xpath = "//*[@id='inventory_container']//div[@class='inventory_item']")
	public List<WebElement>	productList ;
	
	
	
	public void clickOnProduct() {
		
        //2) loop through the list
        for(WebElement listOfProduct : productList) {
            // 3) get the "addCartButton" xpath
            WebElement addCartBtn = listOfProduct.findElement(By.xpath(".//button[contains(text(), 'Add to cart')]"));
            // 4) in this statement use .getAttribute to get attribute of <nameTag> in this
            //   example : we use <id> and use .contain() to get whatever id that contain keyword as "t-shirt"
            if(addCartBtn.getAttribute("id").contains("t-shirt")) {
                // 5) click on items that contain "t-shirt"
                addCartBtn.click();
            }
        }
		cartBtn.click();
	}
	
	public void verifyPruductList() {
		
		int productSize = productList.size();
		int expected = productSize;
		System.out.println("Pruduct list: "+ productSize);
		System.out.println("Expected list: "+ expected);
		Assert.assertEquals(productSize, expected);
	}
}
