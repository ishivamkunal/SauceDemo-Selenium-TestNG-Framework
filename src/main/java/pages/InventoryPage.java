package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class InventoryPage extends Base {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    WebElement cartIcon;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addProductToCart() {
        addToCartButton.click();
    }

    public void goToCart() {
        cartIcon.click();
    }
}