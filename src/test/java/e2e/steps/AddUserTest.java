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
    @BeforeEach
    @DisplayName("Precondition: User most be logged in")
    public void login() throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage(web, get, Do);
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

    static class User {
        String username;
        String pw;

        public User(String username, String pw) {
            this.username = username;
            this.pw = pw;
        }
    }

    @Test
    @DisplayName("GX3-185 | TC1: Add a user successfully")
    public void addUserSuccessfully() throws InterruptedException, IOException {
        Thread.sleep(1000);
        // todo: Given existe Data disponible en la lista de Empleados...
        List<WebElement> cards = get.FilterByElement("[role=\"row\"]", ".oxd-table-cell");
        int availableEmployees = cards.size();
        int randomSelection = new Random().nextInt(availableEmployees);
        WebElement givenEmployee = cards.get(randomSelection);
        then.shouldBeVisible(givenEmployee);

        // Esto corre únicamente cuando se ejecuta por headless:
        String givenUsernameValue;
        String givenUserRoleValue;
        String givenEmployeeNameValue;
        String givenUserStatusValue;
        int expectedSize;
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

        UserManagementPage ump = new UserManagementPage(web, get, Do);
        User newUser = new User("Black4235", "A3b!7xZ*9qP");

        String response = ump.createUserWithData(newUser.username, newUser.pw, newUser.pw, givenEmployeeNameValue,
                givenUserStatusValue, true, true, true, true, true);
        then.shouldBeEqual(response, "Successfully Saved");
        System.out.println("Response: " + response);
        Thread.sleep(4000);
        then.shouldContain(web.getCurrentUrl(), "admin/viewSystemUsers");

        ump.userSearch(newUser.username);
        Thread.sleep(4000);

        List<WebElement> card = get.FilterByElement("[role=\"row\"]", ".oxd-table-cell");
        WebElement employeeSearch = card.get(0);
        List<WebElement> data2 = get.WithinElement(employeeSearch, rowData);
        then.shouldBeEqual(data2.get(1).getText(), newUser.username);
        System.out.println("Usuario encontrado: " + data2.get(1).getText() + " Usuario insertado: " + newUser.username);

    }

    @Test
    @DisplayName("GX3-185 | TC2: Try to save a invalid user with empty user role")
    public void insertEmptyUserRole() throws InterruptedException, IOException {
        //get user by Employee List
        List<WebElement> cards = get.FilterByElement("[role=\"row\"]", ".oxd-table-cell");
        int availableEmployees = cards.size();
        int randomSelection = new Random().nextInt(availableEmployees);
        WebElement givenEmployee = cards.get(randomSelection);
        then.shouldBeVisible(givenEmployee);

        String givenUsernameValue;
        String givenUserRoleValue;
        String givenEmployeeNameValue;
        String givenUserStatusValue;
        int expectedSize;
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

        //change window
        WebElement addButton = get.ByEqualText(" Add ");
        Do.click(addButton);
        Thread.sleep(1000);
        then.shouldContain(web.getCurrentUrl(), "admin/saveSystemUser");

        //create necessary objects
        UserManagementPage ump = new UserManagementPage(web,get,Do);
        User newUser = new User("BlackHol15dc423", "A3b!7xZ*9qP");

        String response = ump.createUserWithData(newUser.username, newUser.pw, newUser.pw, givenEmployeeNameValue, givenUserStatusValue,
                false, true, true, true, true);
        then.shouldBeEqual(response, "Required");
        then.shouldContain(web.getCurrentUrl(), "admin/saveSystemUser");
    }
    @Test
    @DisplayName("GX3-185 | TC3: Try to save a invalid user with empty employee name")
    public void insertEmptyEmployeeName() throws InterruptedException, IOException {
        //get user by Employee List
        List<WebElement> cards = get.FilterByElement("[role=\"row\"]", ".oxd-table-cell");
        int availableEmployees = cards.size();
        int randomSelection = new Random().nextInt(availableEmployees);
        WebElement givenEmployee = cards.get(randomSelection);
        then.shouldBeVisible(givenEmployee);

        String givenUsernameValue;
        String givenUserRoleValue;
        String givenEmployeeNameValue;
        String givenUserStatusValue;
        int expectedSize;
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
        //change window
        WebElement addButton = get.ByEqualText(" Add ");
        Do.click(addButton);
        Thread.sleep(1000);
        then.shouldContain(web.getCurrentUrl(), "admin/saveSystemUser");

        //create necessary objects
        UserManagementPage ump = new UserManagementPage(web,get,Do);
        User newUser = new User("BlackHol15dc423", "A3b!7xZ*9qP");

        String response = ump.createUserWithData(newUser.username, newUser.pw, newUser.pw, "empty", givenUserStatusValue,
                true, true, true, true, true);
        then.shouldBeEqual(response, "Required");
        System.out.println("Response: " + response);

    }

    @Test
    @DisplayName("GX3-185 | TC4: Try to save a invalid user with empty status")
    public void insertEmptyStatus() throws InterruptedException, IOException {
        //get user by Employee List
        List<WebElement> cards = get.FilterByElement("[role=\"row\"]", ".oxd-table-cell");
        int availableEmployees = cards.size();
        int randomSelection = new Random().nextInt(availableEmployees);
        WebElement givenEmployee = cards.get(randomSelection);
        then.shouldBeVisible(givenEmployee);

        String givenUsernameValue;
        String givenUserRoleValue;
        String givenEmployeeNameValue;
        String givenUserStatusValue;
        int expectedSize;
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
        //change window
        WebElement addButton = get.ByEqualText(" Add ");
        Do.click(addButton);
        Thread.sleep(1000);
        then.shouldContain(web.getCurrentUrl(), "admin/saveSystemUser");

        //create necessary objects
        UserManagementPage ump = new UserManagementPage(web,get,Do);
        User newUser = new User("BlackHol15dc423", "A3b!7xZ*9qP");

        String response = ump.createUserWithData(newUser.username, newUser.pw, newUser.pw, givenEmployeeNameValue, givenUserStatusValue,
                true, false, true, true, true);
        then.shouldBeEqual(response, "Required");
    }

    @Test
    @DisplayName("GX3-185 | TC5: Try to save a invalid user with empty username")
    public void insertEmptyUsername() throws InterruptedException, IOException {
        //get user by Employee List
        List<WebElement> cards = get.FilterByElement("[role=\"row\"]", ".oxd-table-cell");
        int availableEmployees = cards.size();
        int randomSelection = new Random().nextInt(availableEmployees);
        WebElement givenEmployee = cards.get(randomSelection);
        then.shouldBeVisible(givenEmployee);

        String givenUsernameValue;
        String givenUserRoleValue;
        String givenEmployeeNameValue;
        String givenUserStatusValue;
        int expectedSize;
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
        //change window
        WebElement addButton = get.ByEqualText(" Add ");
        Do.click(addButton);
        Thread.sleep(1000);
        then.shouldContain(web.getCurrentUrl(), "admin/saveSystemUser");

        //create necessary objects
        UserManagementPage ump = new UserManagementPage(web, get, Do);
        User newUser = new User("BlackHo23", "A3b!7xZ*9qP");

        String response = ump.createUserWithData(newUser.username, newUser.pw, newUser.pw, givenEmployeeNameValue, givenUserStatusValue,
                true, true, false, true, true);
        then.shouldBeEqual(response, "Required");
    }
    @Test
    @DisplayName("GX3-185 | TC6: Try to save a invalid user with 4 characters")
    public void insertInvalidUsername() throws InterruptedException, IOException {
        //get user by Employee List
        List<WebElement> cards = get.FilterByElement("[role=\"row\"]", ".oxd-table-cell");
        int availableEmployees = cards.size();
        int randomSelection = new Random().nextInt(availableEmployees);
        WebElement givenEmployee = cards.get(randomSelection);
        then.shouldBeVisible(givenEmployee);

        String givenUsernameValue;
        String givenUserRoleValue;
        String givenEmployeeNameValue;
        String givenUserStatusValue;
        int expectedSize;
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
        //change window
        WebElement addButton = get.ByEqualText(" Add ");
        Do.click(addButton);
        Thread.sleep(1000);
        then.shouldContain(web.getCurrentUrl(), "admin/saveSystemUser");

        //create necessary objects
        UserManagementPage ump = new UserManagementPage(web, get, Do);
        User newUser = new User("Blan", "A3b!7xZ*9qP");

        String response = ump.createUserWithData(newUser.username, newUser.pw, newUser.pw, givenEmployeeNameValue, givenUserStatusValue,
                true, true, true, true, true);
        then.shouldBeEqual(response, "Should be at least 5 characters");
    }
    @Test
    @DisplayName("GX3-185 | TC7: Try to save a invalid user with 41 characters")
    public void insertInvalidUsername41Char() throws InterruptedException, IOException {
        //get user by Employee List
        List<WebElement> cards = get.FilterByElement("[role=\"row\"]", ".oxd-table-cell");
        int availableEmployees = cards.size();
        int randomSelection = new Random().nextInt(availableEmployees);
        WebElement givenEmployee = cards.get(randomSelection);
        then.shouldBeVisible(givenEmployee);

        String givenUsernameValue;
        String givenUserRoleValue;
        String givenEmployeeNameValue;
        String givenUserStatusValue;
        int expectedSize;
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
        //change window
        WebElement addButton = get.ByEqualText(" Add ");
        Do.click(addButton);
        Thread.sleep(1000);
        then.shouldContain(web.getCurrentUrl(), "admin/saveSystemUser");

        //create necessary objects
        UserManagementPage ump = new UserManagementPage(web, get, Do);
        User newUser = new User("JuanEusebioMoralesNeumannEusebioMoralesNe", "A3b!7xZ*9qP");

        String response = ump.createUserWithData(newUser.username, newUser.pw, newUser.pw, givenEmployeeNameValue, givenUserStatusValue,
                true, true, true, true, true);
        then.shouldBeEqual(response, "Should not exceed 40 characters");
    }
    @Test
    @DisplayName("GX3-185 | TC8: Try to save a invalid user with empty password")
    public void insertEmptyPassword() throws InterruptedException, IOException {
        //get user by Employee List
        List<WebElement> cards = get.FilterByElement("[role=\"row\"]", ".oxd-table-cell");
        int availableEmployees = cards.size();
        int randomSelection = new Random().nextInt(availableEmployees);
        WebElement givenEmployee = cards.get(randomSelection);
        then.shouldBeVisible(givenEmployee);

        String givenUsernameValue;
        String givenUserRoleValue;
        String givenEmployeeNameValue;
        String givenUserStatusValue;
        int expectedSize;
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
        //change window
        WebElement addButton = get.ByEqualText(" Add ");
        Do.click(addButton);
        Thread.sleep(1000);
        then.shouldContain(web.getCurrentUrl(), "admin/saveSystemUser");

        //create necessary objects
        UserManagementPage ump = new UserManagementPage(web, get, Do);
        User newUser = new User("BlackHol15dc423", "A3b!7xZ*9qP");

        String response = ump.createUserWithData(newUser.username, newUser.pw, newUser.pw, givenEmployeeNameValue, givenUserStatusValue,
                true, true, true, false, true);
        then.shouldBeEqual(response, "Required");
    }
    @Test
    @DisplayName("GX3-185 | TC9: Try to save a invalid user with empty repassword")
    public void insertEmptyRePassword() throws InterruptedException, IOException {
        //get user by Employee List
        List<WebElement> cards = get.FilterByElement("[role=\"row\"]", ".oxd-table-cell");
        int availableEmployees = cards.size();
        int randomSelection = new Random().nextInt(availableEmployees);
        WebElement givenEmployee = cards.get(randomSelection);
        then.shouldBeVisible(givenEmployee);

        String givenUsernameValue;
        String givenUserRoleValue;
        String givenEmployeeNameValue;
        String givenUserStatusValue;
        int expectedSize;
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
        //change window
        WebElement addButton = get.ByEqualText(" Add ");
        Do.click(addButton);
        Thread.sleep(1000);
        then.shouldContain(web.getCurrentUrl(), "admin/saveSystemUser");

        //create necessary objects
        UserManagementPage ump = new UserManagementPage(web, get, Do);
        User newUser = new User("BlackHol423", "A3b!7xZ*9qP");

        String response = ump.createUserWithData(newUser.username, newUser.pw, newUser.pw, givenEmployeeNameValue, givenUserStatusValue,
                true, true, true, true, false);
        then.shouldBeEqual(response, "Required");
    }
    @Test
    @DisplayName("GX3-185 | TC10: Try to save a invalid user with different password")
    public void insertDifferentPassword() throws InterruptedException, IOException {
        //get user by Employee List
        List<WebElement> cards = get.FilterByElement("[role=\"row\"]", ".oxd-table-cell");
        int availableEmployees = cards.size();
        int randomSelection = new Random().nextInt(availableEmployees);
        WebElement givenEmployee = cards.get(randomSelection);
        then.shouldBeVisible(givenEmployee);

        String givenUsernameValue;
        String givenUserRoleValue;
        String givenEmployeeNameValue;
        String givenUserStatusValue;
        int expectedSize;
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
        //change window
        WebElement addButton = get.ByEqualText(" Add ");
        Do.click(addButton);
        Thread.sleep(1000);
        then.shouldContain(web.getCurrentUrl(), "admin/saveSystemUser");

        //create necessary objects
        UserManagementPage ump = new UserManagementPage(web, get, Do);
        User newUser = new User("BlackHol423", "A3b!7xZ*9qP");

        String response = ump.createUserWithData(newUser.username, newUser.pw, "A3b!7xZ*9qPs", givenEmployeeNameValue, givenUserStatusValue,
                true, true, true, true, true);
        then.shouldBeEqual(response, "Passwords do not match");
    }
    @Test
    @DisplayName("GX3-185 | TC11: Try to save a invalid user with a short password")
    public void insertShortPassword() throws InterruptedException, IOException {
        //get user by Employee List
        List<WebElement> cards = get.FilterByElement("[role=\"row\"]", ".oxd-table-cell");
        int availableEmployees = cards.size();
        int randomSelection = new Random().nextInt(availableEmployees);
        WebElement givenEmployee = cards.get(randomSelection);
        then.shouldBeVisible(givenEmployee);

        String givenUsernameValue;
        String givenUserRoleValue;
        String givenEmployeeNameValue;
        String givenUserStatusValue;
        int expectedSize;
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
        //change window
        WebElement addButton = get.ByEqualText(" Add ");
        Do.click(addButton);
        Thread.sleep(1000);
        then.shouldContain(web.getCurrentUrl(), "admin/saveSystemUser");

        //create necessary objects
        UserManagementPage ump = new UserManagementPage(web, get, Do);
        User newUser = new User("BlackHol423", "a");

        String response = ump.createUserWithData(newUser.username, newUser.pw, "a", givenEmployeeNameValue, givenUserStatusValue,
                true, true, true, true, true);
        then.shouldBeEqual(response, "Should have at least 7 characters");
    }
    @Test
    @DisplayName("GX3-185 | TC12: Try to save a invalid user with a long password")
    public void insertLongPassword() throws InterruptedException, IOException {
        //get user by Employee List
        List<WebElement> cards = get.FilterByElement("[role=\"row\"]", ".oxd-table-cell");
        int availableEmployees = cards.size();
        int randomSelection = new Random().nextInt(availableEmployees);
        WebElement givenEmployee = cards.get(randomSelection);
        then.shouldBeVisible(givenEmployee);

        String givenUsernameValue;
        String givenUserRoleValue;
        String givenEmployeeNameValue;
        String givenUserStatusValue;
        int expectedSize;
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
        //change window
        WebElement addButton = get.ByEqualText(" Add ");
        Do.click(addButton);
        Thread.sleep(1000);
        then.shouldContain(web.getCurrentUrl(), "admin/saveSystemUser");

        //create necessary objects
        UserManagementPage ump = new UserManagementPage(web, get, Do);
        User newUser = new User("BlackHol423", "JuanEusebioMoralesNeumannEusebioMoralesNe213213123213122323232322");

        String response = ump.createUserWithData(newUser.username, newUser.pw, "JuanEusebioMoralesNeumannEusebioMoralesNe213213123213122323232322", givenEmployeeNameValue, givenUserStatusValue,
                true, true, true, true, true);
        then.shouldBeEqual(response, "Should not exceed 64 characters");
    }
    @Test
    @DisplayName("GX3-185 | TC13: Try to save a invalid user with password only string")
    public void insertOnlyStringPassword() throws InterruptedException, IOException {
        //get user by Employee List
        List<WebElement> cards = get.FilterByElement("[role=\"row\"]", ".oxd-table-cell");
        int availableEmployees = cards.size();
        int randomSelection = new Random().nextInt(availableEmployees);
        WebElement givenEmployee = cards.get(randomSelection);
        then.shouldBeVisible(givenEmployee);

        String givenUsernameValue;
        String givenUserRoleValue;
        String givenEmployeeNameValue;
        String givenUserStatusValue;
        int expectedSize;
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
        //change window
        WebElement addButton = get.ByEqualText(" Add ");
        Do.click(addButton);
        Thread.sleep(1000);
        then.shouldContain(web.getCurrentUrl(), "admin/saveSystemUser");

        //create necessary objects
        UserManagementPage ump = new UserManagementPage(web, get, Do);
        User newUser = new User("BlackHol423", "JuanEusebioMoralesNeumannEusbioMoralesJuanEusebioMoralesNeumannE");

        String response = ump.createUserWithData(newUser.username, newUser.pw, "JuanEuebioMoralesNeumannEusebioMoralesJuanEusebioMoralesNeumannE", givenEmployeeNameValue, givenUserStatusValue,
                true, true, true, true, true);
        then.shouldBeEqual(response, "Your password must contain minimum 1 number");
    }
    @Test
    @DisplayName("GX3-185 | TC14: Try to save a invalid user with password only uppercase")
    public void insertOnlyUpperCasePassword() throws InterruptedException, IOException {
        //get user by Employee List
        List<WebElement> cards = get.FilterByElement("[role=\"row\"]", ".oxd-table-cell");
        int availableEmployees = cards.size();
        int randomSelection = new Random().nextInt(availableEmployees);
        WebElement givenEmployee = cards.get(randomSelection);
        then.shouldBeVisible(givenEmployee);

        String givenUsernameValue;
        String givenUserRoleValue;
        String givenEmployeeNameValue;
        String givenUserStatusValue;
        int expectedSize;
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
        //change window
        WebElement addButton = get.ByEqualText(" Add ");
        Do.click(addButton);
        Thread.sleep(1000);
        then.shouldContain(web.getCurrentUrl(), "admin/saveSystemUser");

        //create necessary objects
        UserManagementPage ump = new UserManagementPage(web, get, Do);
        User newUser = new User("BlackHol423", "TTTTTTT");

        String response = ump.createUserWithData(newUser.username, newUser.pw, "TTTTTTT", givenEmployeeNameValue, givenUserStatusValue,
                true, true, true, true, true);
        then.shouldBeEqual(response, "Your password must contain minimum 1 lower-case letter");
    }
}
