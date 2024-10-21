package config;

import static config.ConfigurationManager.configuration;

public class TestConfig {
	
	private static final String username = configuration().getUsername();
    private static final String password = configuration().getPassword();

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }
}
