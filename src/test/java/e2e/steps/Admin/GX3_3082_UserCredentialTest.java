package e2e.steps.Admin;

import java.io.IOException;

import org.junit.jupiter.api.*;

import e2e.data.GX3_3082_DataForTest;
import e2e.data.GX3_3082_MessageData;
import e2e.fixtures.TestBase;
import e2e.page.GX3_3082_AddCredentialUser;
import e2e.page.LoginPage;

public class GX3_3082_UserCredentialTest extends TestBase {

    private LoginPage loginPage;
    private GX3_3082_AddCredentialUser addUserCredentialPage;
    private GX3_3082_DataForTest data;
    private GX3_3082_MessageData dataMessage;
    private String endpointUserCredential;

    @BeforeEach
    public void initializePagesAndData() {
        loginPage = new LoginPage(web, get, Do);
        addUserCredentialPage = new GX3_3082_AddCredentialUser(web, get, Do);
        data = new GX3_3082_DataForTest();
        dataMessage = new GX3_3082_MessageData();
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
        String expectMessage = dataMessage.getMessageSuccess.get();
        addUserCredentialPage.fillUserDataCredential("ESS", "Enabled", "defaultValue", "defaultValue", "defaultValue");
        addUserCredentialPage.clickSaveButton();
        addUserCredentialPage.verifyMessageSuccess(expectMessage);
    }

}
