package e2e.steps.Admin;

import java.io.IOException;

import org.junit.jupiter.api.*;

import e2e.data.GX3_3082_DataForTest;
import e2e.data.GX3_3082_MessageData;
import e2e.fixtures.TestBase;
import e2e.page.GX3_3082LoginPage;
import e2e.page.GX3_3082_AddCredentialUser;
import io.qameta.allure.*;
import static io.qameta.allure.SeverityLevel.*;

@Feature("Admin")
@Story("GX3-3082: OrangeHRM | Admin | Agregar credenciales del usuario")
@Owner("PabloCz9")
public class GX3_3082_UserCredentialTest extends TestBase {

    private GX3_3082LoginPage loginPage;
    private GX3_3082_AddCredentialUser addUserCredentialPage;
    private GX3_3082_DataForTest data;
    private GX3_3082_MessageData dataMessage;
    private String endpointUserCredential;

    @BeforeEach
    public void initializePagesAndData() {
        loginPage = new GX3_3082LoginPage(web, get, Do);
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
        loginPage.login("Admin", "admin123");
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
        Allure.step("hacer click en el boton save", () -> {
            addUserCredentialPage.clickSaveButton();
        });
        Allure.step("validar agregar credenciales al usuario", () -> {
            addUserCredentialPage.verifyMessageSuccess();
            Do.screenshot(testInfo);
        });
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
        Allure.step("hacer click en el boton save", () -> {
            addUserCredentialPage.clickSaveButton();
        });
        Allure.step("validar agregar credenciales al usuario", () -> {
            addUserCredentialPage.verifyMessageSuccess();
            Do.screenshot(testInfo);
        });
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
        Allure.step("hacer click en el boton save", () -> {
            addUserCredentialPage.clickSaveButton();
        });
        Allure.step("validar agregar credenciales al usuario", () -> {
            addUserCredentialPage.verifyMessageSuccess();
            Do.screenshot(testInfo);
        });
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
        Allure.step("hacer click en el boton save", () -> {
            addUserCredentialPage.clickSaveButton();
        });
        Allure.step("validar agregar credenciales al usuario", () -> {
            addUserCredentialPage.verifyMessageSuccess();
            Do.screenshot(testInfo);
        });
    }

    @Test
    @Severity(NORMAL)
    @Issue("https://upexgalaxy38.atlassian.net/browse/GX3-3082")
    @DisplayName("3087 | TC5: Validar poder agregar credenciales a un usuario con el mínimo de caracteres en los campos Username y Password")
    public void TC5(TestInfo testInfo) throws InterruptedException, IOException {
        String usernameFiveChar = data.getUsernameFiveChar.get();
        String passwdSevenChar = data.getPasswordSevenChar.get();
        Allure.step("insertar valores mínimos permitidos y completar las credenciales del usuario", () -> {
            addUserCredentialPage.fillUserDataCredential("Admin", "Disabled",
                    usernameFiveChar,
                    passwdSevenChar,
                    passwdSevenChar);
        });
        Allure.step("hacer click en el boton save", () -> {
            addUserCredentialPage.clickSaveButton();
        });
        Allure.step("validar agregar credenciales al usuario", () -> {
            addUserCredentialPage.verifyMessageSuccess();
            Do.screenshot(testInfo);
        });

    }

    @Test
    @Severity(NORMAL)
    @Issue("https://upexgalaxy38.atlassian.net/browse/GX3-3082")
    @DisplayName("3087 | TC6: Validar poder agregar credenciales a un usuario con el máximo de caracteres en los campos Username y Password")
    public void TC6(TestInfo testInfo) throws InterruptedException, IOException {
        String usernameMaxLongChar = data.getUsernameMaxLong.get();
        String passwdMaxLongChar = data.getPasswordMaxLong.get();
        Allure.step("insertar valores máximos permitidos y completar las credenciales del usuario", () -> {
            addUserCredentialPage.fillUserDataCredential("Admin", "Enabled",
                    usernameMaxLongChar,
                    passwdMaxLongChar,
                    passwdMaxLongChar);
        });
        Allure.step("hacer click en el boton save", () -> {
            addUserCredentialPage.clickSaveButton();
        });
        Allure.step("validar agregar credenciales al usuario", () -> {
            addUserCredentialPage.verifyMessageSuccess();
            Do.screenshot(testInfo);
        });
    }

    @Test
    @Severity(NORMAL)
    @Issue("https://upexgalaxy38.atlassian.net/browse/GX3-3082")
    @DisplayName("3087 | TC7: Validar NO poder agregar credenciales a un usuario con los campos vacíos")
    public void TC7(TestInfo testInfo) throws InterruptedException, IOException {
        String fieldsErrorEmpty = dataMessage.getFieldsErrorEmpty.get();
        String expectMessages = fieldsErrorEmpty;
        Allure.step("hacer click en el boton save", () -> {
            addUserCredentialPage.clickSaveButton();
        });
        Allure.step("validar NO agregar credenciales al usuario", () -> {
            addUserCredentialPage.verifyMessageEmpty(expectMessages);
            then.shouldContain(web.getCurrentUrl(), endpointUserCredential);
            Do.screenshot(testInfo);
        });
    }

    @Test
    @Severity(NORMAL)
    @Issue("https://upexgalaxy38.atlassian.net/browse/GX3-3082")
    @DisplayName("3087 | TC8: Validar NO poder agregar credenciales a un usuario que no cumplen el mínimo de caracteres en los campos Username y Password")
    public void TC8(TestInfo testInfo) throws InterruptedException, IOException {
        String UsernameFourthChar = data.getUsernameFourthChar.get();
        String passwdSixChar = data.getPasswordSixChar.get();

        Allure.step("insertar valores mínimos NO permitidos y completar las credenciales del usuario", () -> {
            addUserCredentialPage.fillUserDataCredential("ESS", "Enabled",
                    UsernameFourthChar,
                    passwdSixChar,
                    passwdSixChar);
        });
        Allure.step("hacer click en el boton save", () -> {
            addUserCredentialPage.clickSaveButton();
        });
        Allure.step("validar NO agregar credenciales al usuario", () -> {
            then.shouldContain(web.getCurrentUrl(), endpointUserCredential);
            Do.screenshot(testInfo);
        });
    }

    @Test
    @Severity(NORMAL)
    @Issue("https://upexgalaxy38.atlassian.net/browse/GX3-3082")
    @DisplayName("3087 | TC9: Validar NO poder agregar credenciales a un usuario que no cumplen el máximo de caracteres en los campos Username y Password")
    public void TC9(TestInfo testInfo) throws InterruptedException, IOException {
        String usernameMaxOverLong = data.getUsernameMaxOverLong.get();
        String passwdOverMaxLong = data.getPasswordOverMaxLong.get();

        Allure.step("insertar valores máximos NO permitidos y completar las credenciales del usuario", () -> {
            addUserCredentialPage.fillUserDataCredential("Admin", "Disabled",
                    usernameMaxOverLong,
                    passwdOverMaxLong,
                    passwdOverMaxLong);
        });
        Allure.step("hacer click en el boton save", () -> {
            addUserCredentialPage.clickSaveButton();
        });
        Allure.step("validar NO agregar credenciales al usuario", () -> {
            then.shouldContain(web.getCurrentUrl(), endpointUserCredential);
            Do.screenshot(testInfo);
        });
    }
}
