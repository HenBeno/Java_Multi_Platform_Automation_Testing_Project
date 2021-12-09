package PageObjects.AppiumPageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MortgageCalcSavePage {

    private AndroidDriver<AndroidElement> driver;
    @AndroidFindBy(xpath = "//*[@id='btnDel']")
    private WebElement deleteBtn;
    @AndroidFindBy(xpath = "//*[@id='tvAmount']")
    private WebElement gbpResult;

    public MortgageCalcSavePage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public WebElement getDeleteBtn() {
        return deleteBtn;
    }

    public WebElement getGbpResult() {
        return gbpResult;
    }

}
