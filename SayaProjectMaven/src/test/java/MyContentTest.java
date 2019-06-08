import Utilites.PropertyFileUtil;
import WebDriverIntialization.WebDriverTest;
import common.CommonConstants;
import common.CommonJavaScriptMethods;
import common.CommonMethods;
import common.Waiting;
import enums.AdSubType;
import enums.AdType;
import enums.BannerAds;
import enums.PaginationValues;
import methods.IncoisAppsMethod;
import methods.LoginPageMethod;
import methods.MyContentPageMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SayaTemplatePage;

import javax.tools.JavaCompiler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static enums.AdType.AudioAds;

/**
 * Created by lovel on 04-Nov-18.
 */
public class MyContentTest extends WebDriverTest {
    LoginPageMethod loginPageMethod;
    SayaTemplatePage sayaTemplatePage = null;
    IncoisAppsMethod incoisAppsMethod = null;
    MyContentPageMethod myContentPageMethod = null;

    @BeforeClass
    public void login() {
        loginPageMethod = new LoginPageMethod();
        incoisAppsMethod = new IncoisAppsMethod();
        loginPageMethod.login(PropertyFileUtil.getValueForKey("portal.username"), PropertyFileUtil.getValueForKey("portal.password"));
        sayaTemplatePage = new SayaTemplatePage();
        sayaTemplatePage.goToMyContentPageMethod();
    }

    @Test(description = "To verify all adtypes are displaying or not")
    public void clickMyContent() {
        myContentPageMethod = new MyContentPageMethod();
        myContentPageMethod.clickCreateContent();
        Waiting.staticWait(2000);
        myContentPageMethod.selectAdType.click();
        for (AdType adType : AdType.values()) {
            Waiting.staticWait(5000);
            // myContentPageMethod.selectAdType.click();
            myContentPageMethod.clickCreateContent();
            Select select = new Select(myContentPageMethod.selectAdType);
            select.selectByVisibleText(adType.toString());
            WebElement subAdTypes = myContentPageMethod.selectSubType;
            List<WebElement> adsubTypes = subAdTypes.findElements(By.xpath(".//option"));
            for (int i = 0; i < adsubTypes.size(); i++) {
                if (adType.toString().equalsIgnoreCase(AudioAds.toString())) ;
                Assert.assertEquals(adsubTypes.size(), AdSubType.values().length);
            }
        }
    }


    @Test(description = "To create Banner Ads")
    public void createBannerAd() {
        myContentPageMethod = new MyContentPageMethod();
        myContentPageMethod.createNewContent();
        Waiting.staticWait(2000);
        myContentPageMethod.selectAdType.click();
        Waiting.staticWait(3000);
        for (AdType adType : AdType.values()) {
            if (adType.toString().equalsIgnoreCase(AdType.BannerAds.toString())) {


            }
        }
    }

    public boolean elementsVisibleOrNot(String element) {
        boolean x = driver.findElement(By.xpath("(//*[text()='" + element + "'])[2]")).isDisplayed();
        return x;
    }

    @Test
    public void test() {

    }

    @Test(description = "To create Ads")
    public void createAds() {
        myContentPageMethod = new MyContentPageMethod();
        //  myContentPageMethod.createNewContent();
        Waiting.staticWait(2000);
        myContentPageMethod.clickCreateContent();
        //     for (int i = 0; i < AdType.values().length; i++) {
        Waiting.staticWait(3000);
        for (AdType adType : AdType.values()) {
            myContentPageMethod.clickCreateContent();
            myContentPageMethod.selectAdType();
            switch (adType) {
                case AudioAds:
                    Waiting.staticWait(3000);
                    myContentPageMethod.clickElements(adType.toString());
                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                    myContentPageMethod.enterTextAndDescOfAudioAds();
                    break;
                case BannerAds:
                    if (adType.toString().equalsIgnoreCase(AdType.BannerAds.toString())) {
                        myContentPageMethod.clickElements(adType.toString());
//                            myContentPageMethod.selectAdType.click();
                        Waiting.staticWait(2000);
                        myContentPageMethod.selectSubType.click();
                        for (BannerAds bannerAds : BannerAds.values()) {
                            if (bannerAds.toString().equalsIgnoreCase(BannerAds.HorizontalBanner.toString())) {
                                myContentPageMethod.clickElements(bannerAds.toString());
                                myContentPageMethod.enterTextAndDescriptionOfAdTypes(CommonMethods.getCurrentTimeStamp());
                            }
                            if (bannerAds.toString().equalsIgnoreCase(BannerAds.VerticalBanner.toString())) {
                                myContentPageMethod.clickElements(bannerAds.toString());
                                String adTypeName = myContentPageMethod.enterTextAndDescriptionOfAdTypes("BannerAds" + CommonMethods.getCurrentTimeStamp());

                            }
                        }
                    }
            }
        }
    }

