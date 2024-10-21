package page.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Param;
import io.qameta.allure.Step;
import io.qameta.allure.model.Parameter.Mode;
import page.login.common.NavigationPage;

public class LoginPasswordPage extends NavigationPage {
	@FindBy(xpath = "//input[@id='password']")
    private WebElement password;

	@Step
    public void fillPassword(@Param(mode=Mode.MASKED )String password) {
		this.password.sendKeys(password);    	
    }	
}
