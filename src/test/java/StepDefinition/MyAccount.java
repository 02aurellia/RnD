package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.env;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class MyAccount extends env {
	// General
	@Given("User successfully login")
	public void user_successfully_login() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(MagentoLink);
		Duration duration = Duration.ofSeconds(3);
		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-3")));
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();
		driver.findElement(By.id("email")).sendKeys("qa1@test.com");
		driver.findElement(By.id("pass")).sendKeys("Abcd1234@");
		driver.findElement(By.id("send2")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-3")));
	}

	@Then("User go to my account page")
	public void user_go_to_my_account_page() {
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")).click();
		driver.findElement(By.xpath("//div[@aria-hidden='false']//a[normalize-space()='My Account']")).click();
	}

	// edit contact
	@Then("User click button edit contact")
	public void user_click_button_edit_contact() {
		driver.findElement(By.xpath("//span[normalize-space()='Edit']")).click();
	}

	@Then("User input new name")
	public void user_input_new_name() {
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("firstname")).sendKeys("Edit QA");
	}

	@Then("User click button Save contact")
	public void user_click_button_save_contact() {
		driver.findElement(By.xpath("//span[normalize-space()='Save']")).click();
	}

	@Then("User get alert You saved the account information")
	public void user_get_alert_you_saved_the_account_information() {
		Duration duration = Duration.ofSeconds(3);
		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")));
		driver.quit();
	}

	// edit address
	@Then("User click button edit address")
	public void user_click_button_edit_address() {
		driver.findElement(By.xpath("//div[@class='box box-billing-address']//span[contains(text(),'Edit Address')]"))
				.click();
	}

	@Then("User input contact information")
	public void user_input_contact_information() {
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("telephone")).clear();
		driver.findElement(By.id("firstname")).sendKeys("Address");
		driver.findElement(By.id("lastname")).sendKeys("QA");
		driver.findElement(By.id("telephone")).sendKeys("5555544887");
	}

	@Then("User input address")
	public void user_input_address() {
		driver.findElement(By.id("street_1")).clear();
		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("zip")).clear();
		driver.findElement(By.id("street_1")).sendKeys("street");
		driver.findElement(By.id("city")).sendKeys("city");
		driver.findElement(By.id("zip")).sendKeys("1234");
		Select country_Select = new Select(driver.findElement(By.id("country")));
		country_Select.selectByValue("SE");
	}

	@Then("User click button Save address")
	public void user_click_button_save_address() {
		driver.findElement(By.xpath("//button[@title='Save Address']")).click();
	}

	@Then("User get alert You saved the address")
	public void user_get_alert_you_saved_the_address() {
		driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"))
				.isDisplayed();
		driver.quit();
	}

	@Then("User clear required field")
	public void user_clear_required_field() {
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("telephone")).clear();
		driver.findElement(By.id("street_1")).clear();
		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("zip")).clear();
	}

	@Then("User get alert address required field")
	public void user_get_alert_address_required_field() {
		if (driver.findElement(By.xpath("//div[@id='firstname-error']")).isDisplayed()) {
			driver.close();
		} else {
			driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div[1]")).isDisplayed();
			driver.close();
		}
		// driver.quit();
	}
}
