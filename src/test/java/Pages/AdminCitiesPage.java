package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminCitiesPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]")
    private WebElement adminButton;

    @FindBy(xpath = "//*[@id=\"list-item-117\"]")
    private WebElement citiesButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button")
    private WebElement addNewCity;

    @FindBy(id = "name")
    private WebElement cityName;

    @FindBy(xpath = "//*[@id=\"app\"]/div[5]/div/div/div[3]/button[2]")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement alertMessage;
    @FindBy(id = "edit")
    private WebElement editButton;

    @FindBy(id = "search")
    private WebElement searchField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]")
    private WebElement citiesTable;

    @FindBy(id = "delete")
    private WebElement deleteButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[11]/div/div/div[2]/button[2]")
    private WebElement deleteConfrim;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement confirmDeleteMessage;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]")
    private WebElement cityNameTable;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]")
    private WebElement tableRow;

    @FindBy(className = "v-toolbar__content")
    private WebElement deleteAlertMessage;

    @FindBy(css = "#app > div.v-dialog__content.v-dialog__content--active > div > div > div.v-card__actions > button.v-btn.v-btn--text.theme--light.v-size--default.red--text.text--lighten3")
    private WebElement confirmDelete;

    public AdminCitiesPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public void openCitiesPage() {
        adminButton.click();
        citiesButton.click();
    }

    public void addNewCity(String city) {
        addNewCity.click();
        cityName.sendKeys(city);
        saveButton.click();
    }

    public void editExistingCity(String city) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")));
        searchField.sendKeys(city);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit")));
        editButton.click();
        cityName.sendKeys(" - edited");
        saveButton.click();
    }

    public void searchCity(String city) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")));
        searchField.clear();
        searchField.sendKeys(city);
        webDriverWait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]"), city + " - edited"));
    }

    public String messageAlert() {
        String messageAlert = alertMessage.getText();
        return messageAlert;
    }

    public String cityName() {
        String editedCityName = cityNameTable.getText();
        return editedCityName;
    }

    public void deleteCity(String city) {
        webDriverWait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]"), 1));
        deleteButton.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-toolbar__content")));
        confirmDelete.click();
        webDriverWait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"), "Deleted successfully"));
    }

}
