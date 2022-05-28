package thunpanBee51TestCases;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationProperties {
	public static Properties configFile;

 	static {
 		try {
 			// copy : path from content root OR absolute path
 			String path = "src/test/resources/thunpanBeePropertiesFolder.properties/config.properties";
 			FileInputStream input = new FileInputStream(path);

 			configFile = new Properties();
 			configFile.load(input);
 			input.close();
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 	}

 	public static String getProperty(String keyName) {
 		return configFile.getProperty(keyName);
 	}
}
