package helper;

import page.login.LoginPage;
import page.login.LoginPasswordPage;

public class LoginHelper {
	 public static void performLogin(String username, String password) {
	        LoginPage loginPage = new LoginPage();
	        loginPage.fillUsername(username);
	        loginPage.entrar();

	        LoginPasswordPage loginPasswordPage = new LoginPasswordPage();
	        loginPasswordPage.fillPassword(password);
	        loginPasswordPage.entrar();
	    }
}
