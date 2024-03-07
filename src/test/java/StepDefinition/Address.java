package StepDefinition;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.env;
import io.cucumber.java.en.*;

public class Address extends env {

	// General
	@Given("User in My Account page")
	public void user_in_my_account_page() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(MagentoLink);
		Duration duration = Duration.ofSeconds(5);
		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-3")));
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();
		driver.findElement(By.id("email")).sendKeys("qa1@test.com");
		driver.findElement(By.id("pass")).sendKeys("Abcd1234@");
		driver.findElement(By.id("send2")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-3")));
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")).click();
		driver.findElement(By.xpath("//div[@aria-hidden='false']//a[normalize-space()='My Account']")).click();
	}

	@Then("User go to Address Book page")
	public void user_go_to_address_book_page() {
		driver.findElement(By.xpath("//a[normalize-space()='Address Book']")).click();
		Duration duration = Duration.ofSeconds(5);
		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Address Book')]")));
	}

	@Then("User get alert You save the address")
	public void user_get_alert_you_save_the_address() {
		Duration duration = Duration.ofSeconds(3);
		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")));
		driver.close();
	}

	@Then("User get alert required field address")
	public void user_get_alert_required_field_address() {
		if (driver.findElement(By.xpath("//div[contains(text(),'required')]")).isDisplayed()) {
			driver.close();
		} else {
			driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div[1]")).isDisplayed();
			driver.close();
		}
	}

	// View Address
	@Given("User success login and go to homepage")
	public void user_success_login_and_go_to_homepage() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(MagentoLink);
		Duration duration = Duration.ofSeconds(5);
		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-3")));
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();
		driver.findElement(By.id("email")).sendKeys("qa1@test.com");
		driver.findElement(By.id("pass")).sendKeys("Abcd1234@");
		driver.findElement(By.id("send2")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-3")));
	}

	@Then("User go to My Account page")
	public void user_go_to_my_account_page() {
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")).click();
		driver.findElement(By.xpath("//div[@aria-hidden='false']//a[normalize-space()='My Account']")).click();
	}

	// Create New Address
	@Then("User click button Add New Address")
	public void user_click_button_add_new_address() {
		driver.findElement(By.xpath("//span[normalize-space()='Add New Address']")).click();
		Duration duration = Duration.ofSeconds(3);
		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstname")));
	}

	@Then("User input valid contact information")
	public void user_input_valid_contact_information() {
		// Random number for lastname
		Random rand = new Random();
		int userRand = rand.nextInt(10000);
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("firstname")).sendKeys("Address");
		driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("lastname")).sendKeys("QA " + userRand);
		driver.findElement(By.id("telephone")).sendKeys("5555544887");
	}

	@Then("User input valid address")
	public void user_input_valid_address() {
		driver.findElement(By.id("street_1")).sendKeys("street");
		driver.findElement(By.id("city")).sendKeys("city");
		Select country_Select = new Select(driver.findElement(By.id("country")));
		country_Select.selectByValue("CN");
		Select state_select = new Select(driver.findElement(By.id("region_id")));
		state_select.selectByValue("603");
		driver.findElement(By.id("zip")).sendKeys("123456");

	}

	@Then("User click button Save new address")
	public void user_click_button_save_new_address() {
		driver.findElement(By.xpath("//span[normalize-space()='Save Address']")).click();
	}

	// Edit Address
	@Then("User click button update address")
	public void user_click_button_update_address() {
		driver.findElement(By.xpath("//tbody/tr[1]/td[9]/a[1]/span[1]")).click();
		Duration duration = Duration.ofSeconds(3);
		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstname")));
	}

	@Then("User input new contact information")
	public void user_input_new_contact_information() {
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("firstname")).sendKeys("Edit Address");
		driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("lastname")).sendKeys("QA");
	}

	@Then("User input new address")
	public void user_input_new_address() {
		driver.findElement(By.id("street_1")).sendKeys("Street Edit");
		driver.findElement(By.id("city")).sendKeys("city");
		Select country_Select = new Select(driver.findElement(By.id("country")));
		country_Select.selectByValue("CN");
		Select state_select = new Select(driver.findElement(By.id("region_id")));
		state_select.selectByValue("603");
		driver.findElement(By.id("zip")).clear();
		driver.findElement(By.id("zip")).sendKeys("456789");
	}

	@Then("User click button Save edited address")
	public void user_click_button_save_edited_address() {
		driver.findElement(By.xpath("//button[@title='Save Address']")).click();
	}

	@Then("User clear required field address")
	public void user_clear_required_field_address() {
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("telephone")).clear();
		driver.findElement(By.id("street_1")).clear();
		driver.findElement(By.id("zip")).clear();
	}

	// Delete Address
	@Then("User click button delete address")
	public void user_click_button_delete_address() {
		driver.findElement(By.xpath("//tbody/tr[3]/td[9]/a[2]/span[1]")).click();
	}

	@Then("User get confirmation modal delete")
	public void user_get_confirmation_modal_delete() {
		Duration duration = Duration.ofSeconds(3);
		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//footer[contains(@class,'modal-footer')]")));
	}

	@Then("User click button OK delete address")
	public void user_click_button_ok_delete_address() {
		driver.findElement(By.xpath("//span[normalize-space()='OK']")).click();
	}

	@Then("User get alert You deleted the address")
	public void user_get_alert_you_deleted_the_address() {
		Duration duration = Duration.ofSeconds(3);
		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")));
		driver.close();
	}

	@Then("User click button Cancel delete address")
	public void user_click_button_cancel_delete_address() {
		driver.findElement(By.xpath("//span[normalize-space()='Cancel']")).click();
		driver.close();
	}
}
