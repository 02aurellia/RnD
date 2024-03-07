package NoBDD;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.env;

public class Login extends env {
	private static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {
		success_login();
		invalid_login();
	}

	public static void success_login() throws InterruptedException {
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
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, QA Edit Testing!']"))
				.isDisplayed();
		driver.quit();
	}

	public static void invalid_login() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(MagentoLink);
		Duration duration = Duration.ofSeconds(3);
		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-3")));
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();
		driver.findElement(By.id("email")).sendKeys("qa1@test.com");
		driver.findElement(By.id("pass")).sendKeys("11111111");
		driver.findElement(By.id("send2")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-3")));
		driver.quit();
	}
}
