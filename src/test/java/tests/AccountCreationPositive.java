package tests;

import org.testng.annotations.Test;
import pages.CreateAnAccountPage;
import utils.Driver;

public class AccountCreationPositive extends SignUpOption {
    @Test(groups = "smoke")
    public void fillOutValidData () throws InterruptedException {
        SignUpOption signUpOptionPage = new SignUpOption();
        signUpOptionPage.goToSignUp();








    }



}
