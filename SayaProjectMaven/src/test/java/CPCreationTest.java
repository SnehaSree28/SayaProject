import methods.CPCreationMethod;
import org.testng.annotations.Test;
import pages.CPCreation;
import pages.HomePage;

public class CPCreationTest extends TestBase {
    HomePage homePage = null;
    CPCreationMethod cpCreationMethod = null;
    CPCreation cpCreation=null;
//    WebDriverWait wait = new WebDriverWait(driver,10);

    @Test(priority = 1)
    public void createCP() throws InterruptedException {
        homePage = new HomePage();
        cpCreationMethod = new CPCreationMethod();
        cpCreation = new CPCreation();
        cpCreationMethod.addButtonOfCP.click();
       // wait.until(ExpectedConditions.visibilityOf(cpCreation.getFirstName()));
        cpCreationMethod.getFirstName().sendKeys("Sneha");

    }
}




