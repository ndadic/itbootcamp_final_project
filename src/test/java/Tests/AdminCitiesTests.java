package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BaseTest {

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        loginPage.openLoginPage();
        loginPage.login("admin@admin.com", "12345");
        adminCitiesPage.openCitiesPage();
        city1 = faker.address().city();
    }

    @Test
    public void adminCitiesPage() {
        Assert.assertTrue(adminCitiesPage.containsStringUrl("/admin/cities"));
        Assert.assertTrue(homePage.isLogoutVisible());

    }


    String city = "Tokyo";

    @Test (priority = 1)
    public void addNewCity() {
        adminCitiesPage.addNewCity(city);
        Assert.assertTrue(adminCitiesPage.messageAlert().contains("Saved successfully"));
    }

    @Test (priority = 2)
    public void editCity() {
        adminCitiesPage.editExistingCity(city);
        Assert.assertTrue(adminCitiesPage.messageAlert().contains("Saved successfully"));

    }

    @Test (priority = 3)
    public void searchEditedCity() {
        adminCitiesPage.searchCity(city);
        Assert.assertEquals(adminCitiesPage.cityName(), city + " - edited");

    }

    @Test (priority = 4)
    public void deleteCity() {
        adminCitiesPage.searchCity("Oakland");
       // Assert.assertEquals(adminCitiesPage.cityName(), city);
        adminCitiesPage.deleteCity();
        Assert.assertTrue(adminCitiesPage.messageAlert().contains("Deleted successfully"));
    }
}
