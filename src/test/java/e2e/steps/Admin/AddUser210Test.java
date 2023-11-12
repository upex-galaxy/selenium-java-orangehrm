package e2e.steps.Admin;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebElement;

import e2e.fixtures.TestBase;
import e2e.page.LoginPage;

public class AddUser210Test extends TestBase {

    @Test
    @DisplayName("TC01: Test")
    public void tc1(TestInfo test) throws InterruptedException, IOException {
        LoginPage loginPage = new LoginPage(web, get, Do);
        loginPage.login();
        Thread.sleep(2000);

        List<WebElement> sidePanel = get.Xpaths("//*[@class=\"oxd-text oxd-text--span oxd-main-menu-item--name\"]");
        sidePanel.get(0).click();

        then.shouldContain(web.getCurrentUrl(), "/admin/viewSystemUsers");

        // List<WebElement> recordUsers = get.Xpaths("//*[@role=\"cell\"][4]");
        // String recordUser = recordUsers.get(0).getText();
        String recordUser = get.Xpath("//p[@class=\"oxd-userdropdown-name\"]").getText();
        Thread.sleep(3000);
        WebElement addButton = get.Xpath("//button[@type=\"button\"]//i[@class=\"oxd-icon bi-plus oxd-button-icon\"]");
        addButton.click();

        Thread.sleep(1000);

        then.shouldContain(web.getCurrentUrl(), "/admin/saveSystemUser");
        List<WebElement> addUserContainer = get.Xpaths("//*[@class]/*[@class=\"\"]");
        addUserContainer.get(0).click();
        Thread.sleep(1000);

        List<WebElement> selectAdminDropDown = get.Xpaths("//*[@role=\"listbox\"]/*");
        Do.click(selectAdminDropDown.get(1));
        Thread.sleep(1000);

        Do.enterValue(addUserContainer.get(1), recordUser);
        Thread.sleep(2000);
        WebElement listbox = get.ByRole("listbox");
        Do.click(listbox);
        addUserContainer.get(2).click();
        Thread.sleep(1000);
        List<WebElement> selectStatusDropDown = get.Xpaths("//*[@role=\"listbox\"]/*");
        Do.click(selectStatusDropDown.get(1));
        Thread.sleep(1000);

        Random random = new Random();
        String userName = "User" + random.nextInt(100000);
        Do.enterValue(addUserContainer.get(3), userName);
        Thread.sleep(1000);
        Do.enterValue(addUserContainer.get(4), "A3b!7xZ*9qP");
        Do.enterValue(addUserContainer.get(5), "A3b!7xZ*9qP");

        WebElement saveButton = get.Selector("button[type=\"submit\"]");
        Do.screenshot(test);
        saveButton.click();
        Thread.sleep(2000);
        String confirmSaved = get
                .Xpath("//p[@class=\"oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text\"]").getText();
        System.out.println("Confirmar: " + confirmSaved);
        Thread.sleep(3000);

        then.shouldContain(web.getCurrentUrl(), "/admin/viewSystemUsers");

        if (confirmSaved.equals("Successfully Saved")) {
            System.out.println("Successfully Saved");
        } else {
            System.out.println("Not Saved");
        }
        WebElement confirmSaveUser = get.Xpath("//*[contains(text(),\"" + userName + "\")]");
        if (userName.equals(confirmSaveUser.getText())) {
            System.out.println("User was created successfully");
        } else {
            System.out.println("User was not created successfully");
        }
        ;

        Thread.sleep(1000);

        // web.quit();
    }
    // @Test
    // @DisplayName("TC02: Test")
    // public void tc1() throws InterruptedException, IOException
    // {
    // }

}
