package POM;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageFactory.SignupPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUp_PF {
    private static WebDriver driver = null;

    // public static void main(String[] args) throws InterruptedException {
    //     success_signup();
    //     mismatchPass_signup();
    //     weakPass_signup();
    //     emptyCredentials_signup();
    // }

    // public static void success_signup() throws InterruptedException{
    //     System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    //     driver = new ChromeDriver();
    //     driver.manage().window().maximize();
    //     driver.get("https://magento.softwaretestingboard.com/");

    //     SignupPage signup = new SignupPage(driver);
    //     signup.goToSignUpPage();
    //     signup.inputPersonalInformation("qa", "testing");
    //     //Random number for email address
    //     Random rand = new Random();
    //     int userRand = rand.nextInt(10000);
    //     signup.inputSignInInformation("qa"+userRand+"@testing.com", "Qa1234@&", "Qa1234@&");
    //     signup.clickBtnSignUp();
    //     signup.verifySignUp();
    //     driver.close();
    // }

    // public static void mismatchPass_signup() throws InterruptedException{
    //     System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    //     driver = new ChromeDriver();
    //     driver.manage().window().maximize();
    //     driver.get("https://magento.softwaretestingboard.com/");

    //     SignupPage signup = new SignupPage(driver);
    //     signup.goToSignUpPage();
    //     signup.inputPersonalInformation("qa", "testing");
    //     //Random number for email address
    //     Random rand = new Random();
    //     int userRand = rand.nextInt(10000);
    //     signup.inputSignInInformation("qa"+userRand+"@testing.com", "Qa1234@&", "Qa123411");
    //     signup.clickBtnSignUp();
    //     signup.mismatchPassAlert();
    //     driver.close();
    // }

    // public static void weakPass_signup() throws InterruptedException{
    //     System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    //     driver = new ChromeDriver();
    //     driver.manage().window().maximize();
    //     driver.get("https://magento.softwaretestingboard.com/");

    //     SignupPage signup = new SignupPage(driver);
    //     signup.goToSignUpPage();
    //     signup.inputPersonalInformation("qa", "testing");
    //     //Random number for email address
    //     Random rand = new Random();
    //     int userRand = rand.nextInt(10000);
    //     signup.inputSignInInformation("qa"+userRand+"@testing.com", "12345678", "12345678");
    //     signup.weakPassAlert();
    //     driver.close();
    // }

    // public static void emptyCredentials_signup() throws InterruptedException{
    //     System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    //     driver = new ChromeDriver();
    //     driver.manage().window().maximize();
    //     driver.get("https://magento.softwaretestingboard.com/");

    //     SignupPage signup = new SignupPage(driver);
    //     signup.goToSignUpPage();
    //     signup.clickBtnSignUp();
    //     signup.requiredAlert();
    //     driver.close();
    // }

    @Given("User on homepage")
    public void user_on_homepage() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
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
        signup.driverQuit();
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
        signup.driverQuit();
    }

    //Negative Test - Empty credentials

    @Then("User get required field alert")
    public void user_get_required_field_alert() {
        SignupPage signup = new SignupPage(driver);
        signup.requiredAlert();
        signup.driverQuit();
    }
}
