package maria.HomePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Driver;

public class shopPage {
	
	//changes to push
	
	public shopPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//*[@id=\"content\"]/nav/a")
	public WebElement homeButton;


}
