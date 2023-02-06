package Tests;

import Pages.MyProfilePage;
import Pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTests extends BaseTest {
    protected SignUpPage signupPage;
    protected MyProfilePage myProfilePage;
    final String SIGN_UP_URL = "/signup";

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
    }

    @Test
    public void checkURLcontains() {
        Assert.assertTrue(signupPage.containsStringUrl(SIGN_UP_URL));
    }

    @Test
    public void checkInputFields() {

          Assert.assertEquals(signupPage.getEmail().getAttribute("type"), "email");
        Assert.assertEquals(signupPage.getPassword().getAttribute("type"), "password");
        Assert.assertEquals(signupPage.getConfirmPassword().getAttribute("type"), "password");
    }


    @Test
    public void userAlreadyExists() {

        signupPage.signUp("Test Test", EMAIL, "123654");
        Assert.assertEquals(signupPage.alertMessage(), "E-mail already exists");
        Assert.assertTrue(signupPage.containsStringUrl(SIGN_UP_URL));
    }

    @Test
    public void newUser() {

        signupPage.signUp("Natalija Dadic", "nd963@gmail.com", "693369");
        signupPage.waitAssertationMessage();
        Assert.assertEquals(signupPage.verifyAccountMessage(), "IMPORTANT: Verify your account");
        myProfilePage.afterSignUp();
        homePage.logout();
    }


}

