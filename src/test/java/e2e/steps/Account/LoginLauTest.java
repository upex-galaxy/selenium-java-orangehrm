package e2e.steps.Account;

import java.io.IOException;
import java.util.function.Supplier;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;

import e2e.fixtures.TestBase;

public class LoginLauTest extends TestBase {
    public Supplier<WebElement> usernameInput;
    public Supplier<WebElement> passwordInput;
    public Supplier<WebElement> submitButton;

    @Test
    public void login() throws InterruptedException {
        // todo: se debe traer la configuracion
        // ?por herencia tengo las vairables
        // ?web: webdriver (chrome por defecto)
        // ?get:para seleccionar elementos
        // ?Do:interactuar elementos
        // ? then: assersiones

        // todo: visitar pagina
        web.get(BASE_URL);
        Thread.sleep(2000); // Temporary
        // todo: ingresar valores en inputs y hacer click en login
        this.usernameInput = () -> get.ByName("username");
        this.passwordInput = () -> get.ByName("password");
        this.submitButton = () -> get.Selector("[type=\"submit\"]");
        Do.enterValue(this.usernameInput.get(), "Admin");
        Do.enterValue(this.passwordInput.get(), "admin123");
        Do.click(this.submitButton.get());
        // todo: validar endpoint de login valido
        String urlActual = web.getCurrentUrl();
        then.shouldContain(urlActual, "dashboard/index");
    }
}
