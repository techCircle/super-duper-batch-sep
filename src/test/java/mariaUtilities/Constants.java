package mariaUtilities;

public class Constants {
	
	
	
	//public static final String config_filePath=System.getProperty("user.dir")+"/src/test/resources/propertiesFolder/config.properties";
	// we use static to use it any where without creating its object
	// final means constant value 
	
	// now see base class where we used this as a constant
	
	//public static final int implicitWaitTime=10;
	//public static final String config_filePath = System.getProperty("user.dir")+ "/src/test/resources/propertiesFolder/config.properties";
	public static final String excelFilePath = System.getProperty("user.dir")+ "C:\\Users\\mmari\\eclipse-workspace\\batch10Selenium\\src\\test\\resources\\ExcelFolder\\MariaExcel.xlsx";
	public static final int implicitWaitTime = 10;

	public static final int slidersCount = 3;

	public static final int arrivalsCount = 3;

}
