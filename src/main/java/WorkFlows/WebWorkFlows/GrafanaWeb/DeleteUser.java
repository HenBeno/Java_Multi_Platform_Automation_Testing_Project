package WorkFlows.WebWorkFlows.GrafanaWeb;

import Extension.UiAction;
import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class DeleteUser extends CommonOps {

    @Step("Delete user by user name workflow")
    public static void deleteUserByName(String userName) {
        navigateToDeleteUsrPage();
        userToDelete(userName);
        approveDelete();
        verifyUserDeleted(userName);
    }

    @Step("Delete all users workflow")
    public static boolean deleteAllUsers() {
        navigateToDeleteUsrPage();
        deleteAllListOfUsers();
        return verifyAllUserDeleted();
    }

    @Step("Navigate to delete user page")
    public static void navigateToDeleteUsrPage() {
        UiAction.elementHoverAndElementClick(actions, grafanaLeftBarPage.getSettingsLogo(), grafanaLeftBarPage.getSettingsUsers());
    }

    @Step("Search for user to delete")
    private static void userToDelete(String userName) {
        for (int i = 0; i < grafanaDeleteUserPage.getListOfAllUserNames().size(); i++) {
            if (grafanaDeleteUserPage.getListOfAllUserNames().get(i).getText().equals(userName))
                UiAction.click(grafanaDeleteUserPage.getListOfAllDeleteUsersBtn().get(i));
        }
    }

    @Step("Search user by user to delete")
    private static void deleteAllListOfUsers() {
        for (int i = grafanaDeleteUserPage.getListOfAllUserNames().size() - 1; i >= 0; i--) {
            if (!grafanaDeleteUserPage.getListOfAllUserNames().get(i).getText().equals("admin")) {
                userToDelete(grafanaDeleteUserPage.getListOfAllUserNames().get(i).getText());
                approveDelete();
            }
        }
    }

    @Step("Approve delete user")
    private static void approveDelete() {
        UiAction.click(grafanaDeleteUserPage.getApproveDeleteBtn());
    }

    @Step("Verify user deleted")
    public static boolean verifyUserDeleted(String userName) {
        navigateToDeleteUsrPage();
        UiAction.sendKeys(grafanaDeleteUserPage.getSearch(), userName);
        if (grafanaDeleteUserPage.getListOfAllUserNames().size() > 0) {
            for (WebElement user :
                    grafanaDeleteUserPage.getListOfAllUserNames()) {
                if (user.getText().equals(userName))
                    return false;
            }
        }
        return true;
    }

    @Step("Verify all user deleted (exclude admin)")
    private static boolean verifyAllUserDeleted() {
        for (WebElement a :
                grafanaDeleteUserPage.getListOfAllUserNames()) {
        }
        return grafanaDeleteUserPage.getListOfAllUserNames().size() > 1;
    }
}
