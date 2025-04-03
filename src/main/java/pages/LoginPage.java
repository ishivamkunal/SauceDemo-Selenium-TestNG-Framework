package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.Base;

public class LoginPage extends Base {   // ✅ Inherits driver from Base
    // ✅ Locators
    By signin_user = By.name("user-name");
    By signin_pass = By.name("password");
    By login_btn = By.name("login-button");

    // ✅ Constructor to initialize driver (Inherits from Base)
    public LoginPage(WebDriver driver) {
        this.driver = driver;   // ⚠️ FIX: Remove `WebDriver driver;` from class
    }

    // ✅ Correct `login()` method
    public void login(String username, String password) {
        driver.findElement(signin_user).sendKeys(username);
        driver.findElement(signin_pass).sendKeys(password);
        driver.findElement(login_btn).click();
    }
}