package pages;

import WebDriverIntialization.WebDriverTest;
import common.CommonConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

public class PresentationManagementPage extends SayaTemplatePage {

    @FindBy(id="txtPresName")
  //  @FindBy(xpath="//input[@placeholder='Create New Presentation']")
    public WebElement presentationName;
    @FindBy(id="txtPresDesc")
    //@FindBy(xpath = "//input[@placeholder='Description']")
    public WebElement description;
    @FindBy(id="StartDateTime")
    public WebElement startDate;
    @FindBy(id="EndDateTime")
    public WebElement endDate;
    @FindBy(id="txtDayStartTime")
    public WebElement startTime;
    @FindBy(id = "txtDayEndTime")
    public WebElement endTime;
    @FindBy(id="ctl00_ContentPlaceHolder1_rptGobal_ctl00_btnSavePresentation")
    public WebElement save;
   // @FindBy(xpath = "//*[text()='Presentation created successfully']")
    @FindBy(id="lblErrMsg")
    public WebElement statusMsg;


    @FindBy(id="ctl00_ContentPlaceHolder1_rptGobal_ctl01_imgBtnSlides1")
    public WebElement firstAddButtonOfSlide;

    @FindBy(xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_rptGobal_ctl01_Slides\"]/descendant::div/img[1]")
    public WebElement secondAddButtonOfSlide;

    @FindBy(id="dvOpenSlideLibrary")
    public WebElement slideLibrary;

    @FindBy(id="slideImage")
    public WebElement selectionOfSlides;

    @FindBy(id="ctl00_ContentPlaceHolder1_rptGobal_ctl01_imgDelete")
    public WebElement deletePresentation;
    @FindBy(xpath="//*[@value='Add Slide']")
    public WebElement addSlide;
    @FindBy(xpath = "//*[text()='Slide added successfully']")
    public WebElement statusMsgSlideAddedSuccessfully;

    WebDriverWait wait= new WebDriverWait(driver,10);

public PresentationManagementPage(){
    PageFactory.initElements(driver,this);
}
    }
    
