package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPageObjects {
    WebDriver driver = null;

    By header_menu_men = By.xpath("//span[normalize-space()='Men']");
    By verify_menu_men = By.xpath("//span[contains(text(),'Men')]");
    By side_menu_bottom = By.xpath("//a[contains(text(),'Bottoms')]");
    By verify_menu_bottom = By.xpath("//span[@class='base']");
    By button_add_to_cart = By.xpath("//li[1]//div[1]//div[1]//div[3]//div[1]//div[1]//form[1]//button[1]//span[1]");
    By button_cart = By.cssSelector(".action.showcart");
    By button_delete = By.xpath("//li[@class='item product product-item']//a[@title='Remove item']");
    By button_confirm_ok = By.xpath("//span[normalize-space()='OK']");
    By button_confirm_cancel = By.xpath("//span[normalize-space()='Cancel']");
    By button_product = By.id("option-label-size-143-item-178");
    By button_option = By.id("option-label-color-93-item-58");
    By button_update = By.xpath("//span[normalize-space()='Update Cart']");
    By alert = By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
    By button_view = By.xpath("//span[normalize-space()='View and Edit Cart']");
    By verify_cart_page = By.xpath("//span[contains(text(),'Shopping Cart')]");
    By button_edit = By.xpath("//li[@class='item product product-item odd last']//a[@title='Edit item']");
    By new_product = By.xpath("//div[@id='option-label-size-143-item-176']");
    By new_option = By.xpath("//div[@id='option-label-color-93-item-49']");
    By card_product = By.xpath("//a[@class='product photo product-item-photo']//img[@alt='Pierce Gym Short']");
    By alert_required = By.xpath("//div[@class='swatch-attribute size']//div[contains(@id,'super_attribute')]");

    public CartPageObjects(WebDriver driver){
        this.driver = driver;
    }

    public void goToSelectedMenu(){
        driver.findElement(header_menu_men).click();
        driver.findElement(verify_menu_men).isDisplayed();
    }

    public void goToSelectedCat(){
        driver.findElement(side_menu_bottom).click();
        driver.findElement(verify_menu_bottom).isDisplayed();
    }

    public void chooseProduct(){
        driver.findElement(button_product).click();
        driver.findElement(button_option).click();
    }

    public void addToCart(){
        driver.findElement(button_add_to_cart).click();
    }

    public void alertSuccess(){
        Duration duration = Duration.ofSeconds(3);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(alert)
        );
    }

    public void clickBtnCart() {
        driver.findElement(button_cart).click();
    }

    public void clickBtnView(){
        driver.findElement(button_view).click();
    }

    public void verifyCartPage(){
        Duration duration = Duration.ofSeconds(3);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(verify_cart_page)
        );
    }

    public void clickBtnEdit() {
        driver.findElement(button_edit).click();
        Duration duration = Duration.ofSeconds(3);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(button_update)
        );
    }

    public void chooseNewOption() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(new_product).click();
        driver.findElement(new_option).click();
    }

    public void clickBtnUpdate() {
        driver.findElement(button_update).click();
    }

    public void alertSuccessEdit() {
        Duration duration = Duration.ofSeconds(3);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(alert)
        );
    }

    public void clickBtnDelete() {
        driver.findElement(button_delete).click();
    }

    public void ConfirmationModal() {
        Duration duration = Duration.ofSeconds(3);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(button_confirm_ok)
        );
    }

    public void clickBtnOk() {
        driver.findElement(button_confirm_ok).click();
    }

    public void hoverProduct() {
        // Identify the element to be hovered
        WebElement element = driver.findElement(card_product);
        // Instantiate the Actions class
        Actions actions = new Actions(driver);
        // Perform the mouse hover action
        actions.moveToElement(element).build().perform();
    }

    public void alertRequired() {
        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(alert)
        );

    }

    public void alertRequiredEdit() {
        driver.findElement(alert_required).isDisplayed();
    }

    public void clickBtnCancel() {
        driver.findElement(button_confirm_cancel).click();
    }
}
