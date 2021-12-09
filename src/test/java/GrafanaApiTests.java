import Utilities.AutoListeners;
import Utilities.CommonOps;
import Utilities.ExternalFilesManager;
import WorkFlows.ApiWorkFlows.ApiCreateUser;
import WorkFlows.ApiWorkFlows.ApiDeleteUser;
import WorkFlows.ApiWorkFlows.ApiFindUserById;
import WorkFlows.ApiWorkFlows.ApiUpdateUserInfoById;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AutoListeners.class)
public class GrafanaApiTests extends CommonOps {

    @Test(description = "Verify create user using api")
    public void test01_VerifyCreateUserApi() {
        Assert.assertEquals(ApiCreateUser.createUser("ApiUser", "ApiUser@gmail.com", "ApiUserA", "12481"),
                ExternalFilesManager.getData("ExpectedCleanResponse"));
        ApiDeleteUser.deleteUserById(saveLastId);
    }

    @Test(description = "Verify find user by id using api")
    public void test02_VerifyFindUserByIdApi() {

        Assert.assertEquals(ApiFindUserById.findUserById("1"),
                ExternalFilesManager.getData("ExpectedUserById"));
    }

    @Test(description = "Verify update user name and email by id using api")
    public void test03_VerifyUpdateUserInfoById() {
        ApiCreateUser.createUser("Test03TempUser", "Test03TempUser@gmail.com", "Test03TempUser", "12481");
        Assert.assertEquals(ApiUpdateUserInfoById.updateUserInfoById(saveLastId, "UpdateUser@gmail.com"
                , "UpdateUser"), ExternalFilesManager.getData("ExpectedUpdateUserById"));
        ApiDeleteUser.deleteUserById(saveLastId);
    }

    @Test(description = "Verify delete user by id using api")
    public void test03_VerifyDeleteUserById() {
        ApiCreateUser.createUser("Test04TempUser", "Test04TempUser@gmail.com", "Test04TempUser", "12481");
        Assert.assertEquals(ApiDeleteUser.deleteUserById(saveLastId), ExternalFilesManager.getData("ExpectedCodeResult"));
    }

}
