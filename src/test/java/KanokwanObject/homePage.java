package KanokwanObject;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import KanokwanUtilities.KanokwanBaseClass;


public class homePage {
	
	public homePage() {
		
		PageFactory.initElements(KanokwanBaseClass.getDriver(), this);
		
	}
	
	//Click on Shop menu
	@FindBy(id = "menu-item-40")
	public WebElement shopButton;
	
	//click on Home menu button
	@FindBy(xpath = "//*[@id=\"content\"]/nav/a")
	public WebElement homeButton;
	
	//Home page has Three Sliders only
	@FindBy(xpath = "//*[@id=\"n2-ss-6\"]/div[1]/div/div/div")
	public List<WebElement> sliders;
		
	@FindBy(xpath = "//*[@id=\"themify_builder_content-22\"]/div[2]/div/div/div/div/div[2]/div")
	public List<WebElement> arrivals;

	//Click on Picture1
	@FindBy(xpath = "//*[@id=\"text-22-sub_row_1-0-2-0-0\"]/div/ul/li/a[1]")
	public WebElement picture1;
	
	//Verify picture1
	@FindBy(xpath = "//*[@id=\"product-160\"]/div[2]/h1")
	public WebElement verifyPictrue1;
	
	//Description Picture1
	@FindBy(xpath = "//*[@id=\"product-160\"]/div[3]/ul/li[1]/a")
	public WebElement descriptionPicture1Button;
	
	//Verify Description Picture1
	@FindBy(xpath = "//*[@id=\"tab-description\"]/h2")
	public WebElement verifyDescriptionPicture1Button;
	
	//Click on Picture2
	@FindBy(xpath = "//*[@id=\"text-22-sub_row_1-0-2-1-0\"]/div/ul/li/a[1]/img")
	public WebElement picture2;
	
	//Verify picture2
	@FindBy(xpath = "//*[@id=\"product-163\"]/div[2]/h1")
	public WebElement verifyPictrue2;
	
	//Description Picture2
	@FindBy(xpath = "//*[@id=\"product-163\"]/div[3]/ul/li[1]/a")
	public WebElement descriptionPicture2Button;
	
	//Verify Description Picture2
	@FindBy(xpath = "//*[@id=\"tab-description\"]/h2")
	public WebElement verifyDescriptionPicture2Button;
	
	//Click on Picture3
	@FindBy(xpath = "//*[@id=\"text-22-sub_row_1-0-2-2-0\"]/div/ul/li/a[1]/img")
	public WebElement picture3;
	
	//Verify picture3
	@FindBy(xpath = "//*[@id=\"product-165\"]/div[2]/h1")
	public WebElement verifyPictrue3;
	
	//Description Picture3
	@FindBy(xpath = "//*[@id=\"product-165\"]/div[3]/ul/li[1]/a")
	public WebElement descriptionPicture3Button;
		
	//Verify Description Picture3
	@FindBy(xpath = "//*[@id=\"tab-description\"]/h2")
	public WebElement verifyDescriptionPicture3Button;
	
	

	public void checkSlidersCount(int count) {

		Assert.assertEquals(count, sliders.size());
	}

	public void checkArrivalsCount(int count) {

		Assert.assertEquals(count, arrivals.size());
	}

	public void verifyImagesInArrivalsShouldNavigate() {
		
        String[] expectedTexts = new String[]{"Selenium Ruby", "Thinking in HTML", "Mastering JavaScript"};
        
        for(int i = 0; i<arrivals.size(); i++) {
            
          String pathText = String.format("//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div[%d]", i+1);
          //System.out.println(pathText);
          KanokwanBaseClass.getDriver().findElement(By.xpath(pathText)).click();
        
          String text = KanokwanBaseClass.getDriver().findElement(By.xpath("//*[@class='product_title entry-title']")).getText();
          //System.out.println(text);
          Assert.assertTrue(expectedTexts[i].equals(text)) ;                    
          KanokwanBaseClass.getDriver().navigate().back();            
        }
	}

	public void verifyImagesInArrivalsShouldNavigate_URL() {
		String url1 = "http://practice.automationtesting.in/product/selenium-ruby/";
		String url2 = "http://practice.automationtesting.in/product/thinking-in-html/";
		String url3 = "http://practice.automationtesting.in/product/mastering-javascript/";

		List<String> urls = new ArrayList<String>();

		urls.add(url1);
		urls.add(url2);
		urls.add(url3);

		for (int i = 0; i < arrivals.size(); i++) {

			WebElement eachItem = arrivals.get(i);

			eachItem.click();

			Assert.assertTrue(KanokwanBaseClass.getDriver().getCurrentUrl().equalsIgnoreCase(urls.get(i)));

			KanokwanBaseClass.getDriver().navigate().back();
		}
	}

	public void shopButton() {
		shopButton.click();
	}
	
	public void homeButton() {
		homeButton.click();
	}
	
	public void picture1() {
		picture1.click();
	}
	
	public void picture2() {
		picture2.click();
	}
	
	public void picture3() {
		picture3.click();
	}
	
	public void descriptionPicture1Button() {
		descriptionPicture1Button.click();	
	}
	
	public void verifyDescriptionPicture1() {
		Assert.assertTrue(verifyDescriptionPicture1Button.isDisplayed());
		KanokwanBaseClass.getDriver().navigate().back();
	}
	
	public void descriptionPicture2Button() {
		descriptionPicture2Button.click();	
	}
	
	public void verifyDescriptionPicture2() {
		Assert.assertTrue(verifyDescriptionPicture2Button.isDisplayed());
		KanokwanBaseClass.getDriver().navigate().back();
	}
	
	public void descriptionPicture3Button() {
		descriptionPicture3Button.click();	
}

	public void verifyDescriptionPicture3() {
		Assert.assertTrue(verifyDescriptionPicture3Button.isDisplayed());
		KanokwanBaseClass.getDriver().navigate().back();
	}
	
}


