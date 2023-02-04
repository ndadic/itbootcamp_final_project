package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LocaleTests extends BaseTest{

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.getLanguageButton().click();
    }

    @Test
    public void checkHeaderMessageES(){

        homePage.getButtonES().click();
        Assert.assertEquals(homePage.headerMessage(), "Página de aterrizaje");
    }
    @Test
    public void checkHeaderMessageEN(){

        homePage.getButtonEN().click();
        Assert.assertEquals(homePage.headerMessage(), "Landing" );
    }

    @Test
    public void checkHeaderMessageFR(){

        homePage.getButtonFR().click();
        Assert.assertEquals(homePage.headerMessage(), "Page d'atterrissage" );
    }
}
