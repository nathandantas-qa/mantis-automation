package page.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;
import page.login.common.NavigationPage;

public class LoginPage extends NavigationPage {

	@FindBy(xpath = "//input[@id='username']")
    private WebElement username;

	
	@FindBy(xpath = "//div[@class='alert alert-danger']")
	private WebElement feedback;
	
	@Step
    public void fillUsername(String username) {
    	this.username.sendKeys(username);    	
    }	
	
	@Step
    public String  getFeedback() {
    	return this.feedback.getText();    	
    }	
	

}
	