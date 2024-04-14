package e2e.steps.Admin;

import java.io.IOException;

import org.junit.jupiter.api.*;

import e2e.data.GX3_3082_DataForTest;
import e2e.data.GX3_3082_MessageData;
import e2e.fixtures.TestBase;
import e2e.page.GX3_3082_AddCredentialUser;
import e2e.page.LoginPage;
import io.qameta.allure.*;
import static io.qameta.allure.SeverityLevel.*;

@Feature("Admin")
@Story("GX3-3082: OrangeHRM | Admin | Agregar credenciales del usuario")
@Owner("PabloCz9")
public class GX3_3082_UserCredentialTest extends TestBase {

    private LoginPage loginPage;
    private GX3_3082_AddCredentialUser addUserCredentialPage;
    private GX3_3082_DataForTest data;
    private GX3_3082_MessageData dataMessage;
    private String endpointUserCredential;
    private String endpointViewUser;

    public void cleanRecords() throws InterruptedException, IOException {
        addUserCredentialPage.deleteRecords(endpointViewUser);
    }

    @BeforeEach
    public void initializePagesAndData() {
        loginPage = new LoginPage(web, get, Do);
        addUserCredentialPage = new GX3_3082_AddCredentialUser(web, get, Do);
        data = new GX3_3082_DataForTest();
        dataMessage = new GX3_3082_MessageData();
        endpointViewUser = data.getEndpointViewUsers.get();
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
    @Severity(NORMAL)
    @Issue("https://upexgalaxy38.atlassian.net/browse/GX3-3082")
    @DisplayName("3087 | TC1: Validar poder agregar credenciales a un usuario con Rol ESS")
    public void TC1(TestInfo testInfo) throws InterruptedException, IOException {
        Allure.step("Asignar rol ESS y completar las credenciales del usuario",
                () -> {
                    addUserCredentialPage.fillUserDataCredential("ESS", "Enabled",
                            "defaultValue", "defaultValue",
                            "defaultValue");
                });
        String expectMessage = dataMessage.getMessageSuccess.get();
        Allure.step("hacer click en el boton save", () -> {
            addUserCredentialPage.clickSaveButton();
        });
        Allure.step("validar agregar credenciales al usuario", () -> {
            addUserCredentialPage.verifyMessageSuccess(expectMessage);
            Do.screenshot(testInfo);
        });
        cleanRecords();
    }

    @Test
    @Severity(NORMAL)
    @Issue("https://upexgalaxy38.atlassian.net/browse/GX3-3082")
    @DisplayName("3087 | TC2: Validar poder agregar credenciales a un usuario con Rol Admin")
    public void TC2(TestInfo testInfo) throws InterruptedException, IOException {
        Allure.step("Asignar rol admin y completar las credenciales del usuario", () -> {
            addUserCredentialPage.fillUserDataCredential("Admin", "Enabled", "defaultValue", "defaultValue",
                    "defaultValue");
        });
        String expectMessage = dataMessage.getMessageSuccess.get();
        Allure.step("hacer click en el boton save", () -> {
            addUserCredentialPage.clickSaveButton();
        });
        Allure.step("validar agregar credenciales al usuario", () -> {
            addUserCredentialPage.verifyMessageSuccess(expectMessage);
            Do.screenshot(testInfo);
        });
        cleanRecords();
    }

    @Test
    @Severity(NORMAL)
    @Issue("https://upexgalaxy38.atlassian.net/browse/GX3-3082")
    @DisplayName("3087 | TC3: Validar poder agregar credenciales a un usuario con Status Enabled")
    public void TC3(TestInfo testInfo) throws InterruptedException, IOException {
        Allure.step("Asignar status Enabled y completar las credenciales del usuario", () -> {
            addUserCredentialPage.fillUserDataCredential("Admin", "Enabled", "defaultValue", "defaultValue",
                    "defaultValue");
        });
        String expectMessage = dataMessage.getMessageSuccess.get();
        Allure.step("hacer click en el boton save", () -> {
            addUserCredentialPage.clickSaveButton();
        });
        Allure.step("validar agregar credenciales al usuario", () -> {
            addUserCredentialPage.verifyMessageSuccess(expectMessage);
            Do.screenshot(testInfo);
        });
        cleanRecords();
    }

    @Test
    @Severity(NORMAL)
    @Issue("https://upexgalaxy38.atlassian.net/browse/GX3-3082")
    @DisplayName("3087 | TC4: Validar poder agregar credenciales a un usuario con Status Disabled")
    public void TC4(TestInfo testInfo) throws InterruptedException, IOException {
        Allure.step("Asignar status Disabled y completar las credenciales del usuario", () -> {
            addUserCredentialPage.fillUserDataCredential("Admin", "Disabled", "defaultValue", "defaultValue",
                    "defaultValue");
        });
        String expectMessage = dataMessage.getMessageSuccess.get();
        Allure.step("hacer click en el boton save", () -> {
            addUserCredentialPage.clickSaveButton();
        });
        Allure.step("validar agregar credenciales al usuario", () -> {
            addUserCredentialPage.verifyMessageSuccess(expectMessage);
            Do.screenshot(testInfo);
        });
        cleanRecords();
    }

}
