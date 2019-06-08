package methods;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages.AdminLoginPage;
import sun.awt.windows.ThemeReader;

public class AdminLoginPageMethod extends AdminLoginPage {
    AdminLoginPage adminLoginPage ;
   WebDriverWait wait = new WebDriverWait(driver,10);


    public void adminLogin(String userName, String pwd) throws InterruptedException {
        adminLoginPage= new AdminLoginPage();
        System.out.println("Admin username "+adminLoginPage.userName);

        wait.until(ExpectedConditions.visibilityOf(adminLoginPage.userName));
        adminLoginPage.getUserName().sendKeys(userName);
        adminLoginPage.getPassWord().sendKeys(pwd);
        wait.until(ExpectedConditions.visibilityOf(adminLoginPage.login));
      //  Thread.sleep(1000);
        adminLoginPage.getLogin().click();

    }

}
