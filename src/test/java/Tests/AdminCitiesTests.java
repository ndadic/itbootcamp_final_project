package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BaseTest {

    final String savedMessage = "Saved successfully";

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        loginPage.openLoginPage();
        loginPage.login(email, truePass);
        adminCitiesPage.openCitiesPage();
        city = faker.address().city();
    }

    @Test
    public void adminCitiesPage() {

        Assert.assertTrue(adminCitiesPage.containsStringUrl(adminCitiesUrl));
        Assert.assertTrue(homePage.isLogoutVisible());

    }

    @Test
    public void addNewCity() {

        adminCitiesPage.addNewCity(city);
        Assert.assertTrue(adminCitiesPage.messageAlert().contains(savedMessage));
    }

    @Test
    public void editCity() {

        adminCitiesPage.addNewCity(city);
        adminCitiesPage.editExistingCity(city);
        Assert.assertTrue(adminCitiesPage.messageAlert().contains(savedMessage));

    }

    @Test
    public void searchEditedCity() {

        adminCitiesPage.addNewCity(city);
        adminCitiesPage.editExistingCity(city);
        adminCitiesPage.searchCity(city);
        Assert.assertEquals(adminCitiesPage.cityName(), city + " - edited");

    }

    @Test
    public void deleteCity() {

        adminCitiesPage.addNewCity(city);
        adminCitiesPage.editExistingCity(city);
        Assert.assertTrue(adminCitiesPage.cityName().contains(city));
        adminCitiesPage.deleteCity(city);
        Assert.assertTrue(adminCitiesPage.messageAlert().contains("Deleted successfully"));
    }

    @AfterMethod
    public void afterMethod() {
        if (homePage.getLogout().isDisplayed()) {
            homePage.logout();
        }
    }
}
