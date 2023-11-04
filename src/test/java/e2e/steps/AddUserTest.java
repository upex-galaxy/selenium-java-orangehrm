package e2e.steps;

import e2e.fixtures.TestBase;
import e2e.page.LoginPage;
import e2e.page.admin.UserManagementPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class AddUserTest extends TestBase {
    /*
    Feature: Admin | Add User

    Background:
    Given el admin esta logueado en el sistema
    * se ubica en el modulo Admin > User Management - HECHO
    * existe un empleado al que agregarle credenciales - HECHO

    Scenario 1: el administrador agrega un usuario con éxito - HECHO
    When el admin hace click en el botón "Add" - HECHO
    And el admin llena los campos requeridos - HECHO
    And hace click al botón "Save" - HECHO
    Then deberia aparecer un mensaje amistoso indicando "Sucess, Succesfully Saved" - HECHO
    And el admin deberia ser redirigido a la página con la lista de los usuarios del sistema - HECHO
    And debería ser agregado el nuevo usuario en la lista "Records Found" - HECHO

    Scenario 2: el administrador no puede agregar un usuario
    When el admin hace click en el botón "Add"
    And el admin llena los campos requeridos con data inválida
    Then debería aparecer un mensaje de error por campo con datos inválidos
    And el botón "Save" no hará nada

    */

    @BeforeEach
    @DisplayName("Precondition: User most be logged in")
    public void login() throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(web,get,Do);
        try {
            loginPage.login();
            WebElement adminTab = get.ByEqualText("Admin");
            Do.click(adminTab);
            Thread.sleep(1000);
            then.shouldContain(web.getCurrentUrl(), "admin/viewSystemUsers");
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("GX3-185 | TC1: Add a user successfully")
    public void addUserSuccessfully() throws InterruptedException, IOException {

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
        List<WebElement> data = get.WithinElement(givenEmployee, rowData);
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

        WebElement addButton = get.ByEqualText(" Add ");
        Do.click(addButton);
        Thread.sleep(1000);
        then.shouldContain(web.getCurrentUrl(), "admin/saveSystemUser");

        UserManagementPage ump = new UserManagementPage(web,get,Do);
        String response = ump.createUserWithData("BlackHol15d23", "A3b!7xZ*9qP", givenEmployeeNameValue, givenUserStatusValue);
        then.shouldBeEqual(response, "Successfully Saved");
        System.out.println("Response: " + response);
        Thread.sleep(4000);
        then.shouldContain(web.getCurrentUrl(), "admin/viewSystemUsers");

        ump.userSearch("BlackHol15d23");
        Thread.sleep(4000);

        List<WebElement> card = get.FilterByElement("[role=\"row\"]", ".oxd-table-cell");
        WebElement employeeSearch = card.get(0);
        List<WebElement> data2 = get.WithinElement(employeeSearch, rowData);
        then.shouldBeEqual(data2.get(1).getText(), "BlackHol15d23");

    }

    @Test
    @DisplayName("GX3-185 | TC2: Try to insert a invalid user")
    public void insertInvalidUserData(){
        
    }


}
