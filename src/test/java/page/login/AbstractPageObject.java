package page.login;

import static config.ConfigurationManager.configuration;
import static org.openqa.selenium.support.PageFactory.initElements;

import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import driver.DriverManager;
import helper.WaitHelper;
import io.qameta.allure.Step;

public class AbstractPageObject {
	protected WaitHelper wait;
	
	protected AbstractPageObject() {
		initElements(new AjaxElementLocatorFactory(DriverManager.getDriver(), configuration().getTimeout()), this);
		wait = new WaitHelper(DriverManager.getDriver());
	}
	
	@Step
	public boolean urlContains(String url) {
		return wait.urlContains(url);
	}
}
