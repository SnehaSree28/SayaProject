package methods;

import WebDriverIntialization.WebDriverTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

public class LoginPageMethod extends LoginPage {
WebDriverWait wait = new WebDriverWait(driver, 10);
    LoginPage loginPage ;



public void login(String userName, String passWord){

    loginPage= new LoginPage();
//  wait.until(ExpectedConditions.visibilityOf(loginPage.getId()));

    System.out.println("Username" +loginPage.username);
    System.out.println(getUsername());
    getUsername().sendKeys(userName);
    loginPage.getPassword().sendKeys(passWord);
    loginPage.getLogin().click();
}
}
