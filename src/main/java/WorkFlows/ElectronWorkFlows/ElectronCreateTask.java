package WorkFlows.ElectronWorkFlows;

import Extension.ElectronAction;
import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class ElectronCreateTask extends CommonOps {

    @Step("WorkFlows: Start create task")
    public static boolean createTask(String taskName, String color) {
        pickColor(color);
        createTaskByName(taskName);
        insertTask();
        return verifyCreate(taskName);
    }

    @Step("Create task - Choose task color")
    private static void pickColor(String color) {
        toDoListMainPage.getOpenColorsList().click();
        toDoListMainPage.getTaskColorsList().get(ElectronAction.colorToNum(color.toLowerCase())).click();
    }

    @Step("Create task - Insert task info")
    private static void createTaskByName(String taskName) {
        toDoListMainPage.getTaskField().sendKeys(taskName);
    }

    @Step("Create task - Send Enter key to insert the task")
    private static void insertTask() {
        toDoListMainPage.getTaskField().click();
        actions.sendKeys(Keys.ENTER).build().perform();
    }

    @Step("Verify task created")
    private static boolean verifyCreate(String taskName) {

        for (WebElement name : toDoListMainPage.getTaskText()) {
            if (name.getText().equals(taskName))
                return true;
        }
        return false;
    }
}
