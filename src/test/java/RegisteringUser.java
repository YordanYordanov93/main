import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;

public class RegisteringUser {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2020.2.3\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://login.yahoo.com/account/create");
    }

    @Test
    public void registerTest() {
        WebElement firstnameInput = driver.findElement(By.cssSelector("#usernamereg-firstName"));
        firstnameInput.sendKeys("Yordan");
        /* Inputting Username */
        WebElement lastnameInput = driver.findElement(By.cssSelector("#usernamereg-lastName"));
        lastnameInput.sendKeys("Yordanov");
        /* Inputting Lastname */
        WebElement emailaddresInput = driver.findElement(By.id("usernamereg-yid"));
        emailaddresInput.sendKeys("yordan@yahoo.com");
        /* Inputting fixing email : yordan@yahoo.com to be enabled to see equivalent email with same core of word */
        WebElement dropDown = driver.findElement(By.xpath("//ul[@id='desktop-suggestion-list']"));
        dropDown.click();




        /* Inputting password */


        WebElement password = driver.findElement(By.id("usernamereg-password"));
        password.sendKeys("testtest123");
        password.click();
        WebElement visiblePassword = driver.findElement(By.id("usernamereg-show-button"));
        /* Visible Password */
        try {
            if (visiblePassword.isDisplayed()) {
                visiblePassword.click();
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        // Action is not necessary
        Actions builder = new Actions(driver);
        builder
                .click(visiblePassword);


        assertFalse(visiblePassword.isSelected());












        /*Choose bulgarian national number */
        new Select(driver.findElement(By.name("shortCountryCode"))).selectByValue("BG");

        /* Inputting private number */
        WebElement number = driver.findElement(By.id("usernamereg-phone"));
        number.sendKeys("889999770");

        /* Choose Birth Of Month */
        new Select(driver.findElement(By.id("usernamereg-month"))).selectByValue("1");

        /* Inputting birthDay */
        WebElement birthDay = driver.findElement(By.id("usernamereg-day"));
        birthDay.sendKeys("14");

        /*Inputting birthYear */
        WebElement birthYear = driver.findElement(By.id("usernamereg-year"));
        birthYear.sendKeys("1993");

        /* Inputting Gender with checking for male gender option*/
        WebElement inputField = driver.findElement(By.id("usernamereg-freeformGender"));
        WebElement gender = driver.findElement(By.className("reg-gender-list"));
        List<WebElement> options = gender.findElements(By.xpath("//ul[@id='reg-gender-list']"));
        for (WebElement option : options) {
            if (option.getText().equals("Male")){
            }
            inputField.sendKeys("Male");
        }


            /* Continue button */
    WebElement registerButton = driver.findElement(By.id("reg-submit-button"));
        registerButton.click();
}





    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}




