package e2e.steps.Admin;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;

import e2e.fixtures.TestBase;
import e2e.page.LoginPage;

public class AddUser149Test extends TestBase {

    // precondiciones
    @BeforeEach
    public void login() throws InterruptedException, IOException {
        LoginPage loginPage = new LoginPage(web, get, Do);
        loginPage.login();
    }

    // test case

    // steps

    // assertions

}
