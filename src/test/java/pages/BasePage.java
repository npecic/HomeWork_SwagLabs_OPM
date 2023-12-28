package pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    // WebDriver instance
    public WebDriver driver;
    // Default wait time
    public int waitTime = 30;

    // WebElements using PageFactory
    @FindBy(css = ".login")
    public WebElement signInButton;
    @FindBy(css = "#submitAccount")
    public WebElement clickRegister;

    // Constructor to initialize the WebDriver and PageFactory
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to click the Sign In button
    public void clickSignInButton() {
        clickElement(signInButton, "sign in button");
    }

    // Method to click the Register button
    public void registerBtn(){
        clickElement(clickRegister, "register button");
    }

    // Generic method to click a WebElement with logging
    public void clickElement(WebElement element, String log) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, waitTime);
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));

            Actions actions = new Actions(driver);
            actions.moveToElement(element).click().build().perform();
            System.out.println("Clicked " + log);
        } catch (StaleElementReferenceException e) {
            // Retry the click in case of a StaleElementReferenceException
            Actions actions = new Actions(driver);
            actions.moveToElement(element).click().build().perform();
            System.out.println("Clicked " + log);
        }
    }

    // Generic method to send keys to a WebElement with logging
    public void sendKeys(WebElement element, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, waitTime);
            wait.until(ExpectedConditions.visibilityOf(element));

            element.clear();
            element.sendKeys(text);

            System.out.println("Entered " + text);

        } catch (StaleElementReferenceException e) {
            // Retry the sendKeys in case of a StaleElementReferenceException
            element.clear();
            element.sendKeys(text);

            System.out.println("Entered " + text + " value ");
        }
    }
}
