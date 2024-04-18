package tests.login;

import base.TestUtil;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ResetPasswordPage;

public class CheckForgottenPass19 extends TestUtil {

    //This test check is option for forgotten password works correctly
    @Test(dataProvider = "emails")
    public void checkForgottenPass19(String username){
        // Go to the reset password page and check is option for forgotten password works correctly
        HomePage homePage = new HomePage(driver);
        ResetPasswordPage resetPasswordPage = homePage.clickLoginBtn().clickForgottenPasswordLink();
        resetPasswordPage.enterEmailAndSubmit(username);
        resetPasswordPage.checkConfirmationMsg();
    }
}

/*
- защо когато не намери съобщението теста не фейлва
- понякога не показва никакво съобщение
 */