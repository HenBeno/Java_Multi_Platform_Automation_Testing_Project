import Utilities.AutoListeners;
import Utilities.CommonOps;
import Utilities.ExternalFilesManager;
import WorkFlows.ElectronWorkFlows.ElectronChangeHeaderColor;
import WorkFlows.ElectronWorkFlows.ElectronCreateTask;
import WorkFlows.ElectronWorkFlows.ElectronDeleteTask;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class ToDoListElectronTest extends CommonOps {

    @Test(priority = 1, description = "Verify change of color")
    public void VerifyChangeOfColor() {
        Assert.assertEquals(ElectronChangeHeaderColor.changeHeaderColor(ExternalFilesManager.getData("HexColor")),
                ExternalFilesManager.getData("ExpectedHexColor"));
    }

    @Test(priority = 2, description = "Verify task created")
    public void test02_createNewTask() {

        for (int i = 0; i < 3; i++) {
            softAssert.assertTrue(ElectronCreateTask.createTask("Task" + i, "red"));
        }
        softAssert.assertAll("Test2 fail");
    }

    @Test(priority = 3, description = "Verify all task deleted")
    public void test02_delAllTask() {
        ElectronCreateTask.createTask("TempTask", "blue");
        Assert.assertEquals(ElectronDeleteTask.deleteAllTask(), ExternalFilesManager.getData("ExpectedDeleteTask"));
    }

    @Test(priority = 4, description = "Verify task deleted by name")
    public void test02_delTaskByName() {
        ElectronCreateTask.createTask("TempTask3", "blue");
        Assert.assertTrue(ElectronDeleteTask.deleteTaskByName("TempTask3"));
    }
}
