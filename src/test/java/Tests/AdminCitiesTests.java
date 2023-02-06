package Tests;

import Pages.AdminCitiesPage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BaseTest {

    protected LoginPage loginPage;
    protected AdminCitiesPage adminCitiesPage;
    final String SAVED_MESSAGE = "Saved successfully";
    protected String CITY;


    @Override
    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        loginPage = new LoginPage(driver, webDriverWait);
        adminCitiesPage = new AdminCitiesPage(driver, webDriverWait);
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        loginPage.openLoginPage();
        loginPage.login(EMAIL, TRUE_PASS);
        adminCitiesPage.openCitiesPage();
        CITY = faker.address().city();
    }

    @Test
    public void adminCitiesPage() {

        Assert.assertTrue(adminCitiesPage.containsStringUrl(ADMIN_CITIES_URL));
        Assert.assertTrue(homePage.isLogoutVisible());

    }

    @Test
    public void addNewCity() {

        adminCitiesPage.addNewCity(CITY);
        Assert.assertTrue(adminCitiesPage.messageAlert().contains(SAVED_MESSAGE));
    }

    @Test
    public void editCity() {

        adminCitiesPage.addNewCity(CITY);
        adminCitiesPage.editExistingCity(CITY);
        Assert.assertTrue(adminCitiesPage.messageAlert().contains(SAVED_MESSAGE));

    }

    @Test
    public void searchEditedCity() {

        adminCitiesPage.addNewCity(CITY);
        adminCitiesPage.editExistingCity(CITY);
        adminCitiesPage.searchCity(CITY);
        Assert.assertEquals(adminCitiesPage.cityName(), CITY + " - edited");

    }

    @Test
    public void deleteCity() {

        adminCitiesPage.addNewCity(CITY);
        adminCitiesPage.editExistingCity(CITY);
        Assert.assertTrue(adminCitiesPage.cityName().contains(CITY));
        adminCitiesPage.deleteCity(CITY);
        Assert.assertTrue(adminCitiesPage.messageAlert().contains("Deleted successfully"));
    }

    @AfterMethod
    public void afterMethod() {
        if (homePage.getLogout().isDisplayed()) {
            homePage.logout();
        }
    }
}
