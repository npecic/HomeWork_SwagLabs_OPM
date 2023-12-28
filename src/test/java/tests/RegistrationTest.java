package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CreateAccountPage;
import pages.RegistrationPage;

public class RegistrationTest extends BaseTest {


    // This method is executed before each test method to set up the test environment.
    @BeforeMethod
    public void setup(){
        baseSetUP();
    }

    // This method is executed after each test method to tear down the test environment.
    @AfterMethod
    public void tearDown(){
        baseTearDown();
    }

    @Test
    public void registration() throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        driver.get("http://www.automationpractice.pl/index.php");

        basePage.clickSignInButton();

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.submitCreate("test"+System.currentTimeMillis()+"@test.com");

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.selectGender("id_gender2");

        registrationPage.enterName("Jessie");


        registrationPage.enterLast("James");
        registrationPage.enterEmail("test"+System.currentTimeMillis()+"@test.com");
        registrationPage.enterPass("1234567");
        registrationPage.selectDays(22);
        registrationPage.selectMonth(6);
        registrationPage.selectYear("1992");


        registrationPage.registerBtn();

        String message = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[1]")).getText();

        Assert.assertEquals(message,"Your account has been created.");



    }
}
