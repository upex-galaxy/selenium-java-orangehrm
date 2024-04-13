package e2e.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.github.javafaker.Faker;

import e2e.utils.Action;
import e2e.utils.Locator;

public class GX3_3082_AddCredentialUser {

    private WebDriver driver;
    private Locator get;
    private Action Do;
    private Faker faker = new Faker();
    String username = faker.name().username();
    String password = faker.internet().password();

    @FindBy(css = "[class$='form-row'] [data-v-c93bdbf3]:nth-child(1) [tabindex='0']")
    private WebElement dropdownUserRole;
    @FindBy(css = "[class$='form-row'] [data-v-c93bdbf3]:nth-child(1) [tabindex='0']")
    public List<WebElement> optionsOfDropdowns;
    @FindBy(css = "[class$='form-row'] [data-v-c93bdbf3]:nth-child(3) [tabindex='0']")
    private WebElement dropdownStatus;

    public GX3_3082_AddCredentialUser(WebDriver driver, Locator get, Action Do) {
        this.driver = driver;
        this.get = get;
        this.Do = Do;
    }
}
