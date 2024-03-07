package Background;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import config.env;
import io.cucumber.java.en.*;

public class SearchWithBg extends env {

	@Given("User on homepage")
	public void user_on_homepage() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(MagentoLink);
		Duration duration = Duration.ofSeconds(3);
		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-3")));
	}

	@Then("User go to Sign In Page")
	public void user_go_to_sign_in_page() {
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();
	}

	@And("User input credentials")
	public void user_input_credentials() {
		driver.findElement(By.id("email")).sendKeys("qa1@test.com");
		driver.findElement(By.id("pass")).sendKeys("Abcd1234@");
	}

	@And("User click button")
	public void user_click_button() {
		driver.findElement(By.id("send2")).click();
		Duration duration = Duration.ofSeconds(3);
		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-3")));
	}

	@Then("User input valid value")
	public void user_input_valid_value() {
		driver.findElement(By.id("search")).sendKeys("pants");
	}

	@Then("User click button search")
	public void user_click_button_search() {
		driver.findElement(By.xpath("//button[@title='Search']")).click();
	}

	@Then("User redirect to result page")
	public void user_redirect_to_result_page() {
		Duration duration = Duration.ofSeconds(3);
		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Search results')]")));
		driver.quit();

	}

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
		driver.quit();
	}
}
