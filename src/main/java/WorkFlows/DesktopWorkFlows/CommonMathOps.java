package WorkFlows.DesktopWorkFlows;

import Extension.UiAction;
import Utilities.CommonOps;
import io.qameta.allure.Step;

public class CommonMathOps extends CommonOps {

    @Step("Check operator")
    static void operatorSelector(String mathAct) {
        switch (mathAct) {
            case "+":
                UiAction.click(calculatorRegularPage.getPlusButton());
                break;

            case "-":
                UiAction.click(calculatorRegularPage.getMinusButton());
                break;

            case "/":
                UiAction.click(calculatorRegularPage.getDivideButton());
                break;

            case "*":
                UiAction.click(calculatorRegularPage.getMultiplyButton());
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + mathAct);
        }
    }

    @Step("Split and check number")
    static void splitNumber(String number) {

        for (int i = 0; i < number.length(); i++) {
            switch (number.charAt(i)) {
                case '0':
                    UiAction.click(calculatorRegularPage.getZero());
                    break;
                case '1':
                    UiAction.click(calculatorRegularPage.getOne());
                    break;
                case '2':
                    UiAction.click(calculatorRegularPage.getTwo());
                    break;
                case '3':
                    UiAction.click(calculatorRegularPage.getThree());
                    break;
                case '4':
                    UiAction.click(calculatorRegularPage.getFour());
                    break;
                case '5':
                    UiAction.click(calculatorRegularPage.getFive());
                    break;
                case '6':
                    UiAction.click(calculatorRegularPage.getSix());
                    break;
                case '7':
                    UiAction.click(calculatorRegularPage.getSeven());
                    break;
                case '8':
                    UiAction.click(calculatorRegularPage.getEight());
                    break;
                case '9':
                    UiAction.click(calculatorRegularPage.getNine());
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + number);
            }
        }
    }

}
