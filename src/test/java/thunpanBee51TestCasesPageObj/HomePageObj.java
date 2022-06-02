package thunpanBee51TestCasesPageObj;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import thunpanBee51TestCases.ConfigurationProperties;
import thunpanBee51TestCases.Driver;
import thunpanBee51TestCases.ThunpanBeeConstant;

public class HomePageObj {

	ProductPageObj pp = new ProductPageObj();

	@FindBy(xpath = "//*[@id='menu-item-40']/a")
	private WebElement shopBtn;

	@FindBy(xpath = "//*[@class='n2-ss-slider-3']/div")
	public List<WebElement> hpSlide;

	@FindBy(xpath = "//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div")
	public List<WebElement> newArrivalImageList;

	@FindBy(xpath = "//*[@class='product_title entry-title']")
	public WebElement productLabel;

	public HomePageObj() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	public void clickShop() {
		shopBtn.click();
	}

	public void clickRelatedProduct() {
		Driver.clickOnProduct(newArrivalImageList, ConfigurationProperties.getInputDataProperty("HTML"));
		Driver.clickOnProduct(pp.relatedProductList, ConfigurationProperties.getInputDataProperty("relatedProduct"));
	}

	public void verifyHomePageSlide() {
		int actualHpSlide = hpSlide.size();
		int expectedSlide = ThunpanBeeConstant.hpSlide;
		System.out.println("Actual Homepage slide: " + actualHpSlide);
		System.out.println("Expected : " + expectedSlide);
		Assert.assertEquals(actualHpSlide, expectedSlide);
	}

	public void verifyNewArrivalSlide() {
		int actualImageSlide = newArrivalImageList.size();
		int expectedSlide = ThunpanBeeConstant.newArrivalSlide;
		System.out.println("Actual image slide: " + actualImageSlide);
		System.out.println("Expected : " + expectedSlide);
		Assert.assertEquals(actualImageSlide, expectedSlide);

	}

	public void verifyImagesInArrivalsShouldNavigate() {

		List<String> expected = new ArrayList<String>(Arrays.asList("Selenium", "HTML", "JavaScript"));
		for (int i = 0; i < newArrivalImageList.size(); i++) {
			newArrivalImageList.get(i).click();
			String label = pp.productLabel.getText();

			System.out.println("Label Displayed: " + label);
			System.out.println("Expected : " + expected.get(i));

			Assert.assertTrue(label.contains(expected.get(i)));

			Driver.getDriver().navigate().back();
		}
	}

}
