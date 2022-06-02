package victor.automationTesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import victor.utilities.Victor_BaseClass;

public class editAccountPage {
		public editAccountPage () {
			PageFactory.initElements(Victor_BaseClass.getDriver(), this);
			}
		
		@FindBy (xpath="//*[@id=\"page-36\"]/div/div[1]/div/form/p[4]/input[3]")
		public WebElement saveChanges;

}
