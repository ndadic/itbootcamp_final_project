package Tests;

import Pages.LoginPage;
import Pages.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    protected LoginPage loginPage;
    protected SignUpPage signupPage;

    final String baseUrl = ("https://vue-demo.daniel-avellaneda.com");

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dadic\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, webDriverWait);
        signupPage = new SignUpPage(driver, webDriverWait);

    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
