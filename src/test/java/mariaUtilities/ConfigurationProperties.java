package mariaUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationProperties {
	
	public static Properties configfile;  
	
	static {
		System.out.println("before");
		try {
			String path = "src/test/resources/propertiesFolder/mariaConfig.properties";
			FileInputStream input = new FileInputStream(path);
			configfile = new Properties();
			configfile.load(input); 

			input.close();
System.out.println("hiii");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String getProperty(String keyName) {

		return configfile.getProperty(keyName);// we will call this method in our other files to get the properties
	}
	
	

}
