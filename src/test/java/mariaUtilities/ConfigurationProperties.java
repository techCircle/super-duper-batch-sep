package mariaUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationProperties {
	
	public static Properties configfile;  //here properties is a class already present and we 
	//are initializing it here like we initialize webdriver if you hover over it you will get
	//the description and giving it a variable name
// Ex.	public static WebDdriver driver;

	//changes to push
	
	static {

		try {
			String path = "src/test/resources/propertiesFolder/config.properties";
			FileInputStream input = new FileInputStream(path);//FileInputStream is also a class like scanner and if you 
			//hover over it  you will see. its function is to fetch the data from
			//this path src/test/resources/propertiesFolder/userData.properties // which is the userData files

			configfile = new Properties();
			configfile.load(input); // now this will load the key and values from userData.properties files
			//hover over load and you will see 

			input.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String getProperty(String keyName) {

		return configfile.getProperty(keyName);// we will call this method in our other files to get the properties
	}
	
	

}
