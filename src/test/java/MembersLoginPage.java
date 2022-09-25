import PageObjectsandMethods.qaLeadMembersLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MembersLoginPage extends BaseTest1 {

    @Test(description = "User login process check")
    public void loginwithusernamepassword() throws InterruptedException {
        String Expected;
        qaLeadMembersLoginPage lp= new qaLeadMembersLoginPage(driver);
        Thread.sleep(4000);
        lp.getUsername().sendKeys("Prashantb@winjit.com");
        lp.getUserPassword().sendKeys("Winjit@0158");
        Expected=lp.getLoginError().getText();
        Assert.assertEquals(Expected,"ERROR");
        Thread.sleep(2000);
        lp.getLoginButton().click();
    }


}
