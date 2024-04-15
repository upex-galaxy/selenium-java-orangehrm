package e2e.page;

import java.io.IOException;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import e2e.fixtures.TestBase;
import e2e.utils.Action;
import e2e.utils.Locator;

public class GX3_3082LoginPage {

    WebDriver driver;
    Locator get;
    Action Do;

    public Supplier<WebElement> usernameInput = () -> get.ByName("username");
    public Supplier<WebElement> passwordInput = () -> get.ByName("password");
    public Supplier<WebElement> submitButton = () -> get.Selector("[type='submit']");

    public GX3_3082LoginPage(WebDriver driver, Locator get, Action Do) {
        this.driver = driver;
        this.get = get;
        this.Do = Do;
    }

    public void typeUsername(String username) {
        usernameInput.get().sendKeys(username);
    }

    public void typePassword(String password) {
        passwordInput.get().sendKeys(password);
    }

    public void clickSubmitButton() {
        submitButton.get().click();
    }

    public void login(String username, String password) throws InterruptedException, IOException {
        driver.get(TestBase.BASE_URL);
        Thread.sleep(2000);
        this.typeUsername(username);
        this.typePassword(password);
        this.clickSubmitButton();
    }
}