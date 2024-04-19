package tests.login;

import base.TestUtil;
import org.testng.annotations.Test;
import pages.Email.EmailLoginPage;
import pages.HomePage;
import pages.ResetPasswordPage;

public class CheckForgottenPass19 extends TestUtil {

    //This test check is option for forgotten password works correctly
    @Test(dataProvider = "getEmailAndEmailLoginCredentials")
    public void checkForgottenPass19( String username, String email, String password) {

        // Go to the reset password page and check is option for forgotten password works correctly
        HomePage homePage = new HomePage(driver);
        EmailLoginPage emailLoginPage = homePage.clickLoginBtn().clickForgottenPasswordLink().enterEmailAndSubmit(username).checkConfirmationMsg();
        emailLoginPage.openEmailLoginPage(emailUrl).loginToEmail(email, password);
    }
}

/*
- понякога не показва никакво съобщение// пуснат е тикет и е говорено с Кимо

HomePage homePage = new HomePage(driver);
        ResetPasswordPage resetPasswordPage = homePage.clickLoginBtn().clickForgottenPasswordLink();
        resetPasswordPage.enterEmailAndSubmit(username);
        EmailLoginPage emailLoginPage = resetPasswordPage.checkConfirmationMsg();
        emailLoginPage.openEmailLoginPage(emailUrl);
        emailLoginPage.loginToEmail(email, password);
 */