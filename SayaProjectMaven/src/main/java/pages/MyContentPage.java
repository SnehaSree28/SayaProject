package pages;

import WebDriverIntialization.WebDriverTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by lovel on 04-Nov-18.
 */
public class MyContentPage extends WebDriverTest {

    @FindBy(xpath = "//*[contains(text(),'My Content')]//parent::a")
    public WebElement clickMyContent;


    @FindBy(xpath = "//*[@class='btn btn-primary']")
    public WebElement createNewContent;

    @FindBy(xpath="(//*[text()='Select Content Type'])[2]")
    public WebElement selectAdType;

    @FindBy(xpath = "(//*[text()='Select Content SubType'])[2]")
    public WebElement selectSubType;

    @FindBy(xpath = "//*[@id='ctl00_ContentPlaceHolder1_txtAdName']")
    public WebElement adName;

    @FindBy(id="ctl00_ContentPlaceHolder1_txtAdDescription")
    public WebElement adDescription;

    @FindBy(id="ctl00_ContentPlaceHolder1_fupImageUpload")
    public WebElement chooseFile;

//    @FindBy(css = ".btn.btn-primary")
    @FindBy(xpath = "//*[@class='btn btn-primary']")
    public WebElement save;

    @FindBy(id="ctl00_ContentPlaceHolder1_AjaxFileUpload1_Html5InputFile")
    public WebElement selectAudioFile;

    @FindBy(id="ctl00_ContentPlaceHolder1_AjaxFileUpload1_UploadOrCancelButton")
    public WebElement uploadAudioFile;

    @FindBy(id="ctl00_ContentPlaceHolder1_txtSearch")
    public WebElement searchAd;

    @FindBy(xpath="//ul[@class='pagination']")
    public WebElement pagination;

    public  MyContentPage(){
        PageFactory.initElements(driver,this);
    }
}
