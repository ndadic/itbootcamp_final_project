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
        Assert.assertTrue(loginPage.containsStringUrl(loginUrl));
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
        Assert.assertTrue(loginPage.containsStringUrl(loginUrl));
    }

    @Test
    public void wrongPassword() {

        loginPage.login(email, faker.internet().password());
        Assert.assertEquals(loginPage.wrongPasswordMessage(), "Wrong password");
        Assert.assertTrue(loginPage.containsStringUrl(loginUrl));
    }

    @Test
    public void loginTest() {

        loginPage.login(email, truePass);
        Assert.assertTrue(loginPage.containsStringUrl(homeUrl));

    }

    @Test
    public void logoutTest() {

        loginPage.login(email, truePass);
        Assert.assertTrue(homePage.isLogoutVisible());
        homePage.logout();
        Assert.assertTrue(loginPage.containsStringUrl(loginUrl));
        driver.get(baseUrl + homeUrl);
        Assert.assertTrue(driver.getCurrentUrl().contains(loginUrl));


    }
}
