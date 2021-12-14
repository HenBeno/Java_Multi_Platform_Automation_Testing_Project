package WorkFlows.AppiumWorkFlows;

import Extension.AppiumAction;
import Extension.UiAction;
import Utilities.CommonOps;
import io.qameta.allure.Step;

public class AppiumCreateNewCalc extends CommonOps {

    @Step("WorkFlow: get full repayment result")
    public static String getRepaymentResult(String gbp, String years, String percent) {
        insertDetails(gbp, years, percent);
        calculate();
        return AppiumAction.cleanString(paymentResult());
    }

    @Step("WorkFlow: get full interest result")
    public static String getInterestResult(String gbp, String years, String rate) {
        insertDetails(gbp, years, rate);
        calculate();
        return AppiumAction.cleanString(interestResult());
    }

    @Step("insert details")
    public static void insertDetails(String gbp, String years, String percent) {
        UiAction.sendKeys(mortgageCalcPage.getGpbFiled(), gbp);
        UiAction.sendKeys(mortgageCalcPage.getYears(), years);
        UiAction.sendKeys(mortgageCalcPage.getRate(), percent);
    }

    @Step("click on calculate button")
    public static void calculate() {
        UiAction.click(mortgageCalcPage.getCalculateBTN());
    }

    @Step("get payment result")
    public static String paymentResult() {
        return mortgageCalcPage.getPaymentResult().getText();
    }


    @Step("get interest result")
    public static String interestResult() {
        return mortgageCalcPage.getInterestResult().getText();
    }
}
