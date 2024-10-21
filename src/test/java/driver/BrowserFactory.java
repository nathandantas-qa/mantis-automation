package driver;

import static driver.BrowserData.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

import config.ConfigurationManager;


public enum BrowserFactory {

    CHROME {
        @Override
        public WebDriver createLocalDriver() {
            return new ChromeDriver(getOptions());
        }

        @Override
        public ChromeOptions getOptions() {
            var chromeOptions = new ChromeOptions();
            chromeOptions.addArguments(START_MAXIMIZED);
            chromeOptions.addArguments(DISABLE_INFOBARS);
            chromeOptions.addArguments(DISABLE_NOTIFICATIONS);
            chromeOptions.addArguments(REMOTE_ALLOW_ORIGINS);

            if ((ConfigurationManager.configuration()).getHeadless()) chromeOptions.addArguments(CHROME_HEADLESS);

            return chromeOptions;
        }
    }, FIREFOX {
        @Override
        public WebDriver createLocalDriver() {
            return new FirefoxDriver(getOptions());
        }

      
        @Override
        public FirefoxOptions getOptions() {
            var firefoxOptions = new FirefoxOptions();
            
            firefoxOptions.addArguments(START_MAXIMIZED);

            if ((ConfigurationManager.configuration()).getHeadless()) firefoxOptions.addArguments(GENERIC_HEADLESS);
            
            return firefoxOptions;
        }
    };

	public abstract WebDriver createLocalDriver();

    public abstract AbstractDriverOptions<?> getOptions();

}