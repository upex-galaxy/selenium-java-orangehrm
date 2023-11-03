package e2e.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.By;

public class Locator {

    private WebDriver selenium;

    // *Constructor:
    public Locator(final WebDriver driver) {
        this.selenium = driver;
    }

    public WebElement Selector(String css_selector) {
        return this.selenium.findElement(By.cssSelector(css_selector));
    }

    public List<WebElement> Selectors(String css_selector) {
        return this.selenium.findElements(By.cssSelector(css_selector));
    }

    public WebElement Xpath(String xpath_selector) {
        return this.selenium.findElement(By.xpath(xpath_selector));
    }

    public List<WebElement> Xpaths(String xpath_selector) {
        return this.selenium.findElements(By.xpath(xpath_selector));
    }

    public WebElement ByTestId(String testid_name) {
        String data_test_id = String.format("[data-testid=%s]", testid_name);
        return this.selenium.findElement(By.cssSelector(data_test_id));
    }

    public List<WebElement> ByTestIds(String testid_name) {
        String data_test_id = String.format("[data-testid=%s]", testid_name);
        return this.selenium.findElements(By.cssSelector(data_test_id));
    }

    public WebElement ById(String id) {
        return this.selenium.findElement(By.id(id));
    }

    public List<WebElement> ByIds(String id) {
        return this.selenium.findElements(By.id(id));
    }

    public WebElement ByName(String name) {
        return this.selenium.findElement(By.name(name));
    }

    public List<WebElement> ByNames(String name) {
        return this.selenium.findElements(By.name(name));
    }

    public WebElement ByTag(String tag) {
        return this.selenium.findElement(By.tagName(tag));
    }

    public List<WebElement> ByTags(String tag) {
        return this.selenium.findElements(By.tagName(tag));
    }

    public WebElement ByClass(String class_name) {
        return this.selenium.findElement(By.className(class_name));
    }

    public List<WebElement> ByClasses(String class_name) {
        return this.selenium.findElements(By.className(class_name));
    }

    public WebElement BySpecClass(String class_selection) {
        String selector = String.format("[class*=%s]", class_selection);
        return this.selenium.findElement(By.cssSelector(selector)); // Specific Class selector
    }

    public List<WebElement> BySpecClasses(String class_selection) {
        String selector = String.format("[class*=%s]", class_selection);
        return this.selenium.findElements(By.cssSelector(selector)); // Specific Class selector
    }

    public WebElement ByEqualText(String tag, String givenText) {
        String elementToFind = String.format("//%s[text()=\"%s\"]", tag, givenText);
        return this.selenium.findElement(By.xpath(elementToFind));
    }

    public List<WebElement> ByEqualTexts(String tag, String givenText) {
        String elementToFind = String.format("//%s[text()=\"%s\"]", tag, givenText);
        return this.selenium.findElements(By.xpath(elementToFind));
    }

    public WebElement ByContainText(String tag, String givenText) {
        String elementToFind = String.format("//%s[contains(text(),\"%s\")]", tag, givenText);
        return this.selenium.findElement(By.xpath(elementToFind));
    }

    public List<WebElement> ByContainTexts(String givenText) {
        return this.selenium.findElements(By.partialLinkText(givenText));
    }

    public WebElement withinElement(WebElement parent, String withinElement) {
        return parent.findElement(By.cssSelector(withinElement));
    }

    public WebElement withinTextElement(WebElement parent, String tag, String givenText) {
        String xpath = String.format("//%s[text()=\"%s\"]", tag, givenText);
        return parent.findElement(By.xpath(xpath));
    }

    public WebElement filterByElement(String givenElement, String selectorFilter) {
        String locator = String.format("%s:has(%s)", givenElement, selectorFilter);
        return this.selenium.findElement(By.cssSelector(locator));
    }

    public WebElement filterByNotElement(String givenElement, String selectorFilter) {
        String locator = String.format("%s:not(%s)", givenElement, selectorFilter);
        return this.selenium.findElement(By.cssSelector(locator));
    }
}
