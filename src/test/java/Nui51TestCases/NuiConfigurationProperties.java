package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class NuiConfigurationProperties {
	
	public static Properties props;
	
	static {
		
		try {
			
			String path = "src/test/resources/propertiesFolder/51TestCases.properties";
			FileInputStream input = new FileInputStream(path);
			
			props = new Properties();
			props.load(input);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if(props != null)
			System.out.println("props creates");
	}
	
	public static String getKeyValue(String input) {
		return props.getProperty(input);
		
		
	}
	
}
