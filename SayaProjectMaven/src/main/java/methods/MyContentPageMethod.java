package methods;

import common.CommonConstants;
import common.CommonMethods;
import common.Waiting;
import enums.AdType;
import enums.BannerAds;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MyContentPage;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.awt.SystemColor.window;

/**
 * Created by lovel on 04-Nov-18.
 */
public class MyContentPageMethod extends MyContentPage {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebDriver driver2;
    Logger logger = Logger.getLogger(MyContentPageMethod.class);

    public void createNewContent() {
        createNewContent.click();
    }

    /* public void createBannerAds(AdType adType, BannerAds bannerAds){
         Select adType1 = new Select(selectAdType);
         adType1.selectByVisibleText(adType.toString());
         Select subAdType= new Select(selectSubType);
         subAdType.selectByVisibleText(bannerAds.toString());
     }*/
    public void clickElements(String element) {
        Waiting.staticWait(3000);
        driver.findElement(By.xpath("(//*[text()='" + element + "'])[2]")).click();
    }

    public void enterTextAndDescOfAudioAds() {
        Waiting.staticWait(2000);
        adName.sendKeys("Name" + CommonMethods.getCurrentTimeStamp());
        Waiting.staticWait(1000);
        adDescription.sendKeys("Text" + CommonMethods.getCurrentTimeStamp());
        Waiting.staticWait(1000);
        selectAudioFile.sendKeys(CommonConstants.CURRENT_RESOURCES_DIRECTORY_PATH + "audiofiles\\Dhooram.mp3");
        Waiting.staticWait(2000);
        uploadAudioFile.click();
        Waiting.staticWait(4000);
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
        //save.click();
    }

    /**
     * upload file using robot class
     */

    public void uploadFileUsingRobot() throws AWTException {
        StringSelection stringSelection = new StringSelection("C:\\Users\\lovel\\Music\\evare.mp3");
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        Robot robot = null;
        robot = new Robot();
        robot.mousePress(InputEvent.BUTTON1_MASK);
        Waiting.staticWait(5000);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }

    public boolean clickCreateContent() {
        WebElement createContent = driver.findElement(By.xpath("//*[@class='btn btn-primary']"));
        boolean x = createContent.isDisplayed();
        if (x) {
            createContent.click();
        }
        return x;

    }

    public void selectAdType() {
        WebElement adType = driver.findElement(By.xpath("(//*[text()='Select Content Type'])[2]"));
        if (adType.isDisplayed()) {
            adType.click();
        }
    }

    public String enterTextAndDescriptionOfAdTypes(String adTypeName) {
        Waiting.staticWait(2000);
        wait.until(ExpectedConditions.visibilityOf(adName));
        //WebElement adName= driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_txtAdName']"));
        adName.sendKeys(adTypeName);
        Waiting.staticWait(2000);
        wait.until(ExpectedConditions.visibilityOf(adDescription));
        adDescription.sendKeys("BannerAds" + CommonMethods.getCurrentTimeStamp());

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(chooseFile));

        chooseFile.sendKeys(CommonConstants.CURRENT_RESOURCES_DIRECTORY_PATH + "imagefiles\\abc.jpg");
        //save.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement clickOnSave = driver.findElement(By.xpath("//*[@class='btn btn-primary']"));
        clickOnSave.click();
        Waiting.staticWait(3000);
        return adTypeName;
    }

    public boolean searchAd(String adTypeName) {
        searchAd.sendKeys(adTypeName);
        searchAd.sendKeys(Keys.ENTER);

        Waiting.staticWait(2000);
        WebElement searchAd = driver.findElement(By.xpath("//*[text()='" + adTypeName + "']"));
        boolean status = searchAd.isDisplayed();
        if (status) {
            System.out.println("AdType exists");
        } else
            System.out.println("AdType does not exist");

        return status;
    }

    public String clickPages(String pageNo) {
        WebElement pageElement = driver.findElement(By.xpath("//a[text()='" + pageNo + "']"));
        pageElement.click();
        return pageNo;
    }

    public void paginationElement(String adName) {
        Waiting.staticWait(2000);
        /*JavascriptExecutor js=((JavascriptExecutor) driver);
        js.executeScript("window.scrollBy(0,-100)");*/
        Waiting.staticWait(2000);

        WebElement AdName = driver.findElement(By.xpath("//*[text()='" + adName + "']"));
        logger.info("AdName is " + AdName.getText());
        if (AdName.isDisplayed()) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='" + adName + "']/../preceding-sibling::td[4]//input[@type='checkbox']")));
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='" + adName + "']/../preceding-sibling::td[4]//input[@type='checkbox']"))));
            Waiting.staticWait(2000);
            WebElement clickCheckBox = driver.findElement(By.xpath("//*[text()='" + adName + "']/../preceding-sibling::td[4]//input[@type='checkbox']"));
            wait.until(ExpectedConditions.visibilityOf(clickCheckBox));
            Waiting.staticWait(2000);
            clickCheckBox.click();


        }

    }






    public String myContentPaginationElements(String pageNo) {
        List<WebElement> elements = driver.findElements(By.xpath("//a[text()='" + pageNo + "']"));
        for (int i = 0; i < elements.size(); i++) {
            elements.get(i).click();
            System.out.println("pages are" +elements.get(i).getText());
        }
        return pageNo;
    }


}

