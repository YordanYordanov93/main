package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.Browser;

public class NewUser extends BasePage {
    private static final By FIRSTNAME_INPUT_FIELD = By.cssSelector("#usernamereg-firstName");
    private static final By LASTNAME_INPUT_FIELD = By.cssSelector("#usernamereg-lastName");
    private static final By EMAILADDRES_INPUT_FIELD = By.id("usernamereg-yid");
    private static final By DROPDOWN_INPUT_FIELD = By.xpath("//ul[@id='desktop-suggestion-list']");
    private static final By PASSWORD_INPUT_FIELD = By.id("usernamereg-password");
    private static final By VISIBLE_PASSWORD_CHECKER = By.id("usernamereg-show-button");
    private static final By SHORT_COUNTRY_CODE_FIELD = By.name("shortCountryCode");
    private static final By NUMBER_FIELD = By.id("usernamereg-phone");
   private static final By BIRTH_MONTH_DROPDOWN = By.id("usernamereg-month");
    private static final By BIRTH_DAY_FIELD = By.id("usernamereg-day");
    private static final By BIRTH_YEAR_FIELD = By.id("usernamereg-year");
    private static final By GENDER_INPUT_FIELD = By.id("usernamereg-freeformGender");
    private static final By SUBMIT_BUTTON = By.id("reg-submit-button");
    private static final By VALIDATION_MESSAGE = By.id("reg-error-phone");



    public static void goTo() {
        Browser.driver.get("https://login.yahoo.com/account/create");
    }

    public static void selectShortCountryCode(String code){
        click(SHORT_COUNTRY_CODE_FIELD);
        new Select(Browser.driver.findElement(By.name("shortCountryCode"))).selectByValue(code);
    }

    public static void selectMonthBirthday(String month) {
        click(BIRTH_MONTH_DROPDOWN);
        new Select(Browser.driver.findElement(By.id("usernamereg-month"))).selectByValue(month);
        click(BIRTH_DAY_FIELD);
    }

    public static void create(String firstname, String lastname, String email, String password, String number,
                              String birthday, String birthyear, String genderInputField) {
        type(FIRSTNAME_INPUT_FIELD, firstname);
        type(LASTNAME_INPUT_FIELD, lastname);
        type(EMAILADDRES_INPUT_FIELD, email);
        click(DROPDOWN_INPUT_FIELD);
        type(PASSWORD_INPUT_FIELD,password);
        click(VISIBLE_PASSWORD_CHECKER);
        type(NUMBER_FIELD, number);
        type(BIRTH_DAY_FIELD, birthday);
        type(BIRTH_YEAR_FIELD, birthyear);
        type(GENDER_INPUT_FIELD, genderInputField);
        click(SUBMIT_BUTTON);


    }












    public static void verifyValidationMessage(String expectedValidationMessage, String messageOnFailure){
        String actualValidationMessage = getText(VALIDATION_MESSAGE);

        Assert.assertTrue(actualValidationMessage.contains(expectedValidationMessage), messageOnFailure);

    }
}

