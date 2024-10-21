package test;

import static helper.LoginHelper.performLogin;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import config.ConfigurationManager;
import config.TestConfig;
import helper.MessageLoader;
import page.login.LoginPage;
import page.login.MyViewPage;

public class LoginTest extends BaseWeb {

	private String username;
	private String password;
	private MessageLoader messageLoaderLoginErrorMessage;
	
	@BeforeClass
	public void setUp() {
		username = TestConfig.getUsername();
		password = TestConfig.getPassword();
		messageLoaderLoginErrorMessage = new MessageLoader();
	}

	

	@Test(description = "CT01 - Login com sucesso")
	public void loginCT01() {
		performLogin(username, password); // Usa método auxiliar para login

		MyViewPage myViewPage = new MyViewPage();
		
		boolean result = myViewPage.urlContains("my_view_page.php");

		Assert.assertTrue(result, "A URL atual não é a esperada após o login.");
	}
	
	@Test(description = "CT02 - Login com credenciais inválidas")
    public void loginCT02() {
        
		String invalidPassword = "invalid";
        String language = ConfigurationManager.configuration().getLanguage();
        String expected = messageLoaderLoginErrorMessage.getMessage("loginErrorMessage", language);

        performLogin(username, invalidPassword); // Usa método auxiliar para login

        String result = new LoginPage().getFeedback(); // Cria uma nova instância apenas para obter feedback
    
        Assert.assertEquals(result, expected);
    }

}
