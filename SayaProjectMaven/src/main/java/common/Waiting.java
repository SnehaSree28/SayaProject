package common;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class Waiting {
    private  static WebDriver driver;

    Waiting(WebDriver driver){
        this.driver=driver;
    }

    public static void staticWait(int seconds) {
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public static void webDriverWait(WebElement element, int seconds){
        WebDriverWait webDriverWait =new WebDriverWait(driver,seconds);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

   /* public static String getDefaultPageWaitTime() {
        return ConfigManager.getBundle().getString("selenium.wait.timeout", "5000");
    }*/

 //   public static long getDefaultPageWaitTimeNum() {
    //    return Long.valueOf(getDefaultPageWaitTime()).longValue();
    //}




}
