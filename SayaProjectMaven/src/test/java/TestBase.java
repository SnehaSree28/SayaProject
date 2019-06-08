import Utilites.PropertyFileUtil;
import WebDriverIntialization.WebDriverTest;
import methods.AdminLoginPageMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestBase extends WebDriverTest {

    AdminLoginPageMethod adminLoginPageMethod =null;
    @BeforeClass
    public void adminLogin() throws InterruptedException {
        adminLoginPageMethod = new AdminLoginPageMethod();
        adminLoginPageMethod.adminLogin(PropertyFileUtil.getValueForKey("admin.username"),PropertyFileUtil.getValueForKey("admin.password"));
    }


    }

