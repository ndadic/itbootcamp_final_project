package Tests;

import Pages.*;
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
    protected HomePage homePage;
    protected final String BASEURL = ("https://vue-demo.daniel-avellaneda.com");
    protected final String EMAIL = "admin@admin.com";
    protected final String TRUE_PASS = "12345";
    protected final String LOGIN_URL = "/login";
    protected final String HOME_URL = "/home";
    protected final String ADMIN_CITIES_URL = "/admin/cities";

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        faker = new Faker();
        homePage = new HomePage(driver, webDriverWait);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(BASEURL);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
