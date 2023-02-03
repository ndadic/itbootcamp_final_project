package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        loginPage.openLoginPage();
    }

    @Test
    public void loginPage() {
        Assert.assertTrue(loginPage.containsStringUrl("/login"));
    }

    @Test
    public void inputFields() {
        Assert.assertEquals(loginPage.getEmail().getAttribute("type"), "email");
        Assert.assertEquals(loginPage.getPassword().getAttribute("type"), "password");
    }

    @Test
    public void userDoesNotExist() {
        loginPage.login(faker.internet().emailAddress(), faker.internet().password());
        Assert.assertEquals(loginPage.alertMessage(), "User does not exists");
        Assert.assertTrue(loginPage.containsStringUrl("/login"));
    }

    @Test
    public void wrongPassword() {
        loginPage.login("admin@admin.com", faker.internet().password());
        Assert.assertEquals(loginPage.wrongPasswordMessage(), "Wrong password");
        Assert.assertTrue(loginPage.containsStringUrl("/login"));
    }

    @Test
    public void loginTest() {
        loginPage.login("admin@admin.com", "12345");
        Assert.assertTrue(loginPage.containsStringUrl("/home"));

    }

    @Test
    public void logoutTest() {
        loginPage.login("admin@admin.com", "12345");
        Assert.assertTrue(loginPage.isLogoutVisible());
        loginPage.logout();
        Assert.assertTrue(loginPage.containsStringUrl("/login"));
        driver.get(baseUrl + "/home");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));


    }
}
