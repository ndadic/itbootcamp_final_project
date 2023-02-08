package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyProfilePage extends BasePage {
    @FindBy(id = "phone")
    private WebElement phoneField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "country")
    private WebElement countryField;

    @FindBy(id = "urlTwitter")
    private WebElement twitterField;

    @FindBy(id = "urlGitHub")
    private WebElement gitHubField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
    private WebElement saveMessage;

    @FindBy(xpath = "//*[@id=\"app\"]/div[4]/div/div/div[1]")
    private WebElement verifyAccount;

    @FindBy(css = "#app > div.v-dialog__content.v-dialog__content--active > div > div > div.v-card__actions > button")
    private WebElement closeButton;

    public MyProfilePage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public void afterSignUp() {

        webDriverWait.until(ExpectedConditions.textToBePresentInElement(verifyAccount, "IMPORTANT: Verify your account"));
        closeButton.click();

    }

    public void addPhoneNumber(String phone) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(phoneField));
        phoneField.clear();
        phoneField.sendKeys(phone);
    }

    public void addCity(String city) {
        cityField.sendKeys(Keys.SPACE);
        cityField.sendKeys(Keys.CONTROL + "a");
        cityField.sendKeys(city);
        cityField.sendKeys(Keys.ARROW_DOWN);
        cityField.sendKeys(Keys.ENTER);
    }

    public void addCountry(String country) {
        countryField.clear();
        countryField.sendKeys(country);
    }

    public void addTwitter(String twitter) {
        twitterField.clear();
        twitterField.sendKeys(twitter);
    }

    public void addGitHub(String gitHub) {
        gitHubField.clear();
        gitHubField.sendKeys(gitHub);
    }

    public void editProfile(String phone, String city, String country, String twitter, String gitHub) {
        addPhoneNumber(phone);
        addCity(city);
        addCountry(country);
        addTwitter(twitter);
        addGitHub(gitHub);
        saveButton.click();

    }

    public String saveMessage() {
        String saveMessageText = saveMessage.getText();
        return saveMessageText;
    }

    public WebElement getPhoneField() {
        return phoneField;
    }

    public WebElement getCityField() {
        return cityField;
    }

    public WebElement getCountryField() {
        return countryField;
    }

    public WebElement getTwitterField() {
        return twitterField;
    }

    public WebElement getGitHubField() {
        return gitHubField;
    }
}
