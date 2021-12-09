package Extension;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class UiAction {

    @Step("Click Element")
    public static void click(WebElement elem) {
        elem.click();
    }

    @Step("Send keys to Element")
    public static void sendKeys(WebElement elem, String value) {
        elem.clear();
        elem.sendKeys(value);
    }

    @Step("Hover element an click element inside")
    public static void elementHoverAndElementClick(Actions actions, WebElement elem, WebElement elem2) {
        actions.moveToElement(elem).moveToElement(elem2).click().build().perform();
    }

    @Step("Hover element")
    public static void elementHover(Actions actions, WebElement elem) {
        actions.moveToElement(elem).build().perform();
    }

}
