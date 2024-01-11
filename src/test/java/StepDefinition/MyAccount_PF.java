package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageFactory.MyAccountPage;
import Pages.LoginPageObjects;

public class MyAccount_PF {
    private static WebDriver driver =  null;

    public static void main(String[] args) throws InterruptedException {
        successEditContact();
        failedEditContact();
    }

    public static void successEditContact() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");

        LoginPageObjects loginpage = new LoginPageObjects(driver);
        loginpage.loginPage();
        MyAccountPage myacc = new MyAccountPage(driver);
        myacc.goToMyAccPage();
        myacc.clickBtnEdit();
        myacc.inputNewName("QA Edit");
        myacc.clickBtnSave();
        myacc.alertSuccess();
        loginpage.driverQuit();
    }

    public static void failedEditContact() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");

        LoginPageObjects loginpage = new LoginPageObjects(driver);
        loginpage.loginPage();
        MyAccountPage myacc = new MyAccountPage(driver);
        myacc.goToMyAccPage();
        myacc.clickBtnEdit();
        myacc.clear();
        myacc.clickBtnSave();
        myacc.alertRequired();
        loginpage.driverQuit();
    }
}
