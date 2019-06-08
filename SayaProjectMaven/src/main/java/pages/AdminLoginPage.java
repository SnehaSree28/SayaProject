package pages;

import WebDriverIntialization.WebDriverTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage extends WebDriverTest{
    @FindBy(id="txtUserName")
    public WebElement userName;

    @FindBy(id="txtPassword")
    public WebElement passWord;

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getPassWord() {
        return passWord;
    }

    public WebElement getLogin() {
        return login;
    }

    @FindBy(id="btnLogin")
    public WebElement login;

    public AdminLoginPage(){
        PageFactory.initElements(driver,this);
    }
}
