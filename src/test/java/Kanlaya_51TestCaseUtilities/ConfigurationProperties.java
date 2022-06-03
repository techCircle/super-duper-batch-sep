package Kanlaya_51TestCaseUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationProperties extends Base {

	public static Properties configFile;

	// example.
	// public static WebDriver driver;

	static {

		try {
			String path = Constants.config_filePath;
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
