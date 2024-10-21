package test;

import static helper.LoginHelper.performLogin;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import config.ConfigurationManager;
import config.TestConfig;
import helper.CreateEditTaskHelper;
import helper.MessageLoader;
import helper.TaskLoader;
import page.login.MyViewPage;
import page.login.TaskPage;
import pojo.Task;

public class CriarTarefaTest extends BaseWeb {
	
	private String username;
	private String password;
	private TaskLoader createTaskWithMandatoryFieldsOnly ;
	String category;
	String summary; 
	String description;
	private Task task;
	MessageLoader messageLoader;
	String language;

	@BeforeClass
	public void setUp() {
		username = TestConfig.getUsername();
		password = TestConfig.getPassword();
		language = ConfigurationManager.configuration().getLanguage();
		createTaskWithMandatoryFieldsOnly = new TaskLoader();
		String category = createTaskWithMandatoryFieldsOnly.getTaskProperty("createTaskWithMandatoryFieldsOnly",language, "category");
		String summary = createTaskWithMandatoryFieldsOnly.getTaskProperty("createTaskWithMandatoryFieldsOnly", language,"summary"); 
		String description = createTaskWithMandatoryFieldsOnly.getTaskProperty("createTaskWithMandatoryFieldsOnly",language, "description");
		task = new Task( category, summary, description);
		messageLoader = new MessageLoader();
	}

	
	
	@Test(description = "CT03 - Criar tarefa com campos obrigatórios ")
	public void createTaskTest03() {
		
		String expected = messageLoader.getMessage("createTaskSuccess", language);
		
		performLogin(username, password);

		MyViewPage myViewPage = new MyViewPage();
		
		myViewPage.waitCriarTarefa();
		
		myViewPage.clickCreateTaskButtons();
		
		TaskPage taskPage = new TaskPage();
		
		taskPage.waitCategory();
		
		CreateEditTaskHelper.fillTaskWithMandatoryFields(task);
		
		taskPage.createNewTask();
		
		String result = taskPage.getFeedbackSucessful();
	    
		 Assert.assertEquals(result, expected);
		
	}

	
}
