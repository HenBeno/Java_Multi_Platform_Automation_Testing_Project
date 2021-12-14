package Extension;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class AppiumAction {

    @Step("Clean String from currency mark")
    public static String cleanString(String result) {
        return result.replaceAll("[£]", "");
    }

}
