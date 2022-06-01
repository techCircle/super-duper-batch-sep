package thunpanBee51TestCases;

import java.io.FileInputStream;

import java.util.Properties;

public class ConfigurationProperties {
	public static Properties configFile;
	public static Properties configFileInput;

	static {
		try {
			// copy : path from content root OR absolute path
// 			String path = "src/test/resources/thunpanBeePropertiesFolder.properties/config.properties";
			String path = ThunpanBeeConstant.config_file;
			String path2 = ThunpanBeeConstant.config_input_data;
			FileInputStream input = new FileInputStream(path);
			FileInputStream input2 = new FileInputStream(path2);

			configFile = new Properties();
			configFile.load(input);
			input.close();

			configFileInput = new Properties();
			configFileInput.load(input2);
			input2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String keyName) {
		return configFile.getProperty(keyName);
	}

	public static String getInputDataProperty(String name) {
		return configFileInput.getProperty(name);
	}
}
