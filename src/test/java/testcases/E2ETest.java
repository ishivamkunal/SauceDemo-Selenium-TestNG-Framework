package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;
import resources.ReadExcel;
import base.Base;

public class E2ETest extends Base {
	public WebDriver driver;
	
	 @BeforeMethod
	    public void setup() throws Exception {
	        driver = initializeDriver();  // Initialize driver before tests
	        driver.get(getUrl());         // Open the application URL
	    }

    @Test
    public void completePurchaseTest() throws Exception {
        String username = ReadExcel.getData("LoginTest", "Username");
        String password = ReadExcel.getData("LoginTest", "Password");
        String firstName = ReadExcel.getData("LoginTest", "FirstName");
        String lastName = ReadExcel.getData("LoginTest", "LastName");
        String zipCode = ReadExcel.getData("LoginTest", "ZipCode");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addProductToCart();
        inventoryPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterCheckoutDetails(firstName, lastName, zipCode);
        checkoutPage.finishCheckout();
    }
}