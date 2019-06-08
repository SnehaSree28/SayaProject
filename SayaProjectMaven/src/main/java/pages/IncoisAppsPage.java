package pages;

import WebDriverIntialization.WebDriverTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by lovel on 09-Oct-18.
 */
public class IncoisAppsPage extends WebDriverTest{
    @FindBy(id="ctl00_ContentPlaceHolder1_ddlGroup")
    public WebElement selectGroup;

    @FindBy(id="ctl00_ContentPlaceHolder1_btnSearch")
    public WebElement searchGroup;

    @FindBy(xpath="//*[text()='Potential Fishing']")
    public WebElement potentialFishingZone;

    @FindBy(xpath = "//*[text()='Tuna Fishing']")
    public WebElement tunaFishing;

    @FindBy(xpath = "//*[text()='Ocean State Forecast']")
    public WebElement oceanStateForecast;

    @FindBy(xpath="//*[text()='HighWave Alert']")
    public WebElement highWaveAlert;

    @FindBy(xpath = "//*[text()='Tsunami Early Warning']")
    public WebElement tsunamiEarlyWarning;

    @FindBy(xpath = "//*[text()='Tsunami Early Warning']")
    public WebElement stormSurgeAlert;

    @FindBy(id="sliderPfz")
    public WebElement sliderPfz;

    @FindBy(id="ctl00_ContentPlaceHolder1_txtLanguagepfz")
    public WebElement showInPFz;

    @FindBy(id="ctl00_ContentPlaceHolder1_chkAOIPfz")
    public WebElement checkAOI;

    @FindBy(id="pfzrange")
    public WebElement pfzRange;

    @FindBy(xpath="//*[@value='Submit']")
    public WebElement submit;

    @FindBy(id="ctl00_ContentPlaceHolder1_ddlPfzStates")
    public WebElement pfzMultipleStates;

    @FindBy(id="//*[@id='ctl00_ContentPlaceHolder1_ddlPfzDist']")
    public WebElement pfzMultipleDistricts;

    public IncoisAppsPage(){
        PageFactory.initElements(driver, this);
    }


}
