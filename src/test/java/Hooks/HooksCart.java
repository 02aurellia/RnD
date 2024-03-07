package Hooks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.env;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HooksCart extends env{

    public HooksCart(){
        driver = Hooks.driver;
    }
    
    //General
    @Given("User in homepage")
    public void user_in_homepage() {
        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-3"))
        );
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();
        driver.findElement(By.id("email")).sendKeys("qa1@test.com");
        driver.findElement(By.id("pass")).sendKeys("Abcd1234@");
        driver.findElement(By.id("send2")).click();
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-3"))
        );
    }

    @Then("User go to selected menu page")
    public void user_go_to_selected_menu_page() {
        driver.findElement(By.xpath("//span[normalize-space()='Men']")).click();
        Duration duration = Duration.ofSeconds(3);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Men')]"))
        );
    }

    @Then("User go to selected category")
    public void user_go_to_selected_category() {
        driver.findElement(By.xpath("//a[contains(text(),'Bottoms')]")).click();
        Duration duration = Duration.ofSeconds(3);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='base']"))
        );
    }

    @And("User click button add to Cart")
    public void user_click_button_add_to_cart() {
        driver.findElement(By.xpath("//li[1]//div[1]//div[1]//div[3]//div[1]//div[1]//form[1]//button[1]//span[1]")).click();
    }

    @Then("User click button Cart")
    public void user_click_button_cart() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class='action showcart']")).click();
    }

    @Then("User get confirmation modal")
    public void user_get_confirmation_modal() {
        Duration duration = Duration.ofSeconds(3);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='OK']"))
        );
    }

    @And("User click button Update Cart")
    public void user_click_button_update_cart() {
        driver.findElement(By.xpath("//span[normalize-space()='Update Cart']")).click();
    }

    //Add to cart - Positive
    @Then("User choose product and option")
    public void user_choose_product_and_option() {
        driver.findElement(By.id("option-label-size-143-item-175")).click();
        driver.findElement(By.id("option-label-color-93-item-49")).click();
    }
    
    @Then("User get alert success add to Cart")
    public void user_get_alert_success_add_to_cart() {
        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"))
        );
        //driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")).isDisplayed();
        // driver.quit();
    }

    //Add to cart - Negative
    @Then("User choose product")
    public void user_choose_product() {
        // Identify the element to be hovered
        WebElement element = driver.findElement(By.xpath("//a[@class='product photo product-item-photo']//img[@alt='Pierce Gym Short']"));
        // Instantiate the Actions class
        Actions actions = new Actions(driver);
        // Perform the mouse hover action
        actions.moveToElement(element).build().perform();
    }

    @Then("User get alert You need to choose options for your item")
    public void user_get_alert_you_need_to_choose_options_for_your_item() {
        Duration duration = Duration.ofSeconds(3);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"))
        );
    }

    //View cart
    @And("User click button View and Edit Cart")
    public void user_click_button_view_and_edit_cart() {
        driver.findElement(By.xpath("//span[normalize-space()='View and Edit Cart']")).click();
    }

    @Then("User redirect to Cart Page")
    public void user_redirect_to_cart_page() {
        Duration duration = Duration.ofSeconds(3);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Shopping Cart')]"))
        );
    }

    //Edit Product - Positive
    @And("User click button Edit product")
    public void user_click_button_edit_product() {
        driver.findElement(By.xpath("//li[@class='item product product-item odd last']//a[@title='Edit item']")).click();
        Duration duration = Duration.ofSeconds(3);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Update Cart']"))
        );
    }

    @Then("User choose new option")
    public void user_choose_new_option() {
        driver.findElement(By.xpath("//div[@id='option-label-size-143-item-176']")).click();
        driver.findElement(By.xpath("//div[@id='option-label-color-93-item-58']")).click();
    }

    @Then("User get alert success updated shopping cart")
    public void user_get_alert_success_updated_shopping_cart() {
        Duration duration = Duration.ofSeconds(3);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"))
        );
    }

    //Edit Product - Negative
    @Then("User get alert options required field")
    public void user_get_alert_options_required_field() {
        driver.findElement(By.xpath("//div[@class='swatch-attribute size']//div[contains(@id,'super_attribute')]")).isDisplayed();
    }
    
    //Delete Products from Cart - Positive

    @And("User click button delete product")
    public void user_click_button_delete_product() {
        driver.findElement(By.xpath("//a[@title='Remove item']")).click();
        // Duration duration = Duration.ofSeconds(3);
        // WebDriverWait wait = new WebDriverWait(driver, duration);
        // wait.until(
        //     ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='item product product-item']//a[@title='Remove item']"))
        // );
        // driver.findElement(By.xpath("//li[@class='item product product-item']//a[@title='Remove item']")).click();
    }
    
    @And("User click button Ok")
    public void user_click_button_ok() {
        driver.findElement(By.xpath("//span[normalize-space()='OK']")).click();
    }

    //Delete Products from Cart - Negative
    
    @And("User click button Cancel")
    public void user_click_button_cancel() {
        driver.findElement(By.xpath("//span[normalize-space()='Cancel']")).click();
    }
}
