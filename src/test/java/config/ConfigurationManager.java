package config;

public class ConfigurationManager {
	private static ConfigReader config;
	
	private ConfigurationManager() {
	}

	public static ConfigReader configuration() {
		if (config == null) config = new ConfigReader();
		
		return config;
	}
}
