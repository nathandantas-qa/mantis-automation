package test;

import static config.ConfigurationManager.configuration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import driver.DriverManager;
import driver.TargetFactory;

public abstract class BaseWeb {

    private static final String baseUrl = configuration().getBaseUrl();

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void setup(@Optional("chrome") String browser) {
		WebDriver driver = new TargetFactory().createInstance(browser);
		DriverManager.setDriver(driver);
		
		DriverManager.getDriver().get(baseUrl);
	}

	
	@AfterMethod(alwaysRun = true)
	public void postCondition() {
		if (DriverManager.getDriver() != null) {
        	DriverManager.quit();         
        }
	}

	protected String currentUrl() {
		return 	DriverManager.getDriver().getCurrentUrl();
	}
}
