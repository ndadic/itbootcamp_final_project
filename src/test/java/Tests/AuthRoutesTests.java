package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest {

    @Test
    public void homePageLoggedOutUser() {

        driver.get(baseUrl + homeUrl);
        Assert.assertTrue(loginPage.containsStringUrl(loginUrl));
    }

    @Test
    public void profilePageLoggedOutUser() {

        driver.get(baseUrl + "/profile");
        Assert.assertTrue(loginPage.containsStringUrl(loginUrl));
    }

    @Test
    public void adminCitiesLoggedOutUser() {

        driver.get(baseUrl + adminCitiesUrl);
        Assert.assertTrue(loginPage.containsStringUrl(loginUrl));
    }

    @Test
    public void adminUserLoggedOutUser() {

        driver.get(baseUrl + "/admin/users");
        Assert.assertTrue(loginPage.containsStringUrl(loginUrl));
    }
}
