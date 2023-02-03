package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTests extends BaseTest {

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        signupPage.openSignUpPage();
    }

    @Test
    public void checkURLcontains() {
        Assert.assertTrue(signupPage.containsStringUrl("/signup"));
    }

    @Test
    public void checkInputFields() {
        Assert.assertEquals(signupPage.getEmail().getAttribute("type"), "email");
        Assert.assertEquals(signupPage.getPassword().getAttribute("type"), "password");
        Assert.assertEquals(signupPage.getConfirmPassword().getAttribute("type"), "password");
    }


    @Test
    public void userAlreadyExists() {
        signupPage.signUp("Test Test", "admin@admin.com", 123654);
        Assert.assertEquals(signupPage.alertMessage(), "E-mail already exists");
        Assert.assertTrue(signupPage.containsStringUrl("/signup"));
    }

    @Test
    public void newUser() {
        signupPage.signUp("Natalija Dadic", "nd369@gmail.com", 693369);
        Assert.assertEquals(signupPage.verifyAccountMessage(), "IMPORTANT: Verify your account");
    }

}
