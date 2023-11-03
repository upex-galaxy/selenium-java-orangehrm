package e2e.steps.Admin;

import java.io.IOException;
import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import e2e.fixtures.DriverManager;
import e2e.fixtures.TestBase;
import e2e.page.LoginPage;
import e2e.utils.Action;
import e2e.utils.Assertion;
import e2e.utils.Locator;

public class AddUser145test {
    public static final String BASE_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/loginp";
    private static final DriverManager MANAGER = new DriverManager();
    public WebDriver web;
    public Locator get;
    public Assertion then;
    public Action Do;
    private String textValue;

    // TD: https://upexgalaxy26.atlassian.net/browse/GX3-145

    // Precondition

    @BeforeEach
    public void Precondition() throws InterruptedException, IOException {
        // todo: login
        LoginPage loginPage = new LoginPage(web, get, Do);
        loginPage.login();
    }

    // Shortcut
    // TC1
    @Test
    @DisplayName("TC1: Should login successfully")
    public void login() throws InterruptedException, IOException {
        LoginPage loginPage = new LoginPage(web, get, Do);
        web.get(BASE_URL);
        Thread.sleep(1000); // Temporary

        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.submitLogin();
        String actualURL = web.getCurrentUrl();
        then.shouldContain(actualURL, "/dashboard/index");
    }
}