package PageObjectsandMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class qaLeadHomePage {

    WebDriver driver;
    String Expected;

    public qaLeadHomePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
    }


    @FindBy(xpath = "(//a[@class='utility__action utility__action--depth-0'])[4]")
    WebElement membersloginlink;


    @FindBy(xpath = "//div[@class='item-single__category-link']//a")
    WebElement HomePageHeading;

    public WebElement getHomePageHeading()
    {
        return HomePageHeading;
    }

    public WebElement getmembersloginlink()
    {
        return membersloginlink;
    }




}