    @Test
    public void createAdsNewMethod() {
        MyContentPageMethod myContentPageMethod = new MyContentPageMethod();
        Map<AdType, List<AdSubType>> adSubAdType = new HashMap<>();
            /*Banner Ads*/
        List<AdSubType> adSubTypeBannerAds = new ArrayList<>();
        adSubTypeBannerAds.add(AdSubType.HorizontalBannner);
        adSubTypeBannerAds.add(AdSubType.VerticalBanner);
        adSubAdType.put(AdType.BannerAds, adSubTypeBannerAds);
            /*Bug Ads*/
        List<AdSubType> adSubTypeBugAds = new ArrayList<>();
        adSubTypeBugAds.add(AdSubType.BouncingBug);
        adSubTypeBugAds.add(AdSubType.FlyingBug);
        adSubTypeBugAds.add(AdSubType.BoxBug);
        adSubAdType.put(AdType.BugAds, adSubTypeBugAds);
            /*Lbar Ads*/
        List<AdSubType> adSubTypeLbarAds = new ArrayList<>();
        adSubTypeLbarAds.add(AdSubType.AnimatingLBar);
        adSubTypeLbarAds.add(AdSubType.StaticLbar);
        adSubAdType.put(AdType.LbarAds, adSubTypeLbarAds);
        for (AdType adType : adSubAdType.keySet()) {
            List<AdSubType> adSubTypes = adSubAdType.get(adType);
            for (AdSubType adSubType : adSubTypes) {
                myContentPageMethod.clickCreateContent();
                Waiting.staticWait(2000);
                myContentPageMethod.selectAdType();
                myContentPageMethod.clickElements(adType.toString());
                Waiting.staticWait(2000);
                myContentPageMethod.selectSubType.click();
                myContentPageMethod.clickElements(adSubType.toString());
                String adTypeName = myContentPageMethod.enterTextAndDescriptionOfAdTypes("AdType" + CommonMethods.getCurrentTimeStamp());
                Assert.assertTrue(myContentPageMethod.searchAd(adTypeName), "Element not found");
            }
        }
    }

//}

    @Test

    public void pagination() {
        MyContentPageMethod myContentPageMethod = new MyContentPageMethod();
        Waiting.staticWait(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)");
        for (PaginationValues paginationValues : PaginationValues.values()) {
            Waiting.staticWait(1000);
            String pageNo = myContentPageMethod.clickPages(paginationValues.toString());
            if (paginationValues.toString() == pageNo) {
                myContentPageMethod.paginationElement("AdType011218182526");
            }
        }
    }


    @Test
    public void paginationTest() {
        MyContentPageMethod myContentPageMethod = new MyContentPageMethod();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,90)");
        for (PaginationValues paginationValues : PaginationValues.values()) {
            String pageNo = myContentPageMethod.myContentPaginationElements(paginationValues.toString());
            if (paginationValues.toString() == pageNo) {
                WebElement table = driver.findElement(By.xpath("//table[@class='table table-bordered']//tbody"));
                List<WebElement> rows=table.findElements(By.tagName("tr"));
                int rowCount=rows.size();
                for(int i =0; i < rowCount; i++){
                    try{
                        Waiting.staticWait(3000);
                        List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
                        int columnCOunt=columns.size();
                            for(int j=0;j <columnCOunt;j++){
                                String cellText=columns.get(j).getText();
                                if(cellText.equalsIgnoreCase("AdType011218193145")){
                                    myContentPageMethod.paginationElement("AdType011218193145");
                                    break;
                                }
                    }
                    }catch (StaleElementReferenceException e){
                        e.printStackTrace();
                    }
                }

            }
        }
        // driver.findElements()
        //myContentPageMethod.clickPages()
    }

    @Test
    public void test1(){
        MyContentPageMethod myContentPageMethod= new MyContentPageMethod();
        for(PaginationValues paginationValues: PaginationValues.values()){
            myContentPageMethod.myContentPaginationElements(paginationValues.toString());
            CommonJavaScriptMethods.scrollDown("0,150");

        }
    }

    @Test
    public void iteratingTableContent(){
        myContentPageMethod = new MyContentPageMethod();
        CommonJavaScriptMethods.scrollDown("0,100");
        WebElement table = driver.findElement(By.xpath("//table[@class='table table-bordered']//tbody"));
        List<WebElement> rows=table.findElements(By.tagName("tr"));
        int rowCount=rows.size();
        for(int i =0; i < rowCount; i++){
            List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
            int columnCOunt=columns.size();
            for(int j=0;j <columnCOunt;j++){
                              String cellText=columns.get(j).getText();
                            if(cellText.equalsIgnoreCase("bo")){
                               myContentPageMethod.paginationElement("bo");

                }
            }
        }
    }

}





