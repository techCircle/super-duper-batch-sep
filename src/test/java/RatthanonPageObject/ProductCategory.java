package RatthanonPageObject;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RatthanonUtilities.BaseClassR;

public class ProductCategory {
	//ul[@class='products masonry-done']/li
	
	WebDriver driver = BaseClassR.getDriver();

	public ProductCategory() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@class='products masonry-done']/li")
	public List<WebElement> productlist;

	public boolean verifyProduct(String name) {
		
		     
		for(int i =0;i<productlist.size();i++) {
			
			
			if(productlist.get(i).getText().contains(name) || productlist.get(i).getText().contains("JS") ) {
				System.out.println("passed");
			}else {
				System.out.println("failed");
				return false;
			}
			
		}
		
		return true;
	  

	}

}
