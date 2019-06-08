import Utilites.PropertyFileUtil;
import WebDriverIntialization.WebDriverTest;
import common.Waiting;
import enums.Districts;
import enums.States;
import methods.IncoisAppsMethod;
import methods.LoginPageMethod;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SayaTemplatePage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lovel on 08-Oct-18.
 */
public class IncoisAppsTest extends WebDriverTest {
    LoginPageMethod loginPageMethod;
    SayaTemplatePage sayaTemplatePage=null;
    IncoisAppsMethod incoisAppsMethod = null;

    @BeforeClass
    public void login(){
     loginPageMethod = new LoginPageMethod();
        incoisAppsMethod= new IncoisAppsMethod();

        loginPageMethod.login(PropertyFileUtil.getValueForKey("portal.username"),PropertyFileUtil.getValueForKey("portal.password"));
     sayaTemplatePage = new SayaTemplatePage();
     sayaTemplatePage.goToIncoisAppsPage();

    }
    @Test(description="To select the group and search for the group")
    public void selectGroup() throws InterruptedException {
        List<WebElement> e=  incoisAppsMethod.selectGroupIncois();
        e.get(1).click();
        Thread.sleep(2000);
        incoisAppsMethod.searchGroup();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(incoisAppsMethod.potentialFishingZone.isDisplayed(),incoisAppsMethod.tunaFishing.isDisplayed(),"Services are not displayed");
        softAssert.assertAll();
        System.out.println("Software assert has executed");
    }

    @Test(priority=1,dependsOnMethods = {"selectGroup"})
    public void sliderPfz(){
        incoisAppsMethod.sliderPfz(10);
        Waiting.staticWait(3000);
       /*List<String> sl=  new ArrayList<String>();
       sl.add("English");
       sl.add("Tamil");
       sl.add("Oriya");
       incoisAppsMethod.pfzSelectAOI(sl);*/
       Waiting.staticWait(3000);
       List<String> sl= new ArrayList<String>();
       sl.add("Hindi");
       sl.add("Tamil");
       sl.add("Telugu");
       incoisAppsMethod.uncheckCheckBoxes(sl);
      /* incoisAppsMethod.submit.click();
       Waiting.staticWait(2000);
       driver.switchTo().alert().accept();
       Waiting.staticWait(2000);
       Assert.assertTrue(incoisAppsMethod.potentialFishingZone.isDisplayed()&& incoisAppsMethod.tunaFishing.isDisplayed()&&incoisAppsMethod.tsunamiEarlyWarning.isDisplayed(),"Services are not enabled");*/
       //Assert.assertEquals();
    }

    @Test()
    public void pfzMultipleStates() throws InterruptedException {
        selectGroup();
        sliderPfz();
        List<States> states = new ArrayList<>();
        states.add(States.KERALA);
        states.add(States.NORTHANDHRAPRADESH);
        List<Districts> districtss= new ArrayList<>();
        districtss.add(Districts.EASTGODAVARI);
        districtss.add(Districts.SRIKAKULAM);
        incoisAppsMethod.pfzMultipleStatesMethod(states,districtss);
    }
    }
