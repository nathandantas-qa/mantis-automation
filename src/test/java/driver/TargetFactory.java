package driver;

import static config.ConfigurationManager.configuration;
import static driver.BrowserFactory.valueOf;

import org.openqa.selenium.WebDriver;

import enums.Target;

public class TargetFactory {

    public WebDriver createInstance(String browser) {
        Target target = Target.get(configuration().getTarget().toUpperCase());

        return switch (target) {
            case LOCAL -> valueOf(configuration().getBrowser().toUpperCase()).createLocalDriver();
            case LOCAL_SUITE -> valueOf(browser.toUpperCase()).createLocalDriver();            
        };
    }
  
}