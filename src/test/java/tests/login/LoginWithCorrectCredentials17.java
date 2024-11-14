package tests.login;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserPanelPage;

public class LoginWithCorrectCredentials17 extends TestUtil {

    // Test for successful login with valid credentials.
    @Test(dataProvider = "correctLoginCredentials")
    public void loginWithCorrectCredentials17(String username, String password) {

        // Perform successful login with valid credentials.
        HomePage homePage = new HomePage(driver);
        UserPanelPage userPanelPage = homePage.clickLoginBtn().enterUserDataAndLogin(username,password);

        // Assert that the user is successfully logged in.
        Assert.assertTrue(userPanelPage.isAt());
    }
}