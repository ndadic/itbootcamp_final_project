package Tests;

import Pages.MyProfilePage;
import Pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {

    private SignUpPage signupPage;
    private MyProfilePage myProfilePage;
    private final String CITY = "Chicago";
    private String phoneNumber;
    private String country;
    private String twitterUrl;
    private String gitHubUrl;

    @Override
    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        signupPage = new SignUpPage(driver, webDriverWait);
        myProfilePage = new MyProfilePage(driver, webDriverWait);
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        signupPage.openSignUpPage();
        signupPage.signUp(faker.name().firstName(), faker.internet().emailAddress(), faker.internet().password());
        phoneNumber = faker.phoneNumber().cellPhone();
        country = faker.country().name();
        twitterUrl = "https://twitter.com/" + faker.name().username().toLowerCase();
        gitHubUrl = "https://guthub.com/" + faker.name().username().toLowerCase();
    }


    @Test
    public void editProfile() {

        myProfilePage.afterSignUp();
        homePage.clickOnMyProfile();
        myProfilePage.editProfile(phoneNumber, CITY, country, twitterUrl, gitHubUrl);

        Assert.assertTrue(myProfilePage.saveMessage().contains("Profile saved successfuly"));

        Assert.assertEquals(myProfilePage.getPhoneField().getAttribute("value"), phoneNumber);
        Assert.assertEquals(myProfilePage.getCityField().getAttribute("value"), CITY);
        Assert.assertEquals(myProfilePage.getCountryField().getAttribute("value"), country);
        Assert.assertEquals(myProfilePage.getTwitterField().getAttribute("value"), twitterUrl);
        Assert.assertEquals(myProfilePage.getGitHubField().getAttribute("value"), gitHubUrl);

    }
}
