package Tests;

import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    protected LoginPage loginPage;

    @Override
    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        loginPage = new LoginPage(driver, webDriverWait);

    }

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        loginPage.openLoginPage();
    }

    @Test
    public void loginPage() {
        Assert.assertTrue(loginPage.containsStringUrl(LOGIN_URL));
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
        Assert.assertTrue(loginPage.containsStringUrl(LOGIN_URL));
    }

    @Test
    public void wrongPassword() {

        loginPage.login(EMAIL, faker.internet().password());
        Assert.assertEquals(loginPage.wrongPasswordMessage(), "Wrong password");
        Assert.assertTrue(loginPage.containsStringUrl(LOGIN_URL));
    }

    @Test
    public void loginTest() {

        loginPage.login(EMAIL, TRUE_PASS);
        Assert.assertTrue(loginPage.containsStringUrl(HOME_URL));

    }

    @Test
    public void logoutTest() {

        loginPage.login(EMAIL, TRUE_PASS);
        Assert.assertTrue(homePage.isLogoutVisible());
        homePage.logout();
        Assert.assertTrue(loginPage.containsStringUrl(LOGIN_URL));
        driver.get(BASEURL + HOME_URL);
        Assert.assertTrue(driver.getCurrentUrl().contains(LOGIN_URL));


    }
}
