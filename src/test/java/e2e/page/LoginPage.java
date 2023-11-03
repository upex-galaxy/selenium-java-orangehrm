package e2e.page;

import java.io.IOException;
import java.util.function.Supplier;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import e2e.utils.Action;
import e2e.utils.Locator;
import e2e.fixtures.TestBase;

public class LoginPage {

    WebDriver web;
    Locator get;
    Action Do;
    public Supplier<WebElement> usernameInput;
    public Supplier<WebElement> passwordInput;
    public Supplier<WebElement> submitButton;

    public LoginPage(WebDriver driver, Locator get, Action Do) {
        this.web = driver;
        this.get = get;
        this.Do = Do;
        this.usernameInput = () -> this.get.ByName("username");
        this.passwordInput = () -> this.get.Selector("[type=\"password\"]");
        this.submitButton = () -> this.get.Selector("[type=\"submit\"]");
    }

    public void enterUsername(String textValue) {
        this.Do.enterValue(this.usernameInput.get(), textValue);
    }

    public void enterPassword(String textValue) {
        this.Do.enterValue(this.passwordInput.get(), textValue);
    }

    public void submitLogin() throws InterruptedException, IOException {
        this.Do.click(this.submitButton.get());
        Thread.sleep(1000);
    }

    // * Shortcut
    public void login() throws InterruptedException, IOException {
        web.get(TestBase.BASE_URL);
        Thread.sleep(1000);

        this.enterUsername("Admin");
        this.enterPassword("admin123");
        this.submitLogin();
    }
}
