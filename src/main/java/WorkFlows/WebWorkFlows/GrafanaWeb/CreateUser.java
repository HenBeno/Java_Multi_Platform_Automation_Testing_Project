package WorkFlows.WebWorkFlows.GrafanaWeb;

import Extension.UiAction;
import Utilities.CommonOps;
import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class CreateUser extends CommonOps {

    @Step("WorkFlow: Create users")
    public static void createUser(String name, String email, String userName, String password) {
        navigateToCreateUsrPage();
        startCreateUserBtn();
        insertNewUserDetails(name, email, userName, password);
        finishCreateUserBtn();
    }

    @Step("Create users using DDL")
    public static void createUserByDDL(String name, String email, String userName, String password) {
        createUser(name, email, userName, password);
        softAssert.assertEquals(verifyUserCreated(userName), userName + " is exists", "Test02 fail - User not exists");
    }

    @Step("Navigate to create user page")
    private static void navigateToCreateUsrPage() {
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
        navigateToCreateUsrPage();
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
