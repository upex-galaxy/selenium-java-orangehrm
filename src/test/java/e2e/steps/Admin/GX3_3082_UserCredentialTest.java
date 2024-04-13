package e2e.steps.Admin;

import java.io.IOException;

import org.junit.jupiter.api.*;

import e2e.fixtures.TestBase;
import e2e.page.GX3_3082_AddCredentialUser;
import e2e.page.LoginPage;

public class GX3_3082_UserCredentialTest extends TestBase {

    private LoginPage loginPage;
    private GX3_3082_AddCredentialUser addUserPage;

    @BeforeEach
    public void initializePagesAndData() {
        loginPage = new LoginPage(web, get, Do);
        addUserPage = new GX3_3082_AddCredentialUser(web, get, Do);
    }

    @BeforeEach
    @DisplayName("Precondition")
    public void precondition() throws InterruptedException, IOException {
        web.get(BASE_URL);
    }

    @Test
    @DisplayName("3087 | TC1: Validar poder agregar credenciales a un usuario con Rol ESS")
    public void TC1() throws InterruptedException, IOException {
        System.out.println(1);
    }

}
