package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BaseTest{

    @Test
    public void checkHeaderMessageES(){
        homePage.clickLanguageButtonES();
        Assert.assertEquals(homePage.headerMessage(), "Página de aterrizaje");
    }
    @Test
    public void checkHeaderMessageEN(){
        homePage.clickLanguageButtonEN();
        Assert.assertEquals(homePage.headerMessage(), "Landing" );
    }

    @Test
    public void checkHeaderMessageFR(){
        homePage.clickLanguageButtonFR();
        Assert.assertEquals(homePage.headerMessage(), "Page d'atterrissage" );
    }
}
