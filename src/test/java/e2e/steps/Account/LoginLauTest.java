package e2e.steps.Account;

import java.io.IOException;

import org.junit.jupiter.api.*;

import e2e.fixtures.TestBase;
import e2e.page.LoginPage;

public class LoginLauTest extends TestBase {

    @Test
    public void login(TestInfo test) throws InterruptedException, IOException {
        // todo: se debe traer la configuracion
        // ?por herencia tengo las vairables
        // ?web: webdriver (chrome por defecto)
        // ?get:para seleccionar elementos
        // ?Do:interactuar elementos
        // ? then: assersiones

        // todo: instanciar la clase:
        LoginPage loginPage = new LoginPage(web, get, Do);

        // todo: visitar pagina
        web.get(BASE_URL);
        Thread.sleep(2000); // Temporary
        // todo: ingresar valores en inputs y hacer click en login
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        Do.screenshot(test);
        loginPage.submitLogin();

        // todo: validar endpoint de login valido
        String urlActual = web.getCurrentUrl();
        then.shouldContain(urlActual, "dashboard/index");
    }
}
