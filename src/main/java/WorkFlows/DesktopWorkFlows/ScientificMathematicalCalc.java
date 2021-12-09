package WorkFlows.DesktopWorkFlows;

import Extension.UiAction;
import Utilities.CommonOps;
import io.qameta.allure.Step;

public class ScientificMathematicalCalc extends CommonOps {

    @Step("Change calc to scientific mod and Verify")
    public static boolean changeToScientificMod() {
        UiAction.click(calculatorRegularPage.getTogglePaneButton());
        UiAction.click(calculatorRegularPage.getChangeToScientificModeBtn());
        return calculatorScientificPage.getLogBtn().isDisplayed();
    }

}
