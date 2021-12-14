package WorkFlows.AppiumWorkFlows;

import Extension.AppiumAction;
import Extension.UiAction;
import Utilities.CommonOps;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;

import java.time.Duration;

public class AppiumSaveCalc extends CommonOps {


    @Step("WorkFlow: get saved result")
    public static String getSaveResult() {
        saveResult();
        swipeScreenLeft();
        return verifyResultSave();
    }

    @Step("Click Save btn")
    public static void saveResult() {
        UiAction.click(mortgageCalcPage.getSaveResultBtn());

    }

    @Step("Swipe screen from the right to the left")
    public static void swipeScreenLeft() {
        pointOptionStart = PointOption.point(dims.width - dims.width / 4, dims.height / 2);
        pointOptionEnd = PointOption.point(10, dims.height / 2);
        touchAction.press(pointOptionStart)
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
                .moveTo(pointOptionEnd)
                .release().perform();
    }

    @Step("Verify result Save")
    public static String verifyResultSave() {
        return AppiumAction.cleanString(mortgageCalcSavePage.getGbpResult().getText()) + " " +
                AppiumAction.cleanString(mortgageCalcPage.getPaymentResult().getText()) + " " +
                AppiumAction.cleanString(mortgageCalcPage.getInterestResult().getText());
    }
}
