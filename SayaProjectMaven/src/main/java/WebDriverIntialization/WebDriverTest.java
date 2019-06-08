package WebDriverIntialization;
import common.CommonConstants;
import common.CommonMethods;
import org.apache.commons.io.FileUtils;

import Utilites.PropertyFileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;


public class WebDriverTest extends PropertyFileUtil {
    public static   WebDriver driver=null;
    PropertyFileUtil propertyFileUtil = null;



    @BeforeSuite
public  static void launchDriver() {
        if (PropertyFileUtil.getValueForKey("selenium.defaultbrowser").equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "./server/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (PropertyFileUtil.getValueForKey("selenium.defaultbrowser").equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.firefox.driver", "./server/geckodriver");
            driver = new FirefoxDriver();

        }
        driver.manage().window().maximize();
        driver.get(PropertyFileUtil.getValueForKey("env.baseurl"));

    }
    public static void openAdminPage(WebDriver driver){
     driver.get(PropertyFileUtil.getValueForKey("admin.baseurl"));
        }
        @AfterSuite
            public void screenShot(){
                //using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
              //  if(ITestResult.FAILURE==result.getStatus()) {
                    try {
                        // To create reference of TakesScreenshot
                        TakesScreenshot screenshot = (TakesScreenshot) driver;
                        // Call method to capture screenshot
                        File src = screenshot.getScreenshotAs(OutputType.FILE);
                        // Copy files to specific location
                        // result.getName() will return name of test case so that screenshot name will be same as test case name
                        FileUtils.copyFile(src, new File(CommonConstants.CURRENT_DIRECTORY_PATH+ CommonMethods.getCurrentTimeStamp() + ".png"));
                        System.out.println("Successfully captured a screenshot");
                    } catch (Exception e) {
                        System.out.println("Exception while taking screenshot " + e.getMessage());
                    }
            driver.quit();

        }

        }





