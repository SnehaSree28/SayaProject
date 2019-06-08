package common;

import WebDriverIntialization.WebDriverTest;
import org.openqa.selenium.JavascriptExecutor;


/**
 * Created by lovel on 13-Oct-18.
 */
public class CommonJavaScriptMethods extends WebDriverTest {
    private static JavascriptExecutor js=(JavascriptExecutor)driver;

    public static void scrollDown(String value){
        js.executeScript("window.scrollBy("+value+")");

    }


}
