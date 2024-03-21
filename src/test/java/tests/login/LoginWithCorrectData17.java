package tests.login;

import base.TestUtil;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginWithCorrectData17 extends TestUtil {

    // Test for successful login with valid credentials.
    @Test(dataProvider = "validLoginCredentials")
    public void loginWithCorrectData17(String username, String password) {

        // Perform successful login with valid credentials.
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginBtn();
        loginPage.login(username, password);
    }
}
