package e2e.steps.Admin;

import java.io.IOException;

import org.junit.jupiter.api.*;

import e2e.data.DataForTest;
import e2e.fixtures.TestBase;
import e2e.page.GX3_3082_AddCredentialUser;
import e2e.page.LoginPage;

public class GX3_3082_UserCredentialTest extends TestBase {

    private LoginPage loginPage;
    private GX3_3082_AddCredentialUser addUserCredentialPage;
    private DataForTest data;
    private String endpointUserCredential;

    @BeforeEach
    public void initializePagesAndData() {
        loginPage = new LoginPage(web, get, Do);
        addUserCredentialPage = new GX3_3082_AddCredentialUser(web, get, Do);
        data = new DataForTest();
        endpointUserCredential = data.getEndpointUserCredential.get();
    }

    @BeforeEach
    @DisplayName("Precondition")
    public void precondition() throws InterruptedException, IOException {
        web.get(BASE_URL);
        initializePagesAndData();
        loginPage.login();
        web.get(BASE_URL.concat(endpointUserCredential));
    }

    @Test
    @DisplayName("3087 | TC1: Validar poder agregar credenciales a un usuario con Rol ESS")
    public void TC1() throws InterruptedException, IOException {
        addUserCredentialPage.selectOptionStatus("Enabled");
    }

}
