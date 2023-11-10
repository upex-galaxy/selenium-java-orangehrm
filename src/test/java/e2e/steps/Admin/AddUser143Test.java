package e2e.steps.Admin;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;
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
        WebElement tittleAdmin = get.Selector(".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");
        String value = tittleAdmin.getText();
        System.out.println(value);
        then.shouldBeEqual(value, "Admin");
        // guardar los datos de un useR *********copiando lo de ely*****
        List<WebElement> cards = get.FilterByElement("[role=\"row\"]", ".oxd-table-cell");
        Integer availableEmployees = cards.size();
        Integer randomSelection = new Random().nextInt(availableEmployees);
        WebElement givenEmployee = cards.get(randomSelection);
        then.shouldBeVisible(givenEmployee);
        // String givenUsernameValue;
        String textUserRol;
        String textEmployeeName;
        String textEmployeeStatus;
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
        List<WebElement> data = get.WithinElement(givenEmployee, rowData);
        then.shouldBeEqualInt(data.size(), expectedSize);
        if (headlessValue != null && "true".equalsIgnoreCase(headlessValue)) {
            // givenUsernameValue = data.get(0).getText();
            textUserRol = data.get(1).getText();
            textEmployeeName = data.get(2).getText();
            textEmployeeStatus = data.get(3).getText();
        } else {
            // givenUsernameValue = data.get(1).getText();
            textUserRol = data.get(2).getText();
            textEmployeeName = data.get(3).getText();
            textEmployeeStatus = data.get(4).getText();
        }

        /*
         * comentando lo que hice porque no toma el headless
         * String headlessValue = System.getProperty("headless");
         * 
         * if (headlessValue != null && "true".equalsIgnoreCase(headlessValue)) {
         * WebElement username =
         * get.Xpath("//*[@class='oxd-table']//*[@role='cell'][1]");
         * String textUsername = username.getText();
         * System.out.println("eL USERNAME ES: " + textUsername);
         * WebElement getUserRol =
         * get.Xpath("//*[@class='oxd-table']//*[@role='cell'][2]");
         * String textUserRol = getUserRol.getText();
         * System.out.println("eL ROL ES: " + textUserRol);
         * WebElement employeeName =
         * get.Xpath("//*[@class='oxd-table']//*[@role='cell'][1]");
         * String textEmployeeName = employeeName.getText();
         * System.out.println("eL NOMBRE ES: " + textEmployeeName);
         * WebElement statusEmployee =
         * get.Xpath("//*[@class='oxd-table']//*[@role='cell'][3]");
         * String textEmployeeStatus = statusEmployee.getText();
         * System.out.println("eL STATUS ES: " + textEmployeeStatus);
         * } else {
         * 
         * }
         * 
         * WebElement username =
         * get.Xpath("//*[@class='oxd-table']//*[@role='cell'][2]");
         * String textUsername = username.getText();
         * System.out.println("eL USERNAME ES: " + textUsername);
         * WebElement getUserRol =
         * get.Xpath("//*[@class='oxd-table']//*[@role='cell'][3]");
         * String textUserRol = getUserRol.getText();
         * System.out.println("eL ROL ES: " + textUserRol);
         * WebElement employeeName =
         * get.Xpath("//*[@class='oxd-table']//*[@role='cell'][4]");
         * String textEmployeeName = employeeName.getText();
         * System.out.println("eL NOMBRE ES: " + textEmployeeName);
         * WebElement statusEmployee =
         * get.Xpath("//*[@class='oxd-table']//*[@role='cell'][5]");
         * String textEmployeeStatus = statusEmployee.getText();
         * System.out.println("eL STATUS ES: " + textEmployeeStatus);
         */
        // hacer click en add
        WebElement buttonAdd = get.Selector(".oxd-icon.bi-plus.oxd-button-icon");
        buttonAdd.click();
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
        if (textUserRol.equals("Admin")) {
            WebElement rolAdmin = get.Xpath("//*[@role=\"listbox\"]//*[contains(text(),\"Admin\")]");
            String textRol = rolAdmin.getText();
            System.out.println("se hizo clic en :" + textRol);
            rolAdmin.click();
        }
        if (textUserRol.equals("ESS")) {
            WebElement rolAdmin = get.Xpath("//*[@role=\"listbox\"]//*[contains(text(),\"ESS\")]");
            String textRol = rolAdmin.getText();
            System.out.println("se hizo clic en :" + textRol);
            rolAdmin.click();
        }

        // haciendo clic en el dropdown de status
        WebElement userStatus = get.Xpath("(//div[@class='oxd-select-text-input'])[2]");
        userStatus.click();

        // obteniendo locator dentro de user status mediante concatenacion
        if (textEmployeeStatus.equals("Enabled")) {
            WebElement status = get.Xpath("//*[@role=\"listbox\"]//*[contains(text(),\"Enabled\")]");
            String textStatus = status.getText();
            System.out.println("se hizo clic en : " + textStatus);
            status.click();
        }
        if (textEmployeeStatus.equals("Disabled")) {
            WebElement status = get.Xpath("//*[@role=\"listbox\"]//*[contains(text(),\"Disabled\")]");
            String textStatus = status.getText();
            System.out.println("se hizo clic en: " + textStatus);
            status.click();
        }

        // hacienco click en Employee Name

        WebElement selectEmployeeName = get.Xpath("//input[@placeholder='Type for hints...']");
        selectEmployeeName.sendKeys(textEmployeeName);
        Thread.sleep(2000);
        selectEmployeeName.sendKeys(Keys.ARROW_DOWN);
        selectEmployeeName.sendKeys(Keys.ARROW_UP);
        selectEmployeeName.sendKeys(Keys.ENTER);

        // haciendo clic en usrname

        WebElement locatorUserName = get.Xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
        Random random = new Random();
        String numRandom = String.valueOf(random.nextInt(1000));
        String usernameRandom = "DaryelinRossell" + numRandom;
        locatorUserName.sendKeys(usernameRandom);
        System.out.println(usernameRandom);

        // Ingresando password
        WebElement locatorPassword = get.Xpath("(//input[@type='password'])[1]");
        locatorPassword.sendKeys("BlackhOl3*");
        // Ingresando confirmacion del password
        WebElement confirmPassword = get.Xpath("(//input[@type='password'])[2]");
        confirmPassword.sendKeys("BlackhOl3*");

        // hacienco clic en save
        WebElement submitSave = get.Selector("button[type='submit']");
        submitSave.click();
        // confirmacion de Successfully Saved
        /*
         * WebElement frameSuccess =
         * get.Selector(".oxd-toast--success .oxd-text--toast-message");
         * String success = frameSuccess.getText();
         * System.out.println(success);
         * then.shouldContain(success, "Successfully Saved");
         * Thread.sleep(3000);
         */
        // confirmar que nos redirige a la pagina inicial
        WebElement tittleAdminConfirm = get.Selector(".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");
        String valueConfirm = tittleAdminConfirm.getText();
        System.out.println(value);
        then.shouldBeEqual(valueConfirm, "Admin");
        // confirmar que el user esta en la lista
        // WebElement findUser = get
        // .Xpath("//*[@class='oxd-table']//*[@role='cell']//*[contains(text(),\"DaryelinRossell\")]");
        WebElement findUser = get
                .Xpath("//*[@class='oxd-table']//*[@role='cell']//*[contains(text(),usernameRandom)]");
        String textFindUser = findUser.getText();
        System.out.println("se ENCONTRÓ: " + textFindUser);

    }
}
