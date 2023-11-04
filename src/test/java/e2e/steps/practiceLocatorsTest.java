package e2e.steps;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;

import e2e.fixtures.TestBase;
import e2e.page.LoginPage;

public class practiceLocatorsTest extends TestBase {

    // * */ CSS Selectors
    // * */ #filtrar Tags => 'div'
    // * */ #4 Class => '.nombre-de-la-clase'
    // * */ #2 Id => '#searchPanel'
    // * */ #1 datatestid => '[datatestid=value]' // son atributos:
    // * */ #3 Attr => '[key=value]' // name=xx // colindex=zz ....
    // * Usar una Class/id como Attr => [class=nombre] // [id=xx]

    // * */ Xpaths (util para Selenium cuando no puedes agarrar el elemento con un
    // Css
    // Selector: último recurso, abstenerse)
    // * */ #filter Tags => '//div'
    // * */ #4 Class => '//*[@class="active oxd-main"]'
    // * */ #2 Id => '//*[@id="searchPanel"]'
    // * */ #1 datatestid => '//*[@datatestid="value"]'
    // * */ #3 Attr => '//*[@key="value"]'
    // * */ #1 Textos => '//*[text()="TEXTO"]'
    // * */ #1 TextoParcial => '//*[contains(text(),"TEXTO")]'

    @BeforeEach
    @DisplayName("Precondition: User must be Logged in")
    public void login() throws InterruptedException, IOException {
        LoginPage loginPage = new LoginPage(web, get, Do);
        loginPage.login();
    }

    @Test
    @DisplayName("GX3-78 | TC1: Admin adds a new user filling all fields")
    public void addUserSucessfully() throws InterruptedException {
        WebElement AdminTab = get.ByEqualText("Admin");
        Do.click(AdminTab);
        Thread.sleep(1000);
        then.shouldContain(web.getCurrentUrl(), "admin/viewSystemUsers");

        List<WebElement> cards = get.Selectors(".oxd-table-card");
        Integer availableEmployees = cards.size();
        Integer randomSelection = new Random().nextInt(availableEmployees);
        WebElement givenEmployee = cards.get(randomSelection);
        then.shouldBeVisible(givenEmployee);

        // ! List<WebElement> dataTry =
        // givenEmployee.findElements(By.cssSelector(".data"));
        // System.out.println(dataTry);

        // ! List<WebElement> data = get.WithinElements(givenEmployee, ".data");
        // System.out.print(data.size());
        // then.shouldBeEqualInt(data.size(), 4);

        WebElement addButton = get.ByEqualText(" Add ");
        Do.click(addButton);
        Thread.sleep(1000);
        then.shouldContain(web.getCurrentUrl(), "admin/saveSystemUser");

        WebElement userRoleDropdown = get.FilterByText("User Role", 2);
        Do.click(userRoleDropdown);
        WebElement roleOption = get.WithinTextElement("role=\"option\"", "Admin");
        Do.click(roleOption);

        WebElement statusDropdown = get.FilterByText("Status", 2);
        Do.click(statusDropdown);
        WebElement statusOption = get.WithinTextElement("role=\"option\"", "Enabled");
        Do.click(statusOption);

    }

}
