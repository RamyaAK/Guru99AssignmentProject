package guru99.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
   // private By home_page_title = By.tagName("title");
    private By username = By.xpath("//input[@name='uid']");
    private By password = By.xpath("//input[@name='password']");
    private By login_button = By.xpath("//input[@name='btnLogin']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String verifyOnHomePage() {
        return driver.getTitle();
    }

    public LoginPage login_with(String user_id,String password_val){
      driver.findElement(username).sendKeys(user_id);
      driver.findElement(password).sendKeys(password_val);
      driver.findElement(login_button).click();
      return new LoginPage(driver);
    }
}
