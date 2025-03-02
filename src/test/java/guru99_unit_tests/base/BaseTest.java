package guru99_unit_tests.base;

import guru99.pages.HomePage;
import guru99.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;

    @BeforeClass
    public void setup_browser() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        launchUrl();
        initialize_page_objects();
    }

    public void initialize_page_objects() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    public void launchUrl() {
        driver.manage().window().maximize();
        driver.get("https://www.demo.guru99.com/V4/");
    }

    @AfterClass
    public void teardown() {
        System.out.println("Closing test, thank you!");
        if (driver != null) {
            driver.quit();
        }
    }
}