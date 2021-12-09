package WorkFlows.WebWorkFlows.GrafanaWeb;

import Utilities.CommonOps;
import io.qameta.allure.Step;

public class MainPageWF extends CommonOps {

    @Step("Login - Verify login as user with Admin privilege")
    public static boolean verifyLoginAsAdmin() {
        return grafanaLeftBarPage.getSettingsLogo().isDisplayed();
    }
}
