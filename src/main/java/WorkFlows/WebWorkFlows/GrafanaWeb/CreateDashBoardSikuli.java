package WorkFlows.WebWorkFlows.GrafanaWeb;

import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.sikuli.script.FindFailed;

public class CreateDashBoardSikuli extends CommonOps {

    @Step("WorkFlow: Create dashboard by sikuli")
    public static boolean createDashBoardSikuli() throws FindFailed {

        openAddDashboardMenu();
        clickDashboardCreate();
        AddEmptyPanel();
        SavePanel();
        approveSavePanel();
        return verifyCreate();
    }

    @Step("Open 'add dashboard' menu")
    private static void openAddDashboardMenu() throws FindFailed {
        screen.hover(impPath + "plus.png");
    }

    @Step("Click 'dashboard create' bar")
    private static void clickDashboardCreate() throws FindFailed {
        screen.click(impPath + "dashboard.png");
    }

    @Step("Click add empty panel button ")
    private static void AddEmptyPanel() throws FindFailed {
        screen.click(impPath + "addDash.png");
    }

    @Step("Save panel")
    private static void SavePanel() throws FindFailed {
        screen.click(impPath + "saveDash.png");
    }

    @Step("Click 'Approve save' panel button")
    private static void approveSavePanel() throws FindFailed {
        screen.click(impPath + "approveSave.png");
    }

    @Step("Verify dashboard created")
    private static boolean verifyCreate() {
        if (screen.exists(impPath + "verifyCreate.png").toString().isEmpty()) {
            return false;
        }
        return true;
    }
}
