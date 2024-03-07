package NoBDD;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;

import Pages.LoginPageObjects;
import config.env;

public class Login_POM extends env {

	private static WebDriver driver = null;

	public static void main(String[] args) {
		login_success();
		// login_invalid();
		// login_empty();
	}

	public static void login_success() {
		LoginPageObjects loginPageObj = new LoginPageObjects(driver);
		loginPageObj.setUpDriver();
		loginPageObj.validateHeader();
		loginPageObj.goToSignIn();
		loginPageObj.inputUsername("qa1@test.com");
		loginPageObj.inputPassword("Abcd1234@");
		loginPageObj.clickButtonSignIn();
		loginPageObj.validateHeader();
		loginPageObj.driverQuit();
	}

	public static void login_invalid() {
		LoginPageObjects loginPageObj = new LoginPageObjects(driver);
		loginPageObj.setUpDriver();
		loginPageObj.validateHeader();
		loginPageObj.goToSignIn();
		loginPageObj.inputUsername("qa1@test.com");
		loginPageObj.inputPassword("12345678");
		loginPageObj.clickButtonSignIn();
		loginPageObj.alertIncorrect();
		loginPageObj.driverQuit();
	}

	public static void login_empty() {
		LoginPageObjects loginPageObj = new LoginPageObjects(driver);
		loginPageObj.setUpDriver();
		loginPageObj.validateHeader();
		loginPageObj.goToSignIn();
		loginPageObj.clickButtonSignIn();
		loginPageObj.alertRequired();
		loginPageObj.driverQuit();
	}

}
