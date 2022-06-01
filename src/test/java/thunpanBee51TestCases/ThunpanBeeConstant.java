package thunpanBee51TestCases;

public class ThunpanBeeConstant {
	

	public static final String config_file = System.getProperty("user.dir")
			+ "/src/test/resources/thunpanBeePropertiesFolder.properties/config.properties";
	public static final String config_input_data = System.getProperty("user.dir")
			+ "/src/test/resources/thunpanBeePropertiesFolder.properties/input_data.properties";

	public static final int implicitWait = 10;
	public static final double price = 450.00;
	public static final String productLabel="HTML";
	public static final String outOfStock="Out";
	public static final int hpSlide=3;
	public static final int newArrivalSlide=3;
	
	/////////////////////////////////////////////
	public static final String updateExp="updated";
	public static final String desExp="Product Description";
	public static final String couponExp="Coupon";
	public static final String reviewExp="Reviews";
	public static final String removeExp="removed";
	public static final String totalTextExp="Total";
}
