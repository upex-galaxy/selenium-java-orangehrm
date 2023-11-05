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
    public Supplier<WebElement> errorUserRoleMessage;
    public Supplier<WebElement> errorEmployeeNameMessage;
    public Supplier<WebElement> errorStatusMessage;
    public Supplier<WebElement> errorUsernameMessage;
    public Supplier<WebElement> errorPasswordMessage;
    public Supplier<WebElement> errorRePasswordMessage;


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
        this.errorUserRoleMessage = () -> this.get.FilterByTextChild("User Role", 2, "span");
        this.errorEmployeeNameMessage = () -> this.get.FilterByTextChild("Employee Name", 2, "span");
        this.errorStatusMessage = () -> this.get.FilterByTextChild("Status", 2, "span");
        this.errorUsernameMessage = () -> this.get.FilterByTextChild("Username", 2, "span");
        this.errorPasswordMessage = () -> this.get.FilterByTextChild("Password", 2, "span");
        this.errorRePasswordMessage = () -> this.get.FilterByTextChild("Confirm Password", 2, "span");
    }

    public String createUserWithData(String username, String pw, String rpw, String givenEmployeeNameValue, String givenUserStatusValue,
                                     boolean insertUserRole, boolean insertStatus, boolean insertValidUsername,
                                     boolean insertPw, boolean insertRePw) throws InterruptedException, IOException {
        boolean correctUsername = username.length() >= 5 && username.length() < 41;
        boolean shortyPw = pw.length() >= 7 && pw.length() < 64;
        boolean onlyUppercase = pw.matches("[A-Z]+");
        boolean correctsPasswords = pw.equals(rpw);
        boolean happyPath = !givenEmployeeNameValue.contains("empty") && insertUserRole && insertStatus
                && insertValidUsername && insertPw && insertRePw && correctUsername &&
                correctsPasswords && shortyPw && !onlyUppercase;
        String response = "";

        if(insertUserRole){
            Do.click(this.userRoleSelect.get());
            Thread.sleep(500);
            Do.click(this.roleOption.get());
            Thread.sleep(500);
        }
        if (insertStatus){
            Do.click(this.statusSelect.get());
            Thread.sleep(500);
            WebElement statusOption = get.WithinTextElement("role=\"option\"", givenUserStatusValue);
            Do.click(statusOption);
        }
        if (!givenEmployeeNameValue.equals("empty")){
            Do.enterValue(this.employeeNameInput.get(), givenEmployeeNameValue);
            Thread.sleep(2000);
            Do.pressKeyDown();
            Do.screenshot();
            Do.pressEnter();
        }
        if (insertValidUsername)
            Do.enterValue(this.usernameInput.get(), username);
        if(insertPw)
            Do.enterValue(this.passwordInput.get(), pw);
        if (insertRePw)
            Do.enterValue(this.rePasswordInput.get(), rpw);
        Do.click(this.saveButton.get());
        if (happyPath)
            response = this.successfullyAdvice.get().getText();
        else if(!insertUserRole){
            response = this.errorUserRoleMessage.get().getText();
        }else if(givenEmployeeNameValue.equals("empty")){
            response = this.errorEmployeeNameMessage.get().getText();
        }else if(!insertStatus){
            response = this.errorStatusMessage.get().getText();
        }else if(!insertValidUsername || !correctUsername){
            response = this.errorUsernameMessage.get().getText();
        }else if(!insertPw || !shortyPw || onlyUppercase){
            response = this.errorPasswordMessage.get().getText();
        }else if(!insertRePw || !correctsPasswords){
            response = this.errorRePasswordMessage.get().getText();
        }
        return response;
    }

    public void userSearch(String name){
        Do.enterValue(this.usernameInput.get(), name);
        Do.click(this.searchButton.get());
    }
}
