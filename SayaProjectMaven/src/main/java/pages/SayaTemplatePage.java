package pages;

import WebDriverIntialization.WebDriverTest;
import methods.IncoisAppsMethod;
import methods.MyContentPageMethod;
import methods.PresenatationManagementMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SayaTemplatePage extends WebDriverTest {
    @FindBy(id = "ctl00_Signage")
    public WebElement mysignage;

    @FindBy(xpath = "//*[text()=' My Presentations']")
    public WebElement myPresentations;

    @FindBy(xpath = "//a[contains(text(),'IncoisApps')]")
    public WebElement incoisApps;

    @FindBy(xpath = "//*[contains(text(),'My Content')]//parent::a")
    public WebElement clickMyContent;

    @FindBy(xpath = "//span[contains(text(),'My Displays')]")
    public WebElement myDisplays;


    WebDriverWait webDriverWait = new WebDriverWait(driver, 10);

    public SayaTemplatePage() {
        PageFactory.initElements(driver, this);

    }


    public PresenatationManagementMethod goToPresentationMgmtPage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(mysignage));
        mysignage.click();
        myPresentations.click();
        return new PresenatationManagementMethod();

    }
    public IncoisAppsMethod goToIncoisAppsPage(){
        webDriverWait.until(ExpectedConditions.visibilityOf(mysignage));
        mysignage.click();
        incoisApps.click();
        return new IncoisAppsMethod();
    }
    public MyContentPageMethod goToMyContentPageMethod(){
        webDriverWait.until(ExpectedConditions.visibilityOf(clickMyContent));
        clickMyContent.click();
        return new MyContentPageMethod();
    }
    public GroupsPage gotToGroupsPage()
    {
        webDriverWait.until(ExpectedConditions.visibilityOf(mysignage));
        Actions actions = new Actions(driver);
        actions.moveToElement(myDisplays).build().perform();
        return new GroupsPage();
    }

}