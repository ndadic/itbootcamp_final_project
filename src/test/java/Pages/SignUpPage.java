package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasePage {

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[4]")
    private WebElement signUpHeaderButton;

    @FindBy (id = "name")
    private WebElement name;

    @FindBy (id = "email")
    private WebElement email;

    @FindBy (id = "password")
    private WebElement password;

    @FindBy (id = "confirmPassword")
    private WebElement confirmPassword;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button")
    private WebElement signUpButton;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li")
    private WebElement alertMessageUserExists;

    @FindBy (xpath = "//*[@id=\"app\"]/div[4]/div/div/div[1]")
    private WebElement verifyAccount;
    ////*[@id="app"]/div[4]/div/div - cela por
    public SignUpPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getConfirmPassword() {
        return confirmPassword;
    }

    public void openSignUpPage(){
        signUpHeaderButton.click();
    }

    public void signUp(String name, String email, int password){
        this.name.clear();
        this.email.clear();
        this.password.clear();
        this.confirmPassword.clear();

        this.name.sendKeys(name);
        this.email.sendKeys(email);
        this.password.sendKeys(String.valueOf(password));
        this.confirmPassword.sendKeys(String.valueOf(password));
        signUpButton.click();

    }

    public String alertMessage(){
      String message = alertMessageUserExists.getText();
      return message;
    }

    public String verifyAccountMessage(){
        String verifyMessage = verifyAccount.getText();
        return verifyMessage;
    }
}


