package e2e.page;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    @FindBy(css = "[class$='oxd-form'] [role='listbox'] > *")
    public List<WebElement> optionsOfDropdowns;
    @FindBy(css = "[class$='form-row'] [data-v-c93bdbf3]:nth-child(3) [tabindex='0']")
    private WebElement dropdownStatus;
    @FindBy(css = "[class$='form-row'] [data-v-c93bdbf3] [placeholder='Type for hints...']")
    public WebElement employeeNameInput;
    @FindBy(css = "[class$='form-row'] [data-v-c93bdbf3] [autocomplete='off']")
    public WebElement usernameInput;
    @FindBy(css = "[class$='password-cell'] [type='password']")
    public WebElement passwordInput;
    @FindBy(css = "[class$='item--gutters'] [type='password']")
    public WebElement confirmPasswordInput;
    @FindBy(css = "[type='submit']")
    public WebElement saveButton;
    @FindBy(css = "class*='oxd-text--toast-message']")
    public WebElement messageSuccess;
    @FindBy(css = "[class*='field-error-message']")
    public WebElement messageError;

    public GX3_3082_AddCredentialUser(WebDriver driver, Locator get, Action Do) {
        this.driver = driver;
        this.get = get;
        this.Do = Do;
        PageFactory.initElements(driver, this);
    }

    public void selectOptionUserRole(String role) throws InterruptedException {
        this.selectOptionsOfDropdown(dropdownUserRole, role);
    }

    public void selectOptionStatus(String status) throws InterruptedException {
        this.selectOptionsOfDropdown(dropdownStatus, status);
    }

    public void selectOptionsOfDropdown(WebElement element, String role) throws InterruptedException {
        String roleLoweCase = role.toLowerCase();
        Map<String, Integer> userRolesMap = new HashMap<String, Integer>() {
            {
                put("admin", 1);
                put("ess", 2);
                put("enabled", 1);
                put("disabled", 2);
            }
        };

        Integer roleTarget = userRolesMap.get(roleLoweCase);
        element.click();
        optionsOfDropdowns.get(roleTarget).click();
    }

    public void typeEmployeeName() throws InterruptedException, IOException {
        employeeNameInput.sendKeys("m");
        Thread.sleep(2000);
        employeeNameInput.click();
        Integer optionsSize = optionsOfDropdowns.size() - 1;
        Integer randomIndex = new Random().nextInt(optionsSize) + 1;
        optionsOfDropdowns.get(randomIndex).click();
    }

    public void typeUsername() throws InterruptedException {
        usernameInput.sendKeys(username);
    }
}
