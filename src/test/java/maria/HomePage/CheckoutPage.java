package maria.HomePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.ConfigurationProperties;
import Utilities.Driver;

public class CheckoutPage {

	public CheckoutPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	//changes to pushzzz
	@FindBy(xpath="//*[@id=\"page-34\"]/div/div[1]/div/div/div/a")
	public WebElement arrivalsubImg2CartProceedTocheckoutBTn;
	
	@FindBy(name="coupon_code")
	public WebElement couponCode;
	
	@FindBy(name="apply_coupon")
	public WebElement applyCoupon;
	
	@FindBy(xpath="//*[@class='woocommerce']/ul/li")
	public WebElement couponInvalid;
	
	@FindBy(partialLinkText="×")
	public WebElement removeBook;
	
	@FindBy(xpath="//*[@id=\"page-34\"]/div/div[1]")
	public WebElement removeBookConfirmMessage;
	
	
	@FindBy(xpath="//input[@title='Qty']")
	public WebElement increaseQuantity;
	

	@FindBy(xpath="//input[@name='update_cart']")
	public WebElement updateCartBtn;
	
	@FindBy(xpath="//*[@id=\"page-34\"]/div/div[1]/div[1]")
	public WebElement updateConfirmationMsg;
	
	@FindBy(xpath="//tr[@class='order-total']")
	public WebElement orderTotalChkout;
	
	
	
	@FindBy(xpath="//tr[@class='cart-subtotal']")
	public WebElement subTotalBTNcheckout;
	
	@FindBy(xpath="//tr[@class='order-total']")
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
	
	
	public void couponCodeEntry() {   
		couponCode.sendKeys(ConfigurationProperties.getProperty("CouponCode"));
		applyCoupon.click();
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
		
		increaseQuantity.clear();
		increaseQuantity.sendKeys(ConfigurationProperties.getProperty("increaseBookNoby"));
		
	}	
	
	public void updateCart() {
		Assert.assertTrue(updateCartBtn.isEnabled());
		updateCartBtn.click();
		Assert.assertTrue(updateConfirmationMsg.isDisplayed());
		
	}
	
	public void orderTotalChkout() {
	Assert.assertTrue(orderTotalChkout.isDisplayed());
	System.out.println(orderTotalChkout.getText());
	}
	
	public void totalSubTotalDisplay()  {
		Assert.assertTrue(subTotalBTNcheckout.isDisplayed());
		Assert.assertTrue(totalBTNcheckout.isDisplayed());

		String total = totalBTNcheckout.getText().substring(7);
		Double TotalFinal=Double.parseDouble(total);
		//System.out.println(total);
		String subTotal =subTotalBTNcheckout.getText().substring(10);
		Double SubTotalFinal=Double.parseDouble(subTotal);
		Assert.assertTrue(TotalFinal>SubTotalFinal);
		//System.out.println(subTotal);

		//Assert.assertTrue(Float.valueOf(total) > Float.valueOf(subTotal));

//		String totalBTNcheckout = tPrice.getText();
//		String subTotalBTNcheckout = stPrice.getText();
//		Assert.assertTrue(Double.valueOf(totalBTNcheckout.toString()) > Double.valueOf(subTotalBTNcheckout.toString()));
/*String value = subTotal.getText().substring(1, subTotal.getText().length());
		Double price = Double.parseDouble(value); 

		total.getText();
		String totalPrice=total.getText().substring(1, total.getText().length());
		Double TotalFinal=Double.parseDouble(totalPrice);
		Assert.assertTrue(TotalFinal>price);
		Thread.sleep(3000);*/
		
		
	}
	
	public void checkOutPagePayment() {
		Assert.assertTrue(checkOutPagePayment.isDisplayed());
	}
	
}
