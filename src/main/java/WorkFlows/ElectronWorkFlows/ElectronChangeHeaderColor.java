package WorkFlows.ElectronWorkFlows;

import Extension.UiAction;
import Utilities.CommonOps;
import io.qameta.allure.Step;

public class ElectronChangeHeaderColor extends CommonOps {

    @Step("WorkFlows: change header color")
    public static String changeHeaderColor(String hexColor) {
        pickChangeColorBtn();
        insertHexColor(hexColor);
        return verifyColor();
    }

    @Step("Click color picker")
    private static void pickChangeColorBtn() {
        UiAction.click(toDoListMainPage.getColorPicker());
    }

    @Step("Pick a color")
    private static void insertHexColor(String hexColor) {
        UiAction.sendKeys(toDoListMainPage.getColorPicker_text(), hexColor);
    }

    @Step("Verify header color change")
    private static String verifyColor() {
        return toDoListMainPage.getVerifyHeaderColor().getAttribute("style");
    }
}
