package positive;

import org.testng.annotations.Test;
import pages.LoginDashboard;
import pages.NewUser;

public class NewUserTest extends positive.test.BaseTest {

    @Test
    public void successfulSignUp(){
        NewUser.goTo();
        NewUser.selectShortCountryCode("BG");
        NewUser.selectMonthBirthday("1");
        NewUser.create("Yordan","Yordanov", "yordan@yahoo.com","testtest123", "889999770","12","1992","Male");

        LoginDashboard.verifyPageTitle("Verify your phone number", "Smells like a bug");
    }
}

