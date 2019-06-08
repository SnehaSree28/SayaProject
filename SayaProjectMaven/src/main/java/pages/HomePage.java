package pages;

import WebDriverIntialization.WebDriverTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends WebDriverTest {
    @FindBy(id="ctl00_ContentPlaceHolder1_imgNewAdvertiser")
    public WebElement addButtonOfCP;


    @FindBy(id="ctl00_Signage")
    public WebElement MySignage;

    public HomePage(){

        PageFactory.initElements(driver,this);
    }
    public WebElement getAddButtonOfCP(){
        return addButtonOfCP;
    }
}
