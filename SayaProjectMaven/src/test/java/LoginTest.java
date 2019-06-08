import Utilites.PropertyFileUtil;
import WebDriverIntialization.WebDriverTest;
import common.CommonConstants;
import common.CommonMethods;
import methods.LoginPageMethod;
import methods.PresenatationManagementMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.PresentationManagementPage;
import pages.SayaTemplatePage;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.SplittableRandom;
import java.util.concurrent.TimeUnit;

public class LoginTest extends WebDriverTest{
    LoginPageMethod loginPageMethod ;
    PresentationManagementPage presentationManagementPage=null;
    PresenatationManagementMethod presenatationManagementMethod =null;

    SayaTemplatePage sayaTemplatePage=null;

    @BeforeClass
   public void login(){
    loginPageMethod= new LoginPageMethod();
    loginPageMethod.login(PropertyFileUtil.getValueForKey("portal.username"),PropertyFileUtil.getValueForKey("portal.password"));
    sayaTemplatePage = new SayaTemplatePage();
    sayaTemplatePage.goToPresentationMgmtPage();

}
@Test(description = "To create a presentation")
    public void createPresenation() throws InterruptedException {
presenatationManagementMethod = new PresenatationManagementMethod();
presentationManagementPage = new PresentationManagementPage();
       HashMap<String,String> dataMap= new HashMap<String, String>();
       String pName= "Presentation" + CommonMethods.getCurrentTimeStamp();
    Random random = new Random();
    int Description=random.nextInt();
    String desc=String.valueOf(Description);
       String name= dataMap.put(CommonConstants.PRESENTATIONNAME,pName );
       dataMap.put(CommonConstants.DESCRIPTION,desc+pName );
     dataMap.put(CommonConstants.STARTDATE, CommonMethods.getTodaysDate());
    dataMap.put(CommonConstants.STARTTIME,"00:00:00");
     dataMap.put(CommonConstants.ENDDATE,CommonMethods.getFutureDates(6));
     dataMap.put(CommonConstants.ENDTIME,"23:59:59");
    presenatationManagementMethod.setPresentationFields(dataMap);
boolean presentationValidation=presenatationManagementMethod.validatePresenation(name);
Assert.assertEquals(presentationValidation,"PresenationName is displaying", "Presentation Name is not displayed");
    Assert.assertEquals(presentationManagementPage.statusMsg.getText(),"Presentation created successfully", "Presentation Not created successfully");
}
@Test(description = "To create a slide", dependsOnMethods = {"createPresenation"})
    public void addSlideToPresentation() throws InterruptedException {

        presenatationManagementMethod.addSlideToPresentation();
        presentationManagementPage.addSlide.click();
}

/*@AfterMethod
    public void deletePresentation(){
        pesenatationManagementMethod.deletePresentaton();
}*/

@Test
    public void createPppt() throws InterruptedException {
    PresenatationManagementMethod presenatationManagementMethod = new PresenatationManagementMethod();
    String name=presenatationManagementMethod.createPresentation(CommonConstants.PRESENTATIONNAME+CommonMethods.getCurrentTimeStamp(),
            CommonConstants.DESCRIPTION+CommonMethods.getCurrentTimeStamp(),CommonMethods.getTodaysDate(),
            CommonMethods.getFutureDates(6),"00:00:00","23:59:59");

    boolean presenationvalidation=presenatationManagementMethod.validatePresenation(name);
    Assert.assertTrue(presenationvalidation,"presentation is not displaying");

}
@Test(priority = 0)
    public void login1(){
    System.out.println("Hi");
}


@Test
    public void toolTip(){
        Actions actions = new Actions(driver);

    WebElement delete=driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_rptGobal_ctl01_imgDelete']"));
    actions.moveToElement(delete).build().perform();
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    String title = driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_rptGobal_ctl01_imgDelete']")).getAttribute("title");
    Assert.assertEquals("Delete",title);
}
}