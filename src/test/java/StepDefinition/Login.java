package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.env;
import io.cucumber.java.en.*;
import java.time.Duration;

public class Login extends env {
	// General
	@Given("User on a homepage")
	public void user_on_a_homepage() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(MagentoLink);
		Duration duration = Duration.ofSeconds(3);
		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-3")));
	}

	@Then("User go to a Sign In Page")
	public void user_go_to_a_sign_in_page() {
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();
	}

	@And("User click button Sign In")
	public void user_click_button_sign_in() {
		driver.findElement(By.id("send2")).click();
	}

	// Positive Test

	@And("User input valid credentials")
	public void user_input_valid_credentials() {
		driver.findElement(By.id("email")).sendKeys("qa1@test.com");
		driver.findElement(By.id("pass")).sendKeys("Abcd1234@");
	}

	@Then("User redirect to homepage")
	public void user_redirect_to_homepage() {
		Duration duration = Duration.ofSeconds(3);
		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-3")));
		driver.close();
	}

	// Negative Test - Invalid Credentials
	@Then("User input invalid credentials")
	public void user_input_invalid_credentials() {
		driver.findElement(By.id("email")).sendKeys("qa1@test.com");
		driver.findElement(By.id("pass")).sendKeys("WXYZ1234");
	}

	@Then("User get alert the account incorrect")
	public void user_get_alert_the_account_incorrect() {
		Duration duration = Duration.ofSeconds(3);
		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'The account sign-in was incorrect')]")));
		driver.quit();
	}

	// Negative Test - Empty Credentials

	@Then("User get alert required field")
	public void user_get_alert_required_field() {
		// find elements with text 'required field'
		WebElement emptyfield = driver.findElement(By.xpath("//*[contains(text(), 'This is a required field.')]"));
		emptyfield.isDisplayed();
		driver.close();
	}

	// Forgot Password
	@Then("User click button Forgot Your Password")
	public void user_click_button_forgot_your_password() {
		driver.findElement(By.xpath("//a[@class='action remind']//span[contains(text(),'Forgot Your Password?')]"))
				.click();
	}

	@Then("User input email")
	public void user_input_email() {
		driver.findElement(By.id("email_address")).sendKeys("qa1@test.com");
	}

	@And("User click button Reset Password")
	public void user_click_button_reset_password() {
		driver.findElement(By.xpath("//button[@class='action submit primary']")).click();
		Duration duration = Duration.ofSeconds(3);
		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")));
		driver.quit();
	}
}
