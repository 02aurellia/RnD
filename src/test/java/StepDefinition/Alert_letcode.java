package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.env;

public class Alert_letcode extends env {
	private static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {
		// accept_alert();
		// dismiss_alert();
		// prompt_alert();
		modern_alert();
	}

	public static void accept_alert() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(letCodeLink);
		Duration duration = Duration.ofSeconds(3);
		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/app-root/app-test-site/section[1]/div/div/div/div/h1")));
		driver.findElement(
				By.xpath("/html/body/app-root/app-test-site/section[2]/div/div/div/div[4]/app-menu/div/footer/a"))
				.click();
		driver.findElement(By.id("accept")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		// driver.close();
	}

	public static void dismiss_alert() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(letCodeLink);
		Duration duration = Duration.ofSeconds(3);
		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/app-root/app-test-site/section[1]/div/div/div/div/h1")));
		driver.findElement(
				By.xpath("/html/body/app-root/app-test-site/section[2]/div/div/div/div[4]/app-menu/div/footer/a"))
				.click();
		driver.findElement(By.id("confirm")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().dismiss();
		// driver.close();
	}

	public static void prompt_alert() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(letCodeLink);
		Duration duration = Duration.ofSeconds(3);
		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/app-root/app-test-site/section[1]/div/div/div/div/h1")));
		driver.findElement(
				By.xpath("/html/body/app-root/app-test-site/section[2]/div/div/div/div[4]/app-menu/div/footer/a"))
				.click();
		driver.findElement(By.id("prompt")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().sendKeys("Test");
		driver.switchTo().alert().accept();
		// driver.close();
	}

	public static void modern_alert() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(letCodeLink);
		Duration duration = Duration.ofSeconds(3);
		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/app-root/app-test-site/section[1]/div/div/div/div/h1")));
		driver.findElement(
				By.xpath("/html/body/app-root/app-test-site/section[2]/div/div/div/div[4]/app-menu/div/footer/a"))
				.click();
		driver.findElement(By.id("modern")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/app-root/app-alert/section[1]/div/div/div[1]/div/div/div[5]/div[2]/div")));
		// Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/app-root/app-alert/section[1]/div/div/div[1]/div/div/div[5]/button"))
				.click();
		// driver.close();
	}
}
