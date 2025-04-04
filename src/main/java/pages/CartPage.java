package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Base;

public class CartPage extends Base {
    WebDriver driver;

    By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void proceedToCheckout() {
        driver.findElement(checkoutButton).click();
    }
}