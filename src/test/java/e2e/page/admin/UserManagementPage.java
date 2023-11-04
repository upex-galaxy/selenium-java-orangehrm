package e2e.page.admin;

import e2e.utils.Action;
import e2e.utils.Locator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

public class UserManagementPage {

    WebDriver web;
    Locator get;
    Action Do;
    public Supplier<WebElement> userRoleSelect;
    public Supplier<WebElement> employeeNameInput;
    public Supplier<WebElement> statusSelect;
    public Supplier<WebElement> usernameInput;
    public Supplier<WebElement> passwordInput;
    public Supplier<WebElement> rePasswordInput;
    public Supplier<WebElement> saveButton;
    public Supplier<WebElement> searchButton;
    public Supplier<WebElement> roleOption;
    public Supplier<WebElement> successfullyAdvice;
    public Supplier<List<WebElement>> cards;


    public UserManagementPage(WebDriver web, Locator get, Action Do) {
        this.web = web;
        this.get = get;
        this.Do = Do;
        this.userRoleSelect = () -> this.get.FilterByText("User Role", 2);
        this.employeeNameInput = () -> this.get.FilterByText("Employee Name", 2);
        this.statusSelect = () -> this.get.FilterByText("Status", 2);
        this.usernameInput = () -> this.get.FilterByText("Username", 2);
        this.passwordInput = () -> this.get.FilterByText("Password", 2);
        this.rePasswordInput = () -> this.get.FilterByText("Confirm Password", 2);
        this.saveButton = () -> this.get.ByEqualText(" Save ");
        this.searchButton = () -> this.get.ByEqualText(" Search ");
        this.roleOption = () -> this.get.WithinTextElement("role=\"option\"", "Admin");
        this.successfullyAdvice = () -> this.get.ByEqualText("Successfully Saved");
        this.cards = () -> this.get.FilterByElement("[role=\"row\"]", ".oxd-table-cell");
    }

    public String createUserWithData(String username, String pw, String givenEmployeeNameValue, String givenUserStatusValue) throws InterruptedException, IOException {
        Do.click(this.userRoleSelect.get());
        Thread.sleep(500);
        Do.click(this.roleOption.get());
        Thread.sleep(500);
        Do.click(this.statusSelect.get());
        Thread.sleep(500);
        WebElement statusOption = get.WithinTextElement("role=\"option\"", givenUserStatusValue);
        Do.click(statusOption);
        Do.enterValue(this.employeeNameInput.get(), givenEmployeeNameValue);
        Thread.sleep(2000);
        Do.pressKeyDown();
        Do.screenshot();
        Do.pressEnter();
        Do.enterValue(this.usernameInput.get(), username);
        Do.enterValue(this.passwordInput.get(), pw);
        Do.enterValue(this.rePasswordInput.get(), pw);
        Do.click(this.saveButton.get());
        return this.successfullyAdvice.get().getText();
    }
    public void userSearch(String name){
        Do.enterValue(this.usernameInput.get(), name);
        Do.click(this.searchButton.get());
    }
}
