package view;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class shoppingPage {
    WebDriver driver;

    @FindBy(id = "user-name")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "login-button")
    WebElement button;
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement shoppingCart;
    @FindBy(id = "checkout")
    WebElement checkout;
    @FindBy(id = "first-name")
    WebElement nombre;
    @FindBy(id = "last-name")
    WebElement apellido;
    @FindBy(id = "postal-code")
    WebElement CodPostal;
    @FindBy(id = "continue")
    WebElement buttonContinuar;
    @FindBy(id = "finish")
    WebElement buttonFinish;

    public shoppingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String user, String pass) {
        username.sendKeys(user);
        password.sendKeys(pass);
        button.click();
    }

    public void addCarrito(String product) {
        List<WebElement> productElements = driver.findElements(By.className("inventory_item"));

        for (WebElement item : productElements) {
            String productName = item.findElement(By.className("inventory_item_name")).getText();

            if (productName.equals(product)) {
                WebElement addToCartButton = item.findElement(By.cssSelector(".btn_inventory"));
                addToCartButton.click();
                break;


            }
        }
    }

    public void checkout() {
        shoppingCart.click();
        checkout.click();
    }

    public void formulario(String name, String lastname, String codpostal) {
        nombre.sendKeys(name);
        apellido.sendKeys(lastname);
        CodPostal.sendKeys(codpostal);
        buttonContinuar.click();
    }

    public void confirmar() {
        buttonFinish.click();
    }

    public void mensaje(String msg) {
        WebElement confirmationMessage = driver.findElement(By.className("complete-header"));
        Assert.assertEquals(confirmationMessage.getText(), msg, "El pago no fue exitoso.");
    }
}
