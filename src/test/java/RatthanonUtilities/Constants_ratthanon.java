package RatthanonUtilities;

public class Constants_ratthanon {
	
	public static final String config_filePath = System.getProperty("user.dir")+ "/src/test/resources/propertiesFolder/Ratthanon.properties";
	
	public static final int implicitWaitTime = 10;
	
	public static final int slidersCount = 3;
	
	public static final int arrivalsCount = 3;
	
	public static final int slideNumber = 450;
	
	public static final String titleweb[] = {"selenium-ruby","thinking-in-html","mastering-javascript"};
	
	public static final String username = "pradatop@hotmail.com";
	public static final String Invalidusername = "pradatopoo@hotmail";
	public static final String Registerusername = "OnEall10005_kkk@hotmail.com";
	
	public static final String password = "@Prada252627282930!?";
	public static final String Invalidpassword = "@Prada252627282930!??";
	public static final String Registerpassword = "@Phu30272819!!@@111111111138394955";
	
	
	public static final String Popularity_item= "popularity";
	public static final String Averageratings = "rating";
	public static final String Newnessratings = "date";	
	public static final String LowtoHigh = "price";
	public static final String HightoLow = "price-desc";
	
	
	public static final String messageInvalidUser ="ERROR: Invalid username.";
	public static final String messageInvalidUserPassword = "A user could not be found with this email address.";
	public static final String messageCorrectUserEmptyPassword = "Error: Password is required.";
	public static final String messageEmtyUservalidPassword ="Error: Username is required.";
	
	public static final String RegisterusernameTest = "OnEall10005_kkk1455Togo@hotmail.com";
	
	public static final String RegisterwithAlreadyAccout = "Error: An account is already registered with your email address. Please login.";
	
	public static final String productCode = "krishnasakinala";
	public static final String errorCoupon = "Coupon usage limit has been reached.";
	
	public static final String removeItemMessage = "removed.";
	
	public static final String UpdateBasketMessage = "Basket updated.";
	
	
	
	
	
	

	
	
	
	public static void main(String[] args) {
		System.out.println(config_filePath);
	}
	

}
