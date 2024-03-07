package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SignupPage {
	WebDriver driver;

	@FindBy(id = "ui-id-3")
	@CacheLookup // ensure the web elements load just once and do not have to reload whenever the
					// method is called
	WebElement verify_element;

	@FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[3]/a")
	WebElement hrefSignup;

	@FindBy(id = "firstname")
	WebElement tBfname;

	@FindBy(id = "lastname")
	WebElement tBlname;

	@FindBy(css = "button[title='Create an Account'] span")
	WebElement btnCreate;

	@FindBy(id = "email_address")
	WebElement tBemail;

	@FindBy(id = "password")
	WebElement tBPass;

	@FindBy(id = "password-confirmation")
	WebElement tBPassConfirmation;

	@FindBy(xpath = "//li[@class='nav item current']//strong[contains(text(),'My Account')]")
	WebElement verify_signup;

	@FindBy(id = "password-confirmation-error")
	WebElement mismatchpass;

	@FindBy(xpath = "//*[contains(text(), 'Weak')]")
	WebElement weakpass;

	@FindBy(xpath = "//*[contains(text(), 'This is a required field.')]")
	WebElement requiredField;

	@FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/a")
	WebElement btnSignIn;

	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[3]/div[2]/div[2]/div/div/a")
	WebElement btnSignUp;

	public SignupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}

	public void verifyHomepage() throws InterruptedException {
		Thread.sleep(2000);
		verify_element.isDisplayed();
	}

	public void goToSignUpPage() throws InterruptedException {
		verify_element.isDisplayed();
		hrefSignup.click();
		Thread.sleep(2000);
	}

	public void inputPersonalInformation(String fname, String lname) {
		tBfname.sendKeys(fname);
		tBlname.sendKeys(lname);
	}

	public void inputSignInInformation(String email, String pass, String passconfirm) {
		tBemail.sendKeys(email);
		tBPass.sendKeys(pass);
		tBPassConfirmation.sendKeys(passconfirm);

		String getemail = tBemail.getText();
		System.out.println(getemail);
		String getpass = tBPass.getText();
		System.out.println(getpass);
		// System.out.println("Success Sign Up");
	}

	public void clickBtnSignUp() {
		btnCreate.click();
	}

	public void verifySignUp() {
		verify_signup.isDisplayed();
		System.out.println("Success Sign Up");
	}

	public void mismatchPassAlert() {
		mismatchpass.isDisplayed();
		System.out.println("Mismatch Password - Passed");
	}

	public void weakPassAlert() {
		weakpass.isDisplayed();
		System.out.println("Weak Password - Passed");
	}

	public void requiredAlert() {
		requiredField.isDisplayed();
		System.out.println("Required Field - Passed");
	}

	public void driverQuit() {
		driver.quit();
	}

	public void clickSignIn() {
		btnSignIn.click();
	}

	public void clickSignUp() {
		btnSignUp.click();
	}
}
