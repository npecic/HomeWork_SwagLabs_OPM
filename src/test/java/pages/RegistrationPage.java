package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage {

    // Constructor to initialize the WebDriver and PageFactory
    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // XPath expressions for registration form elements
    String selectGenderXpath = "//*[@id='$$']";
    String enterNameXpath = "//*[@id=\"customer_firstname\"]";
    String enterLastXpath = "//*[@id=\"customer_lastname\"]";
    String enterEmailXpath = "//*[@id=\"email\"]";
    String enterPassXpath = "//*[@id=\"passwd\"]";
    String selectDaysXpath = "//*[@id=\"days\"]";
    String selectMonthXpath = "//*[@id=\"months\"]";
    String selectYearXpath = "//*[@id=\"years\"]";

    // Method to select gender from the registration form
    public void selectGender(String select) throws InterruptedException {
        clickElement(driver.findElement(By.xpath(selectGenderXpath.replace("$$",select))), "gender - " + select);
    }

    // Method to enter the first name in the registration form
    public void enterName(String select) throws InterruptedException {
        sendKeys(driver.findElement(By.xpath(enterNameXpath)), "name - " + select);
    }

    // Method to enter the last name in the registration form
    public void enterLast(String select) throws InterruptedException {
        sendKeys(driver.findElement(By.xpath(enterLastXpath)), select);
    }

    // Method to enter the email in the registration form
    public void enterEmail(String select) throws InterruptedException {
        sendKeys(driver.findElement(By.xpath(enterEmailXpath)), select);
    }

    // Method to enter the password in the registration form
    public void enterPass(String select) throws InterruptedException {
        sendKeys(driver.findElement(By.xpath(enterPassXpath)), select);
    }

    // Method to select the day from the dropdown in the registration form
    public void selectDays(int  index) throws InterruptedException {
        WebElement daysDropdown = driver.findElement(By.xpath(selectDaysXpath));
        Select selectDays = new Select(daysDropdown);
        selectDays.selectByIndex(index);
    }

    // Method to select the month from the dropdown in the registration form
    public void selectMonth(int index) throws InterruptedException {
        WebElement daysDropdown = driver.findElement(By.xpath(selectMonthXpath));
        Select selectMonth = new Select(daysDropdown);
        selectMonth.selectByIndex(index);
    }

    // Method to select the year from the dropdown in the registration form
    public void selectYear(String select) throws InterruptedException {
        WebElement daysDropdown = driver.findElement(By.xpath(selectYearXpath));
        Select selectYear = new Select(daysDropdown);
        selectYear.selectByValue(select);
    }
}
