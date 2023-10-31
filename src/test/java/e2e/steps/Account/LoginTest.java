package e2e.steps.Account;

import org.junit.jupiter.api.*;

import e2e.fixtures.TestBase;
import e2e.page.LoginPage;

public class LoginTest extends TestBase {

    @Test
    @DisplayName("TC1: Should login succesffully")
    public void login() {
        LoginPage loginPage = new LoginPage(web, get, Do);
        web.get(BASE_URL);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.submitLogin();
        then.shouldContain(web.getCurrentUrl(), "/dashboard/index");
    }
}
