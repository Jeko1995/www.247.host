package tests.login;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginWithInvalidCredentials18 extends TestUtil {

    // Test for login with invalid credentials
    @Test(dataProvider = "invalidLoginCredentials")
    public void loginWithInvalidCredentials18(String username, String password) {

        // Perform login with invalid credentials
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginBtn();
        loginPage.enterUserDataAndLogin(username, password);

        // Assert that the user is successfully logged in
        Assert.assertTrue(loginPage.isAt());
    }
}