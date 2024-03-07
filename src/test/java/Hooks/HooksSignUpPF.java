package Hooks;

import java.util.Random;

import org.openqa.selenium.WebDriver;

import PageFactory.SignupPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HooksSignUpPF {
    private static WebDriver driver = null;

    public HooksSignUpPF(){
        driver = Hooks.driver;
    }

    @Given("User on homepage")
    public void user_on_homepage() throws InterruptedException {
        SignupPage signup = new SignupPage(driver);
        signup.verifyHomepage();
    }

    @Given("User go to Create an Account page")
    public void user_go_to_create_an_account_page() throws InterruptedException {
        SignupPage signup = new SignupPage(driver);
        signup.goToSignUpPage();
    }

    @And("User input Personal Information")
    public void user_input_personal_information() {
        SignupPage signup = new SignupPage(driver);
        signup.inputPersonalInformation("qa", "testing");
    }
    
    @When("User input Sign In Information")
    public void user_input_sign_in_information() {
        SignupPage signup = new SignupPage(driver);
        //Random number for email address
        Random rand = new Random();
        int userRand = rand.nextInt(10000);
        signup.inputSignInInformation("qa"+userRand+"@testing.com", "Qa1234@&", "Qa1234@&");
    }

    @And("User click button Create an Account")
    public void user_click_button_create_an_account() {
        SignupPage signup = new SignupPage(driver);
        signup.clickBtnSignUp();
    }

    @Then("User is navigated to Account page")
    public void user_is_navigated_to_account_page() {
        SignupPage signup = new SignupPage(driver);
        signup.verifySignUp();
    }

    //Negative Test - Mismatch Password

    @And("User input Sign In Information with mismatch password")
    public void user_input_sign_in_information_with_mismatch_password() {
        SignupPage signup = new SignupPage(driver);
        //Random number for email address
        Random rand = new Random();
        int userRand = rand.nextInt(10000);
        signup.inputSignInInformation("qa"+userRand+"@testing.com", "Qa1234@&", "Qa123411");
    }

    @Then("User get password mismatch alert")
    public void user_get_password_mismatch_alert() {
        SignupPage signup = new SignupPage(driver);
        signup.mismatchPassAlert();
    }

    //Negative Test - Weak Password
    
    @And("User input Sign In Information with weak password")
    public void user_input_sign_in_information_with_weak_password() {
        SignupPage signup = new SignupPage(driver);
        //Random number for email address
        Random rand = new Random();
        int userRand = rand.nextInt(10000);
        signup.inputSignInInformation("qa"+userRand+"@testing.com", "12345678", "12345678");
    }
    
    @Then("User get password weak alert")
    public void user_get_password_weak_alert() {
        SignupPage signup = new SignupPage(driver);
        signup.weakPassAlert();
    }

    //Negative Test - Empty credentials

    @Then("User get required field alert")
    public void user_get_required_field_alert() {
        SignupPage signup = new SignupPage(driver);
        signup.requiredAlert();
    }

    //Positive Test - User Create Account redirect from login page

    @And("User go to Sign In page")
    public void user_go_to_sign_in_page() {
        SignupPage signup = new SignupPage(driver);
        signup.clickSignIn();
    }

    @And("User click button Create an Account for New Customer")
    public void user_click_button_create_an_account_for_new_customer() {
        SignupPage signup = new SignupPage(driver);
        signup.clickSignUp();
    }
}
