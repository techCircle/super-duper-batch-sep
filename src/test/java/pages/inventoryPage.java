package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BaseClass;

public class inventoryPage {
	
	
	public inventoryPage() {
        PageFactory.initElements(BaseClass.getDriver(), this);
    }
    
    @FindBy (className = "title")
    public WebElement pageHeader;
    
    @FindBy(xpath = "//*[@class='inventory_item']")
    public List<WebElement> productList;
    
    @FindBy (xpath = "//button[@class='btn btn_primary btn_small btn_inventory' and @id='add-to-cart-sauce-labs-backpack']")
    public WebElement slbackpack;
    
    @FindBy (xpath = "//button[@class='btn btn_primary btn_small btn_inventory' and @id='add-to-cart-sauce-labs-bike-light']")
    public WebElement bikeLight;
    
    @FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory' and @id='add-to-cart-sauce-labs-bolt-t-shirt']")
    public WebElement tShirt;
    
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    public WebElement shoppingCart;
    
    
    
    
    
    
    public void addToCart() {
        
        slbackpack.click();
        bikeLight.click();
        tShirt.click();
        shoppingCart.click();
    }

}
