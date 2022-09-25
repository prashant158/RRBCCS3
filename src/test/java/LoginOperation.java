import PageObjectsandMethods.qaLeadHomePage;
import org.testng.annotations.Test;

public class LoginOperation extends BaseTest1 {


   @Test (description = "Validate home page title")
   public void validatehomePageHeading()
   {
       qaLeadHomePage qa = new qaLeadHomePage(driver);
       qa.getHomePageHeading();
   }

   @Test (description = "Login into connect application...")
   public void ClickonMemebersLoginLink() throws InterruptedException {
        qaLeadHomePage qa = new qaLeadHomePage(driver);
        qa.getmembersloginlink().click();
        Thread.sleep(4000);
        //PageObjectsandMethods.LoaginPageObjectsandMethods lp= new LoaginPageObjectsandMethods(driver);
        //lp.getEmail().sendKeys("pb@g.com");
        //lp.getPassword().sendKeys("pb");
        //lp.getLoginButton().click();
    }





}
