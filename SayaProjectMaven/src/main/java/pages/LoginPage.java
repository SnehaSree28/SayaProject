package pages;

import WebDriverIntialization.WebDriverTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends WebDriverTest  {
    @FindBy(xpath="//*[@id='txtActorUserName']")
 public WebElement username;

  public WebElement getUsername() {
        return username;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLogin() {
        return login;
    }

    @FindBy(id="txtActorPassword")
    public WebElement password;
    @FindBy(id="btnLogin")
    public WebElement login;


    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

}
