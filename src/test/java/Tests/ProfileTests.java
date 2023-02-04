package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        signupPage.openSignUpPage();
        signupPage.signUp(faker.name().firstName(), faker.internet().emailAddress(), faker.internet().password());
        phoneNumber = faker.phoneNumber().cellPhone();
        country = faker.country().name();
        twitterUrl = "https://" + faker.internet().url();
        gitHubUrl = "https://" + faker.internet().url();
    }

    @Test
    public void editProfile() {
        homePage.clickOnMyProfile();
        myProfilePage.editProfile(phoneNumber, "Chicago", country, twitterUrl, gitHubUrl);

        Assert.assertTrue(myProfilePage.saveMessage().contains("Profile saved successfuly"));

        Assert.assertEquals(myProfilePage.getPhoneField().getAttribute("value"), phoneNumber);
        Assert.assertEquals(myProfilePage.getCityField().getAttribute("value"), "Chicago");
        Assert.assertEquals(myProfilePage.getCountryField().getAttribute("value"), country);
        Assert.assertEquals(myProfilePage.getTwitterField().getAttribute("value"), twitterUrl);
        Assert.assertEquals(myProfilePage.getGitHubField().getAttribute("value"), gitHubUrl);
    }
}
