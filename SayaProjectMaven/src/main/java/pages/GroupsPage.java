package pages;

import WebDriverIntialization.WebDriverTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by lovel on 08-Jun-19.
 */
public class GroupsPage extends WebDriverTest {
    @FindBy(css = "input[name='txtGroupName']")
    public WebElement createGroup;

    @FindBy(css="textarea[name='txtDesc']" )
    public WebElement description;

    @FindBy(id="txtStartDate")
    public WebElement startDate;

    @FindBy(id="txtStartTime")
    public WebElement startTime;

    @FindBy(id="txtEndDate")
    public WebElement endDate;

    @FindBy(id="txtEndTime")
    public WebElement endTime;


    public WebElement getCreateGroup() {
        return createGroup;
    }

    public WebElement getDescription() {
        return description;
    }

    public WebElement getStartDate() {
        return startDate;
    }

    public WebElement getStartTime() {
        return startTime;
    }

    public WebElement getEndDate() {
        return endDate;
    }

    public WebElement getEndTime() {
        return endTime;
    }

   public GroupsPage(){
        PageFactory.initElements(driver, this);
    }



}
