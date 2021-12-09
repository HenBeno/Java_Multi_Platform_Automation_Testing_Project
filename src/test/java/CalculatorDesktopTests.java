import Utilities.AutoListeners;
import Utilities.CommonOps;
import Utilities.ExternalFilesManager;
import WorkFlows.DesktopWorkFlows.RegularMathematicalCalc;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static WorkFlows.DesktopWorkFlows.ScientificMathematicalCalc.changeToScientificMod;

public class CalculatorDesktopTests extends CommonOps {

    @Test(description = "Verify calc result")
    public void test1_VerifyCalcResult() throws Exception {
        Assert.assertEquals(RegularMathematicalCalc.CalcString("120 * 3"), ExternalFilesManager.getData("ExpectedVerifyCalcResult"));
    }

    @Test(description = "Verify in Scientific mode")
    public void test2_VerifyCalcResult() throws Exception {
        Assert.assertTrue(changeToScientificMod(), "Calc is not in Scientific mode");
    }

}
