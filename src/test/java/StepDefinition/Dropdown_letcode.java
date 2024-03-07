package StepDefinition;

import config.env;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Dropdown_letcode extends env {

	private static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {
		dropdown();
	}

	public static void dropdown() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(letCodeLink);
		Duration duration = Duration.ofSeconds(3);
		WebDriverWait wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/app-root/app-test-site/section[1]/div/div/div/div/h1")));
		driver.findElement(By.xpath("//a[normalize-space()='Drop-Down']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/app-root/app-dropdowns/app-pageheader/section/div/div/h1")));

		// Select By Visible Text
		WebElement fruits = driver.findElement(By.id("fruits"));
		Select select_fruit = new Select(fruits);
		select_fruit.selectByVisibleText("Apple");

		// Select By Value and Index (Multiple Values)
		WebElement heroes = driver.findElement(By.id("superheros"));
		Select select_hero = new Select(heroes);
		select_hero.selectByValue("am");
		select_hero.selectByIndex(2);

		// Get All Option
		WebElement programlang = driver.findElement(By.id("lang"));
		Select select_lang = new Select(programlang);
		List<WebElement> op = select_lang.getOptions();
		int size = op.size();
		for (int i = 0; i < size; i++) {
			String options = op.get(i).getText();
			System.out.println(options);
		}
		select_lang.selectByIndex(4);

		// Get Selected Option
		Select select_country = new Select(driver.findElement(By.id("country")));
		select_country.selectByValue("India");
		WebElement option = select_country.getFirstSelectedOption();
		System.out.println(option.getText());
		// driver.close();
	}
}