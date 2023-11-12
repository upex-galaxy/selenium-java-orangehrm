package e2e.steps.Account;

import java.io.IOException;

import org.junit.jupiter.api.*;

import e2e.fixtures.TestBase;
import e2e.page.LoginPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Epic("Account Component")
@Feature("Login")
@Story("User logs in the app with username and password")
public class LoginTest extends TestBase {

    private LoginPage loginPage;

    @BeforeEach
    @DisplayName("PRC: User is on the Login Page")
    public void prec() throws InterruptedException {
        web.get(BASE_URL);
        loginPage = new LoginPage(web, get, Do);
        Thread.sleep(2000); // Temporary
    }

    @Test
    @DisplayName("TC1: Should login succesffully")
    public void login(TestInfo testInfo) throws InterruptedException, IOException {
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        Do.screenshot(testInfo);
        loginPage.submitLogin();
        String actualURL = web.getCurrentUrl();
        then.shouldContain(actualURL, "/dashboard/index");
    }
}
