package WorkFlows.WebWorkFlows.GrafanaWeb;

import Extension.UiAction;
import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;

import static Utilities.DataBaseManager.getLoginDetails;
import static WorkFlows.WebWorkFlows.GrafanaWeb.LogInWF.logInWF;

public class LoginByDataBase extends CommonOps {

    @Step("WorkFlow: Login using DB")
    public static void verifyLoginDB() {
        getLoginDetails();
        logOut();
        initSoftAssert();
        logInFromDB();
    }

    @Step("Logout")
    public static void logOut() {
        actions = new Actions(driver);
        UiAction.elementHoverAndElementClick(actions, grafanaLeftBarPage.getAvatarLogo(), grafanaLeftBarPage.getAvatarLogOut());
    }

    @Step("Login all users in database")
    public static void logInFromDB() {
        int i = 0;
        while (i < listOfUsersFromDB.size()) {
            logInWF(listOfUsersFromDB.get(i), listOfPasswordFromDB.get(i));
            verifyUserConnected(listOfUsersFromDB.get(i), listOfNamesFromDB.get(i++));
            logOut();
        }
        logInWF();
    }

    @Step("Verify user connected")
    private static void verifyUserConnected(String userName, String name) {
        UiAction.elementHover(actions, grafanaLeftBarPage.getAvatarLogo());
        softAssert.assertEquals(grafanaLeftBarPage.getAvatarUserName().getText(), name);
    }
}
