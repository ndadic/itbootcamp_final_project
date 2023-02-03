package Tests;

import Pages.CitiesPage;
import Pages.LoginPage;
import Pages.SignUpPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public abstract class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    protected Faker faker;

    protected LoginPage loginPage;
    protected SignUpPage signupPage;

    protected CitiesPage citiesPage;

    final String baseUrl = ("https://vue-demo.daniel-avellaneda.com");
    protected String city;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dadic\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        faker = new Faker();
        loginPage = new LoginPage(driver, webDriverWait);
        signupPage = new SignUpPage(driver, webDriverWait);
        citiesPage = new CitiesPage(driver, webDriverWait);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl);
        driver.manage().window().maximize();
        city = faker.address().city();
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
