package PageObjectsandMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjectsandMethods{
WebDriver driver;
    public HomePageObjectsandMethods(WebDriver driver)
    {
        //super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy (xpath = "//button[normalize-space()='OK']")
    WebElement WhatNewOKButton;

    @FindBy(xpath = "//i[@class='fas fa-ellipsis-v']")
    WebElement MenuDots;

    @FindBy (xpath = "//i[@class='fas fa-sign-out-alt']")
    WebElement LogoutButton;

    @FindBy(xpath = "//button[normalize-space()='Yes']")
    WebElement NotificationOKButton;

    public WebElement getWhatNewOKButton()
    {
        return WhatNewOKButton;
    }

    public WebElement getMenuDots()
    {
        return MenuDots;
    }

    public WebElement getLogoutButton()
    {
        return LogoutButton;
    }

    public WebElement getNotificationOKButton()
    {
        return NotificationOKButton;
    }


}
