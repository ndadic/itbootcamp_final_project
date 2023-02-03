package Tests;

import Pages.AdminCitiesPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.SignUpPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;


public abstract class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    protected Faker faker;

    protected LoginPage loginPage;
    protected SignUpPage signupPage;

    protected AdminCitiesPage adminCitiesPage;
    protected HomePage homePage;

    final String baseUrl = ("https://vue-demo.daniel-avellaneda.com");
    protected String city1;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dadic\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        faker = new Faker();
        loginPage = new LoginPage(driver, webDriverWait);
        signupPage = new SignUpPage(driver, webDriverWait);
        adminCitiesPage = new AdminCitiesPage(driver, webDriverWait);
        homePage = new HomePage(driver, webDriverWait);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
    //    if (homePage.isLogoutVisible()) {
      //      homePage.logout();}
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
