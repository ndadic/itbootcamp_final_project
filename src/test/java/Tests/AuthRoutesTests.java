package Tests;

import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest {

    protected LoginPage loginPage;

    @Override
    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        loginPage = new LoginPage(driver, webDriverWait);
    }

    @Test
    public void homePageLoggedOutUser() {

        driver.get(BASEURL + HOME_URL);
        Assert.assertTrue(loginPage.containsStringUrl(LOGIN_URL));
    }

    @Test
    public void profilePageLoggedOutUser() {

        driver.get(BASEURL + "/profile");
        Assert.assertTrue(loginPage.containsStringUrl(LOGIN_URL));
    }

    @Test
    public void adminCitiesLoggedOutUser() {

        driver.get(BASEURL + ADMIN_CITIES_URL);
        Assert.assertTrue(loginPage.containsStringUrl(LOGIN_URL));
    }

    @Test
    public void adminUserLoggedOutUser() {

        driver.get(BASEURL + "/admin/users");
        Assert.assertTrue(loginPage.containsStringUrl(LOGIN_URL));
    }
}
