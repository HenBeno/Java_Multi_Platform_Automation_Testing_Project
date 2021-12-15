import Utilities.AutoListeners;
import Utilities.CommonOps;
import Utilities.DataDrivenTestingManager;
import WorkFlows.WebWorkFlows.GrafanaWeb.CreateDashBoardSikuli;
import WorkFlows.WebWorkFlows.GrafanaWeb.CreateUser;
import WorkFlows.WebWorkFlows.GrafanaWeb.DeleteUser;
import WorkFlows.WebWorkFlows.GrafanaWeb.MainPageWF;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static WorkFlows.WebWorkFlows.GrafanaWeb.LoginByDataBase.verifyLoginDB;


public class GrafanaWebTests extends CommonOps {

    @Test(description = "Verify login as user with Admin privilege")
    public void test01_VerifyAdminPrivilege() {
        Assert.assertTrue(MainPageWF.verifyLoginAsAdmin(), "Test01 fail - not login as user with Admin privilege");
    }

    @Test(description = "Verify user exists by UserName")
    public void test02_VerifyUserExistsByUserName() {
        Assert.assertEquals(CreateUser.verifyUserCreated("HenB"), "HenB is exists", "Test02 fail - User does not exist");
    }

    @Test(dataProvider = "data-provider", description = "Create new users by DDT", dataProviderClass = DataDrivenTestingManager.class)
    public void test03_createNewUser(String name, String email, String userName, String password) {
        CreateUser.createUserByDDL(name, email, userName, password);
        softAssert.assertAll("Test3 fail");
    }

    @Test(description = "Verify login details in data Base")
    public void test04_VerifyAllUsersDelete() {
        verifyLoginDB();
        softAssert.assertAll();
    }

    @Test(description = "Verify all users are deleted")
    public void test05_VerifyAllUsersDelete() {
        Assert.assertFalse(DeleteUser.deleteAllUsers(), "Test04 fail - Not all users have been deleted");
    }

    @Test(description = "Create dashboard by sikuli")
    public void test6_VerifyDashboardCreated() throws FindFailed {
        Assert.assertTrue(CreateDashBoardSikuli.createDashBoardSikuli(), "DashBoard fail to create");
    }

}
