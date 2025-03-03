package guru99.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    private By verify_on_login_page_message = By.tagName("marquee");
    private By managerId = By.cssSelector("tr[class='heading3'] td");
    private By logoutLink = By.linkText("Log out");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String verifyOnLoginPage() {
        return driver.getTitle();
    }

    public String verifyLoggedInSuccessfully() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement marquee = wait.until(ExpectedConditions.visibilityOfElementLocated(verify_on_login_page_message));
            return marquee.getText();
        } catch (TimeoutException | NoSuchElementException e) {
            return "User or Password is not valid";
        }
    }

    public String getManagerId() {
        return driver.findElement(managerId).getText();
    }


    public String verifyUnableInSuccessfully() {
        try {
            Alert alert = driver.switchTo().alert(); // Switch to alert
            String alertText = alert.getText(); // Get alert text
            alert.accept(); // Accept (close) the alert
            return alertText;
        } catch (Exception e) {
            return "User or Password is not valid";
        }
    }

    public String user_logout() {
        driver.findElement(logoutLink).click(); // Click logout link

        try {
            Alert alert = driver.switchTo().alert(); // Switch to alert
            String alertText = alert.getText(); // Get alert text
            alert.accept(); // Accept (close) the alert
        } catch (NoAlertPresentException e) {
            return "You Have Successfully Logged Out!!";
        }
        return "You Have Successfully Logged Out!!";
    }

}
