package Utilites;


import WebDriverIntialization.WebDriverTest;
import org.openqa.selenium.WebDriver;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class PropertyFileUtil {
    public static ResourceBundle bundle = ResourceBundle.getBundle("autofrmwrk");
    public  static String baseurl=" ";
   static WebDriver driver = null;

//public static void main(String args[]) {
    public void resourceBundle(){

Enumeration<String> keys = bundle.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            System.out.println("keys is:" +key);
            String value = bundle.getString(key);
            System.out.println("Value of key is :" +value);
        }
    /*    WebDriverTest.launchDriver(driver);
        WebDriverTest.openAdminPage(driver);*/
    }
    public static String getValueForKey(String key) {

       baseurl=bundle.getString(key);
        System.out.println("BaseUrl: " +baseurl);
        return  baseurl;
        }

    }







