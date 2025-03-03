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

    @Test(priority = 0)
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

        //logout the user for login again
        loginPage.user_logout();
    }
    @Test(priority = 1)
    public void test_user_login_with_invalid_username(){
        String title = homePage.verifyOnHomePage();
        Assert.assertEquals(title, "Guru99 Bank Logout Output Page", "Home Page title mismatch!");
        // Login with invalid credentials: invalid username valid password

        homePage.login_with("abcd", password);

        // Verify if unsuccessful login alert pop_up message is displayed
        String invalid_msg = loginPage.verifyUnableInSuccessfully();
        Assert.assertEquals(invalid_msg, "User or Password is not valid");
    }

    @Test(priority = 2)
    public void test_user_login_with_invalid_password(){
        String title = homePage.verifyOnHomePage();
        Assert.assertEquals(title, "Guru99 Bank Home Page", "Home Page title mismatch!");

        // Login with invalid credentials: valid username invalid password
        homePage.login_with(username, "abc123");

        // Verify if unsuccessful login alert pop_up message is displayed
        String invalid_msg = loginPage.verifyUnableInSuccessfully();
        Assert.assertEquals(invalid_msg, "User or Password is not valid");
    }
    @Test(priority = 3)
    public void test_user_login_with_invalid_credentials(){
        String title = homePage.verifyOnHomePage();
        Assert.assertEquals(title, "Guru99 Bank Home Page", "Home Page title mismatch!");

        // Login with invalid credentials: valid username invalid password
        homePage.login_with("abcd", "abc123");

        // Verify if unsuccessful login alert pop_up message is displayed
        String invalid_msg = loginPage.verifyUnableInSuccessfully();
        Assert.assertEquals(invalid_msg, "User or Password is not valid");
    }

    @Test(priority = 4)
    public void test_user_login_with_blank_username_valid_password(){
        String title = homePage.verifyOnHomePage();
        Assert.assertEquals(title, "Guru99 Bank Home Page", "Home Page title mismatch!");

        // Login with invalid credentials: valid username invalid password
        Boolean is_error_msg_displayed=homePage.login_with_blank("", password);
        Assert.assertTrue(is_error_msg_displayed);
        // Verify if unsuccessful login alert pop_up message is displayed
        String invalid_msg = loginPage.verifyUnableInSuccessfully();
        Assert.assertEquals(invalid_msg, "User or Password is not valid");
    }
    @Test(priority = 5)
    public void test_user_login_with_valid_username_blank_password(){
        String title = homePage.verifyOnHomePage();
        Assert.assertEquals(title, "Guru99 Bank Home Page", "Home Page title mismatch!");

        // Login with invalid credentials: valid username invalid password
        Boolean is_error_msg_displayed=homePage.login_with_blank(username, "");
        Assert.assertTrue(is_error_msg_displayed);
        // Verify if unsuccessful login alert pop_up message is displayed
        String invalid_msg = loginPage.verifyUnableInSuccessfully();
        Assert.assertEquals(invalid_msg, "User or Password is not valid");
    }
    @Test(priority = 6)
    public void test_user_login_with_blank_username_blank_password(){
        String title = homePage.verifyOnHomePage();
        Assert.assertEquals(title, "Guru99 Bank Home Page", "Home Page title mismatch!");

        // Login with invalid credentials: valid username invalid password
        Boolean is_error_msg_displayed=homePage.login_with_blank("", "");
        Assert.assertTrue(is_error_msg_displayed);
        // Verify if unsuccessful login alert pop_up message is displayed
        String invalid_msg = loginPage.verifyUnableInSuccessfully();
        Assert.assertEquals(invalid_msg, "User or Password is not valid");
    }
    @Test(priority = 7)
    public void test_user_reset() {
        // Verify on homepage
        String title = homePage.verifyOnHomePage();
        Assert.assertEquals(title, "Guru99 Bank Home Page", "Home Page title mismatch!");

        // Login with valid credentials
        Boolean reset_successful=homePage.reset_with(username, password);
        Assert.assertTrue(reset_successful);

    }

}
