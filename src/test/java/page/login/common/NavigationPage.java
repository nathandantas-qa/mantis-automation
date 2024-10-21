package page.login.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import driver.DriverManager;
import io.qameta.allure.Step;
import page.login.AbstractPageObject;

public class NavigationPage extends AbstractPageObject {

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement entrar;

	@FindBy(xpath = "//a[@class='btn btn-primary btn-sm'][contains(.,'Criar Tarefa')]")
	private WebElement createTaskButtonSuperiorSelector;
	
	@FindBy(xpath = "//span[contains(.,'Criar Tarefa')]")
	private WebElement createTaskButtonLateralSelectorCriarTarefa;

	@FindBy(xpath = "//i[contains(@class,'menu-icon fa fa-edit')]")
	private WebElement createTaskButtonLateralSelector;
	
	@Step
	public void entrar() {
		entrar.click();
	}
	
	@Step
	public void waitCriarTarefa() {
	    super.wait.waitElementToBeClickableWithShouldRetry(createTaskButtonLateralSelector);
	}
	
	@Step
	public void clickCreateTaskButtons() {
	    Actions actions = new Actions(DriverManager.getDriver());
	    actions.click(createTaskButtonLateralSelector).perform();	    
	}
	
	@Step
	public void clickCreateTaskByMenu() {
		this.createTaskButtonLateralSelector.click();
	}
	
	public void waitForCriarTarefa() {
		
	}
	
}