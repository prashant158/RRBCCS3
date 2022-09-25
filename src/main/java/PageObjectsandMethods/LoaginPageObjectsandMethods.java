package PageObjectsandMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoaginPageObjectsandMethods{

    WebDriver driver;

    public LoaginPageObjectsandMethods(WebDriver driver)
    {
        //super(driver);
        this.driver= this.driver;
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(id = "Email")
    WebElement Email;

    @FindBy(id="Password")
    WebElement Password;

    @FindBy(id="LoginButton")
    WebElement LoginButton;

        public WebElement getEmail()
        {
            return Email;
        }
        public WebElement getPassword()
        {
            return Password;
        }

        public WebElement getLoginButton()
        {
            return LoginButton;
        }

        public void clickLoginbutton()
        {
            LoginButton.click();
        }
}
