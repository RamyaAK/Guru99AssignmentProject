package guru99_unit_tests.login;

import guru99_unit_tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    private String username;
    private String password;

    @BeforeMethod
    public void initializeUserCredentials() {
        // Fetch credentials from system properties or use defaults
        this.username = System.getProperty("user.username", "mngr614490");
        this.password = System.getProperty("user.password", "qYsymed");
    }

    @Test
    public void test_user_login_with_valid_UserCredentials() {
        // Verify on homepage
        String title = homePage.verifyOnHomePage();
        Assert.assertEquals(title, "Guru99 Bank Home Page", "Home Page title mismatch!");

        // Login with valid credentials
        homePage.login_with(username, password);

        // Verify on LoginPage after successful login
        String managerial_title = loginPage.verifyOnLoginPage();
        Assert.assertEquals(managerial_title, "Guru99 Bank Manager HomePage", "Login Page title mismatch!");

        // Verify if successful login message is displayed
        String login_success_msg = loginPage.VerifyLoggedInSuccessfully();
        Assert.assertEquals(login_success_msg, "Welcome To Manager's Page of Guru99 Bank", "Login success message mismatch!");
    }
}
