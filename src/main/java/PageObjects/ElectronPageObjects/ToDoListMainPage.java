package PageObjects.ElectronPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ToDoListMainPage {

    @FindBy(xpath = "//div[@class='icons_MDNeU']/*[name()='svg'][1]")
    private WebElement colorPicker;
    @FindBy(xpath = "//input[@class='vc-input__input'][1]")
    private WebElement colorPicker_text;
    @FindBy(tagName = "header")
    private WebElement verifyHeaderColor;
    @FindBy(xpath = "//input[@placeholder='Create a task']")
    private WebElement taskField;
    @FindBy(xpath = "//div[@class='view_2Ow90']/*[name()='svg']")
    private List<WebElement> deleteTask;
    @FindBy(xpath = "//div[@class='textWrapper_X9gil']/label")
    private List<WebElement> taskText;
    @FindBy(xpath = "//div[@class='topWrapper_2caNE']/*[name()='svg']")
    private WebElement openColorsList;
    @FindBy(xpath = "//div[@class='view_2Ow90']/span")
    private List<WebElement> listOfCreatedTask;

    @FindBy(xpath = "//div[@class='wrapper_3Kpfj vertical_di1oV tagList_2NRe0']/span")
    private List<WebElement> taskColorsList;


    public List<WebElement> getListOfCreatedTask() {
        return listOfCreatedTask;
    }

    public List<WebElement> getTaskColorsList() {
        return taskColorsList;
    }

    public WebElement getColorPicker() {
        return colorPicker;
    }

    public WebElement getColorPicker_text() {
        return colorPicker_text;
    }

    public WebElement getVerifyHeaderColor() {
        return verifyHeaderColor;
    }

    public WebElement getTaskField() {
        return taskField;
    }

    public List<WebElement> getDeleteTask() {
        return deleteTask;
    }

    public List<WebElement> getTaskText() {
        return taskText;
    }

    public WebElement getOpenColorsList() {
        return openColorsList;
    }

}
