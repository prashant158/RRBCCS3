package PageObjectsandMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class qaLeadMembersLoginPage {
    WebDriver driver;

    public qaLeadMembersLoginPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(id="user_login")
    WebElement Userlogin;

    @FindBy (id="user_pass")
    WebElement UserPassword;

    @FindBy(id="wp-submit")
    WebElement LoginButton;

    @FindBy(xpath = "//li //strong[contains(text(),'ERROR')]")
    WebElement LoginError;


    public WebElement getLoginError()
    {
        return LoginError;
    }

    public WebElement getUsername()
    {
        return Userlogin;
    }

    public WebElement getUserPassword()
    {
        return UserPassword;
    }

    public WebElement getLoginButton()
    {
        return LoginButton;
    }




}
