package e2e.steps.Account;

import java.io.IOException;

import org.junit.jupiter.api.*;

import e2e.fixtures.TestBase;
import e2e.page.LoginPage;

public class LoginTest extends TestBase {

    @Test
    @DisplayName("TC1: Should login succesffully")
    public void login() throws InterruptedException, IOException {
        LoginPage loginPage = new LoginPage(web, get, Do);
        web.get(BASE_URL);
        Thread.sleep(2000);

        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.submitLogin();
        String actualURL = web.getCurrentUrl();
        then.shouldContain(actualURL, "/dashboard/index");
    }
}
