package Extension;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class AppiumAction {

    @Step("Clean String from currency mark")
    public static String cleanString(String result) {
        return result.replaceAll("[£]", "");
    }

    @Step("Appium click")
    public static void click(WebElement elem) {
        elem.click();
    }

    @Step("Appium sendKey")
    public static void sendKey(WebElement elem, String value) {
        elem.clear();
        elem.sendKeys(value);
    }
}
