package WorkFlows.WebWorkFlows.GrafanaWeb;

import Extension.UiAction;
import Utilities.CommonOps;
import Utilities.ExternalFilesManager;
import io.qameta.allure.Step;

public class LogInWF extends CommonOps {

    @Step("WorkFlow: Login")
    public static void logInWF() {
        insertLoginDetails();
        loginBtnClick();
        skipClick();
    }

    @Step("WorkFlow: Login")
    public static void logInWF(String userName, String password) {
        insertLoginDetails(userName, password);
        loginBtnClick();
    }

    @Step("Login - Insert user name and password")
    private static void insertLoginDetails(String userName, String password) {
        UiAction.sendKeys(grafanaLoginPage.getUserNameInputField(), userName);
        UiAction.sendKeys(grafanaLoginPage.getPasswordInputField(), password);
    }

    @Step("Login - Insert user name and password")
    private static void insertLoginDetails() {
        UiAction.sendKeys(grafanaLoginPage.getUserNameInputField(), ExternalFilesManager.getData("UserName"));
        UiAction.sendKeys(grafanaLoginPage.getPasswordInputField(), ExternalFilesManager.getData("Password"));
    }

    @Step("Login - Click login button")
    private static void loginBtnClick() {
        UiAction.click(grafanaLoginPage.getLogInBtn());
    }

    @Step("Login - Click skip change password button")
    private static void skipClick() {
        UiAction.click(grafanaLoginPage.getSkipChangePasswordBtn());
    }


}
