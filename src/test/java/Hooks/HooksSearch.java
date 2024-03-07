package Hooks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import config.env;
import io.cucumber.java.en.*;

public class HooksSearch extends env {

	public HooksSearch() {
		driver = Hooks.driver;
	}

	// General
	@Given("User success login")
	public void user_success_login() {
		Duration duration = Duration.ofSeconds(5);
		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-3")));
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();
		driver.findElement(By.id("email")).sendKeys("qa1@test.com");
		driver.findElement(By.id("pass")).sendKeys("Abcd1234@");
		driver.findElement(By.id("send2")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-3")));
	}

	@And("User click button search")
	public void user_click_button_search() {
		driver.findElement(By.xpath("//button[@title='Search']")).click();
	}

	// Positive
	@Then("User input valid value")
	public void user_input_valid_value() {
		driver.findElement(By.id("search")).sendKeys("pants");
	}

	@Then("User redirect to result page")
	public void user_redirect_to_result_page() {
		Duration duration = Duration.ofSeconds(3);
		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Search results')]")));
	}

	// Negative
	@Then("User input invalid value")
	public void user_input_invalid_value() {
		driver.findElement(By.id("search")).sendKeys("pencil");
	}

	@Then("User get alert no results")
	public void user_get_alert_no_results() {
		Duration duration = Duration.ofSeconds(3);
		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Your search returned no results.')]")));
	}
}
