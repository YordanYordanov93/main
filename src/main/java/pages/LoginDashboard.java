package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Browser;

public class LoginDashboard extends BasePage {
    private static final By SIGNUP_H2_PAGE_TITLE = By.xpath("//h1[contains(text(),'Sign up')]");

    /**
     * Verifies if the title of the page which is present in the h1 html tag
     * is as we expect it to be
     *
     * @param expectedPageTitle the page title we expect to be on the dashboard page
     * @param messageOnFailure the message that will appear in case of test failure in our reports
     */

        public static void verifyPageTitle(String expectedPageTitle, String messageOnFailure){
            String actualPageTitle = Browser.driver.findElement(SIGNUP_H2_PAGE_TITLE).getText();
            Assert.assertEquals(actualPageTitle, expectedPageTitle, messageOnFailure);
        }
    }
