package guru99.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By home_page_title = By.tagName("title");
    private By username = By.xpath("//input[@name='uid']");
    private By password = By.xpath("//input[@name='password']");
    private By login_button = By.xpath("//input[@name='btnLogin']");
    private By username_should_not_be_blank_message = By.id("message23");
    private By password_should_not_be_blank_message = By.id("message18");
    private By reset_button = By.cssSelector("input[value='RESET']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for elements
    }

    public String verifyOnHomePage() {
        // Wait for the page title to load
        // Wait until the page title matches one of the expected values
        wait.until((Function<WebDriver, Boolean>) d -> {
            String title = d.getTitle();
            return title.equals("Guru99 Bank Home Page") || title.equals("Guru99 Bank Logout Output Page");
        });
        return driver.getTitle();
    }

    public LoginPage login_with(String user_id, String password_val) {
        // Wait for username field to be visible and enter username
        WebElement userInput = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        userInput.clear(); // Clear any existing text
        userInput.sendKeys(user_id);

        // Wait for password field to be visible and enter password
        WebElement passInput = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        passInput.clear();
        passInput.sendKeys(password_val);

        // Wait for login button to be clickable and click it
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(login_button));
        loginBtn.click();

        return new LoginPage(driver);
    }

    // Check if username blank message is displayed
    public boolean isUsernameBlankMessageDisplayed() {
        try {
            WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(username_should_not_be_blank_message));
            return errorMsg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Check if password blank message is displayed
    public boolean isPasswordBlankMessageDisplayed() {
        try {
            WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(password_should_not_be_blank_message));
            return errorMsg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean login_with_blank(String user_id, String password_val) {
        // Wait for username field to be visible and enter username
        WebElement userInput = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        userInput.clear(); // Clear any existing text
        userInput.sendKeys(user_id);

        // Wait for password field to be visible and enter password
        WebElement passInput = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        passInput.clear();
        passInput.sendKeys(password_val);
        isUsernameBlankMessageDisplayed();
        isPasswordBlankMessageDisplayed();
        return (isUsernameBlankMessageDisplayed() || isPasswordBlankMessageDisplayed());
    }

    public Boolean reset_with(String user_id, String password_val) {
        // Wait for username field to be visible and enter username
        WebElement userInput = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        userInput.clear(); // Clear any existing text
        userInput.sendKeys(user_id);

        // Wait for password field to be visible and enter password
        WebElement passInput = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        passInput.clear();
        passInput.sendKeys(password_val);

        // Wait for reset button to be visible and click on it.
        WebElement reset = wait.until(ExpectedConditions.visibilityOfElementLocated(reset_button));
        driver.findElement(reset_button).click();

        // Wait for the fields to be reset and check if they are empty
        String userText = userInput.getAttribute("value");  // Get the value attribute of username field
        String passText = passInput.getAttribute("value");  // Get the value attribute of password field

        return userText.isEmpty() || passText.isEmpty();

    }
}
