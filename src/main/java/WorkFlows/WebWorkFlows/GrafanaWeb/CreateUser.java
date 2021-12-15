package WorkFlows.WebWorkFlows.GrafanaWeb;

import Extension.UiAction;
import Utilities.CommonOps;
import Utilities.ExternalFilesManager;
import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class CreateUser extends CommonOps {

    @Step("WorkFlow: Create users")
    public static void createUser(String name, String email, String userName, String password) {
        navigateToCreateUserPage();
        startCreateUserBtn();
        insertNewUserDetails(name, email, userName, password);
        finishCreateUserBtn();
    }

    @Step("WorkFlow: Before Class Create users")
    public static void createUserBeforeClass() {
        createUser(ExternalFilesManager.getData("CreateBasicName"),
                ExternalFilesManager.getData("CreateBasicEmail"),
                ExternalFilesManager.getData("CreateBasicUserName"),
                ExternalFilesManager.getData("CreateBasicPassword"));
    }

    @Step("Create users using DDL")
    public static void createUserByDDL(String name, String email, String userName, String password) {
        createUser(name, email, userName, password);
        softAssert.assertEquals(verifyUserCreated(userName), userName + " is exists", "Test02 fail - User not exists");
    }

    @Step("Navigate to 'create user' page")
    private static void navigateToCreateUserPage() {
        UiAction.elementHoverAndElementClick(actions, grafanaLeftBarPage.getShieldLogo(), grafanaLeftBarPage.getShieldUsers());
    }

    @Step("Click the 'NewUser' button")
    private static void startCreateUserBtn() {
        UiAction.click(grafanaCreateUserPage.getNewUserBtn());
    }

    @Step("Insert new user details")
    private static void insertNewUserDetails(String name, String email, String userName, String password) {
        UiAction.sendKeys(grafanaCreateUserPage.getName_txt(), name);
        UiAction.sendKeys(grafanaCreateUserPage.getEmail_txt(), email);
        UiAction.sendKeys(grafanaCreateUserPage.getUserName_txt(), userName);
        UiAction.sendKeys(grafanaCreateUserPage.getPassword_txt(), password);
    }

    @Step("Click the 'CreateUser' button")
    private static void finishCreateUserBtn() {
        UiAction.click(grafanaCreateUserPage.getCreateUserBtn());
    }

    @Step("Verify user is successfully created")
    public static String verifyUserCreated(String userName) {
        navigateToCreateUserPage();
        UiAction.sendKeys(grafanaCreateUserPage.getSearchInput(), userName);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

        for (WebElement userNameLop : grafanaCreateUserPage.getSearchResult()) {
            if (userNameLop.getText().equals(userName)) {
                return userName + " is exists";
            }
        }
        return userName + " is not exists";
    }
}
