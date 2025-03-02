package guru99.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    private By verify_on_login_page_message = By.tagName("marquee");
    private By managerId = By.cssSelector("tr[class='heading3'] td");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public String verifyOnLoginPage() {
      return driver.getTitle();
    }

    public String verifyLoggedInSuccessfully() {
        driver.findElement(verify_on_login_page_message).isDisplayed();
        return driver.findElement(verify_on_login_page_message).getText();
    }


    public String getManagerId() {
        return driver.findElement(managerId).getText();
    }
}
