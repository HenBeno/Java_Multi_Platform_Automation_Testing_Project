package WorkFlows.ElectronWorkFlows;

import Utilities.CommonOps;
import io.qameta.allure.Step;

public class ElectronDeleteTask extends CommonOps {

    @Step("WorkFlows: Start delete task")
    public static String deleteAllTask() {
        findAndDeleteTask();
        return String.valueOf(VerifyAllTaskDeleted());
    }

    @Step("WorkFlows: Start delete task by name")
    public static boolean deleteTaskByName(String taskName) {
        findAndDeleteTaskByName(taskName);
        return verifyTaskDeleted(taskName);
    }

    @Step("Find and delete task")
    private static void findAndDeleteTask() {
        for (int i = (toDoListMainPage.getDeleteTask().size() - 1); i >= 0; i--) {
            toDoListMainPage.getDeleteTask().get(i).click();
        }
    }

    @Step("Find and delete task by name")
    private static void findAndDeleteTaskByName(String taskName) {
        for (int i = (toDoListMainPage.getTaskText().size() - 1); i >= 0; i--) {
            if (toDoListMainPage.getTaskText().get(i).getText().equals(taskName))
                toDoListMainPage.getDeleteTask().get(i).click();
        }
    }

    @Step("Verify task deleted")
    private static boolean verifyTaskDeleted(String taskName) {
        for (int i = (toDoListMainPage.getTaskText().size() - 1); i >= 0; i--) {
            if (toDoListMainPage.getTaskText().get(i).getText().equals(taskName))
                return false;
        }
        return true;
    }

    @Step("Verify all task deleted")
    private static int VerifyAllTaskDeleted() {
        return toDoListMainPage.getTaskText().size();
    }
}
