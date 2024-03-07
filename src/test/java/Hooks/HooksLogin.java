package Hooks;

import Pages.LoginPageObjects;
import config.env;
import io.cucumber.java.en.*;

public class HooksLogin extends env {

	public HooksLogin() {
		driver = Hooks.driver;
	}

	// General
	@Given("User on a homepage")
	public void user_on_a_homepage() {
		LoginPageObjects loginPageObj = new LoginPageObjects(driver);
		loginPageObj.validateHeader();
	}

	@Then("User go to a Sign In Page")
	public void user_go_to_a_sign_in_page() {
		LoginPageObjects loginPageObj = new LoginPageObjects(driver);
		loginPageObj.goToSignIn();
	}

	@And("User click button Sign In")
	public void user_click_button_sign_in() {
		LoginPageObjects loginPageObj = new LoginPageObjects(driver);
		loginPageObj.clickButtonSignIn();
	}

	// Positive Test

	@And("User input valid credentials")
	public void user_input_valid_credentials() {
		LoginPageObjects loginPageObj = new LoginPageObjects(driver);
		loginPageObj.inputUsername("qa1@test.com");
		loginPageObj.inputPassword("Abcd1234@");
	}

	@Then("User redirect to homepage")
	public void user_redirect_to_homepage() {
		LoginPageObjects loginPageObj = new LoginPageObjects(driver);
		loginPageObj.validateHeader();
	}

	// Negative Test - Invalid Credentials
	@Then("User input invalid credentials")
	public void user_input_invalid_credentials() {
		LoginPageObjects loginPageObj = new LoginPageObjects(driver);
		loginPageObj.inputUsername("qa1@test.com");
		loginPageObj.inputPassword("12345678");
	}

	@Then("User get alert the account incorrect")
	public void user_get_alert_the_account_incorrect() {
		LoginPageObjects loginPageObj = new LoginPageObjects(driver);
		loginPageObj.alertIncorrect();
	}

	// Negative Test - Empty Credentials

	@Then("User get alert required field")
	public void user_get_alert_required_field() {
		// find elements with text 'required field'
		LoginPageObjects loginPageObj = new LoginPageObjects(driver);
		loginPageObj.alertRequired();
	}

	// Forgot Password
	@Then("User click button Forgot Your Password")
	public void user_click_button_forgot_your_password() {
		LoginPageObjects loginPageObj = new LoginPageObjects(driver);
		loginPageObj.clickForgotPass();
	}

	@Then("User input email")
	public void user_input_email() {
		LoginPageObjects loginPageObj = new LoginPageObjects(driver);
		loginPageObj.inputEmail();
	}

	@And("User click button Reset Password")
	public void user_click_button_reset_password() {
		LoginPageObjects loginPageObj = new LoginPageObjects(driver);
		loginPageObj.clickResetPass();
	}
}
