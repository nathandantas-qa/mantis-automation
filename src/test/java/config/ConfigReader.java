package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

	private Properties properties = new Properties();

	public ConfigReader(String fileName) {
		reader(fileName);
	}

	public ConfigReader() {
		reader("general.properties");
	}

	private void reader(String fileName) {
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName)) {
			if (inputStream != null) {
				properties.load(inputStream);
			} else {
				throw new RuntimeException("Arquivo de configuração '" + fileName + "' não encontrado no classpath");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getTarget() {
		return properties.getProperty("target");
	}

	public String getBrowser() {
		return properties.getProperty("browser");
	}

	public String getBaseUrl() {
		return properties.getProperty("url.base");
	}

	public int getTimeout() {
		return Integer.parseInt(properties.getProperty("timeout"));
	}

	public boolean getHeadless() {
		try {
			return Boolean.parseBoolean(properties.getProperty("headless"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	public String getUsername() {
		return properties.getProperty("username");
	}

	public String getPassword() {
		return properties.getProperty("password");
	}

	public String getLanguage() {
		return properties.getProperty("language");
	}
}
