import Utilites.PropertyFileUtil;
import WebDriverIntialization.WebDriverTest;
import methods.LoginPageMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AffliateManagementPage;

public class AffliateTest extends WebDriverTest {
    LoginPageMethod loginPageMethod;
    @BeforeClass
    public void login(){
        loginPageMethod= new LoginPageMethod();
        loginPageMethod.login(PropertyFileUtil.getValueForKey("portal.username"),PropertyFileUtil.getValueForKey("portal.password"));
    }
    @Test
    public void createAffiliate() throws InterruptedException {

        AffliateManagementPage affiliate = new AffliateManagementPage();
        affiliate.clickAffiliateManagement();
//         WebDriverWait wait = new WebDriverWait(driver, 500);
//        affiliate.clickCreateAfiiliate();
//        wait.until(ExpectedConditions.visibilityOf(affiliate.fname));
//        affiliate.firstName("Chandiniii");
//        affiliate.lastName("Prathapaneniii");
//        affiliate.countryName("India");
//        affiliate.stateName("Andhra Pradesh");
//        affiliate.districtName("Visakhapatnam");
//        affiliate.mandalName("Visakhapatnam");
//        affiliate.locationName("Seethammapeta ");
//        affiliate.addressDetails("chittoor");
//        affiliate.postalCode("517126");
//        affiliate.emailAddress("chandini@gmail.com");
//        affiliate.mobileNumber("1234567890");
//        affiliate.organizationName("abc");
//        affiliate.userName("abcdef@123");
//        affiliate.password("abcdef@123");
//        affiliate.saveButton();
        affiliate.affiliateTable();
        System.out.println("Contents Viewed successfully");
    }
}