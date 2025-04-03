package StepDefinition;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import view.shoppingPage;

public class shoppingStep {
    private WebDriver driver;
    private shoppingPage shoppingPage;

@Before
    public void setUp() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("start-maximized");
        driver = new EdgeDriver(options);
        shoppingPage = new shoppingPage(driver);
    }

    @Given("que soy un cliente de Sauce Demo")
    public void enter_de_website_alertas_en_ventanas() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("inicio sesión con el usuario {string} y la contraseña {string}")
    public void inicioSesiónConElUsuarioYLaContraseña(String user, String pass) {
        shoppingPage.login(user,pass);
    }

    @And("agrego {string} al carrito")
    public void agregoAlCarrito(String product) {
    shoppingPage.addCarrito(product);
    }

    @And("procedo al checkout")
    public void procedoAlCheckout() {
    shoppingPage.checkout();
    }

    @And("ingreso mi información de envío {string}  {string} y {string}")
    public void ingresoMiInformaciónDeEnvíoY(String name, String lastname, String codpostal) {
        shoppingPage.formulario(name, lastname, codpostal);
   
    }

    @And("confirmo la compra")
    public void confirmoLaCompra() {
    shoppingPage.confirmar();
    }

    @Then("la compra se completa exitosamente {string}")
    public void laCompraSeCompletaExitosamente(String msg) {
        shoppingPage.mensaje(msg);
    }
}