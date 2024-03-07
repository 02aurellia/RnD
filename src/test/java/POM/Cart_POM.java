package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.CartPageObjects;
import Pages.LoginPageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Cart_POM {
    
    private static WebDriver driver = null;

    // public static void main(String[] args) throws InterruptedException {
    //     add_cart_pom();
    //     view_cart_pom();
    // }

    // public static void add_cart_pom() {
    //     System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    //     driver = new ChromeDriver();
    //     driver.manage().window().maximize();
    //     driver.get("https://magento.softwaretestingboard.com/");
    //     LoginPageObjects loginPageObj = new LoginPageObjects(driver);
    //     loginPageObj.loginPage();
    //     CartPageObjects cartPageObj = new CartPageObjects(driver);
    //     cartPageObj.goToSelectedMenu();
    //     cartPageObj.goToSelectedCat();
    //     cartPageObj.chooseProduct();
    //     cartPageObj.addToCart();
    //     loginPageObj.driverQuit();
    // }

    // public static void view_cart_pom() throws InterruptedException{
    //     System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    //     driver = new ChromeDriver();
    //     driver.manage().window().maximize();
    //     driver.get("https://magento.softwaretestingboard.com/");
    //     LoginPageObjects loginPageObj = new LoginPageObjects(driver);
    //     loginPageObj.loginPage();
    //     CartPageObjects cartPageObj = new CartPageObjects(driver);
    //     cartPageObj.viewCart();
    //     cartPageObj.verifyCartPage();
    //     loginPageObj.driverQuit();
    // }

    //Add Cart
    @Given("User in homepage")
    public void user_in_homepage() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        LoginPageObjects loginPageObj = new LoginPageObjects(driver);
        loginPageObj.loginPage();
    }

    @Then("User go to selected menu page")
    public void user_go_to_selected_menu_page() {
        CartPageObjects cartPageObj = new CartPageObjects(driver);
        cartPageObj.goToSelectedMenu();
    }

    @Then("User go to selected category")
    public void user_go_to_selected_category() {
        CartPageObjects cartPageObj = new CartPageObjects(driver);
        cartPageObj.goToSelectedCat();
    }

    @Then("User choose product and option")
    public void user_choose_product_and_option() {
        CartPageObjects cartPageObj = new CartPageObjects(driver);
        cartPageObj.chooseProduct();
    }

    @And("User click button add to Cart")
    public void user_click_button_add_to_cart() {
        CartPageObjects cartPageObj = new CartPageObjects(driver);
        cartPageObj.addToCart();
    }

    @Then("User get alert success add to Cart")
    public void user_get_alert_success_add_to_cart() {
        CartPageObjects cartPageObj = new CartPageObjects(driver);
        cartPageObj.alertSuccess();
        LoginPageObjects loginPageObj = new LoginPageObjects(driver);
        loginPageObj.driverQuit();
    }

    //View cart
    @Then("User click button Cart")
    public void user_click_button_cart() throws InterruptedException {
        Thread.sleep(4000);
        CartPageObjects cartPageObj = new CartPageObjects(driver);
        cartPageObj.clickBtnCart();
    }

    @And("User click button View and Edit Cart")
    public void user_click_button_view_and_edit_cart() {
        CartPageObjects cartPageObj = new CartPageObjects(driver);
        cartPageObj.clickBtnView();
    }

    @Then("User redirect to Cart Page")
    public void user_redirect_to_cart_page() {
        CartPageObjects cartPageObj = new CartPageObjects(driver);
        cartPageObj.verifyCartPage();
        LoginPageObjects loginPageObj = new LoginPageObjects(driver);
        loginPageObj.driverQuit();
    }

    //Edit Product - Positive
    @And("User click button Edit product")
    public void user_click_button_edit_product() {
        CartPageObjects cartPageObj = new CartPageObjects(driver);
        cartPageObj.clickBtnEdit();
    }

    @Then("User choose new option")
    public void user_choose_new_option() throws InterruptedException {
        CartPageObjects cartPageObj = new CartPageObjects(driver);
        cartPageObj.chooseNewOption();
    }
    
    @And("User click button Update Cart")
    public void user_click_button_update_cart() {
        CartPageObjects cartPageObj = new CartPageObjects(driver);
        cartPageObj.clickBtnUpdate();
    }

    @Then("User get alert success updated shopping cart")
    public void user_get_alert_success_updated_shopping_cart() {
        CartPageObjects cartPageObj = new CartPageObjects(driver);
        cartPageObj.alertSuccessEdit();
        LoginPageObjects loginPageObj = new LoginPageObjects(driver);
        loginPageObj.driverQuit();
    }

    //Delete Products from Cart - Positive
    @And("User click button delete product")
    public void user_click_button_delete_product() {
        CartPageObjects cartPageObj = new CartPageObjects(driver);
        cartPageObj.clickBtnDelete();
    }

    @Then("User get confirmation modal")
    public void user_get_confirmation_modal() {
        CartPageObjects cartPageObj = new CartPageObjects(driver);
        cartPageObj.ConfirmationModal();
    }

    @And("User click button Ok")
    public void user_click_button_ok() {
        CartPageObjects cartPageObj = new CartPageObjects(driver);
        cartPageObj.clickBtnOk();
        LoginPageObjects loginPageObj = new LoginPageObjects(driver);
        loginPageObj.driverQuit();
    }

    //Add to cart - Negative
    @Then("User choose product")
    public void user_choose_product() {
        CartPageObjects cartPageObj = new CartPageObjects(driver);
        cartPageObj.hoverProduct();
    }

    @Then("User get alert You need to choose options for your item")
    public void user_get_alert_you_need_to_choose_options_for_your_item() {
        CartPageObjects cartPageObj = new CartPageObjects(driver);
        cartPageObj.alertRequired();
        LoginPageObjects loginPageObj = new LoginPageObjects(driver);
        loginPageObj.driverQuit();
    }

    //Edit Product - Negative
    @Then("User get alert options required field")
    public void user_get_alert_options_required_field() {
        CartPageObjects cartPageObj = new CartPageObjects(driver);
        cartPageObj.alertRequiredEdit();
        LoginPageObjects loginPageObj = new LoginPageObjects(driver);
        loginPageObj.driverQuit();
    }

    //Delete Products from Cart - Negative
    @And("User click button Cancel")
    public void user_click_button_cancel() {
        CartPageObjects cartPageObj = new CartPageObjects(driver);
        cartPageObj.clickBtnCancel();
        LoginPageObjects loginPageObj = new LoginPageObjects(driver);
        loginPageObj.driverQuit();
    }
}
