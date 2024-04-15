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
        Allure.step("hacer click en el boton save", () -> {
            addUserCredentialPage.clickSaveButton();
        });
        Allure.step("validar NO agregar credenciales al usuario", () -> {
            addUserCredentialPage.verifyMessageErrorVisibiliTy();
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

    @Test
    @Severity(NORMAL)
    @Issue("https://upexgalaxy38.atlassian.net/browse/GX3-3082")
    @DisplayName("3087 | TC10: Validar NO poder agregar credenciales a un usuario cuando el campo password no tiene al menos 1 letra minúscula")
    public void TC10(TestInfo testInfo) throws InterruptedException, IOException {

        String passwdNoLowerCase = data.getPasswordNoLower.get();
        String passwdErrorNoLoweCase = dataMessage.getPasswdErrorNoLowerCase.get();
        String[] expectMessages = { passwdErrorNoLoweCase };

        Allure.step("insertar valores sin ninguna letra minúscula y completar las credenciales del usuario", () -> {
            addUserCredentialPage.fillUserDataCredential("ESS", "Disabled",
                    "defaultValue",
                    passwdNoLowerCase,
                    passwdNoLowerCase);
        });
        Allure.step("hacer click en el boton save", () ->

        {
            addUserCredentialPage.clickSaveButton();
        });
        Allure.step("validar NO agregar credenciales al usuario", () -> {
            addUserCredentialPage.verifyMsgPasswordError(expectMessages);
            then.shouldContain(web.getCurrentUrl(), endpointUserCredential);
            Do.screenshot(testInfo);
        });
    }

    @Disabled("Defecto - TC11")
    @Test
    @Severity(NORMAL)
    @Issue("https://upexgalaxy38.atlassian.net/browse/GX3-3082")
    @DisplayName("3087 | TC11: Validar NO poder agregar credenciales a un usuario cuando el campo password no tiene al menos 1 letra mayúscula")
    public void TC11(TestInfo testInfo) throws InterruptedException, IOException {

        String passwdNoUpperCase = data.getPasswordNoUpper.get();
        String passwdErrorNoUpperCase = dataMessage.getPasswdErrorNoUpperCase.get();
        String[] expectMessages = { passwdErrorNoUpperCase };

        Allure.step("insertar valores sin ninguna letra mayúscula y completar las credenciales del usuario", () -> {
            addUserCredentialPage.fillUserDataCredential("ESS", "Disabled",
                    "defaultValue",
                    passwdNoUpperCase,
                    passwdNoUpperCase);
        });
        Allure.step("hacer click en el boton save", () ->

        {
            addUserCredentialPage.clickSaveButton();
        });
        Allure.step("validar NO agregar credenciales al usuario", () -> {
            addUserCredentialPage.verifyMsgPasswordError(expectMessages);
            then.shouldContain(web.getCurrentUrl(), endpointUserCredential);
            Do.screenshot(testInfo);
        });
    }

    @Test
    @Severity(NORMAL)
    @Issue("https://upexgalaxy38.atlassian.net/browse/GX3-3082")
    @DisplayName("3087 | TC12: Validar NO poder agregar credenciales a un usuario cuando el campo password no tiene al menos 1 número")
    public void TC12(TestInfo testInfo) throws InterruptedException, IOException {

        String passwdNoNumbers = data.getPasswordNoNumbers.get();
        String passwdErrorErrorNoNumber = dataMessage.getPasswdErrorNoNumber.get();
        String[] expectMessages = { passwdErrorErrorNoNumber };

        Allure.step("insertar valores sin ningún número y completar las credenciales del usuario", () -> {
            addUserCredentialPage.fillUserDataCredential("ESS", "Disabled",
                    "defaultValue",
                    passwdNoNumbers,
                    passwdNoNumbers);
        });
        Allure.step("hacer click en el boton save", () ->

        {
            addUserCredentialPage.clickSaveButton();
        });
        Allure.step("validar NO agregar credenciales al usuario", () -> {
            addUserCredentialPage.verifyMsgPasswordError(expectMessages);
            then.shouldContain(web.getCurrentUrl(), endpointUserCredential);
            Do.screenshot(testInfo);
        });
    }

    @Test
    @Severity(NORMAL)
    @Issue("https://upexgalaxy38.atlassian.net/browse/GX3-3082")
    @DisplayName("3087 | TC13: Validar NO poder agregar credenciales a un usuario cuando el campo password no tiene al menos 1 letra")
    public void TC13(TestInfo testInfo) throws InterruptedException, IOException {

        String passwdNoLetter = data.getPasswordNoLetter.get();
        String passwdErrorNoLower = dataMessage.getPasswdErrorNoLowerCase.get();
        String[] expectMessages = { passwdErrorNoLower };

        Allure.step("insertar valores sin ninguna letra y completar las credenciales del usuario", () -> {
            addUserCredentialPage.fillUserDataCredential("ESS", "Disabled",
                    "defaultValue",
                    passwdNoLetter,
                    passwdNoLetter);
        });
        Allure.step("hacer click en el boton save", () ->

        {
            addUserCredentialPage.clickSaveButton();
        });
        Allure.step("validar NO agregar credenciales al usuario", () -> {
            addUserCredentialPage.verifyMsgPasswordError(expectMessages);
            then.shouldContain(web.getCurrentUrl(), endpointUserCredential);
            Do.screenshot(testInfo);
        });
    }

    @Disabled("Defecto - TC14")
    @Test
    @Severity(NORMAL)
    @Issue("https://upexgalaxy38.atlassian.net/browse/GX3-3082")
    @DisplayName("3087 | TC14: Validar NO poder agregar credenciales a un usuario cuando el campo password no tiene al menos 1 carácter especial")
    public void TC14(TestInfo testInfo) throws InterruptedException, IOException {

        String passwdNoSpecialChar = data.getPasswordNoSpecialChar.get();
        String passwdErrorNoSpecialChar = dataMessage.getPasswdErrorNoSpecialChar.get();
        String[] expectMessages = { passwdErrorNoSpecialChar };

        Allure.step("insertar valores sin ningún carácter especial y completar las credenciales del usuario", () -> {
            addUserCredentialPage.fillUserDataCredential("ESS", "Disabled",
                    "defaultValue",
                    passwdNoSpecialChar,
                    passwdNoSpecialChar);
        });
        Allure.step("hacer click en el boton save", () ->

        {
            addUserCredentialPage.clickSaveButton();
        });
        Allure.step("validar NO agregar credenciales al usuario", () -> {
            addUserCredentialPage.verifyMsgPasswordError(expectMessages);
            then.shouldContain(web.getCurrentUrl(), endpointUserCredential);
            Do.screenshot(testInfo);
        });
    }

    @Test
    @Severity(NORMAL)
    @Issue("https://upexgalaxy38.atlassian.net/browse/GX3-3082")
    @DisplayName("3087 | TC15: Validar NO poder agregar credenciales a un usuario cuando el campo Confirm Password no coincide con el campo Password")
    public void TC15(TestInfo testInfo) throws InterruptedException, IOException {

        String passwd = data.getPasswordSevenChar.get();
        String passwdErrorErrorNoMatch = dataMessage.getPasswdErrorNoMatch.get();
        String[] expectMessages = { passwdErrorErrorNoMatch };

        Allure.step(
                "insertar valores diferentes en Password y confirm Password y completar las credenciales del usuario",
                () -> {
                    addUserCredentialPage.fillUserDataCredential("ESS", "Enabled",
                            "defaultValue",
                            passwd,
                            "defaultValue");
                });
        Allure.step("hacer click en el boton save", () ->

        {
            addUserCredentialPage.clickSaveButton();
        });
        Allure.step("validar NO agregar credenciales al usuario", () -> {
            addUserCredentialPage.verifyMsgPasswordError(expectMessages);
            then.shouldContain(web.getCurrentUrl(), endpointUserCredential);
            Do.screenshot(testInfo);
        });
    }

    @Test
    @Severity(NORMAL)
    @Issue("https://upexgalaxy38.atlassian.net/browse/GX3-3082")
    @DisplayName("3087 | TC16: Validar NO poder agregar credenciales a un usuario existente")
    public void TC16(TestInfo testInfo) throws InterruptedException, IOException {

        String usernameExist = data.getUsernameExist.get();

        Allure.step(
                "insertar un usuario existente y completar las credenciales del usuario", () -> {
                    addUserCredentialPage.fillUserDataCredential("Admin", "Disabled",
                            usernameExist,
                            "defaultValue",
                            "defaultValue");
                });
        Allure.step("hacer click en el boton save", () ->

        {
            addUserCredentialPage.clickSaveButton();
        });
        Allure.step("validar NO agregar credenciales al usuario", () -> {
            addUserCredentialPage.verifyMessageErrorVisibiliTy();
            then.shouldContain(web.getCurrentUrl(), endpointUserCredential);
            Do.screenshot(testInfo);
        });
    }

}
