package e2e.steps.Admin;

import java.io.IOException;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;

import e2e.fixtures.TestBase;
import e2e.page.LoginPage;

public class AddUsersTest extends TestBase {

    @BeforeEach
    public void precondition() throws InterruptedException, IOException {
        LoginPage loginPage = new LoginPage(web, get, Do);
        web.get(BASE_URL);
        Thread.sleep(1000); // Temporary

        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.submitLogin();
        String actualURL = web.getCurrentUrl();
        then.shouldContain(actualURL, "/dashboard/index");
    }

    @Test
    @DisplayName("TC1: Should add a user when admin fills all required input fields")
    public void addUserSuccess() throws InterruptedException, IOException {
        WebElement AdminTab = get.ByEqualText("Admin");
        Do.click(AdminTab);
        Thread.sleep(1000);
        then.shouldContain(web.getCurrentUrl(), "admin/viewSystemUsers");

        WebElement addButton = get.ByEqualText(" Add ");
        Do.click(addButton);
        Thread.sleep(1000);
        then.shouldContain(web.getCurrentUrl(), "admin/saveSystemUser");

        WebElement userRolDropdown = get.ByClass("oxd-select-text-input");
        Do.click(userRolDropdown);
        String givenRole = "Admin";
        WebElement roleOption = get.WithinTextElement("role=\"listbox\"", givenRole);
        Do.click(roleOption);
        String selectedRoleValue = get.ByClass("oxd-select-text-input").getText();
        then.shouldBeEqual(givenRole, selectedRoleValue);
    }
}
