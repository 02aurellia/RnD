package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MyAccountPage {
    WebDriver driver;

    @FindBy(id = "ui-id-3")
    @CacheLookup
    WebElement verify_element;

    @FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")
    WebElement ddMenu;

    @FindBy(xpath = "//div[@aria-hidden='false']//a[normalize-space()='My Account']")
    WebElement hrefMyAccount;

    @FindBy(xpath = "//span[normalize-space()='Edit']")
    WebElement btnEdit;

    @FindBy(id = "firstname")
    WebElement tbFName;

    @FindBy(id = "lastname")
    WebElement tbLName;

    @FindBy(xpath = "//span[normalize-space()='Save']")
    WebElement btnSave;

    @FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    WebElement puAlert;

    @FindBy(id = "firstname-error")
    WebElement errorAlert;

    public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,30),this);
	}

    public void goToMyAccPage(){
        verify_element.isDisplayed();
        ddMenu.click();
        hrefMyAccount.click();
    }

    public void clickBtnEdit(){
        btnEdit.click();
    }

    public void inputNewName(String Name){
        tbFName.clear();
        tbFName.sendKeys(Name);
    }

    public void clickBtnSave(){
        btnSave.click();
    }

    public void alertSuccess() throws InterruptedException{
        Thread.sleep(2000);
        puAlert.isDisplayed();
    }

    public void clear(){
        tbFName.clear();
        tbLName.clear();
    }

    public void alertRequired() throws InterruptedException{
        errorAlert.isDisplayed();
    }
}
