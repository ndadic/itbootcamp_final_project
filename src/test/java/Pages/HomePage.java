package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    @FindBy(className = "btnLogout")
    private WebElement logout;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button")
    private WebElement languageButton;

    @FindBy(id = "list-item-73")
    private WebElement buttonEN;

    @FindBy(id = "list-item-75")
    private WebElement buttonES;

    @FindBy(id = "list-item-77")
    private WebElement buttonFR;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]")
    private WebElement headerMessage;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]")
    private WebElement myProfileButton;


    public HomePage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public WebElement getLogout() {
        return logout;
    }

    public boolean isLogoutVisible() {
        logout.isDisplayed();
        return true;
    }

    public void logout() {
        logout.click();
    }

    public WebElement getLanguageButton() {
        return languageButton;
    }

    public WebElement getButtonEN() {
        return buttonEN;
    }

    public WebElement getButtonES() {
        return buttonES;
    }

    public WebElement getButtonFR() {
        return buttonFR;
    }

    public String headerMessage() {
        String headerTextMessage = headerMessage.getText();
        return headerTextMessage;
    }

    public void clickOnMyProfile() {
        myProfileButton.click();
    }
}

