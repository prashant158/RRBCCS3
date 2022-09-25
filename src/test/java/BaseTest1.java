import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest1 {

    public static WebDriver driver;

    @BeforeTest (description = "browser invoked")
    public void initbrowser() throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.navigate().to("https://connect-qa.ccscloud.com/qa-web/");
        driver.navigate().to("https://theqalead.com/tools/best-web-automation-tools/");
        Thread.sleep(5000);
    }

    @AfterTest(enabled = true,description = "Browser Closed")
    public void closeBrowser()
    {
        driver.close();
    }

}
