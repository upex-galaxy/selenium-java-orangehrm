package e2e.steps.Admin;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;

import e2e.fixtures.TestBase;
import e2e.page.LoginPage;

@Disabled("Flaky Test, inestabilidad en selectores por texto , aveces cambia el idioma")
public class AddUser142Test extends TestBase {
    // ? TD: https://upexgalaxy26.atlassian.net/browse/GX3-142

    @BeforeEach
    @DisplayName("Precondition: User must be Logged in")
    public void login() throws InterruptedException, IOException {
        LoginPage loginPage = new LoginPage(web, get, Do);
        loginPage.login();
    }

    @Test
    @DisplayName("GX3-78 | TC1: Should add a new user when filling all required fields correclty")
    public void addUserSucessfully(TestInfo testInfo) throws InterruptedException, IOException {
        WebElement AdminTab = get.ByEqualText("Admin");
        Do.click(AdminTab);
        Thread.sleep(1000);
        then.shouldContain(web.getCurrentUrl(), "admin/viewSystemUsers");

        // todo: Given existe Data disponible en la lista de Empleados...
        List<WebElement> cards = get.FilterByElement("[role=\"row\"]", ".oxd-table-cell");
        Integer availableEmployees = cards.size();
        Integer randomSelection = new Random().nextInt(availableEmployees);
        WebElement givenEmployee = cards.get(randomSelection);
        then.shouldBeVisible(givenEmployee);

        // Esto corre únicamente cuando se ejecuta por headless:
        String givenUsernameValue;
        String givenUserRoleValue;
        String givenEmployeeNameValue;
        String givenUserStatusValue;
        Integer expectedSize;
        String rowData;
        String headlessValue = System.getProperty("headless");
        if (headlessValue != null && "true".equalsIgnoreCase(headlessValue)) {
            rowData = "[role=cell] .data";
            expectedSize = 4;
        } else {
            rowData = "[role=\"cell\"]>div";
            expectedSize = 6;
        }
        List<WebElement> data = get.WithinElements(givenEmployee, rowData);
        then.shouldBeEqualInt(data.size(), expectedSize);
        if (headlessValue != null && "true".equalsIgnoreCase(headlessValue)) {
            givenUsernameValue = data.get(0).getText();
            givenUserRoleValue = data.get(1).getText();
            givenEmployeeNameValue = data.get(2).getText();
            givenUserStatusValue = data.get(3).getText();
        } else {
            givenUsernameValue = data.get(1).getText();
            givenUserRoleValue = data.get(2).getText();
            givenEmployeeNameValue = data.get(3).getText();
            givenUserStatusValue = data.get(4).getText();
        }

        System.out.println("givenUsername:");
        System.out.println(givenUsernameValue);
        System.out.println("givenUserRole:");
        System.out.println(givenUserRoleValue);
        System.out.println("givenEmployeeName:");
        System.out.println(givenEmployeeNameValue);
        System.out.println("givenUserStatus:");
        System.out.println(givenUserStatusValue);

        // todo: When el admin hace click en el botón "Add"
        WebElement addButton = get.ByEqualText(" Add ");
        Do.click(addButton);
        Thread.sleep(1000);
        then.shouldContain(web.getCurrentUrl(), "admin/saveSystemUser");

        // todo: And el admin llena los campos requeridos
        WebElement userRoleDropdown = get.FilterByText("User Role", 2);
        Do.click(userRoleDropdown);
        WebElement roleOption = get.WithinTextElement("role=\"option\"", "Admin");
        Do.click(roleOption);

        WebElement statusDropdown = get.FilterByText("Status", 2);
        Do.click(statusDropdown);
        WebElement statusOption = get.WithinTextElement("role=\"option\"", givenUserStatusValue);
        Do.click(statusOption);

        WebElement employeeNameField = get.FilterByText("Employee Name", 2);
        Do.enterValue(employeeNameField, givenEmployeeNameValue);
        Thread.sleep(2000);
        Do.pressKeyDown();
        Do.screenshot(testInfo);
        Do.pressEnter();

        WebElement usernameField = get.FilterByText("Username", 2);
        Do.enterValue(usernameField, "BlackholeUser");

        WebElement passwordField = get.FilterByText("Password", 2);
        Do.enterValue(passwordField, "A3b!7xZ*9qP");

        WebElement confirmPasswordField = get.FilterByText("Confirm Password", 2);
        Do.enterValue(confirmPasswordField, "A3b!7xZ*9qP");

        // todo: And hace click al botón "Save"
        // WebElement saveButton = get.WithinTextElement("type=\"submit\"", "Save");
        // Do.click(saveButton);
        // todo: Then deberia aparecer un mensaje indicando "Sucess, Succesfully Saved"
        // todo: And el admin deberia ser redirigido a la página anterior
        // todo: And debería ser agregado el nuevo usuario en la lista "Records Found"

    }

}
