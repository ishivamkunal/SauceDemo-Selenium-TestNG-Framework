package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Base;

public class CheckoutPage extends Base {
    WebDriver driver;

    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By zipCodeField = By.id("postal-code");
    By continueButton = By.id("continue");
    By finishButton = By.id("finish");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCheckoutDetails(String firstName, String lastName, String zipCode) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(zipCodeField).sendKeys(zipCode);
        driver.findElement(continueButton).click();
    }

    public void finishCheckout() {
        driver.findElement(finishButton).click();
    }
}