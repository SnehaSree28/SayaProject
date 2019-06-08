package methods;

import WebDriverIntialization.WebDriverTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SayaTemplatePage;

public class SayaTemplatePageMethods extends SayaTemplatePage {
    WebDriverWait webDriverWait = new WebDriverWait(driver,10);
    public PresenatationManagementMethod goToPresentationMgmtPage(){
        webDriverWait.until(ExpectedConditions.visibilityOf(mysignage));
        mysignage.click();
        myPresentations.click();
        return new PresenatationManagementMethod();
    }
}
