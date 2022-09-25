import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.Constants;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;
    public ExtentHtmlReporter htmlReporter;
    public ExtentReporter htmlReporter1;
    public static ExtentReports extent;
    public static ExtentTest logger;

    @BeforeTest
    public void beforeTestMethod()
    {
        htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+ File.separator+"reports"+File.separator +"AutomationReport.html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Automation Test Results");
        htmlReporter.config().setTheme(Theme.DARK);
        extent= new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Automation QA","Prashant Bachhav");
    }

    @BeforeMethod
    @Parameters(value = {"browserName"})
    public void beforeMethodMethod(String browserName, Method testMethod) throws InterruptedException {
        logger= extent.createTest(testMethod.getName());
        setUpDriver(browserName);
        driver.get(Constants.url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @AfterMethod
    public void afterMethodMethod(ITestResult result)
    {
        if(result.getStatus()== ITestResult.SUCCESS)
        {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case :" + methodName +"Passed";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            logger.log(Status.PASS,m);
        } else if (result.getStatus()== ITestResult.FAILURE) {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case :" + methodName +"Failed";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
            logger.log(Status.FAIL,m);

        }
        driver.quit();
    }

    @AfterTest
    public void afterTestMethod()
    {
        extent.flush();
    }

    public void setUpDriver(String browserName) throws InterruptedException {
        if(browserName.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            //driver.navigate().to("https://connect-qa.ccscloud.com/qa-web/");
            Thread.sleep(5000);
        }
        else if (browserName.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            //driver.navigate().to("https://connect-qa.ccscloud.com/qa-web/");
            Thread.sleep(5000);
        }
        else if (browserName.equalsIgnoreCase("edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            //driver.navigate().to("https://connect-qa.ccscloud.com/qa-web/");
            Thread.sleep(5000);
        }
        else
        {

        }
    }
}
