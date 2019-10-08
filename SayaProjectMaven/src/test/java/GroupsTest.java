import Utilites.PropertyFileUtil;
import WebDriverIntialization.WebDriverTest;
import methods.GroupsPageMethod;
import methods.LoginPageMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SayaTemplatePage;

/**
 * Created by lovel on 08-Jun-19.
 */
public class GroupsTest  extends WebDriverTest {
    LoginPageMethod loginPageMethod =null;
    SayaTemplatePage sayaTemplatePage = null;
    GroupsPageMethod groupsPageMethod =null;
    @BeforeClass

    public void launchBrowser(){
        loginPageMethod= new LoginPageMethod();
        loginPageMethod.login(PropertyFileUtil.getValueForKey("portal.username"),PropertyFileUtil.getValueForKey("portal.password"));
        sayaTemplatePage = new SayaTemplatePage();
        sayaTemplatePage.mysignage.click();
        sayaTemplatePage.gotToGroupsPage();
    }


    @Test
    public void createGroup(){
        groupsPageMethod= new GroupsPageMethod();
        groupsPageMethod.createGroup();
    }
}
