package guru99_unit_tests.login;

import guru99.utils.PropertiesReader;
import guru99_unit_tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    private String username;
    private String password;
    private String managerId;

    @BeforeMethod
    public void initializeUserCredentials() {
        // Fetch credentials from system properties or use defaults
        this.username = PropertiesReader.getProperty("username");
        this.password = PropertiesReader.getProperty("password");
        this.managerId= PropertiesReader.getProperty("manager_id");
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
        String login_success_msg = loginPage.verifyLoggedInSuccessfully();
        Assert.assertEquals(login_success_msg, "Welcome To Manager's Page of Guru99 Bank", "Login success message mismatch!");

        //Verify If ManagerId is being displayed
        String managersId = loginPage.getManagerId();
        Assert.assertEquals(managersId,"Manger Id : "+managerId);
    }
}
