package Extension;

import io.qameta.allure.Step;

public class ElectronAction {


    @Step
    public static int colorToNum(String color) {
        switch (color) {
            case "red":
                return 1;
            case "orange":
                return 2;
            case "yellow":
                return 3;
            case "green":
                return 4;
            case "blue":
                return 5;
            case "purple":
                return 6;
            case "gray":
                return 7;
            default:
                return 0;
        }
    }
}
