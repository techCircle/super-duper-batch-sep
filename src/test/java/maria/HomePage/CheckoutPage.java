package maria.HomePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import mariaUtilities.ConfigurationProperties;
import mariaUtilities.Driver;



public class CheckoutPage {

	public CheckoutPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	//changes to pushzzz
	@FindBy(xpath="//*[@id=\"page-34\"]/div/div[1]/div/div/div/a")
	public WebElement arrivalsubImg2CartProceedTocheckoutBTn;
	
	@FindBy(xpath="//input[@id='coupon_code']")
	public WebElement couponCode;
	
	@FindBy(name="apply_coupon")
	public WebElement applyCoupon;
	
	@FindBy(xpath="//*[@class='woocommerce']/ul/li")
	public WebElement couponInvalid;
	
	@FindBy(partialLinkText="×")
	public WebElement removeBook;
	
	@FindBy(xpath="//*[@id=\"page-34\"]/div/div[1]")
	public WebElement removeBookConfirmMessage;
	
	
	@FindBy(xpath="//*[@id=\"page-34\"]/div/div[1]/form/table/tbody/tr[1]/td[5]/div/input")
	public WebElement increaseQuantity;
	

	@FindBy(xpath="//input[@name='update_cart']")
	public WebElement updateCartBtn;
	
	@FindBy(xpath="//*[@id=\"page-34\"]/div/div[1]/div[1]")
	public WebElement updateConfirmationMsg;
	
	@FindBy(xpath="//tr[@class='order-total']")
	public WebElement orderTotalChkout;
	
	
	
	@FindBy(xpath="//td[@data-title='Subtotal']//span[@class='woocommerce-Price-amount amount']")
	public WebElement subTotalBTNcheckout;
	
	@FindBy(xpath="//strong//span[@class='woocommerce-Price-amount amount']")
	public WebElement totalBTNcheckout;
	

	@FindBy(xpath="//*[@id=\"payment\"]")
	public WebElement checkOutPagePayment;
	
	@FindBy (xpath = "//tr[@class='order-total']/td/strong/span")
	public WebElement tPrice;

	@FindBy (xpath = "//tr[@class='cart-subtotal']/td/span")
	public WebElement stPrice;
	
	
	
	//Methods
	public void arrivalsubImg2CartProceedTocheckoutBtn() {
		Assert.assertTrue(arrivalsubImg2CartProceedTocheckoutBTn.isDisplayed());
		
	}
	
	
	public void couponCodeEntry() throws InterruptedException {   
		couponCode.sendKeys(ConfigurationProperties.getProperty("CouponCode"));
		applyCoupon.click();
		Thread.sleep(1000);
		Assert.assertTrue(couponInvalid.isDisplayed());
		
	}
	
	public void couponCodeCondition() {    
		
		if(couponInvalid.isDisplayed()){
			System.out.println("Coupon is applicable for the book price > 450 rps");
		};
		
			
	}
	
	public void removeBook() {  
		removeBook.click();
		Assert.assertTrue(removeBookConfirmMessage.isDisplayed());
	}
	
	public void updateBasketCheck(){
		increaseQuantity.click();
		increaseQuantity.clear();
			increaseQuantity.sendKeys(ConfigurationProperties.getProperty("increaseBookNoby"));

		}
		
		public void cheeckoutBtnClick() {
			
		}
		
	
	
	public void updateCart() {
		Assert.assertTrue(updateCartBtn.isEnabled());
		updateCartBtn.click();
		Assert.assertTrue(updateConfirmationMsg.isDisplayed());
		
	}
	
	public void orderTotalChkout() {
	Assert.assertTrue(orderTotalChkout.isDisplayed());
	System.out.println("Total= "+orderTotalChkout.getText().substring(7));
	}
	
	public void totalSubTotalDisplay()  {
		Assert.assertTrue(subTotalBTNcheckout.isDisplayed());
		Assert.assertTrue(totalBTNcheckout.isDisplayed());

				
	
		//System.out.println(total);
		String subTotal =subTotalBTNcheckout.getText();
         String total = totalBTNcheckout.getText();
		
		if (total.contains(",")&&subTotal.contains(",")) {
			total.replaceAll(",", "");
		subTotal.replaceAll(",", "");
			Double TotalFinal=Double.parseDouble(total);
		Double SubTotalFinal=Double.parseDouble(subTotal);
		Assert.assertTrue(TotalFinal>SubTotalFinal);
		}
		System.out.println(subTotal);
		
	}
	
	public void checkOutPagePayment() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(checkOutPagePayment.isDisplayed());
	}
	
}
