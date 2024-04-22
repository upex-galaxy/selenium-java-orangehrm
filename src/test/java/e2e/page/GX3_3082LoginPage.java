package e2e.page;

import java.io.IOException;
import java.time.Duration;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

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
        this.waitVisibilityElement(usernameInput.get(), 1500);
        this.waitVisibilityElement(passwordInput.get(), 1500);
        this.typeUsername(username);
        this.typePassword(password);
        this.clickSubmitButton();
    }

    public void waitVisibilityElement(WebElement element, Integer timeoutsOnMilliSecond) throws InterruptedException {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(this.driver);
        wait.withTimeout(Duration.ofMillis(timeoutsOnMilliSecond));
        wait.pollingEvery(Duration.ofMillis(500));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}