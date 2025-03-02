package guru99_unit_tests.login;

import guru99_unit_tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    private String username;
    private String password;

    public void initializeUserCredentials(String user_id, String password_val) {
        this.username = user_id;
        this.password = password_val;
    }

    @Test
    public void test_user_login_with_valid_UserCredentials() {
        //verify on homepage.
        String title = homePage.verifyOnHomePage();
        Assert.assertEquals(title, "Guru99 Bank Home Page");

        //get user test data for login.
        initializeUserCredentials("mngr614490", "qYsymed");

        //login
        homePage.login_with(username, password);

        //verify on LoginPage after successful user login.
        String managerial_title = loginPage.verifyOnLoginPage();
        Assert.assertEquals(managerial_title, "Guru99 Bank Manager HomePage");

        //verify if successful login message is displayed.
        String login_success_msg = loginPage.VerifyLoggedInSuccessfully();
        Assert.assertEquals(login_success_msg, "Welcome To Manager's Page of Guru99 Bank");
    }
}
