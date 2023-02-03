package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]")
    private WebElement logout;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button")
    private WebElement languageButton;

    @FindBy(id = "list-item-73")
    private WebElement buttonEN;

    @FindBy(id = "list-item-75")
    private WebElement buttonES;

    @FindBy(id = "list-item-77")
    private WebElement buttonFR;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]")
    private WebElement headerMessage;


    public HomePage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }
    public boolean isLogoutVisible() {
        logout.isDisplayed();
        return true;
    }

    public void logout() {
        logout.click();
    }

    public void clickLanguageButtonEN(){
        languageButton.click();
        buttonEN.click();
    }

    public void clickLanguageButtonFR(){
        languageButton.click();
        buttonFR.click();
    }

    public void clickLanguageButtonES(){
        languageButton.click();
        buttonES.click();
    }

    public String headerMessage(){
        String headerTextMessage = headerMessage.getText();
        return headerTextMessage;
    }
}

