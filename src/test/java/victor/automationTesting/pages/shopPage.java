package victor.automationTesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import victor.utilities.Victor_BaseClass;

public class shopPage {
	public shopPage() {
		PageFactory.initElements(Victor_BaseClass.getDriver(), this);
		
	}
	
	
	@FindBy (xpath="//*[@id='content']/nav/a")
	public WebElement homeButton;
	
	
}
