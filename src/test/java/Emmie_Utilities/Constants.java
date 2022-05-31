package Emmie_Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationProperties {
	// using properties class to call properties
		public static Properties configfile;

		// example
		// public static WebDriver driver;

		static {

			try {
				// path the file
				String path = "src/test/resources/propertiesFolder/Emmie.properties";

				FileInputStream input = new FileInputStream(path);

				configfile = new Properties();
				// load everything in configFile
				configfile.load(input);

				input.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		public static String getProperty(String keyName) {

			return configfile.getProperty(keyName);

		}

}
