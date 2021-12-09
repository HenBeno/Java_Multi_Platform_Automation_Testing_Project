package PageObjects.DesktopPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalculatorScientificPage {

    @FindBy(xpath = "//*[@AutomationId='logBase10Button']")
    private WebElement logBtn;

    public WebElement getLogBtn() {
        return logBtn;
    }
}
