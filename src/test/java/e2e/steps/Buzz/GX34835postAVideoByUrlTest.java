
package e2e.steps.Buzz;

import java.io.IOException;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import e2e.fixtures.TestBase;
import e2e.page.LoginPage;

public class GX34835postAVideoByUrlTest extends TestBase {

    @BeforeEach
    @DisplayName("41778 | OrangeHRM | Buzz | Post a Video by URL")
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
    @DisplayName("TC1: Validar publicar un video mediante URL")
    public void TestCase1() throws InterruptedException {

        WebElement buttonBuzz = get.Selector("[href='/web/index.php/buzz/viewBuzz']");
        buttonBuzz.click();

        WebElement titlePost = get.Xpath("//button[text()=' Post ']");
        String value = titlePost.getText();
        System.out.println(value);
        then.shouldContain(value, "Post");

        Thread.sleep(2000);
        WebElement buttonPost = get.Selector("span[class*=oxd-glass-button-icon--videoglass]");
        buttonPost.click();
        Thread.sleep(2000);
        WebElement popup = get.ByRole("document");
        then.shouldBeVisible(popup);

        // con xpath selector
        WebElement titleShareVideo = get.Xpath("//p[text()='Share Video']");
        String titleshare = titleShareVideo.getText();
        System.out.println(titleshare);
        then.shouldContain(titleshare, "Share Video");
        Thread.sleep(2000);

        WebElement inputShare = get.Selector("div[class=orangehrm-buzz-post-modal-header] textarea");
        inputShare.sendKeys("queria compartir esto");
        WebElement inputUrl = get.Selector("textarea[class$=resize-vertical]");
        inputUrl.sendKeys("https://www.youtube.com/watch?v=AuChXkp6jR8&ab_channel=Saitest");
        Thread.sleep(3000);
        WebElement buttonShare = get.Selector("div[class$=modal-actions] button");
        buttonShare.click();

        WebElement frameSuccess = get.Selector(".oxd-toast--success .oxd-text--toast-message");
        String success = frameSuccess.getText();
        System.out.println(success);
        then.shouldContain(success, "Successfully Saved");

    }

    @Test
    @DisplayName("TC2: Validar NO publicar un video con una URL no válida")
    public void TestCase2() throws InterruptedException {
        WebElement buttonBuzz = get.Selector("[href='/web/index.php/buzz/viewBuzz']");
        buttonBuzz.click();

        WebElement titleBuzz = get.Xpath("//button[text()=' Post ']");
        String value = titleBuzz.getText();
        System.out.println(value);
        then.shouldBeEqual(value, "Post");

        Thread.sleep(2000);
        WebElement buttonPost = get.Selector("span[class*=oxd-glass-button-icon--videoglass]");
        buttonPost.click();
        Thread.sleep(2000);
        WebElement popup = get.ByRole("document");
        then.shouldBeVisible(popup);

        // con xpath selector
        WebElement titleShareVideo1 = get.Xpath("//p[text()='Share Video']");
        String titleshare = titleShareVideo1.getText();
        System.out.println(titleshare);
        then.shouldContain(titleshare, "Share Video");
        Thread.sleep(2000);

        WebElement inputShare = get.Selector("div[class=orangehrm-buzz-post-modal-header] textarea");
        inputShare.sendKeys("queria compartir esto");
        WebElement inputUrl = get.Selector("textarea[class$=resize-vertical]");
        inputUrl.sendKeys("https://opensource-demo.orangehrmlive.com/web/index.php/buzz/viewBuzz");
        Thread.sleep(3000);
        WebElement buttonShare = get.Selector("div[class$=modal-actions] button");
        buttonShare.click();

        WebElement messageInvalidUrl = get.Selector(".oxd-input-field-error-message");
        String invalidURL = messageInvalidUrl.getText();
        System.out.println(invalidURL);
        then.shouldContain(invalidURL, "This URL is not a valid URL of a video or it is not supported by the system");

    }

    @Test
    @DisplayName("TC3: Validar NO publicar un video sin ingresar una URL")
    public void TestCase3() throws InterruptedException {
        WebElement buttonBuzz = get.Selector("[href='/web/index.php/buzz/viewBuzz']");
        buttonBuzz.click();

        WebElement titleBuzz = get.Xpath("//button[text()=' Post ']");
        String value = titleBuzz.getText();
        System.out.println(value);
        then.shouldContain(value, "Post");

        Thread.sleep(2000);
        WebElement buttonPost = get.Selector("span[class*=oxd-glass-button-icon--videoglass]");
        buttonPost.click();
        Thread.sleep(2000);
        WebElement popup = get.ByRole("document");
        then.shouldBeVisible(popup);

        // con xpath selector
        WebElement titlePost2 = get.Xpath("//p[text()='Share Video']");
        String titleshare = titlePost2.getText();
        System.out.println(titleshare);
        then.shouldBeEqual(titleshare, "Share Video");
        Thread.sleep(2000);

        WebElement inputUrl = get.Selector("textarea[class$=resize-vertical]");
        String stringInput = inputUrl.getText();
        System.out.println(stringInput);
        WebElement buttonShare = get.Selector("div[class$=modal-actions] button");
        buttonShare.click();

        WebElement messageRequired = get.Selector(".oxd-input-field-error-message");
        String required = messageRequired.getText();
        System.out.println(required);
        then.shouldContain(required, "Required");

    }

}
