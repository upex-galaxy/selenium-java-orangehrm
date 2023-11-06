package e2e.steps.Admin;

import java.io.IOException;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;

import e2e.fixtures.TestBase;
import e2e.page.LoginPage;

public class AddUser143Test extends TestBase {


    @BeforeEach
    @DisplayName("143 | [AT] OrangeHRM | Admin | Agregar un usuario")
    public void precondition() throws InterruptedException, IOException {
        LoginPage loginPage = new LoginPage(web, get, Do);
        web.get(BASE_URL);
        Thread.sleep(2000); // Temporary

        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.submitLogin();
        String actualURL = web.getCurrentUrl();
        then.shouldContain(actualURL, "/dashboard/index");
    }

    @Test
    @DisplayName("TC1: Agregar credenciales a un empleado")
    public void AddCredentialsUser() throws InterruptedException {

        // hacer clic en Admin
        WebElement buttonAdmin = get.Selector("a[href='/web/index.php/admin/viewAdminModule']");
        buttonAdmin.click();
        // verificar que estamos en la pestaña de admin
        WebElement tittleAdmin = get.Selector(".oxd-topbar-header-title");
        String value = tittleAdmin.getText();
        System.out.println(value);
        then.shouldBeEqual(value, "Admin\nUser Management");
        // guardar los datos de un user
    
        // hacer click en add
        WebElement buttonAdd = get.Selector(".oxd-icon.bi-plus.oxd-button-icon");
        buttonAdd.click();
        Thread.sleep(2000);
        // confirmar que estamos en la pestaña de creacion de credenciales(Add user)
        WebElement tittlePageAdmin = get.Selector(".oxd-topbar-header-title");
        String textAdmin = tittlePageAdmin.getText();
        System.out.println(textAdmin);
        then.shouldBeEqual(textAdmin, "Admin");
        // *******obteniendo los elementos del fomrulario
        // haciendo clic en el dropdown de user rol
        WebElement userRol = get.Xpath("(//div[@class='oxd-select-text-input'])[1]");
        userRol.click();
        // obteniendo locator dentro de user Rol mediante concatenacion
        WebElement rolAdmin = get.Xpath("//*[@role=\"listbox\"]//*[contains(text(),\"Admin\")]");
        String textRol = rolAdmin.getText();
        System.out.println(textRol);
        rolAdmin.click();
        // userStatus.click();
        
        // haciendo clic en el dropdown de status
        WebElement userStatus = get.Xpath("(//div[@class='oxd-select-text-input'])[2]");
        userStatus.click();
        Thread.sleep(2000);
        // obteniendo locator dentro de user status mediante concatenacion
        WebElement status = get.Xpath("//*[@role=\"listbox\"]//*[contains(text(),\"Enabled\")]");
        String textStatus = status.getText();
        System.out.println(textStatus);
        status.click();

        //hacienco click en Employee Name

        // WebElement employeeName = get.Selector("input[placeholder='Type for
        // hints...']");
        // WebElement UserName =
        // get.Selector("input.oxd-input.oxd-input--active.oxd-input--error");
        // Rellenar el formulario

    }
}
