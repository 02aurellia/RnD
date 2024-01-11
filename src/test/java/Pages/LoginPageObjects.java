package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObjects {
    
    WebDriver driver = null;

    By href_signIn = By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]");
    By textbox_email = By.id("email");
    By textbox_password = By.id("pass");
    By button_signIn = By.xpath("//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]");
    By header_menu = By.id("ui-id-3");
    By invalid_credential = By.xpath("//*[contains(text(), 'The account sign-in was incorrect')]");
    By empty_field = By.xpath("//*[contains(text(), 'This is a required field.')]");

    public LoginPageObjects(WebDriver driver){
        this.driver = driver;
    }

    public void setUpDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
    }

    public void goToSignIn(){
        driver.findElement(href_signIn).click();
    }

    public void inputUsername(String text){
        driver.findElement(textbox_email).sendKeys(text);
    }

    public void inputPassword(String text){
        driver.findElement(textbox_password).sendKeys(text);
    }

    public void clickButtonSignIn(){
        driver.findElement(button_signIn).click();
    }

    public void validateHeader(){
        Duration duration = Duration.ofSeconds(3);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(header_menu)
        );
    }

    public void alertIncorrect(){
        Duration duration = Duration.ofSeconds(3);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(invalid_credential)
        );
    }

    public void alertRequired(){
        driver.findElement(empty_field).isDisplayed();
    }

    public void loginPage(){
        Duration duration = Duration.ofSeconds(3);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(header_menu)
        );
        driver.findElement(href_signIn).click();
        driver.findElement(textbox_email).sendKeys("qa1@test.com");
        driver.findElement(textbox_password).sendKeys("Abcd1234@");
        driver.findElement(button_signIn).click();
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(header_menu)
        );
    }

    public void driverQuit(){
        driver.quit();
    }

    //private static WebElement element = null;

    // public static WebElement href_signIn(WebDriver driver){
    //     element = driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]"));
    //     return element;
    // }

    // public static WebElement textbox_email(WebDriver driver){
    //     element = driver.findElement(By.id("email"));
    //     return element;
    // }

    // public static WebElement textbox_password(WebDriver driver){
    //     element = driver.findElement(By.id("pass"));
    //     return element;
    // }

    // public static WebElement button_signIn(WebDriver driver){
    //     element = driver.findElement(By.xpath("//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]"));
    //     return element;
    // }
    
}
