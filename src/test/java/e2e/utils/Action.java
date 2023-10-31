package e2e.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Action {
    private Actions action;

    // *Constructor:
    public Action(final WebDriver driver) {
        this.action = new Actions(driver);
    }

    public void enterValue(WebElement locator, String textValue) {
        action.sendKeys(locator, textValue).perform();
    }

    public void click(WebElement locator) {
        action.click(locator).perform();
    }

    public void dbClick(WebElement locator) {
        action.doubleClick(locator).perform();
    }

    public void rightClick(WebElement locator) {
        action.contextClick(locator).perform();
    }
}