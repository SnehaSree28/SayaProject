package methods;

import WebDriverIntialization.WebDriverTest;
import common.CommonConstants;
import common.CommonMethods;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import pages.PresentationManagementPage;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class PresenatationManagementMethod extends PresentationManagementPage {
    Logger logger = Logger.getLogger(PresenatationManagementMethod.class.getName());
    WebDriverWait wait = new WebDriverWait(driver, 20);
    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
    PresentationManagementPage presentationManagementPage = new PresentationManagementPage();

    public String setPresentationFields(HashMap<String, String> dataMap) throws InterruptedException {
        //wait.until(ExpectedConditions.visibilityOf(presentationName));
        presentationName.sendKeys(dataMap.get(CommonConstants.PRESENTATIONNAME));
        String name = presentationName.getAttribute("value");
        System.out.println("presentation name is " + name);
        wait.until(ExpectedConditions.visibilityOf(description));
        description.sendKeys(dataMap.get(CommonConstants.DESCRIPTION));
        startDate.sendKeys(dataMap.get(CommonConstants.STARTDATE));
        logger.info("Start time");
        wait.until(ExpectedConditions.visibilityOf(startTime));
        javascriptExecutor.executeScript("arguments[0].value=\'" + dataMap.get(CommonConstants.STARTTIME) + "\';", startTime);
        startTime.sendKeys(dataMap.get(CommonConstants.STARTTIME));
        wait.until(ExpectedConditions.visibilityOf(endTime));
        endDate.sendKeys(dataMap.get(CommonConstants.ENDDATE));
        javascriptExecutor.executeScript("arguments[0].value=\'" + dataMap.get(CommonConstants.ENDTIME) + "\';", endTime);
        wait.until(ExpectedConditions.visibilityOf(save));
        save.click();
        Thread.sleep(5000);
        return name;
    }


    //    Wait wait = new FluentWait(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(5,TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

       /* String statusMsg= presentationManagementPage.statusMsg.getText();
    return statusMsg;*/


    public void addSlideToPresentation() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(presentationManagementPage.firstAddButtonOfSlide));
        presentationManagementPage.firstAddButtonOfSlide.click();
        wait.until(ExpectedConditions.visibilityOf(presentationManagementPage.secondAddButtonOfSlide));
        secondAddButtonOfSlide.click();
        List<WebElement> addingSlides = driver.findElements(By.xpath("//*[@id='slideName']"));
        Thread.sleep(5000);
//        wait.until(ExpectedConditions.visibilityOf((WebElement) addingSlides));
       /* for(WebElement slideNames:addingSlides){
            System.out.println("SlideNames are " +slideNames.getText());
        }*/
        for (int i = 0; i < addingSlides.size(); i++) {
            if (i == 0) {
                addingSlides.get(i).click();
            }
            break;
        }


    }

    public void deletePresentaton() {
        presentationManagementPage.deletePresentation.click();
        driver.switchTo().alert().accept();

    }

    public String createPresentation(String pName, String desc, String sDate, String eDate, String sTime, String eTime) throws InterruptedException {
        presentationName.sendKeys(pName);
        String name = presentationName.getAttribute("value");
        description.sendKeys(desc);
        startDate.sendKeys(sDate);
        Thread.sleep(5000);
        javascriptExecutor.executeScript("arguments[0].value='" + sTime + "'", startTime);
        Thread.sleep(2000);
        endDate.sendKeys(eDate);
        Thread.sleep(5000);
        javascriptExecutor.executeScript("arguments[0].value='" + eTime + "';", endTime);
        endDate.sendKeys(eDate);
        wait.until(ExpectedConditions.visibilityOf(save));
        save.click();
        Thread.sleep(5000);

        return name;
    }
public boolean validatePresenation(String name)
{
   WebElement element=driver.findElement(By.xpath("//*[@title='"+name+"']"));
   boolean status=element.isDisplayed();
   return status;

}
}