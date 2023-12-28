package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends BasePage {

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(css ="#email_create")
    WebElement email;
    @FindBy(css ="#SubmitCreate")
    WebElement clickCreate;


    public void submitCreate(String emailValue){
        enterEmail(emailValue);
        clickLogin();
    }

    public void enterEmail(String emailValue){
        sendKeys(email, emailValue);
    }
    public void clickLogin(){
        clickElement(clickCreate, "create account");
    }

}
