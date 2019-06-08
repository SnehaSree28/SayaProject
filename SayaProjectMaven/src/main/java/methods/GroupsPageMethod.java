package methods;

import common.CommonConstants;
import common.CommonMethods;
import pages.GroupsPage;

/**
 * Created by lovel on 08-Jun-19.
 */
public class GroupsPageMethod extends GroupsPage {
    public void createGroup(){
        getCreateGroup().sendKeys(CommonMethods.randomChar()+CommonMethods.getCurrentTimeStamp());
        getDescription().sendKeys(CommonMethods.randomChar()+CommonMethods.getCurrentTimeStamp());
        getStartDate().sendKeys(CommonMethods.getCurrentTimeStamp());

    }
}
