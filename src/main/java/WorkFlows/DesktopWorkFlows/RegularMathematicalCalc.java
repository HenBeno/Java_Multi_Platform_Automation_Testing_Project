package WorkFlows.DesktopWorkFlows;

import Extension.UiAction;
import Utilities.CommonOps;
import io.qameta.allure.Step;

import static WorkFlows.DesktopWorkFlows.CommonMathOps.operatorSelector;
import static WorkFlows.DesktopWorkFlows.CommonMathOps.splitNumber;

public class RegularMathematicalCalc extends CommonOps {

    @Step("WorkFlow: Calc from string input")
    public static String CalcString(String myCalc) throws Exception {
        splitString(myCalc);
        splitMyNumber(CalcNumber[0]);
        chooseMathAct(CalcNumber[1]);
        splitMyNumber(CalcNumber[2]);
        return getResult();
    }

    @Step("Convert full string into numbers and operator")
    private static void splitString(String myCalc) throws Exception {
        CalcNumber = myCalc.split(" ");
        if (CalcNumber.length != 3)
            throw new Exception("Calc not include 2 numbers");
    }

    @Step("Convert string operator into clicks")
    private static void chooseMathAct(String mathAct) {
        operatorSelector(mathAct);
    }

    @Step("Convert string number into clicks")
    private static void splitMyNumber(String number) {
        splitNumber(number);
    }

    @Step("Get calc result")
    private static String getResult() {
        UiAction.click(calculatorRegularPage.getEqualButton());
        return calculatorRegularPage.getCalculatorResults().getText().replaceAll("[א-תa-zA-Z' ']", "");
    }
}
