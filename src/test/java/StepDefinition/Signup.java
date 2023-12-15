package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.env;
import io.cucumber.java.en.*;
import java.time.Duration;
import java.util.Random;


public class Signup extends env{
    //General
    @Given("User on homepage")
    public void user_on_homepage() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(MagentoLink);
        Duration duration = Duration.ofSeconds(3);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-3"))
        );
    }

    @Given("User go to Create an Account page")
    public void user_go_to_create_an_account_page() {
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a")).click();
    }

    @And("User input Personal Information")
    public void user_input_personal_information() {
        driver.findElement(By.id("firstname")).sendKeys("QA");
        driver.findElement(By.id("lastname")).sendKeys("Testing");
    }
    
    @And("User click button Create an Account")
    public void user_click_button_create_an_account() {
        driver.findElement(By.cssSelector("button[title='Create an Account'] span")).click();
    }

    //Positive Test

    @When("User input Sign In Information")
    public void user_input_sign_in_information() {
        //Random number for email address
        Random rand = new Random();
        int userRand = rand.nextInt(10000);
        driver.findElement(By.id("email_address")).sendKeys("qa"+userRand+"@test.com");
        driver.findElement(By.id("password")).sendKeys("Abcd1234@");
        driver.findElement(By.id("password-confirmation")).sendKeys("Abcd1234@");
    }
    
    @Then("User is navigated to Account page")
    public void user_is_navigated_to_account_page() {
        Duration duration = Duration.ofSeconds(3);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='nav item current']//strong[contains(text(),'My Account')]"))
        );
        driver.close();
    }

    //Negative Test - Mismatch Password

    @And("User input Sign In Information with mismatch password")
    public void user_input_sign_in_information_with_mismatch_password() {
        //Random number for email address
        Random rand = new Random();
        int userRand = rand.nextInt(10000);
        driver.findElement(By.id("email_address")).sendKeys("qa"+userRand+"@test.com");
        driver.findElement(By.id("password")).sendKeys("Abcd1234@");
        driver.findElement(By.id("password-confirmation")).sendKeys("Wxyz1234#");
    }

    @Then("Username get password mismatch alert")
    public void username_get_password_mismatch_alert() {
        WebElement passalert = driver.findElement(By.id("password-confirmation-error"));
        passalert.isDisplayed();
        driver.close();
    }

    //Negative Test - Weak Password
    
    @And("User input Sign In Information with weak password")
    public void user_input_sign_in_information_with_weak_password() {
        //Random number for email address
        Random rand = new Random();
        int userRand = rand.nextInt(10000);
        driver.findElement(By.id("email_address")).sendKeys("qa"+userRand+"@test.com");
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.id("password-confirmation")).sendKeys("12345678");
    }
    
    @Then("Username get password weak alert")
    public void username_get_password_weak_alert() {
        //find elements with text 'Weak'
        WebElement weakpass = driver.findElement(By.xpath("//*[contains(text(), 'Weak')]"));
        weakpass.isDisplayed();
        driver.close();
    }

    //Negative Test - Empty Credentials

    @Then("User get required field alert")
    public void user_get_required_field_alert() {
        //find elements with text 'required field'
        WebElement emptyfield = driver.findElement(By.xpath("//*[contains(text(), 'This is a required field.')]"));
        emptyfield.isDisplayed();
        driver.close();
    }

    //Positive Test - User Create Account redirect from login page

    @And("User go to Sign In page")
    public void user_go_to_sign_in_page() {
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();
    }

    @And("User click button Create an Account for New Customer")
    public void user_click_button_create_an_account_for_new_customer() {
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[3]/div[2]/div[2]/div/div/a")).click();
    }
}
