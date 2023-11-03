package e2e.steps.Admin;

import java.io.IOException;

import org.junit.jupiter.api.*;

import e2e.fixtures.TestBase;
import e2e.page.LoginPage;

public class AddUser142Test extends TestBase {
    // ? TD: https://upexgalaxy26.atlassian.net/browse/GX3-142

    // * */ Precondition
    @BeforeEach
    public void precondition() throws InterruptedException, IOException {
        // todo: Login
        LoginPage loginPage = new LoginPage(web, get, Do);
        loginPage.login();
        // todo: Estar en User Management url ?
        String expectedEnd = "admin/viewSystemUsers";

        // todo: Employee should exist
        // todo: User

    }

    // * */ Test Case: Agregar un Usuario
    @Test
    @DisplayName("TC1: Should add a User when admin fills all fields correclty")
    public void addUserFromOneEmployee() {
        // todo: When el admin hace click en el botón "Add"
        // todo: And el admin llena los campos requeridos
        // todo: And hace click al botón "Save"
        // todo: Then deberia aparecer un mensaje amistoso indicando "Sucess,Succesfully
        // Saved"
        // todo: And el admin deberia ser redirigido a la página con la lista de los
        // usuarios del sistema
        // todo: And debería ser agregado el nuevo usuario en la lista "Records Found"
    }

}
