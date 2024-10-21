package page.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import io.qameta.allure.Step;
import page.login.common.NavigationPage;

public class TaskPage  extends NavigationPage{

	@FindBy(xpath = "//select[@id='category_id']")
	 private WebElement category;
	
	@FindBy(xpath = "//input[@id='summary']")
	 private WebElement summary;
	
	@FindBy(xpath = "//textarea[@id='description']")
	private WebElement description;
	
	@FindBy(xpath = "//p[@class='bold bigger-110']")
	private WebElement feedbackSucessful;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement createNewTask;
	
	@Step
	public void createNewTask() {
		createNewTask.click();
    }
	
	@Step
	public String getFeedbackSucessful() {
		return wait.waitElementToBeClickableWithShouldRetry(feedbackSucessful).getText();
    }
	
	@Step
	public void waitCategory() {
		wait.waitElementToBeClickableWithShouldRetry(category);
    }
	
	@Step
	public void selectedCategory(String value) {
		Select dropdown = new Select(wait.waitElementToBeClickableWithShouldRetry(category));
		dropdown.selectByVisibleText(value);
    }	
	@Step
	public void fillSummary(String value) {
		summary.sendKeys(value);
	}

	@Step
	public void fillDescription(String value) {
		description.sendKeys(value);
	}
	
}
