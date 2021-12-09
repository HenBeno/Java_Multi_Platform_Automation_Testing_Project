import Utilities.AutoListeners;
import Utilities.CommonOps;
import Utilities.ExternalFilesManager;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static WorkFlows.AppiumWorkFlows.AppiumCreateNewCalc.getInterestResult;
import static WorkFlows.AppiumWorkFlows.AppiumCreateNewCalc.getRepaymentResult;
import static WorkFlows.AppiumWorkFlows.AppiumSaveCalc.getSaveResult;

public class MortgageCalcAppiumTests extends CommonOps {

    @Test(description = "Verify repayment result")
    public void test01() {
        Assert.assertEquals(getRepaymentResult("100000", "10", "15"),
                ExternalFilesManager.getData("ExpectedRepayment"));
    }

    @Test(description = "Verify interest result")
    public void test02() {
        Assert.assertEquals(getInterestResult("500000", "20", "25"),
                ExternalFilesManager.getData("ExpectedInterest"));
    }

    @Test(description = "Verify result saving")
    public void test03() {
        getInterestResult("500000", "20", "25");
        Assert.assertEquals(getInterestResult("500000", "20", "25"),
                ExternalFilesManager.getData("ExpectedInterest"));
    }

    @Test(description = "Verify result saving")
    public void test04() {
        getInterestResult("500000", "20", "25");
        Assert.assertEquals(getSaveResult(), "500000.0 10538.16 10416.67");
    }

}

